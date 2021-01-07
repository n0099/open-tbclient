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
    private e moQ;
    private com.baidu.tieba.personCenter.a.a moR;
    private com.baidu.tieba.personCenter.a.b moS;
    private g moT;
    private com.baidu.tieba.personCenter.a.c moU;
    private f moV;
    private d moy;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gAY = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.moQ = new e(tbPageContext, i.mpG);
        this.moR = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.d.mph);
        this.moS = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.e.mpi);
        this.moT = new g(tbPageContext, n.mpS);
        this.moy = new d(tbPageContext, h.mpF);
        this.moV = new f(tbPageContext, k.mpM);
        this.moU = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.c.g.mpy);
        this.boM.add(this.moQ);
        this.boM.add(this.moR);
        this.boM.add(this.moS);
        this.boM.add(this.moT);
        this.boM.add(this.moy);
        this.boM.add(this.moU);
        this.boM.add(this.moV);
        bdTypeListView.addAdapters(this.boM);
    }

    public void onChangeSkinType() {
        if (this.gAY != null && (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public void dyh() {
        this.moR.dyh();
    }

    public void dyi() {
        this.moR.destroy();
    }
}
