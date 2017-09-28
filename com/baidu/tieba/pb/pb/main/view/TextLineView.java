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
    private int dkZ;
    private int eQo;
    private int eQp;
    private int eQq;
    private int eQr;
    private int eQs;
    private int mBottomLineColor;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.TextLineView);
        this.dkZ = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_height, 0);
        this.eQo = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_top_margin, 0);
        this.eQp = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_bottom_margin, 0);
        this.mBottomLineColor = obtainStyledAttributes.getColor(d.n.TextLineView_bottom_line_color, aj.getColor(d.e.cp_cont_f));
        this.eQr = obtainStyledAttributes.getColor(d.n.TextLineView_text_selected_color, aj.getColor(d.e.cp_cont_b));
        this.eQq = obtainStyledAttributes.getColor(d.n.TextLineView_text_unselected_color, aj.getColor(d.e.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.eQo + this.dkZ + this.eQp);
        setTextColor(this.eQr);
        this.eQs = l.f(context, d.f.ds56);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aST();
        int measuredWidth = (getMeasuredWidth() - this.eQs) / 2;
        canvas.drawRoundRect(new RectF(measuredWidth + 0, (getMeasuredHeight() - this.eQp) - this.dkZ, getMeasuredWidth() - measuredWidth, getMeasuredHeight() - this.eQp), l.f(getContext(), d.f.ds4), l.f(getContext(), d.f.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.eQr);
        } else {
            setTextColor(this.eQq);
        }
        invalidate();
    }

    private void aST() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(aj.getColor(d.e.cp_cont_f));
        } else {
            this.mPaint.setColor(aj.getColor(d.e.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.eQr = aj.getColor(d.e.cp_cont_b);
        this.eQq = aj.getColor(d.e.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.eQr);
        } else {
            setTextColor(this.eQq);
        }
        aST();
        invalidate();
    }
}
