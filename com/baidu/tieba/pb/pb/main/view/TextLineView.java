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
    private int dnO;
    private int eVk;
    private int eVl;
    private int eVm;
    private int eVn;
    private int eVo;
    private int eVp;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.TextLineView);
        this.dnO = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_height, 0);
        this.eVk = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_top_margin, 0);
        this.eVl = obtainStyledAttributes.getDimensionPixelSize(d.n.TextLineView_bottom_line_bottom_margin, 0);
        this.eVm = obtainStyledAttributes.getColor(d.n.TextLineView_bottom_line_color, aj.getColor(d.e.cp_cont_f));
        this.eVo = obtainStyledAttributes.getColor(d.n.TextLineView_text_selected_color, aj.getColor(d.e.cp_cont_b));
        this.eVn = obtainStyledAttributes.getColor(d.n.TextLineView_text_unselected_color, aj.getColor(d.e.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.eVk + this.dnO + this.eVl);
        setTextColor(this.eVo);
        this.eVp = k.g(context, d.f.ds56);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aUz();
        int measuredWidth = (getMeasuredWidth() - this.eVp) / 2;
        canvas.drawRoundRect(new RectF(measuredWidth + 0, (getMeasuredHeight() - this.eVl) - this.dnO, getMeasuredWidth() - measuredWidth, getMeasuredHeight() - this.eVl), k.g(getContext(), d.f.ds4), k.g(getContext(), d.f.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.eVo);
        } else {
            setTextColor(this.eVn);
        }
        invalidate();
    }

    private void aUz() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(this.eVm);
        } else {
            this.mPaint.setColor(aj.getColor(d.e.transparent));
        }
    }
}
