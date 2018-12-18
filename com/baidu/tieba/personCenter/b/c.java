package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes5.dex */
public class c {
    a grz;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.grz = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(e eVar) {
        this.mListView.setData(eVar.ebb);
    }

    public void notifyDataSetChanged() {
        this.grz.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.grz.onChangeSkinType();
    }

    public void boA() {
        this.grz.boA();
    }

    public void boB() {
        this.grz.boB();
    }
}
