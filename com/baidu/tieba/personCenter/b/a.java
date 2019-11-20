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
    private List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private BdTypeListView duK;
    private com.baidu.tieba.personCenter.a.b ikA;
    private f ikB;
    private e ikC;
    private com.baidu.tieba.personCenter.a.c iki;
    private d iky;
    private com.baidu.tieba.personCenter.a.a ikz;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.duK = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.iky = new d(tbPageContext, h.ili);
        this.ikz = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.d.ikP);
        this.ikA = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.e.ikQ);
        this.ikB = new f(tbPageContext, m.ilt);
        this.iki = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.ilh);
        this.ikC = new e(tbPageContext, j.iln);
        this.agy.add(this.iky);
        this.agy.add(this.ikz);
        this.agy.add(this.ikA);
        this.agy.add(this.ikB);
        this.agy.add(this.iki);
        this.agy.add(this.ikC);
        bdTypeListView.addAdapters(this.agy);
    }

    public void onChangeSkinType() {
        if (this.duK != null && (this.duK.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.duK.getAdapter().notifyDataSetChanged();
        }
    }

    public void bZh() {
        this.ikz.bZh();
    }

    public void bZi() {
        this.ikz.destroy();
    }
}
