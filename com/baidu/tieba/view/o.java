package com.baidu.tieba.view;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f2694a;
    private boolean b = false;
    private boolean c = false;
    private long d;
    private long e;
    private int f;
    private int g;
    private long h;
    private long i;

    public o(l lVar) {
        this.f2694a = lVar;
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
        interpolator = this.f2694a.M;
        setInterpolator(interpolator);
        this.f = this.f2694a.getScrollX();
        this.g = this.f2694a.getScrollY();
        this.b = true;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        long j;
        int i;
        int i2;
        float f2;
        int i3;
        int i4;
        float f3;
        float f4;
        int i5;
        float f5;
        int i6;
        float f6;
        int i7;
        int i8;
        float f7;
        int i9;
        int i10;
        int i11;
        int i12 = 0;
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (this.h > this.i) {
            j = ((float) this.h) * f;
        } else {
            j = ((float) this.i) * f;
        }
        float f8 = ((float) (j > this.h ? this.h : j)) / 1000.0f;
        if (this.d > 0) {
            i = this.f - ((int) (f8 * (((float) this.d) - ((2500.0f * f8) / 2.0f))));
        } else {
            i = this.f - ((int) (f8 * (((float) this.d) + ((2500.0f * f8) / 2.0f))));
        }
        if (j > this.i) {
            j = this.i;
        }
        float f9 = ((float) j) / 1000.0f;
        if (this.e > 0) {
            i2 = this.g - ((int) (f9 * (((float) this.e) - ((2500.0f * f9) / 2.0f))));
        } else {
            i2 = this.g - ((int) (f9 * (((float) this.e) + ((2500.0f * f9) / 2.0f))));
        }
        f2 = this.f2694a.f;
        i3 = this.f2694a.I;
        float f10 = f2 + i3;
        i4 = this.f2694a.J;
        if (f10 + i4 > this.f2694a.getHeight()) {
            i6 = this.f2694a.K;
            if (i2 < (-i6)) {
                i11 = this.f2694a.K;
                i2 = -i11;
            }
            f6 = this.f2694a.f;
            i7 = this.f2694a.J;
            float f11 = f6 + i7;
            i8 = this.f2694a.L;
            if (this.f2694a.getHeight() + i2 > f11 + i8) {
                f7 = this.f2694a.f;
                i9 = this.f2694a.J;
                float height = (f7 - this.f2694a.getHeight()) + i9;
                i10 = this.f2694a.L;
                i2 = (int) (height + i10);
            }
        } else {
            i2 = 0;
        }
        f3 = this.f2694a.e;
        if (f3 > this.f2694a.getWidth()) {
            f4 = this.f2694a.e;
            if (this.f2694a.getWidth() + i > f4) {
                f5 = this.f2694a.e;
                i5 = (int) (f5 - this.f2694a.getWidth());
            } else {
                i5 = i;
            }
            if (i5 >= 0) {
                i12 = i5;
            }
        }
        this.f2694a.scrollTo(i12, i2);
        this.f2694a.invalidate();
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        boolean z;
        if (!this.c) {
            z = this.f2694a.l;
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
        this.c = false;
        this.b = false;
        return false;
    }

    public boolean a() {
        return this.b;
    }

    public void b() {
        this.c = true;
    }
}
