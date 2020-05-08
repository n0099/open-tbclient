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
    private int aIm;
    private int aIn;
    private int aJC;
    private int jGi;
    private int jGj;
    private int jGk;
    private int jGl;
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
        this.jGi = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.jGj = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.jGk = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.aIm = obtainStyledAttributes.getColor(2, am.getColor(R.color.cp_cont_b));
        this.aIn = obtainStyledAttributes.getColor(3, am.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.jGj + this.jGi + this.jGk);
        setTextColor(this.aIm);
        this.jGl = l.getDimens(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.aJC = l.getDimens(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cCh();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.jGk) - this.jGi, this.mWidth - this.mMargin, this.mHeight - this.jGk);
        canvas.drawRoundRect(this.mRectF, this.aJC, this.aJC, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.aIm);
        } else {
            setTextColor(this.aIn);
        }
        invalidate();
    }

    private void cCh() {
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
        this.aIm = am.getColor(R.color.cp_cont_b);
        this.aIn = am.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.aIm);
        } else {
            setTextColor(this.aIn);
        }
        cCh();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.jGl) / 2;
    }
}
