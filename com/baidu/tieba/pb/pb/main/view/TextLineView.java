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
    private int dsW;
    private int eZk;
    private int eZl;
    private int eZm;
    private int eZn;
    private int eZo;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.TextLineView);
        this.dsW = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_height, 0);
        this.eZk = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_top_margin, 0);
        this.eZl = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_bottom_margin, 0);
        this.eZn = obtainStyledAttributes.getColor(d.l.TextLineView_text_selected_color, aj.getColor(d.C0080d.cp_cont_b));
        this.eZm = obtainStyledAttributes.getColor(d.l.TextLineView_text_unselected_color, aj.getColor(d.C0080d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.eZk + this.dsW + this.eZl);
        setTextColor(this.eZn);
        this.eZo = l.f(context, d.e.ds56);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aWk();
        int measuredWidth = (getMeasuredWidth() - this.eZo) / 2;
        canvas.drawRoundRect(new RectF(measuredWidth + 0, (getMeasuredHeight() - this.eZl) - this.dsW, getMeasuredWidth() - measuredWidth, getMeasuredHeight() - this.eZl), l.f(getContext(), d.e.ds4), l.f(getContext(), d.e.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.eZn);
        } else {
            setTextColor(this.eZm);
        }
        invalidate();
    }

    private void aWk() {
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
        this.eZn = aj.getColor(d.C0080d.cp_cont_b);
        this.eZm = aj.getColor(d.C0080d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.eZn);
        } else {
            setTextColor(this.eZm);
        }
        aWk();
        invalidate();
    }
}
