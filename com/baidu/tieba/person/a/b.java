package com.baidu.tieba.person.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personInfo.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private BdUniqueId aSq;
    private BaseFragmentActivity bfw;
    private BdPersonListView efA;
    public w efB;
    public aq efC;
    public g efD;
    public s efE;
    public ao efF;
    public j efG;
    public ab efH;
    public u efI;
    public af efJ;
    public aj efK;
    public r efL;
    public h efM;
    public d efN;
    public p efO;
    public n efP;
    public com.baidu.tieba.person.god.a.a efQ;
    public com.baidu.tieba.person.god.a.d efR;
    public com.baidu.tieba.person.god.a.d efS;
    public com.baidu.tieba.person.god.a.b efT;
    public ad efU;
    private ag efV;
    private f efz;
    private List<com.baidu.adp.widget.ListView.a> bAz = new ArrayList();
    private ArrayList<com.baidu.adp.widget.ListView.v> cmH = new ArrayList<>();

    public b(f fVar, BdPersonListView bdPersonListView) {
        this.efz = fVar;
        this.bfw = fVar.getBaseFragmentActivity();
        this.aSq = this.efz.getUniqueId();
        a(this.bfw, bdPersonListView);
    }

    private void a(BaseFragmentActivity baseFragmentActivity, BdPersonListView bdPersonListView) {
        this.efA = bdPersonListView;
        this.efB = new w(baseFragmentActivity, com.baidu.tieba.person.data.o.eik);
        this.efC = new aq(baseFragmentActivity, com.baidu.tieba.person.data.t.eit);
        this.efD = new g(this.efz, com.baidu.tieba.person.data.d.ehP);
        this.efE = new s(baseFragmentActivity, com.baidu.tieba.person.data.l.eig);
        this.efH = new ab(baseFragmentActivity, com.baidu.tieba.person.data.p.eim);
        this.efI = new u(baseFragmentActivity, com.baidu.tieba.person.data.m.eii);
        this.efJ = new af(baseFragmentActivity, com.baidu.tieba.person.data.r.eio);
        this.efF = new ao(baseFragmentActivity, com.baidu.tieba.person.data.n.eij);
        this.efL = new r(baseFragmentActivity, com.baidu.tieba.person.data.j.eia);
        this.efG = new j(baseFragmentActivity, com.baidu.tieba.person.data.g.ehV);
        this.efK = new aj(baseFragmentActivity, al.egX);
        this.efN = new d(baseFragmentActivity, com.baidu.tieba.person.data.c.ehN);
        this.efM = new h(baseFragmentActivity, com.baidu.tieba.person.data.f.ehT);
        this.efO = new p(baseFragmentActivity.getPageContext().getPageActivity(), com.baidu.tieba.person.data.i.ehZ);
        this.efP = new n(baseFragmentActivity.getPageContext().getPageActivity(), com.baidu.tieba.person.data.h.ehY);
        this.efR = new com.baidu.tieba.person.god.a.d(baseFragmentActivity.getPageContext(), com.baidu.tieba.card.a.o.aVz);
        this.efS = new com.baidu.tieba.person.god.a.d(baseFragmentActivity.getPageContext(), com.baidu.tieba.card.a.o.aVA);
        this.efT = new com.baidu.tieba.person.god.a.b(baseFragmentActivity.getPageContext(), com.baidu.tieba.card.a.m.Op);
        this.efQ = new com.baidu.tieba.person.god.a.a(baseFragmentActivity.getPageContext(), com.baidu.tieba.person.data.k.Op);
        this.efU = new ad(baseFragmentActivity.getPageContext().getPageActivity(), com.baidu.tieba.person.data.q.ein);
        this.efV = new ag(baseFragmentActivity, com.baidu.tieba.person.data.s.eiq);
        this.bAz.add(this.efB);
        this.bAz.add(this.efD);
        this.bAz.add(this.efC);
        this.bAz.add(this.efH);
        this.bAz.add(this.efI);
        this.bAz.add(this.efF);
        this.bAz.add(this.efL);
        this.bAz.add(this.efE);
        this.bAz.add(this.efG);
        this.bAz.add(this.efJ);
        this.bAz.add(this.efU);
        this.bAz.add(this.efV);
        this.bAz.add(this.efK);
        this.bAz.add(this.efN);
        this.bAz.add(this.efM);
        this.bAz.add(this.efO);
        this.bAz.add(this.efP);
        this.bAz.add(this.efR);
        this.bAz.add(this.efT);
        this.bAz.add(this.efS);
        this.bAz.add(this.efQ);
        h(baseFragmentActivity);
        this.efA.g(this.bAz);
        setPageUniqueId(this.aSq);
    }

    public void h(BaseFragmentActivity baseFragmentActivity) {
        if (EcommSwitchStatic.Fq()) {
            com.baidu.tieba.person.data.v vVar = new com.baidu.tieba.person.data.v(0);
            vVar.activity = baseFragmentActivity;
            vVar.bAz = this.bAz;
            vVar.aDA();
            com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
            iVar.activity = baseFragmentActivity;
            iVar.aoT = this.bAz;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_INFO_ADD_ADAPTER, iVar));
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aSq = bdUniqueId;
        if (this.efR != null) {
            this.efR.setPageUniqueId(bdUniqueId);
        }
        if (this.efR != null) {
            this.efT.setPageUniqueId(bdUniqueId);
        }
    }

    public void an(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (arrayList != null) {
            if (arrayList != null && arrayList.size() == 0) {
                arrayList.add(this.efz.aLZ().aMM());
            } else {
                Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
                boolean z = true;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.v next = it.next();
                    if (next instanceof com.baidu.tieba.person.data.a) {
                        com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) next;
                        if (!aVar.ehK && !z) {
                            aVar.ehJ = false;
                        } else {
                            aVar.ehJ = true;
                        }
                        z = aVar.ehK;
                    } else {
                        z = true;
                    }
                }
            }
            if (com.baidu.tbadk.core.util.y.s(this.bAz) > 0) {
                for (com.baidu.adp.widget.ListView.a aVar2 : this.bAz) {
                    if (aVar2 instanceof com.baidu.tieba.a.a) {
                        ((com.baidu.tieba.a.a) aVar2).aMF = true;
                    }
                }
            }
            if (this.efA != null) {
                this.cmH.clear();
                this.cmH.addAll(arrayList);
                this.efA.setData(this.cmH);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.efA.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.efA.getAdapter()).notifyDataSetChanged();
        }
    }

    public void d(com.baidu.adp.widget.ListView.w wVar) {
        this.efG.d(wVar);
        if (this.efQ != null) {
            this.efQ.d(wVar);
        }
    }
}
