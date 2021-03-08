package com.baidu.tieba.newdetail.adapter.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.cb;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> boS = new LinkedList();
    private BdTypeRecyclerView iPS;
    private TbPageContext<?> jCK;
    private j lAR;
    private c lAS;
    private e lAT;
    private d lAU;
    private f lAV;
    private k lAW;
    private g lAX;
    private h lAY;
    private b lAZ;
    private m lBa;
    private i lBb;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jCK = tbPageContext;
        this.pageId = bdUniqueId;
        this.iPS = bdTypeRecyclerView;
        Kz();
    }

    private void Kz() {
        this.lAR = new j(this.jCK, cb.eRT, this.pageId);
        this.lAR.a(this.iPS);
        this.boS.add(this.lAR);
        this.lAS = new c(this.jCK, cb.eRY, this.pageId);
        this.lAS.a(this.iPS);
        this.boS.add(this.lAS);
        this.lAT = new e(this.jCK, cb.eRW, this.pageId);
        this.lAT.a(this.iPS);
        this.boS.add(this.lAT);
        this.lAU = new d(this.jCK, cb.eRX, this.pageId);
        this.lAU.a(this.iPS);
        this.boS.add(this.lAU);
        this.lAV = new f(this.jCK, cb.eRU, this.pageId);
        this.lAV.a(this.iPS);
        this.boS.add(this.lAV);
        this.lAW = new k(this.jCK, cb.eSl, this.pageId);
        this.lAW.a(this.iPS);
        this.boS.add(this.lAW);
        this.lAX = new g(this.jCK, cb.eSd, this.pageId);
        this.lAX.a(this.iPS);
        this.boS.add(this.lAX);
        this.lAY = new h(this.jCK, cb.eRZ, this.pageId);
        this.lAY.a(this.iPS);
        this.boS.add(this.lAY);
        this.lAZ = new b(this.jCK, cb.eSc, this.pageId);
        this.lAZ.a(this.iPS);
        this.boS.add(this.lAZ);
        this.lBa = new m(this.jCK, bo.eOw);
        this.lBa.a(this.iPS);
        this.boS.add(this.lBa);
        this.lBb = new i(this.jCK, com.baidu.tieba.card.data.k.eSq);
        this.boS.add(this.lBb);
        this.iPS.addAdapters(this.boS);
    }

    public void uq(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            if (aVar instanceof a) {
                ((a) aVar).up(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iPS.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends n> list) {
        this.iPS.setData(list);
    }
}
