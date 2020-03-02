package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView ekb;
    private a jhf;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ekb = bdTypeListView;
        this.jhf = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<m> list) {
        this.ekb.setData(list);
    }

    public void notifyDataSetChanged() {
        this.jhf.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.jhf.onChangeSkinType();
    }

    public void cvd() {
        this.jhf.cvd();
    }

    public void cve() {
        this.jhf.cve();
    }
}
