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
    private BdTypeRecyclerView nqc;
    private b nqd;
    private u nqe;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.nqc = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.nqd = new b(this.mPageContext);
        this.bns.add(this.nqd);
        this.nqe = new u(this.mPageContext);
        this.bns.add(this.nqe);
        this.nqc.addAdapters(this.bns);
    }

    public void notifyDataSetChanged() {
        this.nqc.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<n> list) {
        this.nqc.setData(list);
    }
}
