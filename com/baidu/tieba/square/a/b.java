package com.baidu.tieba.square.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bbu = new LinkedList();
    private BdTypeRecyclerView lXS;
    private c lXT;
    private y lXU;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.lXS = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.lXT = new c(this.mPageContext);
        this.bbu.add(this.lXT);
        this.lXU = new y(this.mPageContext);
        this.bbu.add(this.lXU);
        this.lXS.addAdapters(this.bbu);
    }

    public void notifyDataSetChanged() {
        this.lXS.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<q> list) {
        this.lXS.setData(list);
    }
}
