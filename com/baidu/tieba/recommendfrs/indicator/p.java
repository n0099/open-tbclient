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
public class p extends LinearLayout {
    private int bHc;
    private final int cJe;
    private final Paint cJf;
    private final Paint cJg;
    private boolean cJi;
    private final int cJj;
    private int eaQ;
    private int eaR;

    public p(Context context) {
        this(context, null);
    }

    public p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cJi = true;
        setWillNotDraw(false);
        this.cJe = getResources().getDimensionPixelSize(t.e.ds6);
        this.cJf = new Paint();
        this.cJf.setColor(at.d((Resources) null, t.d.s_actionbar_text_line_color_s));
        this.cJg = new Paint();
        this.cJg.setColor(at.getColor(t.d.cp_bg_line_b));
        this.cJj = getResources().getDimensionPixelSize(t.e.ds1);
    }

    public void e(int i, float f) {
        f(i, f);
        invalidate();
    }

    private void f(int i, float f) {
        View childAt = getChildAt(i);
        this.eaQ = childAt.getLeft();
        this.eaR = childAt.getRight();
        if (f >= 0.0f && i < getChildCount() - 1) {
            View childAt2 = getChildAt(i + 1);
            this.eaQ = (int) ((childAt2.getLeft() * f) + ((1.0f - f) * this.eaQ));
            this.eaR = (int) ((childAt2.getRight() * f) + ((1.0f - f) * this.eaR));
        }
    }

    public void g(int i, float f) {
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.bHc);
        int left = childAt.getLeft();
        this.eaQ = (int) (left + ((childAt2.getLeft() - left) * f));
        int width = childAt.getWidth();
        this.eaR = width + ((int) ((childAt2.getWidth() - width) * f)) + this.eaQ;
        invalidate();
    }

    public void aH(int i, int i2) {
        if (i != i2) {
            this.bHc = i;
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof q) {
                    at.c(((q) childAt).getTextView(), t.d.s_actionbar_text_line_color_s, 1);
                }
            }
            if (i2 >= 0 && i2 < childCount) {
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof q) {
                    at.c(((q) childAt2).getTextView(), t.d.cp_cont_f, 1);
                }
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.cJi = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getChildCount() > 0 && canvas != null) {
            int height = getHeight();
            if (this.cJi) {
                canvas.drawRect(0.0f, height - this.cJj, getRight(), height, this.cJg);
            }
            a(canvas, height);
        }
    }

    private void a(Canvas canvas, int i) {
        if (this.eaR <= 0 && this.bHc >= 0 && this.bHc < getChildCount()) {
            this.eaR = getChildAt(this.bHc).getRight();
        }
        canvas.drawRect(this.eaQ, i - this.cJe, this.eaR, i, this.cJf);
    }

    public void onChangeSkinType(int i) {
        this.cJf.setColor(at.d((Resources) null, t.d.s_actionbar_text_line_color_s));
        this.cJg.setColor(at.getColor(t.d.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof q) {
                    q qVar = (q) childAt;
                    qVar.sg();
                    if (i2 == this.bHc) {
                        at.c(qVar.getTextView(), t.d.s_actionbar_text_line_color_s, 1);
                    } else {
                        at.c(qVar.getTextView(), t.d.cp_cont_c, 1);
                    }
                }
            }
        }
    }
}
