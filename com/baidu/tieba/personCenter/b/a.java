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
/* loaded from: classes21.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private BdTypeListView fGf;
    private g lnA;
    private com.baidu.tieba.personCenter.a.c lnB;
    private f lnC;
    private d lne;
    private e lnx;
    private com.baidu.tieba.personCenter.a.a lny;
    private com.baidu.tieba.personCenter.a.b lnz;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fGf = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.lnx = new e(tbPageContext, i.lor);
        this.lny = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.lnO);
        this.lnz = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.lnP);
        this.lnA = new g(tbPageContext, n.loD);
        this.lne = new d(tbPageContext, h.loq);
        this.lnC = new f(tbPageContext, k.loy);
        this.lnB = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.loh);
        this.bdV.add(this.lnx);
        this.bdV.add(this.lny);
        this.bdV.add(this.lnz);
        this.bdV.add(this.lnA);
        this.bdV.add(this.lne);
        this.bdV.add(this.lnB);
        this.bdV.add(this.lnC);
        bdTypeListView.addAdapters(this.bdV);
    }

    public void onChangeSkinType() {
        if (this.fGf != null && (this.fGf.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) {
            this.fGf.getAdapter().notifyDataSetChanged();
        }
    }

    public void dkf() {
        this.lny.dkf();
    }

    public void dkg() {
        this.lny.destroy();
    }
}
