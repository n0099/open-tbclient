package com.baidu.tieba.square.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes21.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> biN = new LinkedList();
    private TbPageContext<?> mPageContext;
    private BdTypeRecyclerView mQM;
    private c mQN;
    private y mQO;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.mQM = bdTypeRecyclerView;
        Lp();
    }

    private void Lp() {
        this.mQN = new c(this.mPageContext);
        this.biN.add(this.mQN);
        this.mQO = new y(this.mPageContext);
        this.biN.add(this.mQO);
        this.mQM.addAdapters(this.biN);
    }

    public void notifyDataSetChanged() {
        this.mQM.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<q> list) {
        this.mQM.setData(list);
    }
}
