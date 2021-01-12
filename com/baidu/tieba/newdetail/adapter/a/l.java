package com.baidu.tieba.newdetail.adapter.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bz;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> bjZ = new LinkedList();
    private BdTypeRecyclerView iIn;
    private TbPageContext<?> jvh;
    private f lqA;
    private k lqB;
    private g lqC;
    private h lqD;
    private b lqE;
    private m lqF;
    private i lqG;
    private j lqw;
    private c lqx;
    private e lqy;
    private d lqz;
    private BdUniqueId pageId;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jvh = tbPageContext;
        this.pageId = bdUniqueId;
        this.iIn = bdTypeRecyclerView;
        IY();
    }

    private void IY() {
        this.lqw = new j(this.jvh, bz.eOg, this.pageId);
        this.lqw.a(this.iIn);
        this.bjZ.add(this.lqw);
        this.lqx = new c(this.jvh, bz.eOl, this.pageId);
        this.lqx.a(this.iIn);
        this.bjZ.add(this.lqx);
        this.lqy = new e(this.jvh, bz.eOj, this.pageId);
        this.lqy.a(this.iIn);
        this.bjZ.add(this.lqy);
        this.lqz = new d(this.jvh, bz.eOk, this.pageId);
        this.lqz.a(this.iIn);
        this.bjZ.add(this.lqz);
        this.lqA = new f(this.jvh, bz.eOh, this.pageId);
        this.lqA.a(this.iIn);
        this.bjZ.add(this.lqA);
        this.lqB = new k(this.jvh, bz.eOy, this.pageId);
        this.lqB.a(this.iIn);
        this.bjZ.add(this.lqB);
        this.lqC = new g(this.jvh, bz.eOq, this.pageId);
        this.lqC.a(this.iIn);
        this.bjZ.add(this.lqC);
        this.lqD = new h(this.jvh, bz.eOm, this.pageId);
        this.lqD.a(this.iIn);
        this.bjZ.add(this.lqD);
        this.lqE = new b(this.jvh, bz.eOp, this.pageId);
        this.lqE.a(this.iIn);
        this.bjZ.add(this.lqE);
        this.lqF = new m(this.jvh, bm.eKJ);
        this.lqF.a(this.iIn);
        this.bjZ.add(this.lqF);
        this.lqG = new i(this.jvh, com.baidu.tieba.card.data.k.eOD);
        this.bjZ.add(this.lqG);
        this.iIn.addAdapters(this.bjZ);
    }

    public void ud(boolean z) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            if (aVar instanceof a) {
                ((a) aVar).uc(z);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iIn.getAdapter().notifyDataSetChanged();
    }

    public void setData(List<? extends n> list) {
        this.iIn.setData(list);
    }
}
