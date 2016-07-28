package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personInfo.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private BdUniqueId aTm;
    private BaseFragmentActivity bgI;
    private BdPersonListView epA;
    public u epB;
    public ao epC;
    public i epD;
    public q epE;
    public am epF;
    public f epG;
    public l epH;
    public z epI;
    public s epJ;
    public ad epK;
    public ah epL;
    public p epM;
    public j epN;
    public d epO;
    public com.baidu.tieba.person.god.a.a epP;
    public com.baidu.tieba.person.god.a.d epQ;
    public com.baidu.tieba.person.god.a.d epR;
    public com.baidu.tieba.person.god.a.b epS;
    public ab epT;
    private ae epU;
    private h epz;
    private List<com.baidu.adp.widget.ListView.a> bCN = new ArrayList();
    private ArrayList<com.baidu.adp.widget.ListView.v> coW = new ArrayList<>();

    public b(h hVar, BdPersonListView bdPersonListView) {
        this.epz = hVar;
        this.bgI = hVar.getBaseFragmentActivity();
        this.aTm = this.epz.getUniqueId();
        a(this.bgI, bdPersonListView);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, BdPersonListView bdPersonListView) {
        this.epA = bdPersonListView;
        this.epB = new u(baseFragmentActivity, com.baidu.tieba.person.data.n.eso);
        this.epC = new ao(baseFragmentActivity, com.baidu.tieba.person.data.s.esx);
        this.epD = new i(this.epz, com.baidu.tieba.person.data.e.erV);
        this.epE = new q(baseFragmentActivity, com.baidu.tieba.person.data.k.esk);
        this.epI = new z(baseFragmentActivity, com.baidu.tieba.person.data.o.esq);
        this.epJ = new s(baseFragmentActivity, com.baidu.tieba.person.data.l.esm);
        this.epK = new ad(baseFragmentActivity, com.baidu.tieba.person.data.q.ess);
        this.epF = new am(baseFragmentActivity, com.baidu.tieba.person.data.m.esn);
        this.epG = new f(baseFragmentActivity, com.baidu.tieba.person.data.d.erO);
        this.epM = new p(baseFragmentActivity, com.baidu.tieba.person.data.i.ese);
        this.epH = new l(baseFragmentActivity, com.baidu.tieba.person.data.h.esb);
        this.epL = new ah(baseFragmentActivity, aj.eqW);
        this.epO = new d(baseFragmentActivity, com.baidu.tieba.person.data.c.erM);
        this.epN = new j(baseFragmentActivity, com.baidu.tieba.person.data.g.erZ);
        this.epQ = new com.baidu.tieba.person.god.a.d(baseFragmentActivity.getPageContext(), com.baidu.tieba.card.a.o.aWx);
        this.epR = new com.baidu.tieba.person.god.a.d(baseFragmentActivity.getPageContext(), com.baidu.tieba.card.a.o.aWy);
        this.epS = new com.baidu.tieba.person.god.a.b(baseFragmentActivity.getPageContext(), com.baidu.tieba.card.a.m.OB);
        this.epP = new com.baidu.tieba.person.god.a.a(baseFragmentActivity.getPageContext(), com.baidu.tieba.person.data.j.OB);
        this.epT = new ab(baseFragmentActivity.getPageContext().getPageActivity(), com.baidu.tieba.person.data.p.esr);
        this.epU = new ae(baseFragmentActivity, com.baidu.tieba.person.data.r.esu);
        this.bCN.add(this.epB);
        this.bCN.add(this.epD);
        this.bCN.add(this.epC);
        this.bCN.add(this.epI);
        this.bCN.add(this.epJ);
        this.bCN.add(this.epF);
        this.bCN.add(this.epG);
        this.bCN.add(this.epM);
        this.bCN.add(this.epE);
        this.bCN.add(this.epH);
        this.bCN.add(this.epK);
        this.bCN.add(this.epT);
        this.bCN.add(this.epU);
        this.bCN.add(this.epL);
        this.bCN.add(this.epO);
        this.bCN.add(this.epN);
        this.bCN.add(this.epQ);
        this.bCN.add(this.epS);
        this.bCN.add(this.epR);
        this.bCN.add(this.epP);
        h(baseFragmentActivity);
        this.epA.g(this.bCN);
        setPageUniqueId(this.aTm);
    }

    public void h(BaseFragmentActivity baseFragmentActivity) {
        if (EcommSwitchStatic.Fr()) {
            com.baidu.tieba.person.data.u uVar = new com.baidu.tieba.person.data.u(0);
            uVar.activity = baseFragmentActivity;
            uVar.bCN = this.bCN;
            uVar.aGK();
            com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
            iVar.activity = baseFragmentActivity;
            iVar.apJ = this.bCN;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_INFO_ADD_ADAPTER, iVar));
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aTm = bdUniqueId;
        if (this.epQ != null) {
            this.epQ.setPageUniqueId(bdUniqueId);
        }
        if (this.epQ != null) {
            this.epS.setPageUniqueId(bdUniqueId);
        }
    }

    public void ap(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (!com.baidu.tbadk.core.util.y.t(arrayList)) {
            Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof com.baidu.tieba.person.data.a) {
                    com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) next;
                    if (!aVar.erJ && !z) {
                        aVar.erI = false;
                    } else {
                        aVar.erI = true;
                    }
                    z = aVar.erJ;
                } else {
                    z = true;
                }
            }
            if (com.baidu.tbadk.core.util.y.s(this.bCN) > 0) {
                for (com.baidu.adp.widget.ListView.a aVar2 : this.bCN) {
                    if (aVar2 instanceof com.baidu.tieba.a.a) {
                        ((com.baidu.tieba.a.a) aVar2).aNz = true;
                    }
                }
            }
            if (this.epA != null) {
                this.coW.clear();
                this.coW.addAll(arrayList);
                this.epA.setData(this.coW);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.epA.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.epA.getAdapter()).notifyDataSetChanged();
        }
    }

    public void d(com.baidu.adp.widget.ListView.w wVar) {
        this.epH.d(wVar);
        if (this.epP != null) {
            this.epP.d(wVar);
        }
    }
}
