package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private BdTypeRecyclerView iHt;
    private com.baidu.tieba.person.a.a lOj;
    private m lVc;
    private b lVd;
    private i lVe;
    private a lVf;
    private c lVg;
    private h lVh;
    private e lVi;
    private k lVj;
    private d lVk;
    private com.baidu.tieba.person.a.d lVl;
    private p lVm;
    private com.baidu.tieba.personPolymeric.a.a.g lVn;
    private com.baidu.tieba.personPolymeric.a.a.d lVo;
    private com.baidu.tieba.personPolymeric.a.a.i lVp;
    private com.baidu.tieba.personPolymeric.a.a.h lVq;
    private com.baidu.tieba.personPolymeric.a.a.a lVr;
    private com.baidu.tieba.personPolymeric.a.a.c lVs;
    private com.baidu.tieba.personPolymeric.a.a.b lVt;
    private com.baidu.tieba.personPolymeric.a.a.e lVu;
    private com.baidu.tieba.personPolymeric.a.a.f lVv;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iHt = bdTypeRecyclerView;
        this.lVc = new m(tbPageContext);
        this.lVd = new b(tbPageContext);
        this.lVe = new i(tbPageContext);
        this.lVf = new a(tbPageContext);
        this.lVg = new c(tbPageContext);
        this.lVh = new h(tbPageContext, tbPageContext.getUniqueId());
        this.lVi = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.lXu);
        this.lVj = new k(tbPageContext);
        this.lVk = new d(tbPageContext);
        this.lVl = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.lOk);
        this.lOj = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.lNW);
        this.lVm = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.lVn = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.lVo = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.l.eyd);
        this.lVp = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.m.eyg);
        this.lVq = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.l.eyl);
        this.lVt = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.l.eyo);
        this.lVu = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.l.eyn);
        this.lVv = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.l.eyp);
        this.lVr = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.f.hVc);
        this.lVs = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.g.hVd);
        this.bje.add(this.lVc);
        this.bje.add(this.lVd);
        this.bje.add(this.lVe);
        this.bje.add(this.lVf);
        this.bje.add(this.lVg);
        this.bje.add(this.lVh);
        this.bje.add(this.lVi);
        this.bje.add(this.lVj);
        this.bje.add(this.lVk);
        this.bje.add(this.lVl);
        this.bje.add(this.lOj);
        this.bje.add(this.lVm);
        this.bje.add(this.lVn);
        this.bje.add(this.lVo);
        this.bje.add(this.lVp);
        this.bje.add(this.lVq);
        this.bje.add(this.lVt);
        this.bje.add(this.lVu);
        this.bje.add(this.lVv);
        this.bje.add(this.lVr);
        this.bje.add(this.lVs);
        bdTypeRecyclerView.addAdapters(this.bje);
        EL("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.lVn.fmX = bdUniqueId;
        this.lVo.fmX = bdUniqueId;
        this.lVp.fmX = bdUniqueId;
        this.lVq.fmX = bdUniqueId;
        this.lVt.fmX = bdUniqueId;
        this.lVu.fmX = bdUniqueId;
        this.lVv.fmX = bdUniqueId;
        this.lVr.fmX = bdUniqueId;
        this.lVs.fmX = bdUniqueId;
    }

    public void GO(int i) {
        this.lVn.GQ(i);
        this.lVo.GQ(i);
        this.lVp.GQ(i);
        this.lVq.GQ(i);
        this.lVr.GQ(i);
        this.lVs.GQ(i);
        this.lVt.GQ(i);
        this.lVu.GQ(i);
        this.lVv.GQ(i);
    }

    public void GP(int i) {
        this.lVn.GP(i);
        this.lVo.GP(i);
        this.lVp.GP(i);
        this.lVq.GP(i);
        this.lVr.GP(i);
        this.lVs.GP(i);
        this.lVt.GP(i);
        this.lVu.GP(i);
        this.lVv.GP(i);
    }

    public void setTabType(int i) {
        this.lVn.setTabType(i);
        this.lVo.setTabType(i);
        this.lVp.setTabType(i);
        this.lVq.setTabType(i);
        this.lVr.setTabType(i);
        this.lVs.setTabType(i);
        this.lVt.setTabType(i);
        this.lVu.setTabType(i);
        this.lVv.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.lVm.setIsHost(z);
        this.lVe.setIsHost(z);
        this.lVn.setIsHost(z);
        this.lVo.setIsHost(z);
        this.lVp.setIsHost(z);
        this.lVq.setIsHost(z);
        this.lVr.setIsHost(z);
        this.lVs.setIsHost(z);
        this.lVt.setIsHost(z);
        this.lVu.setIsHost(z);
        this.lVv.setIsHost(z);
    }

    private void EL(String str) {
        if (this.bje != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).EL(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.iHt.getListAdapter() != null) {
            this.iHt.getListAdapter().notifyDataSetChanged();
        }
    }
}
