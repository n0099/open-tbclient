package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView fbb;
    private a kmd;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.fbb = bdTypeListView;
        this.kmd = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<o> list) {
        this.fbb.setData(list);
    }

    public void notifyDataSetChanged() {
        this.kmd.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.kmd.onChangeSkinType();
    }

    public void cNu() {
        this.kmd.cNu();
    }

    public void cNv() {
        this.kmd.cNv();
    }
}
