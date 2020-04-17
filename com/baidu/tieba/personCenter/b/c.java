package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView eOe;
    private a jTb;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eOe = bdTypeListView;
        this.jTb = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<m> list) {
        this.eOe.setData(list);
    }

    public void notifyDataSetChanged() {
        this.jTb.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.jTb.onChangeSkinType();
    }

    public void cGh() {
        this.jTb.cGh();
    }

    public void cGi() {
        this.jTb.cGi();
    }
}
