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
    private l dWm;
    private v dWn;
    private u dWo;
    private w dWp;
    private g dWq;
    private a dWt;
    private g.a dWu = new n(this);
    private SparseBooleanArray dWv = new SparseBooleanArray();
    private SparseBooleanArray dWw = new SparseBooleanArray();
    private com.baidu.tieba.recommendfrs.data.o dWr = new com.baidu.tieba.recommendfrs.data.o();
    private com.baidu.tieba.recommendfrs.data.s dWs = new com.baidu.tieba.recommendfrs.data.s();

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, int i);

        void a(long j, DataRes dataRes, boolean z);

        void a(boolean z, com.baidu.tieba.recommendfrs.data.n nVar, boolean z2, long j);
    }

    public m(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.dWm = new l(tbPageContext);
        this.dWm.setUniqueId(bdUniqueId);
        this.dWn = new v(tbPageContext);
        this.dWn.setUniqueId(bdUniqueId);
        this.dWo = new u(tbPageContext, this.dWr);
        this.dWo.setUniqueId(bdUniqueId);
        this.dWp = new w(tbPageContext, this.dWs);
        this.dWp.setUniqueId(bdUniqueId);
        this.dWq = new g(tbPageContext, bdUniqueId);
        this.dWq.a(this.dWu);
        o oVar = new o(this);
        this.dWm.a(oVar);
        this.dWn.a(oVar);
        p pVar = new p(this);
        this.dWo.a(pVar);
        this.dWp.a(pVar);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        if (this.dWq != null) {
            this.dWq.a(i, z, i2, i3, i4, i5);
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

    public void v(long j, int i) {
        if (i == 3) {
            this.dWn.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.recommendfrs.data.q(j));
        } else if (i == 2) {
            this.dWm.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.recommendfrs.data.m(j));
        } else if (this.dWt != null) {
            this.dWt.a(j, TbadkCoreApplication.m411getInst().getString(t.j.invite_friend_no_data_now), -53);
        }
    }

    public void a(int i, long j, int i2, long j2) {
        if (!this.dWo.isLoading() && !this.dWp.isLoading()) {
            switch (i2) {
                case 3:
                    this.dWs.setPn(i);
                    this.dWs.setTagCode(j);
                    this.dWs.setRn(30);
                    if (i == 1) {
                        this.dWs.bU(0L);
                    } else {
                        this.dWs.bU(j2);
                    }
                    this.dWp.FG();
                    return;
                default:
                    this.dWr.setPn(i);
                    this.dWr.setTagCode(j);
                    this.dWr.bT(j2);
                    this.dWo.FG();
                    return;
            }
        }
    }

    public void a(a aVar) {
        this.dWt = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.recommendfrs.data.n, ?> mvcSocketResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.n> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.dWw.get(b, false)) {
            this.dWw.put(b, true);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
            nVar.fh(1005);
            nVar.pageType = b;
            nVar.aBH = false;
            nVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            nVar.aBv = mvcSocketResponsedMessage.performanceData.qH;
            nVar.aBw = mvcSocketResponsedMessage.performanceData.qI;
            nVar.aBx = mvcSocketResponsedMessage.performanceData.qJ;
            nVar.oL = mvcSocketResponsedMessage.performanceData.qK;
            nVar.oM = mvcSocketResponsedMessage.performanceData.qL;
            nVar.aBy = mvcSocketResponsedMessage.performanceData.qM;
            nVar.aBz = mvcSocketResponsedMessage.performanceData.qN;
            nVar.aBA = mvcSocketResponsedMessage.performanceData.qO;
            nVar.aBA += mvcSocketResponsedMessage.getProcessTime() - mvcSocketResponsedMessage.getStartTime();
            nVar.aBF = mvcSocketResponsedMessage.getDownSize();
            nVar.errCode = mvcSocketResponsedMessage.getError();
            nVar.aBG = 0L;
            nVar.sequenceID = mvcSocketResponsedMessage.sequenceID;
            a(nVar, b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.recommendfrs.data.n> mvcHttpResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.n> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.dWw.get(b, false)) {
            this.dWw.put(b, true);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
            nVar.fh(1005);
            nVar.pageType = b;
            nVar.aBH = true;
            nVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            nVar.aBv = mvcHttpResponsedMessage.performanceData.qH;
            nVar.aBw = mvcHttpResponsedMessage.performanceData.qI;
            nVar.aBx = mvcHttpResponsedMessage.performanceData.qJ;
            nVar.oL = mvcHttpResponsedMessage.performanceData.qK;
            nVar.oM = mvcHttpResponsedMessage.performanceData.qL;
            nVar.aBy = mvcHttpResponsedMessage.performanceData.qM;
            nVar.aBz = mvcHttpResponsedMessage.performanceData.qN;
            nVar.aBA = mvcHttpResponsedMessage.performanceData.qO;
            nVar.aBA += mvcHttpResponsedMessage.getProcessTime() - mvcHttpResponsedMessage.getStartTime();
            nVar.aBI = mvcHttpResponsedMessage.performanceData.qR;
            nVar.aBJ = mvcHttpResponsedMessage.performanceData.qS;
            nVar.aBF = 0L;
            nVar.aBG = mvcHttpResponsedMessage.getDownSize();
            nVar.socketErrNo = mvcHttpResponsedMessage.performanceData.qP;
            nVar.socketCostTime = mvcHttpResponsedMessage.performanceData.qQ;
            nVar.errCode = mvcHttpResponsedMessage.getError();
            nVar.aBL = mvcHttpResponsedMessage.getOrginalMessage().getClientLogID();
            a(nVar, b);
        }
    }

    public void a(com.baidu.tbadk.performanceLog.n nVar, int i) {
        if (nVar != null) {
            long ov = com.baidu.tieba.recommendfrs.a.aLJ().ov(i);
            nVar.aBu = 0L;
            com.baidu.tieba.recommendfrs.a.aLJ().setCreateTime(0L);
            nVar.aBB = com.baidu.tieba.recommendfrs.a.aLJ().ou(i);
            nVar.aBC = ov;
            nVar.GP();
        }
    }
}
