package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private BdTypeRecyclerView iuX;
    private com.baidu.tieba.person.a.a lBM;
    private m lIG;
    private b lIH;
    private i lII;
    private a lIJ;
    private c lIK;
    private h lIL;
    private e lIM;
    private k lIN;
    private d lIO;
    private com.baidu.tieba.person.a.d lIP;
    private p lIQ;
    private com.baidu.tieba.personPolymeric.a.a.g lIR;
    private com.baidu.tieba.personPolymeric.a.a.d lIS;
    private com.baidu.tieba.personPolymeric.a.a.i lIT;
    private com.baidu.tieba.personPolymeric.a.a.h lIU;
    private com.baidu.tieba.personPolymeric.a.a.a lIV;
    private com.baidu.tieba.personPolymeric.a.a.c lIW;
    private com.baidu.tieba.personPolymeric.a.a.b lIX;
    private com.baidu.tieba.personPolymeric.a.a.e lIY;
    private com.baidu.tieba.personPolymeric.a.a.f lIZ;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iuX = bdTypeRecyclerView;
        this.lIG = new m(tbPageContext);
        this.lIH = new b(tbPageContext);
        this.lII = new i(tbPageContext);
        this.lIJ = new a(tbPageContext);
        this.lIK = new c(tbPageContext);
        this.lIL = new h(tbPageContext, tbPageContext.getUniqueId());
        this.lIM = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.lKY);
        this.lIN = new k(tbPageContext);
        this.lIO = new d(tbPageContext);
        this.lIP = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.lBN);
        this.lBM = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.lBz);
        this.lIQ = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.lIR = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.lIS = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.l.epF);
        this.lIT = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.m.epH);
        this.lIU = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.l.epL);
        this.lIX = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.l.epN);
        this.lIY = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.l.epM);
        this.lIZ = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.l.epO);
        this.lIV = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.f.hIF);
        this.lIW = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.g.hIG);
        this.bhH.add(this.lIG);
        this.bhH.add(this.lIH);
        this.bhH.add(this.lII);
        this.bhH.add(this.lIJ);
        this.bhH.add(this.lIK);
        this.bhH.add(this.lIL);
        this.bhH.add(this.lIM);
        this.bhH.add(this.lIN);
        this.bhH.add(this.lIO);
        this.bhH.add(this.lIP);
        this.bhH.add(this.lBM);
        this.bhH.add(this.lIQ);
        this.bhH.add(this.lIR);
        this.bhH.add(this.lIS);
        this.bhH.add(this.lIT);
        this.bhH.add(this.lIU);
        this.bhH.add(this.lIX);
        this.bhH.add(this.lIY);
        this.bhH.add(this.lIZ);
        this.bhH.add(this.lIV);
        this.bhH.add(this.lIW);
        bdTypeRecyclerView.addAdapters(this.bhH);
        Es("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.lIR.fey = bdUniqueId;
        this.lIS.fey = bdUniqueId;
        this.lIT.fey = bdUniqueId;
        this.lIU.fey = bdUniqueId;
        this.lIX.fey = bdUniqueId;
        this.lIY.fey = bdUniqueId;
        this.lIZ.fey = bdUniqueId;
        this.lIV.fey = bdUniqueId;
        this.lIW.fey = bdUniqueId;
    }

    public void Gv(int i) {
        this.lIR.Gx(i);
        this.lIS.Gx(i);
        this.lIT.Gx(i);
        this.lIU.Gx(i);
        this.lIV.Gx(i);
        this.lIW.Gx(i);
        this.lIX.Gx(i);
        this.lIY.Gx(i);
        this.lIZ.Gx(i);
    }

    public void Gw(int i) {
        this.lIR.Gw(i);
        this.lIS.Gw(i);
        this.lIT.Gw(i);
        this.lIU.Gw(i);
        this.lIV.Gw(i);
        this.lIW.Gw(i);
        this.lIX.Gw(i);
        this.lIY.Gw(i);
        this.lIZ.Gw(i);
    }

    public void setTabType(int i) {
        this.lIR.setTabType(i);
        this.lIS.setTabType(i);
        this.lIT.setTabType(i);
        this.lIU.setTabType(i);
        this.lIV.setTabType(i);
        this.lIW.setTabType(i);
        this.lIX.setTabType(i);
        this.lIY.setTabType(i);
        this.lIZ.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.lIQ.setIsHost(z);
        this.lII.setIsHost(z);
        this.lIR.setIsHost(z);
        this.lIS.setIsHost(z);
        this.lIT.setIsHost(z);
        this.lIU.setIsHost(z);
        this.lIV.setIsHost(z);
        this.lIW.setIsHost(z);
        this.lIX.setIsHost(z);
        this.lIY.setIsHost(z);
        this.lIZ.setIsHost(z);
    }

    private void Es(String str) {
        if (this.bhH != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Es(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.iuX.getListAdapter() != null) {
            this.iuX.getListAdapter().notifyDataSetChanged();
        }
    }
}
