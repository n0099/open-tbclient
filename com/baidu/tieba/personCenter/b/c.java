package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes5.dex */
public class c {
    a gjk;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.gjk = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(e eVar) {
        this.mListView.setData(eVar.dTs);
    }

    public void notifyDataSetChanged() {
        this.gjk.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.gjk.onChangeSkinType();
    }

    public void bnn() {
        this.gjk.bnn();
    }

    public void bno() {
        this.gjk.bno();
    }
}
