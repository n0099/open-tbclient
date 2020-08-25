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
/* loaded from: classes16.dex */
public class TextLineView extends TextView {
    private int aXh;
    private int aXi;
    private int aYy;
    private int kRi;
    private int kRj;
    private int kRk;
    private int kRl;
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
        this.kRi = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_height, 0);
        this.kRj = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_top_margin, 0);
        this.kRk = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_bottom_margin, 0);
        this.aXh = obtainStyledAttributes.getColor(R.styleable.TextLineView_text_selected_color, ap.getColor(R.color.cp_cont_b));
        this.aXi = obtainStyledAttributes.getColor(R.styleable.TextLineView_text_unselected_color, ap.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.kRj + this.kRi + this.kRk);
        setTextColor(this.aXh);
        this.kRl = l.getDimens(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.aYy = l.getDimens(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dcq();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.kRk) - this.kRi, this.mWidth - this.mMargin, this.mHeight - this.kRk);
        canvas.drawRoundRect(this.mRectF, this.aYy, this.aYy, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.aXh);
        } else {
            setTextColor(this.aXi);
        }
        invalidate();
    }

    private void dcq() {
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
        this.aXh = ap.getColor(R.color.cp_cont_b);
        this.aXi = ap.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.aXh);
        } else {
            setTextColor(this.aXi);
        }
        dcq();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.kRl) / 2;
    }
}
