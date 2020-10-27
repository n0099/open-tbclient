package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private BdTypeListView gcr;
    private a lPw;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gcr = bdTypeListView;
        this.lPw = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<q> list) {
        this.gcr.setData(list);
    }

    public void notifyDataSetChanged() {
        this.lPw.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.lPw.onChangeSkinType();
    }

    public void dqW() {
        this.lPw.dqW();
    }

    public void dqX() {
        this.lPw.dqX();
    }
}
