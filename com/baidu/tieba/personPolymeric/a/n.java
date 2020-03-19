package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private BdTypeRecyclerView gtH;
    private com.baidu.tieba.person.a.a jhF;
    private m jof;
    private b jog;
    private i joh;
    private a joi;
    private c joj;
    private h jok;
    private e jol;
    private k jom;
    private d jon;
    private com.baidu.tieba.person.a.d joo;
    private p jop;
    private com.baidu.tieba.personPolymeric.a.a.g joq;
    private com.baidu.tieba.personPolymeric.a.a.d jor;
    private com.baidu.tieba.personPolymeric.a.a.i jos;
    private com.baidu.tieba.personPolymeric.a.a.h jot;
    private com.baidu.tieba.personPolymeric.a.a.a jou;
    private com.baidu.tieba.personPolymeric.a.a.c jov;
    private com.baidu.tieba.personPolymeric.a.a.b jow;
    private com.baidu.tieba.personPolymeric.a.a.e jox;
    private com.baidu.tieba.personPolymeric.a.a.f joy;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gtH = bdTypeRecyclerView;
        this.jof = new m(tbPageContext);
        this.jog = new b(tbPageContext);
        this.joh = new i(tbPageContext);
        this.joi = new a(tbPageContext);
        this.joj = new c(tbPageContext);
        this.jok = new h(tbPageContext, tbPageContext.getUniqueId());
        this.jol = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.jqA);
        this.jom = new k(tbPageContext);
        this.jon = new d(tbPageContext);
        this.joo = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.jhG);
        this.jhF = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jhs);
        this.jop = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.joq = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jor = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.cRL);
        this.jos = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.cRN);
        this.jot = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.cRR);
        this.jow = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.cRT);
        this.jox = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.cRS);
        this.joy = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.cRU);
        this.jou = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.fNu);
        this.jov = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.fNv);
        this.asP.add(this.jof);
        this.asP.add(this.jog);
        this.asP.add(this.joh);
        this.asP.add(this.joi);
        this.asP.add(this.joj);
        this.asP.add(this.jok);
        this.asP.add(this.jol);
        this.asP.add(this.jom);
        this.asP.add(this.jon);
        this.asP.add(this.joo);
        this.asP.add(this.jhF);
        this.asP.add(this.jop);
        this.asP.add(this.joq);
        this.asP.add(this.jor);
        this.asP.add(this.jos);
        this.asP.add(this.jot);
        this.asP.add(this.jow);
        this.asP.add(this.jox);
        this.asP.add(this.joy);
        this.asP.add(this.jou);
        this.asP.add(this.jov);
        bdTypeRecyclerView.addAdapters(this.asP);
        wQ("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.joq.dBK = bdUniqueId;
        this.jor.dBK = bdUniqueId;
        this.jos.dBK = bdUniqueId;
        this.jot.dBK = bdUniqueId;
        this.jow.dBK = bdUniqueId;
        this.jox.dBK = bdUniqueId;
        this.joy.dBK = bdUniqueId;
        this.jou.dBK = bdUniqueId;
        this.jov.dBK = bdUniqueId;
    }

    public void Ad(int i) {
        this.joq.Af(i);
        this.jor.Af(i);
        this.jos.Af(i);
        this.jot.Af(i);
        this.jou.Af(i);
        this.jov.Af(i);
        this.jow.Af(i);
        this.jox.Af(i);
        this.joy.Af(i);
    }

    public void Ae(int i) {
        this.joq.Ae(i);
        this.jor.Ae(i);
        this.jos.Ae(i);
        this.jot.Ae(i);
        this.jou.Ae(i);
        this.jov.Ae(i);
        this.jow.Ae(i);
        this.jox.Ae(i);
        this.joy.Ae(i);
    }

    public void setTabType(int i) {
        this.joq.setTabType(i);
        this.jor.setTabType(i);
        this.jos.setTabType(i);
        this.jot.setTabType(i);
        this.jou.setTabType(i);
        this.jov.setTabType(i);
        this.jow.setTabType(i);
        this.jox.setTabType(i);
        this.joy.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.jop.setIsHost(z);
        this.joh.setIsHost(z);
        this.joq.setIsHost(z);
        this.jor.setIsHost(z);
        this.jos.setIsHost(z);
        this.jot.setIsHost(z);
        this.jou.setIsHost(z);
        this.jov.setIsHost(z);
        this.jow.setIsHost(z);
        this.jox.setIsHost(z);
        this.joy.setIsHost(z);
    }

    private void wQ(String str) {
        if (this.asP != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wQ(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gtH.getListAdapter() != null) {
            this.gtH.getListAdapter().notifyDataSetChanged();
        }
    }
}
