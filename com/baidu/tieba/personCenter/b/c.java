package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes5.dex */
public class c {
    a gjj;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.gjj = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(e eVar) {
        this.mListView.setData(eVar.dTr);
    }

    public void notifyDataSetChanged() {
        this.gjj.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.gjj.onChangeSkinType();
    }

    public void bnn() {
        this.gjj.bnn();
    }

    public void bno() {
        this.gjj.bno();
    }
}
