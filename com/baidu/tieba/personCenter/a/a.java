package com.baidu.tieba.personCenter.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.a.l;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bOo = new ArrayList();
    private b eDN;
    private c eFi;
    private l eFj;
    private com.baidu.tieba.person.a.b eFk;

    public a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eFi = new c(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.c.eFD);
        this.eFj = new l(tbPageContext, com.baidu.tieba.person.data.c.eEi);
        this.eDN = new b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eFB);
        this.eFk = new com.baidu.tieba.person.a.b(tbPageContext, com.baidu.tieba.person.data.b.eEb);
        this.bOo.add(this.eFi);
        this.bOo.add(this.eFj);
        this.bOo.add(this.eDN);
        this.bOo.add(this.eFk);
        bdPersonListView.g(this.bOo);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eFi.setOnViewResponseListener(mVar);
    }
}
