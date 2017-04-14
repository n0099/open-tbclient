package com.baidu.tieba.personCenter.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.a.i;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private c eAu;
    private i eAv;
    private com.baidu.tieba.person.a.b eAw;
    private b ezC;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eAu = new c(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.c.eAT);
        this.eAv = new i(tbPageContext, com.baidu.tieba.person.data.c.ezV);
        this.ezC = new b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eAR);
        this.eAw = new com.baidu.tieba.person.a.b(tbPageContext, com.baidu.tieba.person.data.b.ezO);
        this.mAdapters.add(this.eAu);
        this.mAdapters.add(this.eAv);
        this.mAdapters.add(this.ezC);
        this.mAdapters.add(this.eAw);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eAu.setOnViewResponseListener(mVar);
    }
}
