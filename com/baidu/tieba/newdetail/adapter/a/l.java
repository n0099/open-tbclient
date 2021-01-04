package com.baidu.tieba.newdetail.adapter.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bz;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> boM = new LinkedList();
    private BdTypeRecyclerView iMU;
    private TbPageContext<?> jzN;
    private j lvc;
    private c lvd;
    private e lve;
    private d lvf;
    private f lvg;
    private k lvh;
    private g lvi;
    private h lvj;
    private b lvk;
    private m lvl;
    private i lvm;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jzN = tbPageContext;
        this.pageId = bdUniqueId;
        this.iMU = bdTypeRecyclerView;
        MT();
    }

    private void MT() {
        this.lvc = new j(this.jzN, bz.eSR, this.pageId);
        this.lvc.a(this.iMU);
        this.boM.add(this.lvc);
        this.lvd = new c(this.jzN, bz.eSW, this.pageId);
        this.lvd.a(this.iMU);
        this.boM.add(this.lvd);
        this.lve = new e(this.jzN, bz.eSU, this.pageId);
        this.lve.a(this.iMU);
        this.boM.add(this.lve);
        this.lvf = new d(this.jzN, bz.eSV, this.pageId);
        this.lvf.a(this.iMU);
        this.boM.add(this.lvf);
        this.lvg = new f(this.jzN, bz.eSS, this.pageId);
        this.lvg.a(this.iMU);
        this.boM.add(this.lvg);
        this.lvh = new k(this.jzN, bz.eTj, this.pageId);
        this.lvh.a(this.iMU);
        this.boM.add(this.lvh);
        this.lvi = new g(this.jzN, bz.eTb, this.pageId);
        this.lvi.a(this.iMU);
        this.boM.add(this.lvi);
        this.lvj = new h(this.jzN, bz.eSX, this.pageId);
        this.lvj.a(this.iMU);
        this.boM.add(this.lvj);
        this.lvk = new b(this.jzN, bz.eTa, this.pageId);
        this.lvk.a(this.iMU);
        this.boM.add(this.lvk);
        this.lvl = new m(this.jzN, bm.ePu);
        this.lvl.a(this.iMU);
        this.boM.add(this.lvl);
        this.lvm = new i(this.jzN, com.baidu.tieba.card.data.k.eTo);
        this.boM.add(this.lvm);
        this.iMU.addAdapters(this.boM);
    }

    public void uh(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            if (aVar instanceof a) {
                ((a) aVar).ug(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iMU.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends n> list) {
        this.iMU.setData(list);
    }
}
