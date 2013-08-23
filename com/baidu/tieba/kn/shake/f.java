package com.baidu.tieba.kn.shake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeActivity f1283a;
    private Context c;
    private Sensor e;
    private SensorManager b = null;
    private int d = 1;

    public f(ShakeActivity shakeActivity, Context context) {
        this.f1283a = shakeActivity;
        this.c = null;
        this.c = context;
    }

    public void a() {
        if (this.b != null) {
            this.b.unregisterListener(this);
        }
    }

    public boolean b() {
        this.b = (SensorManager) this.c.getSystemService("sensor");
        if (this.b != null) {
            this.e = this.b.getDefaultSensor(this.d);
        }
        if (this.e != null) {
            return this.b.registerListener(this, this.e, 0);
        }
        return false;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        g gVar;
        if (sensorEvent.sensor.getType() == this.d) {
            gVar = this.f1283a.d;
            gVar.a(sensorEvent);
        }
    }
}
