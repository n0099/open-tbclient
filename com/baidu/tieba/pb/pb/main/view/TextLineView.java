package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes4.dex */
public class TextLineView extends TextView {
    private int DS4;
    private int dUV;
    private int hSY;
    private int hSZ;
    private int hTa;
    private int hTb;
    private int hTc;
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
        this.hSY = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.hSZ = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.hTa = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.hTc = obtainStyledAttributes.getColor(2, al.getColor(R.color.cp_cont_b));
        this.hTb = obtainStyledAttributes.getColor(3, al.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.hSZ + this.hSY + this.hTa);
        setTextColor(this.hTc);
        this.dUV = l.g(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.DS4 = l.g(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bVV();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.hTa) - this.hSY, this.mWidth - this.mMargin, this.mHeight - this.hTa);
        canvas.drawRoundRect(this.mRectF, this.DS4, this.DS4, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.hTc);
        } else {
            setTextColor(this.hTb);
        }
        invalidate();
    }

    private void bVV() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(al.getColor(R.color.cp_cont_f));
        } else {
            this.mPaint.setColor(al.getColor(R.color.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.hTc = al.getColor(R.color.cp_cont_b);
        this.hTb = al.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.hTc);
        } else {
            setTextColor(this.hTb);
        }
        bVV();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.dUV) / 2;
    }
}
