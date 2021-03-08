package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private BdTypeListView gAY;
    private a mvP;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gAY = bdTypeListView;
        this.mvP = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<n> list) {
        this.gAY.setData(list);
    }

    public void notifyDataSetChanged() {
        this.mvP.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.mvP.onChangeSkinType();
    }

    public void dwO() {
        this.mvP.dwO();
    }

    public void dwP() {
        this.mvP.dwP();
    }
}
