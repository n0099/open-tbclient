package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private BdTypeListView gzb;
    private a mty;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gzb = bdTypeListView;
        this.mty = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<n> list) {
        this.gzb.setData(list);
    }

    public void notifyDataSetChanged() {
        this.mty.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.mty.onChangeSkinType();
    }

    public void dwy() {
        this.mty.dwy();
    }

    public void dwz() {
        this.mty.dwz();
    }
}
