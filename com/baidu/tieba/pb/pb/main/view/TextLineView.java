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
    private int dAJ;
    private int fgd;
    private int fge;
    private int fgf;
    private int fgg;
    private int fgh;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.TextLineView);
        this.dAJ = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_height, 0);
        this.fgd = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_top_margin, 0);
        this.fge = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_bottom_margin, 0);
        this.fgg = obtainStyledAttributes.getColor(d.l.TextLineView_text_selected_color, aj.getColor(d.C0082d.cp_cont_b));
        this.fgf = obtainStyledAttributes.getColor(d.l.TextLineView_text_unselected_color, aj.getColor(d.C0082d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.fgd + this.dAJ + this.fge);
        setTextColor(this.fgg);
        this.fgh = l.f(context, d.e.ds56);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aXj();
        int measuredWidth = (getMeasuredWidth() - this.fgh) / 2;
        canvas.drawRoundRect(new RectF(measuredWidth + 0, (getMeasuredHeight() - this.fge) - this.dAJ, getMeasuredWidth() - measuredWidth, getMeasuredHeight() - this.fge), l.f(getContext(), d.e.ds4), l.f(getContext(), d.e.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.fgg);
        } else {
            setTextColor(this.fgf);
        }
        invalidate();
    }

    private void aXj() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(aj.getColor(d.C0082d.cp_cont_f));
        } else {
            this.mPaint.setColor(aj.getColor(d.C0082d.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.fgg = aj.getColor(d.C0082d.cp_cont_b);
        this.fgf = aj.getColor(d.C0082d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.fgg);
        } else {
            setTextColor(this.fgf);
        }
        aXj();
        invalidate();
    }
}
