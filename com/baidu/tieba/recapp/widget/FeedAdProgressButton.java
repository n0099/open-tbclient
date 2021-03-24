package com.baidu.tieba.recapp.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.b.b.e.p.l;
import d.b.i0.r2.e0.a;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes5.dex */
public class FeedAdProgressButton extends View implements a {

    /* renamed from: e  reason: collision with root package name */
    public int f20902e;

    /* renamed from: f  reason: collision with root package name */
    public int f20903f;

    /* renamed from: g  reason: collision with root package name */
    public int f20904g;

    /* renamed from: h  reason: collision with root package name */
    public int f20905h;
    public int i;
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
    public int u;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = R.color.CAM_X0901;
        this.f20902e = i;
        this.f20903f = R.color.CAM_X0304;
        this.f20904g = R.color.CAM_X0302;
        this.f20905h = R.drawable.ad_download_progress_button_bg;
        this.i = 0;
        this.j = SkinManager.getColor(i);
        this.k = SkinManager.getColor(this.f20903f);
        this.n = 10.0f;
        this.o = SkinManager.getColor(this.f20904g);
        this.q = 100;
        this.r = 0;
        this.u = 0;
        c(context, attributeSet);
    }

    @Override // d.b.i0.r2.e0.a
    public void a() {
        SkinManager.setBackgroundResource(this, this.f20905h);
        this.j = SkinManager.getColor(this.f20902e);
        this.k = SkinManager.getColor(this.f20903f);
        this.o = SkinManager.getColor(this.f20904g);
    }

    public final void b(Canvas canvas) {
        if (this.s == null) {
            this.s = new RectF();
        }
        RectF rectF = this.s;
        int i = this.u;
        rectF.left = i;
        rectF.top = i;
        rectF.right = getMeasuredWidth() - this.u;
        this.s.bottom = getMeasuredHeight() - this.u;
        float f2 = this.i / (this.q + 0.0f);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.o, 0}, new float[]{f2, f2 + 0.001f}, Shader.TileMode.CLAMP);
        this.t = linearGradient;
        this.l.setShader(linearGradient);
        RectF rectF2 = this.s;
        int i2 = this.r;
        canvas.drawRoundRect(rectF2, i2, i2, this.l);
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.feed_ad_progress);
        int color = getResources().getColor(R.color.CAM_X0302);
        int color2 = getResources().getColor(R.color.CAM_X0302);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.u = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.o = obtainStyledAttributes.getInteger(R$styleable.feed_ad_progress_btn_foreground, color2);
        this.j = obtainStyledAttributes.getColor(R$styleable.feed_ad_progress_btn_textColor, color);
        this.k = obtainStyledAttributes.getColor(R$styleable.feed_ad_progress_btn_textColorInit, color);
        this.q = obtainStyledAttributes.getInteger(R$styleable.feed_ad_progress_btn_max, this.q);
        this.i = obtainStyledAttributes.getInteger(R$styleable.feed_ad_progress_btn_progress, 0);
        this.p = obtainStyledAttributes.getString(R$styleable.feed_ad_progress_btn_text);
        this.n = obtainStyledAttributes.getDimension(R$styleable.feed_ad_progress_btn_textSize, (int) getResources().getDimension(R.dimen.fontsize24));
        this.r = obtainStyledAttributes.getDimensionPixelSize(R$styleable.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        this.s = new RectF();
        e();
    }

    @Override // d.b.i0.r2.e0.a
    public void d() {
        SkinManager.setBackgroundResource(this, this.f20905h);
        this.j = SkinManager.getColor(this.f20902e);
        this.k = SkinManager.getColor(this.f20903f);
        this.o = SkinManager.getColor(this.f20904g);
        postInvalidate();
    }

    public final void e() {
        Paint paint = new Paint();
        this.l = paint;
        paint.setAntiAlias(true);
        this.l.setStyle(Paint.Style.FILL);
        this.l.setColor(this.o);
        f();
    }

    public final void f() {
        if (this.m == null) {
            TextPaint textPaint = new TextPaint();
            this.m = textPaint;
            textPaint.setAntiAlias(true);
            this.m.setTextSize(this.n);
        }
        int i = this.i > 0 ? this.j : this.k;
        if (i != this.m.getColor()) {
            this.m.setColor(i);
        }
    }

    public int getMax() {
        return this.q;
    }

    public int getProgress() {
        return this.i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.i > 0) {
            b(canvas);
        }
        if (TextUtils.isEmpty(this.p)) {
            return;
        }
        f();
        Paint.FontMetrics fontMetrics = this.m.getFontMetrics();
        float f2 = fontMetrics.descent;
        canvas.drawText(this.p, (getMeasuredWidth() - this.m.measureText(this.p)) / 2.0f, ((getHeight() / 2) - f2) + ((f2 - fontMetrics.ascent) / 2.0f), this.m);
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        this.f20905h = i;
    }

    @Override // d.b.i0.r2.e0.a
    public void setButtonText(String str) {
        this.p = str;
        this.i = 0;
        postInvalidate();
    }

    @Override // d.b.i0.r2.e0.a
    public void setButtonTextColor(int i) {
        this.k = i;
        this.j = i;
        postInvalidate();
    }

    @Override // d.b.i0.r2.e0.a
    public void setButtonTextNightColor(int i) {
    }

    @Override // d.b.i0.r2.e0.a
    public void setButtonTextSize(int i) {
        this.n = l.e(getContext(), i);
        postInvalidate();
    }

    public void setForeground(int i) {
        this.o = i;
        postInvalidate();
    }

    public void setMax(int i) {
        this.q = i;
    }

    @Override // d.b.i0.r2.e0.a
    public void setProgress(int i) {
        if (i > this.q) {
            return;
        }
        this.i = i;
        this.p = this.i + "%";
        postInvalidate();
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        this.f20903f = i;
    }

    @Override // d.b.i0.r2.e0.a
    public void setButtonText(String str, int i) {
        this.p = str;
        this.i = i;
        postInvalidate();
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = R.color.CAM_X0901;
        this.f20902e = i2;
        this.f20903f = R.color.CAM_X0304;
        this.f20904g = R.color.CAM_X0302;
        this.f20905h = R.drawable.ad_download_progress_button_bg;
        this.i = 0;
        this.j = SkinManager.getColor(i2);
        this.k = SkinManager.getColor(this.f20903f);
        this.n = 10.0f;
        this.o = SkinManager.getColor(this.f20904g);
        this.q = 100;
        this.r = 0;
        this.u = 0;
        c(context, attributeSet);
    }
}
