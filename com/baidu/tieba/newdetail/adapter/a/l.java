package com.baidu.tieba.newdetail.adapter.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bw;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes20.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> bdV = new LinkedList();
    private BdTypeRecyclerView hHG;
    private TbPageContext<?> irP;
    private g kuA;
    private h kuB;
    private b kuC;
    private m kuD;
    private i kuE;
    private j kuu;
    private c kuv;
    private e kuw;
    private d kux;
    private f kuy;
    private k kuz;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.irP = tbPageContext;
        this.pageId = bdUniqueId;
        this.hHG = bdTypeRecyclerView;
        JZ();
    }

    private void JZ() {
        this.kuu = new j(this.irP, bw.edl, this.pageId);
        this.kuu.a(this.hHG);
        this.bdV.add(this.kuu);
        this.kuv = new c(this.irP, bw.edq, this.pageId);
        this.kuv.a(this.hHG);
        this.bdV.add(this.kuv);
        this.kuw = new e(this.irP, bw.edo, this.pageId);
        this.kuw.a(this.hHG);
        this.bdV.add(this.kuw);
        this.kux = new d(this.irP, bw.edp, this.pageId);
        this.kux.a(this.hHG);
        this.bdV.add(this.kux);
        this.kuy = new f(this.irP, bw.edm, this.pageId);
        this.kuy.a(this.hHG);
        this.bdV.add(this.kuy);
        this.kuz = new k(this.irP, bw.edC, this.pageId);
        this.kuz.a(this.hHG);
        this.bdV.add(this.kuz);
        this.kuA = new g(this.irP, bw.edv, this.pageId);
        this.kuA.a(this.hHG);
        this.bdV.add(this.kuA);
        this.kuB = new h(this.irP, bw.edr, this.pageId);
        this.kuB.a(this.hHG);
        this.bdV.add(this.kuB);
        this.kuC = new b(this.irP, bw.edu, this.pageId);
        this.kuC.a(this.hHG);
        this.bdV.add(this.kuC);
        this.kuD = new m(this.irP, bj.dZT);
        this.kuD.a(this.hHG);
        this.bdV.add(this.kuD);
        this.kuE = new i(this.irP, com.baidu.tieba.card.data.l.edG);
        this.bdV.add(this.kuE);
        this.hHG.addAdapters(this.bdV);
    }

    public void su(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            if (aVar instanceof a) {
                ((a) aVar).st(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hHG.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends q> list) {
        this.hHG.setData(list);
    }
}
