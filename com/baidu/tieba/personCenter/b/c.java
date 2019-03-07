package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes4.dex */
public class c {
    a hLL;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.hLL = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(e eVar) {
        this.mListView.setData(eVar.fsP);
    }

    public void notifyDataSetChanged() {
        this.hLL.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.hLL.onChangeSkinType();
    }

    public void bQq() {
        this.hLL.bQq();
    }

    public void bQr() {
        this.hLL.bQr();
    }
}
