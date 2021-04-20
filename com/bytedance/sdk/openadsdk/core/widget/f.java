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
    public int f28606a;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    public int f28607b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public int[] f28608c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public float[] f28609d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public LinearGradient f28610e;

    /* renamed from: f  reason: collision with root package name */
    public int f28611f;

    /* renamed from: g  reason: collision with root package name */
    public int f28612g;

    /* renamed from: h  reason: collision with root package name */
    public int f28613h;
    public int i;
    @Nullable
    public RectF j;
    @Nullable
    public Paint k;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public int[] f28616c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public float[] f28617d;

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f28618e;

        /* renamed from: h  reason: collision with root package name */
        public int f28621h;
        public int i;
        @ColorInt

        /* renamed from: a  reason: collision with root package name */
        public int f28614a = ad.j(p.a(), "tt_ssxinmian8");
        @ColorInt

        /* renamed from: b  reason: collision with root package name */
        public int f28615b = ad.j(p.a(), "tt_ssxinxian3");

        /* renamed from: f  reason: collision with root package name */
        public int f28619f = 10;

        /* renamed from: g  reason: collision with root package name */
        public int f28620g = 16;

        public a() {
            this.f28621h = 0;
            this.i = 0;
            this.f28621h = 0;
            this.i = 0;
        }

        public a a(@ColorInt int i) {
            this.f28614a = i;
            return this;
        }

        public a b(@ColorInt int i) {
            this.f28615b = i;
            return this;
        }

        public a c(int i) {
            this.f28619f = i;
            return this;
        }

        public a d(int i) {
            this.f28621h = i;
            return this;
        }

        public a e(int i) {
            this.i = i;
            return this;
        }

        public a a(@Nullable int[] iArr) {
            this.f28616c = iArr;
            return this;
        }

        public f a() {
            return new f(this.f28614a, this.f28616c, this.f28617d, this.f28615b, this.f28618e, this.f28619f, this.f28620g, this.f28621h, this.i);
        }
    }

    public f(@ColorInt int i, @Nullable int[] iArr, @Nullable float[] fArr, @ColorInt int i2, @Nullable LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.f28606a = i;
        this.f28608c = iArr;
        this.f28609d = fArr;
        this.f28607b = i2;
        this.f28610e = linearGradient;
        this.f28611f = i3;
        this.f28612g = i4;
        this.f28613h = i5;
        this.i = i6;
    }

    private void a() {
        int[] iArr;
        Paint paint = new Paint();
        this.k = paint;
        boolean z = true;
        paint.setAntiAlias(true);
        this.k.setShadowLayer(this.f28612g, this.f28613h, this.i, this.f28607b);
        if (this.j != null && (iArr = this.f28608c) != null && iArr.length > 1) {
            float[] fArr = this.f28609d;
            z = (fArr == null || fArr.length <= 0 || fArr.length != iArr.length) ? false : false;
            Paint paint2 = this.k;
            LinearGradient linearGradient = this.f28610e;
            if (linearGradient == null) {
                RectF rectF = this.j;
                linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.f28608c, z ? this.f28609d : null, Shader.TileMode.CLAMP);
            }
            paint2.setShader(linearGradient);
            return;
        }
        this.k.setColor(this.f28606a);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.j == null) {
            Rect bounds = getBounds();
            int i = bounds.left;
            int i2 = this.f28612g;
            int i3 = this.f28613h;
            int i4 = this.i;
            this.j = new RectF((i + i2) - i3, (bounds.top + i2) - i4, (bounds.right - i2) - i3, (bounds.bottom - i2) - i4);
        }
        if (this.k == null) {
            a();
        }
        RectF rectF = this.j;
        int i5 = this.f28611f;
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
