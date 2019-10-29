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
/* loaded from: classes4.dex */
public class TextLineView extends TextView {
    private int aeP;
    private int iaN;
    private int iaO;
    private int iaP;
    private int iaQ;
    private int iaR;
    private int iaS;
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
        this.iaN = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.iaO = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.iaP = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.iaR = obtainStyledAttributes.getColor(2, am.getColor(R.color.cp_cont_b));
        this.iaQ = obtainStyledAttributes.getColor(3, am.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.iaO + this.iaN + this.iaP);
        setTextColor(this.iaR);
        this.iaS = l.getDimens(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.aeP = l.getDimens(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bWR();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.iaP) - this.iaN, this.mWidth - this.mMargin, this.mHeight - this.iaP);
        canvas.drawRoundRect(this.mRectF, this.aeP, this.aeP, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.iaR);
        } else {
            setTextColor(this.iaQ);
        }
        invalidate();
    }

    private void bWR() {
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
        this.iaR = am.getColor(R.color.cp_cont_b);
        this.iaQ = am.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.iaR);
        } else {
            setTextColor(this.iaQ);
        }
        bWR();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.iaS) / 2;
    }
}
