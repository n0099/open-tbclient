package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    private BdTypeListView efW;
    private a jgf;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.efW = bdTypeListView;
        this.jgf = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<m> list) {
        this.efW.setData(list);
    }

    public void notifyDataSetChanged() {
        this.jgf.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.jgf.onChangeSkinType();
    }

    public void ctG() {
        this.jgf.ctG();
    }

    public void ctH() {
        this.jgf.ctH();
    }
}
