package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes2.dex */
public class c {
    a fUr;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.fUr = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(e eVar) {
        this.mListView.setData(eVar.fUI);
    }

    public void notifyDataSetChanged() {
        this.fUr.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.fUr.onChangeSkinType();
    }

    public void bhB() {
        this.fUr.bhB();
    }

    public void bhC() {
        this.fUr.bhC();
    }
}
