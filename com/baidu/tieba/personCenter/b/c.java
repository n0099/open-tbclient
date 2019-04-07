package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes4.dex */
public class c {
    a hLs;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.hLs = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(e eVar) {
        this.mListView.setData(eVar.fsA);
    }

    public void notifyDataSetChanged() {
        this.hLs.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.hLs.onChangeSkinType();
    }

    public void bQp() {
        this.hLs.bQp();
    }

    public void bQq() {
        this.hLs.bQq();
    }
}
