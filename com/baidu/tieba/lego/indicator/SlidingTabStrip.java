package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class SlidingTabStrip extends LinearLayout {
    public SlidingTabStrip(Context context) {
        this(context, null);
    }

    public SlidingTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
    }

    public void bG(int i, int i2) {
        if (i != i2) {
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                float dimension = getResources().getDimension(d.e.ds32);
                View childAt = getChildAt(i);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextSize(0, dimension);
                }
                al.d(childAt, d.C0236d.cp_other_b, 1);
            }
            if (i2 >= 0 && i2 < childCount) {
                float dimension2 = getResources().getDimension(d.e.ds28);
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof TextView) {
                    ((TextView) childAt2).setTextSize(0, dimension2);
                }
                al.d(childAt2, d.C0236d.cp_cont_b, 1);
            }
        }
    }

    public void onChangeSkinType(int i) {
    }
}
