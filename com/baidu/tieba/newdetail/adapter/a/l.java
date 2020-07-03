package com.baidu.tieba.newdetail.adapter.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bu;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> aUP = new LinkedList();
    private TbPageContext<?> hQz;
    private BdTypeRecyclerView hhX;
    private j jNS;
    private c jNT;
    private e jNU;
    private d jNV;
    private f jNW;
    private k jNX;
    private g jNY;
    private h jNZ;
    private b jOa;
    private m jOb;
    private i jOc;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hQz = tbPageContext;
        this.pageId = bdUniqueId;
        this.hhX = bdTypeRecyclerView;
        Dz();
    }

    private void Dz() {
        this.jNS = new j(this.hQz, bu.dLq, this.pageId);
        this.jNS.a(this.hhX);
        this.aUP.add(this.jNS);
        this.jNT = new c(this.hQz, bu.dLv, this.pageId);
        this.jNT.a(this.hhX);
        this.aUP.add(this.jNT);
        this.jNU = new e(this.hQz, bu.dLt, this.pageId);
        this.jNU.a(this.hhX);
        this.aUP.add(this.jNU);
        this.jNV = new d(this.hQz, bu.dLu, this.pageId);
        this.jNV.a(this.hhX);
        this.aUP.add(this.jNV);
        this.jNW = new f(this.hQz, bu.dLr, this.pageId);
        this.jNW.a(this.hhX);
        this.aUP.add(this.jNW);
        this.jNX = new k(this.hQz, bu.dLH, this.pageId);
        this.jNX.a(this.hhX);
        this.aUP.add(this.jNX);
        this.jNY = new g(this.hQz, bu.dLA, this.pageId);
        this.jNY.a(this.hhX);
        this.aUP.add(this.jNY);
        this.jNZ = new h(this.hQz, bu.dLw, this.pageId);
        this.jNZ.a(this.hhX);
        this.aUP.add(this.jNZ);
        this.jOa = new b(this.hQz, bu.dLz, this.pageId);
        this.jOa.a(this.hhX);
        this.aUP.add(this.jOa);
        this.jOb = new m(this.hQz, bh.dIb);
        this.jOb.a(this.hhX);
        this.aUP.add(this.jOb);
        this.jOc = new i(this.hQz, com.baidu.tieba.card.data.k.dLL);
        this.aUP.add(this.jOc);
        this.hhX.addAdapters(this.aUP);
    }

    public void qZ(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            if (aVar instanceof a) {
                ((a) aVar).qY(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hhX.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends q> list) {
        this.hhX.setData(list);
    }
}
