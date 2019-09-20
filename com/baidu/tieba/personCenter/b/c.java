package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.f;
/* loaded from: classes4.dex */
public class c {
    a imR;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.imR = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(f fVar) {
        this.mListView.setData(fVar.fQB);
    }

    public void notifyDataSetChanged() {
        this.imR.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.imR.onChangeSkinType();
    }

    public void cch() {
        this.imR.cch();
    }

    public void cci() {
        this.imR.cci();
    }
}
