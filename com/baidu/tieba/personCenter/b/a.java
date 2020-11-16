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
    private List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private BdTypeListView ghN;
    private com.baidu.tieba.personCenter.a.a lVA;
    private com.baidu.tieba.personCenter.a.b lVB;
    private g lVC;
    private com.baidu.tieba.personCenter.a.c lVD;
    private f lVE;
    private d lVh;
    private e lVz;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ghN = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.lVz = new e(tbPageContext, i.lWp);
        this.lVA = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.lVQ);
        this.lVB = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.lVR);
        this.lVC = new g(tbPageContext, n.lWA);
        this.lVh = new d(tbPageContext, h.lWo);
        this.lVE = new f(tbPageContext, k.lWv);
        this.lVD = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.lWh);
        this.biN.add(this.lVz);
        this.biN.add(this.lVA);
        this.biN.add(this.lVB);
        this.biN.add(this.lVC);
        this.biN.add(this.lVh);
        this.biN.add(this.lVD);
        this.biN.add(this.lVE);
        bdTypeListView.addAdapters(this.biN);
    }

    public void onChangeSkinType() {
        if (this.ghN != null && (this.ghN.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) {
            this.ghN.getAdapter().notifyDataSetChanged();
        }
    }

    public void dsY() {
        this.lVA.dsY();
    }

    public void dsZ() {
        this.lVA.destroy();
    }
}
