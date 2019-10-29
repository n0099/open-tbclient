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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes3.dex */
public class FeedAdProgressButton extends View implements a {
    private Paint ajo;
    private float ath;
    private int dhV;
    private RectF iQd;
    private Shader iQe;
    private int mForegroundColor;
    private Paint mForegroundPaint;
    private int mProgress;
    private int mRadius;
    private String mText;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.ath = 10.0f;
        this.dhV = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.ath = 10.0f;
        this.dhV = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.feed_ad_progress);
        int color = getResources().getColor(R.color.cp_link_tip_a);
        int color2 = getResources().getColor(R.color.cp_link_tip_a_alpha50);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.strokeWidth = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mForegroundColor = obtainStyledAttributes.getInteger(0, color2);
        this.mTextColor = obtainStyledAttributes.getColor(1, color);
        this.dhV = obtainStyledAttributes.getInteger(2, this.dhV);
        this.mProgress = obtainStyledAttributes.getInteger(3, 0);
        this.mText = obtainStyledAttributes.getString(5);
        this.ath = obtainStyledAttributes.getDimension(4, (int) getResources().getDimension(R.dimen.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        this.iQd = new RectF();
        lj();
    }

    private void lj() {
        this.mForegroundPaint = new Paint();
        this.ajo = new Paint();
        this.ajo.setAntiAlias(true);
        this.ajo.setTextSize(this.ath);
        this.ajo.setColor(this.mTextColor);
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.mForegroundPaint.setColor(this.mForegroundColor);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            I(canvas);
        }
        if (!TextUtils.isEmpty(this.mText)) {
            Paint.FontMetrics fontMetrics = this.ajo.getFontMetrics();
            canvas.drawText(this.mText, (getMeasuredWidth() - this.ajo.measureText(this.mText)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.ajo);
        }
    }

    private void I(Canvas canvas) {
        if (this.iQd == null) {
            this.iQd = new RectF();
        }
        this.iQd.left = this.strokeWidth;
        this.iQd.top = this.strokeWidth;
        this.iQd.right = getMeasuredWidth() - this.strokeWidth;
        this.iQd.bottom = getMeasuredHeight() - this.strokeWidth;
        float f = this.mProgress / (this.dhV + 0.0f);
        this.iQe = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.mForegroundColor, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.iQe);
        canvas.drawRoundRect(this.iQd, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setMax(int i) {
        this.dhV = i;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonText(String str) {
        this.mText = str;
        this.mProgress = 0;
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonText(String str, int i) {
        this.mText = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.mForegroundColor = i;
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonTextSize(int i) {
        this.ath = l.dip2px(getContext(), i);
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonTextColor(int i) {
        this.mTextColor = i;
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonTextNightColor(int i) {
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setProgress(int i) {
        if (i <= this.dhV) {
            this.mProgress = i;
            this.mText = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.dhV;
    }

    public int getProgress() {
        return this.mProgress;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void onChangeSkinType() {
        am.setBackgroundResource(this, R.drawable.feed_ad_progress_button_bg);
        this.mTextColor = am.getColor(R.color.cp_link_tip_a);
        this.mForegroundColor = am.getColor(R.color.cp_link_tip_a_alpha50);
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void bnq() {
        am.setBackgroundResource(this, R.drawable.tail_frame_action_btn_bg);
        this.mTextColor = am.getColor(R.color.cp_cont_a);
        this.ajo.setColor(this.mTextColor);
        postInvalidate();
    }
}
