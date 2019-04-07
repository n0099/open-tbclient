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
/* loaded from: classes4.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c hKS;
    private d hLi;
    private com.baidu.tieba.personCenter.a.a hLj;
    private com.baidu.tieba.personCenter.a.b hLk;
    private e hLl;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.hLi = new d(tbPageContext, g.hLO);
        this.hLj = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.c.hLy);
        this.hLk = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.d.hLz);
        this.hLl = new e(tbPageContext, i.hLS);
        this.hKS = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.hLN);
        this.mAdapters.add(this.hLi);
        this.mAdapters.add(this.hLj);
        this.mAdapters.add(this.hLk);
        this.mAdapters.add(this.hLl);
        this.mAdapters.add(this.hKS);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bQp() {
        this.hLj.bQp();
    }

    public void bQq() {
        this.hLj.destroy();
    }
}
