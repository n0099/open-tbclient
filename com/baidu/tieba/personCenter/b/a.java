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
    private com.baidu.tieba.personCenter.a.c guV;
    private d gvl;
    private com.baidu.tieba.personCenter.a.a gvm;
    private com.baidu.tieba.personCenter.a.b gvn;
    private e gvo;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gvl = new d(tbPageContext, g.gvR);
        this.gvm = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.c.gvB);
        this.gvn = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.d.gvC);
        this.gvo = new e(tbPageContext, i.gvW);
        this.guV = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.gvQ);
        this.mAdapters.add(this.gvl);
        this.mAdapters.add(this.gvm);
        this.mAdapters.add(this.gvn);
        this.mAdapters.add(this.gvo);
        this.mAdapters.add(this.guV);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bpV() {
        this.gvm.bpV();
    }

    public void bpW() {
        this.gvm.destroy();
    }
}
