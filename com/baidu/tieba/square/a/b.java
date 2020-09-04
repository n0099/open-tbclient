package com.baidu.tieba.square.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bbw = new LinkedList();
    private BdTypeRecyclerView lYh;
    private c lYi;
    private y lYj;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.lYh = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.lYi = new c(this.mPageContext);
        this.bbw.add(this.lYi);
        this.lYj = new y(this.mPageContext);
        this.bbw.add(this.lYj);
        this.lYh.addAdapters(this.bbw);
    }

    public void notifyDataSetChanged() {
        this.lYh.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<q> list) {
        this.lYh.setData(list);
    }
}
