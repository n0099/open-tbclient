package com.baidu.tieba.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes5.dex */
public class MeasureLinearLayout extends LinearLayout {
    public MeasureLinearLayout(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 8) {
                measureChildWithMargins(childAt, i2, 0, i3, 0);
            }
        }
    }

    public MeasureLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
