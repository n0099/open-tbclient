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
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private BdTypeListView gwr;
    private d mjT;
    private e mkl;
    private com.baidu.tieba.personCenter.a.a mkm;
    private com.baidu.tieba.personCenter.a.b mkn;
    private g mko;
    private com.baidu.tieba.personCenter.a.c mkp;
    private f mkq;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gwr = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mkl = new e(tbPageContext, i.mlb);
        this.mkm = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.mkC);
        this.mkn = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.mkD);
        this.mko = new g(tbPageContext, n.mln);
        this.mjT = new d(tbPageContext, h.mla);
        this.mkq = new f(tbPageContext, k.mlh);
        this.mkp = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.mkT);
        this.bjZ.add(this.mkl);
        this.bjZ.add(this.mkm);
        this.bjZ.add(this.mkn);
        this.bjZ.add(this.mko);
        this.bjZ.add(this.mjT);
        this.bjZ.add(this.mkp);
        this.bjZ.add(this.mkq);
        bdTypeListView.addAdapters(this.bjZ);
    }

    public void onChangeSkinType() {
        if (this.gwr != null && (this.gwr.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }

    public void dup() {
        this.mkm.dup();
    }

    public void duq() {
        this.mkm.destroy();
    }
}
