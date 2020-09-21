package com.baidu.vi;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
/* loaded from: classes3.dex */
public class VCompass {
    private static final Handler e = new c();
    private float b;
    private SensorManager a = null;
    private float c = 2.0f;
    private int d = 0;
    private SensorEventListener f = new d(this);

    /* JADX INFO: Access modifiers changed from: private */
    public float a(float f) {
        this.b = a(this.b, f, this.c);
        return this.b;
    }

    private float a(float f, float f2, float f3) {
        float f4 = f - f2;
        return (f4 > 180.0f || f4 < -180.0f) ? f2 : (f4 < (-f3) || f3 < f4) ? (f + f2) / 2.0f : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void updateCompass(int i);
}
