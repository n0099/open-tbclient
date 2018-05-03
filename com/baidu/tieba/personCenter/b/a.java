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
    private d fDA;
    private com.baidu.tieba.personCenter.a.a fDB;
    private com.baidu.tieba.personCenter.a.b fDC;
    private com.baidu.tieba.personCenter.a.c fDn;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fDA = new d(tbPageContext, f.fEf);
        this.fDB = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.b.fDQ);
        this.fDC = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.c.fDR);
        this.fDn = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.fEe);
        this.mAdapters.add(this.fDA);
        this.mAdapters.add(this.fDB);
        this.mAdapters.add(this.fDC);
        this.mAdapters.add(this.fDn);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bdH() {
        this.fDB.bdH();
    }

    public void bdI() {
        this.fDB.destroy();
    }
}
