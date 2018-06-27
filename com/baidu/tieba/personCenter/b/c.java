package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.d;
/* loaded from: classes2.dex */
public class c {
    a fUl;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.fUl = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(d dVar) {
        this.mListView.setData(dVar.fUA);
    }

    public void notifyDataSetChanged() {
        this.fUl.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.fUl.onChangeSkinType();
    }

    public void bjn() {
        this.fUl.bjn();
    }

    public void bjo() {
        this.fUl.bjo();
    }
}
