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
    private int bmS;
    private final int cKV;
    private final Paint cKW;
    private final Paint cKX;
    private float cKY;
    private boolean cKZ;
    private final int cLa;

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKZ = true;
        setWillNotDraw(false);
        this.cKV = getResources().getDimensionPixelSize(i.d.ds6);
        this.cKW = new Paint();
        this.cKW.setColor(an.d((Resources) null, i.c.s_actionbar_text_line_color_s));
        this.cKX = new Paint();
        this.cKX.setColor(an.getColor(i.c.cp_bg_line_b));
        this.cLa = getResources().getDimensionPixelSize(i.d.ds1);
    }

    public void d(int i, float f) {
        this.bmS = i;
        this.cKY = f;
        invalidate();
    }

    public void aF(int i, int i2) {
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
        this.cKZ = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        if (getChildCount() > 0) {
            int height = getHeight();
            View childAt = getChildAt(this.bmS);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (this.cKZ) {
                canvas.drawRect(0.0f, height - this.cLa, getRight(), height, this.cKX);
            }
            if (this.cKY <= 0.0f || this.bmS >= getChildCount() - 1) {
                i = right;
                i2 = left;
            } else {
                View childAt2 = getChildAt(this.bmS + 1);
                i2 = (int) ((this.cKY * childAt2.getLeft()) + ((1.0f - this.cKY) * left));
                i = (int) ((childAt2.getRight() * this.cKY) + ((1.0f - this.cKY) * right));
            }
            canvas.drawRect(i2, height - this.cKV, i, height, this.cKW);
        }
    }

    public void onChangeSkinType(int i) {
        this.cKW.setColor(an.d((Resources) null, i.c.s_actionbar_text_line_color_s));
        this.cKX.setColor(an.getColor(i.c.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (i2 == this.bmS) {
                    an.b(childAt, i.c.s_actionbar_text_line_color_s, 1);
                } else {
                    an.b(childAt, i.c.cp_cont_c, 1);
                }
            }
        }
    }
}
