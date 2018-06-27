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
    private com.baidu.tieba.personCenter.a.c fTP;
    private d fUc;
    private com.baidu.tieba.personCenter.a.a fUd;
    private com.baidu.tieba.personCenter.a.b fUe;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fUc = new d(tbPageContext, f.fUG);
        this.fUd = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.b.fUr);
        this.fUe = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.c.fUs);
        this.fTP = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.fUF);
        this.mAdapters.add(this.fUc);
        this.mAdapters.add(this.fUd);
        this.mAdapters.add(this.fUe);
        this.mAdapters.add(this.fTP);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bjn() {
        this.fUd.bjn();
    }

    public void bjo() {
        this.fUd.destroy();
    }
}
