package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private BdTypeListView gcr;
    private d lOT;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, ab<h> abVar) {
        this.gcr = bdTypeListView;
        this.lOT = new d(tbPageContext, h.lQa);
        this.lOT.c(abVar);
        this.bje.add(this.lOT);
        this.gcr.addAdapters(this.bje);
    }

    public void notifyDataSetChanged() {
        this.lOT.notifyDataSetChanged();
    }
}
