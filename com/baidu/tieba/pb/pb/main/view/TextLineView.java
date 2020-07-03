package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class TextLineView extends TextView {
    private int aQB;
    private int aQC;
    private int aRR;
    private int ksN;
    private int ksO;
    private int ksP;
    private int ksQ;
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
        this.ksN = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.ksO = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.ksP = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.aQB = obtainStyledAttributes.getColor(2, an.getColor(R.color.cp_cont_b));
        this.aQC = obtainStyledAttributes.getColor(3, an.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.ksO + this.ksN + this.ksP);
        setTextColor(this.aQB);
        this.ksQ = l.getDimens(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.aRR = l.getDimens(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cNM();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.ksP) - this.ksN, this.mWidth - this.mMargin, this.mHeight - this.ksP);
        canvas.drawRoundRect(this.mRectF, this.aRR, this.aRR, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.aQB);
        } else {
            setTextColor(this.aQC);
        }
        invalidate();
    }

    private void cNM() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(an.getColor(R.color.cp_cont_f));
        } else {
            this.mPaint.setColor(an.getColor(R.color.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.aQB = an.getColor(R.color.cp_cont_b);
        this.aQC = an.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.aQB);
        } else {
            setTextColor(this.aQC);
        }
        cNM();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.ksQ) / 2;
    }
}
