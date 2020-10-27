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
    private List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private BdTypeListView gcr;
    private d lOT;
    private e lPl;
    private com.baidu.tieba.personCenter.a.a lPm;
    private com.baidu.tieba.personCenter.a.b lPn;
    private g lPo;
    private com.baidu.tieba.personCenter.a.c lPp;
    private f lPq;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gcr = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.lPl = new e(tbPageContext, i.lQb);
        this.lPm = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.lPC);
        this.lPn = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.lPD);
        this.lPo = new g(tbPageContext, n.lQm);
        this.lOT = new d(tbPageContext, h.lQa);
        this.lPq = new f(tbPageContext, k.lQh);
        this.lPp = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.lPT);
        this.bje.add(this.lPl);
        this.bje.add(this.lPm);
        this.bje.add(this.lPn);
        this.bje.add(this.lPo);
        this.bje.add(this.lOT);
        this.bje.add(this.lPp);
        this.bje.add(this.lPq);
        bdTypeListView.addAdapters(this.bje);
    }

    public void onChangeSkinType() {
        if (this.gcr != null && (this.gcr.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) {
            this.gcr.getAdapter().notifyDataSetChanged();
        }
    }

    public void dqW() {
        this.lPm.dqW();
    }

    public void dqX() {
        this.lPm.destroy();
    }
}
