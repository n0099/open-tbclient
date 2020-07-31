package com.baidu.tieba.play;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g implements SensorEventListener {
    private WeakReference<Handler> bib;

    public g(Handler handler) {
        this.bib = new WeakReference<>(handler);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Handler handler;
        Message obtainMessage;
        if (sensorEvent != null && sensorEvent.values != null && sensorEvent.values.length >= 3) {
            float[] fArr = sensorEvent.values;
            float f = -fArr[0];
            float f2 = -fArr[1];
            float f3 = -fArr[2];
            if ((f * f) + (f2 * f2) >= f3 * f3) {
                int round = 90 - Math.round(((float) Math.atan2(-f2, f)) * 57.29578f);
                if (round >= 360) {
                    round -= 360;
                }
                int i = round < 0 ? round + 360 : round;
                if (this.bib != null && this.bib.get() != null && (obtainMessage = (handler = this.bib.get()).obtainMessage(1)) != null) {
                    obtainMessage.arg1 = i;
                    handler.sendMessage(obtainMessage);
                }
            }
        }
    }
}
