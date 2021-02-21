package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private BdTypeListView gzp;
    private d mtk;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, ab<h> abVar) {
        this.gzp = bdTypeListView;
        this.mtk = new d(tbPageContext, h.mur);
        this.mtk.c(abVar);
        this.bns.add(this.mtk);
        this.gzp.addAdapters(this.bns);
    }

    public void notifyDataSetChanged() {
        this.mtk.notifyDataSetChanged();
    }
}
