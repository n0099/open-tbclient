package com.baidu.tieba.person.god;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.t;
import com.baidu.tieba.card.a.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private BdUniqueId aSu;
    private List<com.baidu.adp.widget.ListView.a> bcG = new ArrayList();
    private BdTypeListView bcd;
    public com.baidu.tieba.person.god.a.d duC;
    public com.baidu.tieba.person.god.a.b duE;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        a(tbPageContext, bdTypeListView);
    }

    private void a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.aSu = tbPageContext.getUniqueId();
        this.duC = new com.baidu.tieba.person.god.a.d(tbPageContext, v.aWk);
        this.duE = new com.baidu.tieba.person.god.a.b(tbPageContext, t.TC);
        this.bcG.add(this.duC);
        this.bcG.add(this.duE);
        this.bcd = bdTypeListView;
        this.bcd.g(this.bcG);
        setPageUniqueId(this.aSu);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSu = bdUniqueId;
        if (this.duC != null) {
            this.duC.setPageUniqueId(bdUniqueId);
        }
        if (this.duC != null) {
            this.duE.setPageUniqueId(bdUniqueId);
        }
    }

    public void bM(List<u> list) {
        if (list != null && this.bcd != null) {
            this.bcd.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bcd.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bcd.getAdapter()).notifyDataSetChanged();
        }
    }
}
