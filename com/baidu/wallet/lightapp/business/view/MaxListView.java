package com.baidu.wallet.lightapp.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.baidu.apollon.utils.DisplayUtils;
/* loaded from: classes5.dex */
public class MaxListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    public int f24960a;

    /* renamed from: b  reason: collision with root package name */
    public Context f24961b;

    public MaxListView(Context context) {
        super(context);
        this.f24961b = context;
        a();
    }

    private void a() {
        this.f24960a = DisplayUtils.dip2px(this.f24961b, 400.0f);
    }

    public int getListViewHeight() {
        return this.f24960a;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.f24960a;
        if (i4 > -1) {
            i3 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
    }

    public void setListViewHeight(int i2) {
        this.f24960a = i2;
    }

    public MaxListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24961b = context;
        a();
    }

    public MaxListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24961b = context;
        a();
    }
}
