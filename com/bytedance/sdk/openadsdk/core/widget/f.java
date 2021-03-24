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
/* loaded from: classes6.dex */
public class f extends Drawable {
    @ColorInt

    /* renamed from: a  reason: collision with root package name */
    public int f28920a;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    public int f28921b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public int[] f28922c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public float[] f28923d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public LinearGradient f28924e;

    /* renamed from: f  reason: collision with root package name */
    public int f28925f;

    /* renamed from: g  reason: collision with root package name */
    public int f28926g;

    /* renamed from: h  reason: collision with root package name */
    public int f28927h;
    public int i;
    @Nullable
    public RectF j;
    @Nullable
    public Paint k;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public int[] f28930c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public float[] f28931d;

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f28932e;

        /* renamed from: h  reason: collision with root package name */
        public int f28935h;
        public int i;
        @ColorInt

        /* renamed from: a  reason: collision with root package name */
        public int f28928a = ad.j(p.a(), "tt_ssxinmian8");
        @ColorInt

        /* renamed from: b  reason: collision with root package name */
        public int f28929b = ad.j(p.a(), "tt_ssxinxian3");

        /* renamed from: f  reason: collision with root package name */
        public int f28933f = 10;

        /* renamed from: g  reason: collision with root package name */
        public int f28934g = 16;

        public a() {
            this.f28935h = 0;
            this.i = 0;
            this.f28935h = 0;
            this.i = 0;
        }

        public a a(@ColorInt int i) {
            this.f28928a = i;
            return this;
        }

        public a b(@ColorInt int i) {
            this.f28929b = i;
            return this;
        }

        public a c(int i) {
            this.f28933f = i;
            return this;
        }

        public a d(int i) {
            this.f28935h = i;
            return this;
        }

        public a e(int i) {
            this.i = i;
            return this;
        }

        public a a(@Nullable int[] iArr) {
            this.f28930c = iArr;
            return this;
        }

        public f a() {
            return new f(this.f28928a, this.f28930c, this.f28931d, this.f28929b, this.f28932e, this.f28933f, this.f28934g, this.f28935h, this.i);
        }
    }

    public f(@ColorInt int i, @Nullable int[] iArr, @Nullable float[] fArr, @ColorInt int i2, @Nullable LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.f28920a = i;
        this.f28922c = iArr;
        this.f28923d = fArr;
        this.f28921b = i2;
        this.f28924e = linearGradient;
        this.f28925f = i3;
        this.f28926g = i4;
        this.f28927h = i5;
        this.i = i6;
    }

    private void a() {
        int[] iArr;
        Paint paint = new Paint();
        this.k = paint;
        boolean z = true;
        paint.setAntiAlias(true);
        this.k.setShadowLayer(this.f28926g, this.f28927h, this.i, this.f28921b);
        if (this.j != null && (iArr = this.f28922c) != null && iArr.length > 1) {
            float[] fArr = this.f28923d;
            z = (fArr == null || fArr.length <= 0 || fArr.length != iArr.length) ? false : false;
            Paint paint2 = this.k;
            LinearGradient linearGradient = this.f28924e;
            if (linearGradient == null) {
                RectF rectF = this.j;
                linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.f28922c, z ? this.f28923d : null, Shader.TileMode.CLAMP);
            }
            paint2.setShader(linearGradient);
            return;
        }
        this.k.setColor(this.f28920a);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.j == null) {
            Rect bounds = getBounds();
            int i = bounds.left;
            int i2 = this.f28926g;
            int i3 = this.f28927h;
            int i4 = this.i;
            this.j = new RectF((i + i2) - i3, (bounds.top + i2) - i4, (bounds.right - i2) - i3, (bounds.bottom - i2) - i4);
        }
        if (this.k == null) {
            a();
        }
        RectF rectF = this.j;
        int i5 = this.f28925f;
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
