package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class o extends LinearLayout {
    private int bGW;
    private final int cIA;
    private final Paint cIB;
    private final Paint cIC;
    private boolean cIE;
    private final int cIF;
    private int dXG;
    private int dXH;

    public o(Context context) {
        this(context, null);
    }

    public o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cIE = true;
        setWillNotDraw(false);
        this.cIA = getResources().getDimensionPixelSize(t.e.ds6);
        this.cIB = new Paint();
        this.cIB.setColor(at.d((Resources) null, t.d.s_actionbar_text_line_color_s));
        this.cIC = new Paint();
        this.cIC.setColor(at.getColor(t.d.cp_bg_line_b));
        this.cIF = getResources().getDimensionPixelSize(t.e.ds1);
    }

    public void e(int i, float f) {
        f(i, f);
        invalidate();
    }

    private void f(int i, float f) {
        View childAt = getChildAt(i);
        this.dXG = childAt.getLeft();
        this.dXH = childAt.getRight();
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.dXG = (int) ((childAt2.getLeft() * f) + ((1.0f - f) * this.dXG));
            this.dXH = (int) ((childAt2.getRight() * f) + ((1.0f - f) * this.dXH));
        }
    }

    public void g(int i, float f) {
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.bGW);
        int left = childAt.getLeft();
        this.dXG = (int) (left + ((childAt2.getLeft() - left) * f));
        int width = childAt.getWidth();
        this.dXH = width + ((int) ((childAt2.getWidth() - width) * f)) + this.dXG;
        invalidate();
    }

    public void aI(int i, int i2) {
        if (i != i2) {
            this.bGW = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof p) {
                    at.b(((p) childAt).getTextView(), t.d.s_actionbar_text_line_color_s, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof p) {
                    at.b(((p) childAt2).getTextView(), t.d.cp_cont_f, 1);
                }
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.cIE = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getChildCount() > 0 && canvas != null) {
            int height = getHeight();
            if (this.cIE) {
                canvas.drawRect(0.0f, height - this.cIF, getRight(), height, this.cIC);
            }
            a(canvas, height);
        }
    }

    private void a(Canvas canvas, int i) {
        if (this.dXH <= 0 && this.bGW >= 0 && this.bGW < getChildCount()) {
            this.dXH = getChildAt(this.bGW).getRight();
        }
        canvas.drawRect(this.dXG, i - this.cIA, this.dXH, i, this.cIB);
    }

    public void onChangeSkinType(int i) {
        this.cIB.setColor(at.d((Resources) null, t.d.s_actionbar_text_line_color_s));
        this.cIC.setColor(at.getColor(t.d.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof p) {
                    p pVar = (p) childAt;
                    pVar.uA();
                    if (i2 == this.bGW) {
                        at.b(pVar.getTextView(), t.d.s_actionbar_text_line_color_s, 1);
                    } else {
                        at.b(pVar.getTextView(), t.d.cp_cont_c, 1);
                    }
                }
            }
        }
    }
}
