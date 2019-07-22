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
import com.baidu.tieba.c;
/* loaded from: classes4.dex */
public class TextLineView extends TextView {
    private int DS4;
    private int dYN;
    private int hZm;
    private int hZn;
    private int hZo;
    private int hZp;
    private int hZq;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.TextLineView);
        this.hZm = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.hZn = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.hZo = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.hZq = obtainStyledAttributes.getColor(2, am.getColor(R.color.cp_cont_b));
        this.hZp = obtainStyledAttributes.getColor(3, am.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.hZn + this.hZm + this.hZo);
        setTextColor(this.hZq);
        this.dYN = l.g(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.DS4 = l.g(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bYK();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.hZo) - this.hZm, this.mWidth - this.mMargin, this.mHeight - this.hZo);
        canvas.drawRoundRect(this.mRectF, this.DS4, this.DS4, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.hZq);
        } else {
            setTextColor(this.hZp);
        }
        invalidate();
    }

    private void bYK() {
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
        this.hZq = am.getColor(R.color.cp_cont_b);
        this.hZp = am.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.hZq);
        } else {
            setTextColor(this.hZp);
        }
        bYK();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.dYN) / 2;
    }
}
