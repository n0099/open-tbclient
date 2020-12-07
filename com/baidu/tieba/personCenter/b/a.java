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
    private BdTypeListView gpX;
    private e mjG;
    private com.baidu.tieba.personCenter.a.a mjH;
    private com.baidu.tieba.personCenter.a.b mjI;
    private g mjJ;
    private com.baidu.tieba.personCenter.a.c mjK;
    private f mjL;
    private d mjo;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gpX = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mjG = new e(tbPageContext, i.mkw);
        this.mjH = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.mjX);
        this.mjI = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.mjY);
        this.mjJ = new g(tbPageContext, n.mkI);
        this.mjo = new d(tbPageContext, h.mkv);
        this.mjL = new f(tbPageContext, k.mkC);
        this.mjK = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.mko);
        this.bnf.add(this.mjG);
        this.bnf.add(this.mjH);
        this.bnf.add(this.mjI);
        this.bnf.add(this.mjJ);
        this.bnf.add(this.mjo);
        this.bnf.add(this.mjK);
        this.bnf.add(this.mjL);
        bdTypeListView.addAdapters(this.bnf);
    }

    public void onChangeSkinType() {
        if (this.gpX != null && (this.gpX.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) {
            this.gpX.getAdapter().notifyDataSetChanged();
        }
    }

    public void dyq() {
        this.mjH.dyq();
    }

    public void dyr() {
        this.mjH.destroy();
    }
}
