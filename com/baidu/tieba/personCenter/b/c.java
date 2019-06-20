package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.f;
/* loaded from: classes4.dex */
public class c {
    a idA;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.idA = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(f fVar) {
        this.mListView.setData(fVar.fIZ);
    }

    public void notifyDataSetChanged() {
        this.idA.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.idA.onChangeSkinType();
    }

    public void bYm() {
        this.idA.bYm();
    }

    public void bYn() {
        this.idA.bYn();
    }
}
