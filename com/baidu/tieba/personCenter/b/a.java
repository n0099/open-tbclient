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
    private com.baidu.tieba.personCenter.a.c giM;
    private d giZ;
    private com.baidu.tieba.personCenter.a.a gja;
    private com.baidu.tieba.personCenter.a.b gjb;
    private e gjc;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.giZ = new d(tbPageContext, g.gjF);
        this.gja = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.c.gjp);
        this.gjb = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.d.gjq);
        this.gjc = new e(tbPageContext, i.gjK);
        this.giM = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.gjE);
        this.mAdapters.add(this.giZ);
        this.mAdapters.add(this.gja);
        this.mAdapters.add(this.gjb);
        this.mAdapters.add(this.gjc);
        this.mAdapters.add(this.giM);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bnn() {
        this.gja.bnn();
    }

    public void bno() {
        this.gja.destroy();
    }
}
