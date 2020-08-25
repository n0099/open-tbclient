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
/* loaded from: classes16.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private BdTypeListView fCP;
    private com.baidu.tieba.personCenter.a.b leA;
    private g leB;
    private com.baidu.tieba.personCenter.a.c leC;
    private f leD;
    private d leg;
    private e ley;
    private com.baidu.tieba.personCenter.a.a lez;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fCP = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ley = new e(tbPageContext, i.lfp);
        this.lez = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.leP);
        this.leA = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.leQ);
        this.leB = new g(tbPageContext, n.lfA);
        this.leg = new d(tbPageContext, h.lfo);
        this.leD = new f(tbPageContext, k.lfv);
        this.leC = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.lfg);
        this.bbu.add(this.ley);
        this.bbu.add(this.lez);
        this.bbu.add(this.leA);
        this.bbu.add(this.leB);
        this.bbu.add(this.leg);
        this.bbu.add(this.leC);
        this.bbu.add(this.leD);
        bdTypeListView.addAdapters(this.bbu);
    }

    public void onChangeSkinType() {
        if (this.fCP != null && (this.fCP.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }

    public void dgz() {
        this.lez.dgz();
    }

    public void dgA() {
        this.lez.destroy();
    }
}
