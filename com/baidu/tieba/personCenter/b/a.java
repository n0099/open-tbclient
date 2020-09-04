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
/* loaded from: classes16.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private BdTypeListView fCT;
    private e leF;
    private com.baidu.tieba.personCenter.a.a leG;
    private com.baidu.tieba.personCenter.a.b leH;
    private g leI;
    private com.baidu.tieba.personCenter.a.c leJ;
    private f leK;
    private d leo;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fCT = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.leF = new e(tbPageContext, i.lfw);
        this.leG = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.leW);
        this.leH = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.leX);
        this.leI = new g(tbPageContext, n.lfH);
        this.leo = new d(tbPageContext, h.lfv);
        this.leK = new f(tbPageContext, k.lfC);
        this.leJ = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.lfn);
        this.bbw.add(this.leF);
        this.bbw.add(this.leG);
        this.bbw.add(this.leH);
        this.bbw.add(this.leI);
        this.bbw.add(this.leo);
        this.bbw.add(this.leJ);
        this.bbw.add(this.leK);
        bdTypeListView.addAdapters(this.bbw);
    }

    public void onChangeSkinType() {
        if (this.fCT != null && (this.fCT.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) {
            this.fCT.getAdapter().notifyDataSetChanged();
        }
    }

    public void dgA() {
        this.leG.dgA();
    }

    public void dgB() {
        this.leG.destroy();
    }
}
