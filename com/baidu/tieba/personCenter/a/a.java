package com.baidu.tieba.personCenter.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.a.i;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private b eBS;
    private c eCK;
    private i eCL;
    private com.baidu.tieba.person.a.b eCM;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eCK = new c(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.c.eDj);
        this.eCL = new i(tbPageContext, com.baidu.tieba.person.data.c.eCl);
        this.eBS = new b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eDh);
        this.eCM = new com.baidu.tieba.person.a.b(tbPageContext, com.baidu.tieba.person.data.b.eCe);
        this.mAdapters.add(this.eCK);
        this.mAdapters.add(this.eCL);
        this.mAdapters.add(this.eBS);
        this.mAdapters.add(this.eCM);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eCK.setOnViewResponseListener(mVar);
    }
}
