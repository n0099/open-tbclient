package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.a.e;
import com.baidu.tieba.personCenter.a.f;
import com.baidu.tieba.personCenter.c.g;
import com.baidu.tieba.personCenter.c.h;
import com.baidu.tieba.personCenter.c.j;
import com.baidu.tieba.personCenter.c.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private BdTypeListView eko;
    private com.baidu.tieba.personCenter.a.c jgS;
    private d jhg;
    private com.baidu.tieba.personCenter.a.a jhh;
    private com.baidu.tieba.personCenter.a.b jhi;
    private f jhj;
    private e jhk;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eko = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jhg = new d(tbPageContext, h.jhS);
        this.jhh = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.jhy);
        this.jhi = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.jhz);
        this.jhj = new f(tbPageContext, m.jie);
        this.jgS = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jhR);
        this.jhk = new e(tbPageContext, j.jhY);
        this.asF.add(this.jhg);
        this.asF.add(this.jhh);
        this.asF.add(this.jhi);
        this.asF.add(this.jhj);
        this.asF.add(this.jgS);
        this.asF.add(this.jhk);
        bdTypeListView.addAdapters(this.asF);
    }

    public void onChangeSkinType() {
        if (this.eko != null && (this.eko.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.eko.getAdapter().notifyDataSetChanged();
        }
    }

    public void cve() {
        this.jhh.cve();
    }

    public void cvf() {
        this.jhh.destroy();
    }
}
