package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes5.dex */
public class c {
    a gkJ;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.gkJ = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(e eVar) {
        this.mListView.setData(eVar.dUy);
    }

    public void notifyDataSetChanged() {
        this.gkJ.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.gkJ.onChangeSkinType();
    }

    public void bmI() {
        this.gkJ.bmI();
    }

    public void bmJ() {
        this.gkJ.bmJ();
    }
}
