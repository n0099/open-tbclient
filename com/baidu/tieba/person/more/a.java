package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private BdTypeListView frv;
    private d kOr;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, aa<h> aaVar) {
        this.frv = bdTypeListView;
        this.kOr = new d(tbPageContext, h.kPy);
        this.kOr.c(aaVar);
        this.aWf.add(this.kOr);
        this.frv.addAdapters(this.aWf);
    }

    public void notifyDataSetChanged() {
        this.kOr.notifyDataSetChanged();
    }
}
