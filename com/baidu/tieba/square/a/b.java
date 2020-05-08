package com.baidu.tieba.square.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aMj = new LinkedList();
    private BdTypeRecyclerView kLx;
    private c kLy;
    private s kLz;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.kLx = bdTypeRecyclerView;
        BB();
    }

    private void BB() {
        this.kLy = new c(this.mPageContext);
        this.aMj.add(this.kLy);
        this.kLz = new s(this.mPageContext);
        this.aMj.add(this.kLz);
        this.kLx.addAdapters(this.aMj);
    }

    public void notifyDataSetChanged() {
        this.kLx.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<m> list) {
        this.kLx.setData(list);
    }
}
