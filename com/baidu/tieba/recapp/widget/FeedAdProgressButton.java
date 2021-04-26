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
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.a.c.e.p.l;
import d.a.j0.s2.k0.a;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes5.dex */
public class FeedAdProgressButton extends View implements a {

    /* renamed from: e  reason: collision with root package name */
    public int f21148e;

    /* renamed from: f  reason: collision with root package name */
    public int f21149f;

    /* renamed from: g  reason: collision with root package name */
    public int f21150g;

    /* renamed from: h  reason: collision with root package name */
    public int f21151h;

    /* renamed from: i  reason: collision with root package name */
    public int f21152i;
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
        int i2 = R.color.CAM_X0901;
        this.f21148e = i2;
        this.f21149f = R.color.CAM_X0304;
        this.f21150g = R.color.CAM_X0302;
        this.f21151h = R.drawable.ad_download_progress_button_bg;
        this.f21152i = 0;
        this.j = SkinManager.getColor(i2);
        this.k = SkinManager.getColor(this.f21149f);
        this.n = 10.0f;
        this.o = SkinManager.getColor(this.f21150g);
        this.q = 100;
        this.r = 0;
        this.u = 0;
        c(context, attributeSet);
    }

    @Override // d.a.j0.s2.k0.a
    public void a() {
        SkinManager.setBackgroundResource(this, this.f21151h);
        this.j = SkinManager.getColor(this.f21148e);
        this.k = SkinManager.getColor(this.f21149f);
        this.o = SkinManager.getColor(this.f21150g);
    }

    public final void b(Canvas canvas) {
        if (this.s == null) {
            this.s = new RectF();
        }
        RectF rectF = this.s;
        int i2 = this.u;
        rectF.left = i2;
        rectF.top = i2;
        rectF.right = getMeasuredWidth() - this.u;
        this.s.bottom = getMeasuredHeight() - this.u;
        float f2 = this.f21152i / (this.q + 0.0f);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.o, 0}, new float[]{f2, f2 + 0.001f}, Shader.TileMode.CLAMP);
        this.t = linearGradient;
        this.l.setShader(linearGradient);
        RectF rectF2 = this.s;
        int i3 = this.r;
        canvas.drawRoundRect(rectF2, i3, i3, this.l);
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
        this.f21152i = obtainStyledAttributes.getInteger(R$styleable.feed_ad_progress_btn_progress, 0);
        this.p = obtainStyledAttributes.getString(R$styleable.feed_ad_progress_btn_text);
        this.n = obtainStyledAttributes.getDimension(R$styleable.feed_ad_progress_btn_textSize, (int) getResources().getDimension(R.dimen.fontsize24));
        this.r = obtainStyledAttributes.getDimensionPixelSize(R$styleable.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        this.s = new RectF();
        e();
    }

    @Override // d.a.j0.s2.k0.a
    public void d() {
        SkinManager.setBackgroundResource(this, this.f21151h);
        this.j = SkinManager.getColor(this.f21148e);
        this.k = SkinManager.getColor(this.f21149f);
        this.o = SkinManager.getColor(this.f21150g);
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
        int i2 = this.f21152i > 0 ? this.j : this.k;
        if (i2 != this.m.getColor()) {
            this.m.setColor(i2);
        }
    }

    public int getMax() {
        return this.q;
    }

    public int getProgress() {
        return this.f21152i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f21152i > 0) {
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

    public void setBackgroundSkin(@DrawableRes int i2) {
        this.f21151h = i2;
    }

    @Override // d.a.j0.s2.k0.a
    public void setButtonText(String str) {
        this.p = str;
        this.f21152i = 0;
        postInvalidate();
    }

    @Override // d.a.j0.s2.k0.a
    public void setButtonTextColor(int i2) {
        this.k = i2;
        this.j = i2;
        postInvalidate();
    }

    @Override // d.a.j0.s2.k0.a
    public void setButtonTextNightColor(int i2) {
    }

    @Override // d.a.j0.s2.k0.a
    public void setButtonTextSize(int i2) {
        this.n = l.e(getContext(), i2);
        postInvalidate();
    }

    public void setForeground(int i2) {
        this.o = i2;
        postInvalidate();
    }

    public void setMax(int i2) {
        this.q = i2;
    }

    @Override // d.a.j0.s2.k0.a
    public void setProgress(int i2) {
        if (i2 > this.q) {
            return;
        }
        this.f21152i = i2;
        this.p = this.f21152i + "%";
        postInvalidate();
    }

    public void setStrokeWidth(@DimenRes int i2) {
        this.u = getResources().getDimensionPixelSize(i2);
    }

    public void setTextColorInitSkin(@ColorRes int i2) {
        this.f21149f = i2;
    }

    public void setTextColorSkin(@ColorRes int i2) {
        this.f21148e = i2;
    }

    @Override // d.a.j0.s2.k0.a
    public void setButtonText(String str, int i2) {
        this.p = str;
        this.f21152i = i2;
        postInvalidate();
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3 = R.color.CAM_X0901;
        this.f21148e = i3;
        this.f21149f = R.color.CAM_X0304;
        this.f21150g = R.color.CAM_X0302;
        this.f21151h = R.drawable.ad_download_progress_button_bg;
        this.f21152i = 0;
        this.j = SkinManager.getColor(i3);
        this.k = SkinManager.getColor(this.f21149f);
        this.n = 10.0f;
        this.o = SkinManager.getColor(this.f21150g);
        this.q = 100;
        this.r = 0;
        this.u = 0;
        c(context, attributeSet);
    }
}
