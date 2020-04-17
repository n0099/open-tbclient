package com.baidu.tieba.square.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aMd = new LinkedList();
    private BdTypeRecyclerView kLt;
    private c kLu;
    private s kLv;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.kLt = bdTypeRecyclerView;
        BC();
    }

    private void BC() {
        this.kLu = new c(this.mPageContext);
        this.aMd.add(this.kLu);
        this.kLv = new s(this.mPageContext);
        this.aMd.add(this.kLv);
        this.kLt.addAdapters(this.aMd);
    }

    public void notifyDataSetChanged() {
        this.kLt.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<m> list) {
        this.kLt.setData(list);
    }
}
