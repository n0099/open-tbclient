package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.data.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c fsl;
    private d fsw;
    private com.baidu.tieba.personCenter.a.a fsx;
    private com.baidu.tieba.personCenter.a.b fsy;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fsw = new d(tbPageContext, e.fsZ);
        this.fsx = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.a.fsL);
        this.fsy = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.b.fsM);
        this.fsl = new com.baidu.tieba.personCenter.a.c(tbPageContext, com.baidu.tieba.personCenter.data.d.fsY);
        this.mAdapters.add(this.fsw);
        this.mAdapters.add(this.fsx);
        this.mAdapters.add(this.fsy);
        this.mAdapters.add(this.fsl);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void bac() {
        this.fsx.bac();
    }

    public void bad() {
        this.fsx.destroy();
    }
}
