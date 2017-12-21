package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.data.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private d fsB;
    private com.baidu.tieba.personCenter.a.a fsC;
    private com.baidu.tieba.personCenter.a.b fsD;
    private com.baidu.tieba.personCenter.a.c fsq;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fsB = new d(tbPageContext, e.fte);
        this.fsC = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.a.fsQ);
        this.fsD = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.b.fsR);
        this.fsq = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.data.d.ftd);
        this.mAdapters.add(this.fsB);
        this.mAdapters.add(this.fsC);
        this.mAdapters.add(this.fsD);
        this.mAdapters.add(this.fsq);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void bad() {
        this.fsC.bad();
    }

    public void bae() {
        this.fsC.destroy();
    }
}
