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
    private com.baidu.tieba.personCenter.a.c jfI;
    private d jfZ;
    private com.baidu.tieba.personCenter.a.a jga;
    private com.baidu.tieba.personCenter.a.b jgb;
    private f jgc;
    private e jgd;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.efW = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jfZ = new d(tbPageContext, h.jgL);
        this.jga = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.d.jgr);
        this.jgb = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.e.jgs);
        this.jgc = new f(tbPageContext, m.jgW);
        this.jfI = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jgK);
        this.jgd = new e(tbPageContext, j.jgR);
        this.apl.add(this.jfZ);
        this.apl.add(this.jga);
        this.apl.add(this.jgb);
        this.apl.add(this.jgc);
        this.apl.add(this.jfI);
        this.apl.add(this.jgd);
        bdTypeListView.addAdapters(this.apl);
    }

    public void onChangeSkinType() {
        if (this.efW != null && (this.efW.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.efW.getAdapter().notifyDataSetChanged();
        }
    }

    public void ctI() {
        this.jga.ctI();
    }

    public void ctJ() {
        this.jga.destroy();
    }
}
