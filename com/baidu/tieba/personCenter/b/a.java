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
    private com.baidu.tieba.personCenter.a.c fUc;
    private d fUp;
    private com.baidu.tieba.personCenter.a.a fUq;
    private com.baidu.tieba.personCenter.a.b fUr;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fUp = new d(tbPageContext, f.fUT);
        this.fUq = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.b.fUE);
        this.fUr = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.c.fUF);
        this.fUc = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.fUS);
        this.mAdapters.add(this.fUp);
        this.mAdapters.add(this.fUq);
        this.mAdapters.add(this.fUr);
        this.mAdapters.add(this.fUc);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bhG() {
        this.fUq.bhG();
    }

    public void bhH() {
        this.fUq.destroy();
    }
}
