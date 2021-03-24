package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
/* loaded from: classes3.dex */
public class CooperatePrivilegeListView extends ListView {
    public CooperatePrivilegeListView(Context context) {
        super(context);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public CooperatePrivilegeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CooperatePrivilegeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
