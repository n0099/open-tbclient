package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private BdTypeListView gAY;
    private d moy;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, aa<h> aaVar) {
        this.gAY = bdTypeListView;
        this.moy = new d(tbPageContext, h.mpF);
        this.moy.c(aaVar);
        this.boM.add(this.moy);
        this.gAY.addAdapters(this.boM);
    }

    public void notifyDataSetChanged() {
        this.moy.notifyDataSetChanged();
    }
}
