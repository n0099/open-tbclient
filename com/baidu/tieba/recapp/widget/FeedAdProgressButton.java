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
import com.baidu.tieba.c;
@SuppressLint({"DrawAllocation"})
/* loaded from: classes3.dex */
public class FeedAdProgressButton extends View implements a {
    private Paint GG;
    private int Hc;
    private String amD;
    private Paint bXC;
    private float cLF;
    private int gRn;
    private RectF iOJ;
    private Shader iOK;
    private int mProgress;
    private int mRadius;
    private int mTextColor;
    private int strokeWidth;

    public FeedAdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.cLF = 10.0f;
        this.gRn = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        init(context, attributeSet);
    }

    public FeedAdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mTextColor = -1;
        this.cLF = 10.0f;
        this.gRn = 100;
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
        this.Hc = obtainStyledAttributes.getInteger(0, color2);
        this.mTextColor = obtainStyledAttributes.getColor(1, color);
        this.gRn = obtainStyledAttributes.getInteger(2, this.gRn);
        this.mProgress = obtainStyledAttributes.getInteger(3, 0);
        this.amD = obtainStyledAttributes.getString(5);
        this.cLF = obtainStyledAttributes.getDimension(4, (int) getResources().getDimension(R.dimen.fontsize24));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        this.iOJ = new RectF();
        qp();
    }

    private void qp() {
        this.GG = new Paint();
        this.bXC = new Paint();
        this.bXC.setAntiAlias(true);
        this.bXC.setTextSize(this.cLF);
        this.bXC.setColor(this.mTextColor);
        this.GG.setAntiAlias(true);
        this.GG.setStyle(Paint.Style.FILL);
        this.GG.setColor(this.Hc);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgress > 0) {
            ab(canvas);
        }
        if (!TextUtils.isEmpty(this.amD)) {
            Paint.FontMetrics fontMetrics = this.bXC.getFontMetrics();
            canvas.drawText(this.amD, (getMeasuredWidth() - this.bXC.measureText(this.amD)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.bXC);
        }
    }

    private void ab(Canvas canvas) {
        if (this.iOJ == null) {
            this.iOJ = new RectF();
        }
        this.iOJ.left = this.strokeWidth;
        this.iOJ.top = this.strokeWidth;
        this.iOJ.right = getMeasuredWidth() - this.strokeWidth;
        this.iOJ.bottom = getMeasuredHeight() - this.strokeWidth;
        float f = this.mProgress / (this.gRn + 0.0f);
        this.iOK = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.Hc, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP);
        this.GG.setShader(this.iOK);
        canvas.drawRoundRect(this.iOJ, this.mRadius, this.mRadius, this.GG);
    }

    public void setMax(int i) {
        this.gRn = i;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonText(String str) {
        this.amD = str;
        this.mProgress = 0;
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonText(String str, int i) {
        this.amD = str;
        this.mProgress = i;
        postInvalidate();
    }

    public void setForeground(int i) {
        this.Hc = i;
        postInvalidate();
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void setButtonTextSize(int i) {
        this.cLF = l.dip2px(getContext(), i);
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
        if (i <= this.gRn) {
            this.mProgress = i;
            this.amD = this.mProgress + "%";
            postInvalidate();
        }
    }

    public int getMax() {
        return this.gRn;
    }

    public int getProgress() {
        return this.mProgress;
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void onChangeSkinType() {
        am.k(this, R.drawable.feed_ad_progress_button_bg);
        this.mTextColor = am.getColor(R.color.cp_link_tip_a);
        this.Hc = am.getColor(R.color.cp_link_tip_a_alpha50);
    }

    @Override // com.baidu.tieba.recapp.widget.a
    public void bIz() {
        am.k(this, R.drawable.tail_frame_action_btn_bg);
        this.mTextColor = am.getColor(R.color.cp_btn_a);
        this.bXC.setColor(this.mTextColor);
        postInvalidate();
    }
}
