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
    private BdTypeRecyclerView lGm;
    private c lGn;
    private w lGo;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.lGm = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.lGn = new c(this.mPageContext);
        this.aWf.add(this.lGn);
        this.lGo = new w(this.mPageContext);
        this.aWf.add(this.lGo);
        this.lGm.addAdapters(this.aWf);
    }

    public void notifyDataSetChanged() {
        this.lGm.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<q> list) {
        this.lGm.setData(list);
    }
}
