package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes4.dex */
public class c {
    a hLG;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.hLG = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(e eVar) {
        this.mListView.setData(eVar.fsO);
    }

    public void notifyDataSetChanged() {
        this.hLG.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.hLG.onChangeSkinType();
    }

    public void bQt() {
        this.hLG.bQt();
    }

    public void bQu() {
        this.hLG.bQu();
    }
}
