package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
/* loaded from: classes.dex */
public class GoodGridView extends GridView {
    public GoodGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GoodGridView(Context context) {
        super(context);
    }

    public GoodGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
