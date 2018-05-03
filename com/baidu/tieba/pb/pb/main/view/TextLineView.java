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
    private int ftq;
    private int ftr;
    private int fts;
    private int ftt;
    private int ftu;
    private int ftv;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.TextLineView);
        this.ftq = obtainStyledAttributes.getDimensionPixelSize(d.m.TextLineView_bottom_line_height, 0);
        this.ftr = obtainStyledAttributes.getDimensionPixelSize(d.m.TextLineView_bottom_line_top_margin, 0);
        this.fts = obtainStyledAttributes.getDimensionPixelSize(d.m.TextLineView_bottom_line_bottom_margin, 0);
        this.ftu = obtainStyledAttributes.getColor(d.m.TextLineView_text_selected_color, ak.getColor(d.C0126d.cp_cont_b));
        this.ftt = obtainStyledAttributes.getColor(d.m.TextLineView_text_unselected_color, ak.getColor(d.C0126d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.ftr + this.ftq + this.fts);
        setTextColor(this.ftu);
        this.ftv = l.e(context, d.e.ds56);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bbo();
        int measuredWidth = (getMeasuredWidth() - this.ftv) / 2;
        canvas.drawRoundRect(new RectF(measuredWidth + 0, (getMeasuredHeight() - this.fts) - this.ftq, getMeasuredWidth() - measuredWidth, getMeasuredHeight() - this.fts), l.e(getContext(), d.e.ds4), l.e(getContext(), d.e.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.ftu);
        } else {
            setTextColor(this.ftt);
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
        this.ftu = ak.getColor(d.C0126d.cp_cont_b);
        this.ftt = ak.getColor(d.C0126d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.ftu);
        } else {
            setTextColor(this.ftt);
        }
        bbo();
        invalidate();
    }
}
