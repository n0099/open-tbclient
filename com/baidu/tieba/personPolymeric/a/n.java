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
    private BdTypeRecyclerView gsQ;
    private com.baidu.tieba.person.a.a jfU;
    private e jmA;
    private k jmB;
    private d jmC;
    private com.baidu.tieba.person.a.d jmD;
    private p jmE;
    private com.baidu.tieba.personPolymeric.a.a.g jmF;
    private com.baidu.tieba.personPolymeric.a.a.d jmG;
    private com.baidu.tieba.personPolymeric.a.a.i jmH;
    private com.baidu.tieba.personPolymeric.a.a.h jmI;
    private com.baidu.tieba.personPolymeric.a.a.a jmJ;
    private com.baidu.tieba.personPolymeric.a.a.c jmK;
    private com.baidu.tieba.personPolymeric.a.a.b jmL;
    private com.baidu.tieba.personPolymeric.a.a.e jmM;
    private com.baidu.tieba.personPolymeric.a.a.f jmN;
    private m jmu;
    private b jmv;
    private i jmw;
    private a jmx;
    private c jmy;
    private h jmz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gsQ = bdTypeRecyclerView;
        this.jmu = new m(tbPageContext);
        this.jmv = new b(tbPageContext);
        this.jmw = new i(tbPageContext);
        this.jmx = new a(tbPageContext);
        this.jmy = new c(tbPageContext);
        this.jmz = new h(tbPageContext, tbPageContext.getUniqueId());
        this.jmA = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.joP);
        this.jmB = new k(tbPageContext);
        this.jmC = new d(tbPageContext);
        this.jmD = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.jfV);
        this.jfU = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jfH);
        this.jmE = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.jmF = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jmG = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.cRx);
        this.jmH = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.cRz);
        this.jmI = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.cRD);
        this.jmL = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.cRF);
        this.jmM = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.cRE);
        this.jmN = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.cRG);
        this.jmJ = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.fMz);
        this.jmK = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.fMA);
        this.asE.add(this.jmu);
        this.asE.add(this.jmv);
        this.asE.add(this.jmw);
        this.asE.add(this.jmx);
        this.asE.add(this.jmy);
        this.asE.add(this.jmz);
        this.asE.add(this.jmA);
        this.asE.add(this.jmB);
        this.asE.add(this.jmC);
        this.asE.add(this.jmD);
        this.asE.add(this.jfU);
        this.asE.add(this.jmE);
        this.asE.add(this.jmF);
        this.asE.add(this.jmG);
        this.asE.add(this.jmH);
        this.asE.add(this.jmI);
        this.asE.add(this.jmL);
        this.asE.add(this.jmM);
        this.asE.add(this.jmN);
        this.asE.add(this.jmJ);
        this.asE.add(this.jmK);
        bdTypeRecyclerView.addAdapters(this.asE);
        wO("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jmF.dBk = bdUniqueId;
        this.jmG.dBk = bdUniqueId;
        this.jmH.dBk = bdUniqueId;
        this.jmI.dBk = bdUniqueId;
        this.jmL.dBk = bdUniqueId;
        this.jmM.dBk = bdUniqueId;
        this.jmN.dBk = bdUniqueId;
        this.jmJ.dBk = bdUniqueId;
        this.jmK.dBk = bdUniqueId;
    }

    public void zV(int i) {
        this.jmF.zX(i);
        this.jmG.zX(i);
        this.jmH.zX(i);
        this.jmI.zX(i);
        this.jmJ.zX(i);
        this.jmK.zX(i);
        this.jmL.zX(i);
        this.jmM.zX(i);
        this.jmN.zX(i);
    }

    public void zW(int i) {
        this.jmF.zW(i);
        this.jmG.zW(i);
        this.jmH.zW(i);
        this.jmI.zW(i);
        this.jmJ.zW(i);
        this.jmK.zW(i);
        this.jmL.zW(i);
        this.jmM.zW(i);
        this.jmN.zW(i);
    }

    public void setTabType(int i) {
        this.jmF.setTabType(i);
        this.jmG.setTabType(i);
        this.jmH.setTabType(i);
        this.jmI.setTabType(i);
        this.jmJ.setTabType(i);
        this.jmK.setTabType(i);
        this.jmL.setTabType(i);
        this.jmM.setTabType(i);
        this.jmN.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.jmE.setIsHost(z);
        this.jmw.setIsHost(z);
        this.jmF.setIsHost(z);
        this.jmG.setIsHost(z);
        this.jmH.setIsHost(z);
        this.jmI.setIsHost(z);
        this.jmJ.setIsHost(z);
        this.jmK.setIsHost(z);
        this.jmL.setIsHost(z);
        this.jmM.setIsHost(z);
        this.jmN.setIsHost(z);
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
        if (this.gsQ.getListAdapter() != null) {
            this.gsQ.getListAdapter().notifyDataSetChanged();
        }
    }
}
