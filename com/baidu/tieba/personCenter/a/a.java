package com.baidu.tieba.personCenter.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.a.i;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbV = new ArrayList();
    private b eoc;
    private c epd;
    private i epe;
    private com.baidu.tieba.person.a.b epf;

    public a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.epd = new c(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.c.epA);
        this.epe = new i(tbPageContext, com.baidu.tieba.person.data.c.eow);
        this.eoc = new b(tbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.epy);
        this.epf = new com.baidu.tieba.person.a.b(tbPageContext, com.baidu.tieba.person.data.b.eop);
        this.bbV.add(this.epd);
        this.bbV.add(this.epe);
        this.bbV.add(this.eoc);
        this.bbV.add(this.epf);
        bdPersonListView.g(this.bbV);
    }

    public void setOnViewResponseListener(m mVar) {
        this.epd.setOnViewResponseListener(mVar);
    }
}
