package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    private BdTypeListView fCT;
    private a leQ;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fCT = bdTypeListView;
        this.leQ = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<q> list) {
        this.fCT.setData(list);
    }

    public void notifyDataSetChanged() {
        this.leQ.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.leQ.onChangeSkinType();
    }

    public void dgA() {
        this.leQ.dgA();
    }

    public void dgB() {
        this.leQ.dgB();
    }
}
