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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class TextLineView extends TextView {
    private int DS4;
    private int fJW;
    private int fJX;
    private int fJY;
    private int fJZ;
    private int fKa;
    private int fKb;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.l.TextLineView);
        this.fJW = obtainStyledAttributes.getDimensionPixelSize(f.l.TextLineView_bottom_line_height, 0);
        this.fJX = obtainStyledAttributes.getDimensionPixelSize(f.l.TextLineView_bottom_line_top_margin, 0);
        this.fJY = obtainStyledAttributes.getDimensionPixelSize(f.l.TextLineView_bottom_line_bottom_margin, 0);
        this.fKa = obtainStyledAttributes.getColor(f.l.TextLineView_text_selected_color, am.getColor(f.d.cp_cont_b));
        this.fJZ = obtainStyledAttributes.getColor(f.l.TextLineView_text_unselected_color, am.getColor(f.d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.fJX + this.fJW + this.fJY);
        setTextColor(this.fKa);
        this.fKb = l.f(context, f.e.ds56);
        this.mRectF = new RectF();
        this.DS4 = l.f(getContext(), f.e.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bfj();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.fJY) - this.fJW, this.mWidth - this.mMargin, this.mHeight - this.fJY);
        canvas.drawRoundRect(this.mRectF, this.DS4, this.DS4, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.fKa);
        } else {
            setTextColor(this.fJZ);
        }
        invalidate();
    }

    private void bfj() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(am.getColor(f.d.cp_cont_f));
        } else {
            this.mPaint.setColor(am.getColor(f.d.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.fKa = am.getColor(f.d.cp_cont_b);
        this.fJZ = am.getColor(f.d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.fKa);
        } else {
            setTextColor(this.fJZ);
        }
        bfj();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.fKb) / 2;
    }
}
