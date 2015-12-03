package com.baidu.tieba.pb.pb.praise;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter implements AbsListView.OnScrollListener {
    private PraiseListActivity cGE;
    private volatile boolean isScrolling;
    private List<a> mZanItemDataList = null;

    public c(PraiseListActivity praiseListActivity) {
        this.cGE = null;
        this.cGE = praiseListActivity;
    }

    public void setZanItemDataList(List<a> list) {
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
    /* renamed from: kc */
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
        return buildItemView(i, view, viewGroup);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.isScrolling = false;
            notifyDataSetChanged();
            return;
        }
        this.isScrolling = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    private View buildItemView(int i, View view, ViewGroup viewGroup) {
        b i2 = b.i(this.cGE.getPageContext().getPageActivity(), view);
        a item = getItem(i);
        i2.setData(item.getUserName(), item.getPortrait(), item.ame(), this.isScrolling);
        this.cGE.changSkinType(i2.getView());
        return i2.getView();
    }
}
