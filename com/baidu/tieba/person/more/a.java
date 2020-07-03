package com.baidu.tieba.person.more;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private BdTypeListView fml;
    private d kFn;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, aa<h> aaVar) {
        this.fml = bdTypeListView;
        this.kFn = new d(tbPageContext, h.kGv);
        this.kFn.c(aaVar);
        this.aUP.add(this.kFn);
        this.fml.addAdapters(this.aUP);
    }

    public void notifyDataSetChanged() {
        this.kFn.notifyDataSetChanged();
    }
}
