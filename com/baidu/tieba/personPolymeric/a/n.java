package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private BdTypeRecyclerView hYQ;
    private com.baidu.tieba.person.a.a ldw;
    private com.baidu.tieba.personPolymeric.a.a.h lkA;
    private com.baidu.tieba.personPolymeric.a.a.a lkB;
    private com.baidu.tieba.personPolymeric.a.a.c lkC;
    private com.baidu.tieba.personPolymeric.a.a.b lkD;
    private com.baidu.tieba.personPolymeric.a.a.e lkE;
    private com.baidu.tieba.personPolymeric.a.a.f lkF;
    private m lkm;
    private b lkn;
    private i lko;
    private a lkp;
    private c lkq;
    private h lkr;
    private e lks;
    private k lkt;
    private d lku;
    private com.baidu.tieba.person.a.d lkv;
    private p lkw;
    private com.baidu.tieba.personPolymeric.a.a.g lkx;
    private com.baidu.tieba.personPolymeric.a.a.d lky;
    private com.baidu.tieba.personPolymeric.a.a.i lkz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hYQ = bdTypeRecyclerView;
        this.lkm = new m(tbPageContext);
        this.lkn = new b(tbPageContext);
        this.lko = new i(tbPageContext);
        this.lkp = new a(tbPageContext);
        this.lkq = new c(tbPageContext);
        this.lkr = new h(tbPageContext, tbPageContext.getUniqueId());
        this.lks = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.lmE);
        this.lkt = new k(tbPageContext);
        this.lku = new d(tbPageContext);
        this.lkv = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.ldx);
        this.ldw = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ldj);
        this.lkw = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.lkx = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.lky = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.l.ebm);
        this.lkz = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.m.ebo);
        this.lkA = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.l.ebs);
        this.lkD = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.l.ebu);
        this.lkE = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.l.ebt);
        this.lkF = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.l.ebv);
        this.lkB = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.f.hmE);
        this.lkC = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.g.hmF);
        this.bbu.add(this.lkm);
        this.bbu.add(this.lkn);
        this.bbu.add(this.lko);
        this.bbu.add(this.lkp);
        this.bbu.add(this.lkq);
        this.bbu.add(this.lkr);
        this.bbu.add(this.lks);
        this.bbu.add(this.lkt);
        this.bbu.add(this.lku);
        this.bbu.add(this.lkv);
        this.bbu.add(this.ldw);
        this.bbu.add(this.lkw);
        this.bbu.add(this.lkx);
        this.bbu.add(this.lky);
        this.bbu.add(this.lkz);
        this.bbu.add(this.lkA);
        this.bbu.add(this.lkD);
        this.bbu.add(this.lkE);
        this.bbu.add(this.lkF);
        this.bbu.add(this.lkB);
        this.bbu.add(this.lkC);
        bdTypeRecyclerView.addAdapters(this.bbu);
        Dj("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.lkx.ePv = bdUniqueId;
        this.lky.ePv = bdUniqueId;
        this.lkz.ePv = bdUniqueId;
        this.lkA.ePv = bdUniqueId;
        this.lkD.ePv = bdUniqueId;
        this.lkE.ePv = bdUniqueId;
        this.lkF.ePv = bdUniqueId;
        this.lkB.ePv = bdUniqueId;
        this.lkC.ePv = bdUniqueId;
    }

    public void Fo(int i) {
        this.lkx.Fq(i);
        this.lky.Fq(i);
        this.lkz.Fq(i);
        this.lkA.Fq(i);
        this.lkB.Fq(i);
        this.lkC.Fq(i);
        this.lkD.Fq(i);
        this.lkE.Fq(i);
        this.lkF.Fq(i);
    }

    public void Fp(int i) {
        this.lkx.Fp(i);
        this.lky.Fp(i);
        this.lkz.Fp(i);
        this.lkA.Fp(i);
        this.lkB.Fp(i);
        this.lkC.Fp(i);
        this.lkD.Fp(i);
        this.lkE.Fp(i);
        this.lkF.Fp(i);
    }

    public void setTabType(int i) {
        this.lkx.setTabType(i);
        this.lky.setTabType(i);
        this.lkz.setTabType(i);
        this.lkA.setTabType(i);
        this.lkB.setTabType(i);
        this.lkC.setTabType(i);
        this.lkD.setTabType(i);
        this.lkE.setTabType(i);
        this.lkF.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.lkw.setIsHost(z);
        this.lko.setIsHost(z);
        this.lkx.setIsHost(z);
        this.lky.setIsHost(z);
        this.lkz.setIsHost(z);
        this.lkA.setIsHost(z);
        this.lkB.setIsHost(z);
        this.lkC.setIsHost(z);
        this.lkD.setIsHost(z);
        this.lkE.setIsHost(z);
        this.lkF.setIsHost(z);
    }

    private void Dj(String str) {
        if (this.bbu != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Dj(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.hYQ.getListAdapter() != null) {
            this.hYQ.getListAdapter().notifyDataSetChanged();
        }
    }
}
