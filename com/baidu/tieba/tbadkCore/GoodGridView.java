package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.view.BdGridView;
/* loaded from: classes5.dex */
public class GoodGridView extends BdGridView {
    public GoodGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public GoodGridView(Context context) {
        super(context);
    }

    public GoodGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
