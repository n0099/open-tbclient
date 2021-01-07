package com.baidu.tieba.square.adapter;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boM = new LinkedList();
    private TbPageContext<?> mPageContext;
    private u nkA;
    private BdTypeRecyclerView nky;
    private b nkz;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.nky = bdTypeRecyclerView;
        MT();
    }

    private void MT() {
        this.nkz = new b(this.mPageContext);
        this.boM.add(this.nkz);
        this.nkA = new u(this.mPageContext);
        this.boM.add(this.nkA);
        this.nky.addAdapters(this.boM);
    }

    public void notifyDataSetChanged() {
        this.nky.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<n> list) {
        this.nky.setData(list);
    }
}
