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
    private BdTypeRecyclerView iYW;
    private BdUniqueId mBdUniqueId;
    private com.baidu.tieba.person.a.a miG;
    private m mpB;
    private b mpC;
    private i mpD;
    private a mpE;
    private c mpF;
    private h mpG;
    private e mpH;
    private k mpI;
    private d mpJ;
    private com.baidu.tieba.person.a.d mpK;
    private p mpL;
    private com.baidu.tieba.personPolymeric.a.a.g mpM;
    private com.baidu.tieba.personPolymeric.a.a.d mpN;
    private com.baidu.tieba.personPolymeric.a.a.i mpO;
    private com.baidu.tieba.personPolymeric.a.a.h mpP;
    private com.baidu.tieba.personPolymeric.a.a.a mpQ;
    private com.baidu.tieba.personPolymeric.a.a.c mpR;
    private com.baidu.tieba.personPolymeric.a.a.b mpS;
    private com.baidu.tieba.personPolymeric.a.a.e mpT;
    private com.baidu.tieba.personPolymeric.a.a.f mpU;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iYW = bdTypeRecyclerView;
        this.mpB = new m(tbPageContext);
        this.mpC = new b(tbPageContext);
        this.mpD = new i(tbPageContext);
        this.mpE = new a(tbPageContext);
        this.mpF = new c(tbPageContext);
        this.mpG = new h(tbPageContext, tbPageContext.getUniqueId());
        this.mpH = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.mrT);
        this.mpI = new k(tbPageContext);
        this.mpJ = new d(tbPageContext);
        this.mpK = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.miH);
        this.miG = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.mir);
        this.mpL = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mpM = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.mpN = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.eJo);
        this.mpO = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.eJq);
        this.mpP = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.eJv);
        this.mpS = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.eJx);
        this.mpT = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.eJw);
        this.mpU = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.eJy);
        this.mpQ = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.imQ);
        this.mpR = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.imR);
        this.bnf.add(this.mpB);
        this.bnf.add(this.mpC);
        this.bnf.add(this.mpD);
        this.bnf.add(this.mpE);
        this.bnf.add(this.mpF);
        this.bnf.add(this.mpG);
        this.bnf.add(this.mpH);
        this.bnf.add(this.mpI);
        this.bnf.add(this.mpJ);
        this.bnf.add(this.mpK);
        this.bnf.add(this.miG);
        this.bnf.add(this.mpL);
        this.bnf.add(this.mpM);
        this.bnf.add(this.mpN);
        this.bnf.add(this.mpO);
        this.bnf.add(this.mpP);
        this.bnf.add(this.mpS);
        this.bnf.add(this.mpT);
        this.bnf.add(this.mpU);
        this.bnf.add(this.mpQ);
        this.bnf.add(this.mpR);
        bdTypeRecyclerView.addAdapters(this.bnf);
        Fo("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mpM.fzO = bdUniqueId;
        this.mpN.fzO = bdUniqueId;
        this.mpO.fzO = bdUniqueId;
        this.mpP.fzO = bdUniqueId;
        this.mpS.fzO = bdUniqueId;
        this.mpT.fzO = bdUniqueId;
        this.mpU.fzO = bdUniqueId;
        this.mpQ.fzO = bdUniqueId;
        this.mpR.fzO = bdUniqueId;
    }

    public void Iq(int i) {
        this.mpM.Is(i);
        this.mpN.Is(i);
        this.mpO.Is(i);
        this.mpP.Is(i);
        this.mpQ.Is(i);
        this.mpR.Is(i);
        this.mpS.Is(i);
        this.mpT.Is(i);
        this.mpU.Is(i);
    }

    public void Ir(int i) {
        this.mpM.Ir(i);
        this.mpN.Ir(i);
        this.mpO.Ir(i);
        this.mpP.Ir(i);
        this.mpQ.Ir(i);
        this.mpR.Ir(i);
        this.mpS.Ir(i);
        this.mpT.Ir(i);
        this.mpU.Ir(i);
    }

    public void setTabType(int i) {
        this.mpM.setTabType(i);
        this.mpN.setTabType(i);
        this.mpO.setTabType(i);
        this.mpP.setTabType(i);
        this.mpQ.setTabType(i);
        this.mpR.setTabType(i);
        this.mpS.setTabType(i);
        this.mpT.setTabType(i);
        this.mpU.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.mpL.setIsHost(z);
        this.mpD.setIsHost(z);
        this.mpM.setIsHost(z);
        this.mpN.setIsHost(z);
        this.mpO.setIsHost(z);
        this.mpP.setIsHost(z);
        this.mpQ.setIsHost(z);
        this.mpR.setIsHost(z);
        this.mpS.setIsHost(z);
        this.mpT.setIsHost(z);
        this.mpU.setIsHost(z);
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
        if (this.iYW.getListAdapter() != null) {
            this.iYW.getListAdapter().notifyDataSetChanged();
        }
    }
}
