package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class TextLineView extends TextView {
    private int cNr;
    private int exA;
    private int exB;
    private int exC;
    private int exD;
    private int exz;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.TextLineView);
        this.cNr = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.exz = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.exA = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.exB = obtainStyledAttributes.getColor(1, aq.getColor(w.e.cp_cont_b));
        this.exD = obtainStyledAttributes.getColor(2, aq.getColor(w.e.cp_cont_b));
        this.exC = obtainStyledAttributes.getColor(3, aq.getColor(w.e.cp_cont_d));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.exz + this.cNr + this.exA);
        setTextColor(this.exD);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aND();
        canvas.drawRoundRect(new RectF(0.0f, (getMeasuredHeight() - this.exA) - this.cNr, getMeasuredWidth(), getMeasuredHeight() - this.exA), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.exD);
        } else {
            setTextColor(this.exC);
        }
        invalidate();
    }

    private void aND() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(this.exB);
        } else {
            this.mPaint.setColor(aq.getColor(w.e.transparent));
        }
    }
}
