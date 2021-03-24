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
    public Context f24072a;

    /* renamed from: b  reason: collision with root package name */
    public List<T> f24073b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public InnerAdapter<T> f24074c;
    public ViewGroup mParent;

    /* loaded from: classes5.dex */
    public static abstract class BaseViewHolder<T> {
        public View createView(Context context) {
            return null;
        }

        public abstract void setView(T t, int i, Context context, BaseListAdapter<T> baseListAdapter);
    }

    public BaseListAdapter(Context context) {
        this.f24072a = context;
        this.f24074c = new InnerAdapter<>(context, this);
    }

    public void addList(List<T> list) {
        this.f24073b.addAll(list);
        notifyDataSetChanged();
    }

    public void clearList() {
        this.f24073b.clear();
        notifyDataSetChanged();
    }

    public Context getContext() {
        return this.f24072a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f24073b.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return this.f24073b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public int getItemTrueType(int i) {
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public List<T> getList() {
        return this.f24073b;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        this.mParent = viewGroup;
        return this.f24074c.getView(i, view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f24074c.getViewBundles().size();
    }

    public void initList(List<T> list) {
        if (this.f24073b.size() > 0) {
            this.f24073b.clear();
        }
        this.f24073b.addAll(list);
        notifyDataSetChanged();
    }

    public abstract void onBindViewHolder(List<Class<?>> list);

    public boolean useItemTrueType() {
        return false;
    }
}
