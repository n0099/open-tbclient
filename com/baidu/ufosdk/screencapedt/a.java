package com.baidu.ufosdk.screencapedt;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private float f5395a;

    /* renamed from: b  reason: collision with root package name */
    private float f5396b;
    private float c;
    private float d;
    private boolean e;
    private int f;
    private int g;
    private String h;

    public a() {
        this.f = 0;
        this.g = 2;
        this.h = null;
    }

    public a(float f, float f2, float f3, float f4, String str) {
        this.f = 0;
        this.g = 2;
        this.h = null;
        this.f5395a = f;
        this.f5396b = f2;
        this.c = f3;
        this.d = f4;
        this.e = true;
        this.h = str;
    }

    public final int a(float f, float f2, int i, int i2) {
        if (!a(f, i, f2, i2)) {
            this.e = false;
            return -1;
        }
        this.e = true;
        float f3 = this.f5395a - (this.g * i);
        float f4 = this.f5396b - (this.g * i2);
        float f5 = this.f5395a + (this.g * i);
        float f6 = this.f5396b + (this.g * i2);
        if ((f3 - f) * (f5 - f) >= 0.0f || (f4 - f2) * (f6 - f2) >= 0.0f) {
            float f7 = this.f5395a - (this.g * i);
            float f8 = ((this.f5396b + this.d) / 2.0f) - (this.g * i2);
            float f9 = this.f5395a + (this.g * i);
            float f10 = ((this.f5396b + this.d) / 2.0f) + (this.g * i2);
            if ((f7 - f) * (f9 - f) >= 0.0f || (f8 - f2) * (f10 - f2) >= 0.0f) {
                float f11 = this.f5395a - (this.g * i);
                float f12 = this.d - (this.g * i2);
                float f13 = this.f5395a + (this.g * i);
                float f14 = this.d + (this.g * i2);
                if ((f11 - f) * (f13 - f) >= 0.0f || (f12 - f2) * (f14 - f2) >= 0.0f) {
                    float f15 = ((this.f5395a + this.c) / 2.0f) - (this.g * i);
                    float f16 = this.f5396b - (this.g * i2);
                    float f17 = ((this.f5395a + this.c) / 2.0f) + (this.g * i);
                    float f18 = this.f5396b + (this.g * i2);
                    if ((f15 - f) * (f17 - f) >= 0.0f || (f16 - f2) * (f18 - f2) >= 0.0f) {
                        float f19 = ((this.f5395a + this.c) / 2.0f) - (this.g * i);
                        float f20 = this.d - (this.g * i2);
                        float f21 = ((this.f5395a + this.c) / 2.0f) + (this.g * i);
                        float f22 = this.d + (this.g * i2);
                        if ((f19 - f) * (f21 - f) >= 0.0f || (f20 - f2) * (f22 - f2) >= 0.0f) {
                            float f23 = this.c - (this.g * i);
                            float f24 = ((this.f5396b + this.d) / 2.0f) - (this.g * i2);
                            float f25 = this.c + (this.g * i);
                            float f26 = ((this.f5396b + this.d) / 2.0f) + (this.g * i2);
                            if ((f23 - f) * (f25 - f) >= 0.0f || (f24 - f2) * (f26 - f2) >= 0.0f) {
                                float f27 = this.c - (this.g * i);
                                float f28 = this.d - (this.g * i2);
                                float f29 = this.c + (this.g * i);
                                float f30 = this.d + (this.g * i2);
                                if ((f27 - f) * (f29 - f) >= 0.0f || (f28 - f2) * (f30 - f2) >= 0.0f) {
                                    return (((this.c - ((float) (this.g * i))) - f) * ((this.c + ((float) (this.g * i))) - f) >= 0.0f || ((this.f5396b - ((float) (this.g * i2))) - f2) * ((this.f5396b + ((float) (this.g * i2))) - f2) >= 0.0f) ? 0 : 23;
                                }
                                return 24;
                            }
                            return 2;
                        }
                        return 4;
                    }
                    return 3;
                }
                return 14;
            }
            return 1;
        }
        return 13;
    }

    public final String a() {
        return this.h;
    }

    public final void a(float f) {
        this.f5395a = f;
    }

    public final void a(int i) {
        this.f = i;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final boolean a(float f, int i, float f2, int i2) {
        return ((this.f5395a - ((float) i)) - f) * ((this.c + ((float) i)) - f) < 0.0f && ((this.f5396b - ((float) i2)) - f2) * ((this.d + ((float) i2)) - f2) < 0.0f;
    }

    public final float b() {
        return this.f5395a;
    }

    public final void b(float f) {
        this.f5396b = f;
    }

    public final float c() {
        return this.f5396b;
    }

    public final void c(float f) {
        this.c = f;
    }

    public final float d() {
        return this.c;
    }

    public final void d(float f) {
        this.d = f;
    }

    public final float e() {
        return this.d;
    }

    public final boolean f() {
        return this.e;
    }

    public final int g() {
        return this.f;
    }
}
