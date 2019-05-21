package com.example.tiro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class MainActivity extends AppCompatActivity {


    private SeekBar sb1,sb2,sb3,sb4;
    private TextView tv1,tv2,tv3,tv4;
    double vox, voy, aceleracion, ecuacion, dh, hmax;
    LineGraphSeries<DataPoint> series;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb1 = (SeekBar)findViewById(R.id.sb_tiempo);
        sb2 = (SeekBar)findViewById(R.id.sb_velocidad);
        sb3 = (SeekBar)findViewById(R.id.sb_angulo);
        sb4 = (SeekBar)findViewById(R.id.sb_altura);

        tv1 = (TextView) findViewById(R.id.tv_tiempo);
        tv1.setText("3 s");
        tv2 = (TextView) findViewById(R.id.tv_vo);
        tv2.setText("1 m/s");
        tv3 = (TextView) findViewById(R.id.tv_angulo);
        tv3.setText("20°");
        tv4 = (TextView) findViewById(R.id.tv_altura);
        tv4.setText("10 m");

        double x,y;
        x = 0;


        GraphView graph = (GraphView)findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        for (int i =0; i<20;i++){
            x = x + 0.1;
            y = -(Math.pow(x,2)) + 5*x;

            series.appendData(new DataPoint(x, y), true, 500);
        }
        graph.addSeries(series);


        sb1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

           // private Toast toastStart = Toast.makeText(MainActivity.this, getText(R.string.start), Toast.LENGTH_SHORT);
            //private Toast toastStop = Toast.makeText(MainActivity.this, getText(R.string.stop), Toast.LENGTH_SHORT);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //la Seekbar siempre empieza en cero, si queremos que el valor mínimo sea otro podemos modificarlo
                tv1.setText(progress + 3 + " ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        sb2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            // private Toast toastStart = Toast.makeText(MainActivity.this, getText(R.string.start), Toast.LENGTH_SHORT);
            //private Toast toastStop = Toast.makeText(MainActivity.this, getText(R.string.stop), Toast.LENGTH_SHORT);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //la Seekbar siempre empieza en cero, si queremos que el valor mínimo sea otro podemos modificarlo
                tv2.setText(progress + 1 + " ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        sb3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            // private Toast toastStart = Toast.makeText(MainActivity.this, getText(R.string.start), Toast.LENGTH_SHORT);
            //private Toast toastStop = Toast.makeText(MainActivity.this, getText(R.string.stop), Toast.LENGTH_SHORT);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //la Seekbar siempre empieza en cero, si queremos que el valor mínimo sea otro podemos modificarlo
                tv3.setText(progress + 20 + " ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        sb4.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            // private Toast toastStart = Toast.makeText(MainActivity.this, getText(R.string.start), Toast.LENGTH_SHORT);
            //private Toast toastStop = Toast.makeText(MainActivity.this, getText(R.string.stop), Toast.LENGTH_SHORT);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //la Seekbar siempre empieza en cero, si queremos que el valor mínimo sea otro podemos modificarlo
                tv4.setText(progress + 10 + " ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });



    }
    public void generar(View view){
        vox();
        voy();
        aceleracion();
        dh();
    }

    private void vox() {
        String seno = tv3.getText().toString();
        double resultado = Double.parseDouble(seno);
        resultado = Math.cos(resultado);
        String vo =  tv2.getText().toString();
        double vo1 = Double.parseDouble(vo);
        resultado = resultado * vo1;
        vox = resultado;
    }
    private  void voy(){
        String cos = tv3.getText().toString();
        double resultado = Double.parseDouble(cos);
        resultado = Math.cos(resultado);
        String vo =  tv2.getText().toString();
        double vo1 = Double.parseDouble(vo);
        resultado = resultado * vo1;
        voy = resultado;

    }
    private void aceleracion() {
        String vo = tv2.getText().toString();
        double resultado = Double.parseDouble(vo);
        String time = tv1.getText().toString();
        double resultado1 = Double.parseDouble(time);
        aceleracion = resultado / resultado1;
    }
    private  void dh(){
        String time = tv1.getText().toString();
        double resultado1 = Double.parseDouble(time);
        dh = vox * resultado1;
    }


    //private void Seno(View view){
      //  String seno = tv3.getText().toString();
        //double resultado = Double.parseDouble(seno);
        //resultado = Math.sin(resultado);
      //  String resu = String.valueOf(resultado);
        //tv1.setText(resu);
   // }

}
