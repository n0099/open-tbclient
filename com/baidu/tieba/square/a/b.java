package com.baidu.tieba.square.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aSj = new LinkedList();
    private BdTypeRecyclerView ldN;
    private c ldO;
    private u ldP;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.ldN = bdTypeRecyclerView;
        CY();
    }

    private void CY() {
        this.ldO = new c(this.mPageContext);
        this.aSj.add(this.ldO);
        this.ldP = new u(this.mPageContext);
        this.aSj.add(this.ldP);
        this.ldN.addAdapters(this.aSj);
    }

    public void notifyDataSetChanged() {
        this.ldN.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<o> list) {
        this.ldN.setData(list);
    }
}
