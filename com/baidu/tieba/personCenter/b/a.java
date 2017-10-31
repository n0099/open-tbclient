package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
import com.baidu.tieba.personCenter.data.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tieba.personCenter.a.d fib;
    private com.baidu.tieba.personCenter.a.a fic;
    private com.baidu.tieba.personCenter.a.b fie;
    private com.baidu.tieba.personCenter.a.c fif;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fib = new com.baidu.tieba.personCenter.a.d(tbPageContext, f.fiK);
        this.fic = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.a.fis);
        this.fie = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.b.fit);
        this.fif = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.fiJ);
        this.mAdapters.add(this.fib);
        this.mAdapters.add(this.fic);
        this.mAdapters.add(this.fie);
        this.mAdapters.add(this.fif);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void aYk() {
        this.fic.aYk();
    }

    public void aYl() {
        this.fic.destroy();
    }
}
