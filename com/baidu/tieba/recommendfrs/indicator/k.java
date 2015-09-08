package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class k extends LinearLayout {
    private int blG;
    private final int cBZ;
    private final Paint cCa;
    private final Paint cCb;
    private float cCc;
    private boolean cCd;
    private final int cCe;

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cCd = true;
        setWillNotDraw(false);
        this.cBZ = getResources().getDimensionPixelSize(i.d.ds6);
        this.cCa = new Paint();
        this.cCa.setColor(al.getColor(i.c.cp_link_tip_a));
        this.cCb = new Paint();
        this.cCb.setColor(al.getColor(i.c.cp_bg_line_b));
        this.cCe = getResources().getDimensionPixelSize(i.d.ds1);
    }

    public void d(int i, float f) {
        this.blG = i;
        this.cCc = f;
        invalidate();
    }

    public void aE(int i, int i2) {
        if (i != i2) {
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                al.b(getChildAt(i), i.c.cp_link_tip_a, 1);
            }
            if (i2 >= 0 && i2 < childCount) {
                al.b(getChildAt(i2), i.c.cp_cont_f, 1);
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.cCd = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        if (getChildCount() > 0) {
            int height = getHeight();
            View childAt = getChildAt(this.blG);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (this.cCd) {
                canvas.drawRect(0.0f, height - this.cCe, getRight(), height, this.cCb);
            }
            if (this.cCc <= 0.0f || this.blG >= getChildCount() - 1) {
                i = right;
                i2 = left;
            } else {
                View childAt2 = getChildAt(this.blG + 1);
                i2 = (int) ((this.cCc * childAt2.getLeft()) + ((1.0f - this.cCc) * left));
                i = (int) ((childAt2.getRight() * this.cCc) + ((1.0f - this.cCc) * right));
            }
            canvas.drawRect(i2, height - this.cBZ, i, height, this.cCa);
        }
    }

    public void onChangeSkinType(int i) {
        this.cCa.setColor(al.getColor(i.c.cp_link_tip_a));
        this.cCb.setColor(al.getColor(i.c.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (i2 == this.blG) {
                    al.b(childAt, i.c.cp_link_tip_a, 1);
                } else {
                    al.b(childAt, i.c.cp_cont_c, 1);
                }
            }
        }
    }
}
