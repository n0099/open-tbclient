package com.baidu.wallet.base.widget.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.wallet.base.widget.listview.internal.InnerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class BaseListAdapter<T> extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f23678a;

    /* renamed from: b  reason: collision with root package name */
    public List<T> f23679b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public InnerAdapter<T> f23680c;
    public ViewGroup mParent;

    /* loaded from: classes5.dex */
    public static abstract class BaseViewHolder<T> {
        public View createView(Context context) {
            return null;
        }

        public abstract void setView(T t, int i2, Context context, BaseListAdapter<T> baseListAdapter);
    }

    public BaseListAdapter(Context context) {
        this.f23678a = context;
        this.f23680c = new InnerAdapter<>(context, this);
    }

    public void addList(List<T> list) {
        this.f23679b.addAll(list);
        notifyDataSetChanged();
    }

    public void clearList() {
        this.f23679b.clear();
        notifyDataSetChanged();
    }

    public Context getContext() {
        return this.f23678a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f23679b.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i2) {
        return this.f23679b.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    public int getItemTrueType(int i2) {
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return super.getItemViewType(i2);
    }

    public List<T> getList() {
        return this.f23679b;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        this.mParent = viewGroup;
        return this.f23680c.getView(i2, view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f23680c.getViewBundles().size();
    }

    public void initList(List<T> list) {
        if (this.f23679b.size() > 0) {
            this.f23679b.clear();
        }
        this.f23679b.addAll(list);
        notifyDataSetChanged();
    }

    public abstract void onBindViewHolder(List<Class<?>> list);

    public boolean useItemTrueType() {
        return false;
    }
}
