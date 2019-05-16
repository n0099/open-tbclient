package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.f;
/* loaded from: classes4.dex */
public class c {
    a idw;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.idw = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(f fVar) {
        this.mListView.setData(fVar.fIW);
    }

    public void notifyDataSetChanged() {
        this.idw.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.idw.onChangeSkinType();
    }

    public void bYi() {
        this.idw.bYi();
    }

    public void bYj() {
        this.idw.bYj();
    }
}
