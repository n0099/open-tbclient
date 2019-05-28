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
import com.baidu.tieba.R;
import com.baidu.tieba.c;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes3.dex */
public class FeedAdProgressButton extends View {
    private int GQ;
    private Paint Gz;
    private String ama;
    private Paint bWt;
    private float cKd;
    private int gKj;
    private RectF iHk;
    private Shader iHl;
    private int mProgress;
    private int mRadius;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.cKd = 10.0f;
        this.gKj = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.cKd = 10.0f;
        this.gKj = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.feed_ad_progress);
        int color = getResources().getColor(R.color.cp_link_tip_a);
        int color2 = getResources().getColor(R.color.cp_link_tip_a_alpha50);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.GQ = obtainStyledAttributes.getInteger(0, color2);
        this.mTextColor = obtainStyledAttributes.getColor(1, color);
        this.gKj = obtainStyledAttributes.getInteger(2, this.gKj);
        this.mProgress = obtainStyledAttributes.getInteger(3, 0);
        this.ama = obtainStyledAttributes.getString(5);
        this.cKd = obtainStyledAttributes.getDimension(4, (int) getResources().getDimension(R.dimen.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        this.iHk = new RectF();
        pT();
    }

    private void pT() {
        this.Gz = new Paint();
        this.bWt = new Paint();
        this.bWt.setAntiAlias(true);
        this.bWt.setTextSize(this.cKd);
        this.bWt.setColor(this.mTextColor);
        this.Gz.setAntiAlias(true);
        this.Gz.setStyle(Paint.Style.FILL);
        this.Gz.setColor(this.GQ);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            ab(canvas);
        }
        if (!TextUtils.isEmpty(this.ama)) {
            Paint.FontMetrics fontMetrics = this.bWt.getFontMetrics();
            canvas.drawText(this.ama, (getMeasuredWidth() - this.bWt.measureText(this.ama)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.bWt);
        }
    }

    private void ab(Canvas canvas) {
        if (this.iHk == null) {
            this.iHk = new RectF();
        }
        this.iHk.left = this.strokeWidth;
        this.iHk.top = this.strokeWidth;
        this.iHk.right = getMeasuredWidth() - this.strokeWidth;
        this.iHk.bottom = getMeasuredHeight() - this.strokeWidth;
        float f = this.mProgress / (this.gKj + 0.0f);
        this.iHl = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.GQ, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP);
        this.Gz.setShader(this.iHl);
        canvas.drawRoundRect(this.iHk, this.mRadius, this.mRadius, this.Gz);
    }

    public void setMax(int i) {
        this.gKj = i;
    }

    public void setText(String str) {
        this.ama = str;
        this.mProgress = 0;
        postInvalidate();
    }

    public void setText(String str, int i) {
        this.ama = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.GQ = i;
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.cKd = i;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        if (i <= this.gKj) {
            this.mProgress = i;
            this.ama = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.gKj;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void onChangeSkinType() {
        al.k(this, R.drawable.feed_ad_progress_button_bg);
        this.mTextColor = al.getColor(R.color.cp_link_tip_a);
        this.GQ = al.getColor(R.color.cp_link_tip_a_alpha50);
    }

    public void bFD() {
        al.k(this, R.drawable.tail_frame_action_btn_bg);
        this.mTextColor = al.getColor(R.color.cp_btn_a);
        this.bWt.setColor(this.mTextColor);
        postInvalidate();
    }
}
