package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private BdTypeRecyclerView hrX;
    private com.baidu.tieba.person.a.a kkQ;
    private c krA;
    private h krB;
    private e krC;
    private k krD;
    private d krE;
    private com.baidu.tieba.person.a.d krF;
    private p krG;
    private com.baidu.tieba.personPolymeric.a.a.g krH;
    private com.baidu.tieba.personPolymeric.a.a.d krI;
    private com.baidu.tieba.personPolymeric.a.a.i krJ;
    private com.baidu.tieba.personPolymeric.a.a.h krK;
    private com.baidu.tieba.personPolymeric.a.a.a krL;
    private com.baidu.tieba.personPolymeric.a.a.c krM;
    private com.baidu.tieba.personPolymeric.a.a.b krN;
    private com.baidu.tieba.personPolymeric.a.a.e krO;
    private com.baidu.tieba.personPolymeric.a.a.f krP;
    private m krw;
    private b krx;
    private i kry;
    private a krz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hrX = bdTypeRecyclerView;
        this.krw = new m(tbPageContext);
        this.krx = new b(tbPageContext);
        this.kry = new i(tbPageContext);
        this.krz = new a(tbPageContext);
        this.krA = new c(tbPageContext);
        this.krB = new h(tbPageContext, tbPageContext.getUniqueId());
        this.krC = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.ktR);
        this.krD = new k(tbPageContext);
        this.krE = new d(tbPageContext);
        this.krF = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.kkR);
        this.kkQ = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.kkD);
        this.krG = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.krH = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.krI = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.dET);
        this.krJ = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.dEV);
        this.krK = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.dEZ);
        this.krN = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.dFb);
        this.krO = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.dFa);
        this.krP = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.dFc);
        this.krL = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.gHh);
        this.krM = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.gHi);
        this.aSj.add(this.krw);
        this.aSj.add(this.krx);
        this.aSj.add(this.kry);
        this.aSj.add(this.krz);
        this.aSj.add(this.krA);
        this.aSj.add(this.krB);
        this.aSj.add(this.krC);
        this.aSj.add(this.krD);
        this.aSj.add(this.krE);
        this.aSj.add(this.krF);
        this.aSj.add(this.kkQ);
        this.aSj.add(this.krG);
        this.aSj.add(this.krH);
        this.aSj.add(this.krI);
        this.aSj.add(this.krJ);
        this.aSj.add(this.krK);
        this.aSj.add(this.krN);
        this.aSj.add(this.krO);
        this.aSj.add(this.krP);
        this.aSj.add(this.krL);
        this.aSj.add(this.krM);
        bdTypeRecyclerView.addAdapters(this.aSj);
        zL("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.krH.epM = bdUniqueId;
        this.krI.epM = bdUniqueId;
        this.krJ.epM = bdUniqueId;
        this.krK.epM = bdUniqueId;
        this.krN.epM = bdUniqueId;
        this.krO.epM = bdUniqueId;
        this.krP.epM = bdUniqueId;
        this.krL.epM = bdUniqueId;
        this.krM.epM = bdUniqueId;
    }

    public void Br(int i) {
        this.krH.Bt(i);
        this.krI.Bt(i);
        this.krJ.Bt(i);
        this.krK.Bt(i);
        this.krL.Bt(i);
        this.krM.Bt(i);
        this.krN.Bt(i);
        this.krO.Bt(i);
        this.krP.Bt(i);
    }

    public void Bs(int i) {
        this.krH.Bs(i);
        this.krI.Bs(i);
        this.krJ.Bs(i);
        this.krK.Bs(i);
        this.krL.Bs(i);
        this.krM.Bs(i);
        this.krN.Bs(i);
        this.krO.Bs(i);
        this.krP.Bs(i);
    }

    public void setTabType(int i) {
        this.krH.setTabType(i);
        this.krI.setTabType(i);
        this.krJ.setTabType(i);
        this.krK.setTabType(i);
        this.krL.setTabType(i);
        this.krM.setTabType(i);
        this.krN.setTabType(i);
        this.krO.setTabType(i);
        this.krP.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.krG.setIsHost(z);
        this.kry.setIsHost(z);
        this.krH.setIsHost(z);
        this.krI.setIsHost(z);
        this.krJ.setIsHost(z);
        this.krK.setIsHost(z);
        this.krL.setIsHost(z);
        this.krM.setIsHost(z);
        this.krN.setIsHost(z);
        this.krO.setIsHost(z);
        this.krP.setIsHost(z);
    }

    private void zL(String str) {
        if (this.aSj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).zL(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.hrX.getListAdapter() != null) {
            this.hrX.getListAdapter().notifyDataSetChanged();
        }
    }
}
