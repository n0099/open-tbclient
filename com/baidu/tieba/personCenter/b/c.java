package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    private BdTypeListView efW;
    private a jgk;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.efW = bdTypeListView;
        this.jgk = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<m> list) {
        this.efW.setData(list);
    }

    public void notifyDataSetChanged() {
        this.jgk.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.jgk.onChangeSkinType();
    }

    public void ctI() {
        this.jgk.ctI();
    }

    public void ctJ() {
        this.jgk.ctJ();
    }
}
