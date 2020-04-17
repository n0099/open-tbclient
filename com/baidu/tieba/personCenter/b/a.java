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
    private List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private BdTypeListView eOe;
    private d jSQ;
    private com.baidu.tieba.personCenter.a.a jSR;
    private com.baidu.tieba.personCenter.a.b jSS;
    private f jST;
    private e jSU;
    private com.baidu.tieba.personCenter.a.c jSz;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eOe = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jSQ = new d(tbPageContext, h.jTE);
        this.jSR = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.jTi);
        this.jSS = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.jTj);
        this.jST = new f(tbPageContext, m.jTP);
        this.jSz = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jTD);
        this.jSU = new e(tbPageContext, j.jTK);
        this.aMd.add(this.jSQ);
        this.aMd.add(this.jSR);
        this.aMd.add(this.jSS);
        this.aMd.add(this.jST);
        this.aMd.add(this.jSz);
        this.aMd.add(this.jSU);
        bdTypeListView.addAdapters(this.aMd);
    }

    public void onChangeSkinType() {
        if (this.eOe != null && (this.eOe.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.eOe.getAdapter().notifyDataSetChanged();
        }
    }

    public void cGh() {
        this.jSR.cGh();
    }

    public void cGi() {
        this.jSR.destroy();
    }
}
