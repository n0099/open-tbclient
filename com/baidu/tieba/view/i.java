package com.baidu.tieba.view;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Animation {
    final /* synthetic */ f a;
    private boolean b = false;
    private boolean c = false;
    private long d;
    private long e;
    private int f;
    private int g;
    private long h;
    private long i;

    public i(f fVar) {
        this.a = fVar;
    }

    public void a(float f, float f2) {
        Interpolator interpolator;
        if (f > 1500.0f) {
            f = 1500.0f;
        } else if (f < -1500.0f) {
            f = -1500.0f;
        }
        if (f2 > 1500.0f) {
            f2 = 1500.0f;
        } else if (f2 < -1500.0f) {
            f2 = -1500.0f;
        }
        this.d = f;
        this.e = f2;
        this.h = Math.abs((f * 1000.0f) / 2500.0f);
        this.i = Math.abs((f2 * 1000.0f) / 2500.0f);
        setDuration(Math.max(this.h, this.i));
        interpolator = this.a.L;
        setInterpolator(interpolator);
        this.f = this.a.getScrollX();
        this.g = this.a.getScrollY();
        this.b = true;
    }

    public boolean a() {
        return this.b;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2;
        int i;
        int i2;
        float f3;
        float f4;
        int i3;
        float f5;
        int i4;
        float f6;
        int i5;
        int i6;
        float f7;
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        if (f > 1.0f) {
            f = 1.0f;
        }
        long j = this.h > this.i ? ((float) this.h) * f : ((float) this.i) * f;
        float f8 = ((float) (j > this.h ? this.h : j)) / 1000.0f;
        int i11 = this.d > 0 ? this.f - ((int) (f8 * (((float) this.d) - ((2500.0f * f8) / 2.0f)))) : this.f - ((int) (f8 * (((float) this.d) + ((2500.0f * f8) / 2.0f))));
        if (j > this.i) {
            j = this.i;
        }
        float f9 = ((float) j) / 1000.0f;
        int i12 = this.e > 0 ? this.g - ((int) (f9 * (((float) this.e) - ((2500.0f * f9) / 2.0f)))) : this.g - ((int) (f9 * (((float) this.e) + ((2500.0f * f9) / 2.0f))));
        f2 = this.a.f;
        i = this.a.H;
        float f10 = f2 + i;
        i2 = this.a.I;
        if (f10 + i2 > this.a.getHeight()) {
            i4 = this.a.J;
            if (i12 < (-i4)) {
                i9 = this.a.J;
                i12 = -i9;
            }
            f6 = this.a.f;
            i5 = this.a.I;
            float f11 = f6 + i5;
            i6 = this.a.K;
            if (this.a.getHeight() + i12 > f11 + i6) {
                f7 = this.a.f;
                i7 = this.a.I;
                float height = (f7 - this.a.getHeight()) + i7;
                i8 = this.a.K;
                i12 = (int) (height + i8);
            }
        } else {
            i12 = 0;
        }
        f3 = this.a.e;
        if (f3 > this.a.getWidth()) {
            f4 = this.a.e;
            if (this.a.getWidth() + i11 > f4) {
                f5 = this.a.e;
                i3 = (int) (f5 - this.a.getWidth());
            } else {
                i3 = i11;
            }
            if (i3 >= 0) {
                i10 = i3;
            }
        }
        this.a.scrollTo(i10, i12);
        this.a.invalidate();
    }

    public void b() {
        this.c = true;
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        boolean z;
        if (this.c) {
            this.c = false;
            this.b = false;
            return false;
        }
        z = this.a.l;
        if (z) {
            this.b = false;
            return false;
        }
        try {
            if (super.getTransformation(j, transformation)) {
                return true;
            }
            this.b = false;
            return false;
        } catch (Exception e) {
            this.b = false;
            return false;
        }
    }
}
