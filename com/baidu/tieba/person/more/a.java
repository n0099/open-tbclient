package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.personCenter.c.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private BdTypeListView ekE;
    private com.baidu.tieba.personCenter.a.c jis;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, z<g> zVar) {
        this.ekE = bdTypeListView;
        this.jis = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jjr);
        this.jis.c(zVar);
        this.asP.add(this.jis);
        this.ekE.addAdapters(this.asP);
    }

    public void notifyDataSetChanged() {
        this.jis.notifyDataSetChanged();
    }
}
