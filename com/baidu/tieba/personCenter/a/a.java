package com.baidu.tieba.personCenter.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.a.l;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bOr = new ArrayList();
    private b eBK;
    private c eDf;
    private l eDg;
    private com.baidu.tieba.person.a.b eDh;

    public a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eDf = new c(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.c.eDA);
        this.eDg = new l(tbPageContext, com.baidu.tieba.person.data.c.eCf);
        this.eBK = new b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eDy);
        this.eDh = new com.baidu.tieba.person.a.b(tbPageContext, com.baidu.tieba.person.data.b.eBY);
        this.bOr.add(this.eDf);
        this.bOr.add(this.eDg);
        this.bOr.add(this.eBK);
        this.bOr.add(this.eDh);
        bdPersonListView.g(this.bOr);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eDf.setOnViewResponseListener(mVar);
    }
}
