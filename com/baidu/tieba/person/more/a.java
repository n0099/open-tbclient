package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private BdTypeListView fGf;
    private d lne;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, aa<h> aaVar) {
        this.fGf = bdTypeListView;
        this.lne = new d(tbPageContext, h.loq);
        this.lne.c(aaVar);
        this.bdV.add(this.lne);
        this.fGf.addAdapters(this.bdV);
    }

    public void notifyDataSetChanged() {
        this.lne.notifyDataSetChanged();
    }
}
