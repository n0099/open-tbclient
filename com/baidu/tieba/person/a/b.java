package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private BdUniqueId aSu;
    private List<com.baidu.adp.widget.ListView.a> bcG = new ArrayList();
    public m duA;
    public com.baidu.tieba.person.god.a.a duB;
    public com.baidu.tieba.person.god.a.d duC;
    public com.baidu.tieba.person.god.a.d duD;
    public com.baidu.tieba.person.god.a.b duE;
    private BaseFragmentActivity duj;
    private com.baidu.tieba.personInfo.f duk;
    private BdPersonListView dul;
    public v dum;
    public ai dun;
    public f duo;
    public r dup;
    public ag duq;
    public i dur;
    public aa dus;
    public t dut;
    public ac duu;
    public ad duv;
    public q duw;
    public g dux;
    public d duy;
    public o duz;

    public b(com.baidu.tieba.personInfo.f fVar, BdPersonListView bdPersonListView) {
        this.duk = fVar;
        this.duj = fVar.getBaseFragmentActivity();
        this.aSu = this.duk.getUniqueId();
        a(this.duj, bdPersonListView);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, BdPersonListView bdPersonListView) {
        this.dum = new v(baseFragmentActivity, com.baidu.tieba.person.data.n.dwC);
        this.dun = new ai(baseFragmentActivity, com.baidu.tieba.person.data.q.dwH);
        this.duo = new f(this.duk, com.baidu.tieba.person.data.c.dwh);
        this.dup = new r(baseFragmentActivity, com.baidu.tieba.person.data.k.dwy);
        this.dus = new aa(baseFragmentActivity, com.baidu.tieba.person.data.o.dwE);
        this.dut = new t(baseFragmentActivity, com.baidu.tieba.person.data.l.dwA);
        this.duu = new ac(baseFragmentActivity, com.baidu.tieba.person.data.p.dwF);
        this.duq = new ag(baseFragmentActivity, com.baidu.tieba.person.data.m.dwB);
        this.duw = new q(baseFragmentActivity, com.baidu.tieba.person.data.i.dws);
        this.dur = new i(baseFragmentActivity, com.baidu.tieba.person.data.f.dwn);
        this.duv = new ad(baseFragmentActivity, ae.dvz);
        this.duy = new d(baseFragmentActivity, com.baidu.tieba.person.data.b.dwf);
        this.dux = new g(baseFragmentActivity, com.baidu.tieba.person.data.e.dwl);
        this.duz = new o(baseFragmentActivity.getPageContext().getPageActivity(), com.baidu.tieba.person.data.h.dwr);
        this.duA = new m(baseFragmentActivity.getPageContext().getPageActivity(), com.baidu.tieba.person.data.g.dwq);
        this.duC = new com.baidu.tieba.person.god.a.d(baseFragmentActivity.getPageContext(), com.baidu.tieba.card.a.v.aWk);
        this.duD = new com.baidu.tieba.person.god.a.d(baseFragmentActivity.getPageContext(), com.baidu.tieba.card.a.v.aWl);
        this.duE = new com.baidu.tieba.person.god.a.b(baseFragmentActivity.getPageContext(), com.baidu.tieba.card.a.t.TC);
        this.duB = new com.baidu.tieba.person.god.a.a(baseFragmentActivity.getPageContext(), com.baidu.tieba.person.data.j.TC);
        this.bcG.add(this.dum);
        this.bcG.add(this.duo);
        this.bcG.add(this.dun);
        this.bcG.add(this.dus);
        this.bcG.add(this.dut);
        this.bcG.add(this.duq);
        this.bcG.add(this.duw);
        this.bcG.add(this.dup);
        this.bcG.add(this.dur);
        this.bcG.add(this.duu);
        this.bcG.add(this.duv);
        this.bcG.add(this.duy);
        this.bcG.add(this.dux);
        this.bcG.add(this.duz);
        this.bcG.add(this.duA);
        this.bcG.add(this.duC);
        this.bcG.add(this.duE);
        this.bcG.add(this.duD);
        this.bcG.add(this.duB);
        this.dul = bdPersonListView;
        this.dul.g(this.bcG);
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

    public void ab(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        if (arrayList != null) {
            if (arrayList != null && arrayList.size() == 0) {
                arrayList.add(this.duk.aCH().aDs());
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                boolean z = true;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.u next = it.next();
                    if (next instanceof com.baidu.tieba.person.data.a) {
                        com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) next;
                        if (!aVar.dwe && !z) {
                            aVar.dwd = false;
                        } else {
                            aVar.dwd = true;
                        }
                        z = aVar.dwe;
                    } else {
                        z = true;
                    }
                }
            }
            if (com.baidu.tbadk.core.util.y.p(this.bcG) > 0) {
                for (com.baidu.adp.widget.ListView.a aVar2 : this.bcG) {
                    if (aVar2 instanceof c) {
                        ((c) aVar2).bcn = true;
                    }
                }
            }
            if (this.dul != null) {
                this.dul.setData(arrayList);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.dul.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.dul.getAdapter()).notifyDataSetChanged();
        }
    }

    public void b(com.baidu.adp.widget.ListView.v vVar) {
        this.dur.b(vVar);
        if (this.duB != null) {
            this.duB.b(vVar);
        }
    }
}
