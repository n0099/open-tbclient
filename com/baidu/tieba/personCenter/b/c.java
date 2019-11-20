package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.f;
/* loaded from: classes4.dex */
public class c {
    private BdTypeListView duK;
    a ikJ;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.duK = bdTypeListView;
        this.ikJ = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(f fVar) {
        this.duK.setData(fVar.fPd);
    }

    public void notifyDataSetChanged() {
        this.ikJ.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.ikJ.onChangeSkinType();
    }

    public void bZh() {
        this.ikJ.bZh();
    }

    public void bZi() {
        this.ikJ.bZi();
    }
}
