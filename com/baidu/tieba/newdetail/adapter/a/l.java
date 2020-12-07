package com.baidu.tieba.newdetail.adapter.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.by;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes21.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
    private BdTypeRecyclerView iAG;
    private TbPageContext<?> jnn;
    private j lpS;
    private c lpT;
    private e lpU;
    private d lpV;
    private f lpW;
    private k lpX;
    private g lpY;
    private h lpZ;
    private b lqa;
    private m lqb;
    private i lqc;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jnn = tbPageContext;
        this.pageId = bdUniqueId;
        this.iAG = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.lpS = new j(this.jnn, by.eIY, this.pageId);
        this.lpS.a(this.iAG);
        this.bnf.add(this.lpS);
        this.lpT = new c(this.jnn, by.eJd, this.pageId);
        this.lpT.a(this.iAG);
        this.bnf.add(this.lpT);
        this.lpU = new e(this.jnn, by.eJb, this.pageId);
        this.lpU.a(this.iAG);
        this.bnf.add(this.lpU);
        this.lpV = new d(this.jnn, by.eJc, this.pageId);
        this.lpV.a(this.iAG);
        this.bnf.add(this.lpV);
        this.lpW = new f(this.jnn, by.eIZ, this.pageId);
        this.lpW.a(this.iAG);
        this.bnf.add(this.lpW);
        this.lpX = new k(this.jnn, by.eJq, this.pageId);
        this.lpX.a(this.iAG);
        this.bnf.add(this.lpX);
        this.lpY = new g(this.jnn, by.eJi, this.pageId);
        this.lpY.a(this.iAG);
        this.bnf.add(this.lpY);
        this.lpZ = new h(this.jnn, by.eJe, this.pageId);
        this.lpZ.a(this.iAG);
        this.bnf.add(this.lpZ);
        this.lqa = new b(this.jnn, by.eJh, this.pageId);
        this.lqa.a(this.iAG);
        this.bnf.add(this.lqa);
        this.lqb = new m(this.jnn, bl.eFE);
        this.lqb.a(this.iAG);
        this.bnf.add(this.lqb);
        this.lqc = new i(this.jnn, com.baidu.tieba.card.data.k.eJv);
        this.bnf.add(this.lqc);
        this.iAG.addAdapters(this.bnf);
    }

    public void ug(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            if (aVar instanceof a) {
                ((a) aVar).uf(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iAG.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends q> list) {
        this.iAG.setData(list);
    }
}
