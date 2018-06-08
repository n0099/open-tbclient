package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.d;
/* loaded from: classes2.dex */
public class c {
    a fQj;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.fQj = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(d dVar) {
        this.mListView.setData(dVar.fQy);
    }

    public void notifyDataSetChanged() {
        this.fQj.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.fQj.onChangeSkinType();
    }

    public void biH() {
        this.fQj.biH();
    }

    public void biI() {
        this.fQj.biI();
    }
}
