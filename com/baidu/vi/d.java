package com.baidu.vi;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
/* loaded from: classes3.dex */
class d implements SensorEventListener {
    final /* synthetic */ VCompass a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VCompass vCompass) {
        this.a = vCompass;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float a;
        switch (sensorEvent.sensor.getType()) {
            case 3:
                a = this.a.a(sensorEvent.values[0]);
                this.a.updateCompass((int) a);
                return;
            default:
                return;
        }
    }
}
