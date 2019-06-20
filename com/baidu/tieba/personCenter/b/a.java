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
    private com.baidu.tieba.personCenter.a.c icW;
    private d idn;
    private com.baidu.tieba.personCenter.a.a ido;
    private com.baidu.tieba.personCenter.a.b idp;
    private f idq;
    private e idr;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.idn = new d(tbPageContext, h.idX);
        this.ido = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.d.idG);
        this.idp = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.e.idH);
        this.idq = new f(tbPageContext, m.ieh);
        this.icW = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.idW);
        this.idr = new e(tbPageContext, j.ieb);
        this.mAdapters.add(this.idn);
        this.mAdapters.add(this.ido);
        this.mAdapters.add(this.idp);
        this.mAdapters.add(this.idq);
        this.mAdapters.add(this.icW);
        this.mAdapters.add(this.idr);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bYm() {
        this.ido.bYm();
    }

    public void bYn() {
        this.ido.destroy();
    }
}
