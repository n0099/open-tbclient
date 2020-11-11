package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private BdTypeListView gih;
    private a lVs;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gih = bdTypeListView;
        this.lVs = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<q> list) {
        this.gih.setData(list);
    }

    public void notifyDataSetChanged() {
        this.lVs.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.lVs.onChangeSkinType();
    }

    public void dty() {
        this.lVs.dty();
    }

    public void dtz() {
        this.lVs.dtz();
    }
}
