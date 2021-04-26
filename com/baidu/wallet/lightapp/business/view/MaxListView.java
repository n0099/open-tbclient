package com.baidu.wallet.lightapp.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.baidu.apollon.utils.DisplayUtils;
/* loaded from: classes5.dex */
public class MaxListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    public int f25601a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25602b;

    public MaxListView(Context context) {
        super(context);
        this.f25602b = context;
        a();
    }

    private void a() {
        this.f25601a = DisplayUtils.dip2px(this.f25602b, 400.0f);
    }

    public int getListViewHeight() {
        return this.f25601a;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.f25601a;
        if (i4 > -1) {
            i3 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
    }

    public void setListViewHeight(int i2) {
        this.f25601a = i2;
    }

    public MaxListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f25602b = context;
        a();
    }

    public MaxListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25602b = context;
        a();
    }
}
