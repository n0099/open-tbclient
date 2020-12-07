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
    private BdTypeRecyclerView neR;
    private c neS;
    private y neT;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.neR = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.neS = new c(this.mPageContext);
        this.bnf.add(this.neS);
        this.neT = new y(this.mPageContext);
        this.bnf.add(this.neT);
        this.neR.addAdapters(this.bnf);
    }

    public void notifyDataSetChanged() {
        this.neR.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<q> list) {
        this.neR.setData(list);
    }
}
