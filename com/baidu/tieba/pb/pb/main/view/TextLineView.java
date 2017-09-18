package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TextLineView extends TextView {
    private int doK;
    private int eWe;
    private int eWf;
    private int eWg;
    private int eWh;
    private int eWi;
    private int eWj;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.TextLineView);
        this.doK = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_height, 0);
        this.eWe = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_top_margin, 0);
        this.eWf = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_bottom_margin, 0);
        this.eWg = obtainStyledAttributes.getColor(d.n.TextLineView_bottom_line_color, aj.getColor(d.e.cp_cont_f));
        this.eWi = obtainStyledAttributes.getColor(d.n.TextLineView_text_selected_color, aj.getColor(d.e.cp_cont_b));
        this.eWh = obtainStyledAttributes.getColor(d.n.TextLineView_text_unselected_color, aj.getColor(d.e.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.eWe + this.doK + this.eWf);
        setTextColor(this.eWi);
        this.eWj = k.f(context, d.f.ds56);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aUK();
        int measuredWidth = (getMeasuredWidth() - this.eWj) / 2;
        canvas.drawRoundRect(new RectF(measuredWidth + 0, (getMeasuredHeight() - this.eWf) - this.doK, getMeasuredWidth() - measuredWidth, getMeasuredHeight() - this.eWf), k.f(getContext(), d.f.ds4), k.f(getContext(), d.f.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.eWi);
        } else {
            setTextColor(this.eWh);
        }
        invalidate();
    }

    private void aUK() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(this.eWg);
        } else {
            this.mPaint.setColor(aj.getColor(d.e.transparent));
        }
    }
}
