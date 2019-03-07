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
    private int dLh;
    private int hBm;
    private int hBn;
    private int hBo;
    private int hBp;
    private int hBq;
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
        this.hBm = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_height, 0);
        this.hBn = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_top_margin, 0);
        this.hBo = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_bottom_margin, 0);
        this.hBq = obtainStyledAttributes.getColor(d.l.TextLineView_text_selected_color, al.getColor(d.C0236d.cp_cont_b));
        this.hBp = obtainStyledAttributes.getColor(d.l.TextLineView_text_unselected_color, al.getColor(d.C0236d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.hBn + this.hBm + this.hBo);
        setTextColor(this.hBq);
        this.dLh = l.h(context, d.e.ds56);
        this.mRectF = new RectF();
        this.DS4 = l.h(getContext(), d.e.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bOb();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.hBo) - this.hBm, this.mWidth - this.mMargin, this.mHeight - this.hBo);
        canvas.drawRoundRect(this.mRectF, this.DS4, this.DS4, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.hBq);
        } else {
            setTextColor(this.hBp);
        }
        invalidate();
    }

    private void bOb() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(al.getColor(d.C0236d.cp_cont_f));
        } else {
            this.mPaint.setColor(al.getColor(d.C0236d.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.hBq = al.getColor(d.C0236d.cp_cont_b);
        this.hBp = al.getColor(d.C0236d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.hBq);
        } else {
            setTextColor(this.hBp);
        }
        bOb();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.dLh) / 2;
    }
}
