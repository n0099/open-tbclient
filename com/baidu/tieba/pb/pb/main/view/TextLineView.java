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
/* loaded from: classes6.dex */
public class TextLineView extends TextView {
    private int amx;
    private int iPh;
    private int iPi;
    private int iPj;
    private int iPk;
    private int iPl;
    private int iPm;
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
        this.iPh = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.iPi = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.iPj = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.iPl = obtainStyledAttributes.getColor(2, am.getColor(R.color.cp_cont_b));
        this.iPk = obtainStyledAttributes.getColor(3, am.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.iPi + this.iPh + this.iPj);
        setTextColor(this.iPl);
        this.iPm = l.getDimens(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.amx = l.getDimens(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        coH();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.iPj) - this.iPh, this.mWidth - this.mMargin, this.mHeight - this.iPj);
        canvas.drawRoundRect(this.mRectF, this.amx, this.amx, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.iPl);
        } else {
            setTextColor(this.iPk);
        }
        invalidate();
    }

    private void coH() {
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
        this.iPl = am.getColor(R.color.cp_cont_b);
        this.iPk = am.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.iPl);
        } else {
            setTextColor(this.iPk);
        }
        coH();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.iPm) / 2;
    }
}
