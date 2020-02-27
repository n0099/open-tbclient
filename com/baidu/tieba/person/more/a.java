package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.personCenter.c.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private BdTypeListView eka;
    private com.baidu.tieba.personCenter.a.c jgE;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, z<g> zVar) {
        this.eka = bdTypeListView;
        this.jgE = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jhD);
        this.jgE.c(zVar);
        this.asE.add(this.jgE);
        this.eka.addAdapters(this.asE);
    }

    public void notifyDataSetChanged() {
        this.jgE.notifyDataSetChanged();
    }
}
