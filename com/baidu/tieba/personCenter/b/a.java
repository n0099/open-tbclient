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
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private BdTypeListView gAY;
    private e moR;
    private com.baidu.tieba.personCenter.a.a moS;
    private com.baidu.tieba.personCenter.a.b moT;
    private g moU;
    private com.baidu.tieba.personCenter.a.c moV;
    private f moW;
    private d moz;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gAY = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.moR = new e(tbPageContext, i.mpH);
        this.moS = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.mpi);
        this.moT = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.mpj);
        this.moU = new g(tbPageContext, n.mpT);
        this.moz = new d(tbPageContext, h.mpG);
        this.moW = new f(tbPageContext, k.mpN);
        this.moV = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.mpz);
        this.boM.add(this.moR);
        this.boM.add(this.moS);
        this.boM.add(this.moT);
        this.boM.add(this.moU);
        this.boM.add(this.moz);
        this.boM.add(this.moV);
        this.boM.add(this.moW);
        bdTypeListView.addAdapters(this.boM);
    }

    public void onChangeSkinType() {
        if (this.gAY != null && (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public void dyg() {
        this.moS.dyg();
    }

    public void dyh() {
        this.moS.destroy();
    }
}
