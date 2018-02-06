package com.baidu.tieba.recapp.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes3.dex */
public class FeedAdProgressButton extends View {
    private String aUX;
    private Paint apf;
    private int apz;
    private float bKx;
    private int eNG;
    private Paint gJp;
    private int mProgress;
    private int mRadius;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bKx = 10.0f;
        this.eNG = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bKx = 10.0f;
        this.eNG = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.feed_ad_progress);
        int color = getResources().getColor(d.C0140d.cp_link_tip_a);
        int color2 = getResources().getColor(d.C0140d.cp_link_tip_a_alpha15);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds1);
        this.strokeWidth = getResources().getDimensionPixelSize(d.e.ds1);
        this.apz = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_foreground, color2);
        this.mTextColor = obtainStyledAttributes.getColor(d.l.feed_ad_progress_btn_textColor, color);
        this.eNG = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_max, this.eNG);
        this.mProgress = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_progress, 0);
        this.aUX = obtainStyledAttributes.getString(d.l.feed_ad_progress_btn_text);
        this.bKx = obtainStyledAttributes.getDimension(d.l.feed_ad_progress_btn_textSize, (int) getResources().getDimension(d.e.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(d.l.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        initPaint();
    }

    private void initPaint() {
        this.apf = new Paint();
        this.gJp = new Paint();
        this.gJp.setAntiAlias(true);
        this.gJp.setTextSize(this.bKx);
        this.gJp.setColor(this.mTextColor);
        this.apf.setAntiAlias(true);
        this.apf.setStyle(Paint.Style.FILL);
        this.apf.setColor(this.apz);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            canvas.drawRoundRect(new RectF(this.strokeWidth, this.strokeWidth, ((getWidth() * this.mProgress) / this.eNG) - this.strokeWidth, getHeight() - this.strokeWidth), this.mRadius, this.mRadius, this.apf);
        }
        if (!TextUtils.isEmpty(this.aUX)) {
            Paint.FontMetrics fontMetrics = this.gJp.getFontMetrics();
            canvas.drawText(this.aUX, (getMeasuredWidth() - this.gJp.measureText(this.aUX)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.gJp);
        }
    }

    public void setMax(int i) {
        this.eNG = i;
    }

    public void setText(String str) {
        this.aUX = str;
        this.mProgress = 0;
        postInvalidate();
    }

    public void aE(String str, int i) {
        this.aUX = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.apz = i;
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.bKx = i;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        if (i <= this.eNG) {
            this.mProgress = i;
            this.aUX = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.eNG;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void onChangeSkinType() {
        aj.s(this, d.f.feed_ad_progress_button_bg);
        this.mTextColor = aj.getColor(d.C0140d.cp_link_tip_a);
        this.apz = aj.getColor(d.C0140d.cp_link_tip_a_alpha15);
    }
}
