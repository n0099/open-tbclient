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
    private com.baidu.tieba.personCenter.a.c fTU;
    private d fUh;
    private com.baidu.tieba.personCenter.a.a fUi;
    private com.baidu.tieba.personCenter.a.b fUj;
    private e fUk;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fUh = new d(tbPageContext, g.fUO);
        this.fUi = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.c.fUx);
        this.fUj = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.d.fUy);
        this.fUk = new e(tbPageContext, i.fUT);
        this.fTU = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.fUN);
        this.mAdapters.add(this.fUh);
        this.mAdapters.add(this.fUi);
        this.mAdapters.add(this.fUj);
        this.mAdapters.add(this.fUk);
        this.mAdapters.add(this.fTU);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bhB() {
        this.fUi.bhB();
    }

    public void bhC() {
        this.fUi.destroy();
    }
}
