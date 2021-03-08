package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private BdTypeRecyclerView joh;
    private m mBA;
    private b mBB;
    private i mBC;
    private a mBD;
    private c mBE;
    private h mBF;
    private e mBG;
    private k mBH;
    private d mBI;
    private com.baidu.tieba.person.a.d mBJ;
    private p mBK;
    private com.baidu.tieba.personPolymeric.a.a.g mBL;
    private com.baidu.tieba.personPolymeric.a.a.d mBM;
    private com.baidu.tieba.personPolymeric.a.a.i mBN;
    private com.baidu.tieba.personPolymeric.a.a.h mBO;
    private com.baidu.tieba.personPolymeric.a.a.a mBP;
    private com.baidu.tieba.personPolymeric.a.a.c mBQ;
    private com.baidu.tieba.personPolymeric.a.a.b mBR;
    private com.baidu.tieba.personPolymeric.a.a.e mBS;
    private com.baidu.tieba.personPolymeric.a.a.f mBT;
    private BdUniqueId mBdUniqueId;
    private com.baidu.tieba.person.a.a muC;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.joh = bdTypeRecyclerView;
        this.mBA = new m(tbPageContext);
        this.mBB = new b(tbPageContext);
        this.mBC = new i(tbPageContext);
        this.mBD = new a(tbPageContext);
        this.mBE = new c(tbPageContext);
        this.mBF = new h(tbPageContext, tbPageContext.getUniqueId());
        this.mBG = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.mDX);
        this.mBH = new k(tbPageContext);
        this.mBI = new d(tbPageContext);
        this.mBJ = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.muD);
        this.muC = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.mun);
        this.mBK = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mBL = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.mBM = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.k.eSj);
        this.mBN = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.l.eSl);
        this.mBO = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.k.eSq);
        this.mBR = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.k.eSs);
        this.mBS = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.k.eSr);
        this.mBT = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.k.eSt);
        this.mBP = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.e.iCl);
        this.mBQ = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.f.iCm);
        this.boS.add(this.mBA);
        this.boS.add(this.mBB);
        this.boS.add(this.mBC);
        this.boS.add(this.mBD);
        this.boS.add(this.mBE);
        this.boS.add(this.mBF);
        this.boS.add(this.mBG);
        this.boS.add(this.mBH);
        this.boS.add(this.mBI);
        this.boS.add(this.mBJ);
        this.boS.add(this.muC);
        this.boS.add(this.mBK);
        this.boS.add(this.mBL);
        this.boS.add(this.mBM);
        this.boS.add(this.mBN);
        this.boS.add(this.mBO);
        this.boS.add(this.mBR);
        this.boS.add(this.mBS);
        this.boS.add(this.mBT);
        this.boS.add(this.mBP);
        this.boS.add(this.mBQ);
        bdTypeRecyclerView.addAdapters(this.boS);
        ED("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBL.fIy = bdUniqueId;
        this.mBM.fIy = bdUniqueId;
        this.mBN.fIy = bdUniqueId;
        this.mBO.fIy = bdUniqueId;
        this.mBR.fIy = bdUniqueId;
        this.mBS.fIy = bdUniqueId;
        this.mBT.fIy = bdUniqueId;
        this.mBP.fIy = bdUniqueId;
        this.mBQ.fIy = bdUniqueId;
    }

    public void GY(int i) {
        this.mBL.Ha(i);
        this.mBM.Ha(i);
        this.mBN.Ha(i);
        this.mBO.Ha(i);
        this.mBP.Ha(i);
        this.mBQ.Ha(i);
        this.mBR.Ha(i);
        this.mBS.Ha(i);
        this.mBT.Ha(i);
    }

    public void GZ(int i) {
        this.mBL.GZ(i);
        this.mBM.GZ(i);
        this.mBN.GZ(i);
        this.mBO.GZ(i);
        this.mBP.GZ(i);
        this.mBQ.GZ(i);
        this.mBR.GZ(i);
        this.mBS.GZ(i);
        this.mBT.GZ(i);
    }

    public void setTabType(int i) {
        this.mBL.setTabType(i);
        this.mBM.setTabType(i);
        this.mBN.setTabType(i);
        this.mBO.setTabType(i);
        this.mBP.setTabType(i);
        this.mBQ.setTabType(i);
        this.mBR.setTabType(i);
        this.mBS.setTabType(i);
        this.mBT.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.mBK.setIsHost(z);
        this.mBC.setIsHost(z);
        this.mBL.setIsHost(z);
        this.mBM.setIsHost(z);
        this.mBN.setIsHost(z);
        this.mBO.setIsHost(z);
        this.mBP.setIsHost(z);
        this.mBQ.setIsHost(z);
        this.mBR.setIsHost(z);
        this.mBS.setIsHost(z);
        this.mBT.setIsHost(z);
    }

    private void ED(String str) {
        if (this.boS != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).ED(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.joh.getListAdapter() != null) {
            this.joh.getListAdapter().notifyDataSetChanged();
        }
    }
}
