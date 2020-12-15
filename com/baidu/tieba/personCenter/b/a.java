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
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private BdTypeListView gpZ;
    private e mjI;
    private com.baidu.tieba.personCenter.a.a mjJ;
    private com.baidu.tieba.personCenter.a.b mjK;
    private g mjL;
    private com.baidu.tieba.personCenter.a.c mjM;
    private f mjN;
    private d mjq;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gpZ = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mjI = new e(tbPageContext, i.mky);
        this.mjJ = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.mjZ);
        this.mjK = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.mka);
        this.mjL = new g(tbPageContext, n.mkK);
        this.mjq = new d(tbPageContext, h.mkx);
        this.mjN = new f(tbPageContext, k.mkE);
        this.mjM = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.mkq);
        this.bnf.add(this.mjI);
        this.bnf.add(this.mjJ);
        this.bnf.add(this.mjK);
        this.bnf.add(this.mjL);
        this.bnf.add(this.mjq);
        this.bnf.add(this.mjM);
        this.bnf.add(this.mjN);
        bdTypeListView.addAdapters(this.bnf);
    }

    public void onChangeSkinType() {
        if (this.gpZ != null && (this.gpZ.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) {
            this.gpZ.getAdapter().notifyDataSetChanged();
        }
    }

    public void dyr() {
        this.mjJ.dyr();
    }

    public void dys() {
        this.mjJ.destroy();
    }
}
