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
    private BdTypeRecyclerView leX;
    private c leY;
    private u leZ;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.leX = bdTypeRecyclerView;
        CY();
    }

    private void CY() {
        this.leY = new c(this.mPageContext);
        this.aSj.add(this.leY);
        this.leZ = new u(this.mPageContext);
        this.aSj.add(this.leZ);
        this.leX.addAdapters(this.aSj);
    }

    public void notifyDataSetChanged() {
        this.leX.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<o> list) {
        this.leX.setData(list);
    }
}
