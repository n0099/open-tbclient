package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
import com.baidu.tieba.personCenter.data.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tieba.personCenter.a.d frw;
    private com.baidu.tieba.personCenter.a.a frx;
    private com.baidu.tieba.personCenter.a.b fry;
    private com.baidu.tieba.personCenter.a.c frz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.frw = new com.baidu.tieba.personCenter.a.d(tbPageContext, f.fse);
        this.frx = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.a.frM);
        this.fry = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.b.frN);
        this.frz = new com.baidu.tieba.personCenter.a.c(tbPageContext, e.fsd);
        this.mAdapters.add(this.frw);
        this.mAdapters.add(this.frx);
        this.mAdapters.add(this.fry);
        this.mAdapters.add(this.frz);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void aZU() {
        this.frx.aZU();
    }

    public void aZV() {
        this.frx.destroy();
    }
}
