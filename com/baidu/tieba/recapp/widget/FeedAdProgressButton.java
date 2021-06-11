package com.baidu.tieba.recapp.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.a.c.e.p.l;
import d.a.n0.t2.k0.a;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes5.dex */
public class FeedAdProgressButton extends View implements a {

    /* renamed from: e  reason: collision with root package name */
    public int f20391e;

    /* renamed from: f  reason: collision with root package name */
    public int f20392f;

    /* renamed from: g  reason: collision with root package name */
    public int f20393g;

    /* renamed from: h  reason: collision with root package name */
    public int f20394h;

    /* renamed from: i  reason: collision with root package name */
    public int f20395i;
    public int j;
    public int k;
    public Paint l;
    public TextPaint m;
    public float n;
    public int o;
    public String p;
    public int q;
    public int r;
    public RectF s;
    public Shader t;
    public String u;
    public int v;
    public int w;
    public int x;
    public Rect y;
    public Paint z;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2 = R.color.CAM_X0901;
        this.f20391e = i2;
        this.f20392f = R.color.CAM_X0304;
        this.f20393g = R.color.CAM_X0302;
        this.f20394h = R.drawable.ad_download_progress_button_bg;
        this.f20395i = 0;
        this.j = SkinManager.getColor(i2);
        this.k = SkinManager.getColor(this.f20392f);
        this.n = 10.0f;
        this.o = SkinManager.getColor(this.f20393g);
        this.q = 100;
        this.r = 0;
        this.u = getResources().getString(R.string.install_app);
        this.x = 0;
        e(context, attributeSet);
    }

    @Override // d.a.n0.t2.k0.a
    public void a() {
        SkinManager.setBackgroundResource(this, this.f20394h);
        this.j = SkinManager.getColor(this.f20391e);
        this.k = SkinManager.getColor(this.f20392f);
        this.o = SkinManager.getColor(this.f20393g);
    }

    @Override // d.a.n0.t2.k0.a
    public void b() {
        SkinManager.setBackgroundResource(this, this.f20394h);
        this.j = SkinManager.getColor(this.f20391e);
        this.k = SkinManager.getColor(this.f20392f);
        this.o = SkinManager.getColor(this.f20393g);
        postInvalidate();
    }

    public final void c(Canvas canvas) {
        if (this.s == null) {
            this.s = new RectF();
        }
        RectF rectF = this.s;
        int i2 = this.x;
        rectF.left = i2;
        rectF.top = i2;
        rectF.right = getMeasuredWidth() - this.x;
        this.s.bottom = getMeasuredHeight() - this.x;
        float f2 = this.f20395i / (this.q + 0.0f);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.o, 0}, new float[]{f2, f2 + 0.001f}, Shader.TileMode.CLAMP);
        this.t = linearGradient;
        this.l.setShader(linearGradient);
        RectF rectF2 = this.s;
        int i3 = this.r;
        canvas.drawRoundRect(rectF2, i3, i3, this.l);
    }

    public final float d(int i2, float f2, boolean z) {
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE || i2 == 0) {
            return f2;
        }
        return View.getDefaultSize(z ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight(), i2);
    }

    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.feed_ad_progress);
        int color = getResources().getColor(R.color.CAM_X0302);
        int color2 = getResources().getColor(R.color.CAM_X0302);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.x = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.v = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
        this.w = getResources().getDimensionPixelSize(R.dimen.M_H_X003);
        this.o = obtainStyledAttributes.getInteger(R$styleable.feed_ad_progress_btn_foreground, color2);
        this.j = obtainStyledAttributes.getColor(R$styleable.feed_ad_progress_btn_textColor, color);
        this.k = obtainStyledAttributes.getColor(R$styleable.feed_ad_progress_btn_textColorInit, color);
        this.q = obtainStyledAttributes.getInteger(R$styleable.feed_ad_progress_btn_max, this.q);
        this.f20395i = obtainStyledAttributes.getInteger(R$styleable.feed_ad_progress_btn_progress, 0);
        this.p = obtainStyledAttributes.getString(R$styleable.feed_ad_progress_btn_text);
        this.n = obtainStyledAttributes.getDimension(R$styleable.feed_ad_progress_btn_textSize, (int) getResources().getDimension(R.dimen.fontsize24));
        this.r = obtainStyledAttributes.getDimensionPixelSize(R$styleable.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        this.s = new RectF();
        f();
    }

    public final void f() {
        Paint paint = new Paint();
        this.l = paint;
        paint.setAntiAlias(true);
        this.l.setStyle(Paint.Style.FILL);
        this.l.setColor(this.o);
        g();
    }

    public final void g() {
        if (this.m == null) {
            TextPaint textPaint = new TextPaint();
            this.m = textPaint;
            textPaint.setAntiAlias(true);
            this.m.setTextSize(this.n);
        }
        int i2 = this.f20395i > 0 ? this.j : this.k;
        if (i2 != this.m.getColor()) {
            this.m.setColor(i2);
        }
    }

    public int getMax() {
        return this.q;
    }

    public int getProgress() {
        return this.f20395i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20395i > 0) {
            c(canvas);
        }
        if (TextUtils.isEmpty(this.p)) {
            return;
        }
        g();
        Paint.FontMetrics fontMetrics = this.m.getFontMetrics();
        float f2 = fontMetrics.descent;
        canvas.drawText(this.p, (getMeasuredWidth() - this.m.measureText(this.p)) / 2.0f, ((getHeight() / 2) - f2) + ((f2 - fontMetrics.ascent) / 2.0f), this.m);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        float f2;
        if (this.y == null) {
            this.y = new Rect();
        }
        if (this.z == null) {
            this.z = new Paint();
        }
        this.z.setAntiAlias(true);
        this.z.setStyle(Paint.Style.FILL);
        this.z.setTextSize(this.n);
        this.z.setTextAlign(Paint.Align.CENTER);
        float f3 = 0.0f;
        if (TextUtils.isEmpty(this.u)) {
            f2 = 0.0f;
        } else {
            String string = this.u.length() >= 4 ? this.u : getResources().getString(R.string.install_app);
            this.z.getTextBounds(string, 0, string.length(), this.y);
            float height = this.y.height() + (this.w * 2);
            f3 = this.y.width() + (this.v * 2);
            f2 = height;
        }
        setMeasuredDimension((int) d(i2, f3, true), (int) d(i3, f2, false));
    }

    public void setBackgroundSkin(@DrawableRes int i2) {
        this.f20394h = i2;
    }

    @Override // d.a.n0.t2.k0.a
    public void setButtonText(String str) {
        this.p = str;
        postInvalidate();
    }

    @Override // d.a.n0.t2.k0.a
    public void setButtonTextColor(int i2) {
        this.k = i2;
        this.j = i2;
        postInvalidate();
    }

    @Override // d.a.n0.t2.k0.a
    public void setButtonTextNightColor(int i2) {
    }

    @Override // d.a.n0.t2.k0.a
    public void setButtonTextSize(@DimenRes int i2) {
        this.n = l.g(getContext(), i2);
        postInvalidate();
    }

    public void setForeground(int i2) {
        this.o = i2;
        postInvalidate();
    }

    @Override // d.a.n0.t2.k0.a
    public void setInitText(String str) {
        this.u = str;
    }

    public void setMax(int i2) {
        this.q = i2;
    }

    @Override // d.a.n0.t2.k0.a
    public void setProgress(int i2) {
        if (i2 > this.q || i2 < this.f20395i) {
            return;
        }
        this.f20395i = i2;
        this.p = this.f20395i + "%";
        postInvalidate();
    }

    public void setStrokeWidth(@DimenRes int i2) {
        this.x = getResources().getDimensionPixelSize(i2);
    }

    public void setTextColorInitSkin(@ColorRes int i2) {
        this.f20392f = i2;
    }

    public void setTextColorSkin(@ColorRes int i2) {
        this.f20391e = i2;
    }

    @Override // d.a.n0.t2.k0.a
    public void setButtonText(String str, int i2) {
        this.p = str;
        this.f20395i = i2;
        postInvalidate();
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3 = R.color.CAM_X0901;
        this.f20391e = i3;
        this.f20392f = R.color.CAM_X0304;
        this.f20393g = R.color.CAM_X0302;
        this.f20394h = R.drawable.ad_download_progress_button_bg;
        this.f20395i = 0;
        this.j = SkinManager.getColor(i3);
        this.k = SkinManager.getColor(this.f20392f);
        this.n = 10.0f;
        this.o = SkinManager.getColor(this.f20393g);
        this.q = 100;
        this.r = 0;
        this.u = getResources().getString(R.string.install_app);
        this.x = 0;
        e(context, attributeSet);
    }
}
