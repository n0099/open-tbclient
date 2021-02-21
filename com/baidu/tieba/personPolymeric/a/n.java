package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private BdTypeRecyclerView jmy;
    private BdUniqueId mBdUniqueId;
    private com.baidu.tieba.person.a.a msA;
    private a mzA;
    private c mzB;
    private h mzC;
    private e mzD;
    private k mzE;
    private d mzF;
    private com.baidu.tieba.person.a.d mzG;
    private p mzH;
    private com.baidu.tieba.personPolymeric.a.a.g mzI;
    private com.baidu.tieba.personPolymeric.a.a.d mzJ;
    private com.baidu.tieba.personPolymeric.a.a.i mzK;
    private com.baidu.tieba.personPolymeric.a.a.h mzL;
    private com.baidu.tieba.personPolymeric.a.a.a mzM;
    private com.baidu.tieba.personPolymeric.a.a.c mzN;
    private com.baidu.tieba.personPolymeric.a.a.b mzO;
    private com.baidu.tieba.personPolymeric.a.a.e mzP;
    private com.baidu.tieba.personPolymeric.a.a.f mzQ;
    private m mzx;
    private b mzy;
    private i mzz;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jmy = bdTypeRecyclerView;
        this.mzx = new m(tbPageContext);
        this.mzy = new b(tbPageContext);
        this.mzz = new i(tbPageContext);
        this.mzA = new a(tbPageContext);
        this.mzB = new c(tbPageContext);
        this.mzC = new h(tbPageContext, tbPageContext.getUniqueId());
        this.mzD = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.mBR);
        this.mzE = new k(tbPageContext);
        this.mzF = new d(tbPageContext);
        this.mzG = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.msB);
        this.msA = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.msl);
        this.mzH = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mzI = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.mzJ = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.eQI);
        this.mzK = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.eQK);
        this.mzL = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.eQP);
        this.mzO = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.eQR);
        this.mzP = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.eQQ);
        this.mzQ = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.eQS);
        this.mzM = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.iAC);
        this.mzN = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.iAD);
        this.bns.add(this.mzx);
        this.bns.add(this.mzy);
        this.bns.add(this.mzz);
        this.bns.add(this.mzA);
        this.bns.add(this.mzB);
        this.bns.add(this.mzC);
        this.bns.add(this.mzD);
        this.bns.add(this.mzE);
        this.bns.add(this.mzF);
        this.bns.add(this.mzG);
        this.bns.add(this.msA);
        this.bns.add(this.mzH);
        this.bns.add(this.mzI);
        this.bns.add(this.mzJ);
        this.bns.add(this.mzK);
        this.bns.add(this.mzL);
        this.bns.add(this.mzO);
        this.bns.add(this.mzP);
        this.bns.add(this.mzQ);
        this.bns.add(this.mzM);
        this.bns.add(this.mzN);
        bdTypeRecyclerView.addAdapters(this.bns);
        Ew("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mzI.fGZ = bdUniqueId;
        this.mzJ.fGZ = bdUniqueId;
        this.mzK.fGZ = bdUniqueId;
        this.mzL.fGZ = bdUniqueId;
        this.mzO.fGZ = bdUniqueId;
        this.mzP.fGZ = bdUniqueId;
        this.mzQ.fGZ = bdUniqueId;
        this.mzM.fGZ = bdUniqueId;
        this.mzN.fGZ = bdUniqueId;
    }

    public void GV(int i) {
        this.mzI.GX(i);
        this.mzJ.GX(i);
        this.mzK.GX(i);
        this.mzL.GX(i);
        this.mzM.GX(i);
        this.mzN.GX(i);
        this.mzO.GX(i);
        this.mzP.GX(i);
        this.mzQ.GX(i);
    }

    public void GW(int i) {
        this.mzI.GW(i);
        this.mzJ.GW(i);
        this.mzK.GW(i);
        this.mzL.GW(i);
        this.mzM.GW(i);
        this.mzN.GW(i);
        this.mzO.GW(i);
        this.mzP.GW(i);
        this.mzQ.GW(i);
    }

    public void setTabType(int i) {
        this.mzI.setTabType(i);
        this.mzJ.setTabType(i);
        this.mzK.setTabType(i);
        this.mzL.setTabType(i);
        this.mzM.setTabType(i);
        this.mzN.setTabType(i);
        this.mzO.setTabType(i);
        this.mzP.setTabType(i);
        this.mzQ.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.mzH.setIsHost(z);
        this.mzz.setIsHost(z);
        this.mzI.setIsHost(z);
        this.mzJ.setIsHost(z);
        this.mzK.setIsHost(z);
        this.mzL.setIsHost(z);
        this.mzM.setIsHost(z);
        this.mzN.setIsHost(z);
        this.mzO.setIsHost(z);
        this.mzP.setIsHost(z);
        this.mzQ.setIsHost(z);
    }

    private void Ew(String str) {
        if (this.bns != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ew(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.jmy.getListAdapter() != null) {
            this.jmy.getListAdapter().notifyDataSetChanged();
        }
    }
}
