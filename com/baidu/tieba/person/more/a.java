package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private BdTypeListView gpZ;
    private d mjq;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, ab<h> abVar) {
        this.gpZ = bdTypeListView;
        this.mjq = new d(tbPageContext, h.mkx);
        this.mjq.c(abVar);
        this.bnf.add(this.mjq);
        this.gpZ.addAdapters(this.bnf);
    }

    public void notifyDataSetChanged() {
        this.mjq.notifyDataSetChanged();
    }
}
