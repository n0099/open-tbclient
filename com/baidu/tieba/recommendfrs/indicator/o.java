package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class o extends LinearLayout {
    private int bBx;
    private final int dFP;
    private final Paint dFQ;
    private final Paint dFR;
    private boolean dFS;
    private final int dFT;
    private int dFU;
    private int dFV;

    public o(Context context) {
        this(context, null);
    }

    public o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dFS = true;
        setWillNotDraw(false);
        this.dFP = getResources().getDimensionPixelSize(t.e.ds6);
        this.dFQ = new Paint();
        this.dFQ.setColor(ar.d((Resources) null, t.d.s_actionbar_text_line_color_s));
        this.dFR = new Paint();
        this.dFR.setColor(ar.getColor(t.d.cp_bg_line_b));
        this.dFT = getResources().getDimensionPixelSize(t.e.ds1);
    }

    public void d(int i, float f) {
        e(i, f);
        invalidate();
    }

    private void e(int i, float f) {
        View childAt = getChildAt(i);
        this.dFU = childAt.getLeft();
        this.dFV = childAt.getRight();
        if (f > 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.dFU = (int) ((childAt2.getLeft() * f) + ((1.0f - f) * this.dFU));
            this.dFV = (int) ((childAt2.getRight() * f) + ((1.0f - f) * this.dFV));
        }
    }

    public void f(int i, float f) {
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.bBx);
        int left = childAt.getLeft();
        this.dFU = (int) (left + ((childAt2.getLeft() - left) * f));
        int width = childAt.getWidth();
        this.dFV = width + ((int) ((childAt2.getWidth() - width) * f)) + this.dFU;
        invalidate();
    }

    public void aZ(int i, int i2) {
        if (i != i2) {
            this.bBx = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof p) {
                    ar.b(((p) childAt).getTextView(), t.d.s_actionbar_text_line_color_s, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof p) {
                    ar.b(((p) childAt2).getTextView(), t.d.cp_cont_f, 1);
                }
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.dFS = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getChildCount() > 0 && canvas != null) {
            int height = getHeight();
            if (this.dFS) {
                canvas.drawRect(0.0f, height - this.dFT, getRight(), height, this.dFR);
            }
            a(canvas, height);
        }
    }

    private void a(Canvas canvas, int i) {
        if (this.dFV <= 0 && this.bBx >= 0 && this.bBx < getChildCount()) {
            this.dFV = getChildAt(this.bBx).getRight();
        }
        canvas.drawRect(this.dFU, i - this.dFP, this.dFV, i, this.dFQ);
    }

    public void onChangeSkinType(int i) {
        this.dFQ.setColor(ar.d((Resources) null, t.d.s_actionbar_text_line_color_s));
        this.dFR.setColor(ar.getColor(t.d.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof p) {
                    p pVar = (p) childAt;
                    pVar.uv();
                    if (i2 == this.bBx) {
                        ar.b(pVar.getTextView(), t.d.s_actionbar_text_line_color_s, 1);
                    } else {
                        ar.b(pVar.getTextView(), t.d.cp_cont_c, 1);
                    }
                }
            }
        }
    }
}
