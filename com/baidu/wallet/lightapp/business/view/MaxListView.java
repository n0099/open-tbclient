package com.baidu.wallet.lightapp.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.baidu.apollon.utils.DisplayUtils;
/* loaded from: classes5.dex */
public class MaxListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    public int f24829a;

    /* renamed from: b  reason: collision with root package name */
    public Context f24830b;

    public MaxListView(Context context) {
        super(context);
        this.f24830b = context;
        a();
    }

    private void a() {
        this.f24829a = DisplayUtils.dip2px(this.f24830b, 400.0f);
    }

    public int getListViewHeight() {
        return this.f24829a;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.f24829a;
        if (i3 > -1) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public void setListViewHeight(int i) {
        this.f24829a = i;
    }

    public MaxListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24830b = context;
        a();
    }

    public MaxListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24830b = context;
        a();
    }
}
