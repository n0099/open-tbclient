package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class TextLineView extends TextView {
    private int bWc;
    private int bWd;
    private int bjV;
    private int lVT;
    private int lVU;
    private int lVV;
    private int lVW;
    private int mHeight;
    private int mMargin;
    private Paint mPaint;
    private RectF mRectF;
    private int mWidth;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextLineView);
        this.lVT = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_height, 0);
        this.lVU = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_top_margin, 0);
        this.lVV = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_bottom_margin, 0);
        this.bWc = obtainStyledAttributes.getColor(R.styleable.TextLineView_text_selected_color, ap.getColor(R.color.CAM_X0105));
        this.bWd = obtainStyledAttributes.getColor(R.styleable.TextLineView_text_unselected_color, ap.getColor(R.color.CAM_X0108));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.lVU + this.lVT + this.lVV);
        setTextColor(this.bWc);
        this.lVW = l.getDimens(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.bjV = l.getDimens(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dug();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.lVV) - this.lVT, this.mWidth - this.mMargin, this.mHeight - this.lVV);
        canvas.drawRoundRect(this.mRectF, this.bjV, this.bjV, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        setTextSelectedUI(z);
        invalidate();
    }

    private void dug() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(ap.getColor(R.color.transparent));
        } else {
            this.mPaint.setColor(ap.getColor(R.color.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        setTextSelectedUI(isSelected());
        dug();
        invalidate();
    }

    private void setTextSelectedUI(boolean z) {
        if (z) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this).ps(R.color.CAM_X0105).pu(R.string.F_X02);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bm(this).ps(R.color.CAM_X0108).pu(R.string.F_X01);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.lVW) / 2;
    }
}
