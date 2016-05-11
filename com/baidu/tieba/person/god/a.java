package com.baidu.tieba.person.god;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.l;
import com.baidu.tieba.card.a.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private BdUniqueId aOT;
    private List<com.baidu.adp.widget.ListView.a> bei = new ArrayList();
    private BdTypeListView bej;
    public com.baidu.tieba.person.god.a.d dxv;
    public com.baidu.tieba.person.god.a.b dxx;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        a(tbPageContext, bdTypeListView);
    }

    private void a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.aOT = tbPageContext.getUniqueId();
        this.dxv = new com.baidu.tieba.person.god.a.d(tbPageContext, n.aSe);
        this.dxx = new com.baidu.tieba.person.god.a.b(tbPageContext, l.Oq);
        this.bei.add(this.dxv);
        this.bei.add(this.dxx);
        this.bej = bdTypeListView;
        this.bej.g(this.bei);
        setPageUniqueId(this.aOT);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOT = bdUniqueId;
        if (this.dxv != null) {
            this.dxv.setPageUniqueId(bdUniqueId);
        }
        if (this.dxv != null) {
            this.dxx.setPageUniqueId(bdUniqueId);
        }
    }

    public void bO(List<v> list) {
        if (list != null && this.bej != null) {
            this.bej.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bej.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bej.getAdapter()).notifyDataSetChanged();
        }
    }
}
