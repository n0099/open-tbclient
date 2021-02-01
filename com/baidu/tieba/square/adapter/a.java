package com.baidu.tieba.square.adapter;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
    private TbPageContext<?> mPageContext;
    private BdTypeRecyclerView npC;
    private b npD;
    private u npE;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.npC = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.npD = new b(this.mPageContext);
        this.bns.add(this.npD);
        this.npE = new u(this.mPageContext);
        this.bns.add(this.npE);
        this.npC.addAdapters(this.bns);
    }

    public void notifyDataSetChanged() {
        this.npC.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<n> list) {
        this.npC.setData(list);
    }
}
