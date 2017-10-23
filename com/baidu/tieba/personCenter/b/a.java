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
    private com.baidu.tieba.personCenter.a.d eZM;
    private com.baidu.tieba.personCenter.a.a eZN;
    private com.baidu.tieba.personCenter.a.b eZO;
    private com.baidu.tieba.personCenter.a.c eZP;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eZM = new com.baidu.tieba.personCenter.a.d(tbPageContext, f.fas);
        this.eZN = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.c.a.fac);
        this.eZO = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.c.b.fad);
        this.eZP = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.far);
        this.mAdapters.add(this.eZM);
        this.mAdapters.add(this.eZN);
        this.mAdapters.add(this.eZO);
        this.mAdapters.add(this.eZP);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void aVh() {
        this.eZN.aVh();
    }

    public void aVi() {
        this.eZN.destroy();
    }
}
