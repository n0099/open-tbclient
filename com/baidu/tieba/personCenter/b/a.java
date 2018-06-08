package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.data.e;
import com.baidu.tieba.personCenter.data.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c fPN;
    private d fQa;
    private com.baidu.tieba.personCenter.a.a fQb;
    private com.baidu.tieba.personCenter.a.b fQc;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fQa = new d(tbPageContext, f.fQE);
        this.fQb = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.b.fQp);
        this.fQc = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.c.fQq);
        this.fPN = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.fQD);
        this.mAdapters.add(this.fQa);
        this.mAdapters.add(this.fQb);
        this.mAdapters.add(this.fQc);
        this.mAdapters.add(this.fPN);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void biH() {
        this.fQb.biH();
    }

    public void biI() {
        this.fQb.destroy();
    }
}
