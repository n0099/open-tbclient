package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView eka;
    private a jhd;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eka = bdTypeListView;
        this.jhd = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<m> list) {
        this.eka.setData(list);
    }

    public void notifyDataSetChanged() {
        this.jhd.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.jhd.onChangeSkinType();
    }

    public void cvb() {
        this.jhd.cvb();
    }

    public void cvc() {
        this.jhd.cvc();
    }
}
