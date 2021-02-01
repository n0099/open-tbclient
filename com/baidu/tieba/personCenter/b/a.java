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
    private BdTypeListView gzb;
    private d msV;
    private e mtn;
    private com.baidu.tieba.personCenter.a.a mto;
    private com.baidu.tieba.personCenter.a.b mtp;
    private g mtq;
    private com.baidu.tieba.personCenter.a.c mtr;
    private f mts;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gzb = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mtn = new e(tbPageContext, i.mud);
        this.mto = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.mtE);
        this.mtp = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.mtF);
        this.mtq = new g(tbPageContext, n.muo);
        this.msV = new d(tbPageContext, h.muc);
        this.mts = new f(tbPageContext, k.muj);
        this.mtr = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.mtV);
        this.bns.add(this.mtn);
        this.bns.add(this.mto);
        this.bns.add(this.mtp);
        this.bns.add(this.mtq);
        this.bns.add(this.msV);
        this.bns.add(this.mtr);
        this.bns.add(this.mts);
        bdTypeListView.addAdapters(this.bns);
    }

    public void onChangeSkinType() {
        if (this.gzb != null && (this.gzb.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }

    public void dwy() {
        this.mto.dwy();
    }

    public void dwz() {
        this.mto.destroy();
    }
}
