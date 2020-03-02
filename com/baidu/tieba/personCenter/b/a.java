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
    private BdTypeListView ekb;
    private com.baidu.tieba.personCenter.a.c jgG;
    private d jgU;
    private com.baidu.tieba.personCenter.a.a jgV;
    private com.baidu.tieba.personCenter.a.b jgW;
    private f jgX;
    private e jgY;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ekb = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jgU = new d(tbPageContext, h.jhG);
        this.jgV = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.jhm);
        this.jgW = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.jhn);
        this.jgX = new f(tbPageContext, m.jhR);
        this.jgG = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jhF);
        this.jgY = new e(tbPageContext, j.jhM);
        this.asE.add(this.jgU);
        this.asE.add(this.jgV);
        this.asE.add(this.jgW);
        this.asE.add(this.jgX);
        this.asE.add(this.jgG);
        this.asE.add(this.jgY);
        bdTypeListView.addAdapters(this.asE);
    }

    public void onChangeSkinType() {
        if (this.ekb != null && (this.ekb.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.ekb.getAdapter().notifyDataSetChanged();
        }
    }

    public void cvd() {
        this.jgV.cvd();
    }

    public void cve() {
        this.jgV.destroy();
    }
}
