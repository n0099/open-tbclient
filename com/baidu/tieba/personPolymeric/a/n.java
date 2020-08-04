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
    private com.baidu.tieba.person.a.a kNG;
    private h kUA;
    private e kUB;
    private k kUC;
    private d kUD;
    private com.baidu.tieba.person.a.d kUE;
    private p kUF;
    private com.baidu.tieba.personPolymeric.a.a.g kUG;
    private com.baidu.tieba.personPolymeric.a.a.d kUH;
    private com.baidu.tieba.personPolymeric.a.a.i kUI;
    private com.baidu.tieba.personPolymeric.a.a.h kUJ;
    private com.baidu.tieba.personPolymeric.a.a.a kUK;
    private com.baidu.tieba.personPolymeric.a.a.c kUL;
    private com.baidu.tieba.personPolymeric.a.a.b kUM;
    private com.baidu.tieba.personPolymeric.a.a.e kUN;
    private com.baidu.tieba.personPolymeric.a.a.f kUO;
    private m kUv;
    private b kUw;
    private i kUx;
    private a kUy;
    private c kUz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hKL = bdTypeRecyclerView;
        this.kUv = new m(tbPageContext);
        this.kUw = new b(tbPageContext);
        this.kUx = new i(tbPageContext);
        this.kUy = new a(tbPageContext);
        this.kUz = new c(tbPageContext);
        this.kUA = new h(tbPageContext, tbPageContext.getUniqueId());
        this.kUB = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.kWN);
        this.kUC = new k(tbPageContext);
        this.kUD = new d(tbPageContext);
        this.kUE = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.kNH);
        this.kNG = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.kNt);
        this.kUF = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.kUG = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.kUH = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.dRQ);
        this.kUI = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.dRS);
        this.kUJ = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.dRW);
        this.kUM = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.dRY);
        this.kUN = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.dRX);
        this.kUO = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.dRZ);
        this.kUK = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.gZL);
        this.kUL = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.gZM);
        this.aWf.add(this.kUv);
        this.aWf.add(this.kUw);
        this.aWf.add(this.kUx);
        this.aWf.add(this.kUy);
        this.aWf.add(this.kUz);
        this.aWf.add(this.kUA);
        this.aWf.add(this.kUB);
        this.aWf.add(this.kUC);
        this.aWf.add(this.kUD);
        this.aWf.add(this.kUE);
        this.aWf.add(this.kNG);
        this.aWf.add(this.kUF);
        this.aWf.add(this.kUG);
        this.aWf.add(this.kUH);
        this.aWf.add(this.kUI);
        this.aWf.add(this.kUJ);
        this.aWf.add(this.kUM);
        this.aWf.add(this.kUN);
        this.aWf.add(this.kUO);
        this.aWf.add(this.kUK);
        this.aWf.add(this.kUL);
        bdTypeRecyclerView.addAdapters(this.aWf);
        AP("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.kUG.eEU = bdUniqueId;
        this.kUH.eEU = bdUniqueId;
        this.kUI.eEU = bdUniqueId;
        this.kUJ.eEU = bdUniqueId;
        this.kUM.eEU = bdUniqueId;
        this.kUN.eEU = bdUniqueId;
        this.kUO.eEU = bdUniqueId;
        this.kUK.eEU = bdUniqueId;
        this.kUL.eEU = bdUniqueId;
    }

    public void CT(int i) {
        this.kUG.CV(i);
        this.kUH.CV(i);
        this.kUI.CV(i);
        this.kUJ.CV(i);
        this.kUK.CV(i);
        this.kUL.CV(i);
        this.kUM.CV(i);
        this.kUN.CV(i);
        this.kUO.CV(i);
    }

    public void CU(int i) {
        this.kUG.CU(i);
        this.kUH.CU(i);
        this.kUI.CU(i);
        this.kUJ.CU(i);
        this.kUK.CU(i);
        this.kUL.CU(i);
        this.kUM.CU(i);
        this.kUN.CU(i);
        this.kUO.CU(i);
    }

    public void setTabType(int i) {
        this.kUG.setTabType(i);
        this.kUH.setTabType(i);
        this.kUI.setTabType(i);
        this.kUJ.setTabType(i);
        this.kUK.setTabType(i);
        this.kUL.setTabType(i);
        this.kUM.setTabType(i);
        this.kUN.setTabType(i);
        this.kUO.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.kUF.setIsHost(z);
        this.kUx.setIsHost(z);
        this.kUG.setIsHost(z);
        this.kUH.setIsHost(z);
        this.kUI.setIsHost(z);
        this.kUJ.setIsHost(z);
        this.kUK.setIsHost(z);
        this.kUL.setIsHost(z);
        this.kUM.setIsHost(z);
        this.kUN.setIsHost(z);
        this.kUO.setIsHost(z);
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
