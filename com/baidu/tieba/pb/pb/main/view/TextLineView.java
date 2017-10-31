package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TextLineView extends TextView {
    private int dsC;
    private int eYP;
    private int eYQ;
    private int eYR;
    private int eYS;
    private int eYT;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.TextLineView);
        this.dsC = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_height, 0);
        this.eYP = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_top_margin, 0);
        this.eYQ = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_bottom_margin, 0);
        this.eYS = obtainStyledAttributes.getColor(d.l.TextLineView_text_selected_color, aj.getColor(d.C0080d.cp_cont_b));
        this.eYR = obtainStyledAttributes.getColor(d.l.TextLineView_text_unselected_color, aj.getColor(d.C0080d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.eYP + this.dsC + this.eYQ);
        setTextColor(this.eYS);
        this.eYT = l.f(context, d.e.ds56);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aWc();
        int measuredWidth = (getMeasuredWidth() - this.eYT) / 2;
        canvas.drawRoundRect(new RectF(measuredWidth + 0, (getMeasuredHeight() - this.eYQ) - this.dsC, getMeasuredWidth() - measuredWidth, getMeasuredHeight() - this.eYQ), l.f(getContext(), d.e.ds4), l.f(getContext(), d.e.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.eYS);
        } else {
            setTextColor(this.eYR);
        }
        invalidate();
    }

    private void aWc() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(aj.getColor(d.C0080d.cp_cont_f));
        } else {
            this.mPaint.setColor(aj.getColor(d.C0080d.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.eYS = aj.getColor(d.C0080d.cp_cont_b);
        this.eYR = aj.getColor(d.C0080d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.eYS);
        } else {
            setTextColor(this.eYR);
        }
        aWc();
        invalidate();
    }
}
