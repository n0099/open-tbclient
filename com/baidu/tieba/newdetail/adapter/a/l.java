package com.baidu.tieba.newdetail.adapter.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bw;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes21.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> bhH = new LinkedList();
    private BdTypeRecyclerView hWB;
    private TbPageContext<?> iGI;
    private j kJG;
    private c kJH;
    private e kJI;
    private d kJJ;
    private f kJK;
    private k kJL;
    private g kJM;
    private h kJN;
    private b kJO;
    private m kJP;
    private i kJQ;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iGI = tbPageContext;
        this.pageId = bdUniqueId;
        this.hWB = bdTypeRecyclerView;
        Le();
    }

    private void Le() {
        this.kJG = new j(this.iGI, bw.epq, this.pageId);
        this.kJG.a(this.hWB);
        this.bhH.add(this.kJG);
        this.kJH = new c(this.iGI, bw.epv, this.pageId);
        this.kJH.a(this.hWB);
        this.bhH.add(this.kJH);
        this.kJI = new e(this.iGI, bw.ept, this.pageId);
        this.kJI.a(this.hWB);
        this.bhH.add(this.kJI);
        this.kJJ = new d(this.iGI, bw.epu, this.pageId);
        this.kJJ.a(this.hWB);
        this.bhH.add(this.kJJ);
        this.kJK = new f(this.iGI, bw.epr, this.pageId);
        this.kJK.a(this.hWB);
        this.bhH.add(this.kJK);
        this.kJL = new k(this.iGI, bw.epH, this.pageId);
        this.kJL.a(this.hWB);
        this.bhH.add(this.kJL);
        this.kJM = new g(this.iGI, bw.epA, this.pageId);
        this.kJM.a(this.hWB);
        this.bhH.add(this.kJM);
        this.kJN = new h(this.iGI, bw.epw, this.pageId);
        this.kJN.a(this.hWB);
        this.bhH.add(this.kJN);
        this.kJO = new b(this.iGI, bw.epz, this.pageId);
        this.kJO.a(this.hWB);
        this.bhH.add(this.kJO);
        this.kJP = new m(this.iGI, bj.elV);
        this.kJP.a(this.hWB);
        this.bhH.add(this.kJP);
        this.kJQ = new i(this.iGI, com.baidu.tieba.card.data.l.epL);
        this.bhH.add(this.kJQ);
        this.hWB.addAdapters(this.bhH);
    }

    public void tb(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            if (aVar instanceof a) {
                ((a) aVar).ta(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hWB.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends q> list) {
        this.hWB.setData(list);
    }
}
