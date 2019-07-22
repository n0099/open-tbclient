package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.f;
/* loaded from: classes4.dex */
public class c {
    a ijP;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.ijP = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(f fVar) {
        this.mListView.setData(fVar.fNX);
    }

    public void notifyDataSetChanged() {
        this.ijP.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.ijP.onChangeSkinType();
    }

    public void cbb() {
        this.ijP.cbb();
    }

    public void cbc() {
        this.ijP.cbc();
    }
}
