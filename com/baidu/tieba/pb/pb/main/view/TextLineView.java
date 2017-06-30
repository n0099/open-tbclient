package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class TextLineView extends TextView {
    private int cVo;
    private int eGX;
    private int eGY;
    private int eGZ;
    private int eHa;
    private int eHb;
    private Paint mPaint;

    public TextLineView(Context context) {
        super(context);
    }

    public TextLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.TextLineView);
        this.cVo = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.eGX = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.eGY = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.eGZ = obtainStyledAttributes.getColor(1, as.getColor(w.e.cp_cont_b));
        this.eHb = obtainStyledAttributes.getColor(2, as.getColor(w.e.cp_cont_b));
        this.eHa = obtainStyledAttributes.getColor(3, as.getColor(w.e.cp_cont_d));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.eGX + this.cVo + this.eGY);
        setTextColor(this.eHb);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aRD();
        canvas.drawRoundRect(new RectF(0.0f, (getMeasuredHeight() - this.eGY) - this.cVo, getMeasuredWidth(), getMeasuredHeight() - this.eGY), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4), this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(this.eHb);
        } else {
            setTextColor(this.eHa);
        }
        invalidate();
    }

    private void aRD() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (isSelected()) {
            this.mPaint.setColor(this.eGZ);
        } else {
            this.mPaint.setColor(as.getColor(w.e.transparent));
        }
    }
}
