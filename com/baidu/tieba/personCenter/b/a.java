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
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private BdTypeListView efM;
    private com.baidu.tieba.personCenter.a.c jca;
    private d jcr;
    private com.baidu.tieba.personCenter.a.a jcs;
    private com.baidu.tieba.personCenter.a.b jct;
    private f jcu;
    private e jcv;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.efM = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.jcr = new d(tbPageContext, h.jdd);
        this.jcs = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.d.jcJ);
        this.jct = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.e.jcK);
        this.jcu = new f(tbPageContext, m.jdp);
        this.jca = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jdc);
        this.jcv = new e(tbPageContext, j.jdj);
        this.aoz.add(this.jcr);
        this.aoz.add(this.jcs);
        this.aoz.add(this.jct);
        this.aoz.add(this.jcu);
        this.aoz.add(this.jca);
        this.aoz.add(this.jcv);
        bdTypeListView.addAdapters(this.aoz);
    }

    public void onChangeSkinType() {
        if (this.efM != null && (this.efM.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.efM.getAdapter().notifyDataSetChanged();
        }
    }

    public void csz() {
        this.jcs.csz();
    }

    public void csA() {
        this.jcs.destroy();
    }
}
