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
    private BdTypeRecyclerView iAI;
    private TbPageContext<?> jnp;
    private j lpU;
    private c lpV;
    private e lpW;
    private d lpX;
    private f lpY;
    private k lpZ;
    private g lqa;
    private h lqb;
    private b lqc;
    private m lqd;
    private i lqe;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jnp = tbPageContext;
        this.pageId = bdUniqueId;
        this.iAI = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.lpU = new j(this.jnp, by.eIY, this.pageId);
        this.lpU.a(this.iAI);
        this.bnf.add(this.lpU);
        this.lpV = new c(this.jnp, by.eJd, this.pageId);
        this.lpV.a(this.iAI);
        this.bnf.add(this.lpV);
        this.lpW = new e(this.jnp, by.eJb, this.pageId);
        this.lpW.a(this.iAI);
        this.bnf.add(this.lpW);
        this.lpX = new d(this.jnp, by.eJc, this.pageId);
        this.lpX.a(this.iAI);
        this.bnf.add(this.lpX);
        this.lpY = new f(this.jnp, by.eIZ, this.pageId);
        this.lpY.a(this.iAI);
        this.bnf.add(this.lpY);
        this.lpZ = new k(this.jnp, by.eJq, this.pageId);
        this.lpZ.a(this.iAI);
        this.bnf.add(this.lpZ);
        this.lqa = new g(this.jnp, by.eJi, this.pageId);
        this.lqa.a(this.iAI);
        this.bnf.add(this.lqa);
        this.lqb = new h(this.jnp, by.eJe, this.pageId);
        this.lqb.a(this.iAI);
        this.bnf.add(this.lqb);
        this.lqc = new b(this.jnp, by.eJh, this.pageId);
        this.lqc.a(this.iAI);
        this.bnf.add(this.lqc);
        this.lqd = new m(this.jnp, bl.eFE);
        this.lqd.a(this.iAI);
        this.bnf.add(this.lqd);
        this.lqe = new i(this.jnp, com.baidu.tieba.card.data.k.eJv);
        this.bnf.add(this.lqe);
        this.iAI.addAdapters(this.bnf);
    }

    public void ug(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            if (aVar instanceof a) {
                ((a) aVar).uf(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iAI.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends q> list) {
        this.iAI.setData(list);
    }
}
