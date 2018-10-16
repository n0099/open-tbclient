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
    private Paint IF;
    private int IY;
    private Paint aBB;
    private float bmh;
    private int dyv;
    private int eRp;
    private int mProgress;
    private String mText;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bmh = 10.0f;
        this.eRp = 100;
        this.dyv = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.bmh = 10.0f;
        this.eRp = 100;
        this.dyv = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.feed_ad_progress);
        int color = getResources().getColor(e.d.cp_link_tip_a);
        int color2 = getResources().getColor(e.d.cp_link_tip_a_alpha15);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0175e.ds1);
        this.strokeWidth = getResources().getDimensionPixelSize(e.C0175e.ds1);
        this.IY = obtainStyledAttributes.getInteger(e.l.feed_ad_progress_btn_foreground, color2);
        this.mTextColor = obtainStyledAttributes.getColor(e.l.feed_ad_progress_btn_textColor, color);
        this.eRp = obtainStyledAttributes.getInteger(e.l.feed_ad_progress_btn_max, this.eRp);
        this.mProgress = obtainStyledAttributes.getInteger(e.l.feed_ad_progress_btn_progress, 0);
        this.mText = obtainStyledAttributes.getString(e.l.feed_ad_progress_btn_text);
        this.bmh = obtainStyledAttributes.getDimension(e.l.feed_ad_progress_btn_textSize, (int) getResources().getDimension(e.C0175e.fontsize24));
        this.dyv = obtainStyledAttributes.getDimensionPixelSize(e.l.feed_ad_progress_btn_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        initPaint();
    }

    private void initPaint() {
        this.IF = new Paint();
        this.aBB = new Paint();
        this.aBB.setAntiAlias(true);
        this.aBB.setTextSize(this.bmh);
        this.aBB.setColor(this.mTextColor);
        this.IF.setAntiAlias(true);
        this.IF.setStyle(Paint.Style.FILL);
        this.IF.setColor(this.IY);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            canvas.drawRoundRect(new RectF(this.strokeWidth, this.strokeWidth, ((getWidth() * this.mProgress) / this.eRp) - this.strokeWidth, getHeight() - this.strokeWidth), this.dyv, this.dyv, this.IF);
        }
        if (!TextUtils.isEmpty(this.mText)) {
            Paint.FontMetrics fontMetrics = this.aBB.getFontMetrics();
            canvas.drawText(this.mText, (getMeasuredWidth() - this.aBB.measureText(this.mText)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.aBB);
        }
    }

    public void setMax(int i) {
        this.eRp = i;
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
        this.IY = i;
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.bmh = i;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        if (i <= this.eRp) {
            this.mProgress = i;
            this.mText = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.eRp;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void onChangeSkinType() {
        al.i(this, e.f.feed_ad_progress_button_bg);
        this.mTextColor = al.getColor(e.d.cp_link_tip_a);
        this.IY = al.getColor(e.d.cp_link_tip_a_alpha15);
    }
}
