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
    private com.baidu.tieba.personCenter.a.c icV;
    private d idm;
    private com.baidu.tieba.personCenter.a.a idn;
    private com.baidu.tieba.personCenter.a.b ido;
    private f idp;
    private e idq;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.idm = new d(tbPageContext, h.idW);
        this.idn = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.d.idF);
        this.ido = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.e.idG);
        this.idp = new f(tbPageContext, m.ieg);
        this.icV = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.idV);
        this.idq = new e(tbPageContext, j.iea);
        this.mAdapters.add(this.idm);
        this.mAdapters.add(this.idn);
        this.mAdapters.add(this.ido);
        this.mAdapters.add(this.idp);
        this.mAdapters.add(this.icV);
        this.mAdapters.add(this.idq);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bYl() {
        this.idn.bYl();
    }

    public void bYm() {
        this.idn.destroy();
    }
}
