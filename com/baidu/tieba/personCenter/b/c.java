package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes5.dex */
public class c {
    a gvv;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.gvv = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(e eVar) {
        this.mListView.setData(eVar.eez);
    }

    public void notifyDataSetChanged() {
        this.gvv.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.gvv.onChangeSkinType();
    }

    public void bpV() {
        this.gvv.bpV();
    }

    public void bpW() {
        this.gvv.bpW();
    }
}
