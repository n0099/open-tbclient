package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes4.dex */
public class c {
    a hLt;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.hLt = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(e eVar) {
        this.mListView.setData(eVar.fsA);
    }

    public void notifyDataSetChanged() {
        this.hLt.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.hLt.onChangeSkinType();
    }

    public void bQp() {
        this.hLt.bQp();
    }

    public void bQq() {
        this.hLt.bQq();
    }
}
