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
    private List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private BdTypeListView gih;
    private d lUP;
    private e lVh;
    private com.baidu.tieba.personCenter.a.a lVi;
    private com.baidu.tieba.personCenter.a.b lVj;
    private g lVk;
    private com.baidu.tieba.personCenter.a.c lVl;
    private f lVm;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gih = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.lVh = new e(tbPageContext, i.lVX);
        this.lVi = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.lVy);
        this.lVj = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.lVz);
        this.lVk = new g(tbPageContext, n.lWi);
        this.lUP = new d(tbPageContext, h.lVW);
        this.lVm = new f(tbPageContext, k.lWd);
        this.lVl = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.lVP);
        this.bky.add(this.lVh);
        this.bky.add(this.lVi);
        this.bky.add(this.lVj);
        this.bky.add(this.lVk);
        this.bky.add(this.lUP);
        this.bky.add(this.lVl);
        this.bky.add(this.lVm);
        bdTypeListView.addAdapters(this.bky);
    }

    public void onChangeSkinType() {
        if (this.gih != null && (this.gih.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) {
            this.gih.getAdapter().notifyDataSetChanged();
        }
    }

    public void dty() {
        this.lVi.dty();
    }

    public void dtz() {
        this.lVi.destroy();
    }
}
