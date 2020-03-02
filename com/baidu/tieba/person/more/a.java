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
    private BdTypeListView ekb;
    private com.baidu.tieba.personCenter.a.c jgG;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, z<g> zVar) {
        this.ekb = bdTypeListView;
        this.jgG = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jhF);
        this.jgG.c(zVar);
        this.asE.add(this.jgG);
        this.ekb.addAdapters(this.asE);
    }

    public void notifyDataSetChanged() {
        this.jgG.notifyDataSetChanged();
    }
}
