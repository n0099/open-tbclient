package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private BdTypeRecyclerView gsO;
    private com.baidu.tieba.person.a.a jfS;
    private d jmA;
    private com.baidu.tieba.person.a.d jmB;
    private p jmC;
    private com.baidu.tieba.personPolymeric.a.a.g jmD;
    private com.baidu.tieba.personPolymeric.a.a.d jmE;
    private com.baidu.tieba.personPolymeric.a.a.i jmF;
    private com.baidu.tieba.personPolymeric.a.a.h jmG;
    private com.baidu.tieba.personPolymeric.a.a.a jmH;
    private com.baidu.tieba.personPolymeric.a.a.c jmI;
    private com.baidu.tieba.personPolymeric.a.a.b jmJ;
    private com.baidu.tieba.personPolymeric.a.a.e jmK;
    private com.baidu.tieba.personPolymeric.a.a.f jmL;
    private m jms;
    private b jmt;
    private i jmu;
    private a jmv;
    private c jmw;
    private h jmx;
    private e jmy;
    private k jmz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gsO = bdTypeRecyclerView;
        this.jms = new m(tbPageContext);
        this.jmt = new b(tbPageContext);
        this.jmu = new i(tbPageContext);
        this.jmv = new a(tbPageContext);
        this.jmw = new c(tbPageContext);
        this.jmx = new h(tbPageContext, tbPageContext.getUniqueId());
        this.jmy = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.joN);
        this.jmz = new k(tbPageContext);
        this.jmA = new d(tbPageContext);
        this.jmB = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.jfT);
        this.jfS = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jfF);
        this.jmC = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.jmD = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jmE = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.cRw);
        this.jmF = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.cRy);
        this.jmG = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.cRC);
        this.jmJ = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.cRE);
        this.jmK = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.cRD);
        this.jmL = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.cRF);
        this.jmH = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.fMx);
        this.jmI = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.fMy);
        this.asE.add(this.jms);
        this.asE.add(this.jmt);
        this.asE.add(this.jmu);
        this.asE.add(this.jmv);
        this.asE.add(this.jmw);
        this.asE.add(this.jmx);
        this.asE.add(this.jmy);
        this.asE.add(this.jmz);
        this.asE.add(this.jmA);
        this.asE.add(this.jmB);
        this.asE.add(this.jfS);
        this.asE.add(this.jmC);
        this.asE.add(this.jmD);
        this.asE.add(this.jmE);
        this.asE.add(this.jmF);
        this.asE.add(this.jmG);
        this.asE.add(this.jmJ);
        this.asE.add(this.jmK);
        this.asE.add(this.jmL);
        this.asE.add(this.jmH);
        this.asE.add(this.jmI);
        bdTypeRecyclerView.addAdapters(this.asE);
        wO("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jmD.dBj = bdUniqueId;
        this.jmE.dBj = bdUniqueId;
        this.jmF.dBj = bdUniqueId;
        this.jmG.dBj = bdUniqueId;
        this.jmJ.dBj = bdUniqueId;
        this.jmK.dBj = bdUniqueId;
        this.jmL.dBj = bdUniqueId;
        this.jmH.dBj = bdUniqueId;
        this.jmI.dBj = bdUniqueId;
    }

    public void zV(int i) {
        this.jmD.zX(i);
        this.jmE.zX(i);
        this.jmF.zX(i);
        this.jmG.zX(i);
        this.jmH.zX(i);
        this.jmI.zX(i);
        this.jmJ.zX(i);
        this.jmK.zX(i);
        this.jmL.zX(i);
    }

    public void zW(int i) {
        this.jmD.zW(i);
        this.jmE.zW(i);
        this.jmF.zW(i);
        this.jmG.zW(i);
        this.jmH.zW(i);
        this.jmI.zW(i);
        this.jmJ.zW(i);
        this.jmK.zW(i);
        this.jmL.zW(i);
    }

    public void setTabType(int i) {
        this.jmD.setTabType(i);
        this.jmE.setTabType(i);
        this.jmF.setTabType(i);
        this.jmG.setTabType(i);
        this.jmH.setTabType(i);
        this.jmI.setTabType(i);
        this.jmJ.setTabType(i);
        this.jmK.setTabType(i);
        this.jmL.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.jmC.setIsHost(z);
        this.jmu.setIsHost(z);
        this.jmD.setIsHost(z);
        this.jmE.setIsHost(z);
        this.jmF.setIsHost(z);
        this.jmG.setIsHost(z);
        this.jmH.setIsHost(z);
        this.jmI.setIsHost(z);
        this.jmJ.setIsHost(z);
        this.jmK.setIsHost(z);
        this.jmL.setIsHost(z);
    }

    private void wO(String str) {
        if (this.asE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wO(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gsO.getListAdapter() != null) {
            this.gsO.getListAdapter().notifyDataSetChanged();
        }
    }
}
