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
    private d fEG;
    private com.baidu.tieba.personCenter.a.a fEH;
    private com.baidu.tieba.personCenter.a.b fEI;
    private com.baidu.tieba.personCenter.a.c fEt;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fEG = new d(tbPageContext, f.fFl);
        this.fEH = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.b.fEW);
        this.fEI = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.c.fEX);
        this.fEt = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.fFk);
        this.mAdapters.add(this.fEG);
        this.mAdapters.add(this.fEH);
        this.mAdapters.add(this.fEI);
        this.mAdapters.add(this.fEt);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bdH() {
        this.fEH.bdH();
    }

    public void bdI() {
        this.fEH.destroy();
    }
}
