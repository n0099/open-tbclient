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
    private int gaA;
    private int gaB;
    private int gaC;
    private int gaD;
    private int gay;
    private int gaz;
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
        this.gay = obtainStyledAttributes.getDimensionPixelSize(e.l.TextLineView_bottom_line_height, 0);
        this.gaz = obtainStyledAttributes.getDimensionPixelSize(e.l.TextLineView_bottom_line_top_margin, 0);
        this.gaA = obtainStyledAttributes.getDimensionPixelSize(e.l.TextLineView_bottom_line_bottom_margin, 0);
        this.gaC = obtainStyledAttributes.getColor(e.l.TextLineView_text_selected_color, al.getColor(e.d.cp_cont_b));
        this.gaB = obtainStyledAttributes.getColor(e.l.TextLineView_text_unselected_color, al.getColor(e.d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.gaz + this.gay + this.gaA);
        setTextColor(this.gaC);
        this.gaD = l.h(context, e.C0200e.ds56);
        this.mRectF = new RectF();
        this.DS4 = l.h(getContext(), e.C0200e.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bkv();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.gaA) - this.gay, this.mWidth - this.mMargin, this.mHeight - this.gaA);
        canvas.drawRoundRect(this.mRectF, this.DS4, this.DS4, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.gaC);
        } else {
            setTextColor(this.gaB);
        }
        invalidate();
    }

    private void bkv() {
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
        this.gaC = al.getColor(e.d.cp_cont_b);
        this.gaB = al.getColor(e.d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.gaC);
        } else {
            setTextColor(this.gaB);
        }
        bkv();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.gaD) / 2;
    }
}
