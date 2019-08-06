package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.f;
/* loaded from: classes4.dex */
public class c {
    a ikR;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.ikR = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(f fVar) {
        this.mListView.setData(fVar.fOL);
    }

    public void notifyDataSetChanged() {
        this.ikR.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.ikR.onChangeSkinType();
    }

    public void cbt() {
        this.ikR.cbt();
    }

    public void cbu() {
        this.ikR.cbu();
    }
}
