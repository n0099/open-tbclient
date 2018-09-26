package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes2.dex */
public class c {
    a gbH;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.gbH = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(e eVar) {
        this.mListView.setData(eVar.dLv);
    }

    public void notifyDataSetChanged() {
        this.gbH.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.gbH.onChangeSkinType();
    }

    public void bkc() {
        this.gbH.bkc();
    }

    public void bkd() {
        this.gbH.bkd();
    }
}
