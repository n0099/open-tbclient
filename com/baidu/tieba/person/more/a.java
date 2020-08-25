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
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private BdTypeListView fCP;
    private d leg;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, aa<h> aaVar) {
        this.fCP = bdTypeListView;
        this.leg = new d(tbPageContext, h.lfo);
        this.leg.c(aaVar);
        this.bbu.add(this.leg);
        this.fCP.addAdapters(this.bbu);
    }

    public void notifyDataSetChanged() {
        this.leg.notifyDataSetChanged();
    }
}
