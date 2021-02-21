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
    private BdTypeRecyclerView iOj;
    private TbPageContext<?> jBb;
    private j lyP;
    private c lyQ;
    private e lyR;
    private d lyS;
    private f lyT;
    private k lyU;
    private g lyV;
    private h lyW;
    private b lyX;
    private m lyY;
    private i lyZ;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jBb = tbPageContext;
        this.pageId = bdUniqueId;
        this.iOj = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.lyP = new j(this.jBb, cb.eQs, this.pageId);
        this.lyP.a(this.iOj);
        this.bns.add(this.lyP);
        this.lyQ = new c(this.jBb, cb.eQx, this.pageId);
        this.lyQ.a(this.iOj);
        this.bns.add(this.lyQ);
        this.lyR = new e(this.jBb, cb.eQv, this.pageId);
        this.lyR.a(this.iOj);
        this.bns.add(this.lyR);
        this.lyS = new d(this.jBb, cb.eQw, this.pageId);
        this.lyS.a(this.iOj);
        this.bns.add(this.lyS);
        this.lyT = new f(this.jBb, cb.eQt, this.pageId);
        this.lyT.a(this.iOj);
        this.bns.add(this.lyT);
        this.lyU = new k(this.jBb, cb.eQK, this.pageId);
        this.lyU.a(this.iOj);
        this.bns.add(this.lyU);
        this.lyV = new g(this.jBb, cb.eQC, this.pageId);
        this.lyV.a(this.iOj);
        this.bns.add(this.lyV);
        this.lyW = new h(this.jBb, cb.eQy, this.pageId);
        this.lyW.a(this.iOj);
        this.bns.add(this.lyW);
        this.lyX = new b(this.jBb, cb.eQB, this.pageId);
        this.lyX.a(this.iOj);
        this.bns.add(this.lyX);
        this.lyY = new m(this.jBb, bo.eMV);
        this.lyY.a(this.iOj);
        this.bns.add(this.lyY);
        this.lyZ = new i(this.jBb, com.baidu.tieba.card.data.k.eQP);
        this.bns.add(this.lyZ);
        this.iOj.addAdapters(this.bns);
    }

    public void uq(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar instanceof a) {
                ((a) aVar).up(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iOj.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends n> list) {
        this.iOj.setData(list);
    }
}
