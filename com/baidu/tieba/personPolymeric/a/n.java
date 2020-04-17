package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private BdTypeRecyclerView hcS;
    private com.baidu.tieba.person.a.a jRN;
    private k jYA;
    private d jYB;
    private com.baidu.tieba.person.a.d jYC;
    private p jYD;
    private com.baidu.tieba.personPolymeric.a.a.g jYE;
    private com.baidu.tieba.personPolymeric.a.a.d jYF;
    private com.baidu.tieba.personPolymeric.a.a.i jYG;
    private com.baidu.tieba.personPolymeric.a.a.h jYH;
    private com.baidu.tieba.personPolymeric.a.a.a jYI;
    private com.baidu.tieba.personPolymeric.a.a.c jYJ;
    private com.baidu.tieba.personPolymeric.a.a.b jYK;
    private com.baidu.tieba.personPolymeric.a.a.e jYL;
    private com.baidu.tieba.personPolymeric.a.a.f jYM;
    private m jYt;
    private b jYu;
    private i jYv;
    private a jYw;
    private c jYx;
    private h jYy;
    private e jYz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hcS = bdTypeRecyclerView;
        this.jYt = new m(tbPageContext);
        this.jYu = new b(tbPageContext);
        this.jYv = new i(tbPageContext);
        this.jYw = new a(tbPageContext);
        this.jYx = new c(tbPageContext);
        this.jYy = new h(tbPageContext, tbPageContext.getUniqueId());
        this.jYz = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.kaP);
        this.jYA = new k(tbPageContext);
        this.jYB = new d(tbPageContext);
        this.jYC = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.jRO);
        this.jRN = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jRA);
        this.jYD = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.jYE = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jYF = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.dqT);
        this.jYG = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.dqV);
        this.jYH = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.dqZ);
        this.jYK = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.drb);
        this.jYL = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.dra);
        this.jYM = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.drc);
        this.jYI = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.gsb);
        this.jYJ = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.gsc);
        this.aMd.add(this.jYt);
        this.aMd.add(this.jYu);
        this.aMd.add(this.jYv);
        this.aMd.add(this.jYw);
        this.aMd.add(this.jYx);
        this.aMd.add(this.jYy);
        this.aMd.add(this.jYz);
        this.aMd.add(this.jYA);
        this.aMd.add(this.jYB);
        this.aMd.add(this.jYC);
        this.aMd.add(this.jRN);
        this.aMd.add(this.jYD);
        this.aMd.add(this.jYE);
        this.aMd.add(this.jYF);
        this.aMd.add(this.jYG);
        this.aMd.add(this.jYH);
        this.aMd.add(this.jYK);
        this.aMd.add(this.jYL);
        this.aMd.add(this.jYM);
        this.aMd.add(this.jYI);
        this.aMd.add(this.jYJ);
        bdTypeRecyclerView.addAdapters(this.aMd);
        yc("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jYE.ebv = bdUniqueId;
        this.jYF.ebv = bdUniqueId;
        this.jYG.ebv = bdUniqueId;
        this.jYH.ebv = bdUniqueId;
        this.jYK.ebv = bdUniqueId;
        this.jYL.ebv = bdUniqueId;
        this.jYM.ebv = bdUniqueId;
        this.jYI.ebv = bdUniqueId;
        this.jYJ.ebv = bdUniqueId;
    }

    public void AE(int i) {
        this.jYE.AG(i);
        this.jYF.AG(i);
        this.jYG.AG(i);
        this.jYH.AG(i);
        this.jYI.AG(i);
        this.jYJ.AG(i);
        this.jYK.AG(i);
        this.jYL.AG(i);
        this.jYM.AG(i);
    }

    public void AF(int i) {
        this.jYE.AF(i);
        this.jYF.AF(i);
        this.jYG.AF(i);
        this.jYH.AF(i);
        this.jYI.AF(i);
        this.jYJ.AF(i);
        this.jYK.AF(i);
        this.jYL.AF(i);
        this.jYM.AF(i);
    }

    public void setTabType(int i) {
        this.jYE.setTabType(i);
        this.jYF.setTabType(i);
        this.jYG.setTabType(i);
        this.jYH.setTabType(i);
        this.jYI.setTabType(i);
        this.jYJ.setTabType(i);
        this.jYK.setTabType(i);
        this.jYL.setTabType(i);
        this.jYM.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.jYD.setIsHost(z);
        this.jYv.setIsHost(z);
        this.jYE.setIsHost(z);
        this.jYF.setIsHost(z);
        this.jYG.setIsHost(z);
        this.jYH.setIsHost(z);
        this.jYI.setIsHost(z);
        this.jYJ.setIsHost(z);
        this.jYK.setIsHost(z);
        this.jYL.setIsHost(z);
        this.jYM.setIsHost(z);
    }

    private void yc(String str) {
        if (this.aMd != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).yc(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.hcS.getListAdapter() != null) {
            this.hcS.getListAdapter().notifyDataSetChanged();
        }
    }
}
