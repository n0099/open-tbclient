package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.personCenter.data.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private BdTypeListView efM;
    private com.baidu.tieba.personCenter.a.c jca;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, z<g> zVar) {
        this.efM = bdTypeListView;
        this.jca = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jdc);
        this.jca.c(zVar);
        this.aoz.add(this.jca);
        this.efM.addAdapters(this.aoz);
    }

    public void notifyDataSetChanged() {
        this.jca.notifyDataSetChanged();
    }
}
