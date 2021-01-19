package com.baidu.yuyinala.privatemessage.session.view.smrlistview;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import androidx.core.internal.view.SupportMenu;
import com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMListView;
import com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMView;
/* loaded from: classes10.dex */
public class b implements WrapperListAdapter, SMView.a {
    private ListAdapter mAdapter;
    private Context mContext;
    private SMListView.a paH;

    public b(Context context, ListAdapter listAdapter) {
        this.mAdapter = listAdapter;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mAdapter.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mAdapter.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.mAdapter.getItemId(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            View view2 = this.mAdapter.getView(i, view, viewGroup);
            c cVar = new c(this.mContext);
            cVar.setViewType(this.mAdapter.getItemViewType(i));
            b(cVar);
            SMView sMView = new SMView(cVar, (SMListView) viewGroup);
            sMView.setOnSwipeItemClickListener(this);
            SMListView sMListView = (SMListView) viewGroup;
            SMLayout sMLayout = new SMLayout(view2, sMView, sMListView.getCloseInterpolator(), sMListView.getOpenInterpolator());
            sMLayout.setPosition(i);
            return sMLayout;
        }
        SMLayout sMLayout2 = (SMLayout) view;
        sMLayout2.ekJ();
        sMLayout2.setPosition(i);
        this.mAdapter.getView(i, sMLayout2.getContentView(), viewGroup);
        return sMLayout2;
    }

    public void b(c cVar) {
        e eVar = new e(this.mContext);
        eVar.setTitle("Item 1");
        eVar.setBackground(new ColorDrawable(-7829368));
        eVar.setWidth(300);
        cVar.c(eVar);
        e eVar2 = new e(this.mContext);
        eVar2.setTitle("Item 2");
        eVar2.setBackground(new ColorDrawable(SupportMenu.CATEGORY_MASK));
        eVar2.setWidth(300);
        cVar.c(eVar2);
    }

    public void a(SMView sMView, c cVar, int i) {
        if (this.paH != null) {
            this.paH.a(sMView.getPosition(), cVar, i);
        }
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mAdapter.registerDataSetObserver(dataSetObserver);
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mAdapter.unregisterDataSetObserver(dataSetObserver);
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.mAdapter.areAllItemsEnabled();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return this.mAdapter.isEnabled(i);
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        return this.mAdapter.hasStableIds();
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        return this.mAdapter.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        return this.mAdapter.getViewTypeCount();
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        return this.mAdapter.isEmpty();
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.mAdapter;
    }
}
