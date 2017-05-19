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
    private int cHT;
    private int eqp;
    private int eqq;
    private int eqr;
    private int eqs;
    private int eqt;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.TextLineView);
        this.cHT = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.eqp = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.eqq = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.eqr = obtainStyledAttributes.getColor(1, aq.getColor(w.e.cp_cont_b));
        this.eqt = obtainStyledAttributes.getColor(2, aq.getColor(w.e.cp_cont_b));
        this.eqs = obtainStyledAttributes.getColor(3, aq.getColor(w.e.cp_cont_d));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.eqp + this.cHT + this.eqq);
        setTextColor(this.eqt);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aMu();
        canvas.drawRoundRect(new RectF(0.0f, (getMeasuredHeight() - this.eqq) - this.cHT, getMeasuredWidth(), getMeasuredHeight() - this.eqq), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.eqt);
        } else {
            setTextColor(this.eqs);
        }
        invalidate();
    }

    private void aMu() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(this.eqr);
        } else {
            this.mPaint.setColor(aq.getColor(w.e.transparent));
        }
    }
}
