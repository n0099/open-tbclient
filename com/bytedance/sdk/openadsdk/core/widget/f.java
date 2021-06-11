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
    public int f28771a;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    public int f28772b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public int[] f28773c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public float[] f28774d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public LinearGradient f28775e;

    /* renamed from: f  reason: collision with root package name */
    public int f28776f;

    /* renamed from: g  reason: collision with root package name */
    public int f28777g;

    /* renamed from: h  reason: collision with root package name */
    public int f28778h;

    /* renamed from: i  reason: collision with root package name */
    public int f28779i;
    @Nullable
    public RectF j;
    @Nullable
    public Paint k;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public int[] f28782c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public float[] f28783d;

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f28784e;

        /* renamed from: h  reason: collision with root package name */
        public int f28787h;

        /* renamed from: i  reason: collision with root package name */
        public int f28788i;
        @ColorInt

        /* renamed from: a  reason: collision with root package name */
        public int f28780a = ad.j(p.a(), "tt_ssxinmian8");
        @ColorInt

        /* renamed from: b  reason: collision with root package name */
        public int f28781b = ad.j(p.a(), "tt_ssxinxian3");

        /* renamed from: f  reason: collision with root package name */
        public int f28785f = 10;

        /* renamed from: g  reason: collision with root package name */
        public int f28786g = 16;

        public a() {
            this.f28787h = 0;
            this.f28788i = 0;
            this.f28787h = 0;
            this.f28788i = 0;
        }

        public a a(@ColorInt int i2) {
            this.f28780a = i2;
            return this;
        }

        public a b(@ColorInt int i2) {
            this.f28781b = i2;
            return this;
        }

        public a c(int i2) {
            this.f28785f = i2;
            return this;
        }

        public a d(int i2) {
            this.f28787h = i2;
            return this;
        }

        public a e(int i2) {
            this.f28788i = i2;
            return this;
        }

        public a a(@Nullable int[] iArr) {
            this.f28782c = iArr;
            return this;
        }

        public f a() {
            return new f(this.f28780a, this.f28782c, this.f28783d, this.f28781b, this.f28784e, this.f28785f, this.f28786g, this.f28787h, this.f28788i);
        }
    }

    public f(@ColorInt int i2, @Nullable int[] iArr, @Nullable float[] fArr, @ColorInt int i3, @Nullable LinearGradient linearGradient, int i4, int i5, int i6, int i7) {
        this.f28771a = i2;
        this.f28773c = iArr;
        this.f28774d = fArr;
        this.f28772b = i3;
        this.f28775e = linearGradient;
        this.f28776f = i4;
        this.f28777g = i5;
        this.f28778h = i6;
        this.f28779i = i7;
    }

    private void a() {
        int[] iArr;
        Paint paint = new Paint();
        this.k = paint;
        boolean z = true;
        paint.setAntiAlias(true);
        this.k.setShadowLayer(this.f28777g, this.f28778h, this.f28779i, this.f28772b);
        if (this.j != null && (iArr = this.f28773c) != null && iArr.length > 1) {
            float[] fArr = this.f28774d;
            z = (fArr == null || fArr.length <= 0 || fArr.length != iArr.length) ? false : false;
            Paint paint2 = this.k;
            LinearGradient linearGradient = this.f28775e;
            if (linearGradient == null) {
                RectF rectF = this.j;
                linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.f28773c, z ? this.f28774d : null, Shader.TileMode.CLAMP);
            }
            paint2.setShader(linearGradient);
            return;
        }
        this.k.setColor(this.f28771a);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.j == null) {
            Rect bounds = getBounds();
            int i2 = bounds.left;
            int i3 = this.f28777g;
            int i4 = this.f28778h;
            int i5 = this.f28779i;
            this.j = new RectF((i2 + i3) - i4, (bounds.top + i3) - i5, (bounds.right - i3) - i4, (bounds.bottom - i3) - i5);
        }
        if (this.k == null) {
            a();
        }
        RectF rectF = this.j;
        int i6 = this.f28776f;
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
