package com.baidu.tieba.personCenter.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.a.i;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private b exW;
    private c eyY;
    private i eyZ;
    private com.baidu.tieba.person.a.b eza;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eyY = new c(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.c.ezx);
        this.eyZ = new i(tbPageContext, com.baidu.tieba.person.data.c.eyq);
        this.exW = new b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.ezv);
        this.eza = new com.baidu.tieba.person.a.b(tbPageContext, com.baidu.tieba.person.data.b.eyi);
        this.mAdapters.add(this.eyY);
        this.mAdapters.add(this.eyZ);
        this.mAdapters.add(this.exW);
        this.mAdapters.add(this.eza);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eyY.setOnViewResponseListener(mVar);
    }
}
