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
/* loaded from: classes2.dex */
public class a {
    private e gbA;
    private com.baidu.tieba.personCenter.a.c gbk;
    private d gbx;
    private com.baidu.tieba.personCenter.a.a gby;
    private com.baidu.tieba.personCenter.a.b gbz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gbx = new d(tbPageContext, g.gcd);
        this.gby = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.c.gbN);
        this.gbz = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.d.gbO);
        this.gbA = new e(tbPageContext, i.gci);
        this.gbk = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.gcc);
        this.mAdapters.add(this.gbx);
        this.mAdapters.add(this.gby);
        this.mAdapters.add(this.gbz);
        this.mAdapters.add(this.gbA);
        this.mAdapters.add(this.gbk);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bkc() {
        this.gby.bkc();
    }

    public void bkd() {
        this.gby.destroy();
    }
}
