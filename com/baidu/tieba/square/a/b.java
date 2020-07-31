package com.baidu.tieba.square.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aWf = new LinkedList();
    private BdTypeRecyclerView lGk;
    private c lGl;
    private w lGm;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.lGk = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.lGl = new c(this.mPageContext);
        this.aWf.add(this.lGl);
        this.lGm = new w(this.mPageContext);
        this.aWf.add(this.lGm);
        this.lGk.addAdapters(this.aWf);
    }

    public void notifyDataSetChanged() {
        this.lGk.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<q> list) {
        this.lGk.setData(list);
    }
}
