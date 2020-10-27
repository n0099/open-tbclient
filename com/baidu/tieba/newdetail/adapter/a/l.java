package com.baidu.tieba.newdetail.adapter.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bw;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes21.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> bje = new LinkedList();
    private TbPageContext<?> iTe;
    private BdTypeRecyclerView ijb;
    private j kWd;
    private c kWe;
    private e kWf;
    private d kWg;
    private f kWh;
    private k kWi;
    private g kWj;
    private h kWk;
    private b kWl;
    private m kWm;
    private i kWn;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iTe = tbPageContext;
        this.pageId = bdUniqueId;
        this.ijb = bdTypeRecyclerView;
        Ly();
    }

    private void Ly() {
        this.kWd = new j(this.iTe, bw.exO, this.pageId);
        this.kWd.a(this.ijb);
        this.bje.add(this.kWd);
        this.kWe = new c(this.iTe, bw.exT, this.pageId);
        this.kWe.a(this.ijb);
        this.bje.add(this.kWe);
        this.kWf = new e(this.iTe, bw.exR, this.pageId);
        this.kWf.a(this.ijb);
        this.bje.add(this.kWf);
        this.kWg = new d(this.iTe, bw.exS, this.pageId);
        this.kWg.a(this.ijb);
        this.bje.add(this.kWg);
        this.kWh = new f(this.iTe, bw.exP, this.pageId);
        this.kWh.a(this.ijb);
        this.bje.add(this.kWh);
        this.kWi = new k(this.iTe, bw.eyg, this.pageId);
        this.kWi.a(this.ijb);
        this.bje.add(this.kWi);
        this.kWj = new g(this.iTe, bw.exY, this.pageId);
        this.kWj.a(this.ijb);
        this.bje.add(this.kWj);
        this.kWk = new h(this.iTe, bw.exU, this.pageId);
        this.kWk.a(this.ijb);
        this.bje.add(this.kWk);
        this.kWl = new b(this.iTe, bw.exX, this.pageId);
        this.kWl.a(this.ijb);
        this.bje.add(this.kWl);
        this.kWm = new m(this.iTe, bj.euv);
        this.kWm.a(this.ijb);
        this.bje.add(this.kWm);
        this.kWn = new i(this.iTe, com.baidu.tieba.card.data.l.eyl);
        this.bje.add(this.kWn);
        this.ijb.addAdapters(this.bje);
    }

    public void ts(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            if (aVar instanceof a) {
                ((a) aVar).tr(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.ijb.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends q> list) {
        this.ijb.setData(list);
    }
}
