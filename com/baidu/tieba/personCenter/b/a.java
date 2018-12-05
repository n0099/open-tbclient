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
    private com.baidu.tieba.personCenter.a.c gqZ;
    private d grp;
    private com.baidu.tieba.personCenter.a.a grq;
    private com.baidu.tieba.personCenter.a.b grr;
    private e grs;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.grp = new d(tbPageContext, g.grV);
        this.grq = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.c.grF);
        this.grr = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.d.grG);
        this.grs = new e(tbPageContext, i.gsa);
        this.gqZ = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.grU);
        this.mAdapters.add(this.grp);
        this.mAdapters.add(this.grq);
        this.mAdapters.add(this.grr);
        this.mAdapters.add(this.grs);
        this.mAdapters.add(this.gqZ);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void boB() {
        this.grq.boB();
    }

    public void boC() {
        this.grq.destroy();
    }
}
