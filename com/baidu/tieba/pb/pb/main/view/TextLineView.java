package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class TextLineView extends TextView {
    private int bkb;
    private int caN;
    private int caO;
    private int mHeight;
    private int mMargin;
    private Paint mPaint;
    private RectF mRectF;
    private int mWidth;
    private int mfU;
    private int mfV;
    private int mfW;
    private int mfX;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextLineView);
        this.mfU = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_height, 0);
        this.mfV = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_top_margin, 0);
        this.mfW = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_bottom_margin, 0);
        this.caN = obtainStyledAttributes.getColor(R.styleable.TextLineView_text_selected_color, ap.getColor(R.color.CAM_X0105));
        this.caO = obtainStyledAttributes.getColor(R.styleable.TextLineView_text_unselected_color, ap.getColor(R.color.CAM_X0108));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.mfV + this.mfU + this.mfW);
        setTextColor(this.caN);
        this.mfX = l.getDimens(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.bkb = l.getDimens(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dsz();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.mfW) - this.mfU, this.mWidth - this.mMargin, this.mHeight - this.mfW);
        canvas.drawRoundRect(this.mRectF, this.bkb, this.bkb, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        setTextSelectedUI(z);
        invalidate();
    }

    private void dsz() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(ap.getColor(R.color.transparent));
        } else {
            this.mPaint.setColor(ap.getColor(R.color.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        setTextSelectedUI(isSelected());
        dsz();
        invalidate();
    }

    private void setTextSelectedUI(boolean z) {
        if (z) {
            com.baidu.tbadk.core.elementsMaven.c.br(this).nY(R.color.CAM_X0105).oa(R.string.F_X02);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.br(this).nY(R.color.CAM_X0108).oa(R.string.F_X01);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.mfX) / 2;
    }
}
