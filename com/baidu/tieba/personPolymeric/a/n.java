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
    private com.baidu.tieba.person.a.a mnO;
    private m muO;
    private b muP;
    private i muQ;
    private a muR;
    private c muS;
    private h muT;
    private e muU;
    private k muV;
    private d muW;
    private com.baidu.tieba.person.a.d muX;
    private p muY;
    private com.baidu.tieba.personPolymeric.a.a.g muZ;
    private com.baidu.tieba.personPolymeric.a.a.d mva;
    private com.baidu.tieba.personPolymeric.a.a.i mvb;
    private com.baidu.tieba.personPolymeric.a.a.h mvc;
    private com.baidu.tieba.personPolymeric.a.a.a mvd;
    private com.baidu.tieba.personPolymeric.a.a.c mve;
    private com.baidu.tieba.personPolymeric.a.a.b mvf;
    private com.baidu.tieba.personPolymeric.a.a.e mvg;
    private com.baidu.tieba.personPolymeric.a.a.f mvh;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jlj = bdTypeRecyclerView;
        this.muO = new m(tbPageContext);
        this.muP = new b(tbPageContext);
        this.muQ = new i(tbPageContext);
        this.muR = new a(tbPageContext);
        this.muS = new c(tbPageContext);
        this.muT = new h(tbPageContext, tbPageContext.getUniqueId());
        this.muU = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.mxh);
        this.muV = new k(tbPageContext);
        this.muW = new d(tbPageContext);
        this.muX = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.mnP);
        this.mnO = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.mnz);
        this.muY = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.muZ = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.mva = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.eTh);
        this.mvb = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.eTj);
        this.mvc = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.eTo);
        this.mvf = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.eTq);
        this.mvg = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.eTp);
        this.mvh = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.eTr);
        this.mvd = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.izl);
        this.mve = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.izm);
        this.boM.add(this.muO);
        this.boM.add(this.muP);
        this.boM.add(this.muQ);
        this.boM.add(this.muR);
        this.boM.add(this.muS);
        this.boM.add(this.muT);
        this.boM.add(this.muU);
        this.boM.add(this.muV);
        this.boM.add(this.muW);
        this.boM.add(this.muX);
        this.boM.add(this.mnO);
        this.boM.add(this.muY);
        this.boM.add(this.muZ);
        this.boM.add(this.mva);
        this.boM.add(this.mvb);
        this.boM.add(this.mvc);
        this.boM.add(this.mvf);
        this.boM.add(this.mvg);
        this.boM.add(this.mvh);
        this.boM.add(this.mvd);
        this.boM.add(this.mve);
        bdTypeRecyclerView.addAdapters(this.boM);
        Fm("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.muZ.fJu = bdUniqueId;
        this.mva.fJu = bdUniqueId;
        this.mvb.fJu = bdUniqueId;
        this.mvc.fJu = bdUniqueId;
        this.mvf.fJu = bdUniqueId;
        this.mvg.fJu = bdUniqueId;
        this.mvh.fJu = bdUniqueId;
        this.mvd.fJu = bdUniqueId;
        this.mve.fJu = bdUniqueId;
    }

    public void Ik(int i) {
        this.muZ.Im(i);
        this.mva.Im(i);
        this.mvb.Im(i);
        this.mvc.Im(i);
        this.mvd.Im(i);
        this.mve.Im(i);
        this.mvf.Im(i);
        this.mvg.Im(i);
        this.mvh.Im(i);
    }

    public void Il(int i) {
        this.muZ.Il(i);
        this.mva.Il(i);
        this.mvb.Il(i);
        this.mvc.Il(i);
        this.mvd.Il(i);
        this.mve.Il(i);
        this.mvf.Il(i);
        this.mvg.Il(i);
        this.mvh.Il(i);
    }

    public void setTabType(int i) {
        this.muZ.setTabType(i);
        this.mva.setTabType(i);
        this.mvb.setTabType(i);
        this.mvc.setTabType(i);
        this.mvd.setTabType(i);
        this.mve.setTabType(i);
        this.mvf.setTabType(i);
        this.mvg.setTabType(i);
        this.mvh.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.muY.setIsHost(z);
        this.muQ.setIsHost(z);
        this.muZ.setIsHost(z);
        this.mva.setIsHost(z);
        this.mvb.setIsHost(z);
        this.mvc.setIsHost(z);
        this.mvd.setIsHost(z);
        this.mve.setIsHost(z);
        this.mvf.setIsHost(z);
        this.mvg.setIsHost(z);
        this.mvh.setIsHost(z);
    }

    private void Fm(String str) {
        if (this.boM != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Fm(str);
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
