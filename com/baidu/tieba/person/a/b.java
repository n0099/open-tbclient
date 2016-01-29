package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private BdUniqueId aPF;
    private List<com.baidu.adp.widget.ListView.a> aXX = new ArrayList();
    private BaseFragmentActivity cZG;
    private com.baidu.tieba.personInfo.f cZH;
    private BdPersonListView cZI;
    public v cZJ;
    public ai cZK;
    public f cZL;
    public r cZM;
    public ag cZN;
    public i cZO;
    public aa cZP;
    public t cZQ;
    public ac cZR;
    public ad cZS;
    public q cZT;
    public g cZU;
    public d cZV;
    public o cZW;
    public m cZX;
    public com.baidu.tieba.person.god.a.a cZY;
    public com.baidu.tieba.person.god.a.d cZZ;
    public com.baidu.tieba.person.god.a.b daa;

    public b(com.baidu.tieba.personInfo.f fVar, BdPersonListView bdPersonListView) {
        this.cZH = fVar;
        this.cZG = fVar.getBaseFragmentActivity();
        this.aPF = this.cZH.getUniqueId();
        a(this.cZG, bdPersonListView);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, BdPersonListView bdPersonListView) {
        this.cZJ = new v(baseFragmentActivity, com.baidu.tieba.person.data.n.dbZ);
        this.cZK = new ai(baseFragmentActivity, com.baidu.tieba.person.data.q.dce);
        this.cZL = new f(this.cZH, com.baidu.tieba.person.data.c.dbE);
        this.cZM = new r(baseFragmentActivity, com.baidu.tieba.person.data.k.dbV);
        this.cZP = new aa(baseFragmentActivity, com.baidu.tieba.person.data.o.dcb);
        this.cZQ = new t(baseFragmentActivity, com.baidu.tieba.person.data.l.dbX);
        this.cZR = new ac(baseFragmentActivity, com.baidu.tieba.person.data.p.dcc);
        this.cZN = new ag(baseFragmentActivity, com.baidu.tieba.person.data.m.dbY);
        this.cZT = new q(baseFragmentActivity, com.baidu.tieba.person.data.i.dbP);
        this.cZO = new i(baseFragmentActivity, com.baidu.tieba.person.data.f.dbK);
        this.cZS = new ad(baseFragmentActivity, ae.daX);
        this.cZV = new d(baseFragmentActivity, com.baidu.tieba.person.data.b.dbC);
        this.cZU = new g(baseFragmentActivity, com.baidu.tieba.person.data.e.dbI);
        this.cZW = new o(baseFragmentActivity.getPageContext().getPageActivity(), com.baidu.tieba.person.data.h.dbO);
        this.cZX = new m(baseFragmentActivity.getPageContext().getPageActivity(), com.baidu.tieba.person.data.g.dbN);
        this.cZZ = new com.baidu.tieba.person.god.a.d(baseFragmentActivity.getPageContext(), com.baidu.tieba.card.a.s.aSz);
        this.daa = new com.baidu.tieba.person.god.a.b(baseFragmentActivity.getPageContext(), com.baidu.tieba.card.a.q.aRS);
        this.cZY = new com.baidu.tieba.person.god.a.a(baseFragmentActivity.getPageContext(), com.baidu.tieba.person.data.j.aRS);
        this.aXX.add(this.cZJ);
        this.aXX.add(this.cZL);
        this.aXX.add(this.cZK);
        this.aXX.add(this.cZP);
        this.aXX.add(this.cZQ);
        this.aXX.add(this.cZN);
        this.aXX.add(this.cZT);
        this.aXX.add(this.cZM);
        this.aXX.add(this.cZO);
        this.aXX.add(this.cZR);
        this.aXX.add(this.cZS);
        this.aXX.add(this.cZV);
        this.aXX.add(this.cZU);
        this.aXX.add(this.cZW);
        this.aXX.add(this.cZX);
        this.aXX.add(this.cZZ);
        this.aXX.add(this.daa);
        this.aXX.add(this.cZY);
        this.cZI = bdPersonListView;
        this.cZI.g(this.aXX);
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

    public void aa(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        if (arrayList != null) {
            if (arrayList != null && arrayList.size() == 0) {
                arrayList.add(this.cZH.avb().avN());
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                boolean z = true;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.u next = it.next();
                    if (next instanceof com.baidu.tieba.person.data.a) {
                        com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) next;
                        if (!aVar.dbB && !z) {
                            aVar.dbA = false;
                        } else {
                            aVar.dbA = true;
                        }
                        z = aVar.dbB;
                    } else {
                        z = true;
                    }
                }
            }
            if (com.baidu.tbadk.core.util.x.o(this.aXX) > 0) {
                for (com.baidu.adp.widget.ListView.a aVar2 : this.aXX) {
                    if (aVar2 instanceof c) {
                        ((c) aVar2).aXE = true;
                    }
                }
            }
            if (this.cZI != null) {
                this.cZI.setData(arrayList);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.cZI.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.cZI.getAdapter()).notifyDataSetChanged();
        }
    }

    public void b(com.baidu.adp.widget.ListView.v vVar) {
        this.cZO.b(vVar);
        if (this.cZY != null) {
            this.cZY.b(vVar);
        }
    }
}
