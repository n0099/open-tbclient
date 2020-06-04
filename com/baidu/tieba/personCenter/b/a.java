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
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private BdTypeListView fbb;
    private com.baidu.tieba.personCenter.a.c klB;
    private d klS;
    private com.baidu.tieba.personCenter.a.a klT;
    private com.baidu.tieba.personCenter.a.b klU;
    private f klV;
    private e klW;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fbb = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.klS = new d(tbPageContext, h.kmF);
        this.klT = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.kmk);
        this.klU = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.kml);
        this.klV = new f(tbPageContext, m.kmQ);
        this.klB = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.kmE);
        this.klW = new e(tbPageContext, j.kmL);
        this.aSj.add(this.klS);
        this.aSj.add(this.klT);
        this.aSj.add(this.klU);
        this.aSj.add(this.klV);
        this.aSj.add(this.klB);
        this.aSj.add(this.klW);
        bdTypeListView.addAdapters(this.aSj);
    }

    public void onChangeSkinType() {
        if (this.fbb != null && (this.fbb.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.fbb.getAdapter().notifyDataSetChanged();
        }
    }

    public void cNu() {
        this.klT.cNu();
    }

    public void cNv() {
        this.klT.destroy();
    }
}
