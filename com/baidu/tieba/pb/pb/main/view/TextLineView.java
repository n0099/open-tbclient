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
    private int aqD;
    private int iUt;
    private int iUu;
    private int iUv;
    private int iUw;
    private int iUx;
    private int iUy;
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
        this.iUt = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.iUu = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.iUv = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.iUx = obtainStyledAttributes.getColor(2, am.getColor(R.color.cp_cont_b));
        this.iUw = obtainStyledAttributes.getColor(3, am.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.iUu + this.iUt + this.iUv);
        setTextColor(this.iUx);
        this.iUy = l.getDimens(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.aqD = l.getDimens(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        crj();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.iUv) - this.iUt, this.mWidth - this.mMargin, this.mHeight - this.iUv);
        canvas.drawRoundRect(this.mRectF, this.aqD, this.aqD, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.iUx);
        } else {
            setTextColor(this.iUw);
        }
        invalidate();
    }

    private void crj() {
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
        this.iUx = am.getColor(R.color.cp_cont_b);
        this.iUw = am.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.iUx);
        } else {
            setTextColor(this.iUw);
        }
        crj();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.iUy) / 2;
    }
}
