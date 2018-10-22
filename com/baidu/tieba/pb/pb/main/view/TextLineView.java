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
    private int fZc;
    private int fZd;
    private int fZe;
    private int fZf;
    private int fZg;
    private int fZh;
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
        this.fZc = obtainStyledAttributes.getDimensionPixelSize(e.l.TextLineView_bottom_line_height, 0);
        this.fZd = obtainStyledAttributes.getDimensionPixelSize(e.l.TextLineView_bottom_line_top_margin, 0);
        this.fZe = obtainStyledAttributes.getDimensionPixelSize(e.l.TextLineView_bottom_line_bottom_margin, 0);
        this.fZg = obtainStyledAttributes.getColor(e.l.TextLineView_text_selected_color, al.getColor(e.d.cp_cont_b));
        this.fZf = obtainStyledAttributes.getColor(e.l.TextLineView_text_unselected_color, al.getColor(e.d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.fZd + this.fZc + this.fZe);
        setTextColor(this.fZg);
        this.fZh = l.h(context, e.C0175e.ds56);
        this.mRectF = new RectF();
        this.DS4 = l.h(getContext(), e.C0175e.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bkZ();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.fZe) - this.fZc, this.mWidth - this.mMargin, this.mHeight - this.fZe);
        canvas.drawRoundRect(this.mRectF, this.DS4, this.DS4, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.fZg);
        } else {
            setTextColor(this.fZf);
        }
        invalidate();
    }

    private void bkZ() {
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
        this.fZg = al.getColor(e.d.cp_cont_b);
        this.fZf = al.getColor(e.d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.fZg);
        } else {
            setTextColor(this.fZf);
        }
        bkZ();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.fZh) / 2;
    }
}
