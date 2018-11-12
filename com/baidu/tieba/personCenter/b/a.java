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
    private com.baidu.tieba.personCenter.a.a gkA;
    private com.baidu.tieba.personCenter.a.b gkB;
    private e gkC;
    private com.baidu.tieba.personCenter.a.c gkj;
    private d gkz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gkz = new d(tbPageContext, g.glf);
        this.gkA = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.c.gkP);
        this.gkB = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.d.gkQ);
        this.gkC = new e(tbPageContext, i.glk);
        this.gkj = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.gle);
        this.mAdapters.add(this.gkz);
        this.mAdapters.add(this.gkA);
        this.mAdapters.add(this.gkB);
        this.mAdapters.add(this.gkC);
        this.mAdapters.add(this.gkj);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bmI() {
        this.gkA.bmI();
    }

    public void bmJ() {
        this.gkA.destroy();
    }
}
