package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class SlidingTabStrip extends LinearLayout {
    public SlidingTabStrip(Context context) {
        this(context, null);
    }

    public void a(int i2) {
    }

    public void b(int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        int childCount = getChildCount();
        if (i2 >= 0 && i2 < childCount) {
            float dimension = getResources().getDimension(R.dimen.ds32);
            View childAt = getChildAt(i2);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTextSize(0, dimension);
            }
            SkinManager.setViewTextColor(childAt, R.color.CAM_X0308, 1);
        }
        if (i3 < 0 || i3 >= childCount) {
            return;
        }
        float dimension2 = getResources().getDimension(R.dimen.ds28);
        View childAt2 = getChildAt(i3);
        if (childAt2 instanceof TextView) {
            ((TextView) childAt2).setTextSize(0, dimension2);
        }
        SkinManager.setViewTextColor(childAt2, R.color.CAM_X0105, 1);
    }

    public SlidingTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
    }
}
