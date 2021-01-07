package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private BdTypeRecyclerView jlj;
    private BdUniqueId mBdUniqueId;
    private com.baidu.tieba.person.a.a mnN;
    private m muN;
    private b muO;
    private i muP;
    private a muQ;
    private c muR;
    private h muS;
    private e muT;
    private k muU;
    private d muV;
    private com.baidu.tieba.person.a.d muW;
    private p muX;
    private com.baidu.tieba.personPolymeric.a.a.g muY;
    private com.baidu.tieba.personPolymeric.a.a.d muZ;
    private com.baidu.tieba.personPolymeric.a.a.i mva;
    private com.baidu.tieba.personPolymeric.a.a.h mvb;
    private com.baidu.tieba.personPolymeric.a.a.a mvc;
    private com.baidu.tieba.personPolymeric.a.a.c mvd;
    private com.baidu.tieba.personPolymeric.a.a.b mve;
    private com.baidu.tieba.personPolymeric.a.a.e mvf;
    private com.baidu.tieba.personPolymeric.a.a.f mvg;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jlj = bdTypeRecyclerView;
        this.muN = new m(tbPageContext);
        this.muO = new b(tbPageContext);
        this.muP = new i(tbPageContext);
        this.muQ = new a(tbPageContext);
        this.muR = new c(tbPageContext);
        this.muS = new h(tbPageContext, tbPageContext.getUniqueId());
        this.muT = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.mxg);
        this.muU = new k(tbPageContext);
        this.muV = new d(tbPageContext);
        this.muW = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.mnO);
        this.mnN = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.mny);
        this.muX = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.muY = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.muZ = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.eTh);
        this.mva = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.eTj);
        this.mvb = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.eTo);
        this.mve = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.eTq);
        this.mvf = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.eTp);
        this.mvg = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.eTr);
        this.mvc = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.izl);
        this.mvd = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.izm);
        this.boM.add(this.muN);
        this.boM.add(this.muO);
        this.boM.add(this.muP);
        this.boM.add(this.muQ);
        this.boM.add(this.muR);
        this.boM.add(this.muS);
        this.boM.add(this.muT);
        this.boM.add(this.muU);
        this.boM.add(this.muV);
        this.boM.add(this.muW);
        this.boM.add(this.mnN);
        this.boM.add(this.muX);
        this.boM.add(this.muY);
        this.boM.add(this.muZ);
        this.boM.add(this.mva);
        this.boM.add(this.mvb);
        this.boM.add(this.mve);
        this.boM.add(this.mvf);
        this.boM.add(this.mvg);
        this.boM.add(this.mvc);
        this.boM.add(this.mvd);
        bdTypeRecyclerView.addAdapters(this.boM);
        Fl("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.muY.fJu = bdUniqueId;
        this.muZ.fJu = bdUniqueId;
        this.mva.fJu = bdUniqueId;
        this.mvb.fJu = bdUniqueId;
        this.mve.fJu = bdUniqueId;
        this.mvf.fJu = bdUniqueId;
        this.mvg.fJu = bdUniqueId;
        this.mvc.fJu = bdUniqueId;
        this.mvd.fJu = bdUniqueId;
    }

    public void Ik(int i) {
        this.muY.Im(i);
        this.muZ.Im(i);
        this.mva.Im(i);
        this.mvb.Im(i);
        this.mvc.Im(i);
        this.mvd.Im(i);
        this.mve.Im(i);
        this.mvf.Im(i);
        this.mvg.Im(i);
    }

    public void Il(int i) {
        this.muY.Il(i);
        this.muZ.Il(i);
        this.mva.Il(i);
        this.mvb.Il(i);
        this.mvc.Il(i);
        this.mvd.Il(i);
        this.mve.Il(i);
        this.mvf.Il(i);
        this.mvg.Il(i);
    }

    public void setTabType(int i) {
        this.muY.setTabType(i);
        this.muZ.setTabType(i);
        this.mva.setTabType(i);
        this.mvb.setTabType(i);
        this.mvc.setTabType(i);
        this.mvd.setTabType(i);
        this.mve.setTabType(i);
        this.mvf.setTabType(i);
        this.mvg.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.muX.setIsHost(z);
        this.muP.setIsHost(z);
        this.muY.setIsHost(z);
        this.muZ.setIsHost(z);
        this.mva.setIsHost(z);
        this.mvb.setIsHost(z);
        this.mvc.setIsHost(z);
        this.mvd.setIsHost(z);
        this.mve.setIsHost(z);
        this.mvf.setIsHost(z);
        this.mvg.setIsHost(z);
    }

    private void Fl(String str) {
        if (this.boM != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Fl(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.jlj.getListAdapter() != null) {
            this.jlj.getListAdapter().notifyDataSetChanged();
        }
    }
}
