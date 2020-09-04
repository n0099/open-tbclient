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
    private List<com.baidu.adp.widget.ListView.a> bbw = new LinkedList();
    private BdTypeRecyclerView hAE;
    private TbPageContext<?> ikN;
    private j klV;
    private c klW;
    private e klX;
    private d klY;
    private f klZ;
    private k kma;
    private g kmb;
    private h kmc;
    private b kmd;
    private m kme;
    private i kmf;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ikN = tbPageContext;
        this.pageId = bdUniqueId;
        this.hAE = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.klV = new j(this.ikN, bw.ebb, this.pageId);
        this.klV.a(this.hAE);
        this.bbw.add(this.klV);
        this.klW = new c(this.ikN, bw.ebg, this.pageId);
        this.klW.a(this.hAE);
        this.bbw.add(this.klW);
        this.klX = new e(this.ikN, bw.ebe, this.pageId);
        this.klX.a(this.hAE);
        this.bbw.add(this.klX);
        this.klY = new d(this.ikN, bw.ebf, this.pageId);
        this.klY.a(this.hAE);
        this.bbw.add(this.klY);
        this.klZ = new f(this.ikN, bw.ebc, this.pageId);
        this.klZ.a(this.hAE);
        this.bbw.add(this.klZ);
        this.kma = new k(this.ikN, bw.ebs, this.pageId);
        this.kma.a(this.hAE);
        this.bbw.add(this.kma);
        this.kmb = new g(this.ikN, bw.ebl, this.pageId);
        this.kmb.a(this.hAE);
        this.bbw.add(this.kmb);
        this.kmc = new h(this.ikN, bw.ebh, this.pageId);
        this.kmc.a(this.hAE);
        this.bbw.add(this.kmc);
        this.kmd = new b(this.ikN, bw.ebk, this.pageId);
        this.kmd.a(this.hAE);
        this.bbw.add(this.kmd);
        this.kme = new m(this.ikN, bj.dXJ);
        this.kme.a(this.hAE);
        this.bbw.add(this.kme);
        this.kmf = new i(this.ikN, com.baidu.tieba.card.data.l.ebw);
        this.bbw.add(this.kmf);
        this.hAE.addAdapters(this.bbw);
    }

    public void sm(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            if (aVar instanceof a) {
                ((a) aVar).sl(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hAE.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends q> list) {
        this.hAE.setData(list);
    }
}
