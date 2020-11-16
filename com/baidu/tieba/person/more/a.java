package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private BdTypeListView ghN;
    private d lVh;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, ab<h> abVar) {
        this.ghN = bdTypeListView;
        this.lVh = new d(tbPageContext, h.lWo);
        this.lVh.c(abVar);
        this.biN.add(this.lVh);
        this.ghN.addAdapters(this.biN);
    }

    public void notifyDataSetChanged() {
        this.lVh.notifyDataSetChanged();
    }
}
