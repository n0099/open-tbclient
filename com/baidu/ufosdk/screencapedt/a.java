package com.baidu.ufosdk.screencapedt;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public float f22614a;

    /* renamed from: b  reason: collision with root package name */
    public float f22615b;

    /* renamed from: c  reason: collision with root package name */
    public float f22616c;

    /* renamed from: d  reason: collision with root package name */
    public float f22617d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22618e;

    /* renamed from: f  reason: collision with root package name */
    public int f22619f;

    /* renamed from: g  reason: collision with root package name */
    public int f22620g;

    /* renamed from: h  reason: collision with root package name */
    public String f22621h;

    public a() {
        this.f22619f = 0;
        this.f22620g = 2;
        this.f22621h = null;
    }

    public a(float f2, float f3, float f4, float f5, String str) {
        this.f22619f = 0;
        this.f22620g = 2;
        this.f22621h = null;
        this.f22614a = f2;
        this.f22615b = f3;
        this.f22616c = f4;
        this.f22617d = f5;
        this.f22618e = true;
        this.f22621h = str;
    }

    public final int a(float f2, float f3, int i2, int i3) {
        if (!a(f2, i2, f3, i3)) {
            this.f22618e = false;
            return -1;
        }
        this.f22618e = true;
        float f4 = this.f22614a;
        int i4 = this.f22620g;
        float f5 = f4 - (i2 * i4);
        float f6 = this.f22615b;
        float f7 = f6 - (i3 * i4);
        float f8 = f6 + (i4 * i3);
        if ((f5 - f2) * ((f4 + (i2 * i4)) - f2) >= 0.0f || (f7 - f3) * (f8 - f3) >= 0.0f) {
            float f9 = this.f22614a;
            int i5 = this.f22620g;
            float f10 = f9 - (i2 * i5);
            float f11 = this.f22615b;
            float f12 = this.f22617d;
            float f13 = ((f11 + f12) / 2.0f) - (i3 * i5);
            float f14 = ((f11 + f12) / 2.0f) + (i5 * i3);
            if ((f10 - f2) * ((f9 + (i2 * i5)) - f2) >= 0.0f || (f13 - f3) * (f14 - f3) >= 0.0f) {
                float f15 = this.f22614a;
                int i6 = this.f22620g;
                float f16 = f15 - (i2 * i6);
                float f17 = this.f22617d;
                float f18 = f17 - (i3 * i6);
                float f19 = f17 + (i6 * i3);
                if ((f16 - f2) * ((f15 + (i2 * i6)) - f2) >= 0.0f || (f18 - f3) * (f19 - f3) >= 0.0f) {
                    float f20 = this.f22614a;
                    float f21 = this.f22616c;
                    int i7 = this.f22620g;
                    float f22 = ((f20 + f21) / 2.0f) - (i2 * i7);
                    float f23 = this.f22615b;
                    float f24 = f23 - (i3 * i7);
                    float f25 = f23 + (i7 * i3);
                    if ((f22 - f2) * ((((f20 + f21) / 2.0f) + (i2 * i7)) - f2) >= 0.0f || (f24 - f3) * (f25 - f3) >= 0.0f) {
                        float f26 = this.f22614a;
                        float f27 = this.f22616c;
                        int i8 = this.f22620g;
                        float f28 = ((f26 + f27) / 2.0f) - (i2 * i8);
                        float f29 = this.f22617d;
                        float f30 = f29 - (i3 * i8);
                        float f31 = f29 + (i8 * i3);
                        if ((f28 - f2) * ((((f26 + f27) / 2.0f) + (i2 * i8)) - f2) >= 0.0f || (f30 - f3) * (f31 - f3) >= 0.0f) {
                            float f32 = this.f22616c;
                            int i9 = this.f22620g;
                            float f33 = f32 - (i2 * i9);
                            float f34 = this.f22615b;
                            float f35 = this.f22617d;
                            float f36 = ((f34 + f35) / 2.0f) - (i3 * i9);
                            float f37 = ((f34 + f35) / 2.0f) + (i9 * i3);
                            if ((f33 - f2) * ((f32 + (i2 * i9)) - f2) >= 0.0f || (f36 - f3) * (f37 - f3) >= 0.0f) {
                                float f38 = this.f22616c;
                                int i10 = this.f22620g;
                                float f39 = f38 - (i2 * i10);
                                float f40 = this.f22617d;
                                float f41 = f40 - (i3 * i10);
                                float f42 = f40 + (i10 * i3);
                                if ((f39 - f2) * ((f38 + (i2 * i10)) - f2) >= 0.0f || (f41 - f3) * (f42 - f3) >= 0.0f) {
                                    float f43 = this.f22616c;
                                    int i11 = this.f22620g;
                                    float f44 = f43 - (i11 * i2);
                                    float f45 = this.f22615b;
                                    return ((f44 - f2) * ((f43 + ((float) (i2 * i11))) - f2) >= 0.0f || ((f45 - ((float) (i11 * i3))) - f3) * ((f45 + ((float) (i11 * i3))) - f3) >= 0.0f) ? 0 : 23;
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
        return this.f22621h;
    }

    public final void a(float f2) {
        this.f22614a = f2;
    }

    public final void a(int i2) {
        this.f22619f = i2;
    }

    public final void a(boolean z) {
        this.f22618e = z;
    }

    public final boolean a(float f2, int i2, float f3, int i3) {
        float f4 = i2;
        if (((this.f22614a - f4) - f2) * ((this.f22616c + f4) - f2) < 0.0f) {
            float f5 = i3;
            return ((this.f22615b - f5) - f3) * ((this.f22617d + f5) - f3) < 0.0f;
        }
        return false;
    }

    public final float b() {
        return this.f22614a;
    }

    public final void b(float f2) {
        this.f22615b = f2;
    }

    public final float c() {
        return this.f22615b;
    }

    public final void c(float f2) {
        this.f22616c = f2;
    }

    public final float d() {
        return this.f22616c;
    }

    public final void d(float f2) {
        this.f22617d = f2;
    }

    public final float e() {
        return this.f22617d;
    }

    public final boolean f() {
        return this.f22618e;
    }

    public final int g() {
        return this.f22619f;
    }
}
