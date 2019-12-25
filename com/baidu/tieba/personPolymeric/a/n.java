package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private BdTypeRecyclerView gnE;
    private com.baidu.tieba.person.a.a jbo;
    private m jhR;
    private b jhS;
    private i jhT;
    private a jhU;
    private c jhV;
    private h jhW;
    private e jhX;
    private k jhY;
    private d jhZ;
    private com.baidu.tieba.person.a.d jia;
    private p jib;
    private com.baidu.tieba.personPolymeric.a.a.g jic;
    private com.baidu.tieba.personPolymeric.a.a.d jie;
    private com.baidu.tieba.personPolymeric.a.a.i jif;
    private com.baidu.tieba.personPolymeric.a.a.h jig;
    private com.baidu.tieba.personPolymeric.a.a.a jih;
    private com.baidu.tieba.personPolymeric.a.a.c jii;
    private com.baidu.tieba.personPolymeric.a.a.b jij;
    private com.baidu.tieba.personPolymeric.a.a.e jik;
    private com.baidu.tieba.personPolymeric.a.a.f jil;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gnE = bdTypeRecyclerView;
        this.jhR = new m(tbPageContext);
        this.jhS = new b(tbPageContext);
        this.jhT = new i(tbPageContext);
        this.jhU = new a(tbPageContext);
        this.jhV = new c(tbPageContext);
        this.jhW = new h(tbPageContext, tbPageContext.getUniqueId());
        this.jhX = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.jkm);
        this.jhY = new k(tbPageContext);
        this.jhZ = new d(tbPageContext);
        this.jia = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.jbp);
        this.jbo = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jbb);
        this.jib = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.jic = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jie = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.cNj);
        this.jif = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.cNl);
        this.jig = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.cNp);
        this.jij = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.cNr);
        this.jik = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.cNq);
        this.jil = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.cNs);
        this.jih = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.fGR);
        this.jii = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.fGS);
        this.aoz.add(this.jhR);
        this.aoz.add(this.jhS);
        this.aoz.add(this.jhT);
        this.aoz.add(this.jhU);
        this.aoz.add(this.jhV);
        this.aoz.add(this.jhW);
        this.aoz.add(this.jhX);
        this.aoz.add(this.jhY);
        this.aoz.add(this.jhZ);
        this.aoz.add(this.jia);
        this.aoz.add(this.jbo);
        this.aoz.add(this.jib);
        this.aoz.add(this.jic);
        this.aoz.add(this.jie);
        this.aoz.add(this.jif);
        this.aoz.add(this.jig);
        this.aoz.add(this.jij);
        this.aoz.add(this.jik);
        this.aoz.add(this.jil);
        this.aoz.add(this.jih);
        this.aoz.add(this.jii);
        bdTypeRecyclerView.addAdapters(this.aoz);
        wq("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jic.dwY = bdUniqueId;
        this.jie.dwY = bdUniqueId;
        this.jif.dwY = bdUniqueId;
        this.jig.dwY = bdUniqueId;
        this.jij.dwY = bdUniqueId;
        this.jik.dwY = bdUniqueId;
        this.jil.dwY = bdUniqueId;
        this.jih.dwY = bdUniqueId;
        this.jii.dwY = bdUniqueId;
    }

    public void zJ(int i) {
        this.jic.zL(i);
        this.jie.zL(i);
        this.jif.zL(i);
        this.jig.zL(i);
        this.jih.zL(i);
        this.jii.zL(i);
        this.jij.zL(i);
        this.jik.zL(i);
        this.jil.zL(i);
    }

    public void zK(int i) {
        this.jic.zK(i);
        this.jie.zK(i);
        this.jif.zK(i);
        this.jig.zK(i);
        this.jih.zK(i);
        this.jii.zK(i);
        this.jij.zK(i);
        this.jik.zK(i);
        this.jil.zK(i);
    }

    public void setTabType(int i) {
        this.jic.setTabType(i);
        this.jie.setTabType(i);
        this.jif.setTabType(i);
        this.jig.setTabType(i);
        this.jih.setTabType(i);
        this.jii.setTabType(i);
        this.jij.setTabType(i);
        this.jik.setTabType(i);
        this.jil.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.jib.setIsHost(z);
        this.jhT.setIsHost(z);
        this.jic.setIsHost(z);
        this.jie.setIsHost(z);
        this.jif.setIsHost(z);
        this.jig.setIsHost(z);
        this.jih.setIsHost(z);
        this.jii.setIsHost(z);
        this.jij.setIsHost(z);
        this.jik.setIsHost(z);
        this.jil.setIsHost(z);
    }

    private void wq(String str) {
        if (this.aoz != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wq(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gnE.getListAdapter() != null) {
            this.gnE.getListAdapter().notifyDataSetChanged();
        }
    }
}
