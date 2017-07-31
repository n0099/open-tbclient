package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class DynamicHeightListView extends BdListView {
    private int maxHeight;

    public DynamicHeightListView(Context context) {
        super(context);
        this.maxHeight = k.g(TbadkCoreApplication.getInst(), d.f.ds484);
    }

    public DynamicHeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.maxHeight = k.g(TbadkCoreApplication.getInst(), d.f.ds484);
    }

    public DynamicHeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxHeight = k.g(TbadkCoreApplication.getInst(), d.f.ds484);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (getMeasuredHeight() > this.maxHeight && this.maxHeight > 0) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), this.maxHeight);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, ExploreByTouchHelper.INVALID_ID));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }
}
