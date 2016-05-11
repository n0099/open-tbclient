package com.baidu.tieba.recommendfrs.control.a;

import android.util.SparseBooleanArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.recommendfrs.control.a.g;
import com.baidu.tieba.t;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class m {
    private g dZA;
    private a dZD;
    private l dZw;
    private v dZx;
    private u dZy;
    private w dZz;
    private g.a dZE = new n(this);
    private SparseBooleanArray dZF = new SparseBooleanArray();
    private SparseBooleanArray dZG = new SparseBooleanArray();
    private com.baidu.tieba.recommendfrs.data.o dZB = new com.baidu.tieba.recommendfrs.data.o();
    private com.baidu.tieba.recommendfrs.data.s dZC = new com.baidu.tieba.recommendfrs.data.s();

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, int i);

        void a(long j, DataRes dataRes, boolean z);

        void a(boolean z, com.baidu.tieba.recommendfrs.data.n nVar, boolean z2, long j);
    }

    public m(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.dZw = new l(tbPageContext);
        this.dZw.setUniqueId(bdUniqueId);
        this.dZx = new v(tbPageContext);
        this.dZx.setUniqueId(bdUniqueId);
        this.dZy = new u(tbPageContext, this.dZB);
        this.dZy.setUniqueId(bdUniqueId);
        this.dZz = new w(tbPageContext, this.dZC);
        this.dZz.setUniqueId(bdUniqueId);
        this.dZA = new g(tbPageContext, bdUniqueId);
        this.dZA.a(this.dZE);
        o oVar = new o(this);
        this.dZw.a(oVar);
        this.dZx.a(oVar);
        p pVar = new p(this);
        this.dZy.a(pVar);
        this.dZz.a(pVar);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        if (this.dZA != null) {
            this.dZA.a(i, z, i2, i3, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.n> mvcNetMessage) {
        com.baidu.tieba.recommendfrs.data.s sVar;
        if (mvcNetMessage != null) {
            if (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.o) {
                com.baidu.tieba.recommendfrs.data.o oVar = (com.baidu.tieba.recommendfrs.data.o) mvcNetMessage.getRequestData();
                if (oVar != null) {
                    return oVar.getTagCode();
                }
            } else if ((mvcNetMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.s) && (sVar = (com.baidu.tieba.recommendfrs.data.s) mvcNetMessage.getRequestData()) != null) {
                return sVar.getTagCode();
            }
        }
        return -1L;
    }

    private int b(MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.n> mvcNetMessage) {
        if (mvcNetMessage != null) {
            if (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.o) {
                return 2;
            }
            return mvcNetMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.s ? 3 : 0;
        }
        return 0;
    }

    public void w(long j, int i) {
        if (i == 3) {
            this.dZx.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.recommendfrs.data.q(j));
        } else if (i == 2) {
            this.dZw.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.recommendfrs.data.m(j));
        } else if (this.dZD != null) {
            this.dZD.a(j, TbadkCoreApplication.m11getInst().getString(t.j.invite_friend_no_data_now), -53);
        }
    }

    public void a(int i, long j, int i2, long j2) {
        if (!this.dZy.isLoading() && !this.dZz.isLoading()) {
            switch (i2) {
                case 3:
                    this.dZC.setPn(i);
                    this.dZC.setTagCode(j);
                    this.dZC.setRn(30);
                    if (i == 1) {
                        this.dZC.bU(0L);
                    } else {
                        this.dZC.bU(j2);
                    }
                    this.dZz.Dy();
                    return;
                default:
                    this.dZB.setPn(i);
                    this.dZB.setTagCode(j);
                    this.dZB.bT(j2);
                    this.dZy.Dy();
                    return;
            }
        }
    }

    public void a(a aVar) {
        this.dZD = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.recommendfrs.data.n, ?> mvcSocketResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.n> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.dZG.get(b, false)) {
            this.dZG.put(b, true);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
            nVar.eM(1005);
            nVar.pageType = b;
            nVar.axK = false;
            nVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            nVar.axy = mvcSocketResponsedMessage.performanceData.gv;
            nVar.axz = mvcSocketResponsedMessage.performanceData.gw;
            nVar.axA = mvcSocketResponsedMessage.performanceData.gx;
            nVar.eD = mvcSocketResponsedMessage.performanceData.gy;
            nVar.eE = mvcSocketResponsedMessage.performanceData.gz;
            nVar.axB = mvcSocketResponsedMessage.performanceData.gA;
            nVar.axC = mvcSocketResponsedMessage.performanceData.gB;
            nVar.axD = mvcSocketResponsedMessage.performanceData.gC;
            nVar.axD += mvcSocketResponsedMessage.getProcessTime() - mvcSocketResponsedMessage.getStartTime();
            nVar.axI = mvcSocketResponsedMessage.getDownSize();
            nVar.errCode = mvcSocketResponsedMessage.getError();
            nVar.axJ = 0L;
            nVar.sequenceID = mvcSocketResponsedMessage.sequenceID;
            a(nVar, b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.recommendfrs.data.n> mvcHttpResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.n> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.dZG.get(b, false)) {
            this.dZG.put(b, true);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
            nVar.eM(1005);
            nVar.pageType = b;
            nVar.axK = true;
            nVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            nVar.axy = mvcHttpResponsedMessage.performanceData.gv;
            nVar.axz = mvcHttpResponsedMessage.performanceData.gw;
            nVar.axA = mvcHttpResponsedMessage.performanceData.gx;
            nVar.eD = mvcHttpResponsedMessage.performanceData.gy;
            nVar.eE = mvcHttpResponsedMessage.performanceData.gz;
            nVar.axB = mvcHttpResponsedMessage.performanceData.gA;
            nVar.axC = mvcHttpResponsedMessage.performanceData.gB;
            nVar.axD = mvcHttpResponsedMessage.performanceData.gC;
            nVar.axD += mvcHttpResponsedMessage.getProcessTime() - mvcHttpResponsedMessage.getStartTime();
            nVar.axL = mvcHttpResponsedMessage.performanceData.gF;
            nVar.axM = mvcHttpResponsedMessage.performanceData.gG;
            nVar.axI = 0L;
            nVar.axJ = mvcHttpResponsedMessage.getDownSize();
            nVar.socketErrNo = mvcHttpResponsedMessage.performanceData.gD;
            nVar.socketCostTime = mvcHttpResponsedMessage.performanceData.gE;
            nVar.errCode = mvcHttpResponsedMessage.getError();
            nVar.axO = mvcHttpResponsedMessage.getOrginalMessage().getClientLogID();
            a(nVar, b);
        }
    }

    public void a(com.baidu.tbadk.performanceLog.n nVar, int i) {
        if (nVar != null) {
            long ol = com.baidu.tieba.recommendfrs.a.aLN().ol(i);
            nVar.axx = 0L;
            com.baidu.tieba.recommendfrs.a.aLN().setCreateTime(0L);
            nVar.axE = com.baidu.tieba.recommendfrs.a.aLN().ok(i);
            nVar.axF = ol;
            nVar.EH();
        }
    }
}
