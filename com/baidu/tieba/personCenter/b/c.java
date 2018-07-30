package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.d;
/* loaded from: classes2.dex */
public class c {
    a fUy;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.fUy = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(d dVar) {
        this.mListView.setData(dVar.fUN);
    }

    public void notifyDataSetChanged() {
        this.fUy.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.fUy.onChangeSkinType();
    }

    public void bhG() {
        this.fUy.bhG();
    }

    public void bhH() {
        this.fUy.bhH();
    }
}
