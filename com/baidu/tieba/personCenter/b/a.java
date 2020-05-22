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
    private BdTypeListView faQ;
    private d kkM;
    private com.baidu.tieba.personCenter.a.a kkN;
    private com.baidu.tieba.personCenter.a.b kkO;
    private f kkP;
    private e kkQ;
    private com.baidu.tieba.personCenter.a.c kkv;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.faQ = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.kkM = new d(tbPageContext, h.klz);
        this.kkN = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.kle);
        this.kkO = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.klf);
        this.kkP = new f(tbPageContext, m.klK);
        this.kkv = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.kly);
        this.kkQ = new e(tbPageContext, j.klF);
        this.aSj.add(this.kkM);
        this.aSj.add(this.kkN);
        this.aSj.add(this.kkO);
        this.aSj.add(this.kkP);
        this.aSj.add(this.kkv);
        this.aSj.add(this.kkQ);
        bdTypeListView.addAdapters(this.aSj);
    }

    public void onChangeSkinType() {
        if (this.faQ != null && (this.faQ.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.faQ.getAdapter().notifyDataSetChanged();
        }
    }

    public void cNe() {
        this.kkN.cNe();
    }

    public void cNf() {
        this.kkN.destroy();
    }
}
