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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class TextLineView extends TextView {
    private int DS4;
    private int fFO;
    private int fFP;
    private int fFQ;
    private int fFR;
    private int fFS;
    private int fFT;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.TextLineView);
        this.fFO = obtainStyledAttributes.getDimensionPixelSize(d.m.TextLineView_bottom_line_height, 0);
        this.fFP = obtainStyledAttributes.getDimensionPixelSize(d.m.TextLineView_bottom_line_top_margin, 0);
        this.fFQ = obtainStyledAttributes.getDimensionPixelSize(d.m.TextLineView_bottom_line_bottom_margin, 0);
        this.fFS = obtainStyledAttributes.getColor(d.m.TextLineView_text_selected_color, al.getColor(d.C0141d.cp_cont_b));
        this.fFR = obtainStyledAttributes.getColor(d.m.TextLineView_text_unselected_color, al.getColor(d.C0141d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.fFP + this.fFO + this.fFQ);
        setTextColor(this.fFS);
        this.fFT = l.e(context, d.e.ds56);
        this.mRectF = new RectF();
        this.DS4 = l.e(getContext(), d.e.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bgn();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.fFQ) - this.fFO, this.mWidth - this.mMargin, this.mHeight - this.fFQ);
        canvas.drawRoundRect(this.mRectF, this.DS4, this.DS4, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.fFS);
        } else {
            setTextColor(this.fFR);
        }
        invalidate();
    }

    private void bgn() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(al.getColor(d.C0141d.cp_cont_f));
        } else {
            this.mPaint.setColor(al.getColor(d.C0141d.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.fFS = al.getColor(d.C0141d.cp_cont_b);
        this.fFR = al.getColor(d.C0141d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.fFS);
        } else {
            setTextColor(this.fFR);
        }
        bgn();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.fFT) / 2;
    }
}
