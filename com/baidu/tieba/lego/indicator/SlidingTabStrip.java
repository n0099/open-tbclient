package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class SlidingTabStrip extends LinearLayout {
    public SlidingTabStrip(Context context) {
        this(context, null);
    }

    public SlidingTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
    }

    public void cO(int i, int i2) {
        if (i != i2) {
            int childCount = getChildCount();
            if (i >= 0 && i < childCount) {
                float dimension = getResources().getDimension(R.dimen.ds32);
                View childAt = getChildAt(i);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextSize(0, dimension);
                }
                ap.setViewTextColor(childAt, R.color.CAM_X0308, 1);
            }
            if (i2 >= 0 && i2 < childCount) {
                float dimension2 = getResources().getDimension(R.dimen.ds28);
                View childAt2 = getChildAt(i2);
                if (childAt2 instanceof TextView) {
                    ((TextView) childAt2).setTextSize(0, dimension2);
                }
                ap.setViewTextColor(childAt2, R.color.CAM_X0105, 1);
            }
        }
    }

    public void onChangeSkinType(int i) {
    }
}
