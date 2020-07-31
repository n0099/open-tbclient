package com.baidu.tieba.recapp.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes20.dex */
public class FeedAdProgressButton extends View implements a {
    private int ltG;
    private int ltH;
    private int ltI;
    private int ltJ;
    private int ltK;
    private RectF ltL;
    private Shader ltM;
    private int mForegroundColor;
    private Paint mForegroundPaint;
    private int mMax;
    private int mProgress;
    private int mRadius;
    private String mText;
    private int mTextColor;
    private TextPaint mTextPaint;
    private float mTextSize;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ltG = R.color.cp_btn_a;
        this.ltH = R.color.cp_link_tip_a;
        this.ltI = R.color.cp_link_tip_a;
        this.ltJ = R.drawable.ad_download_progress_button_bg;
        this.mProgress = 0;
        this.mTextColor = ao.getColor(this.ltG);
        this.ltK = ao.getColor(this.ltH);
        this.mTextSize = 10.0f;
        this.mForegroundColor = ao.getColor(this.ltI);
        this.mMax = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ltG = R.color.cp_btn_a;
        this.ltH = R.color.cp_link_tip_a;
        this.ltI = R.color.cp_link_tip_a;
        this.ltJ = R.drawable.ad_download_progress_button_bg;
        this.mProgress = 0;
        this.mTextColor = ao.getColor(this.ltG);
        this.ltK = ao.getColor(this.ltH);
        this.mTextSize = 10.0f;
        this.mForegroundColor = ao.getColor(this.ltI);
        this.mMax = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.feed_ad_progress);
        int color = getResources().getColor(R.color.cp_link_tip_a);
        int color2 = getResources().getColor(R.color.cp_link_tip_a_alpha50);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mForegroundColor = obtainStyledAttributes.getInteger(R.styleable.feed_ad_progress_btn_foreground, color2);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.feed_ad_progress_btn_textColor, color);
        this.ltK = obtainStyledAttributes.getColor(R.styleable.feed_ad_progress_btn_textColorInit, color);
        this.mMax = obtainStyledAttributes.getInteger(R.styleable.feed_ad_progress_btn_max, this.mMax);
        this.mProgress = obtainStyledAttributes.getInteger(R.styleable.feed_ad_progress_btn_progress, 0);
        this.mText = obtainStyledAttributes.getString(R.styleable.feed_ad_progress_btn_text);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.feed_ad_progress_btn_textSize, (int) getResources().getDimension(R.dimen.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        this.ltL = new RectF();
        qS();
    }

    private void qS() {
        this.mForegroundPaint = new Paint();
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.mForegroundPaint.setColor(this.mForegroundColor);
        Ff();
    }

    private void Ff() {
        if (this.mTextPaint == null) {
            this.mTextPaint = new TextPaint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setTextSize(this.mTextSize);
        }
        int i = this.mProgress > 0 ? this.mTextColor : this.ltK;
        if (i != this.mTextPaint.getColor()) {
            this.mTextPaint.setColor(i);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            u(canvas);
        }
        if (!TextUtils.isEmpty(this.mText)) {
            Ff();
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            canvas.drawText(this.mText, (getMeasuredWidth() - this.mTextPaint.measureText(this.mText)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.mTextPaint);
        }
    }

    private void u(Canvas canvas) {
        if (this.ltL == null) {
            this.ltL = new RectF();
        }
        this.ltL.left = this.strokeWidth;
        this.ltL.top = this.strokeWidth;
        this.ltL.right = getMeasuredWidth() - this.strokeWidth;
        this.ltL.bottom = getMeasuredHeight() - this.strokeWidth;
        float f = this.mProgress / (this.mMax + 0.0f);
        this.ltM = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.mForegroundColor, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.ltM);
        canvas.drawRoundRect(this.ltL, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setMax(int i) {
        this.mMax = i;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonText(String str) {
        this.mText = str;
        this.mProgress = 0;
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonText(String str, int i) {
        this.mText = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.mForegroundColor = i;
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonTextSize(int i) {
        this.mTextSize = l.dip2px(getContext(), i);
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonTextColor(int i) {
        this.ltK = i;
        this.mTextColor = i;
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonTextNightColor(int i) {
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setProgress(int i) {
        if (i <= this.mMax) {
            this.mProgress = i;
            this.mText = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.mMax;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        this.ltH = i;
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        this.ltJ = i;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void onChangeSkinType() {
        ao.setBackgroundResource(this, this.ltJ);
        this.mTextColor = ao.getColor(this.ltG);
        this.ltK = ao.getColor(this.ltH);
        this.mForegroundColor = ao.getColor(this.ltI);
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void changeSkin() {
        ao.setBackgroundResource(this, this.ltJ);
        this.mTextColor = ao.getColor(this.ltG);
        this.ltK = ao.getColor(this.ltH);
        this.mForegroundColor = ao.getColor(this.ltI);
        postInvalidate();
    }
}
