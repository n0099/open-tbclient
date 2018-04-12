package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class TextLineView extends TextView {
    private int ftt;
    private int ftu;
    private int ftv;
    private int ftw;
    private int ftx;
    private int fty;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.TextLineView);
        this.ftt = obtainStyledAttributes.getDimensionPixelSize(d.m.TextLineView_bottom_line_height, 0);
        this.ftu = obtainStyledAttributes.getDimensionPixelSize(d.m.TextLineView_bottom_line_top_margin, 0);
        this.ftv = obtainStyledAttributes.getDimensionPixelSize(d.m.TextLineView_bottom_line_bottom_margin, 0);
        this.ftx = obtainStyledAttributes.getColor(d.m.TextLineView_text_selected_color, ak.getColor(d.C0126d.cp_cont_b));
        this.ftw = obtainStyledAttributes.getColor(d.m.TextLineView_text_unselected_color, ak.getColor(d.C0126d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.ftu + this.ftt + this.ftv);
        setTextColor(this.ftx);
        this.fty = l.e(context, d.e.ds56);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bbo();
        int measuredWidth = (getMeasuredWidth() - this.fty) / 2;
        canvas.drawRoundRect(new RectF(measuredWidth + 0, (getMeasuredHeight() - this.ftv) - this.ftt, getMeasuredWidth() - measuredWidth, getMeasuredHeight() - this.ftv), l.e(getContext(), d.e.ds4), l.e(getContext(), d.e.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.ftx);
        } else {
            setTextColor(this.ftw);
        }
        invalidate();
    }

    private void bbo() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(ak.getColor(d.C0126d.cp_cont_f));
        } else {
            this.mPaint.setColor(ak.getColor(d.C0126d.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.ftx = ak.getColor(d.C0126d.cp_cont_b);
        this.ftw = ak.getColor(d.C0126d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.ftx);
        } else {
            setTextColor(this.ftw);
        }
        bbo();
        invalidate();
    }
}
