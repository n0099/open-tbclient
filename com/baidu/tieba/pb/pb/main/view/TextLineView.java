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
    private int fZi;
    private int fZj;
    private int fZk;
    private int fZl;
    private int fZm;
    private int fZn;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.TextLineView);
        this.fZi = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_height, 0);
        this.fZj = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_top_margin, 0);
        this.fZk = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_bottom_margin, 0);
        this.fZm = obtainStyledAttributes.getColor(d.l.TextLineView_text_selected_color, aj.getColor(d.C0140d.cp_cont_b));
        this.fZl = obtainStyledAttributes.getColor(d.l.TextLineView_text_unselected_color, aj.getColor(d.C0140d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.fZj + this.fZi + this.fZk);
        setTextColor(this.fZm);
        this.fZn = l.t(context, d.e.ds56);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bgq();
        int measuredWidth = (getMeasuredWidth() - this.fZn) / 2;
        canvas.drawRoundRect(new RectF(measuredWidth + 0, (getMeasuredHeight() - this.fZk) - this.fZi, getMeasuredWidth() - measuredWidth, getMeasuredHeight() - this.fZk), l.t(getContext(), d.e.ds4), l.t(getContext(), d.e.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.fZm);
        } else {
            setTextColor(this.fZl);
        }
        invalidate();
    }

    private void bgq() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(aj.getColor(d.C0140d.cp_cont_f));
        } else {
            this.mPaint.setColor(aj.getColor(d.C0140d.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.fZm = aj.getColor(d.C0140d.cp_cont_b);
        this.fZl = aj.getColor(d.C0140d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.fZm);
        } else {
            setTextColor(this.fZl);
        }
        bgq();
        invalidate();
    }
}
