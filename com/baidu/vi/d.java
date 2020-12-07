package com.baidu.vi;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
/* loaded from: classes26.dex */
class d implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VCompass f3909a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VCompass vCompass) {
        this.f3909a = vCompass;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float a2;
        switch (sensorEvent.sensor.getType()) {
            case 3:
                a2 = this.f3909a.a(sensorEvent.values[0]);
                this.f3909a.updateCompass((int) a2);
                return;
            default:
                return;
        }
    }
}
