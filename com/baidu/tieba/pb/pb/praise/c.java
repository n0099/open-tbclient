package com.baidu.tieba.pb.pb.praise;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter implements AbsListView.OnScrollListener {
    private PraiseListActivity dnU;
    private volatile boolean dnV;
    private List<a> mZanItemDataList = null;

    public c(PraiseListActivity praiseListActivity) {
        this.dnU = null;
        this.dnU = praiseListActivity;
    }

    public void bJ(List<a> list) {
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
    /* renamed from: ml */
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
            this.dnV = false;
            notifyDataSetChanged();
            return;
        }
        this.dnV = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    private View g(int i, View view, ViewGroup viewGroup) {
        b h = b.h(this.dnU.getPageContext().getPageActivity(), view);
        a item = getItem(i);
        h.a(StringUtils.isNull(item.ask()) ? item.getUserName() : item.ask(), item.getPortrait(), item.azz(), this.dnV);
        this.dnU.changSkinType(h.getView());
        return h.getView();
    }
}
