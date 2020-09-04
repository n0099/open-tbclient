package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private BdTypeListView fCT;
    private d leo;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, aa<h> aaVar) {
        this.fCT = bdTypeListView;
        this.leo = new d(tbPageContext, h.lfv);
        this.leo.c(aaVar);
        this.bbw.add(this.leo);
        this.fCT.addAdapters(this.bbw);
    }

    public void notifyDataSetChanged() {
        this.leo.notifyDataSetChanged();
    }
}
