package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private BdTypeRecyclerView jmj;
    private BdUniqueId mBdUniqueId;
    private com.baidu.tieba.person.a.a msl;
    private com.baidu.tieba.personPolymeric.a.a.e mzA;
    private com.baidu.tieba.personPolymeric.a.a.f mzB;
    private m mzi;
    private b mzj;
    private i mzk;
    private a mzl;
    private c mzm;
    private h mzn;
    private e mzo;
    private k mzp;
    private d mzq;
    private com.baidu.tieba.person.a.d mzr;
    private p mzs;
    private com.baidu.tieba.personPolymeric.a.a.g mzt;
    private com.baidu.tieba.personPolymeric.a.a.d mzu;
    private com.baidu.tieba.personPolymeric.a.a.i mzv;
    private com.baidu.tieba.personPolymeric.a.a.h mzw;
    private com.baidu.tieba.personPolymeric.a.a.a mzx;
    private com.baidu.tieba.personPolymeric.a.a.c mzy;
    private com.baidu.tieba.personPolymeric.a.a.b mzz;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jmj = bdTypeRecyclerView;
        this.mzi = new m(tbPageContext);
        this.mzj = new b(tbPageContext);
        this.mzk = new i(tbPageContext);
        this.mzl = new a(tbPageContext);
        this.mzm = new c(tbPageContext);
        this.mzn = new h(tbPageContext, tbPageContext.getUniqueId());
        this.mzo = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.mBC);
        this.mzp = new k(tbPageContext);
        this.mzq = new d(tbPageContext);
        this.mzr = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.msm);
        this.msl = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.mrV);
        this.mzs = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mzt = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.mzu = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.eQI);
        this.mzv = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.eQK);
        this.mzw = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.eQP);
        this.mzz = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.eQR);
        this.mzA = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.eQQ);
        this.mzB = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.eQS);
        this.mzx = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.iAo);
        this.mzy = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.iAp);
        this.bns.add(this.mzi);
        this.bns.add(this.mzj);
        this.bns.add(this.mzk);
        this.bns.add(this.mzl);
        this.bns.add(this.mzm);
        this.bns.add(this.mzn);
        this.bns.add(this.mzo);
        this.bns.add(this.mzp);
        this.bns.add(this.mzq);
        this.bns.add(this.mzr);
        this.bns.add(this.msl);
        this.bns.add(this.mzs);
        this.bns.add(this.mzt);
        this.bns.add(this.mzu);
        this.bns.add(this.mzv);
        this.bns.add(this.mzw);
        this.bns.add(this.mzz);
        this.bns.add(this.mzA);
        this.bns.add(this.mzB);
        this.bns.add(this.mzx);
        this.bns.add(this.mzy);
        bdTypeRecyclerView.addAdapters(this.bns);
        Ey("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mzt.fGZ = bdUniqueId;
        this.mzu.fGZ = bdUniqueId;
        this.mzv.fGZ = bdUniqueId;
        this.mzw.fGZ = bdUniqueId;
        this.mzz.fGZ = bdUniqueId;
        this.mzA.fGZ = bdUniqueId;
        this.mzB.fGZ = bdUniqueId;
        this.mzx.fGZ = bdUniqueId;
        this.mzy.fGZ = bdUniqueId;
    }

    public void GV(int i) {
        this.mzt.GX(i);
        this.mzu.GX(i);
        this.mzv.GX(i);
        this.mzw.GX(i);
        this.mzx.GX(i);
        this.mzy.GX(i);
        this.mzz.GX(i);
        this.mzA.GX(i);
        this.mzB.GX(i);
    }

    public void GW(int i) {
        this.mzt.GW(i);
        this.mzu.GW(i);
        this.mzv.GW(i);
        this.mzw.GW(i);
        this.mzx.GW(i);
        this.mzy.GW(i);
        this.mzz.GW(i);
        this.mzA.GW(i);
        this.mzB.GW(i);
    }

    public void setTabType(int i) {
        this.mzt.setTabType(i);
        this.mzu.setTabType(i);
        this.mzv.setTabType(i);
        this.mzw.setTabType(i);
        this.mzx.setTabType(i);
        this.mzy.setTabType(i);
        this.mzz.setTabType(i);
        this.mzA.setTabType(i);
        this.mzB.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.mzs.setIsHost(z);
        this.mzk.setIsHost(z);
        this.mzt.setIsHost(z);
        this.mzu.setIsHost(z);
        this.mzv.setIsHost(z);
        this.mzw.setIsHost(z);
        this.mzx.setIsHost(z);
        this.mzy.setIsHost(z);
        this.mzz.setIsHost(z);
        this.mzA.setIsHost(z);
        this.mzB.setIsHost(z);
    }

    private void Ey(String str) {
        if (this.bns != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ey(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.jmj.getListAdapter() != null) {
            this.jmj.getListAdapter().notifyDataSetChanged();
        }
    }
}
