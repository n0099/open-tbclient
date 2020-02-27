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
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private BdTypeListView eka;
    private com.baidu.tieba.personCenter.a.c jgE;
    private d jgS;
    private com.baidu.tieba.personCenter.a.a jgT;
    private com.baidu.tieba.personCenter.a.b jgU;
    private f jgV;
    private e jgW;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eka = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jgS = new d(tbPageContext, h.jhE);
        this.jgT = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.jhk);
        this.jgU = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.jhl);
        this.jgV = new f(tbPageContext, m.jhP);
        this.jgE = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jhD);
        this.jgW = new e(tbPageContext, j.jhK);
        this.asE.add(this.jgS);
        this.asE.add(this.jgT);
        this.asE.add(this.jgU);
        this.asE.add(this.jgV);
        this.asE.add(this.jgE);
        this.asE.add(this.jgW);
        bdTypeListView.addAdapters(this.asE);
    }

    public void onChangeSkinType() {
        if (this.eka != null && (this.eka.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.eka.getAdapter().notifyDataSetChanged();
        }
    }

    public void cvb() {
        this.jgT.cvb();
    }

    public void cvc() {
        this.jgT.destroy();
    }
}
