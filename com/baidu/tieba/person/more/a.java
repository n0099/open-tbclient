package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.data.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private BdTypeListView dvB;
    private com.baidu.tieba.personCenter.a.c ikZ;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, ab<g> abVar) {
        this.dvB = bdTypeListView;
        this.ikZ = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.ilY);
        this.ikZ.d(abVar);
        this.agQ.add(this.ikZ);
        this.dvB.addAdapters(this.agQ);
    }

    public void notifyDataSetChanged() {
        this.ikZ.notifyDataSetChanged();
    }
}
