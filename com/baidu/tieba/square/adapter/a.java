package com.baidu.tieba.square.adapter;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boS = new LinkedList();
    private TbPageContext<?> mPageContext;
    private BdTypeRecyclerView nsg;
    private b nsh;
    private u nsi;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.nsg = bdTypeRecyclerView;
        Kz();
    }

    private void Kz() {
        this.nsh = new b(this.mPageContext);
        this.boS.add(this.nsh);
        this.nsi = new u(this.mPageContext);
        this.boS.add(this.nsi);
        this.nsg.addAdapters(this.boS);
    }

    public void notifyDataSetChanged() {
        this.nsg.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<n> list) {
        this.nsg.setData(list);
    }
}
