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
/* loaded from: classes22.dex */
public class TextLineView extends TextView {
    private int bfI;
    private int bfJ;
    private int bhr;
    private int lHF;
    private int lHG;
    private int lHH;
    private int lHI;
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
        this.lHF = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_height, 0);
        this.lHG = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_top_margin, 0);
        this.lHH = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextLineView_bottom_line_bottom_margin, 0);
        this.bfI = obtainStyledAttributes.getColor(R.styleable.TextLineView_text_selected_color, ap.getColor(R.color.cp_cont_b));
        this.bfJ = obtainStyledAttributes.getColor(R.styleable.TextLineView_text_unselected_color, ap.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.lHG + this.lHF + this.lHH);
        setTextColor(this.bfI);
        this.lHI = l.getDimens(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.bhr = l.getDimens(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dpo();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.lHH) - this.lHF, this.mWidth - this.mMargin, this.mHeight - this.lHH);
        canvas.drawRoundRect(this.mRectF, this.bhr, this.bhr, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.bfI);
        } else {
            setTextColor(this.bfJ);
        }
        invalidate();
    }

    private void dpo() {
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
        this.bfI = ap.getColor(R.color.cp_cont_b);
        this.bfJ = ap.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.bfI);
        } else {
            setTextColor(this.bfJ);
        }
        dpo();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.lHI) / 2;
    }
}
