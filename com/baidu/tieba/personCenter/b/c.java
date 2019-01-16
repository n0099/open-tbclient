package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes5.dex */
public class c {
    a gvu;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.gvu = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(e eVar) {
        this.mListView.setData(eVar.eey);
    }

    public void notifyDataSetChanged() {
        this.gvu.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.gvu.onChangeSkinType();
    }

    public void bpV() {
        this.gvu.bpV();
    }

    public void bpW() {
        this.gvu.bpW();
    }
}
