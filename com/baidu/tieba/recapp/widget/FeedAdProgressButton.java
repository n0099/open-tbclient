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
    private Paint Id;
    private int Iv;
    private String aqV;
    private Paint awR;
    private float bia;
    private int dqu;
    private int eJG;
    private int mProgress;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bia = 10.0f;
        this.eJG = 100;
        this.dqu = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bia = 10.0f;
        this.eJG = 100;
        this.dqu = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.feed_ad_progress);
        int color = getResources().getColor(e.d.cp_link_tip_a);
        int color2 = getResources().getColor(e.d.cp_link_tip_a_alpha15);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0141e.ds1);
        this.strokeWidth = getResources().getDimensionPixelSize(e.C0141e.ds1);
        this.Iv = obtainStyledAttributes.getInteger(e.l.feed_ad_progress_btn_foreground, color2);
        this.mTextColor = obtainStyledAttributes.getColor(e.l.feed_ad_progress_btn_textColor, color);
        this.eJG = obtainStyledAttributes.getInteger(e.l.feed_ad_progress_btn_max, this.eJG);
        this.mProgress = obtainStyledAttributes.getInteger(e.l.feed_ad_progress_btn_progress, 0);
        this.aqV = obtainStyledAttributes.getString(e.l.feed_ad_progress_btn_text);
        this.bia = obtainStyledAttributes.getDimension(e.l.feed_ad_progress_btn_textSize, (int) getResources().getDimension(e.C0141e.fontsize24));
        this.dqu = obtainStyledAttributes.getDimensionPixelSize(e.l.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        pN();
    }

    private void pN() {
        this.Id = new Paint();
        this.awR = new Paint();
        this.awR.setAntiAlias(true);
        this.awR.setTextSize(this.bia);
        this.awR.setColor(this.mTextColor);
        this.Id.setAntiAlias(true);
        this.Id.setStyle(Paint.Style.FILL);
        this.Id.setColor(this.Iv);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            canvas.drawRoundRect(new RectF(this.strokeWidth, this.strokeWidth, ((getWidth() * this.mProgress) / this.eJG) - this.strokeWidth, getHeight() - this.strokeWidth), this.dqu, this.dqu, this.Id);
        }
        if (!TextUtils.isEmpty(this.aqV)) {
            Paint.FontMetrics fontMetrics = this.awR.getFontMetrics();
            canvas.drawText(this.aqV, (getMeasuredWidth() - this.awR.measureText(this.aqV)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.awR);
        }
    }

    public void setMax(int i) {
        this.eJG = i;
    }

    public void setText(String str) {
        this.aqV = str;
        this.mProgress = 0;
        postInvalidate();
    }

    public void setText(String str, int i) {
        this.aqV = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.Iv = i;
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.bia = i;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        if (i <= this.eJG) {
            this.mProgress = i;
            this.aqV = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.eJG;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void onChangeSkinType() {
        al.i(this, e.f.feed_ad_progress_button_bg);
        this.mTextColor = al.getColor(e.d.cp_link_tip_a);
        this.Iv = al.getColor(e.d.cp_link_tip_a_alpha15);
    }
}
