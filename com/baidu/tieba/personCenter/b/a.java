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
/* loaded from: classes5.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c giN;
    private d gja;
    private com.baidu.tieba.personCenter.a.a gjb;
    private com.baidu.tieba.personCenter.a.b gjc;
    private e gjd;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gja = new d(tbPageContext, g.gjG);
        this.gjb = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.c.gjq);
        this.gjc = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.d.gjr);
        this.gjd = new e(tbPageContext, i.gjL);
        this.giN = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.gjF);
        this.mAdapters.add(this.gja);
        this.mAdapters.add(this.gjb);
        this.mAdapters.add(this.gjc);
        this.mAdapters.add(this.gjd);
        this.mAdapters.add(this.giN);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bnn() {
        this.gjb.bnn();
    }

    public void bno() {
        this.gjb.destroy();
    }
}
