package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
public class ScrollFragmentTabWidget extends HorizontalCustomScrollView {
    private int TD;
    private int TE;
    private LinearLayout ccm;
    private int ccn;
    private c cco;

    public ScrollFragmentTabWidget(Context context) {
        super(context);
        this.TE = -1;
        init(context);
    }

    public ScrollFragmentTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TE = -1;
        init(context);
    }

    public void setIndicatorWidth(int i) {
        this.ccn = i;
    }

    private void init(Context context) {
        aE(context);
        setWillNotDraw(false);
        setScrollbarFadingEnabled(false);
        setHorizontalScrollBarEnabled(false);
        this.TD = p.bg_navigation_bar;
    }

    private void aE(Context context) {
        this.ccm = new LinearLayout(context);
        this.ccm.setOrientation(0);
        this.ccm.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        addView(this.ccm);
    }

    public int in(int i) {
        int i2 = 0;
        int childCount = this.ccm.getChildCount();
        if (i >= 0 && i < childCount) {
            int i3 = 0;
            while (i3 <= i) {
                int measuredWidth = this.ccm.getChildAt(i3).getMeasuredWidth() + i2;
                i3++;
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.ccm.getChildCount() && this.TE != i) {
            if (this.TE != -1) {
                this.ccm.getChildAt(this.TE).setSelected(false);
            }
            this.TE = i;
            this.ccm.getChildAt(this.TE).setSelected(true);
        }
    }

    public void o(View view, int i) {
        n(view);
        this.ccm.addView(view);
        view.setOnClickListener(new d(this, this.ccm.getChildCount() - 1, null));
    }

    private void n(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ccn, -1);
        layoutParams.setMargins(0, 0, 0, 0);
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        this.ccm.removeAllViews();
        this.TE = -1;
    }

    public void setBackGroundDrawableResId(int i) {
        this.TD = i;
    }

    public void onChangeSkinType(int i) {
        ay.i(this, this.TD);
        int childCount = this.ccm.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.ccm.getChildAt(i2);
            if (childAt instanceof b) {
                ((b) childAt).rU();
            }
        }
        invalidate();
    }

    public void setTabSelectionListener(c cVar) {
        this.cco = cVar;
    }
}
