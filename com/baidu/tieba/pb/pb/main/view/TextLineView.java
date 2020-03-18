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
    private int aqN;
    private int iVU;
    private int iVV;
    private int iVW;
    private int iVX;
    private int iVY;
    private int iVZ;
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
        this.iVU = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.iVV = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.iVW = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.iVY = obtainStyledAttributes.getColor(2, am.getColor(R.color.cp_cont_b));
        this.iVX = obtainStyledAttributes.getColor(3, am.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.iVV + this.iVU + this.iVW);
        setTextColor(this.iVY);
        this.iVZ = l.getDimens(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.aqN = l.getDimens(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        crE();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.iVW) - this.iVU, this.mWidth - this.mMargin, this.mHeight - this.iVW);
        canvas.drawRoundRect(this.mRectF, this.aqN, this.aqN, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.iVY);
        } else {
            setTextColor(this.iVX);
        }
        invalidate();
    }

    private void crE() {
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
        this.iVY = am.getColor(R.color.cp_cont_b);
        this.iVX = am.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.iVY);
        } else {
            setTextColor(this.iVX);
        }
        crE();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.iVZ) / 2;
    }
}
