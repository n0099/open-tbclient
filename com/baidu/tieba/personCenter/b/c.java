package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private BdTypeListView gwr;
    private a mkw;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gwr = bdTypeListView;
        this.mkw = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<n> list) {
        this.gwr.setData(list);
    }

    public void notifyDataSetChanged() {
        this.mkw.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.mkw.onChangeSkinType();
    }

    public void dup() {
        this.mkw.dup();
    }

    public void duq() {
        this.mkw.duq();
    }
}
