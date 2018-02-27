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
    private String aUL;
    private Paint aoY;
    private int apq;
    private float bKk;
    private int eNu;
    private Paint gJa;
    private int mProgress;
    private int mRadius;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bKk = 10.0f;
        this.eNu = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bKk = 10.0f;
        this.eNu = 100;
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
        this.apq = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_foreground, color2);
        this.mTextColor = obtainStyledAttributes.getColor(d.l.feed_ad_progress_btn_textColor, color);
        this.eNu = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_max, this.eNu);
        this.mProgress = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_progress, 0);
        this.aUL = obtainStyledAttributes.getString(d.l.feed_ad_progress_btn_text);
        this.bKk = obtainStyledAttributes.getDimension(d.l.feed_ad_progress_btn_textSize, (int) getResources().getDimension(d.e.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(d.l.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        initPaint();
    }

    private void initPaint() {
        this.aoY = new Paint();
        this.gJa = new Paint();
        this.gJa.setAntiAlias(true);
        this.gJa.setTextSize(this.bKk);
        this.gJa.setColor(this.mTextColor);
        this.aoY.setAntiAlias(true);
        this.aoY.setStyle(Paint.Style.FILL);
        this.aoY.setColor(this.apq);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            canvas.drawRoundRect(new RectF(this.strokeWidth, this.strokeWidth, ((getWidth() * this.mProgress) / this.eNu) - this.strokeWidth, getHeight() - this.strokeWidth), this.mRadius, this.mRadius, this.aoY);
        }
        if (!TextUtils.isEmpty(this.aUL)) {
            Paint.FontMetrics fontMetrics = this.gJa.getFontMetrics();
            canvas.drawText(this.aUL, (getMeasuredWidth() - this.gJa.measureText(this.aUL)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.gJa);
        }
    }

    public void setMax(int i) {
        this.eNu = i;
    }

    public void setText(String str) {
        this.aUL = str;
        this.mProgress = 0;
        postInvalidate();
    }

    public void aE(String str, int i) {
        this.aUL = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.apq = i;
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.bKk = i;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        if (i <= this.eNu) {
            this.mProgress = i;
            this.aUL = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.eNu;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void onChangeSkinType() {
        aj.s(this, d.f.feed_ad_progress_button_bg);
        this.mTextColor = aj.getColor(d.C0141d.cp_link_tip_a);
        this.apq = aj.getColor(d.C0141d.cp_link_tip_a_alpha15);
    }
}
