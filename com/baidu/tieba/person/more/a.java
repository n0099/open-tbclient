package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.data.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private BdTypeListView duK;
    private com.baidu.tieba.personCenter.a.c iki;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, ab<g> abVar) {
        this.duK = bdTypeListView;
        this.iki = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.ilh);
        this.iki.d(abVar);
        this.agy.add(this.iki);
        this.duK.addAdapters(this.agy);
    }

    public void notifyDataSetChanged() {
        this.iki.notifyDataSetChanged();
    }
}
