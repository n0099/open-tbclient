package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private BdTypeRecyclerView hEN;
    private com.baidu.tieba.person.a.a kEC;
    private k kLA;
    private d kLB;
    private com.baidu.tieba.person.a.d kLC;
    private p kLD;
    private com.baidu.tieba.personPolymeric.a.a.g kLE;
    private com.baidu.tieba.personPolymeric.a.a.d kLF;
    private com.baidu.tieba.personPolymeric.a.a.i kLG;
    private com.baidu.tieba.personPolymeric.a.a.h kLH;
    private com.baidu.tieba.personPolymeric.a.a.a kLI;
    private com.baidu.tieba.personPolymeric.a.a.c kLJ;
    private com.baidu.tieba.personPolymeric.a.a.b kLK;
    private com.baidu.tieba.personPolymeric.a.a.e kLL;
    private com.baidu.tieba.personPolymeric.a.a.f kLM;
    private m kLt;
    private b kLu;
    private i kLv;
    private a kLw;
    private c kLx;
    private h kLy;
    private e kLz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hEN = bdTypeRecyclerView;
        this.kLt = new m(tbPageContext);
        this.kLu = new b(tbPageContext);
        this.kLv = new i(tbPageContext);
        this.kLw = new a(tbPageContext);
        this.kLx = new c(tbPageContext);
        this.kLy = new h(tbPageContext, tbPageContext.getUniqueId());
        this.kLz = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.kNO);
        this.kLA = new k(tbPageContext);
        this.kLB = new d(tbPageContext);
        this.kLC = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.kED);
        this.kEC = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.kEp);
        this.kLD = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.kLE = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.kLF = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.dLF);
        this.kLG = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.dLH);
        this.kLH = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.dLL);
        this.kLK = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.dLN);
        this.kLL = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.dLM);
        this.kLM = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.dLO);
        this.kLI = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.gUh);
        this.kLJ = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.gUi);
        this.aUP.add(this.kLt);
        this.aUP.add(this.kLu);
        this.aUP.add(this.kLv);
        this.aUP.add(this.kLw);
        this.aUP.add(this.kLx);
        this.aUP.add(this.kLy);
        this.aUP.add(this.kLz);
        this.aUP.add(this.kLA);
        this.aUP.add(this.kLB);
        this.aUP.add(this.kLC);
        this.aUP.add(this.kEC);
        this.aUP.add(this.kLD);
        this.aUP.add(this.kLE);
        this.aUP.add(this.kLF);
        this.aUP.add(this.kLG);
        this.aUP.add(this.kLH);
        this.aUP.add(this.kLK);
        this.aUP.add(this.kLL);
        this.aUP.add(this.kLM);
        this.aUP.add(this.kLI);
        this.aUP.add(this.kLJ);
        bdTypeRecyclerView.addAdapters(this.aUP);
        Ae("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.kLE.eyE = bdUniqueId;
        this.kLF.eyE = bdUniqueId;
        this.kLG.eyE = bdUniqueId;
        this.kLH.eyE = bdUniqueId;
        this.kLK.eyE = bdUniqueId;
        this.kLL.eyE = bdUniqueId;
        this.kLM.eyE = bdUniqueId;
        this.kLI.eyE = bdUniqueId;
        this.kLJ.eyE = bdUniqueId;
    }

    public void Ct(int i) {
        this.kLE.Cv(i);
        this.kLF.Cv(i);
        this.kLG.Cv(i);
        this.kLH.Cv(i);
        this.kLI.Cv(i);
        this.kLJ.Cv(i);
        this.kLK.Cv(i);
        this.kLL.Cv(i);
        this.kLM.Cv(i);
    }

    public void Cu(int i) {
        this.kLE.Cu(i);
        this.kLF.Cu(i);
        this.kLG.Cu(i);
        this.kLH.Cu(i);
        this.kLI.Cu(i);
        this.kLJ.Cu(i);
        this.kLK.Cu(i);
        this.kLL.Cu(i);
        this.kLM.Cu(i);
    }

    public void setTabType(int i) {
        this.kLE.setTabType(i);
        this.kLF.setTabType(i);
        this.kLG.setTabType(i);
        this.kLH.setTabType(i);
        this.kLI.setTabType(i);
        this.kLJ.setTabType(i);
        this.kLK.setTabType(i);
        this.kLL.setTabType(i);
        this.kLM.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.kLD.setIsHost(z);
        this.kLv.setIsHost(z);
        this.kLE.setIsHost(z);
        this.kLF.setIsHost(z);
        this.kLG.setIsHost(z);
        this.kLH.setIsHost(z);
        this.kLI.setIsHost(z);
        this.kLJ.setIsHost(z);
        this.kLK.setIsHost(z);
        this.kLL.setIsHost(z);
        this.kLM.setIsHost(z);
    }

    private void Ae(String str) {
        if (this.aUP != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ae(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.hEN.getListAdapter() != null) {
            this.hEN.getListAdapter().notifyDataSetChanged();
        }
    }
}
