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
    private int dBR;
    private int fhg;
    private int fhh;
    private int fhi;
    private int fhj;
    private int fhk;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.TextLineView);
        this.dBR = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_height, 0);
        this.fhg = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_top_margin, 0);
        this.fhh = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_bottom_margin, 0);
        this.fhj = obtainStyledAttributes.getColor(d.l.TextLineView_text_selected_color, aj.getColor(d.C0095d.cp_cont_b));
        this.fhi = obtainStyledAttributes.getColor(d.l.TextLineView_text_unselected_color, aj.getColor(d.C0095d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.fhg + this.dBR + this.fhh);
        setTextColor(this.fhj);
        this.fhk = l.f(context, d.e.ds56);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aXr();
        int measuredWidth = (getMeasuredWidth() - this.fhk) / 2;
        canvas.drawRoundRect(new RectF(measuredWidth + 0, (getMeasuredHeight() - this.fhh) - this.dBR, getMeasuredWidth() - measuredWidth, getMeasuredHeight() - this.fhh), l.f(getContext(), d.e.ds4), l.f(getContext(), d.e.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.fhj);
        } else {
            setTextColor(this.fhi);
        }
        invalidate();
    }

    private void aXr() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(aj.getColor(d.C0095d.cp_cont_f));
        } else {
            this.mPaint.setColor(aj.getColor(d.C0095d.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.fhj = aj.getColor(d.C0095d.cp_cont_b);
        this.fhi = aj.getColor(d.C0095d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.fhj);
        } else {
            setTextColor(this.fhi);
        }
        aXr();
        invalidate();
    }
}
