package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private BdTypeRecyclerView iYU;
    private BdUniqueId mBdUniqueId;
    private com.baidu.tieba.person.a.a miE;
    private b mpA;
    private i mpB;
    private a mpC;
    private c mpD;
    private h mpE;
    private e mpF;
    private k mpG;
    private d mpH;
    private com.baidu.tieba.person.a.d mpI;
    private p mpJ;
    private com.baidu.tieba.personPolymeric.a.a.g mpK;
    private com.baidu.tieba.personPolymeric.a.a.d mpL;
    private com.baidu.tieba.personPolymeric.a.a.i mpM;
    private com.baidu.tieba.personPolymeric.a.a.h mpN;
    private com.baidu.tieba.personPolymeric.a.a.a mpO;
    private com.baidu.tieba.personPolymeric.a.a.c mpP;
    private com.baidu.tieba.personPolymeric.a.a.b mpQ;
    private com.baidu.tieba.personPolymeric.a.a.e mpR;
    private com.baidu.tieba.personPolymeric.a.a.f mpS;
    private m mpz;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iYU = bdTypeRecyclerView;
        this.mpz = new m(tbPageContext);
        this.mpA = new b(tbPageContext);
        this.mpB = new i(tbPageContext);
        this.mpC = new a(tbPageContext);
        this.mpD = new c(tbPageContext);
        this.mpE = new h(tbPageContext, tbPageContext.getUniqueId());
        this.mpF = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.mrR);
        this.mpG = new k(tbPageContext);
        this.mpH = new d(tbPageContext);
        this.mpI = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.miF);
        this.miE = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.mip);
        this.mpJ = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mpK = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.mpL = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.eJo);
        this.mpM = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.eJq);
        this.mpN = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.eJv);
        this.mpQ = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.eJx);
        this.mpR = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.eJw);
        this.mpS = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.eJy);
        this.mpO = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.imO);
        this.mpP = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.imP);
        this.bnf.add(this.mpz);
        this.bnf.add(this.mpA);
        this.bnf.add(this.mpB);
        this.bnf.add(this.mpC);
        this.bnf.add(this.mpD);
        this.bnf.add(this.mpE);
        this.bnf.add(this.mpF);
        this.bnf.add(this.mpG);
        this.bnf.add(this.mpH);
        this.bnf.add(this.mpI);
        this.bnf.add(this.miE);
        this.bnf.add(this.mpJ);
        this.bnf.add(this.mpK);
        this.bnf.add(this.mpL);
        this.bnf.add(this.mpM);
        this.bnf.add(this.mpN);
        this.bnf.add(this.mpQ);
        this.bnf.add(this.mpR);
        this.bnf.add(this.mpS);
        this.bnf.add(this.mpO);
        this.bnf.add(this.mpP);
        bdTypeRecyclerView.addAdapters(this.bnf);
        Fo("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mpK.fzO = bdUniqueId;
        this.mpL.fzO = bdUniqueId;
        this.mpM.fzO = bdUniqueId;
        this.mpN.fzO = bdUniqueId;
        this.mpQ.fzO = bdUniqueId;
        this.mpR.fzO = bdUniqueId;
        this.mpS.fzO = bdUniqueId;
        this.mpO.fzO = bdUniqueId;
        this.mpP.fzO = bdUniqueId;
    }

    public void Iq(int i) {
        this.mpK.Is(i);
        this.mpL.Is(i);
        this.mpM.Is(i);
        this.mpN.Is(i);
        this.mpO.Is(i);
        this.mpP.Is(i);
        this.mpQ.Is(i);
        this.mpR.Is(i);
        this.mpS.Is(i);
    }

    public void Ir(int i) {
        this.mpK.Ir(i);
        this.mpL.Ir(i);
        this.mpM.Ir(i);
        this.mpN.Ir(i);
        this.mpO.Ir(i);
        this.mpP.Ir(i);
        this.mpQ.Ir(i);
        this.mpR.Ir(i);
        this.mpS.Ir(i);
    }

    public void setTabType(int i) {
        this.mpK.setTabType(i);
        this.mpL.setTabType(i);
        this.mpM.setTabType(i);
        this.mpN.setTabType(i);
        this.mpO.setTabType(i);
        this.mpP.setTabType(i);
        this.mpQ.setTabType(i);
        this.mpR.setTabType(i);
        this.mpS.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.mpJ.setIsHost(z);
        this.mpB.setIsHost(z);
        this.mpK.setIsHost(z);
        this.mpL.setIsHost(z);
        this.mpM.setIsHost(z);
        this.mpN.setIsHost(z);
        this.mpO.setIsHost(z);
        this.mpP.setIsHost(z);
        this.mpQ.setIsHost(z);
        this.mpR.setIsHost(z);
        this.mpS.setIsHost(z);
    }

    private void Fo(String str) {
        if (this.bnf != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Fo(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.iYU.getListAdapter() != null) {
            this.iYU.getListAdapter().notifyDataSetChanged();
        }
    }
}
