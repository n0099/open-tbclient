package com.baidu.tieba.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class MeasureLinearLayout extends LinearLayout {
    public MeasureLinearLayout(Context context) {
        super(context);
    }

    public MeasureLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 8) {
                measureChildWithMargins(childAt, i, 0, i2, 0);
            }
        }
    }
}
