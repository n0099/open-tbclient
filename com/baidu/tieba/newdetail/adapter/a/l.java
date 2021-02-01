package com.baidu.tieba.newdetail.adapter.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.cb;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
    private BdTypeRecyclerView iNV;
    private TbPageContext<?> jAN;
    private j lyB;
    private c lyC;
    private e lyD;
    private d lyE;
    private f lyF;
    private k lyG;
    private g lyH;
    private h lyI;
    private b lyJ;
    private m lyK;
    private i lyL;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jAN = tbPageContext;
        this.pageId = bdUniqueId;
        this.iNV = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.lyB = new j(this.jAN, cb.eQs, this.pageId);
        this.lyB.a(this.iNV);
        this.bns.add(this.lyB);
        this.lyC = new c(this.jAN, cb.eQx, this.pageId);
        this.lyC.a(this.iNV);
        this.bns.add(this.lyC);
        this.lyD = new e(this.jAN, cb.eQv, this.pageId);
        this.lyD.a(this.iNV);
        this.bns.add(this.lyD);
        this.lyE = new d(this.jAN, cb.eQw, this.pageId);
        this.lyE.a(this.iNV);
        this.bns.add(this.lyE);
        this.lyF = new f(this.jAN, cb.eQt, this.pageId);
        this.lyF.a(this.iNV);
        this.bns.add(this.lyF);
        this.lyG = new k(this.jAN, cb.eQK, this.pageId);
        this.lyG.a(this.iNV);
        this.bns.add(this.lyG);
        this.lyH = new g(this.jAN, cb.eQC, this.pageId);
        this.lyH.a(this.iNV);
        this.bns.add(this.lyH);
        this.lyI = new h(this.jAN, cb.eQy, this.pageId);
        this.lyI.a(this.iNV);
        this.bns.add(this.lyI);
        this.lyJ = new b(this.jAN, cb.eQB, this.pageId);
        this.lyJ.a(this.iNV);
        this.bns.add(this.lyJ);
        this.lyK = new m(this.jAN, bo.eMV);
        this.lyK.a(this.iNV);
        this.bns.add(this.lyK);
        this.lyL = new i(this.jAN, com.baidu.tieba.card.data.k.eQP);
        this.bns.add(this.lyL);
        this.iNV.addAdapters(this.bns);
    }

    public void uq(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar instanceof a) {
                ((a) aVar).up(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iNV.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends n> list) {
        this.iNV.setData(list);
    }
}
