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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes3.dex */
public class FeedAdProgressButton extends View {
    private Paint IJ;
    private int Jb;
    private Paint aGu;
    private float bri;
    private int fdc;
    private int mProgress;
    private int mRadius;
    private String mText;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bri = 10.0f;
        this.fdc = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bri = 10.0f;
        this.fdc = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.feed_ad_progress);
        int color = getResources().getColor(e.d.cp_link_tip_a);
        int color2 = getResources().getColor(e.d.cp_link_tip_a_alpha15);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds1);
        this.strokeWidth = getResources().getDimensionPixelSize(e.C0210e.ds1);
        this.Jb = obtainStyledAttributes.getInteger(e.l.feed_ad_progress_btn_foreground, color2);
        this.mTextColor = obtainStyledAttributes.getColor(e.l.feed_ad_progress_btn_textColor, color);
        this.fdc = obtainStyledAttributes.getInteger(e.l.feed_ad_progress_btn_max, this.fdc);
        this.mProgress = obtainStyledAttributes.getInteger(e.l.feed_ad_progress_btn_progress, 0);
        this.mText = obtainStyledAttributes.getString(e.l.feed_ad_progress_btn_text);
        this.bri = obtainStyledAttributes.getDimension(e.l.feed_ad_progress_btn_textSize, (int) getResources().getDimension(e.C0210e.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(e.l.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        initPaint();
    }

    private void initPaint() {
        this.IJ = new Paint();
        this.aGu = new Paint();
        this.aGu.setAntiAlias(true);
        this.aGu.setTextSize(this.bri);
        this.aGu.setColor(this.mTextColor);
        this.IJ.setAntiAlias(true);
        this.IJ.setStyle(Paint.Style.FILL);
        this.IJ.setColor(this.Jb);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            canvas.drawRoundRect(new RectF(this.strokeWidth, this.strokeWidth, ((getWidth() * this.mProgress) / this.fdc) - this.strokeWidth, getHeight() - this.strokeWidth), this.mRadius, this.mRadius, this.IJ);
        }
        if (!TextUtils.isEmpty(this.mText)) {
            Paint.FontMetrics fontMetrics = this.aGu.getFontMetrics();
            canvas.drawText(this.mText, (getMeasuredWidth() - this.aGu.measureText(this.mText)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.aGu);
        }
    }

    public void setMax(int i) {
        this.fdc = i;
    }

    public void setText(String str) {
        this.mText = str;
        this.mProgress = 0;
        postInvalidate();
    }

    public void setText(String str, int i) {
        this.mText = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.Jb = i;
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.bri = i;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        if (i <= this.fdc) {
            this.mProgress = i;
            this.mText = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.fdc;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void onChangeSkinType() {
        al.i(this, e.f.feed_ad_progress_button_bg);
        this.mTextColor = al.getColor(e.d.cp_link_tip_a);
        this.Jb = al.getColor(e.d.cp_link_tip_a_alpha15);
    }
}
