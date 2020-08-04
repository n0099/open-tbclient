package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class TextLineView extends TextView {
    private int aRU;
    private int aRV;
    private int aTk;
    private int kBD;
    private int kBE;
    private int kBF;
    private int kBG;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextLineView);
        this.kBD = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_height, 0);
        this.kBE = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_top_margin, 0);
        this.kBF = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_bottom_margin, 0);
        this.aRU = obtainStyledAttributes.getColor(R.styleable.TextLineView_text_selected_color, ao.getColor(R.color.cp_cont_b));
        this.aRV = obtainStyledAttributes.getColor(R.styleable.TextLineView_text_unselected_color, ao.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.kBE + this.kBD + this.kBF);
        setTextColor(this.aRU);
        this.kBG = l.getDimens(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.aTk = l.getDimens(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cRA();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.kBF) - this.kBD, this.mWidth - this.mMargin, this.mHeight - this.kBF);
        canvas.drawRoundRect(this.mRectF, this.aTk, this.aTk, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.aRU);
        } else {
            setTextColor(this.aRV);
        }
        invalidate();
    }

    private void cRA() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(ao.getColor(R.color.cp_cont_f));
        } else {
            this.mPaint.setColor(ao.getColor(R.color.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.aRU = ao.getColor(R.color.cp_cont_b);
        this.aRV = ao.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.aRU);
        } else {
            setTextColor(this.aRV);
        }
        cRA();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.kBG) / 2;
    }
}
