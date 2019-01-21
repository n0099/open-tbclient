package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class TextLineView extends TextView {
    private int DS4;
    private int cwn;
    private int glm;
    private int gln;
    private int glo;
    private int glp;
    private int glq;
    private int mHeight;
    private int mMargin;
    private Paint mPaint;
    private RectF mRectF;
    private int mWidth;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.TextLineView);
        this.glm = obtainStyledAttributes.getDimensionPixelSize(e.l.TextLineView_bottom_line_height, 0);
        this.gln = obtainStyledAttributes.getDimensionPixelSize(e.l.TextLineView_bottom_line_top_margin, 0);
        this.glo = obtainStyledAttributes.getDimensionPixelSize(e.l.TextLineView_bottom_line_bottom_margin, 0);
        this.glq = obtainStyledAttributes.getColor(e.l.TextLineView_text_selected_color, al.getColor(e.d.cp_cont_b));
        this.glp = obtainStyledAttributes.getColor(e.l.TextLineView_text_unselected_color, al.getColor(e.d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.gln + this.glm + this.glo);
        setTextColor(this.glq);
        this.cwn = l.h(context, e.C0210e.ds56);
        this.mRectF = new RectF();
        this.DS4 = l.h(getContext(), e.C0210e.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bnH();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.glo) - this.glm, this.mWidth - this.mMargin, this.mHeight - this.glo);
        canvas.drawRoundRect(this.mRectF, this.DS4, this.DS4, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.glq);
        } else {
            setTextColor(this.glp);
        }
        invalidate();
    }

    private void bnH() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(al.getColor(e.d.cp_cont_f));
        } else {
            this.mPaint.setColor(al.getColor(e.d.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.glq = al.getColor(e.d.cp_cont_b);
        this.glp = al.getColor(e.d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.glq);
        } else {
            setTextColor(this.glp);
        }
        bnH();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.cwn) / 2;
    }
}
