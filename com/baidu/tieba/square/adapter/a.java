package com.baidu.tieba.square.adapter;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bjZ = new LinkedList();
    private TbPageContext<?> mPageContext;
    private BdTypeRecyclerView nfT;
    private b nfU;
    private u nfV;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.nfT = bdTypeRecyclerView;
        IY();
    }

    private void IY() {
        this.nfU = new b(this.mPageContext);
        this.bjZ.add(this.nfU);
        this.nfV = new u(this.mPageContext);
        this.bjZ.add(this.nfV);
        this.nfT.addAdapters(this.bjZ);
    }

    public void notifyDataSetChanged() {
        this.nfT.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<n> list) {
        this.nfT.setData(list);
    }
}
