package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.f;
/* loaded from: classes4.dex */
public class c {
    private BdTypeListView dvB;
    a ilA;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.dvB = bdTypeListView;
        this.ilA = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(f fVar) {
        this.dvB.setData(fVar.fPU);
    }

    public void notifyDataSetChanged() {
        this.ilA.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.ilA.onChangeSkinType();
    }

    public void bZj() {
        this.ilA.bZj();
    }

    public void bZk() {
        this.ilA.bZk();
    }
}
