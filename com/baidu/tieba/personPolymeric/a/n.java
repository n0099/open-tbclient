package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private BdTypeRecyclerView iga;
    private com.baidu.tieba.person.a.a lmu;
    private e ltA;
    private k ltB;
    private d ltC;
    private com.baidu.tieba.person.a.d ltD;
    private p ltE;
    private com.baidu.tieba.personPolymeric.a.a.g ltF;
    private com.baidu.tieba.personPolymeric.a.a.d ltG;
    private com.baidu.tieba.personPolymeric.a.a.i ltH;
    private com.baidu.tieba.personPolymeric.a.a.h ltI;
    private com.baidu.tieba.personPolymeric.a.a.a ltJ;
    private com.baidu.tieba.personPolymeric.a.a.c ltK;
    private com.baidu.tieba.personPolymeric.a.a.b ltL;
    private com.baidu.tieba.personPolymeric.a.a.e ltM;
    private com.baidu.tieba.personPolymeric.a.a.f ltN;
    private m ltu;
    private b ltv;
    private i ltw;
    private a ltx;
    private c lty;
    private h ltz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iga = bdTypeRecyclerView;
        this.ltu = new m(tbPageContext);
        this.ltv = new b(tbPageContext);
        this.ltw = new i(tbPageContext);
        this.ltx = new a(tbPageContext);
        this.lty = new c(tbPageContext);
        this.ltz = new h(tbPageContext, tbPageContext.getUniqueId());
        this.ltA = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.lvM);
        this.ltB = new k(tbPageContext);
        this.ltC = new d(tbPageContext);
        this.ltD = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.lmv);
        this.lmu = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.lmh);
        this.ltE = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.ltF = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.ltG = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.l.edA);
        this.ltH = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.m.edC);
        this.ltI = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.l.edG);
        this.ltL = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.l.edI);
        this.ltM = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.l.edH);
        this.ltN = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.l.edJ);
        this.ltJ = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.f.htL);
        this.ltK = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.g.htM);
        this.bdV.add(this.ltu);
        this.bdV.add(this.ltv);
        this.bdV.add(this.ltw);
        this.bdV.add(this.ltx);
        this.bdV.add(this.lty);
        this.bdV.add(this.ltz);
        this.bdV.add(this.ltA);
        this.bdV.add(this.ltB);
        this.bdV.add(this.ltC);
        this.bdV.add(this.ltD);
        this.bdV.add(this.lmu);
        this.bdV.add(this.ltE);
        this.bdV.add(this.ltF);
        this.bdV.add(this.ltG);
        this.bdV.add(this.ltH);
        this.bdV.add(this.ltI);
        this.bdV.add(this.ltL);
        this.bdV.add(this.ltM);
        this.bdV.add(this.ltN);
        this.bdV.add(this.ltJ);
        this.bdV.add(this.ltK);
        bdTypeRecyclerView.addAdapters(this.bdV);
        DH("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ltF.eSq = bdUniqueId;
        this.ltG.eSq = bdUniqueId;
        this.ltH.eSq = bdUniqueId;
        this.ltI.eSq = bdUniqueId;
        this.ltL.eSq = bdUniqueId;
        this.ltM.eSq = bdUniqueId;
        this.ltN.eSq = bdUniqueId;
        this.ltJ.eSq = bdUniqueId;
        this.ltK.eSq = bdUniqueId;
    }

    public void FP(int i) {
        this.ltF.FR(i);
        this.ltG.FR(i);
        this.ltH.FR(i);
        this.ltI.FR(i);
        this.ltJ.FR(i);
        this.ltK.FR(i);
        this.ltL.FR(i);
        this.ltM.FR(i);
        this.ltN.FR(i);
    }

    public void FQ(int i) {
        this.ltF.FQ(i);
        this.ltG.FQ(i);
        this.ltH.FQ(i);
        this.ltI.FQ(i);
        this.ltJ.FQ(i);
        this.ltK.FQ(i);
        this.ltL.FQ(i);
        this.ltM.FQ(i);
        this.ltN.FQ(i);
    }

    public void setTabType(int i) {
        this.ltF.setTabType(i);
        this.ltG.setTabType(i);
        this.ltH.setTabType(i);
        this.ltI.setTabType(i);
        this.ltJ.setTabType(i);
        this.ltK.setTabType(i);
        this.ltL.setTabType(i);
        this.ltM.setTabType(i);
        this.ltN.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.ltE.setIsHost(z);
        this.ltw.setIsHost(z);
        this.ltF.setIsHost(z);
        this.ltG.setIsHost(z);
        this.ltH.setIsHost(z);
        this.ltI.setIsHost(z);
        this.ltJ.setIsHost(z);
        this.ltK.setIsHost(z);
        this.ltL.setIsHost(z);
        this.ltM.setIsHost(z);
        this.ltN.setIsHost(z);
    }

    private void DH(String str) {
        if (this.bdV != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).DH(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.iga.getListAdapter() != null) {
            this.iga.getListAdapter().notifyDataSetChanged();
        }
    }
}
