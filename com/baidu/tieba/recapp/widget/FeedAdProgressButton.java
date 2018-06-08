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
import com.baidu.tieba.d;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes3.dex */
public class FeedAdProgressButton extends View {
    private Paint FI;
    private int Ga;
    private String aon;
    private float bdh;
    private int euL;
    private Paint gqN;
    private int mProgress;
    private int mRadius;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bdh = 10.0f;
        this.euL = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bdh = 10.0f;
        this.euL = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.feed_ad_progress);
        int color = getResources().getColor(d.C0141d.cp_link_tip_a);
        int color2 = getResources().getColor(d.C0141d.cp_link_tip_a_alpha15);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds1);
        this.strokeWidth = getResources().getDimensionPixelSize(d.e.ds1);
        this.Ga = obtainStyledAttributes.getInteger(d.m.feed_ad_progress_btn_foreground, color2);
        this.mTextColor = obtainStyledAttributes.getColor(d.m.feed_ad_progress_btn_textColor, color);
        this.euL = obtainStyledAttributes.getInteger(d.m.feed_ad_progress_btn_max, this.euL);
        this.mProgress = obtainStyledAttributes.getInteger(d.m.feed_ad_progress_btn_progress, 0);
        this.aon = obtainStyledAttributes.getString(d.m.feed_ad_progress_btn_text);
        this.bdh = obtainStyledAttributes.getDimension(d.m.feed_ad_progress_btn_textSize, (int) getResources().getDimension(d.e.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(d.m.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        initPaint();
    }

    private void initPaint() {
        this.FI = new Paint();
        this.gqN = new Paint();
        this.gqN.setAntiAlias(true);
        this.gqN.setTextSize(this.bdh);
        this.gqN.setColor(this.mTextColor);
        this.FI.setAntiAlias(true);
        this.FI.setStyle(Paint.Style.FILL);
        this.FI.setColor(this.Ga);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            canvas.drawRoundRect(new RectF(this.strokeWidth, this.strokeWidth, ((getWidth() * this.mProgress) / this.euL) - this.strokeWidth, getHeight() - this.strokeWidth), this.mRadius, this.mRadius, this.FI);
        }
        if (!TextUtils.isEmpty(this.aon)) {
            Paint.FontMetrics fontMetrics = this.gqN.getFontMetrics();
            canvas.drawText(this.aon, (getMeasuredWidth() - this.gqN.measureText(this.aon)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.gqN);
        }
    }

    public void setMax(int i) {
        this.euL = i;
    }

    public void setText(String str) {
        this.aon = str;
        this.mProgress = 0;
        postInvalidate();
    }

    public void setText(String str, int i) {
        this.aon = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.Ga = i;
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.bdh = i;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        if (i <= this.euL) {
            this.mProgress = i;
            this.aon = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.euL;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void onChangeSkinType() {
        al.i(this, d.f.feed_ad_progress_button_bg);
        this.mTextColor = al.getColor(d.C0141d.cp_link_tip_a);
        this.Ga = al.getColor(d.C0141d.cp_link_tip_a_alpha15);
    }
}
