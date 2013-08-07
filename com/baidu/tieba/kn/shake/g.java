package com.baidu.tieba.kn.shake;

import android.hardware.SensorEvent;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final float f1251a = (float) ((2.0d * Math.sqrt(3.0d)) * 9.806650161743164d);
    private boolean b = true;
    private float c = 0.0f;
    private float d = 0.0f;
    private long e = 0;
    private int f = 0;
    private float g = 0.0f;
    private float h = 0.0f;
    private l i = null;
    private boolean j = false;
    private boolean k = true;
    private int l = 0;
    private h m = null;
    private float[] n = new float[3];

    public void a(h hVar) {
        this.m = hVar;
    }

    private void a(l lVar) {
        if (this.k) {
            this.n[0] = lVar.f1255a;
            this.n[1] = lVar.b;
            this.n[2] = lVar.c;
        }
        this.n[0] = (this.n[0] * 0.8f) + (lVar.f1255a * 0.19999999f);
        this.n[1] = (this.n[1] * 0.8f) + (lVar.b * 0.19999999f);
        this.n[2] = (this.n[2] * 0.8f) + (lVar.c * 0.19999999f);
        lVar.f1255a -= this.n[0];
        lVar.b -= this.n[1];
        lVar.c -= this.n[2];
        this.k = false;
    }

    public void a(SensorEvent sensorEvent) {
        l lVar = new l(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
        if (this.b) {
            a(lVar);
        }
        long j = sensorEvent.timestamp / 1000000;
        long j2 = this.e > 0 ? j - this.e : 0L;
        this.e = j;
        float a2 = lVar.a();
        float f = a2 - this.c;
        float f2 = a2 > f1251a ? f1251a : a2;
        if (a2 > 0.5d) {
            this.g = ((((float) j2) * f2) / 1000.0f) + this.g;
        }
        if (a2 > 9.0f) {
            if (Math.abs(this.d) > 0.01f && f < 0.0f && this.d * f < 0.0f) {
                if (this.i != null && this.i.b(lVar) > 1.5707963267948966d) {
                    this.h = this.g;
                    if (this.h > 1.96133f) {
                        this.f++;
                        this.g = 0.0f;
                        this.j = true;
                    } else {
                        if (this.j && this.h > 0.6537767f) {
                            this.f++;
                            this.g = 0.0f;
                        }
                        this.j = false;
                    }
                    this.i = lVar;
                }
                if (this.i == null) {
                    this.i = lVar;
                }
            }
            if (Math.abs(f) > 0.01f) {
                this.d = f;
            }
        }
        this.c = a2;
        if (this.f > this.l) {
            this.l = this.f;
            if (this.m != null) {
                this.m.a(this.l, this.c);
            }
        }
    }
}
