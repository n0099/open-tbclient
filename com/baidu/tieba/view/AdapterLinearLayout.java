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
    public Adapter f21626e;

    /* renamed from: f  reason: collision with root package name */
    public final DataSetObserver f21627f;

    /* loaded from: classes5.dex */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (AdapterLinearLayout.this.f21626e == null) {
                return;
            }
            int count = AdapterLinearLayout.this.f21626e.getCount();
            int childCount = AdapterLinearLayout.this.getChildCount() - count;
            for (int i2 = 0; i2 < count; i2++) {
                View childAt = AdapterLinearLayout.this.getChildAt(i2);
                View view = AdapterLinearLayout.this.f21626e.getView(i2, childAt, AdapterLinearLayout.this);
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
        this.f21627f = new a();
    }

    public void setAdapter(Adapter adapter) {
        Adapter adapter2 = this.f21626e;
        if (adapter2 != null) {
            adapter2.unregisterDataSetObserver(this.f21627f);
        }
        this.f21626e = adapter;
        if (adapter != null) {
            adapter.registerDataSetObserver(this.f21627f);
        }
    }

    public AdapterLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21627f = new a();
    }

    public AdapterLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21627f = new a();
    }
}
