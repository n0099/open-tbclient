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
    private int buv;
    private final int djr;
    private final Paint djs;
    private final Paint djt;
    private float dju;
    private boolean djv;
    private final int djw;

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.djv = true;
        setWillNotDraw(false);
        this.djr = getResources().getDimensionPixelSize(n.d.ds6);
        this.djs = new Paint();
        this.djs.setColor(as.d((Resources) null, n.c.s_actionbar_text_line_color_s));
        this.djt = new Paint();
        this.djt.setColor(as.getColor(n.c.cp_bg_line_b));
        this.djw = getResources().getDimensionPixelSize(n.d.ds1);
    }

    public void d(int i, float f) {
        this.buv = i;
        this.dju = f;
        invalidate();
    }

    public void aH(int i, int i2) {
        if (i != i2) {
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                as.b(getChildAt(i), n.c.s_actionbar_text_line_color_s, 1);
            }
            if (i2 >= 0 && i2 < childCount) {
                as.b(getChildAt(i2), n.c.cp_cont_f, 1);
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        this.djv = z;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        if (getChildCount() > 0) {
            int height = getHeight();
            View childAt = getChildAt(this.buv);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (this.djv) {
                canvas.drawRect(0.0f, height - this.djw, getRight(), height, this.djt);
            }
            if (this.dju <= 0.0f || this.buv >= getChildCount() - 1) {
                i = right;
                i2 = left;
            } else {
                View childAt2 = getChildAt(this.buv + 1);
                i2 = (int) ((this.dju * childAt2.getLeft()) + ((1.0f - this.dju) * left));
                i = (int) ((childAt2.getRight() * this.dju) + ((1.0f - this.dju) * right));
            }
            canvas.drawRect(i2, height - this.djr, i, height, this.djs);
        }
    }

    public void onChangeSkinType(int i) {
        this.djs.setColor(as.d((Resources) null, n.c.s_actionbar_text_line_color_s));
        this.djt.setColor(as.getColor(n.c.cp_bg_line_b));
        invalidate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (i2 == this.buv) {
                    as.b(childAt, n.c.s_actionbar_text_line_color_s, 1);
                } else {
                    as.b(childAt, n.c.cp_cont_c, 1);
                }
            }
        }
    }
}
