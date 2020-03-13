package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView eko;
    private a jhr;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eko = bdTypeListView;
        this.jhr = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<m> list) {
        this.eko.setData(list);
    }

    public void notifyDataSetChanged() {
        this.jhr.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.jhr.onChangeSkinType();
    }

    public void cve() {
        this.jhr.cve();
    }

    public void cvf() {
        this.jhr.cvf();
    }
}
