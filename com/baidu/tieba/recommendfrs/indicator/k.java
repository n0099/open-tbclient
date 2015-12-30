package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class k extends LinearLayout {
    private int bym;
    private final int dpV;
    private final Paint dpW;
    private final Paint dpX;
    private float dpY;
    private boolean dpZ;
    private final int dqa;

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dpZ = true;
        setWillNotDraw(false);
        this.dpV = getResources().getDimensionPixelSize(n.e.ds6);
        this.dpW = new Paint();
        this.dpW.setColor(as.d((Resources) null, n.d.s_actionbar_text_line_color_s));
        this.dpX = new Paint();
        this.dpX.setColor(as.getColor(n.d.cp_bg_line_b));
        this.dqa = getResources().getDimensionPixelSize(n.e.ds1);
    }

    public void d(int i, float f) {
        this.bym = i;
        this.dpY = f;
        invalidate();
    }

    public void aW(int i, int i2) {
        if (i != i2) {
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                as.b(getChildAt(i), n.d.s_actionbar_text_line_color_s, 1);
            }
            if (i2 >= 0 && i2 < childCount) {
                as.b(getChildAt(i2), n.d.cp_cont_f, 1);
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.dpZ = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        if (getChildCount() > 0) {
            int height = getHeight();
            View childAt = getChildAt(this.bym);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (this.dpZ) {
                canvas.drawRect(0.0f, height - this.dqa, getRight(), height, this.dpX);
            }
            if (this.dpY <= 0.0f || this.bym >= getChildCount() - 1) {
                i = right;
                i2 = left;
            } else {
                View childAt2 = getChildAt(this.bym + 1);
                i2 = (int) ((this.dpY * childAt2.getLeft()) + ((1.0f - this.dpY) * left));
                i = (int) ((childAt2.getRight() * this.dpY) + ((1.0f - this.dpY) * right));
            }
            canvas.drawRect(i2, height - this.dpV, i, height, this.dpW);
        }
    }

    public void onChangeSkinType(int i) {
        this.dpW.setColor(as.d((Resources) null, n.d.s_actionbar_text_line_color_s));
        this.dpX.setColor(as.getColor(n.d.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (i2 == this.bym) {
                    as.b(childAt, n.d.s_actionbar_text_line_color_s, 1);
                } else {
                    as.b(childAt, n.d.cp_cont_c, 1);
                }
            }
        }
    }
}
