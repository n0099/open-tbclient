package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.personCenter.c.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private BdTypeListView eko;
    private com.baidu.tieba.personCenter.a.c jgS;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, z<g> zVar) {
        this.eko = bdTypeListView;
        this.jgS = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jhR);
        this.jgS.c(zVar);
        this.asF.add(this.jgS);
        this.eko.addAdapters(this.asF);
    }

    public void notifyDataSetChanged() {
        this.jgS.notifyDataSetChanged();
    }
}
