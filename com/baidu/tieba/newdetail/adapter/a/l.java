package com.baidu.tieba.newdetail.adapter.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bw;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes15.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> bbu = new LinkedList();
    private BdTypeRecyclerView hAy;
    private TbPageContext<?> ikH;
    private j klO;
    private c klP;
    private e klQ;
    private d klR;
    private f klS;
    private k klT;
    private g klU;
    private h klV;
    private b klW;
    private m klX;
    private i klY;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ikH = tbPageContext;
        this.pageId = bdUniqueId;
        this.hAy = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.klO = new j(this.ikH, bw.eaX, this.pageId);
        this.klO.a(this.hAy);
        this.bbu.add(this.klO);
        this.klP = new c(this.ikH, bw.ebc, this.pageId);
        this.klP.a(this.hAy);
        this.bbu.add(this.klP);
        this.klQ = new e(this.ikH, bw.eba, this.pageId);
        this.klQ.a(this.hAy);
        this.bbu.add(this.klQ);
        this.klR = new d(this.ikH, bw.ebb, this.pageId);
        this.klR.a(this.hAy);
        this.bbu.add(this.klR);
        this.klS = new f(this.ikH, bw.eaY, this.pageId);
        this.klS.a(this.hAy);
        this.bbu.add(this.klS);
        this.klT = new k(this.ikH, bw.ebo, this.pageId);
        this.klT.a(this.hAy);
        this.bbu.add(this.klT);
        this.klU = new g(this.ikH, bw.ebh, this.pageId);
        this.klU.a(this.hAy);
        this.bbu.add(this.klU);
        this.klV = new h(this.ikH, bw.ebd, this.pageId);
        this.klV.a(this.hAy);
        this.bbu.add(this.klV);
        this.klW = new b(this.ikH, bw.ebg, this.pageId);
        this.klW.a(this.hAy);
        this.bbu.add(this.klW);
        this.klX = new m(this.ikH, bj.dXF);
        this.klX.a(this.hAy);
        this.bbu.add(this.klX);
        this.klY = new i(this.ikH, com.baidu.tieba.card.data.l.ebs);
        this.bbu.add(this.klY);
        this.hAy.addAdapters(this.bbu);
    }

    public void sk(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            if (aVar instanceof a) {
                ((a) aVar).sj(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hAy.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends q> list) {
        this.hAy.setData(list);
    }
}
