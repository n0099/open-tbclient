package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.personCenter.c.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private BdTypeListView eOj;
    private com.baidu.tieba.personCenter.a.c jSD;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, z<g> zVar) {
        this.eOj = bdTypeListView;
        this.jSD = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jTH);
        this.jSD.c(zVar);
        this.aMj.add(this.jSD);
        this.eOj.addAdapters(this.aMj);
    }

    public void notifyDataSetChanged() {
        this.jSD.notifyDataSetChanged();
    }
}
