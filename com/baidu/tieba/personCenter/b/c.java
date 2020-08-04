package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    private BdTypeListView frv;
    private a kOT;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.frv = bdTypeListView;
        this.kOT = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<q> list) {
        this.frv.setData(list);
    }

    public void notifyDataSetChanged() {
        this.kOT.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.kOT.onChangeSkinType();
    }

    public void cVC() {
        this.kOT.cVC();
    }

    public void cVD() {
        this.kOT.cVD();
    }
}
