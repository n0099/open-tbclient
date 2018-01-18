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
    private int epr;
    private int fVG;
    private int fVH;
    private int fVI;
    private int fVJ;
    private int fVK;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.TextLineView);
        this.epr = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_height, 0);
        this.fVG = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_top_margin, 0);
        this.fVH = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_bottom_margin, 0);
        this.fVJ = obtainStyledAttributes.getColor(d.l.TextLineView_text_selected_color, aj.getColor(d.C0107d.cp_cont_b));
        this.fVI = obtainStyledAttributes.getColor(d.l.TextLineView_text_unselected_color, aj.getColor(d.C0107d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.fVG + this.epr + this.fVH);
        setTextColor(this.fVJ);
        this.fVK = l.s(context, d.e.ds56);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        beL();
        int measuredWidth = (getMeasuredWidth() - this.fVK) / 2;
        canvas.drawRoundRect(new RectF(measuredWidth + 0, (getMeasuredHeight() - this.fVH) - this.epr, getMeasuredWidth() - measuredWidth, getMeasuredHeight() - this.fVH), l.s(getContext(), d.e.ds4), l.s(getContext(), d.e.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.fVJ);
        } else {
            setTextColor(this.fVI);
        }
        invalidate();
    }

    private void beL() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(aj.getColor(d.C0107d.cp_cont_f));
        } else {
            this.mPaint.setColor(aj.getColor(d.C0107d.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.fVJ = aj.getColor(d.C0107d.cp_cont_b);
        this.fVI = aj.getColor(d.C0107d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.fVJ);
        } else {
            setTextColor(this.fVI);
        }
        beL();
        invalidate();
    }
}
