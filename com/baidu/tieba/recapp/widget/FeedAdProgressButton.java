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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes7.dex */
public class FeedAdProgressButton extends View implements a {
    private int dUc;
    private int mForegroundColor;
    private Paint mForegroundPaint;
    private int mProgress;
    private int mQj;
    private int mQk;
    private int mQl;
    private int mQm;
    private int mQn;
    private RectF mQo;
    private Shader mQp;
    private int mRadius;
    private String mText;
    private int mTextColor;
    private TextPaint mTextPaint;
    private float mTextSize;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mQj = R.color.CAM_X0901;
        this.mQk = R.color.CAM_X0304;
        this.mQl = R.color.CAM_X0302;
        this.mQm = R.drawable.ad_download_progress_button_bg;
        this.mProgress = 0;
        this.mTextColor = ao.getColor(this.mQj);
        this.mQn = ao.getColor(this.mQk);
        this.mTextSize = 10.0f;
        this.mForegroundColor = ao.getColor(this.mQl);
        this.dUc = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mQj = R.color.CAM_X0901;
        this.mQk = R.color.CAM_X0304;
        this.mQl = R.color.CAM_X0302;
        this.mQm = R.drawable.ad_download_progress_button_bg;
        this.mProgress = 0;
        this.mTextColor = ao.getColor(this.mQj);
        this.mQn = ao.getColor(this.mQk);
        this.mTextSize = 10.0f;
        this.mForegroundColor = ao.getColor(this.mQl);
        this.dUc = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.feed_ad_progress);
        int color = getResources().getColor(R.color.CAM_X0302);
        int color2 = getResources().getColor(R.color.CAM_X0302);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mForegroundColor = obtainStyledAttributes.getInteger(R.styleable.feed_ad_progress_btn_foreground, color2);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.feed_ad_progress_btn_textColor, color);
        this.mQn = obtainStyledAttributes.getColor(R.styleable.feed_ad_progress_btn_textColorInit, color);
        this.dUc = obtainStyledAttributes.getInteger(R.styleable.feed_ad_progress_btn_max, this.dUc);
        this.mProgress = obtainStyledAttributes.getInteger(R.styleable.feed_ad_progress_btn_progress, 0);
        this.mText = obtainStyledAttributes.getString(R.styleable.feed_ad_progress_btn_text);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.feed_ad_progress_btn_textSize, (int) getResources().getDimension(R.dimen.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        this.mQo = new RectF();
        sa();
    }

    private void sa() {
        this.mForegroundPaint = new Paint();
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.mForegroundPaint.setColor(this.mForegroundColor);
        Hl();
    }

    private void Hl() {
        if (this.mTextPaint == null) {
            this.mTextPaint = new TextPaint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setTextSize(this.mTextSize);
        }
        int i = this.mProgress > 0 ? this.mTextColor : this.mQn;
        if (i != this.mTextPaint.getColor()) {
            this.mTextPaint.setColor(i);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            D(canvas);
        }
        if (!TextUtils.isEmpty(this.mText)) {
            Hl();
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            canvas.drawText(this.mText, (getMeasuredWidth() - this.mTextPaint.measureText(this.mText)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.mTextPaint);
        }
    }

    private void D(Canvas canvas) {
        if (this.mQo == null) {
            this.mQo = new RectF();
        }
        this.mQo.left = this.strokeWidth;
        this.mQo.top = this.strokeWidth;
        this.mQo.right = getMeasuredWidth() - this.strokeWidth;
        this.mQo.bottom = getMeasuredHeight() - this.strokeWidth;
        float f = this.mProgress / (this.dUc + 0.0f);
        this.mQp = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.mForegroundColor, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.mQp);
        canvas.drawRoundRect(this.mQo, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setMax(int i) {
        this.dUc = i;
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
        this.mQn = i;
        this.mTextColor = i;
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonTextNightColor(int i) {
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setProgress(int i) {
        if (i <= this.dUc) {
            this.mProgress = i;
            this.mText = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.dUc;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        this.mQk = i;
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        this.mQm = i;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void onChangeSkinType() {
        ao.setBackgroundResource(this, this.mQm);
        this.mTextColor = ao.getColor(this.mQj);
        this.mQn = ao.getColor(this.mQk);
        this.mForegroundColor = ao.getColor(this.mQl);
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void btU() {
        ao.setBackgroundResource(this, this.mQm);
        this.mTextColor = ao.getColor(this.mQj);
        this.mQn = ao.getColor(this.mQk);
        this.mForegroundColor = ao.getColor(this.mQl);
        postInvalidate();
    }
}
