package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private BdTypeRecyclerView hKL;
    private com.baidu.tieba.person.a.a kNE;
    private k kUA;
    private d kUB;
    private com.baidu.tieba.person.a.d kUC;
    private p kUD;
    private com.baidu.tieba.personPolymeric.a.a.g kUE;
    private com.baidu.tieba.personPolymeric.a.a.d kUF;
    private com.baidu.tieba.personPolymeric.a.a.i kUG;
    private com.baidu.tieba.personPolymeric.a.a.h kUH;
    private com.baidu.tieba.personPolymeric.a.a.a kUI;
    private com.baidu.tieba.personPolymeric.a.a.c kUJ;
    private com.baidu.tieba.personPolymeric.a.a.b kUK;
    private com.baidu.tieba.personPolymeric.a.a.e kUL;
    private com.baidu.tieba.personPolymeric.a.a.f kUM;
    private m kUt;
    private b kUu;
    private i kUv;
    private a kUw;
    private c kUx;
    private h kUy;
    private e kUz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hKL = bdTypeRecyclerView;
        this.kUt = new m(tbPageContext);
        this.kUu = new b(tbPageContext);
        this.kUv = new i(tbPageContext);
        this.kUw = new a(tbPageContext);
        this.kUx = new c(tbPageContext);
        this.kUy = new h(tbPageContext, tbPageContext.getUniqueId());
        this.kUz = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.kWL);
        this.kUA = new k(tbPageContext);
        this.kUB = new d(tbPageContext);
        this.kUC = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.kNF);
        this.kNE = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.kNr);
        this.kUD = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.kUE = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.kUF = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.dRQ);
        this.kUG = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.dRS);
        this.kUH = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.dRW);
        this.kUK = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.dRY);
        this.kUL = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.dRX);
        this.kUM = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.dRZ);
        this.kUI = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.gZL);
        this.kUJ = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.gZM);
        this.aWf.add(this.kUt);
        this.aWf.add(this.kUu);
        this.aWf.add(this.kUv);
        this.aWf.add(this.kUw);
        this.aWf.add(this.kUx);
        this.aWf.add(this.kUy);
        this.aWf.add(this.kUz);
        this.aWf.add(this.kUA);
        this.aWf.add(this.kUB);
        this.aWf.add(this.kUC);
        this.aWf.add(this.kNE);
        this.aWf.add(this.kUD);
        this.aWf.add(this.kUE);
        this.aWf.add(this.kUF);
        this.aWf.add(this.kUG);
        this.aWf.add(this.kUH);
        this.aWf.add(this.kUK);
        this.aWf.add(this.kUL);
        this.aWf.add(this.kUM);
        this.aWf.add(this.kUI);
        this.aWf.add(this.kUJ);
        bdTypeRecyclerView.addAdapters(this.aWf);
        AP("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.kUE.eEU = bdUniqueId;
        this.kUF.eEU = bdUniqueId;
        this.kUG.eEU = bdUniqueId;
        this.kUH.eEU = bdUniqueId;
        this.kUK.eEU = bdUniqueId;
        this.kUL.eEU = bdUniqueId;
        this.kUM.eEU = bdUniqueId;
        this.kUI.eEU = bdUniqueId;
        this.kUJ.eEU = bdUniqueId;
    }

    public void CT(int i) {
        this.kUE.CV(i);
        this.kUF.CV(i);
        this.kUG.CV(i);
        this.kUH.CV(i);
        this.kUI.CV(i);
        this.kUJ.CV(i);
        this.kUK.CV(i);
        this.kUL.CV(i);
        this.kUM.CV(i);
    }

    public void CU(int i) {
        this.kUE.CU(i);
        this.kUF.CU(i);
        this.kUG.CU(i);
        this.kUH.CU(i);
        this.kUI.CU(i);
        this.kUJ.CU(i);
        this.kUK.CU(i);
        this.kUL.CU(i);
        this.kUM.CU(i);
    }

    public void setTabType(int i) {
        this.kUE.setTabType(i);
        this.kUF.setTabType(i);
        this.kUG.setTabType(i);
        this.kUH.setTabType(i);
        this.kUI.setTabType(i);
        this.kUJ.setTabType(i);
        this.kUK.setTabType(i);
        this.kUL.setTabType(i);
        this.kUM.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.kUD.setIsHost(z);
        this.kUv.setIsHost(z);
        this.kUE.setIsHost(z);
        this.kUF.setIsHost(z);
        this.kUG.setIsHost(z);
        this.kUH.setIsHost(z);
        this.kUI.setIsHost(z);
        this.kUJ.setIsHost(z);
        this.kUK.setIsHost(z);
        this.kUL.setIsHost(z);
        this.kUM.setIsHost(z);
    }

    private void AP(String str) {
        if (this.aWf != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).AP(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.hKL.getListAdapter() != null) {
            this.hKL.getListAdapter().notifyDataSetChanged();
        }
    }
}
