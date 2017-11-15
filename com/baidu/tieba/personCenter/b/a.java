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
    private com.baidu.tieba.personCenter.a.a fiA;
    private com.baidu.tieba.personCenter.a.b fiB;
    private com.baidu.tieba.personCenter.a.c fiC;
    private com.baidu.tieba.personCenter.a.d fiz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fiz = new com.baidu.tieba.personCenter.a.d(tbPageContext, f.fjh);
        this.fiA = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.a.fiP);
        this.fiB = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.b.fiQ);
        this.fiC = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.fjg);
        this.mAdapters.add(this.fiz);
        this.mAdapters.add(this.fiA);
        this.mAdapters.add(this.fiB);
        this.mAdapters.add(this.fiC);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void aYs() {
        this.fiA.aYs();
    }

    public void aYt() {
        this.fiA.destroy();
    }
}
