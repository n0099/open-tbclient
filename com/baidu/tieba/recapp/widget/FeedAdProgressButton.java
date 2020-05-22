package com.baidu.tieba.recapp.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes13.dex */
public class FeedAdProgressButton extends View implements a {
    private int kRi;
    private int kRj;
    private int kRk;
    private int kRl;
    private int kRm;
    private RectF kRn;
    private Shader kRo;
    private int mForegroundColor;
    private Paint mForegroundPaint;
    private int mMax;
    private int mProgress;
    private int mRadius;
    private String mText;
    private int mTextColor;
    private TextPaint mTextPaint;
    private float mTextSize;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kRi = R.color.cp_btn_a;
        this.kRj = R.color.cp_link_tip_a;
        this.kRk = R.color.cp_link_tip_a;
        this.kRl = R.drawable.ad_download_progress_button_bg;
        this.mProgress = 0;
        this.mTextColor = am.getColor(this.kRi);
        this.kRm = am.getColor(this.kRj);
        this.mTextSize = 10.0f;
        this.mForegroundColor = am.getColor(this.kRk);
        this.mMax = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kRi = R.color.cp_btn_a;
        this.kRj = R.color.cp_link_tip_a;
        this.kRk = R.color.cp_link_tip_a;
        this.kRl = R.drawable.ad_download_progress_button_bg;
        this.mProgress = 0;
        this.mTextColor = am.getColor(this.kRi);
        this.kRm = am.getColor(this.kRj);
        this.mTextSize = 10.0f;
        this.mForegroundColor = am.getColor(this.kRk);
        this.mMax = 100;
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
        this.kRm = obtainStyledAttributes.getColor(2, color);
        this.mMax = obtainStyledAttributes.getInteger(3, this.mMax);
        this.mProgress = obtainStyledAttributes.getInteger(4, 0);
        this.mText = obtainStyledAttributes.getString(6);
        this.mTextSize = obtainStyledAttributes.getDimension(5, (int) getResources().getDimension(R.dimen.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(7, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        this.kRn = new RectF();
        qy();
    }

    private void qy() {
        this.mForegroundPaint = new Paint();
        this.mForegroundPaint.setAntiAlias(true);
        this.mForegroundPaint.setStyle(Paint.Style.FILL);
        this.mForegroundPaint.setColor(this.mForegroundColor);
        Eu();
    }

    private void Eu() {
        if (this.mTextPaint == null) {
            this.mTextPaint = new TextPaint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setTextSize(this.mTextSize);
        }
        int i = this.mProgress > 0 ? this.mTextColor : this.kRm;
        if (i != this.mTextPaint.getColor()) {
            this.mTextPaint.setColor(i);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            u(canvas);
        }
        if (!TextUtils.isEmpty(this.mText)) {
            Eu();
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            canvas.drawText(this.mText, (getMeasuredWidth() - this.mTextPaint.measureText(this.mText)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.mTextPaint);
        }
    }

    private void u(Canvas canvas) {
        if (this.kRn == null) {
            this.kRn = new RectF();
        }
        this.kRn.left = this.strokeWidth;
        this.kRn.top = this.strokeWidth;
        this.kRn.right = getMeasuredWidth() - this.strokeWidth;
        this.kRn.bottom = getMeasuredHeight() - this.strokeWidth;
        float f = this.mProgress / (this.mMax + 0.0f);
        this.kRo = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.mForegroundColor, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP);
        this.mForegroundPaint.setShader(this.kRo);
        canvas.drawRoundRect(this.kRn, this.mRadius, this.mRadius, this.mForegroundPaint);
    }

    public void setMax(int i) {
        this.mMax = i;
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
        this.mTextSize = l.dip2px(getContext(), i);
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonTextColor(int i) {
        this.kRm = i;
        this.mTextColor = i;
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonTextNightColor(int i) {
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setProgress(int i) {
        if (i <= this.mMax) {
            this.mProgress = i;
            this.mText = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.mMax;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        this.kRj = i;
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        this.kRl = i;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void onChangeSkinType() {
        am.setBackgroundResource(this, this.kRl);
        this.mTextColor = am.getColor(this.kRi);
        this.kRm = am.getColor(this.kRj);
        this.mForegroundColor = am.getColor(this.kRk);
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void crm() {
        am.setBackgroundResource(this, this.kRl);
        this.mTextColor = am.getColor(this.kRi);
        this.kRm = am.getColor(this.kRj);
        this.mForegroundColor = am.getColor(this.kRk);
        postInvalidate();
    }
}
