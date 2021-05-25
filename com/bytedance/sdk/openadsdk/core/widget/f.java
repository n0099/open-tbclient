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
    public int f28668a;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    public int f28669b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public int[] f28670c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public float[] f28671d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public LinearGradient f28672e;

    /* renamed from: f  reason: collision with root package name */
    public int f28673f;

    /* renamed from: g  reason: collision with root package name */
    public int f28674g;

    /* renamed from: h  reason: collision with root package name */
    public int f28675h;

    /* renamed from: i  reason: collision with root package name */
    public int f28676i;
    @Nullable
    public RectF j;
    @Nullable
    public Paint k;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public int[] f28679c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public float[] f28680d;

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f28681e;

        /* renamed from: h  reason: collision with root package name */
        public int f28684h;

        /* renamed from: i  reason: collision with root package name */
        public int f28685i;
        @ColorInt

        /* renamed from: a  reason: collision with root package name */
        public int f28677a = ad.j(p.a(), "tt_ssxinmian8");
        @ColorInt

        /* renamed from: b  reason: collision with root package name */
        public int f28678b = ad.j(p.a(), "tt_ssxinxian3");

        /* renamed from: f  reason: collision with root package name */
        public int f28682f = 10;

        /* renamed from: g  reason: collision with root package name */
        public int f28683g = 16;

        public a() {
            this.f28684h = 0;
            this.f28685i = 0;
            this.f28684h = 0;
            this.f28685i = 0;
        }

        public a a(@ColorInt int i2) {
            this.f28677a = i2;
            return this;
        }

        public a b(@ColorInt int i2) {
            this.f28678b = i2;
            return this;
        }

        public a c(int i2) {
            this.f28682f = i2;
            return this;
        }

        public a d(int i2) {
            this.f28684h = i2;
            return this;
        }

        public a e(int i2) {
            this.f28685i = i2;
            return this;
        }

        public a a(@Nullable int[] iArr) {
            this.f28679c = iArr;
            return this;
        }

        public f a() {
            return new f(this.f28677a, this.f28679c, this.f28680d, this.f28678b, this.f28681e, this.f28682f, this.f28683g, this.f28684h, this.f28685i);
        }
    }

    public f(@ColorInt int i2, @Nullable int[] iArr, @Nullable float[] fArr, @ColorInt int i3, @Nullable LinearGradient linearGradient, int i4, int i5, int i6, int i7) {
        this.f28668a = i2;
        this.f28670c = iArr;
        this.f28671d = fArr;
        this.f28669b = i3;
        this.f28672e = linearGradient;
        this.f28673f = i4;
        this.f28674g = i5;
        this.f28675h = i6;
        this.f28676i = i7;
    }

    private void a() {
        int[] iArr;
        Paint paint = new Paint();
        this.k = paint;
        boolean z = true;
        paint.setAntiAlias(true);
        this.k.setShadowLayer(this.f28674g, this.f28675h, this.f28676i, this.f28669b);
        if (this.j != null && (iArr = this.f28670c) != null && iArr.length > 1) {
            float[] fArr = this.f28671d;
            z = (fArr == null || fArr.length <= 0 || fArr.length != iArr.length) ? false : false;
            Paint paint2 = this.k;
            LinearGradient linearGradient = this.f28672e;
            if (linearGradient == null) {
                RectF rectF = this.j;
                linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.f28670c, z ? this.f28671d : null, Shader.TileMode.CLAMP);
            }
            paint2.setShader(linearGradient);
            return;
        }
        this.k.setColor(this.f28668a);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.j == null) {
            Rect bounds = getBounds();
            int i2 = bounds.left;
            int i3 = this.f28674g;
            int i4 = this.f28675h;
            int i5 = this.f28676i;
            this.j = new RectF((i2 + i3) - i4, (bounds.top + i3) - i5, (bounds.right - i3) - i4, (bounds.bottom - i3) - i5);
        }
        if (this.k == null) {
            a();
        }
        RectF rectF = this.j;
        int i6 = this.f28673f;
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
