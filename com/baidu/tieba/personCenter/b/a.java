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
    private d hLB;
    private com.baidu.tieba.personCenter.a.a hLC;
    private com.baidu.tieba.personCenter.a.b hLD;
    private e hLE;
    private com.baidu.tieba.personCenter.a.c hLl;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.hLB = new d(tbPageContext, g.hMh);
        this.hLC = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.c.hLR);
        this.hLD = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.d.hLS);
        this.hLE = new e(tbPageContext, i.hMl);
        this.hLl = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.hMg);
        this.mAdapters.add(this.hLB);
        this.mAdapters.add(this.hLC);
        this.mAdapters.add(this.hLD);
        this.mAdapters.add(this.hLE);
        this.mAdapters.add(this.hLl);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bQq() {
        this.hLC.bQq();
    }

    public void bQr() {
        this.hLC.destroy();
    }
}
