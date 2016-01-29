package com.baidu.tieba.person.god;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.q;
import com.baidu.tieba.card.a.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private BdUniqueId aPF;
    private List<com.baidu.adp.widget.ListView.a> aXX = new ArrayList();
    private BdTypeListView aXu;
    public com.baidu.tieba.person.god.a.d cZZ;
    public com.baidu.tieba.person.god.a.b daa;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        a(tbPageContext, bdTypeListView);
    }

    private void a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.aPF = tbPageContext.getUniqueId();
        this.cZZ = new com.baidu.tieba.person.god.a.d(tbPageContext, s.aSz);
        this.daa = new com.baidu.tieba.person.god.a.b(tbPageContext, q.aRS);
        this.aXX.add(this.cZZ);
        this.aXX.add(this.daa);
        this.aXu = bdTypeListView;
        this.aXu.g(this.aXX);
        setPageUniqueId(this.aPF);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aPF = bdUniqueId;
        if (this.cZZ != null) {
            this.cZZ.setPageUniqueId(bdUniqueId);
        }
        if (this.cZZ != null) {
            this.daa.setPageUniqueId(bdUniqueId);
        }
    }

    public void bq(List<u> list) {
        if (list != null && this.aXu != null) {
            this.aXu.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aXu.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aXu.getAdapter()).notifyDataSetChanged();
        }
    }
}
