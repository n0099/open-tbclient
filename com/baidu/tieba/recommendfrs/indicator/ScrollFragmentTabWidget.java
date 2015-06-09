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
    private LinearLayout ccn;
    private int cco;
    private c ccp;

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
        this.cco = i;
    }

    private void init(Context context) {
        aE(context);
        setWillNotDraw(false);
        setScrollbarFadingEnabled(false);
        setHorizontalScrollBarEnabled(false);
        this.TD = p.bg_navigation_bar;
    }

    private void aE(Context context) {
        this.ccn = new LinearLayout(context);
        this.ccn.setOrientation(0);
        this.ccn.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        addView(this.ccn);
    }

    public int in(int i) {
        int i2 = 0;
        int childCount = this.ccn.getChildCount();
        if (i >= 0 && i < childCount) {
            int i3 = 0;
            while (i3 <= i) {
                int measuredWidth = this.ccn.getChildAt(i3).getMeasuredWidth() + i2;
                i3++;
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.ccn.getChildCount() && this.TE != i) {
            if (this.TE != -1) {
                this.ccn.getChildAt(this.TE).setSelected(false);
            }
            this.TE = i;
            this.ccn.getChildAt(this.TE).setSelected(true);
        }
    }

    public void o(View view, int i) {
        n(view);
        this.ccn.addView(view);
        view.setOnClickListener(new d(this, this.ccn.getChildCount() - 1, null));
    }

    private void n(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cco, -1);
        layoutParams.setMargins(0, 0, 0, 0);
        view.setLayoutParams(layoutParams);
        view.setFocusable(true);
        view.setClickable(true);
    }

    public void reset() {
        this.ccn.removeAllViews();
        this.TE = -1;
    }

    public void setBackGroundDrawableResId(int i) {
        this.TD = i;
    }

    public void onChangeSkinType(int i) {
        ay.i(this, this.TD);
        int childCount = this.ccn.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.ccn.getChildAt(i2);
            if (childAt instanceof b) {
                ((b) childAt).rU();
            }
        }
        invalidate();
    }

    public void setTabSelectionListener(c cVar) {
        this.ccp = cVar;
    }
}
