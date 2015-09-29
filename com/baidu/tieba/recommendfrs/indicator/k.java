package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class k extends LinearLayout {
    private int bmd;
    private final int cJa;
    private final Paint cJb;
    private final Paint cJc;
    private float cJd;
    private boolean cJe;
    private final int cJf;

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cJe = true;
        setWillNotDraw(false);
        this.cJa = getResources().getDimensionPixelSize(i.d.ds6);
        this.cJb = new Paint();
        this.cJb.setColor(am.d((Resources) null, i.c.s_actionbar_text_line_color_s));
        this.cJc = new Paint();
        this.cJc.setColor(am.getColor(i.c.cp_bg_line_b));
        this.cJf = getResources().getDimensionPixelSize(i.d.ds1);
    }

    public void d(int i, float f) {
        this.bmd = i;
        this.cJd = f;
        invalidate();
    }

    public void aD(int i, int i2) {
        if (i != i2) {
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                am.b(getChildAt(i), i.c.s_actionbar_text_line_color_s, 1);
            }
            if (i2 >= 0 && i2 < childCount) {
                am.b(getChildAt(i2), i.c.cp_cont_f, 1);
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.cJe = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        if (getChildCount() > 0) {
            int height = getHeight();
            View childAt = getChildAt(this.bmd);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (this.cJe) {
                canvas.drawRect(0.0f, height - this.cJf, getRight(), height, this.cJc);
            }
            if (this.cJd <= 0.0f || this.bmd >= getChildCount() - 1) {
                i = right;
                i2 = left;
            } else {
                View childAt2 = getChildAt(this.bmd + 1);
                i2 = (int) ((this.cJd * childAt2.getLeft()) + ((1.0f - this.cJd) * left));
                i = (int) ((childAt2.getRight() * this.cJd) + ((1.0f - this.cJd) * right));
            }
            canvas.drawRect(i2, height - this.cJa, i, height, this.cJb);
        }
    }

    public void onChangeSkinType(int i) {
        this.cJb.setColor(am.d((Resources) null, i.c.s_actionbar_text_line_color_s));
        this.cJc.setColor(am.getColor(i.c.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (i2 == this.bmd) {
                    am.b(childAt, i.c.s_actionbar_text_line_color_s, 1);
                } else {
                    am.b(childAt, i.c.cp_cont_c, 1);
                }
            }
        }
    }
}
