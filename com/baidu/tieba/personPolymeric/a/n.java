package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private BdTypeRecyclerView gtd;
    private com.baidu.tieba.person.a.a jgg;
    private m jmG;
    private b jmH;
    private i jmI;
    private a jmJ;
    private c jmK;
    private h jmL;
    private e jmM;
    private k jmN;
    private d jmO;
    private com.baidu.tieba.person.a.d jmP;
    private p jmQ;
    private com.baidu.tieba.personPolymeric.a.a.g jmR;
    private com.baidu.tieba.personPolymeric.a.a.d jmS;
    private com.baidu.tieba.personPolymeric.a.a.i jmT;
    private com.baidu.tieba.personPolymeric.a.a.h jmU;
    private com.baidu.tieba.personPolymeric.a.a.a jmV;
    private com.baidu.tieba.personPolymeric.a.a.c jmW;
    private com.baidu.tieba.personPolymeric.a.a.b jmX;
    private com.baidu.tieba.personPolymeric.a.a.e jmY;
    private com.baidu.tieba.personPolymeric.a.a.f jmZ;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gtd = bdTypeRecyclerView;
        this.jmG = new m(tbPageContext);
        this.jmH = new b(tbPageContext);
        this.jmI = new i(tbPageContext);
        this.jmJ = new a(tbPageContext);
        this.jmK = new c(tbPageContext);
        this.jmL = new h(tbPageContext, tbPageContext.getUniqueId());
        this.jmM = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.jpb);
        this.jmN = new k(tbPageContext);
        this.jmO = new d(tbPageContext);
        this.jmP = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.jgh);
        this.jgg = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jfT);
        this.jmQ = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.jmR = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jmS = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.cRy);
        this.jmT = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.cRA);
        this.jmU = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.cRE);
        this.jmX = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.cRG);
        this.jmY = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.cRF);
        this.jmZ = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.cRH);
        this.jmV = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.fMM);
        this.jmW = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.fMN);
        this.asF.add(this.jmG);
        this.asF.add(this.jmH);
        this.asF.add(this.jmI);
        this.asF.add(this.jmJ);
        this.asF.add(this.jmK);
        this.asF.add(this.jmL);
        this.asF.add(this.jmM);
        this.asF.add(this.jmN);
        this.asF.add(this.jmO);
        this.asF.add(this.jmP);
        this.asF.add(this.jgg);
        this.asF.add(this.jmQ);
        this.asF.add(this.jmR);
        this.asF.add(this.jmS);
        this.asF.add(this.jmT);
        this.asF.add(this.jmU);
        this.asF.add(this.jmX);
        this.asF.add(this.jmY);
        this.asF.add(this.jmZ);
        this.asF.add(this.jmV);
        this.asF.add(this.jmW);
        bdTypeRecyclerView.addAdapters(this.asF);
        wP("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jmR.dBx = bdUniqueId;
        this.jmS.dBx = bdUniqueId;
        this.jmT.dBx = bdUniqueId;
        this.jmU.dBx = bdUniqueId;
        this.jmX.dBx = bdUniqueId;
        this.jmY.dBx = bdUniqueId;
        this.jmZ.dBx = bdUniqueId;
        this.jmV.dBx = bdUniqueId;
        this.jmW.dBx = bdUniqueId;
    }

    public void zV(int i) {
        this.jmR.zX(i);
        this.jmS.zX(i);
        this.jmT.zX(i);
        this.jmU.zX(i);
        this.jmV.zX(i);
        this.jmW.zX(i);
        this.jmX.zX(i);
        this.jmY.zX(i);
        this.jmZ.zX(i);
    }

    public void zW(int i) {
        this.jmR.zW(i);
        this.jmS.zW(i);
        this.jmT.zW(i);
        this.jmU.zW(i);
        this.jmV.zW(i);
        this.jmW.zW(i);
        this.jmX.zW(i);
        this.jmY.zW(i);
        this.jmZ.zW(i);
    }

    public void setTabType(int i) {
        this.jmR.setTabType(i);
        this.jmS.setTabType(i);
        this.jmT.setTabType(i);
        this.jmU.setTabType(i);
        this.jmV.setTabType(i);
        this.jmW.setTabType(i);
        this.jmX.setTabType(i);
        this.jmY.setTabType(i);
        this.jmZ.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.jmQ.setIsHost(z);
        this.jmI.setIsHost(z);
        this.jmR.setIsHost(z);
        this.jmS.setIsHost(z);
        this.jmT.setIsHost(z);
        this.jmU.setIsHost(z);
        this.jmV.setIsHost(z);
        this.jmW.setIsHost(z);
        this.jmX.setIsHost(z);
        this.jmY.setIsHost(z);
        this.jmZ.setIsHost(z);
    }

    private void wP(String str) {
        if (this.asF != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wP(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gtd.getListAdapter() != null) {
            this.gtd.getListAdapter().notifyDataSetChanged();
        }
    }
}
