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
    private TbPageContext<?> hWy;
    private BdTypeRecyclerView hnH;
    private i jWA;
    private j jWq;
    private c jWr;
    private e jWs;
    private d jWt;
    private f jWu;
    private k jWv;
    private g jWw;
    private h jWx;
    private b jWy;
    private m jWz;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hWy = tbPageContext;
        this.pageId = bdUniqueId;
        this.hnH = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.jWq = new j(this.hWy, bv.dRB, this.pageId);
        this.jWq.a(this.hnH);
        this.aWf.add(this.jWq);
        this.jWr = new c(this.hWy, bv.dRG, this.pageId);
        this.jWr.a(this.hnH);
        this.aWf.add(this.jWr);
        this.jWs = new e(this.hWy, bv.dRE, this.pageId);
        this.jWs.a(this.hnH);
        this.aWf.add(this.jWs);
        this.jWt = new d(this.hWy, bv.dRF, this.pageId);
        this.jWt.a(this.hnH);
        this.aWf.add(this.jWt);
        this.jWu = new f(this.hWy, bv.dRC, this.pageId);
        this.jWu.a(this.hnH);
        this.aWf.add(this.jWu);
        this.jWv = new k(this.hWy, bv.dRS, this.pageId);
        this.jWv.a(this.hnH);
        this.aWf.add(this.jWv);
        this.jWw = new g(this.hWy, bv.dRL, this.pageId);
        this.jWw.a(this.hnH);
        this.aWf.add(this.jWw);
        this.jWx = new h(this.hWy, bv.dRH, this.pageId);
        this.jWx.a(this.hnH);
        this.aWf.add(this.jWx);
        this.jWy = new b(this.hWy, bv.dRK, this.pageId);
        this.jWy.a(this.hnH);
        this.aWf.add(this.jWy);
        this.jWz = new m(this.hWy, bi.dOm);
        this.jWz.a(this.hnH);
        this.aWf.add(this.jWz);
        this.jWA = new i(this.hWy, com.baidu.tieba.card.data.k.dRW);
        this.aWf.add(this.jWA);
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
