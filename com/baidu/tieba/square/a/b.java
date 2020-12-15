package com.baidu.tieba.square.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
    private TbPageContext<?> mPageContext;
    private BdTypeRecyclerView neT;
    private c neU;
    private y neV;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.neT = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.neU = new c(this.mPageContext);
        this.bnf.add(this.neU);
        this.neV = new y(this.mPageContext);
        this.bnf.add(this.neV);
        this.neT.addAdapters(this.bnf);
    }

    public void notifyDataSetChanged() {
        this.neT.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<q> list) {
        this.neT.setData(list);
    }
}
