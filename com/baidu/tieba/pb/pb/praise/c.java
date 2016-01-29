package com.baidu.tieba.pb.pb.praise;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter implements AbsListView.OnScrollListener {
    private PraiseListActivity cTa;
    private volatile boolean cTb;
    private List<a> mZanItemDataList = null;

    public c(PraiseListActivity praiseListActivity) {
        this.cTa = null;
        this.cTa = praiseListActivity;
    }

    public void bn(List<a> list) {
        this.mZanItemDataList = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mZanItemDataList == null) {
            return 0;
        }
        return this.mZanItemDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ld */
    public a getItem(int i) {
        if (this.mZanItemDataList != null) {
            return this.mZanItemDataList.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return g(i, view, viewGroup);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.cTb = false;
            notifyDataSetChanged();
            return;
        }
        this.cTb = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    private View g(int i, View view, ViewGroup viewGroup) {
        b h = b.h(this.cTa.getPageContext().getPageActivity(), view);
        a item = getItem(i);
        h.a(item.getUserName(), item.getPortrait(), item.arQ(), this.cTb);
        this.cTa.changSkinType(h.getView());
        return h.getView();
    }
}
