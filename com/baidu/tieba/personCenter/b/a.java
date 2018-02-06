package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.data.e;
import com.baidu.tieba.personCenter.data.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c giO;
    private d gjc;
    private com.baidu.tieba.personCenter.a.a gjd;
    private com.baidu.tieba.personCenter.a.b gje;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gjc = new d(tbPageContext, f.gjH);
        this.gjd = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.b.gjs);
        this.gje = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.c.gjt);
        this.giO = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.gjG);
        this.mAdapters.add(this.gjc);
        this.mAdapters.add(this.gjd);
        this.mAdapters.add(this.gje);
        this.mAdapters.add(this.giO);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void biG() {
        this.gjd.biG();
    }

    public void biH() {
        this.gjd.destroy();
    }
}
