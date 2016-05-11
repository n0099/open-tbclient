package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private BdUniqueId aOT;
    private List<com.baidu.adp.widget.ListView.a> bei = new ArrayList();
    private BaseFragmentActivity cSp;
    private com.baidu.tieba.personInfo.f dxd;
    private BdPersonListView dxe;
    public w dxf;
    public ap dxg;
    public g dxh;
    public s dxi;
    public an dxj;
    public j dxk;
    public ab dxl;
    public u dxm;
    public af dxn;
    public aj dxo;
    public r dxp;
    public h dxq;
    public e dxr;
    public p dxs;
    public n dxt;
    public com.baidu.tieba.person.god.a.a dxu;
    public com.baidu.tieba.person.god.a.d dxv;
    public com.baidu.tieba.person.god.a.d dxw;
    public com.baidu.tieba.person.god.a.b dxx;
    public ad dxy;
    private ag dxz;

    public b(com.baidu.tieba.personInfo.f fVar, BdPersonListView bdPersonListView) {
        this.dxd = fVar;
        this.cSp = fVar.getBaseFragmentActivity();
        this.aOT = this.dxd.getUniqueId();
        a(this.cSp, bdPersonListView);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, BdPersonListView bdPersonListView) {
        this.dxf = new w(baseFragmentActivity, com.baidu.tieba.person.data.o.dzG);
        this.dxg = new ap(baseFragmentActivity, com.baidu.tieba.person.data.t.dzP);
        this.dxh = new g(this.dxd, com.baidu.tieba.person.data.d.dzl);
        this.dxi = new s(baseFragmentActivity, com.baidu.tieba.person.data.l.dzC);
        this.dxl = new ab(baseFragmentActivity, com.baidu.tieba.person.data.p.dzI);
        this.dxm = new u(baseFragmentActivity, com.baidu.tieba.person.data.m.dzE);
        this.dxn = new af(baseFragmentActivity, com.baidu.tieba.person.data.r.dzK);
        this.dxj = new an(baseFragmentActivity, com.baidu.tieba.person.data.n.dzF);
        this.dxp = new r(baseFragmentActivity, com.baidu.tieba.person.data.j.dzw);
        this.dxk = new j(baseFragmentActivity, com.baidu.tieba.person.data.g.dzr);
        this.dxo = new aj(baseFragmentActivity, al.dyB);
        this.dxr = new e(baseFragmentActivity, com.baidu.tieba.person.data.c.dzj);
        this.dxq = new h(baseFragmentActivity, com.baidu.tieba.person.data.f.dzp);
        this.dxs = new p(baseFragmentActivity.getPageContext().getPageActivity(), com.baidu.tieba.person.data.i.dzv);
        this.dxt = new n(baseFragmentActivity.getPageContext().getPageActivity(), com.baidu.tieba.person.data.h.dzu);
        this.dxv = new com.baidu.tieba.person.god.a.d(baseFragmentActivity.getPageContext(), com.baidu.tieba.card.a.n.aSe);
        this.dxw = new com.baidu.tieba.person.god.a.d(baseFragmentActivity.getPageContext(), com.baidu.tieba.card.a.n.aSf);
        this.dxx = new com.baidu.tieba.person.god.a.b(baseFragmentActivity.getPageContext(), com.baidu.tieba.card.a.l.Oq);
        this.dxu = new com.baidu.tieba.person.god.a.a(baseFragmentActivity.getPageContext(), com.baidu.tieba.person.data.k.Oq);
        this.dxy = new ad(baseFragmentActivity.getPageContext().getPageActivity(), com.baidu.tieba.person.data.q.dzJ);
        this.dxz = new ag(baseFragmentActivity, com.baidu.tieba.person.data.s.dzM);
        this.bei.add(this.dxf);
        this.bei.add(this.dxh);
        this.bei.add(this.dxg);
        this.bei.add(this.dxl);
        this.bei.add(this.dxm);
        this.bei.add(this.dxj);
        this.bei.add(this.dxp);
        this.bei.add(this.dxi);
        this.bei.add(this.dxk);
        this.bei.add(this.dxn);
        this.bei.add(this.dxy);
        this.bei.add(this.dxz);
        this.bei.add(this.dxo);
        this.bei.add(this.dxr);
        this.bei.add(this.dxq);
        this.bei.add(this.dxs);
        this.bei.add(this.dxt);
        this.bei.add(this.dxv);
        this.bei.add(this.dxx);
        this.bei.add(this.dxw);
        this.bei.add(this.dxu);
        this.dxe = bdPersonListView;
        this.dxe.g(this.bei);
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

    public void ac(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (arrayList != null) {
            if (arrayList != null && arrayList.size() == 0) {
                arrayList.add(this.dxd.aDb().aDO());
            } else {
                Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
                boolean z = true;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.v next = it.next();
                    if (next instanceof com.baidu.tieba.person.data.a) {
                        com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) next;
                        if (!aVar.dzg && !z) {
                            aVar.dzf = false;
                        } else {
                            aVar.dzf = true;
                        }
                        z = aVar.dzg;
                    } else {
                        z = true;
                    }
                }
            }
            if (com.baidu.tbadk.core.util.y.r(this.bei) > 0) {
                for (com.baidu.adp.widget.ListView.a aVar2 : this.bei) {
                    if (aVar2 instanceof c) {
                        ((c) aVar2).bUL = true;
                    }
                }
            }
            if (this.dxe != null) {
                this.dxe.setData(arrayList);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.dxe.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.dxe.getAdapter()).notifyDataSetChanged();
        }
    }

    public void d(com.baidu.adp.widget.ListView.w wVar) {
        this.dxk.d(wVar);
        if (this.dxu != null) {
            this.dxu.d(wVar);
        }
    }
}
