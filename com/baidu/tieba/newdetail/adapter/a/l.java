package com.baidu.tieba.newdetail.adapter.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bv;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes15.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> aWf = new LinkedList();
    private TbPageContext<?> hWA;
    private BdTypeRecyclerView hnH;
    private b jWA;
    private m jWB;
    private i jWC;
    private j jWs;
    private c jWt;
    private e jWu;
    private d jWv;
    private f jWw;
    private k jWx;
    private g jWy;
    private h jWz;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hWA = tbPageContext;
        this.pageId = bdUniqueId;
        this.hnH = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.jWs = new j(this.hWA, bv.dRB, this.pageId);
        this.jWs.a(this.hnH);
        this.aWf.add(this.jWs);
        this.jWt = new c(this.hWA, bv.dRG, this.pageId);
        this.jWt.a(this.hnH);
        this.aWf.add(this.jWt);
        this.jWu = new e(this.hWA, bv.dRE, this.pageId);
        this.jWu.a(this.hnH);
        this.aWf.add(this.jWu);
        this.jWv = new d(this.hWA, bv.dRF, this.pageId);
        this.jWv.a(this.hnH);
        this.aWf.add(this.jWv);
        this.jWw = new f(this.hWA, bv.dRC, this.pageId);
        this.jWw.a(this.hnH);
        this.aWf.add(this.jWw);
        this.jWx = new k(this.hWA, bv.dRS, this.pageId);
        this.jWx.a(this.hnH);
        this.aWf.add(this.jWx);
        this.jWy = new g(this.hWA, bv.dRL, this.pageId);
        this.jWy.a(this.hnH);
        this.aWf.add(this.jWy);
        this.jWz = new h(this.hWA, bv.dRH, this.pageId);
        this.jWz.a(this.hnH);
        this.aWf.add(this.jWz);
        this.jWA = new b(this.hWA, bv.dRK, this.pageId);
        this.jWA.a(this.hnH);
        this.aWf.add(this.jWA);
        this.jWB = new m(this.hWA, bi.dOm);
        this.jWB.a(this.hnH);
        this.aWf.add(this.jWB);
        this.jWC = new i(this.hWA, com.baidu.tieba.card.data.k.dRW);
        this.aWf.add(this.jWC);
        this.hnH.addAdapters(this.aWf);
    }

    public void rE(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            if (aVar instanceof a) {
                ((a) aVar).rD(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hnH.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends q> list) {
        this.hnH.setData(list);
    }
}
