package com.baidu.tieba.square.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bky = new LinkedList();
    private BdTypeRecyclerView mPT;
    private c mPU;
    private y mPV;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mPT = bdTypeRecyclerView;
        LY();
    }

    private void LY() {
        this.mPU = new c(this.mPageContext);
        this.bky.add(this.mPU);
        this.mPV = new y(this.mPageContext);
        this.bky.add(this.mPV);
        this.mPT.addAdapters(this.bky);
    }

    public void notifyDataSetChanged() {
        this.mPT.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<q> list) {
        this.mPT.setData(list);
    }
}
