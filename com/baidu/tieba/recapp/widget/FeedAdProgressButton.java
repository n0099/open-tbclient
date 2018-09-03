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
import com.baidu.tieba.f;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes3.dex */
public class FeedAdProgressButton extends View {
    private Paint FH;
    private int Ga;
    private String aop;
    private Paint atD;
    private float beG;
    private int dkB;
    private int eCp;
    private int mProgress;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.beG = 10.0f;
        this.eCp = 100;
        this.dkB = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.beG = 10.0f;
        this.eCp = 100;
        this.dkB = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.l.feed_ad_progress);
        int color = getResources().getColor(f.d.cp_link_tip_a);
        int color2 = getResources().getColor(f.d.cp_link_tip_a_alpha15);
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.e.ds1);
        this.strokeWidth = getResources().getDimensionPixelSize(f.e.ds1);
        this.Ga = obtainStyledAttributes.getInteger(f.l.feed_ad_progress_btn_foreground, color2);
        this.mTextColor = obtainStyledAttributes.getColor(f.l.feed_ad_progress_btn_textColor, color);
        this.eCp = obtainStyledAttributes.getInteger(f.l.feed_ad_progress_btn_max, this.eCp);
        this.mProgress = obtainStyledAttributes.getInteger(f.l.feed_ad_progress_btn_progress, 0);
        this.aop = obtainStyledAttributes.getString(f.l.feed_ad_progress_btn_text);
        this.beG = obtainStyledAttributes.getDimension(f.l.feed_ad_progress_btn_textSize, (int) getResources().getDimension(f.e.fontsize24));
        this.dkB = obtainStyledAttributes.getDimensionPixelSize(f.l.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        oH();
    }

    private void oH() {
        this.FH = new Paint();
        this.atD = new Paint();
        this.atD.setAntiAlias(true);
        this.atD.setTextSize(this.beG);
        this.atD.setColor(this.mTextColor);
        this.FH.setAntiAlias(true);
        this.FH.setStyle(Paint.Style.FILL);
        this.FH.setColor(this.Ga);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            canvas.drawRoundRect(new RectF(this.strokeWidth, this.strokeWidth, ((getWidth() * this.mProgress) / this.eCp) - this.strokeWidth, getHeight() - this.strokeWidth), this.dkB, this.dkB, this.FH);
        }
        if (!TextUtils.isEmpty(this.aop)) {
            Paint.FontMetrics fontMetrics = this.atD.getFontMetrics();
            canvas.drawText(this.aop, (getMeasuredWidth() - this.atD.measureText(this.aop)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.atD);
        }
    }

    public void setMax(int i) {
        this.eCp = i;
    }

    public void setText(String str) {
        this.aop = str;
        this.mProgress = 0;
        postInvalidate();
    }

    public void setText(String str, int i) {
        this.aop = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.Ga = i;
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.beG = i;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        if (i <= this.eCp) {
            this.mProgress = i;
            this.aop = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.eCp;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void onChangeSkinType() {
        am.i(this, f.C0146f.feed_ad_progress_button_bg);
        this.mTextColor = am.getColor(f.d.cp_link_tip_a);
        this.Ga = am.getColor(f.d.cp_link_tip_a_alpha15);
    }
}
