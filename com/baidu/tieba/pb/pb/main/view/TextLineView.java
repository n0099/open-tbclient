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
    private int cvB;
    private int gki;
    private int gkj;
    private int gkk;
    private int gkl;
    private int gkm;
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
        this.gki = obtainStyledAttributes.getDimensionPixelSize(e.l.TextLineView_bottom_line_height, 0);
        this.gkj = obtainStyledAttributes.getDimensionPixelSize(e.l.TextLineView_bottom_line_top_margin, 0);
        this.gkk = obtainStyledAttributes.getDimensionPixelSize(e.l.TextLineView_bottom_line_bottom_margin, 0);
        this.gkm = obtainStyledAttributes.getColor(e.l.TextLineView_text_selected_color, al.getColor(e.d.cp_cont_b));
        this.gkl = obtainStyledAttributes.getColor(e.l.TextLineView_text_unselected_color, al.getColor(e.d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.gkj + this.gki + this.gkk);
        setTextColor(this.gkm);
        this.cvB = l.h(context, e.C0210e.ds56);
        this.mRectF = new RectF();
        this.DS4 = l.h(getContext(), e.C0210e.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bmZ();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.gkk) - this.gki, this.mWidth - this.mMargin, this.mHeight - this.gkk);
        canvas.drawRoundRect(this.mRectF, this.DS4, this.DS4, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.gkm);
        } else {
            setTextColor(this.gkl);
        }
        invalidate();
    }

    private void bmZ() {
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
        this.gkm = al.getColor(e.d.cp_cont_b);
        this.gkl = al.getColor(e.d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.gkm);
        } else {
            setTextColor(this.gkl);
        }
        bmZ();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.cvB) / 2;
    }
}
