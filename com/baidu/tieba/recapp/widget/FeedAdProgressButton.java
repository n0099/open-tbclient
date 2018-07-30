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
    private Paint FH;
    private int Ga;
    private String aoo;
    private Paint atC;
    private float beF;
    private int dkD;
    private int eCt;
    private int mProgress;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.beF = 10.0f;
        this.eCt = 100;
        this.dkD = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.beF = 10.0f;
        this.eCt = 100;
        this.dkD = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.feed_ad_progress);
        int color = getResources().getColor(d.C0140d.cp_link_tip_a);
        int color2 = getResources().getColor(d.C0140d.cp_link_tip_a_alpha15);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds1);
        this.strokeWidth = getResources().getDimensionPixelSize(d.e.ds1);
        this.Ga = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_foreground, color2);
        this.mTextColor = obtainStyledAttributes.getColor(d.l.feed_ad_progress_btn_textColor, color);
        this.eCt = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_max, this.eCt);
        this.mProgress = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_progress, 0);
        this.aoo = obtainStyledAttributes.getString(d.l.feed_ad_progress_btn_text);
        this.beF = obtainStyledAttributes.getDimension(d.l.feed_ad_progress_btn_textSize, (int) getResources().getDimension(d.e.fontsize24));
        this.dkD = obtainStyledAttributes.getDimensionPixelSize(d.l.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        oK();
    }

    private void oK() {
        this.FH = new Paint();
        this.atC = new Paint();
        this.atC.setAntiAlias(true);
        this.atC.setTextSize(this.beF);
        this.atC.setColor(this.mTextColor);
        this.FH.setAntiAlias(true);
        this.FH.setStyle(Paint.Style.FILL);
        this.FH.setColor(this.Ga);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            canvas.drawRoundRect(new RectF(this.strokeWidth, this.strokeWidth, ((getWidth() * this.mProgress) / this.eCt) - this.strokeWidth, getHeight() - this.strokeWidth), this.dkD, this.dkD, this.FH);
        }
        if (!TextUtils.isEmpty(this.aoo)) {
            Paint.FontMetrics fontMetrics = this.atC.getFontMetrics();
            canvas.drawText(this.aoo, (getMeasuredWidth() - this.atC.measureText(this.aoo)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.atC);
        }
    }

    public void setMax(int i) {
        this.eCt = i;
    }

    public void setText(String str) {
        this.aoo = str;
        this.mProgress = 0;
        postInvalidate();
    }

    public void setText(String str, int i) {
        this.aoo = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.Ga = i;
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.beF = i;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        if (i <= this.eCt) {
            this.mProgress = i;
            this.aoo = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.eCt;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void onChangeSkinType() {
        am.i(this, d.f.feed_ad_progress_button_bg);
        this.mTextColor = am.getColor(d.C0140d.cp_link_tip_a);
        this.Ga = am.getColor(d.C0140d.cp_link_tip_a_alpha15);
    }
}
