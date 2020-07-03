package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView fml;
    private a kFQ;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fml = bdTypeListView;
        this.kFQ = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<q> list) {
        this.fml.setData(list);
    }

    public void notifyDataSetChanged() {
        this.kFQ.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.kFQ.onChangeSkinType();
    }

    public void cRL() {
        this.kFQ.cRL();
    }

    public void cRM() {
        this.kFQ.cRM();
    }
}
