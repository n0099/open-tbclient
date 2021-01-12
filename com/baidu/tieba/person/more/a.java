package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private BdTypeListView gwr;
    private d mjT;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, aa<h> aaVar) {
        this.gwr = bdTypeListView;
        this.mjT = new d(tbPageContext, h.mla);
        this.mjT.c(aaVar);
        this.bjZ.add(this.mjT);
        this.gwr.addAdapters(this.bjZ);
    }

    public void notifyDataSetChanged() {
        this.mjT.notifyDataSetChanged();
    }
}
