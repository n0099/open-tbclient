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
    private d fDD;
    private com.baidu.tieba.personCenter.a.a fDE;
    private com.baidu.tieba.personCenter.a.b fDF;
    private com.baidu.tieba.personCenter.a.c fDq;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fDD = new d(tbPageContext, f.fEi);
        this.fDE = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.b.fDT);
        this.fDF = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.c.fDU);
        this.fDq = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.fEh);
        this.mAdapters.add(this.fDD);
        this.mAdapters.add(this.fDE);
        this.mAdapters.add(this.fDF);
        this.mAdapters.add(this.fDq);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bdH() {
        this.fDE.bdH();
    }

    public void bdI() {
        this.fDE.destroy();
    }
}
