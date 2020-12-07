package com.baidu.tieba.play;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Handler;
import android.os.Message;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g implements SensorEventListener {
    private WeakReference<Handler> bGj;

    public g(Handler handler) {
        this.bGj = new WeakReference<>(handler);
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
                int i = round < 0 ? round + EncoderTextureDrawer.X264_WIDTH : round;
                if (this.bGj != null && this.bGj.get() != null && (obtainMessage = (handler = this.bGj.get()).obtainMessage(1)) != null) {
                    obtainMessage.arg1 = i;
                    handler.sendMessage(obtainMessage);
                }
            }
        }
    }
}
