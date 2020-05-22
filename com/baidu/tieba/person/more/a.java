package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.personCenter.c.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private BdTypeListView faQ;
    private com.baidu.tieba.personCenter.a.c kkv;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, aa<g> aaVar) {
        this.faQ = bdTypeListView;
        this.kkv = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.kly);
        this.kkv.c(aaVar);
        this.aSj.add(this.kkv);
        this.faQ.addAdapters(this.aSj);
    }

    public void notifyDataSetChanged() {
        this.kkv.notifyDataSetChanged();
    }
}
