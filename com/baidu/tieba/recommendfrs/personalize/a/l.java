package com.baidu.tieba.recommendfrs.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.q;
import com.baidu.tieba.card.a.r;
import com.baidu.tieba.card.a.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l {
    private TbPageContext<?> Nw;
    private BdTypeListView dDe;
    private d dGA;
    private com.baidu.tieba.recommendfrs.a.a.b dGB;
    private com.baidu.tieba.recommendfrs.a.a.d dGC;
    private List<com.baidu.adp.widget.ListView.a> dGs = new ArrayList();
    private c dGt;
    private b dGu;
    private j dGv;
    private k dGw;
    private a dGx;
    private f dGy;
    private h dGz;

    public l(Context context, BdTypeListView bdTypeListView) {
        this.dDe = bdTypeListView;
        this.Nw = (TbPageContext) com.baidu.adp.base.l.C(context);
        aO(context);
        bdTypeListView.g(this.dGs);
    }

    private void aO(Context context) {
        this.dGt = new c(this.Nw);
        this.dGu = new b(this.Nw);
        this.dGv = new j(this.Nw);
        this.dGw = new k(this.Nw);
        this.dGx = new a(this.Nw);
        this.dGy = new f(this.Nw, q.aRS);
        this.dGz = new h(this.Nw, s.aSz);
        this.dGA = new d(this.Nw, r.aRS);
        this.dGB = new com.baidu.tieba.recommendfrs.a.a.b(this.Nw, com.baidu.tieba.card.a.i.aRS);
        this.dGC = new com.baidu.tieba.recommendfrs.a.a.d(this.Nw, com.baidu.tieba.card.a.j.aRS);
        this.dGs.add(this.dGt);
        this.dGs.add(this.dGu);
        this.dGs.add(this.dGv);
        this.dGs.add(this.dGw);
        this.dGs.add(this.dGx);
        this.dGs.add(this.dGz);
        this.dGs.add(this.dGy);
        this.dGs.add(this.dGA);
        this.dGs.add(new com.baidu.tieba.recommendfrs.a.a.a(this.Nw.getPageActivity(), com.baidu.tieba.recommendfrs.data.g.dEL));
        this.dGs.add(this.dGB);
        this.dGs.add(this.dGC);
    }

    public void b(com.baidu.tieba.recommendfrs.control.a.f fVar) {
        this.dGy.a(fVar);
        this.dGz.a(fVar);
    }

    public void bV(List<u> list) {
        this.dDe.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dGt.onChangeSkinType(i);
        this.dGu.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.dDe != null && (this.dDe.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.dDe.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dGy != null) {
            this.dGy.setFromCDN(z);
        }
        if (this.dGx != null) {
            this.dGx.setFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dGB != null) {
            this.dGB.setPageUniqueId(bdUniqueId);
        }
        if (this.dGC != null) {
            this.dGC.setPageUniqueId(bdUniqueId);
        }
        if (this.dGy != null) {
            this.dGy.setPageUniqueId(bdUniqueId);
        }
        if (this.dGz != null) {
            this.dGz.setPageUniqueId(bdUniqueId);
        }
        if (this.dGA != null) {
            this.dGA.setPageUniqueId(bdUniqueId);
        }
        if (this.dGt != null) {
            this.dGt.setPageUniqueId(bdUniqueId);
        }
        if (this.dGu != null) {
            this.dGu.setPageUniqueId(bdUniqueId);
        }
    }
}
