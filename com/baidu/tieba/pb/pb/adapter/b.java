package com.baidu.tieba.pb.pb.adapter;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> jVU = new ArrayList();
    private BdTypeRecyclerView jVV;
    private c lHT;
    private d lHU;
    private e lHV;
    private f lHW;
    private g lHX;
    private h lHY;
    private List<n> mDataList;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jVV = bdTypeRecyclerView;
        this.mPageContext = tbPageContext;
        MT();
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jVU);
    }

    private void MT() {
        this.lHV = new e(this.mPageContext, k.izL);
        this.lHU = new d(this.mPageContext, k.izM);
        this.lHT = new c(this.mPageContext, k.izN);
        this.lHW = new f(this.mPageContext, k.eSQ);
        this.lHX = new g(this.mPageContext, k.izP);
        this.lHY = new h(this.mPageContext, l.eTj);
        this.jVU.add(this.lHV);
        this.jVU.add(this.lHU);
        this.jVU.add(this.lHT);
        this.jVU.add(this.lHW);
        this.jVU.add(this.lHX);
        this.jVU.add(this.lHY);
    }

    private void a(s sVar) {
        this.lHV.a(sVar);
        this.lHU.a(sVar);
        this.lHT.a(sVar);
        this.lHW.a(sVar);
        this.lHX.a(sVar);
        this.lHY.a(sVar);
    }

    public void cC(List<n> list) {
        this.mDataList = list;
        this.jVV.setData(list);
    }

    public void onChangeSkinType() {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.jVV != null) {
            this.jVV.getListAdapter().notifyDataSetChanged();
        }
    }
}
