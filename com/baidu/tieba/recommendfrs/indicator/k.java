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
    private int blk;
    private final int ctH;
    private final Paint ctI;
    private final Paint ctJ;
    private float ctK;
    private boolean ctL;
    private final int ctM;

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ctL = true;
        setWillNotDraw(false);
        this.ctH = getResources().getDimensionPixelSize(i.d.ds6);
        this.ctI = new Paint();
        this.ctI.setColor(al.getColor(i.c.cp_link_tip_a));
        this.ctJ = new Paint();
        this.ctJ.setColor(al.getColor(i.c.cp_bg_line_b));
        this.ctM = getResources().getDimensionPixelSize(i.d.ds1);
    }

    public void d(int i, float f) {
        this.blk = i;
        this.ctK = f;
        invalidate();
    }

    public void av(int i, int i2) {
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
        this.ctL = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        if (getChildCount() > 0) {
            int height = getHeight();
            View childAt = getChildAt(this.blk);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (this.ctL) {
                canvas.drawRect(0.0f, height - this.ctM, getRight(), height, this.ctJ);
            }
            if (this.ctK <= 0.0f || this.blk >= getChildCount() - 1) {
                i = right;
                i2 = left;
            } else {
                View childAt2 = getChildAt(this.blk + 1);
                i2 = (int) ((this.ctK * childAt2.getLeft()) + ((1.0f - this.ctK) * left));
                i = (int) ((childAt2.getRight() * this.ctK) + ((1.0f - this.ctK) * right));
            }
            canvas.drawRect(i2, height - this.ctH, i, height, this.ctI);
        }
    }

    public void onChangeSkinType(int i) {
        this.ctI.setColor(al.getColor(i.c.cp_link_tip_a));
        this.ctJ.setColor(al.getColor(i.c.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (i2 == this.blk) {
                    al.b(childAt, i.c.cp_link_tip_a, 1);
                } else {
                    al.b(childAt, i.c.cp_cont_c, 1);
                }
            }
        }
    }
}
