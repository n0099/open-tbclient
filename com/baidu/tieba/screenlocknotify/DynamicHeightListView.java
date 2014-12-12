package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class DynamicHeightListView extends ListView {
    private int maxHeight;

    public DynamicHeightListView(Context context) {
        super(context);
        this.maxHeight = com.baidu.adp.lib.util.l.d(getContext(), u.ds484);
    }

    public DynamicHeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.maxHeight = com.baidu.adp.lib.util.l.d(getContext(), u.ds484);
    }

    public DynamicHeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxHeight = com.baidu.adp.lib.util.l.d(getContext(), u.ds484);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        if (measuredHeight > this.maxHeight) {
            measuredHeight = this.maxHeight;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), measuredHeight);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }
}
