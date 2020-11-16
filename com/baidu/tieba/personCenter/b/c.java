package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes21.dex */
public class c {
    private BdTypeListView ghN;
    private a lVK;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ghN = bdTypeListView;
        this.lVK = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<q> list) {
        this.ghN.setData(list);
    }

    public void notifyDataSetChanged() {
        this.lVK.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.lVK.onChangeSkinType();
    }

    public void dsY() {
        this.lVK.dsY();
    }

    public void dsZ() {
        this.lVK.dsZ();
    }
}
