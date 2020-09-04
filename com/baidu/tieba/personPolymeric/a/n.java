package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private BdTypeRecyclerView hYW;
    private com.baidu.tieba.person.a.a ldD;
    private a lkA;
    private c lkB;
    private h lkC;
    private e lkD;
    private k lkE;
    private d lkF;
    private com.baidu.tieba.person.a.d lkG;
    private p lkH;
    private com.baidu.tieba.personPolymeric.a.a.g lkI;
    private com.baidu.tieba.personPolymeric.a.a.d lkJ;
    private com.baidu.tieba.personPolymeric.a.a.i lkK;
    private com.baidu.tieba.personPolymeric.a.a.h lkL;
    private com.baidu.tieba.personPolymeric.a.a.a lkM;
    private com.baidu.tieba.personPolymeric.a.a.c lkN;
    private com.baidu.tieba.personPolymeric.a.a.b lkO;
    private com.baidu.tieba.personPolymeric.a.a.e lkP;
    private com.baidu.tieba.personPolymeric.a.a.f lkQ;
    private m lkx;
    private b lky;
    private i lkz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hYW = bdTypeRecyclerView;
        this.lkx = new m(tbPageContext);
        this.lky = new b(tbPageContext);
        this.lkz = new i(tbPageContext);
        this.lkA = new a(tbPageContext);
        this.lkB = new c(tbPageContext);
        this.lkC = new h(tbPageContext, tbPageContext.getUniqueId());
        this.lkD = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.lmP);
        this.lkE = new k(tbPageContext);
        this.lkF = new d(tbPageContext);
        this.lkG = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.ldE);
        this.ldD = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ldq);
        this.lkH = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.lkI = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.lkJ = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.l.ebq);
        this.lkK = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.m.ebs);
        this.lkL = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.l.ebw);
        this.lkO = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.l.eby);
        this.lkP = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.l.ebx);
        this.lkQ = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.l.ebz);
        this.lkM = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.f.hmI);
        this.lkN = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.g.hmJ);
        this.bbw.add(this.lkx);
        this.bbw.add(this.lky);
        this.bbw.add(this.lkz);
        this.bbw.add(this.lkA);
        this.bbw.add(this.lkB);
        this.bbw.add(this.lkC);
        this.bbw.add(this.lkD);
        this.bbw.add(this.lkE);
        this.bbw.add(this.lkF);
        this.bbw.add(this.lkG);
        this.bbw.add(this.ldD);
        this.bbw.add(this.lkH);
        this.bbw.add(this.lkI);
        this.bbw.add(this.lkJ);
        this.bbw.add(this.lkK);
        this.bbw.add(this.lkL);
        this.bbw.add(this.lkO);
        this.bbw.add(this.lkP);
        this.bbw.add(this.lkQ);
        this.bbw.add(this.lkM);
        this.bbw.add(this.lkN);
        bdTypeRecyclerView.addAdapters(this.bbw);
        Dk("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.lkI.ePz = bdUniqueId;
        this.lkJ.ePz = bdUniqueId;
        this.lkK.ePz = bdUniqueId;
        this.lkL.ePz = bdUniqueId;
        this.lkO.ePz = bdUniqueId;
        this.lkP.ePz = bdUniqueId;
        this.lkQ.ePz = bdUniqueId;
        this.lkM.ePz = bdUniqueId;
        this.lkN.ePz = bdUniqueId;
    }

    public void Fo(int i) {
        this.lkI.Fq(i);
        this.lkJ.Fq(i);
        this.lkK.Fq(i);
        this.lkL.Fq(i);
        this.lkM.Fq(i);
        this.lkN.Fq(i);
        this.lkO.Fq(i);
        this.lkP.Fq(i);
        this.lkQ.Fq(i);
    }

    public void Fp(int i) {
        this.lkI.Fp(i);
        this.lkJ.Fp(i);
        this.lkK.Fp(i);
        this.lkL.Fp(i);
        this.lkM.Fp(i);
        this.lkN.Fp(i);
        this.lkO.Fp(i);
        this.lkP.Fp(i);
        this.lkQ.Fp(i);
    }

    public void setTabType(int i) {
        this.lkI.setTabType(i);
        this.lkJ.setTabType(i);
        this.lkK.setTabType(i);
        this.lkL.setTabType(i);
        this.lkM.setTabType(i);
        this.lkN.setTabType(i);
        this.lkO.setTabType(i);
        this.lkP.setTabType(i);
        this.lkQ.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.lkH.setIsHost(z);
        this.lkz.setIsHost(z);
        this.lkI.setIsHost(z);
        this.lkJ.setIsHost(z);
        this.lkK.setIsHost(z);
        this.lkL.setIsHost(z);
        this.lkM.setIsHost(z);
        this.lkN.setIsHost(z);
        this.lkO.setIsHost(z);
        this.lkP.setIsHost(z);
        this.lkQ.setIsHost(z);
    }

    private void Dk(String str) {
        if (this.bbw != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Dk(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.hYW.getListAdapter() != null) {
            this.hYW.getListAdapter().notifyDataSetChanged();
        }
    }
}
