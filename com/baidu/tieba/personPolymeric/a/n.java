package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private BdTypeRecyclerView jgC;
    private BdUniqueId mBdUniqueId;
    private com.baidu.tieba.person.a.a mjj;
    private com.baidu.tieba.personPolymeric.a.a.e mqA;
    private com.baidu.tieba.personPolymeric.a.a.f mqB;
    private m mqi;
    private b mqj;
    private i mqk;
    private a mql;
    private c mqm;
    private h mqn;
    private e mqo;
    private k mqp;
    private d mqq;
    private com.baidu.tieba.person.a.d mqr;
    private p mqs;
    private com.baidu.tieba.personPolymeric.a.a.g mqt;
    private com.baidu.tieba.personPolymeric.a.a.d mqu;
    private com.baidu.tieba.personPolymeric.a.a.i mqv;
    private com.baidu.tieba.personPolymeric.a.a.h mqw;
    private com.baidu.tieba.personPolymeric.a.a.a mqx;
    private com.baidu.tieba.personPolymeric.a.a.c mqy;
    private com.baidu.tieba.personPolymeric.a.a.b mqz;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jgC = bdTypeRecyclerView;
        this.mqi = new m(tbPageContext);
        this.mqj = new b(tbPageContext);
        this.mqk = new i(tbPageContext);
        this.mql = new a(tbPageContext);
        this.mqm = new c(tbPageContext);
        this.mqn = new h(tbPageContext, tbPageContext.getUniqueId());
        this.mqo = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.msC);
        this.mqp = new k(tbPageContext);
        this.mqq = new d(tbPageContext);
        this.mqr = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.mjk);
        this.mjj = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.miU);
        this.mqs = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mqt = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.mqu = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.eOw);
        this.mqv = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.eOy);
        this.mqw = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.eOD);
        this.mqz = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.eOF);
        this.mqA = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.eOE);
        this.mqB = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.eOG);
        this.mqx = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.iuE);
        this.mqy = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.iuF);
        this.bjZ.add(this.mqi);
        this.bjZ.add(this.mqj);
        this.bjZ.add(this.mqk);
        this.bjZ.add(this.mql);
        this.bjZ.add(this.mqm);
        this.bjZ.add(this.mqn);
        this.bjZ.add(this.mqo);
        this.bjZ.add(this.mqp);
        this.bjZ.add(this.mqq);
        this.bjZ.add(this.mqr);
        this.bjZ.add(this.mjj);
        this.bjZ.add(this.mqs);
        this.bjZ.add(this.mqt);
        this.bjZ.add(this.mqu);
        this.bjZ.add(this.mqv);
        this.bjZ.add(this.mqw);
        this.bjZ.add(this.mqz);
        this.bjZ.add(this.mqA);
        this.bjZ.add(this.mqB);
        this.bjZ.add(this.mqx);
        this.bjZ.add(this.mqy);
        bdTypeRecyclerView.addAdapters(this.bjZ);
        Ea("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mqt.fEN = bdUniqueId;
        this.mqu.fEN = bdUniqueId;
        this.mqv.fEN = bdUniqueId;
        this.mqw.fEN = bdUniqueId;
        this.mqz.fEN = bdUniqueId;
        this.mqA.fEN = bdUniqueId;
        this.mqB.fEN = bdUniqueId;
        this.mqx.fEN = bdUniqueId;
        this.mqy.fEN = bdUniqueId;
    }

    public void GD(int i) {
        this.mqt.GF(i);
        this.mqu.GF(i);
        this.mqv.GF(i);
        this.mqw.GF(i);
        this.mqx.GF(i);
        this.mqy.GF(i);
        this.mqz.GF(i);
        this.mqA.GF(i);
        this.mqB.GF(i);
    }

    public void GE(int i) {
        this.mqt.GE(i);
        this.mqu.GE(i);
        this.mqv.GE(i);
        this.mqw.GE(i);
        this.mqx.GE(i);
        this.mqy.GE(i);
        this.mqz.GE(i);
        this.mqA.GE(i);
        this.mqB.GE(i);
    }

    public void setTabType(int i) {
        this.mqt.setTabType(i);
        this.mqu.setTabType(i);
        this.mqv.setTabType(i);
        this.mqw.setTabType(i);
        this.mqx.setTabType(i);
        this.mqy.setTabType(i);
        this.mqz.setTabType(i);
        this.mqA.setTabType(i);
        this.mqB.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.mqs.setIsHost(z);
        this.mqk.setIsHost(z);
        this.mqt.setIsHost(z);
        this.mqu.setIsHost(z);
        this.mqv.setIsHost(z);
        this.mqw.setIsHost(z);
        this.mqx.setIsHost(z);
        this.mqy.setIsHost(z);
        this.mqz.setIsHost(z);
        this.mqA.setIsHost(z);
        this.mqB.setIsHost(z);
    }

    private void Ea(String str) {
        if (this.bjZ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ea(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.jgC.getListAdapter() != null) {
            this.jgC.getListAdapter().notifyDataSetChanged();
        }
    }
}
