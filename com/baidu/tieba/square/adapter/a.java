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
    private b nkA;
    private u nkB;
    private BdTypeRecyclerView nkz;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.nkz = bdTypeRecyclerView;
        MT();
    }

    private void MT() {
        this.nkA = new b(this.mPageContext);
        this.boM.add(this.nkA);
        this.nkB = new u(this.mPageContext);
        this.boM.add(this.nkB);
        this.nkz.addAdapters(this.boM);
    }

    public void notifyDataSetChanged() {
        this.nkz.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<n> list) {
        this.nkz.setData(list);
    }
}
