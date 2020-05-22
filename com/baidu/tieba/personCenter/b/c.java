package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView faQ;
    private a kkX;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.faQ = bdTypeListView;
        this.kkX = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void setData(List<o> list) {
        this.faQ.setData(list);
    }

    public void notifyDataSetChanged() {
        this.kkX.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.kkX.onChangeSkinType();
    }

    public void cNe() {
        this.kkX.cNe();
    }

    public void cNf() {
        this.kkX.cNf();
    }
}
