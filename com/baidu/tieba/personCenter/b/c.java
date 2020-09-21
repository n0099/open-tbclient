package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes21.dex */
public class c {
    private BdTypeListView fGf;
    private a lnI;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fGf = bdTypeListView;
        this.lnI = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<q> list) {
        this.fGf.setData(list);
    }

    public void notifyDataSetChanged() {
        this.lnI.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.lnI.onChangeSkinType();
    }

    public void dkf() {
        this.lnI.dkf();
    }

    public void dkg() {
        this.lnI.dkg();
    }
}
