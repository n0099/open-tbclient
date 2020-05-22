package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class TextLineView extends TextView {
    private int aNV;
    private int aNW;
    private int aPl;
    private int jXP;
    private int jXQ;
    private int jXR;
    private int jXS;
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
        this.jXP = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.jXQ = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.jXR = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.aNV = obtainStyledAttributes.getColor(2, am.getColor(R.color.cp_cont_b));
        this.aNW = obtainStyledAttributes.getColor(3, am.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.jXQ + this.jXP + this.jXR);
        setTextColor(this.aNV);
        this.jXS = l.getDimens(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.aPl = l.getDimens(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cJf();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.jXR) - this.jXP, this.mWidth - this.mMargin, this.mHeight - this.jXR);
        canvas.drawRoundRect(this.mRectF, this.aPl, this.aPl, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.aNV);
        } else {
            setTextColor(this.aNW);
        }
        invalidate();
    }

    private void cJf() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(am.getColor(R.color.cp_cont_f));
        } else {
            this.mPaint.setColor(am.getColor(R.color.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.aNV = am.getColor(R.color.cp_cont_b);
        this.aNW = am.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.aNV);
        } else {
            setTextColor(this.aNW);
        }
        cJf();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.jXS) / 2;
    }
}
