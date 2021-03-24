package com.baidu.wallet.lightapp.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.baidu.apollon.utils.DisplayUtils;
/* loaded from: classes5.dex */
public class MaxListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    public int f25143a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25144b;

    public MaxListView(Context context) {
        super(context);
        this.f25144b = context;
        a();
    }

    private void a() {
        this.f25143a = DisplayUtils.dip2px(this.f25144b, 400.0f);
    }

    public int getListViewHeight() {
        return this.f25143a;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.f25143a;
        if (i3 > -1) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public void setListViewHeight(int i) {
        this.f25143a = i;
    }

    public MaxListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f25144b = context;
        a();
    }

    public MaxListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25144b = context;
        a();
    }
}
