package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ad;
/* loaded from: classes5.dex */
public class f extends Drawable {
    @ColorInt

    /* renamed from: a  reason: collision with root package name */
    public int f29494a;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    public int f29495b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public int[] f29496c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public float[] f29497d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public LinearGradient f29498e;

    /* renamed from: f  reason: collision with root package name */
    public int f29499f;

    /* renamed from: g  reason: collision with root package name */
    public int f29500g;

    /* renamed from: h  reason: collision with root package name */
    public int f29501h;

    /* renamed from: i  reason: collision with root package name */
    public int f29502i;
    @Nullable
    public RectF j;
    @Nullable
    public Paint k;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public int[] f29505c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public float[] f29506d;

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f29507e;

        /* renamed from: h  reason: collision with root package name */
        public int f29510h;

        /* renamed from: i  reason: collision with root package name */
        public int f29511i;
        @ColorInt

        /* renamed from: a  reason: collision with root package name */
        public int f29503a = ad.j(p.a(), "tt_ssxinmian8");
        @ColorInt

        /* renamed from: b  reason: collision with root package name */
        public int f29504b = ad.j(p.a(), "tt_ssxinxian3");

        /* renamed from: f  reason: collision with root package name */
        public int f29508f = 10;

        /* renamed from: g  reason: collision with root package name */
        public int f29509g = 16;

        public a() {
            this.f29510h = 0;
            this.f29511i = 0;
            this.f29510h = 0;
            this.f29511i = 0;
        }

        public a a(@ColorInt int i2) {
            this.f29503a = i2;
            return this;
        }

        public a b(@ColorInt int i2) {
            this.f29504b = i2;
            return this;
        }

        public a c(int i2) {
            this.f29508f = i2;
            return this;
        }

        public a d(int i2) {
            this.f29510h = i2;
            return this;
        }

        public a e(int i2) {
            this.f29511i = i2;
            return this;
        }

        public a a(@Nullable int[] iArr) {
            this.f29505c = iArr;
            return this;
        }

        public f a() {
            return new f(this.f29503a, this.f29505c, this.f29506d, this.f29504b, this.f29507e, this.f29508f, this.f29509g, this.f29510h, this.f29511i);
        }
    }

    public f(@ColorInt int i2, @Nullable int[] iArr, @Nullable float[] fArr, @ColorInt int i3, @Nullable LinearGradient linearGradient, int i4, int i5, int i6, int i7) {
        this.f29494a = i2;
        this.f29496c = iArr;
        this.f29497d = fArr;
        this.f29495b = i3;
        this.f29498e = linearGradient;
        this.f29499f = i4;
        this.f29500g = i5;
        this.f29501h = i6;
        this.f29502i = i7;
    }

    private void a() {
        int[] iArr;
        Paint paint = new Paint();
        this.k = paint;
        boolean z = true;
        paint.setAntiAlias(true);
        this.k.setShadowLayer(this.f29500g, this.f29501h, this.f29502i, this.f29495b);
        if (this.j != null && (iArr = this.f29496c) != null && iArr.length > 1) {
            float[] fArr = this.f29497d;
            z = (fArr == null || fArr.length <= 0 || fArr.length != iArr.length) ? false : false;
            Paint paint2 = this.k;
            LinearGradient linearGradient = this.f29498e;
            if (linearGradient == null) {
                RectF rectF = this.j;
                linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.f29496c, z ? this.f29497d : null, Shader.TileMode.CLAMP);
            }
            paint2.setShader(linearGradient);
            return;
        }
        this.k.setColor(this.f29494a);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.j == null) {
            Rect bounds = getBounds();
            int i2 = bounds.left;
            int i3 = this.f29500g;
            int i4 = this.f29501h;
            int i5 = this.f29502i;
            this.j = new RectF((i2 + i3) - i4, (bounds.top + i3) - i5, (bounds.right - i3) - i4, (bounds.bottom - i3) - i5);
        }
        if (this.k == null) {
            a();
        }
        RectF rectF = this.j;
        int i6 = this.f29499f;
        canvas.drawRoundRect(rectF, i6, i6, this.k);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Paint paint = this.k;
        if (paint != null) {
            paint.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Paint paint = this.k;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public static void a(View view, a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, aVar.a());
    }
}
