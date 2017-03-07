package com.baidu.tieba.personCenter.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.a.i;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private b eBw;
    private c eCx;
    private i eCy;
    private com.baidu.tieba.person.a.b eCz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eCx = new c(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.c.eCW);
        this.eCy = new i(tbPageContext, com.baidu.tieba.person.data.c.eBP);
        this.eBw = new b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eCU);
        this.eCz = new com.baidu.tieba.person.a.b(tbPageContext, com.baidu.tieba.person.data.b.eBI);
        this.mAdapters.add(this.eCx);
        this.mAdapters.add(this.eCy);
        this.mAdapters.add(this.eBw);
        this.mAdapters.add(this.eCz);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eCx.setOnViewResponseListener(mVar);
    }
}
