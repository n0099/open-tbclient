package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private BdTypeListView gAY;
    private a mpb;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gAY = bdTypeListView;
        this.mpb = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<n> list) {
        this.gAY.setData(list);
    }

    public void notifyDataSetChanged() {
        this.mpb.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.mpb.onChangeSkinType();
    }

    public void dyh() {
        this.mpb.dyh();
    }

    public void dyi() {
        this.mpb.dyi();
    }
}
