package com.baidu.tieba.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;
/* loaded from: classes5.dex */
public class AdapterLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Adapter f21705e;

    /* renamed from: f  reason: collision with root package name */
    public final DataSetObserver f21706f;

    /* loaded from: classes5.dex */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (AdapterLinearLayout.this.f21705e == null) {
                return;
            }
            int count = AdapterLinearLayout.this.f21705e.getCount();
            int childCount = AdapterLinearLayout.this.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = AdapterLinearLayout.this.getChildAt(i);
                View view = AdapterLinearLayout.this.f21705e.getView(i, childAt, AdapterLinearLayout.this);
                if (childAt == null && view != null) {
                    AdapterLinearLayout.this.addView(view);
                }
            }
            if (childCount > 0) {
                AdapterLinearLayout.this.removeViews(count, childCount);
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
        }
    }

    public AdapterLinearLayout(Context context) {
        super(context);
        this.f21706f = new a();
    }

    public void setAdapter(Adapter adapter) {
        Adapter adapter2 = this.f21705e;
        if (adapter2 != null) {
            adapter2.unregisterDataSetObserver(this.f21706f);
        }
        this.f21705e = adapter;
        if (adapter != null) {
            adapter.registerDataSetObserver(this.f21706f);
        }
    }

    public AdapterLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21706f = new a();
    }

    public AdapterLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21706f = new a();
    }
}
