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
    public int f28614a;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    public int f28615b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public int[] f28616c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public float[] f28617d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public LinearGradient f28618e;

    /* renamed from: f  reason: collision with root package name */
    public int f28619f;

    /* renamed from: g  reason: collision with root package name */
    public int f28620g;

    /* renamed from: h  reason: collision with root package name */
    public int f28621h;
    public int i;
    @Nullable
    public RectF j;
    @Nullable
    public Paint k;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public int[] f28624c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public float[] f28625d;

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f28626e;

        /* renamed from: h  reason: collision with root package name */
        public int f28629h;
        public int i;
        @ColorInt

        /* renamed from: a  reason: collision with root package name */
        public int f28622a = ad.j(p.a(), "tt_ssxinmian8");
        @ColorInt

        /* renamed from: b  reason: collision with root package name */
        public int f28623b = ad.j(p.a(), "tt_ssxinxian3");

        /* renamed from: f  reason: collision with root package name */
        public int f28627f = 10;

        /* renamed from: g  reason: collision with root package name */
        public int f28628g = 16;

        public a() {
            this.f28629h = 0;
            this.i = 0;
            this.f28629h = 0;
            this.i = 0;
        }

        public a a(@ColorInt int i) {
            this.f28622a = i;
            return this;
        }

        public a b(@ColorInt int i) {
            this.f28623b = i;
            return this;
        }

        public a c(int i) {
            this.f28627f = i;
            return this;
        }

        public a d(int i) {
            this.f28629h = i;
            return this;
        }

        public a e(int i) {
            this.i = i;
            return this;
        }

        public a a(@Nullable int[] iArr) {
            this.f28624c = iArr;
            return this;
        }

        public f a() {
            return new f(this.f28622a, this.f28624c, this.f28625d, this.f28623b, this.f28626e, this.f28627f, this.f28628g, this.f28629h, this.i);
        }
    }

    public f(@ColorInt int i, @Nullable int[] iArr, @Nullable float[] fArr, @ColorInt int i2, @Nullable LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.f28614a = i;
        this.f28616c = iArr;
        this.f28617d = fArr;
        this.f28615b = i2;
        this.f28618e = linearGradient;
        this.f28619f = i3;
        this.f28620g = i4;
        this.f28621h = i5;
        this.i = i6;
    }

    private void a() {
        int[] iArr;
        Paint paint = new Paint();
        this.k = paint;
        boolean z = true;
        paint.setAntiAlias(true);
        this.k.setShadowLayer(this.f28620g, this.f28621h, this.i, this.f28615b);
        if (this.j != null && (iArr = this.f28616c) != null && iArr.length > 1) {
            float[] fArr = this.f28617d;
            z = (fArr == null || fArr.length <= 0 || fArr.length != iArr.length) ? false : false;
            Paint paint2 = this.k;
            LinearGradient linearGradient = this.f28618e;
            if (linearGradient == null) {
                RectF rectF = this.j;
                linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.f28616c, z ? this.f28617d : null, Shader.TileMode.CLAMP);
            }
            paint2.setShader(linearGradient);
            return;
        }
        this.k.setColor(this.f28614a);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.j == null) {
            Rect bounds = getBounds();
            int i = bounds.left;
            int i2 = this.f28620g;
            int i3 = this.f28621h;
            int i4 = this.i;
            this.j = new RectF((i + i2) - i3, (bounds.top + i2) - i4, (bounds.right - i2) - i3, (bounds.bottom - i2) - i4);
        }
        if (this.k == null) {
            a();
        }
        RectF rectF = this.j;
        int i5 = this.f28619f;
        canvas.drawRoundRect(rectF, i5, i5, this.k);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.k;
        if (paint != null) {
            paint.setAlpha(i);
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
