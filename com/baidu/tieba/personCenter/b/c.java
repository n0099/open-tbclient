package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private BdTypeListView fSo;
    private a lCZ;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fSo = bdTypeListView;
        this.lCZ = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<q> list) {
        this.fSo.setData(list);
    }

    public void notifyDataSetChanged() {
        this.lCZ.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.lCZ.onChangeSkinType();
    }

    public void dnP() {
        this.lCZ.dnP();
    }

    public void dnQ() {
        this.lCZ.dnQ();
    }
}
