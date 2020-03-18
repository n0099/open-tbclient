package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView ekE;
    private a jiR;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ekE = bdTypeListView;
        this.jiR = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<m> list) {
        this.ekE.setData(list);
    }

    public void notifyDataSetChanged() {
        this.jiR.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.jiR.onChangeSkinType();
    }

    public void cvx() {
        this.jiR.cvx();
    }

    public void cvy() {
        this.jiR.cvy();
    }
}
