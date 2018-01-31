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
/* loaded from: classes2.dex */
public class TextLineView extends TextView {
    private int epM;
    private int fWb;
    private int fWc;
    private int fWd;
    private int fWe;
    private int fWf;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.TextLineView);
        this.epM = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_height, 0);
        this.fWb = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_top_margin, 0);
        this.fWc = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_bottom_margin, 0);
        this.fWe = obtainStyledAttributes.getColor(d.l.TextLineView_text_selected_color, aj.getColor(d.C0108d.cp_cont_b));
        this.fWd = obtainStyledAttributes.getColor(d.l.TextLineView_text_unselected_color, aj.getColor(d.C0108d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.fWb + this.epM + this.fWc);
        setTextColor(this.fWe);
        this.fWf = l.s(context, d.e.ds56);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        beQ();
        int measuredWidth = (getMeasuredWidth() - this.fWf) / 2;
        canvas.drawRoundRect(new RectF(measuredWidth + 0, (getMeasuredHeight() - this.fWc) - this.epM, getMeasuredWidth() - measuredWidth, getMeasuredHeight() - this.fWc), l.s(getContext(), d.e.ds4), l.s(getContext(), d.e.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.fWe);
        } else {
            setTextColor(this.fWd);
        }
        invalidate();
    }

    private void beQ() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(aj.getColor(d.C0108d.cp_cont_f));
        } else {
            this.mPaint.setColor(aj.getColor(d.C0108d.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.fWe = aj.getColor(d.C0108d.cp_cont_b);
        this.fWd = aj.getColor(d.C0108d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.fWe);
        } else {
            setTextColor(this.fWd);
        }
        beQ();
        invalidate();
    }
}
