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
    private int fKd;
    private int fKe;
    private int fKf;
    private int fKg;
    private int fKh;
    private int fKi;
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
        this.fKd = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_height, 0);
        this.fKe = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_top_margin, 0);
        this.fKf = obtainStyledAttributes.getDimensionPixelSize(d.l.TextLineView_bottom_line_bottom_margin, 0);
        this.fKh = obtainStyledAttributes.getColor(d.l.TextLineView_text_selected_color, am.getColor(d.C0140d.cp_cont_b));
        this.fKg = obtainStyledAttributes.getColor(d.l.TextLineView_text_unselected_color, am.getColor(d.C0140d.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.fKe + this.fKd + this.fKf);
        setTextColor(this.fKh);
        this.fKi = l.f(context, d.e.ds56);
        this.mRectF = new RectF();
        this.DS4 = l.f(getContext(), d.e.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bfo();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.fKf) - this.fKd, this.mWidth - this.mMargin, this.mHeight - this.fKf);
        canvas.drawRoundRect(this.mRectF, this.DS4, this.DS4, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.fKh);
        } else {
            setTextColor(this.fKg);
        }
        invalidate();
    }

    private void bfo() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(am.getColor(d.C0140d.cp_cont_f));
        } else {
            this.mPaint.setColor(am.getColor(d.C0140d.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.fKh = am.getColor(d.C0140d.cp_cont_b);
        this.fKg = am.getColor(d.C0140d.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.fKh);
        } else {
            setTextColor(this.fKg);
        }
        bfo();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.fKi) / 2;
    }
}
