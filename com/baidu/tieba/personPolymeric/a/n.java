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
    private BdTypeRecyclerView hrM;
    private com.baidu.tieba.person.a.a kjK;
    private p kqA;
    private com.baidu.tieba.personPolymeric.a.a.g kqB;
    private com.baidu.tieba.personPolymeric.a.a.d kqC;
    private com.baidu.tieba.personPolymeric.a.a.i kqD;
    private com.baidu.tieba.personPolymeric.a.a.h kqE;
    private com.baidu.tieba.personPolymeric.a.a.a kqF;
    private com.baidu.tieba.personPolymeric.a.a.c kqG;
    private com.baidu.tieba.personPolymeric.a.a.b kqH;
    private com.baidu.tieba.personPolymeric.a.a.e kqI;
    private com.baidu.tieba.personPolymeric.a.a.f kqJ;
    private m kqq;
    private b kqr;
    private i kqs;
    private a kqt;
    private c kqu;
    private h kqv;
    private e kqw;
    private k kqx;
    private d kqy;
    private com.baidu.tieba.person.a.d kqz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hrM = bdTypeRecyclerView;
        this.kqq = new m(tbPageContext);
        this.kqr = new b(tbPageContext);
        this.kqs = new i(tbPageContext);
        this.kqt = new a(tbPageContext);
        this.kqu = new c(tbPageContext);
        this.kqv = new h(tbPageContext, tbPageContext.getUniqueId());
        this.kqw = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.ksL);
        this.kqx = new k(tbPageContext);
        this.kqy = new d(tbPageContext);
        this.kqz = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.kjL);
        this.kjK = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.kjx);
        this.kqA = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.kqB = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.kqC = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.dET);
        this.kqD = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.dEV);
        this.kqE = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.dEZ);
        this.kqH = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.dFb);
        this.kqI = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.dFa);
        this.kqJ = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.dFc);
        this.kqF = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.gGW);
        this.kqG = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.gGX);
        this.aSj.add(this.kqq);
        this.aSj.add(this.kqr);
        this.aSj.add(this.kqs);
        this.aSj.add(this.kqt);
        this.aSj.add(this.kqu);
        this.aSj.add(this.kqv);
        this.aSj.add(this.kqw);
        this.aSj.add(this.kqx);
        this.aSj.add(this.kqy);
        this.aSj.add(this.kqz);
        this.aSj.add(this.kjK);
        this.aSj.add(this.kqA);
        this.aSj.add(this.kqB);
        this.aSj.add(this.kqC);
        this.aSj.add(this.kqD);
        this.aSj.add(this.kqE);
        this.aSj.add(this.kqH);
        this.aSj.add(this.kqI);
        this.aSj.add(this.kqJ);
        this.aSj.add(this.kqF);
        this.aSj.add(this.kqG);
        bdTypeRecyclerView.addAdapters(this.aSj);
        zL("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.kqB.epM = bdUniqueId;
        this.kqC.epM = bdUniqueId;
        this.kqD.epM = bdUniqueId;
        this.kqE.epM = bdUniqueId;
        this.kqH.epM = bdUniqueId;
        this.kqI.epM = bdUniqueId;
        this.kqJ.epM = bdUniqueId;
        this.kqF.epM = bdUniqueId;
        this.kqG.epM = bdUniqueId;
    }

    public void Bp(int i) {
        this.kqB.Br(i);
        this.kqC.Br(i);
        this.kqD.Br(i);
        this.kqE.Br(i);
        this.kqF.Br(i);
        this.kqG.Br(i);
        this.kqH.Br(i);
        this.kqI.Br(i);
        this.kqJ.Br(i);
    }

    public void Bq(int i) {
        this.kqB.Bq(i);
        this.kqC.Bq(i);
        this.kqD.Bq(i);
        this.kqE.Bq(i);
        this.kqF.Bq(i);
        this.kqG.Bq(i);
        this.kqH.Bq(i);
        this.kqI.Bq(i);
        this.kqJ.Bq(i);
    }

    public void setTabType(int i) {
        this.kqB.setTabType(i);
        this.kqC.setTabType(i);
        this.kqD.setTabType(i);
        this.kqE.setTabType(i);
        this.kqF.setTabType(i);
        this.kqG.setTabType(i);
        this.kqH.setTabType(i);
        this.kqI.setTabType(i);
        this.kqJ.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.kqA.setIsHost(z);
        this.kqs.setIsHost(z);
        this.kqB.setIsHost(z);
        this.kqC.setIsHost(z);
        this.kqD.setIsHost(z);
        this.kqE.setIsHost(z);
        this.kqF.setIsHost(z);
        this.kqG.setIsHost(z);
        this.kqH.setIsHost(z);
        this.kqI.setIsHost(z);
        this.kqJ.setIsHost(z);
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
        if (this.hrM.getListAdapter() != null) {
            this.hrM.getListAdapter().notifyDataSetChanged();
        }
    }
}
