package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView eOj;
    private a jTf;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eOj = bdTypeListView;
        this.jTf = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<m> list) {
        this.eOj.setData(list);
    }

    public void notifyDataSetChanged() {
        this.jTf.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.jTf.onChangeSkinType();
    }

    public void cGe() {
        this.jTf.cGe();
    }

    public void cGf() {
        this.jTf.cGf();
    }
}
