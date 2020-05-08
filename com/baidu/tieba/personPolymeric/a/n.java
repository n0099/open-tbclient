package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private BdTypeRecyclerView hcY;
    private com.baidu.tieba.person.a.a jRR;
    private a jYA;
    private c jYB;
    private h jYC;
    private e jYD;
    private k jYE;
    private d jYF;
    private com.baidu.tieba.person.a.d jYG;
    private p jYH;
    private com.baidu.tieba.personPolymeric.a.a.g jYI;
    private com.baidu.tieba.personPolymeric.a.a.d jYJ;
    private com.baidu.tieba.personPolymeric.a.a.i jYK;
    private com.baidu.tieba.personPolymeric.a.a.h jYL;
    private com.baidu.tieba.personPolymeric.a.a.a jYM;
    private com.baidu.tieba.personPolymeric.a.a.c jYN;
    private com.baidu.tieba.personPolymeric.a.a.b jYO;
    private com.baidu.tieba.personPolymeric.a.a.e jYP;
    private com.baidu.tieba.personPolymeric.a.a.f jYQ;
    private m jYx;
    private b jYy;
    private i jYz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hcY = bdTypeRecyclerView;
        this.jYx = new m(tbPageContext);
        this.jYy = new b(tbPageContext);
        this.jYz = new i(tbPageContext);
        this.jYA = new a(tbPageContext);
        this.jYB = new c(tbPageContext);
        this.jYC = new h(tbPageContext, tbPageContext.getUniqueId());
        this.jYD = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.kaT);
        this.jYE = new k(tbPageContext);
        this.jYF = new d(tbPageContext);
        this.jYG = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.jRS);
        this.jRR = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jRE);
        this.jYH = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.jYI = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jYJ = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.dqX);
        this.jYK = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.dqZ);
        this.jYL = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.drd);
        this.jYO = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.drf);
        this.jYP = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.dre);
        this.jYQ = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.drg);
        this.jYM = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.gsh);
        this.jYN = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.gsi);
        this.aMj.add(this.jYx);
        this.aMj.add(this.jYy);
        this.aMj.add(this.jYz);
        this.aMj.add(this.jYA);
        this.aMj.add(this.jYB);
        this.aMj.add(this.jYC);
        this.aMj.add(this.jYD);
        this.aMj.add(this.jYE);
        this.aMj.add(this.jYF);
        this.aMj.add(this.jYG);
        this.aMj.add(this.jRR);
        this.aMj.add(this.jYH);
        this.aMj.add(this.jYI);
        this.aMj.add(this.jYJ);
        this.aMj.add(this.jYK);
        this.aMj.add(this.jYL);
        this.aMj.add(this.jYO);
        this.aMj.add(this.jYP);
        this.aMj.add(this.jYQ);
        this.aMj.add(this.jYM);
        this.aMj.add(this.jYN);
        bdTypeRecyclerView.addAdapters(this.aMj);
        yf("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jYI.ebA = bdUniqueId;
        this.jYJ.ebA = bdUniqueId;
        this.jYK.ebA = bdUniqueId;
        this.jYL.ebA = bdUniqueId;
        this.jYO.ebA = bdUniqueId;
        this.jYP.ebA = bdUniqueId;
        this.jYQ.ebA = bdUniqueId;
        this.jYM.ebA = bdUniqueId;
        this.jYN.ebA = bdUniqueId;
    }

    public void AE(int i) {
        this.jYI.AG(i);
        this.jYJ.AG(i);
        this.jYK.AG(i);
        this.jYL.AG(i);
        this.jYM.AG(i);
        this.jYN.AG(i);
        this.jYO.AG(i);
        this.jYP.AG(i);
        this.jYQ.AG(i);
    }

    public void AF(int i) {
        this.jYI.AF(i);
        this.jYJ.AF(i);
        this.jYK.AF(i);
        this.jYL.AF(i);
        this.jYM.AF(i);
        this.jYN.AF(i);
        this.jYO.AF(i);
        this.jYP.AF(i);
        this.jYQ.AF(i);
    }

    public void setTabType(int i) {
        this.jYI.setTabType(i);
        this.jYJ.setTabType(i);
        this.jYK.setTabType(i);
        this.jYL.setTabType(i);
        this.jYM.setTabType(i);
        this.jYN.setTabType(i);
        this.jYO.setTabType(i);
        this.jYP.setTabType(i);
        this.jYQ.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.jYH.setIsHost(z);
        this.jYz.setIsHost(z);
        this.jYI.setIsHost(z);
        this.jYJ.setIsHost(z);
        this.jYK.setIsHost(z);
        this.jYL.setIsHost(z);
        this.jYM.setIsHost(z);
        this.jYN.setIsHost(z);
        this.jYO.setIsHost(z);
        this.jYP.setIsHost(z);
        this.jYQ.setIsHost(z);
    }

    private void yf(String str) {
        if (this.aMj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).yf(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.hcY.getListAdapter() != null) {
            this.hcY.getListAdapter().notifyDataSetChanged();
        }
    }
}
