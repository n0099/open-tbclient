package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.personCenter.data.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private BdTypeListView efW;
    private com.baidu.tieba.personCenter.a.c jfI;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, z<g> zVar) {
        this.efW = bdTypeListView;
        this.jfI = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.jgK);
        this.jfI.c(zVar);
        this.apl.add(this.jfI);
        this.efW.addAdapters(this.apl);
    }

    public void notifyDataSetChanged() {
        this.jfI.notifyDataSetChanged();
    }
}
