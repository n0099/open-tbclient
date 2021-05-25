package com.baidu.wallet.lightapp.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.baidu.apollon.utils.DisplayUtils;
/* loaded from: classes5.dex */
public class MaxListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    public int f24775a;

    /* renamed from: b  reason: collision with root package name */
    public Context f24776b;

    public MaxListView(Context context) {
        super(context);
        this.f24776b = context;
        a();
    }

    private void a() {
        this.f24775a = DisplayUtils.dip2px(this.f24776b, 400.0f);
    }

    public int getListViewHeight() {
        return this.f24775a;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.f24775a;
        if (i4 > -1) {
            i3 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
    }

    public void setListViewHeight(int i2) {
        this.f24775a = i2;
    }

    public MaxListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24776b = context;
        a();
    }

    public MaxListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24776b = context;
        a();
    }
}
