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
    private List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private BdTypeListView eOj;
    private com.baidu.tieba.personCenter.a.c jSD;
    private d jSU;
    private com.baidu.tieba.personCenter.a.a jSV;
    private com.baidu.tieba.personCenter.a.b jSW;
    private f jSX;
    private e jSY;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eOj = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jSU = new d(tbPageContext, h.jTI);
        this.jSV = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.jTm);
        this.jSW = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.jTn);
        this.jSX = new f(tbPageContext, m.jTT);
        this.jSD = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jTH);
        this.jSY = new e(tbPageContext, j.jTO);
        this.aMj.add(this.jSU);
        this.aMj.add(this.jSV);
        this.aMj.add(this.jSW);
        this.aMj.add(this.jSX);
        this.aMj.add(this.jSD);
        this.aMj.add(this.jSY);
        bdTypeListView.addAdapters(this.aMj);
    }

    public void onChangeSkinType() {
        if (this.eOj != null && (this.eOj.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.eOj.getAdapter().notifyDataSetChanged();
        }
    }

    public void cGe() {
        this.jSV.cGe();
    }

    public void cGf() {
        this.jSV.destroy();
    }
}
