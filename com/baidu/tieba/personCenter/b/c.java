package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    private BdTypeListView fCP;
    private a leJ;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fCP = bdTypeListView;
        this.leJ = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<q> list) {
        this.fCP.setData(list);
    }

    public void notifyDataSetChanged() {
        this.leJ.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.leJ.onChangeSkinType();
    }

    public void dgz() {
        this.leJ.dgz();
    }

    public void dgA() {
        this.leJ.dgA();
    }
}
