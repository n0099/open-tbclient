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
    private d hLC;
    private com.baidu.tieba.personCenter.a.a hLD;
    private com.baidu.tieba.personCenter.a.b hLE;
    private e hLF;
    private com.baidu.tieba.personCenter.a.c hLm;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.hLC = new d(tbPageContext, g.hMi);
        this.hLD = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.c.hLS);
        this.hLE = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.d.hLT);
        this.hLF = new e(tbPageContext, i.hMm);
        this.hLm = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.hMh);
        this.mAdapters.add(this.hLC);
        this.mAdapters.add(this.hLD);
        this.mAdapters.add(this.hLE);
        this.mAdapters.add(this.hLF);
        this.mAdapters.add(this.hLm);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bQr() {
        this.hLD.bQr();
    }

    public void bQs() {
        this.hLD.destroy();
    }
}
