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
    private com.baidu.tieba.person.a.a jeR;
    private k jlA;
    private d jlB;
    private com.baidu.tieba.person.a.d jlC;
    private p jlD;
    private com.baidu.tieba.personPolymeric.a.a.g jlE;
    private com.baidu.tieba.personPolymeric.a.a.d jlF;
    private com.baidu.tieba.personPolymeric.a.a.i jlG;
    private com.baidu.tieba.personPolymeric.a.a.h jlH;
    private com.baidu.tieba.personPolymeric.a.a.a jlI;
    private com.baidu.tieba.personPolymeric.a.a.c jlJ;
    private com.baidu.tieba.personPolymeric.a.a.b jlK;
    private com.baidu.tieba.personPolymeric.a.a.e jlL;
    private com.baidu.tieba.personPolymeric.a.a.f jlM;
    private m jlt;
    private b jlu;
    private i jlv;
    private a jlw;
    private c jlx;
    private h jly;
    private e jlz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gqN = bdTypeRecyclerView;
        this.jlt = new m(tbPageContext);
        this.jlu = new b(tbPageContext);
        this.jlv = new i(tbPageContext);
        this.jlw = new a(tbPageContext);
        this.jlx = new c(tbPageContext);
        this.jly = new h(tbPageContext, tbPageContext.getUniqueId());
        this.jlz = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.jnO);
        this.jlA = new k(tbPageContext);
        this.jlB = new d(tbPageContext);
        this.jlC = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.jeS);
        this.jeR = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.jeE);
        this.jlD = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.jlE = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jlF = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.cNt);
        this.jlG = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.cNv);
        this.jlH = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.cNz);
        this.jlK = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.cNB);
        this.jlL = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.cNA);
        this.jlM = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.cNC);
        this.jlI = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.fKb);
        this.jlJ = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.fKc);
        this.apl.add(this.jlt);
        this.apl.add(this.jlu);
        this.apl.add(this.jlv);
        this.apl.add(this.jlw);
        this.apl.add(this.jlx);
        this.apl.add(this.jly);
        this.apl.add(this.jlz);
        this.apl.add(this.jlA);
        this.apl.add(this.jlB);
        this.apl.add(this.jlC);
        this.apl.add(this.jeR);
        this.apl.add(this.jlD);
        this.apl.add(this.jlE);
        this.apl.add(this.jlF);
        this.apl.add(this.jlG);
        this.apl.add(this.jlH);
        this.apl.add(this.jlK);
        this.apl.add(this.jlL);
        this.apl.add(this.jlM);
        this.apl.add(this.jlI);
        this.apl.add(this.jlJ);
        bdTypeRecyclerView.addAdapters(this.apl);
        wu("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jlE.dxg = bdUniqueId;
        this.jlF.dxg = bdUniqueId;
        this.jlG.dxg = bdUniqueId;
        this.jlH.dxg = bdUniqueId;
        this.jlK.dxg = bdUniqueId;
        this.jlL.dxg = bdUniqueId;
        this.jlM.dxg = bdUniqueId;
        this.jlI.dxg = bdUniqueId;
        this.jlJ.dxg = bdUniqueId;
    }

    public void zO(int i) {
        this.jlE.zQ(i);
        this.jlF.zQ(i);
        this.jlG.zQ(i);
        this.jlH.zQ(i);
        this.jlI.zQ(i);
        this.jlJ.zQ(i);
        this.jlK.zQ(i);
        this.jlL.zQ(i);
        this.jlM.zQ(i);
    }

    public void zP(int i) {
        this.jlE.zP(i);
        this.jlF.zP(i);
        this.jlG.zP(i);
        this.jlH.zP(i);
        this.jlI.zP(i);
        this.jlJ.zP(i);
        this.jlK.zP(i);
        this.jlL.zP(i);
        this.jlM.zP(i);
    }

    public void setTabType(int i) {
        this.jlE.setTabType(i);
        this.jlF.setTabType(i);
        this.jlG.setTabType(i);
        this.jlH.setTabType(i);
        this.jlI.setTabType(i);
        this.jlJ.setTabType(i);
        this.jlK.setTabType(i);
        this.jlL.setTabType(i);
        this.jlM.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.jlD.setIsHost(z);
        this.jlv.setIsHost(z);
        this.jlE.setIsHost(z);
        this.jlF.setIsHost(z);
        this.jlG.setIsHost(z);
        this.jlH.setIsHost(z);
        this.jlI.setIsHost(z);
        this.jlJ.setIsHost(z);
        this.jlK.setIsHost(z);
        this.jlL.setIsHost(z);
        this.jlM.setIsHost(z);
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
