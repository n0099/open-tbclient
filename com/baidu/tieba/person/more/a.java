package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.personCenter.c.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private BdTypeListView eOe;
    private com.baidu.tieba.personCenter.a.c jSz;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, z<g> zVar) {
        this.eOe = bdTypeListView;
        this.jSz = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jTD);
        this.jSz.c(zVar);
        this.aMd.add(this.jSz);
        this.eOe.addAdapters(this.aMd);
    }

    public void notifyDataSetChanged() {
        this.jSz.notifyDataSetChanged();
    }
}
