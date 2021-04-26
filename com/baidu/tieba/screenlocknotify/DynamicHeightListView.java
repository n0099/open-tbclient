package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
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
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        int measuredHeight = getMeasuredHeight();
        int i4 = this.K;
        if (measuredHeight > i4 && i4 > 0) {
            setMeasuredDimension(View.MeasureSpec.getSize(i2), i4);
        } else {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void setMaxHeight(int i2) {
        this.K = i2;
    }

    public DynamicHeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K = l.g(TbadkCoreApplication.getInst(), R.dimen.ds484);
    }

    public DynamicHeightListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.K = l.g(TbadkCoreApplication.getInst(), R.dimen.ds484);
    }
}
