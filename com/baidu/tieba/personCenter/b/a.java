package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.a.e;
import com.baidu.tieba.personCenter.a.f;
import com.baidu.tieba.personCenter.a.g;
import com.baidu.tieba.personCenter.c.h;
import com.baidu.tieba.personCenter.c.i;
import com.baidu.tieba.personCenter.c.k;
import com.baidu.tieba.personCenter.c.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private BdTypeListView gzp;
    private e mtC;
    private com.baidu.tieba.personCenter.a.a mtD;
    private com.baidu.tieba.personCenter.a.b mtE;
    private g mtF;
    private com.baidu.tieba.personCenter.a.c mtG;
    private f mtH;
    private d mtk;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gzp = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mtC = new e(tbPageContext, i.mus);
        this.mtD = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.mtT);
        this.mtE = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.mtU);
        this.mtF = new g(tbPageContext, n.muD);
        this.mtk = new d(tbPageContext, h.mur);
        this.mtH = new f(tbPageContext, k.muy);
        this.mtG = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.muk);
        this.bns.add(this.mtC);
        this.bns.add(this.mtD);
        this.bns.add(this.mtE);
        this.bns.add(this.mtF);
        this.bns.add(this.mtk);
        this.bns.add(this.mtG);
        this.bns.add(this.mtH);
        bdTypeListView.addAdapters(this.bns);
    }

    public void onChangeSkinType() {
        if (this.gzp != null && (this.gzp.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gzp.getAdapter().notifyDataSetChanged();
        }
    }

    public void dwF() {
        this.mtD.dwF();
    }

    public void dwG() {
        this.mtD.destroy();
    }
}
