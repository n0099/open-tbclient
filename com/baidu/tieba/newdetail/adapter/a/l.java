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
    private List<com.baidu.adp.widget.ListView.a> bky = new LinkedList();
    private TbPageContext<?> iZb;
    private BdTypeRecyclerView ipa;
    private j lca;
    private c lcb;
    private e lcc;
    private d lcd;
    private f lce;
    private k lcf;
    private g lcg;
    private h lch;
    private b lci;
    private m lcj;
    private i lck;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iZb = tbPageContext;
        this.pageId = bdUniqueId;
        this.ipa = bdTypeRecyclerView;
        LY();
    }

    private void LY() {
        this.lca = new j(this.iZb, bw.eDF, this.pageId);
        this.lca.a(this.ipa);
        this.bky.add(this.lca);
        this.lcb = new c(this.iZb, bw.eDK, this.pageId);
        this.lcb.a(this.ipa);
        this.bky.add(this.lcb);
        this.lcc = new e(this.iZb, bw.eDI, this.pageId);
        this.lcc.a(this.ipa);
        this.bky.add(this.lcc);
        this.lcd = new d(this.iZb, bw.eDJ, this.pageId);
        this.lcd.a(this.ipa);
        this.bky.add(this.lcd);
        this.lce = new f(this.iZb, bw.eDG, this.pageId);
        this.lce.a(this.ipa);
        this.bky.add(this.lce);
        this.lcf = new k(this.iZb, bw.eDW, this.pageId);
        this.lcf.a(this.ipa);
        this.bky.add(this.lcf);
        this.lcg = new g(this.iZb, bw.eDP, this.pageId);
        this.lcg.a(this.ipa);
        this.bky.add(this.lcg);
        this.lch = new h(this.iZb, bw.eDL, this.pageId);
        this.lch.a(this.ipa);
        this.bky.add(this.lch);
        this.lci = new b(this.iZb, bw.eDO, this.pageId);
        this.lci.a(this.ipa);
        this.bky.add(this.lci);
        this.lcj = new m(this.iZb, bj.eAo);
        this.lcj.a(this.ipa);
        this.bky.add(this.lcj);
        this.lck = new i(this.iZb, com.baidu.tieba.card.data.l.eEb);
        this.bky.add(this.lck);
        this.ipa.addAdapters(this.bky);
    }

    public void tB(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            if (aVar instanceof a) {
                ((a) aVar).tA(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.ipa.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends q> list) {
        this.ipa.setData(list);
    }
}
