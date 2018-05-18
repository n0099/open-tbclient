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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes3.dex */
public class FeedAdProgressButton extends View {
    private float aVd;
    private String agh;
    private int eju;
    private Paint gft;
    private int mProgress;
    private int mRadius;
    private int mTextColor;
    private int strokeWidth;
    private Paint zA;
    private int zR;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.aVd = 10.0f;
        this.eju = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.aVd = 10.0f;
        this.eju = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.feed_ad_progress);
        int color = getResources().getColor(d.C0126d.cp_link_tip_a);
        int color2 = getResources().getColor(d.C0126d.cp_link_tip_a_alpha15);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds1);
        this.strokeWidth = getResources().getDimensionPixelSize(d.e.ds1);
        this.zR = obtainStyledAttributes.getInteger(d.m.feed_ad_progress_btn_foreground, color2);
        this.mTextColor = obtainStyledAttributes.getColor(d.m.feed_ad_progress_btn_textColor, color);
        this.eju = obtainStyledAttributes.getInteger(d.m.feed_ad_progress_btn_max, this.eju);
        this.mProgress = obtainStyledAttributes.getInteger(d.m.feed_ad_progress_btn_progress, 0);
        this.agh = obtainStyledAttributes.getString(d.m.feed_ad_progress_btn_text);
        this.aVd = obtainStyledAttributes.getDimension(d.m.feed_ad_progress_btn_textSize, (int) getResources().getDimension(d.e.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(d.m.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        initPaint();
    }

    private void initPaint() {
        this.zA = new Paint();
        this.gft = new Paint();
        this.gft.setAntiAlias(true);
        this.gft.setTextSize(this.aVd);
        this.gft.setColor(this.mTextColor);
        this.zA.setAntiAlias(true);
        this.zA.setStyle(Paint.Style.FILL);
        this.zA.setColor(this.zR);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            canvas.drawRoundRect(new RectF(this.strokeWidth, this.strokeWidth, ((getWidth() * this.mProgress) / this.eju) - this.strokeWidth, getHeight() - this.strokeWidth), this.mRadius, this.mRadius, this.zA);
        }
        if (!TextUtils.isEmpty(this.agh)) {
            Paint.FontMetrics fontMetrics = this.gft.getFontMetrics();
            canvas.drawText(this.agh, (getMeasuredWidth() - this.gft.measureText(this.agh)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.gft);
        }
    }

    public void setMax(int i) {
        this.eju = i;
    }

    public void setText(String str) {
        this.agh = str;
        this.mProgress = 0;
        postInvalidate();
    }

    public void setText(String str, int i) {
        this.agh = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.zR = i;
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.aVd = i;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        if (i <= this.eju) {
            this.mProgress = i;
            this.agh = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.eju;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void onChangeSkinType() {
        ak.i(this, d.f.feed_ad_progress_button_bg);
        this.mTextColor = ak.getColor(d.C0126d.cp_link_tip_a);
        this.zR = ak.getColor(d.C0126d.cp_link_tip_a_alpha15);
    }
}
