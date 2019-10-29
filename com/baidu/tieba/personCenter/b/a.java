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
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private BdTypeListView dvB;
    private com.baidu.tieba.personCenter.a.c ikZ;
    private d ilp;
    private com.baidu.tieba.personCenter.a.a ilq;
    private com.baidu.tieba.personCenter.a.b ilr;
    private f ils;
    private e ilt;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.dvB = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ilp = new d(tbPageContext, h.ilZ);
        this.ilq = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.d.ilG);
        this.ilr = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.e.ilH);
        this.ils = new f(tbPageContext, m.iml);
        this.ikZ = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.ilY);
        this.ilt = new e(tbPageContext, j.ime);
        this.agQ.add(this.ilp);
        this.agQ.add(this.ilq);
        this.agQ.add(this.ilr);
        this.agQ.add(this.ils);
        this.agQ.add(this.ikZ);
        this.agQ.add(this.ilt);
        bdTypeListView.addAdapters(this.agQ);
    }

    public void onChangeSkinType() {
        if (this.dvB != null && (this.dvB.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dvB.getAdapter().notifyDataSetChanged();
        }
    }

    public void bZj() {
        this.ilq.bZj();
    }

    public void bZk() {
        this.ilq.destroy();
    }
}
