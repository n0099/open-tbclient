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
/* loaded from: classes21.dex */
public class TextLineView extends TextView {
    private int aZD;
    private int aZE;
    private int baX;
    private int kZS;
    private int kZT;
    private int kZU;
    private int kZV;
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
        this.kZS = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_height, 0);
        this.kZT = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_top_margin, 0);
        this.kZU = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_bottom_margin, 0);
        this.aZD = obtainStyledAttributes.getColor(R.styleable.TextLineView_text_selected_color, ap.getColor(R.color.cp_cont_b));
        this.aZE = obtainStyledAttributes.getColor(R.styleable.TextLineView_text_unselected_color, ap.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.kZT + this.kZS + this.kZU);
        setTextColor(this.aZD);
        this.kZV = l.getDimens(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.baX = l.getDimens(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dfV();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.kZU) - this.kZS, this.mWidth - this.mMargin, this.mHeight - this.kZU);
        canvas.drawRoundRect(this.mRectF, this.baX, this.baX, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.aZD);
        } else {
            setTextColor(this.aZE);
        }
        invalidate();
    }

    private void dfV() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(ap.getColor(R.color.cp_cont_f));
        } else {
            this.mPaint.setColor(ap.getColor(R.color.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.aZD = ap.getColor(R.color.cp_cont_b);
        this.aZE = ap.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.aZD);
        } else {
            setTextColor(this.aZE);
        }
        dfV();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.kZV) / 2;
    }
}
