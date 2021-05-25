package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes6.dex */
public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    public DynamicBaseWidgetImp(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull f fVar) {
        super(context, dynamicRootView, fVar);
        setTag(Integer.valueOf(getClickArea()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    public boolean b() {
        View view = this.n;
        if (view == null) {
            view = this;
        }
        view.setBackgroundColor(0);
        view.setPadding(this.j.c(), this.j.b(), this.j.d(), this.j.a());
        if (this.o) {
            view.setVisibility(4);
            return true;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    public boolean c() {
        if (e()) {
            View view = this.n;
            if (view == null) {
                view = this;
            }
            view.setOnTouchListener(getDynamicClickListener());
            view.setOnClickListener(getDynamicClickListener());
            return true;
        }
        return true;
    }

    public ViewGroup.LayoutParams getWidgetLayoutParams() {
        return new ViewGroup.LayoutParams(this.f28026e, this.f28027f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.n != null) {
            u.f("DynamicBaseWidget", "widget mDynamicView onLayout l,t,r,b:" + i2 + "," + i3 + "," + i4 + "," + i5);
            this.n.layout(0, 0, this.f28026e, this.f28027f);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(this.f28026e, this.f28027f);
    }
}
