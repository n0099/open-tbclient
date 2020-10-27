package com.baidu.tieba.square.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bje = new LinkedList();
    private BdTypeRecyclerView mJW;
    private c mJX;
    private y mJY;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mJW = bdTypeRecyclerView;
        Ly();
    }

    private void Ly() {
        this.mJX = new c(this.mPageContext);
        this.bje.add(this.mJX);
        this.mJY = new y(this.mPageContext);
        this.bje.add(this.mJY);
        this.mJW.addAdapters(this.bje);
    }

    public void notifyDataSetChanged() {
        this.mJW.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<q> list) {
        this.mJW.setData(list);
    }
}
