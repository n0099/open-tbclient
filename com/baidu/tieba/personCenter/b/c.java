package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private BdTypeListView gAY;
    private a mpc;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gAY = bdTypeListView;
        this.mpc = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<n> list) {
        this.gAY.setData(list);
    }

    public void notifyDataSetChanged() {
        this.mpc.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.mpc.onChangeSkinType();
    }

    public void dyg() {
        this.mpc.dyg();
    }

    public void dyh() {
        this.mpc.dyh();
    }
}
