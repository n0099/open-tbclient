package com.baidu.tieba.personCenter.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.a.l;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bRh = new ArrayList();
    private b eKm;
    private c eLH;
    private l eLI;
    private com.baidu.tieba.person.a.b eLJ;

    public a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.eLH = new c(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.c.eMc);
        this.eLI = new l(tbPageContext, com.baidu.tieba.person.data.c.eKH);
        this.eKm = new b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eMa);
        this.eLJ = new com.baidu.tieba.person.a.b(tbPageContext, com.baidu.tieba.person.data.b.eKA);
        this.bRh.add(this.eLH);
        this.bRh.add(this.eLI);
        this.bRh.add(this.eKm);
        this.bRh.add(this.eLJ);
        bdPersonListView.g(this.bRh);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eLH.setOnViewResponseListener(mVar);
    }
}
