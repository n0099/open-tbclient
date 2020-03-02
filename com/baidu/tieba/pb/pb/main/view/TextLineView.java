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
    private int aqC;
    private int iUh;
    private int iUi;
    private int iUj;
    private int iUk;
    private int iUl;
    private int iUm;
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
        this.iUh = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.iUi = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.iUj = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.iUl = obtainStyledAttributes.getColor(2, am.getColor(R.color.cp_cont_b));
        this.iUk = obtainStyledAttributes.getColor(3, am.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.iUi + this.iUh + this.iUj);
        setTextColor(this.iUl);
        this.iUm = l.getDimens(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.aqC = l.getDimens(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cri();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.iUj) - this.iUh, this.mWidth - this.mMargin, this.mHeight - this.iUj);
        canvas.drawRoundRect(this.mRectF, this.aqC, this.aqC, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.iUl);
        } else {
            setTextColor(this.iUk);
        }
        invalidate();
    }

    private void cri() {
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
        this.iUl = am.getColor(R.color.cp_cont_b);
        this.iUk = am.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.iUl);
        } else {
            setTextColor(this.iUk);
        }
        cri();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.iUm) / 2;
    }
}
