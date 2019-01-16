package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.a.e;
import com.baidu.tieba.personCenter.data.f;
import com.baidu.tieba.personCenter.data.g;
import com.baidu.tieba.personCenter.data.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c guU;
    private d gvk;
    private com.baidu.tieba.personCenter.a.a gvl;
    private com.baidu.tieba.personCenter.a.b gvm;
    private e gvn;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gvk = new d(tbPageContext, g.gvQ);
        this.gvl = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.c.gvA);
        this.gvm = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.d.gvB);
        this.gvn = new e(tbPageContext, i.gvV);
        this.guU = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.gvP);
        this.mAdapters.add(this.gvk);
        this.mAdapters.add(this.gvl);
        this.mAdapters.add(this.gvm);
        this.mAdapters.add(this.gvn);
        this.mAdapters.add(this.guU);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bpV() {
        this.gvl.bpV();
    }

    public void bpW() {
        this.gvl.destroy();
    }
}
