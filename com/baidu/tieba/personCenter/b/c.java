package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private BdTypeListView gpZ;
    private a mjT;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gpZ = bdTypeListView;
        this.mjT = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<q> list) {
        this.gpZ.setData(list);
    }

    public void notifyDataSetChanged() {
        this.mjT.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.mjT.onChangeSkinType();
    }

    public void dyr() {
        this.mjT.dyr();
    }

    public void dys() {
        this.mjT.dys();
    }
}
