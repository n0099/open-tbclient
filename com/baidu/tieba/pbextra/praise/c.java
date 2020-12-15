package com.baidu.tieba.pbextra.praise;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes22.dex */
public class c extends BaseAdapter implements AbsListView.OnScrollListener {
    private volatile boolean isScrolling;
    private List<a> mZanItemDataList = null;
    private PraiseListActivity mhQ;

    public c(PraiseListActivity praiseListActivity) {
        this.mhQ = null;
        this.mhQ = praiseListActivity;
    }

    public void ft(List<a> list) {
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
    /* renamed from: Ic */
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
            this.isScrolling = false;
            notifyDataSetChanged();
            return;
        }
        this.isScrolling = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    private View g(int i, View view, ViewGroup viewGroup) {
        b b = b.b(this.mhQ.getPageContext().getPageActivity(), view);
        a item = getItem(i);
        b.b(StringUtils.isNull(item.getShowName()) ? item.getUserName() : item.getShowName(), item.getPortrait(), item.dxW(), this.isScrolling);
        this.mhQ.changSkinType(b.getView());
        return b.getView();
    }
}
