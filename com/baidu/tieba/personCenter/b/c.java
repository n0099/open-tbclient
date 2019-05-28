package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.f;
/* loaded from: classes4.dex */
public class c {
    a idz;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.idz = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(f fVar) {
        this.mListView.setData(fVar.fIX);
    }

    public void notifyDataSetChanged() {
        this.idz.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.idz.onChangeSkinType();
    }

    public void bYl() {
        this.idz.bYl();
    }

    public void bYm() {
        this.idz.bYm();
    }
}
