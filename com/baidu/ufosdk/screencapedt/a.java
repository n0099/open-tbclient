package com.baidu.ufosdk.screencapedt;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public float f22657a;

    /* renamed from: b  reason: collision with root package name */
    public float f22658b;

    /* renamed from: c  reason: collision with root package name */
    public float f22659c;

    /* renamed from: d  reason: collision with root package name */
    public float f22660d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22661e;

    /* renamed from: f  reason: collision with root package name */
    public int f22662f;

    /* renamed from: g  reason: collision with root package name */
    public int f22663g;

    /* renamed from: h  reason: collision with root package name */
    public String f22664h;

    public a() {
        this.f22662f = 0;
        this.f22663g = 2;
        this.f22664h = null;
    }

    public a(float f2, float f3, float f4, float f5, String str) {
        this.f22662f = 0;
        this.f22663g = 2;
        this.f22664h = null;
        this.f22657a = f2;
        this.f22658b = f3;
        this.f22659c = f4;
        this.f22660d = f5;
        this.f22661e = true;
        this.f22664h = str;
    }

    public final int a(float f2, float f3, int i, int i2) {
        if (!a(f2, i, f3, i2)) {
            this.f22661e = false;
            return -1;
        }
        this.f22661e = true;
        float f4 = this.f22657a;
        int i3 = this.f22663g;
        float f5 = f4 - (i * i3);
        float f6 = this.f22658b;
        float f7 = f6 - (i2 * i3);
        float f8 = f6 + (i3 * i2);
        if ((f5 - f2) * ((f4 + (i * i3)) - f2) >= 0.0f || (f7 - f3) * (f8 - f3) >= 0.0f) {
            float f9 = this.f22657a;
            int i4 = this.f22663g;
            float f10 = f9 - (i * i4);
            float f11 = this.f22658b;
            float f12 = this.f22660d;
            float f13 = ((f11 + f12) / 2.0f) - (i2 * i4);
            float f14 = ((f11 + f12) / 2.0f) + (i4 * i2);
            if ((f10 - f2) * ((f9 + (i * i4)) - f2) >= 0.0f || (f13 - f3) * (f14 - f3) >= 0.0f) {
                float f15 = this.f22657a;
                int i5 = this.f22663g;
                float f16 = f15 - (i * i5);
                float f17 = this.f22660d;
                float f18 = f17 - (i2 * i5);
                float f19 = f17 + (i5 * i2);
                if ((f16 - f2) * ((f15 + (i * i5)) - f2) >= 0.0f || (f18 - f3) * (f19 - f3) >= 0.0f) {
                    float f20 = this.f22657a;
                    float f21 = this.f22659c;
                    int i6 = this.f22663g;
                    float f22 = ((f20 + f21) / 2.0f) - (i * i6);
                    float f23 = this.f22658b;
                    float f24 = f23 - (i2 * i6);
                    float f25 = f23 + (i6 * i2);
                    if ((f22 - f2) * ((((f20 + f21) / 2.0f) + (i * i6)) - f2) >= 0.0f || (f24 - f3) * (f25 - f3) >= 0.0f) {
                        float f26 = this.f22657a;
                        float f27 = this.f22659c;
                        int i7 = this.f22663g;
                        float f28 = ((f26 + f27) / 2.0f) - (i * i7);
                        float f29 = this.f22660d;
                        float f30 = f29 - (i2 * i7);
                        float f31 = f29 + (i7 * i2);
                        if ((f28 - f2) * ((((f26 + f27) / 2.0f) + (i * i7)) - f2) >= 0.0f || (f30 - f3) * (f31 - f3) >= 0.0f) {
                            float f32 = this.f22659c;
                            int i8 = this.f22663g;
                            float f33 = f32 - (i * i8);
                            float f34 = this.f22658b;
                            float f35 = this.f22660d;
                            float f36 = ((f34 + f35) / 2.0f) - (i2 * i8);
                            float f37 = ((f34 + f35) / 2.0f) + (i8 * i2);
                            if ((f33 - f2) * ((f32 + (i * i8)) - f2) >= 0.0f || (f36 - f3) * (f37 - f3) >= 0.0f) {
                                float f38 = this.f22659c;
                                int i9 = this.f22663g;
                                float f39 = f38 - (i * i9);
                                float f40 = this.f22660d;
                                float f41 = f40 - (i2 * i9);
                                float f42 = f40 + (i9 * i2);
                                if ((f39 - f2) * ((f38 + (i * i9)) - f2) >= 0.0f || (f41 - f3) * (f42 - f3) >= 0.0f) {
                                    float f43 = this.f22659c;
                                    int i10 = this.f22663g;
                                    float f44 = f43 - (i10 * i);
                                    float f45 = this.f22658b;
                                    return ((f44 - f2) * ((f43 + ((float) (i * i10))) - f2) >= 0.0f || ((f45 - ((float) (i10 * i2))) - f3) * ((f45 + ((float) (i10 * i2))) - f3) >= 0.0f) ? 0 : 23;
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
        return this.f22664h;
    }

    public final void a(float f2) {
        this.f22657a = f2;
    }

    public final void a(int i) {
        this.f22662f = i;
    }

    public final void a(boolean z) {
        this.f22661e = z;
    }

    public final boolean a(float f2, int i, float f3, int i2) {
        float f4 = i;
        if (((this.f22657a - f4) - f2) * ((this.f22659c + f4) - f2) < 0.0f) {
            float f5 = i2;
            return ((this.f22658b - f5) - f3) * ((this.f22660d + f5) - f3) < 0.0f;
        }
        return false;
    }

    public final float b() {
        return this.f22657a;
    }

    public final void b(float f2) {
        this.f22658b = f2;
    }

    public final float c() {
        return this.f22658b;
    }

    public final void c(float f2) {
        this.f22659c = f2;
    }

    public final float d() {
        return this.f22659c;
    }

    public final void d(float f2) {
        this.f22660d = f2;
    }

    public final float e() {
        return this.f22660d;
    }

    public final boolean f() {
        return this.f22661e;
    }

    public final int g() {
        return this.f22662f;
    }
}
