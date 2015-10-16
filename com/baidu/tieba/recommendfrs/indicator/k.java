package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class k extends LinearLayout {
    private int bmo;
    private final Paint cJA;
    private final Paint cJB;
    private float cJC;
    private boolean cJD;
    private final int cJE;
    private final int cJz;

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cJD = true;
        setWillNotDraw(false);
        this.cJz = getResources().getDimensionPixelSize(i.d.ds6);
        this.cJA = new Paint();
        this.cJA.setColor(an.d((Resources) null, i.c.s_actionbar_text_line_color_s));
        this.cJB = new Paint();
        this.cJB.setColor(an.getColor(i.c.cp_bg_line_b));
        this.cJE = getResources().getDimensionPixelSize(i.d.ds1);
    }

    public void d(int i, float f) {
        this.bmo = i;
        this.cJC = f;
        invalidate();
    }

    public void aD(int i, int i2) {
        if (i != i2) {
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                an.b(getChildAt(i), i.c.s_actionbar_text_line_color_s, 1);
            }
            if (i2 >= 0 && i2 < childCount) {
                an.b(getChildAt(i2), i.c.cp_cont_f, 1);
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.cJD = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        if (getChildCount() > 0) {
            int height = getHeight();
            View childAt = getChildAt(this.bmo);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (this.cJD) {
                canvas.drawRect(0.0f, height - this.cJE, getRight(), height, this.cJB);
            }
            if (this.cJC <= 0.0f || this.bmo >= getChildCount() - 1) {
                i = right;
                i2 = left;
            } else {
                View childAt2 = getChildAt(this.bmo + 1);
                i2 = (int) ((this.cJC * childAt2.getLeft()) + ((1.0f - this.cJC) * left));
                i = (int) ((childAt2.getRight() * this.cJC) + ((1.0f - this.cJC) * right));
            }
            canvas.drawRect(i2, height - this.cJz, i, height, this.cJA);
        }
    }

    public void onChangeSkinType(int i) {
        this.cJA.setColor(an.d((Resources) null, i.c.s_actionbar_text_line_color_s));
        this.cJB.setColor(an.getColor(i.c.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (i2 == this.bmo) {
                    an.b(childAt, i.c.s_actionbar_text_line_color_s, 1);
                } else {
                    an.b(childAt, i.c.cp_cont_c, 1);
                }
            }
        }
    }
}
