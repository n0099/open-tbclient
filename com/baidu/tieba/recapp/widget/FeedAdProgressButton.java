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
    private String aUN;
    private Paint aoY;
    private int apr;
    private float bKn;
    private int eNK;
    private Paint gJq;
    private int mProgress;
    private int mRadius;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bKn = 10.0f;
        this.eNK = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bKn = 10.0f;
        this.eNK = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.feed_ad_progress);
        int color = getResources().getColor(d.C0141d.cp_link_tip_a);
        int color2 = getResources().getColor(d.C0141d.cp_link_tip_a_alpha15);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds1);
        this.strokeWidth = getResources().getDimensionPixelSize(d.e.ds1);
        this.apr = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_foreground, color2);
        this.mTextColor = obtainStyledAttributes.getColor(d.l.feed_ad_progress_btn_textColor, color);
        this.eNK = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_max, this.eNK);
        this.mProgress = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_progress, 0);
        this.aUN = obtainStyledAttributes.getString(d.l.feed_ad_progress_btn_text);
        this.bKn = obtainStyledAttributes.getDimension(d.l.feed_ad_progress_btn_textSize, (int) getResources().getDimension(d.e.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(d.l.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        initPaint();
    }

    private void initPaint() {
        this.aoY = new Paint();
        this.gJq = new Paint();
        this.gJq.setAntiAlias(true);
        this.gJq.setTextSize(this.bKn);
        this.gJq.setColor(this.mTextColor);
        this.aoY.setAntiAlias(true);
        this.aoY.setStyle(Paint.Style.FILL);
        this.aoY.setColor(this.apr);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            canvas.drawRoundRect(new RectF(this.strokeWidth, this.strokeWidth, ((getWidth() * this.mProgress) / this.eNK) - this.strokeWidth, getHeight() - this.strokeWidth), this.mRadius, this.mRadius, this.aoY);
        }
        if (!TextUtils.isEmpty(this.aUN)) {
            Paint.FontMetrics fontMetrics = this.gJq.getFontMetrics();
            canvas.drawText(this.aUN, (getMeasuredWidth() - this.gJq.measureText(this.aUN)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.gJq);
        }
    }

    public void setMax(int i) {
        this.eNK = i;
    }

    public void setText(String str) {
        this.aUN = str;
        this.mProgress = 0;
        postInvalidate();
    }

    public void aE(String str, int i) {
        this.aUN = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.apr = i;
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.bKn = i;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        if (i <= this.eNK) {
            this.mProgress = i;
            this.aUN = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.eNK;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void onChangeSkinType() {
        aj.s(this, d.f.feed_ad_progress_button_bg);
        this.mTextColor = aj.getColor(d.C0141d.cp_link_tip_a);
        this.apr = aj.getColor(d.C0141d.cp_link_tip_a_alpha15);
    }
}
