package com.baidu.tieba.newdetail.adapter.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bx;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes20.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> biN = new LinkedList();
    private TbPageContext<?> iZN;
    private BdTypeRecyclerView ipO;
    private b lcA;
    private m lcB;
    private i lcC;
    private j lcs;
    private c lct;
    private e lcu;
    private d lcv;
    private f lcw;
    private k lcx;
    private g lcy;
    private h lcz;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iZN = tbPageContext;
        this.pageId = bdUniqueId;
        this.ipO = bdTypeRecyclerView;
        Lp();
    }

    private void Lp() {
        this.lcs = new j(this.iZN, bx.eBX, this.pageId);
        this.lcs.a(this.ipO);
        this.biN.add(this.lcs);
        this.lct = new c(this.iZN, bx.eCc, this.pageId);
        this.lct.a(this.ipO);
        this.biN.add(this.lct);
        this.lcu = new e(this.iZN, bx.eCa, this.pageId);
        this.lcu.a(this.ipO);
        this.biN.add(this.lcu);
        this.lcv = new d(this.iZN, bx.eCb, this.pageId);
        this.lcv.a(this.ipO);
        this.biN.add(this.lcv);
        this.lcw = new f(this.iZN, bx.eBY, this.pageId);
        this.lcw.a(this.ipO);
        this.biN.add(this.lcw);
        this.lcx = new k(this.iZN, bx.eCo, this.pageId);
        this.lcx.a(this.ipO);
        this.biN.add(this.lcx);
        this.lcy = new g(this.iZN, bx.eCh, this.pageId);
        this.lcy.a(this.ipO);
        this.biN.add(this.lcy);
        this.lcz = new h(this.iZN, bx.eCd, this.pageId);
        this.lcz.a(this.ipO);
        this.biN.add(this.lcz);
        this.lcA = new b(this.iZN, bx.eCg, this.pageId);
        this.lcA.a(this.ipO);
        this.biN.add(this.lcA);
        this.lcB = new m(this.iZN, bk.eyF);
        this.lcB.a(this.ipO);
        this.biN.add(this.lcB);
        this.lcC = new i(this.iZN, com.baidu.tieba.card.data.k.eCt);
        this.biN.add(this.lcC);
        this.ipO.addAdapters(this.biN);
    }

    public void tE(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
            if (aVar instanceof a) {
                ((a) aVar).tD(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.ipO.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends q> list) {
        this.ipO.setData(list);
    }
}
