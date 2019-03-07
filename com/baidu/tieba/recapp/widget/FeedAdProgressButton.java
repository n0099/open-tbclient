package com.baidu.tieba.recapp.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes3.dex */
public class FeedAdProgressButton extends View {
    private Paint IQ;
    private int Ji;
    private String alI;
    private Paint bOB;
    private float cBV;
    private int gth;
    private RectF ioP;
    private Shader ioQ;
    private int mProgress;
    private int mRadius;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.cBV = 10.0f;
        this.gth = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.cBV = 10.0f;
        this.gth = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.feed_ad_progress);
        int color = getResources().getColor(d.C0236d.cp_link_tip_a);
        int color2 = getResources().getColor(d.C0236d.cp_link_tip_a_alpha50);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.tbds10);
        this.strokeWidth = getResources().getDimensionPixelSize(d.e.ds1);
        this.Ji = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_foreground, color2);
        this.mTextColor = obtainStyledAttributes.getColor(d.l.feed_ad_progress_btn_textColor, color);
        this.gth = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_max, this.gth);
        this.mProgress = obtainStyledAttributes.getInteger(d.l.feed_ad_progress_btn_progress, 0);
        this.alI = obtainStyledAttributes.getString(d.l.feed_ad_progress_btn_text);
        this.cBV = obtainStyledAttributes.getDimension(d.l.feed_ad_progress_btn_textSize, (int) getResources().getDimension(d.e.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(d.l.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        this.ioP = new RectF();
        qY();
    }

    private void qY() {
        this.IQ = new Paint();
        this.bOB = new Paint();
        this.bOB.setAntiAlias(true);
        this.bOB.setTextSize(this.cBV);
        this.bOB.setColor(this.mTextColor);
        this.IQ.setAntiAlias(true);
        this.IQ.setStyle(Paint.Style.FILL);
        this.IQ.setColor(this.Ji);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            aa(canvas);
        }
        if (!TextUtils.isEmpty(this.alI)) {
            Paint.FontMetrics fontMetrics = this.bOB.getFontMetrics();
            canvas.drawText(this.alI, (getMeasuredWidth() - this.bOB.measureText(this.alI)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.bOB);
        }
    }

    private void aa(Canvas canvas) {
        if (this.ioP == null) {
            this.ioP = new RectF();
        }
        this.ioP.left = this.strokeWidth;
        this.ioP.top = this.strokeWidth;
        this.ioP.right = getMeasuredWidth() - this.strokeWidth;
        this.ioP.bottom = getMeasuredHeight() - this.strokeWidth;
        float f = this.mProgress / (this.gth + 0.0f);
        this.ioQ = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.Ji, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP);
        this.IQ.setShader(this.ioQ);
        canvas.drawRoundRect(this.ioP, this.mRadius, this.mRadius, this.IQ);
    }

    public void setMax(int i) {
        this.gth = i;
    }

    public void setText(String str) {
        this.alI = str;
        this.mProgress = 0;
        postInvalidate();
    }

    public void setText(String str, int i) {
        this.alI = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.Ji = i;
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.cBV = i;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        if (i <= this.gth) {
            this.mProgress = i;
            this.alI = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.gth;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void onChangeSkinType() {
        al.k(this, d.f.feed_ad_progress_button_bg);
        this.mTextColor = al.getColor(d.C0236d.cp_link_tip_a);
        this.Ji = al.getColor(d.C0236d.cp_link_tip_a_alpha50);
    }

    public void bxV() {
        al.k(this, d.f.tail_frame_action_btn_bg);
        this.mTextColor = al.getColor(d.C0236d.cp_btn_a);
        this.bOB.setColor(this.mTextColor);
        postInvalidate();
    }
}
