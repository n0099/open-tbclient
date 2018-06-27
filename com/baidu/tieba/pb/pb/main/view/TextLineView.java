package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class TextLineView extends TextView {
    private int DS4;
    private int fJP;
    private int fJQ;
    private int fJR;
    private int fJS;
    private int fJT;
    private int fJU;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.TextLineView);
        this.fJP = obtainStyledAttributes.getDimensionPixelSize(d.m.TextLineView_bottom_line_height, 0);
        this.fJQ = obtainStyledAttributes.getDimensionPixelSize(d.m.TextLineView_bottom_line_top_margin, 0);
        this.fJR = obtainStyledAttributes.getDimensionPixelSize(d.m.TextLineView_bottom_line_bottom_margin, 0);
        this.fJT = obtainStyledAttributes.getColor(d.m.TextLineView_text_selected_color, am.getColor(d.C0142d.cp_cont_b));
        this.fJS = obtainStyledAttributes.getColor(d.m.TextLineView_text_unselected_color, am.getColor(d.C0142d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.fJQ + this.fJP + this.fJR);
        setTextColor(this.fJT);
        this.fJU = l.e(context, d.e.ds56);
        this.mRectF = new RectF();
        this.DS4 = l.e(getContext(), d.e.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bgV();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.fJR) - this.fJP, this.mWidth - this.mMargin, this.mHeight - this.fJR);
        canvas.drawRoundRect(this.mRectF, this.DS4, this.DS4, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.fJT);
        } else {
            setTextColor(this.fJS);
        }
        invalidate();
    }

    private void bgV() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(am.getColor(d.C0142d.cp_cont_f));
        } else {
            this.mPaint.setColor(am.getColor(d.C0142d.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.fJT = am.getColor(d.C0142d.cp_cont_b);
        this.fJS = am.getColor(d.C0142d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.fJT);
        } else {
            setTextColor(this.fJS);
        }
        bgV();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.fJU) / 2;
    }
}
