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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class TextLineView extends TextView {
    private int DS4;
    private int dKu;
    private int hAT;
    private int hAU;
    private int hAV;
    private int hAW;
    private int hAX;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.TextLineView);
        this.hAT = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_height, 0);
        this.hAU = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_top_margin, 0);
        this.hAV = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_bottom_margin, 0);
        this.hAX = obtainStyledAttributes.getColor(d.l.TextLineView_text_selected_color, al.getColor(d.C0277d.cp_cont_b));
        this.hAW = obtainStyledAttributes.getColor(d.l.TextLineView_text_unselected_color, al.getColor(d.C0277d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.hAU + this.hAT + this.hAV);
        setTextColor(this.hAX);
        this.dKu = l.h(context, d.e.ds56);
        this.mRectF = new RectF();
        this.DS4 = l.h(getContext(), d.e.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bNZ();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.hAV) - this.hAT, this.mWidth - this.mMargin, this.mHeight - this.hAV);
        canvas.drawRoundRect(this.mRectF, this.DS4, this.DS4, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.hAX);
        } else {
            setTextColor(this.hAW);
        }
        invalidate();
    }

    private void bNZ() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(al.getColor(d.C0277d.cp_cont_f));
        } else {
            this.mPaint.setColor(al.getColor(d.C0277d.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.hAX = al.getColor(d.C0277d.cp_cont_b);
        this.hAW = al.getColor(d.C0277d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.hAX);
        } else {
            setTextColor(this.hAW);
        }
        bNZ();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.dKu) / 2;
    }
}
