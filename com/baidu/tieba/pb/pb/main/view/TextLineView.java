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
import com.baidu.tieba.R;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class TextLineView extends TextView {
    private int DS4;
    private int eaE;
    private int icg;
    private int ich;
    private int ici;
    private int icj;
    private int ick;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.TextLineView);
        this.icg = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.ich = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.ici = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.ick = obtainStyledAttributes.getColor(2, am.getColor(R.color.cp_cont_b));
        this.icj = obtainStyledAttributes.getColor(3, am.getColor(R.color.cp_cont_j));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.ich + this.icg + this.ici);
        setTextColor(this.ick);
        this.eaE = l.g(context, R.dimen.ds56);
        this.mRectF = new RectF();
        this.DS4 = l.g(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bZP();
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        this.mRectF.set(this.mMargin + 0, (this.mHeight - this.ici) - this.icg, this.mWidth - this.mMargin, this.mHeight - this.ici);
        canvas.drawRoundRect(this.mRectF, this.DS4, this.DS4, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.ick);
        } else {
            setTextColor(this.icj);
        }
        invalidate();
    }

    private void bZP() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(am.getColor(R.color.cp_cont_f));
        } else {
            this.mPaint.setColor(am.getColor(R.color.transparent));
        }
    }

    public void onChangeSkinType(int i) {
        this.ick = am.getColor(R.color.cp_cont_b);
        this.icj = am.getColor(R.color.cp_cont_j);
        if (isSelected()) {
            setTextColor(this.ick);
        } else {
            setTextColor(this.icj);
        }
        bZP();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.mMargin = (this.mWidth - this.eaE) / 2;
    }
}
