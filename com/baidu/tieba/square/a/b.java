package com.baidu.tieba.square.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes21.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bdV = new LinkedList();
    private TbPageContext<?> mPageContext;
    private BdTypeRecyclerView mhJ;
    private c mhK;
    private y mhL;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mhJ = bdTypeRecyclerView;
        JZ();
    }

    private void JZ() {
        this.mhK = new c(this.mPageContext);
        this.bdV.add(this.mhK);
        this.mhL = new y(this.mPageContext);
        this.bdV.add(this.mhL);
        this.mhJ.addAdapters(this.bdV);
    }

    public void notifyDataSetChanged() {
        this.mhJ.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<q> list) {
        this.mhJ.setData(list);
    }
}
