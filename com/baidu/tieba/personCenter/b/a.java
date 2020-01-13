package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.a.e;
import com.baidu.tieba.personCenter.a.f;
import com.baidu.tieba.personCenter.data.g;
import com.baidu.tieba.personCenter.data.h;
import com.baidu.tieba.personCenter.data.j;
import com.baidu.tieba.personCenter.data.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private BdTypeListView efW;
    private com.baidu.tieba.personCenter.a.c jfD;
    private d jfU;
    private com.baidu.tieba.personCenter.a.a jfV;
    private com.baidu.tieba.personCenter.a.b jfW;
    private f jfX;
    private e jfY;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.efW = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jfU = new d(tbPageContext, h.jgG);
        this.jfV = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.d.jgm);
        this.jfW = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.e.jgn);
        this.jfX = new f(tbPageContext, m.jgR);
        this.jfD = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jgF);
        this.jfY = new e(tbPageContext, j.jgM);
        this.apl.add(this.jfU);
        this.apl.add(this.jfV);
        this.apl.add(this.jfW);
        this.apl.add(this.jfX);
        this.apl.add(this.jfD);
        this.apl.add(this.jfY);
        bdTypeListView.addAdapters(this.apl);
    }

    public void onChangeSkinType() {
        if (this.efW != null && (this.efW.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.efW.getAdapter().notifyDataSetChanged();
        }
    }

    public void ctG() {
        this.jfV.ctG();
    }

    public void ctH() {
        this.jfV.destroy();
    }
}
