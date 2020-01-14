package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private BdTypeRecyclerView gqN;
    private com.baidu.tieba.person.a.a jeW;
    private i jlA;
    private a jlB;
    private c jlC;
    private h jlD;
    private e jlE;
    private k jlF;
    private d jlG;
    private com.baidu.tieba.person.a.d jlH;
    private p jlI;
    private com.baidu.tieba.personPolymeric.a.a.g jlJ;
    private com.baidu.tieba.personPolymeric.a.a.d jlK;
    private com.baidu.tieba.personPolymeric.a.a.i jlL;
    private com.baidu.tieba.personPolymeric.a.a.h jlM;
    private com.baidu.tieba.personPolymeric.a.a.a jlN;
    private com.baidu.tieba.personPolymeric.a.a.c jlO;
    private com.baidu.tieba.personPolymeric.a.a.b jlP;
    private com.baidu.tieba.personPolymeric.a.a.e jlQ;
    private com.baidu.tieba.personPolymeric.a.a.f jlR;
    private m jly;
    private b jlz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gqN = bdTypeRecyclerView;
        this.jly = new m(tbPageContext);
        this.jlz = new b(tbPageContext);
        this.jlA = new i(tbPageContext);
        this.jlB = new a(tbPageContext);
        this.jlC = new c(tbPageContext);
        this.jlD = new h(tbPageContext, tbPageContext.getUniqueId());
        this.jlE = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.jnT);
        this.jlF = new k(tbPageContext);
        this.jlG = new d(tbPageContext);
        this.jlH = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.jeX);
        this.jeW = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jeJ);
        this.jlI = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.jlJ = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jlK = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.cNt);
        this.jlL = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.cNv);
        this.jlM = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.cNz);
        this.jlP = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.cNB);
        this.jlQ = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.cNA);
        this.jlR = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.cNC);
        this.jlN = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.fKb);
        this.jlO = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.fKc);
        this.apl.add(this.jly);
        this.apl.add(this.jlz);
        this.apl.add(this.jlA);
        this.apl.add(this.jlB);
        this.apl.add(this.jlC);
        this.apl.add(this.jlD);
        this.apl.add(this.jlE);
        this.apl.add(this.jlF);
        this.apl.add(this.jlG);
        this.apl.add(this.jlH);
        this.apl.add(this.jeW);
        this.apl.add(this.jlI);
        this.apl.add(this.jlJ);
        this.apl.add(this.jlK);
        this.apl.add(this.jlL);
        this.apl.add(this.jlM);
        this.apl.add(this.jlP);
        this.apl.add(this.jlQ);
        this.apl.add(this.jlR);
        this.apl.add(this.jlN);
        this.apl.add(this.jlO);
        bdTypeRecyclerView.addAdapters(this.apl);
        wu("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jlJ.dxg = bdUniqueId;
        this.jlK.dxg = bdUniqueId;
        this.jlL.dxg = bdUniqueId;
        this.jlM.dxg = bdUniqueId;
        this.jlP.dxg = bdUniqueId;
        this.jlQ.dxg = bdUniqueId;
        this.jlR.dxg = bdUniqueId;
        this.jlN.dxg = bdUniqueId;
        this.jlO.dxg = bdUniqueId;
    }

    public void zO(int i) {
        this.jlJ.zQ(i);
        this.jlK.zQ(i);
        this.jlL.zQ(i);
        this.jlM.zQ(i);
        this.jlN.zQ(i);
        this.jlO.zQ(i);
        this.jlP.zQ(i);
        this.jlQ.zQ(i);
        this.jlR.zQ(i);
    }

    public void zP(int i) {
        this.jlJ.zP(i);
        this.jlK.zP(i);
        this.jlL.zP(i);
        this.jlM.zP(i);
        this.jlN.zP(i);
        this.jlO.zP(i);
        this.jlP.zP(i);
        this.jlQ.zP(i);
        this.jlR.zP(i);
    }

    public void setTabType(int i) {
        this.jlJ.setTabType(i);
        this.jlK.setTabType(i);
        this.jlL.setTabType(i);
        this.jlM.setTabType(i);
        this.jlN.setTabType(i);
        this.jlO.setTabType(i);
        this.jlP.setTabType(i);
        this.jlQ.setTabType(i);
        this.jlR.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.jlI.setIsHost(z);
        this.jlA.setIsHost(z);
        this.jlJ.setIsHost(z);
        this.jlK.setIsHost(z);
        this.jlL.setIsHost(z);
        this.jlM.setIsHost(z);
        this.jlN.setIsHost(z);
        this.jlO.setIsHost(z);
        this.jlP.setIsHost(z);
        this.jlQ.setIsHost(z);
        this.jlR.setIsHost(z);
    }

    private void wu(String str) {
        if (this.apl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wu(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gqN.getListAdapter() != null) {
            this.gqN.getListAdapter().notifyDataSetChanged();
        }
    }
}
