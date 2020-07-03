package com.baidu.tieba.square.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aUP = new LinkedList();
    private BdTypeRecyclerView lyU;
    private c lyV;
    private w lyW;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.lyU = bdTypeRecyclerView;
        Dz();
    }

    private void Dz() {
        this.lyV = new c(this.mPageContext);
        this.aUP.add(this.lyV);
        this.lyW = new w(this.mPageContext);
        this.aUP.add(this.lyW);
        this.lyU.addAdapters(this.aUP);
    }

    public void notifyDataSetChanged() {
        this.lyU.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<q> list) {
        this.lyU.setData(list);
    }
}
