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
    public Context f23781a;

    /* renamed from: b  reason: collision with root package name */
    public List<T> f23782b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public InnerAdapter<T> f23783c;
    public ViewGroup mParent;

    /* loaded from: classes5.dex */
    public static abstract class BaseViewHolder<T> {
        public View createView(Context context) {
            return null;
        }

        public abstract void setView(T t, int i2, Context context, BaseListAdapter<T> baseListAdapter);
    }

    public BaseListAdapter(Context context) {
        this.f23781a = context;
        this.f23783c = new InnerAdapter<>(context, this);
    }

    public void addList(List<T> list) {
        this.f23782b.addAll(list);
        notifyDataSetChanged();
    }

    public void clearList() {
        this.f23782b.clear();
        notifyDataSetChanged();
    }

    public Context getContext() {
        return this.f23781a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f23782b.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i2) {
        return this.f23782b.get(i2);
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
        return this.f23782b;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        this.mParent = viewGroup;
        return this.f23783c.getView(i2, view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f23783c.getViewBundles().size();
    }

    public void initList(List<T> list) {
        if (this.f23782b.size() > 0) {
            this.f23782b.clear();
        }
        this.f23782b.addAll(list);
        notifyDataSetChanged();
    }

    public abstract void onBindViewHolder(List<Class<?>> list);

    public boolean useItemTrueType() {
        return false;
    }
}
