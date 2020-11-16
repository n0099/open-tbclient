package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private BdTypeRecyclerView iOd;
    private com.baidu.tieba.person.a.a lUx;
    private BdUniqueId mBdUniqueId;
    private k mbA;
    private d mbB;
    private com.baidu.tieba.person.a.d mbC;
    private p mbD;
    private com.baidu.tieba.personPolymeric.a.a.g mbE;
    private com.baidu.tieba.personPolymeric.a.a.d mbF;
    private com.baidu.tieba.personPolymeric.a.a.i mbG;
    private com.baidu.tieba.personPolymeric.a.a.h mbH;
    private com.baidu.tieba.personPolymeric.a.a.a mbI;
    private com.baidu.tieba.personPolymeric.a.a.c mbJ;
    private com.baidu.tieba.personPolymeric.a.a.b mbK;
    private com.baidu.tieba.personPolymeric.a.a.e mbL;
    private com.baidu.tieba.personPolymeric.a.a.f mbM;
    private m mbt;
    private b mbu;
    private i mbv;
    private a mbw;
    private c mbx;
    private h mby;
    private e mbz;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iOd = bdTypeRecyclerView;
        this.mbt = new m(tbPageContext);
        this.mbu = new b(tbPageContext);
        this.mbv = new i(tbPageContext);
        this.mbw = new a(tbPageContext);
        this.mbx = new c(tbPageContext);
        this.mby = new h(tbPageContext, tbPageContext.getUniqueId());
        this.mbz = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.mdL);
        this.mbA = new k(tbPageContext);
        this.mbB = new d(tbPageContext);
        this.mbC = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.lUy);
        this.lUx = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.lUi);
        this.mbD = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mbE = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.mbF = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.eCm);
        this.mbG = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.eCo);
        this.mbH = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.eCt);
        this.mbK = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.eCv);
        this.mbL = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.eCu);
        this.mbM = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.eCw);
        this.mbI = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.ibR);
        this.mbJ = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.ibS);
        this.biN.add(this.mbt);
        this.biN.add(this.mbu);
        this.biN.add(this.mbv);
        this.biN.add(this.mbw);
        this.biN.add(this.mbx);
        this.biN.add(this.mby);
        this.biN.add(this.mbz);
        this.biN.add(this.mbA);
        this.biN.add(this.mbB);
        this.biN.add(this.mbC);
        this.biN.add(this.lUx);
        this.biN.add(this.mbD);
        this.biN.add(this.mbE);
        this.biN.add(this.mbF);
        this.biN.add(this.mbG);
        this.biN.add(this.mbH);
        this.biN.add(this.mbK);
        this.biN.add(this.mbL);
        this.biN.add(this.mbM);
        this.biN.add(this.mbI);
        this.biN.add(this.mbJ);
        bdTypeRecyclerView.addAdapters(this.biN);
        EA("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mbE.fsa = bdUniqueId;
        this.mbF.fsa = bdUniqueId;
        this.mbG.fsa = bdUniqueId;
        this.mbH.fsa = bdUniqueId;
        this.mbK.fsa = bdUniqueId;
        this.mbL.fsa = bdUniqueId;
        this.mbM.fsa = bdUniqueId;
        this.mbI.fsa = bdUniqueId;
        this.mbJ.fsa = bdUniqueId;
    }

    public void Hz(int i) {
        this.mbE.HB(i);
        this.mbF.HB(i);
        this.mbG.HB(i);
        this.mbH.HB(i);
        this.mbI.HB(i);
        this.mbJ.HB(i);
        this.mbK.HB(i);
        this.mbL.HB(i);
        this.mbM.HB(i);
    }

    public void HA(int i) {
        this.mbE.HA(i);
        this.mbF.HA(i);
        this.mbG.HA(i);
        this.mbH.HA(i);
        this.mbI.HA(i);
        this.mbJ.HA(i);
        this.mbK.HA(i);
        this.mbL.HA(i);
        this.mbM.HA(i);
    }

    public void setTabType(int i) {
        this.mbE.setTabType(i);
        this.mbF.setTabType(i);
        this.mbG.setTabType(i);
        this.mbH.setTabType(i);
        this.mbI.setTabType(i);
        this.mbJ.setTabType(i);
        this.mbK.setTabType(i);
        this.mbL.setTabType(i);
        this.mbM.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.mbD.setIsHost(z);
        this.mbv.setIsHost(z);
        this.mbE.setIsHost(z);
        this.mbF.setIsHost(z);
        this.mbG.setIsHost(z);
        this.mbH.setIsHost(z);
        this.mbI.setIsHost(z);
        this.mbJ.setIsHost(z);
        this.mbK.setIsHost(z);
        this.mbL.setIsHost(z);
        this.mbM.setIsHost(z);
    }

    private void EA(String str) {
        if (this.biN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).EA(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.iOd.getListAdapter() != null) {
            this.iOd.getListAdapter().notifyDataSetChanged();
        }
    }
}
