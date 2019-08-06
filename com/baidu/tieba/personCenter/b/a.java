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
    private d ikG;
    private com.baidu.tieba.personCenter.a.a ikH;
    private com.baidu.tieba.personCenter.a.b ikI;
    private f ikJ;
    private e ikK;
    private com.baidu.tieba.personCenter.a.c ikq;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ikG = new d(tbPageContext, h.ilp);
        this.ikH = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.d.ikX);
        this.ikI = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.e.ikY);
        this.ikJ = new f(tbPageContext, m.ilA);
        this.ikq = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.ilo);
        this.ikK = new e(tbPageContext, j.ilu);
        this.mAdapters.add(this.ikG);
        this.mAdapters.add(this.ikH);
        this.mAdapters.add(this.ikI);
        this.mAdapters.add(this.ikJ);
        this.mAdapters.add(this.ikq);
        this.mAdapters.add(this.ikK);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void cbt() {
        this.ikH.cbt();
    }

    public void cbu() {
        this.ikH.destroy();
    }
}
