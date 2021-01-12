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
import com.bytedance.sdk.openadsdk.utils.ac;
/* loaded from: classes4.dex */
public class f extends Drawable {
    @ColorInt

    /* renamed from: a  reason: collision with root package name */
    private int f6808a;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    private int f6809b;
    @Nullable
    private int[] c;
    @Nullable
    private float[] d;
    @Nullable
    private LinearGradient e;
    private int f;
    private int g;
    private int h;
    private int i;
    @Nullable
    private RectF j;
    @Nullable
    private Paint k;

    public f(@ColorInt int i, @Nullable int[] iArr, @Nullable float[] fArr, @ColorInt int i2, @Nullable LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.f6808a = i;
        this.c = iArr;
        this.d = fArr;
        this.f6809b = i2;
        this.e = linearGradient;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.j == null) {
            Rect bounds = getBounds();
            this.j = new RectF((bounds.left + this.g) - this.h, (bounds.top + this.g) - this.i, (bounds.right - this.g) - this.h, (bounds.bottom - this.g) - this.i);
        }
        if (this.k == null) {
            a();
        }
        canvas.drawRoundRect(this.j, this.f, this.f, this.k);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.k != null) {
            this.k.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.k != null) {
            this.k.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void a() {
        LinearGradient linearGradient;
        this.k = new Paint();
        this.k.setAntiAlias(true);
        this.k.setShadowLayer(this.g, this.h, this.i, this.f6809b);
        if (this.j != null && this.c != null && this.c.length > 1) {
            boolean z = this.d != null && this.d.length > 0 && this.d.length == this.c.length;
            Paint paint = this.k;
            if (this.e == null) {
                linearGradient = new LinearGradient(this.j.left, 0.0f, this.j.right, 0.0f, this.c, z ? this.d : null, Shader.TileMode.CLAMP);
            } else {
                linearGradient = this.e;
            }
            paint.setShader(linearGradient);
            return;
        }
        this.k.setColor(this.f6808a);
    }

    public static void a(View view, a aVar) {
        if (view != null && aVar != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, aVar.a());
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private int[] c;
        @Nullable
        private float[] d;
        private LinearGradient e;
        private int h;
        private int i;
        @ColorInt

        /* renamed from: a  reason: collision with root package name */
        private int f6810a = ac.j(p.a(), "tt_ssxinmian8");
        @ColorInt

        /* renamed from: b  reason: collision with root package name */
        private int f6811b = ac.j(p.a(), "tt_ssxinxian3");
        private int f = 10;
        private int g = 16;

        public a() {
            this.h = 0;
            this.i = 0;
            this.h = 0;
            this.i = 0;
        }

        public a a(@ColorInt int i) {
            this.f6810a = i;
            return this;
        }

        public a b(@ColorInt int i) {
            this.f6811b = i;
            return this;
        }

        public a a(@Nullable int[] iArr) {
            this.c = iArr;
            return this;
        }

        public a c(int i) {
            this.f = i;
            return this;
        }

        public a d(int i) {
            this.h = i;
            return this;
        }

        public a e(int i) {
            this.i = i;
            return this;
        }

        public f a() {
            return new f(this.f6810a, this.c, this.d, this.f6811b, this.e, this.f, this.g, this.h, this.i);
        }
    }
}
