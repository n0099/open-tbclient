package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private BdTypeListView gpX;
    private a mjR;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gpX = bdTypeListView;
        this.mjR = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<q> list) {
        this.gpX.setData(list);
    }

    public void notifyDataSetChanged() {
        this.mjR.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.mjR.onChangeSkinType();
    }

    public void dyq() {
        this.mjR.dyq();
    }

    public void dyr() {
        this.mjR.dyr();
    }
}
