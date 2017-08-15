package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TextLineView extends TextView {
    private int dhl;
    private int eWD;
    private int eWE;
    private int eWF;
    private int eWG;
    private int eWH;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.TextLineView);
        this.dhl = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_height, 0);
        this.eWD = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_top_margin, 0);
        this.eWE = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_bottom_margin, 0);
        this.eWF = obtainStyledAttributes.getColor(d.n.TextLineView_bottom_line_color, ai.getColor(d.e.cp_cont_b));
        this.eWH = obtainStyledAttributes.getColor(d.n.TextLineView_text_selected_color, ai.getColor(d.e.cp_cont_b));
        this.eWG = obtainStyledAttributes.getColor(d.n.TextLineView_text_unselected_color, ai.getColor(d.e.cp_cont_d));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.eWD + this.dhl + this.eWE);
        setTextColor(this.eWH);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aVs();
        canvas.drawRoundRect(new RectF(0.0f, (getMeasuredHeight() - this.eWE) - this.dhl, getMeasuredWidth(), getMeasuredHeight() - this.eWE), k.g(getContext(), d.f.ds4), k.g(getContext(), d.f.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.eWH);
        } else {
            setTextColor(this.eWG);
        }
        invalidate();
    }

    private void aVs() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(this.eWF);
        } else {
            this.mPaint.setColor(ai.getColor(d.e.transparent));
        }
    }
}
