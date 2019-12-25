package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private BdTypeListView efM;
    private a jcC;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.efM = bdTypeListView;
        this.jcC = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<m> list) {
        this.efM.setData(list);
    }

    public void notifyDataSetChanged() {
        this.jcC.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.jcC.onChangeSkinType();
    }

    public void csz() {
        this.jcC.csz();
    }

    public void csA() {
        this.jcC.csA();
    }
}
