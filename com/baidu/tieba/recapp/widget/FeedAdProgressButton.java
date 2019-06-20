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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.c;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes3.dex */
public class FeedAdProgressButton extends View implements a {
    private int GP;
    private Paint Gy;
    private String ama;
    private Paint bWu;
    private float cKe;
    private int gKl;
    private RectF iHn;
    private Shader iHo;
    private int mProgress;
    private int mRadius;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.cKe = 10.0f;
        this.gKl = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.cKe = 10.0f;
        this.gKl = 100;
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
        this.GP = obtainStyledAttributes.getInteger(0, color2);
        this.mTextColor = obtainStyledAttributes.getColor(1, color);
        this.gKl = obtainStyledAttributes.getInteger(2, this.gKl);
        this.mProgress = obtainStyledAttributes.getInteger(3, 0);
        this.ama = obtainStyledAttributes.getString(5);
        this.cKe = obtainStyledAttributes.getDimension(4, (int) getResources().getDimension(R.dimen.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        this.iHn = new RectF();
        pT();
    }

    private void pT() {
        this.Gy = new Paint();
        this.bWu = new Paint();
        this.bWu.setAntiAlias(true);
        this.bWu.setTextSize(this.cKe);
        this.bWu.setColor(this.mTextColor);
        this.Gy.setAntiAlias(true);
        this.Gy.setStyle(Paint.Style.FILL);
        this.Gy.setColor(this.GP);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            ab(canvas);
        }
        if (!TextUtils.isEmpty(this.ama)) {
            Paint.FontMetrics fontMetrics = this.bWu.getFontMetrics();
            canvas.drawText(this.ama, (getMeasuredWidth() - this.bWu.measureText(this.ama)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.bWu);
        }
    }

    private void ab(Canvas canvas) {
        if (this.iHn == null) {
            this.iHn = new RectF();
        }
        this.iHn.left = this.strokeWidth;
        this.iHn.top = this.strokeWidth;
        this.iHn.right = getMeasuredWidth() - this.strokeWidth;
        this.iHn.bottom = getMeasuredHeight() - this.strokeWidth;
        float f = this.mProgress / (this.gKl + 0.0f);
        this.iHo = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.GP, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP);
        this.Gy.setShader(this.iHo);
        canvas.drawRoundRect(this.iHn, this.mRadius, this.mRadius, this.Gy);
    }

    public void setMax(int i) {
        this.gKl = i;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonText(String str) {
        this.ama = str;
        this.mProgress = 0;
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonText(String str, int i) {
        this.ama = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.GP = i;
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonTextSize(int i) {
        this.cKe = l.dip2px(getContext(), i);
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
        if (i <= this.gKl) {
            this.mProgress = i;
            this.ama = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.gKl;
    }

    public int getProgress() {
        return this.mProgress;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void onChangeSkinType() {
        al.k(this, R.drawable.feed_ad_progress_button_bg);
        this.mTextColor = al.getColor(R.color.cp_link_tip_a);
        this.GP = al.getColor(R.color.cp_link_tip_a_alpha50);
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void bFE() {
        al.k(this, R.drawable.tail_frame_action_btn_bg);
        this.mTextColor = al.getColor(R.color.cp_btn_a);
        this.bWu.setColor(this.mTextColor);
        postInvalidate();
    }
}
