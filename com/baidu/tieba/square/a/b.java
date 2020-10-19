package com.baidu.tieba.square.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bhH = new LinkedList();
    private TbPageContext<?> mPageContext;
    private BdTypeRecyclerView mxm;
    private c mxn;
    private y mxo;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mxm = bdTypeRecyclerView;
        Le();
    }

    private void Le() {
        this.mxn = new c(this.mPageContext);
        this.bhH.add(this.mxn);
        this.mxo = new y(this.mPageContext);
        this.bhH.add(this.mxo);
        this.mxm.addAdapters(this.bhH);
    }

    public void notifyDataSetChanged() {
        this.mxm.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<q> list) {
        this.mxm.setData(list);
    }
}
