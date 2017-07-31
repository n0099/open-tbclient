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
    private int dfo;
    private int eUK;
    private int eUL;
    private int eUM;
    private int eUN;
    private int eUO;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.TextLineView);
        this.dfo = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_height, 0);
        this.eUK = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_top_margin, 0);
        this.eUL = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_bottom_margin, 0);
        this.eUM = obtainStyledAttributes.getColor(d.n.TextLineView_bottom_line_color, ai.getColor(d.e.cp_cont_b));
        this.eUO = obtainStyledAttributes.getColor(d.n.TextLineView_text_selected_color, ai.getColor(d.e.cp_cont_b));
        this.eUN = obtainStyledAttributes.getColor(d.n.TextLineView_text_unselected_color, ai.getColor(d.e.cp_cont_d));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.eUK + this.dfo + this.eUL);
        setTextColor(this.eUO);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aUL();
        canvas.drawRoundRect(new RectF(0.0f, (getMeasuredHeight() - this.eUL) - this.dfo, getMeasuredWidth(), getMeasuredHeight() - this.eUL), k.g(getContext(), d.f.ds4), k.g(getContext(), d.f.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.eUO);
        } else {
            setTextColor(this.eUN);
        }
        invalidate();
    }

    private void aUL() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(this.eUM);
        } else {
            this.mPaint.setColor(ai.getColor(d.e.transparent));
        }
    }
}
