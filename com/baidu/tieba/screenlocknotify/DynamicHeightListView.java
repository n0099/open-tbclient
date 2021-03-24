package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class DynamicHeightListView extends BdListView {
    public int K;

    public DynamicHeightListView(Context context) {
        super(context);
        this.K = l.g(TbadkCoreApplication.getInst(), R.dimen.ds484);
    }

    public int getMaxHeight() {
        return this.K;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight = getMeasuredHeight();
        int i3 = this.K;
        if (measuredHeight > i3 && i3 > 0) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), i3);
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void setMaxHeight(int i) {
        this.K = i;
    }

    public DynamicHeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K = l.g(TbadkCoreApplication.getInst(), R.dimen.ds484);
    }

    public DynamicHeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.K = l.g(TbadkCoreApplication.getInst(), R.dimen.ds484);
    }
}
