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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes3.dex */
public class FeedAdProgressButton extends View {
    private Paint FK;
    private int Gc;
    private String aoM;
    private Paint atY;
    private float bew;
    private int eyC;
    private int mProgress;
    private int mRadius;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bew = 10.0f;
        this.eyC = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bew = 10.0f;
        this.eyC = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.feed_ad_progress);
        int color = getResources().getColor(d.C0142d.cp_link_tip_a);
        int color2 = getResources().getColor(d.C0142d.cp_link_tip_a_alpha15);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds1);
        this.strokeWidth = getResources().getDimensionPixelSize(d.e.ds1);
        this.Gc = obtainStyledAttributes.getInteger(d.m.feed_ad_progress_btn_foreground, color2);
        this.mTextColor = obtainStyledAttributes.getColor(d.m.feed_ad_progress_btn_textColor, color);
        this.eyC = obtainStyledAttributes.getInteger(d.m.feed_ad_progress_btn_max, this.eyC);
        this.mProgress = obtainStyledAttributes.getInteger(d.m.feed_ad_progress_btn_progress, 0);
        this.aoM = obtainStyledAttributes.getString(d.m.feed_ad_progress_btn_text);
        this.bew = obtainStyledAttributes.getDimension(d.m.feed_ad_progress_btn_textSize, (int) getResources().getDimension(d.e.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(d.m.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        initPaint();
    }

    private void initPaint() {
        this.FK = new Paint();
        this.atY = new Paint();
        this.atY.setAntiAlias(true);
        this.atY.setTextSize(this.bew);
        this.atY.setColor(this.mTextColor);
        this.FK.setAntiAlias(true);
        this.FK.setStyle(Paint.Style.FILL);
        this.FK.setColor(this.Gc);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            canvas.drawRoundRect(new RectF(this.strokeWidth, this.strokeWidth, ((getWidth() * this.mProgress) / this.eyC) - this.strokeWidth, getHeight() - this.strokeWidth), this.mRadius, this.mRadius, this.FK);
        }
        if (!TextUtils.isEmpty(this.aoM)) {
            Paint.FontMetrics fontMetrics = this.atY.getFontMetrics();
            canvas.drawText(this.aoM, (getMeasuredWidth() - this.atY.measureText(this.aoM)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.atY);
        }
    }

    public void setMax(int i) {
        this.eyC = i;
    }

    public void setText(String str) {
        this.aoM = str;
        this.mProgress = 0;
        postInvalidate();
    }

    public void setText(String str, int i) {
        this.aoM = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.Gc = i;
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.bew = i;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        if (i <= this.eyC) {
            this.mProgress = i;
            this.aoM = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.eyC;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void onChangeSkinType() {
        am.i(this, d.f.feed_ad_progress_button_bg);
        this.mTextColor = am.getColor(d.C0142d.cp_link_tip_a);
        this.Gc = am.getColor(d.C0142d.cp_link_tip_a_alpha15);
    }
}
