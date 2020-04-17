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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes13.dex */
public class FeedAdProgressButton extends View implements a {
    private int kzl;
    private int kzm;
    private int kzn;
    private int kzo;
    private int kzp;
    private RectF kzq;
    private Shader kzr;
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
        this.kzl = R.color.cp_btn_a;
        this.kzm = R.color.cp_link_tip_a;
        this.kzn = R.color.cp_link_tip_a;
        this.kzo = R.drawable.ad_download_progress_button_bg;
        this.mProgress = 0;
        this.mTextColor = am.getColor(this.kzl);
        this.kzp = am.getColor(this.kzm);
        this.mTextSize = 10.0f;
        this.mForegroundColor = am.getColor(this.kzn);
        this.mMax = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kzl = R.color.cp_btn_a;
        this.kzm = R.color.cp_link_tip_a;
        this.kzn = R.color.cp_link_tip_a;
        this.kzo = R.drawable.ad_download_progress_button_bg;
        this.mProgress = 0;
        this.mTextColor = am.getColor(this.kzl);
        this.kzp = am.getColor(this.kzm);
        this.mTextSize = 10.0f;
        this.mForegroundColor = am.getColor(this.kzn);
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
        this.mForegroundColor = obtainStyledAttributes.getInteger(0, color2);
        this.mTextColor = obtainStyledAttributes.getColor(1, color);
        this.kzp = obtainStyledAttributes.getColor(2, color);
        this.mMax = obtainStyledAttributes.getInteger(3, this.mMax);
        this.mProgress = obtainStyledAttributes.getInteger(4, 0);
        this.mText = obtainStyledAttributes.getString(6);
        this.mTextSize = obtainStyledAttributes.getDimension(5, (int) getResources().getDimension(R.dimen.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(7, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        this.kzq = new RectF();
        qs();
    }

    private void qs() {
        this.mForegroundPaint = new Paint();
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.mForegroundPaint.setColor(this.mForegroundColor);
        CX();
    }

    private void CX() {
        if (this.mTextPaint == null) {
            this.mTextPaint = new TextPaint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setTextSize(this.mTextSize);
        }
        int i = this.mProgress > 0 ? this.mTextColor : this.kzp;
        if (i != this.mTextPaint.getColor()) {
            this.mTextPaint.setColor(i);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            t(canvas);
        }
        if (!TextUtils.isEmpty(this.mText)) {
            CX();
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            canvas.drawText(this.mText, (getMeasuredWidth() - this.mTextPaint.measureText(this.mText)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.mTextPaint);
        }
    }

    private void t(Canvas canvas) {
        if (this.kzq == null) {
            this.kzq = new RectF();
        }
        this.kzq.left = this.strokeWidth;
        this.kzq.top = this.strokeWidth;
        this.kzq.right = getMeasuredWidth() - this.strokeWidth;
        this.kzq.bottom = getMeasuredHeight() - this.strokeWidth;
        float f = this.mProgress / (this.mMax + 0.0f);
        this.kzr = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.mForegroundColor, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.kzr);
        canvas.drawRoundRect(this.kzq, this.mRadius, this.mRadius, this.mForegroundPaint);
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
        this.kzp = i;
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
        this.kzm = i;
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        this.kzo = i;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void onChangeSkinType() {
        am.setBackgroundResource(this, this.kzo);
        this.mTextColor = am.getColor(this.kzl);
        this.kzp = am.getColor(this.kzm);
        this.mForegroundColor = am.getColor(this.kzn);
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void ckO() {
        am.setBackgroundResource(this, this.kzo);
        this.mTextColor = am.getColor(this.kzl);
        this.kzp = am.getColor(this.kzm);
        this.mForegroundColor = am.getColor(this.kzn);
        postInvalidate();
    }
}
