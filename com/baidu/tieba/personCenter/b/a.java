package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.c.e;
import com.baidu.tieba.personCenter.c.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tieba.personCenter.a.d faa;
    private com.baidu.tieba.personCenter.a.a fab;
    private com.baidu.tieba.personCenter.a.b fac;
    private com.baidu.tieba.personCenter.a.c fad;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.faa = new com.baidu.tieba.personCenter.a.d(tbPageContext, f.faG);
        this.fab = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.a.faq);
        this.fac = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.b.far);
        this.fad = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.faF);
        this.mAdapters.add(this.faa);
        this.mAdapters.add(this.fab);
        this.mAdapters.add(this.fac);
        this.mAdapters.add(this.fad);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void aVm() {
        this.fab.aVm();
    }

    public void aVn() {
        this.fab.destroy();
    }
}
