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
public class j {
    private i dEo;
    private s dEp;
    private r dEq;
    private t dEr;
    private g dEs;
    private a dEv;
    private g.a dEw = new k(this);
    private long aAL = 0;
    private SparseBooleanArray dEx = new SparseBooleanArray();
    private SparseBooleanArray dEy = new SparseBooleanArray();
    private com.baidu.tieba.recommendfrs.data.k dEt = new com.baidu.tieba.recommendfrs.data.k();
    private com.baidu.tieba.recommendfrs.data.o dEu = new com.baidu.tieba.recommendfrs.data.o();

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, int i);

        void a(long j, DataRes dataRes, boolean z);

        void a(boolean z, com.baidu.tieba.recommendfrs.data.j jVar, boolean z2, long j);
    }

    public j(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.dEo = new i(tbPageContext);
        this.dEo.setUniqueId(bdUniqueId);
        this.dEp = new s(tbPageContext);
        this.dEp.setUniqueId(bdUniqueId);
        this.dEq = new r(tbPageContext, this.dEt);
        this.dEq.setUniqueId(bdUniqueId);
        this.dEr = new t(tbPageContext, this.dEu);
        this.dEr.setUniqueId(bdUniqueId);
        this.dEs = new g(tbPageContext, bdUniqueId);
        this.dEs.a(this.dEw);
        l lVar = new l(this);
        this.dEo.a(lVar);
        this.dEp.a(lVar);
        m mVar = new m(this);
        this.dEq.a(mVar);
        this.dEr.a(mVar);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        if (this.dEs != null) {
            this.dEs.a(i, z, i2, i3, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.j> mvcNetMessage) {
        com.baidu.tieba.recommendfrs.data.o oVar;
        if (mvcNetMessage != null) {
            if (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.k) {
                com.baidu.tieba.recommendfrs.data.k kVar = (com.baidu.tieba.recommendfrs.data.k) mvcNetMessage.getRequestData();
                if (kVar != null) {
                    return kVar.getTagCode();
                }
            } else if ((mvcNetMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.o) && (oVar = (com.baidu.tieba.recommendfrs.data.o) mvcNetMessage.getRequestData()) != null) {
                return oVar.getTagCode();
            }
        }
        return -1L;
    }

    private int b(MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.j> mvcNetMessage) {
        if (mvcNetMessage != null) {
            if (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.k) {
                return 2;
            }
            return mvcNetMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.o ? 3 : 0;
        }
        return 0;
    }

    public void h(long j, int i) {
        if (i == 3) {
            this.dEp.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.recommendfrs.data.m(j));
        } else if (i == 2) {
            this.dEo.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.recommendfrs.data.i(j));
        } else if (this.dEv != null) {
            this.dEv.a(j, TbadkCoreApplication.m411getInst().getString(t.j.invite_friend_no_data_now), -53);
        }
    }

    public void a(int i, long j, int i2, long j2) {
        if (!this.dEq.isLoading() && !this.dEr.isLoading()) {
            switch (i2) {
                case 3:
                    this.dEu.setPn(i);
                    this.dEu.setTagCode(j);
                    this.dEu.setRn(30);
                    if (i == 1) {
                        this.dEu.bK(0L);
                    } else {
                        this.dEu.bK(j2);
                    }
                    this.dEr.ET();
                    return;
                default:
                    this.dEt.setPn(i);
                    this.dEt.setTagCode(j);
                    this.dEt.bJ(j2);
                    this.dEq.ET();
                    return;
            }
        }
    }

    public void a(a aVar) {
        this.dEv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.recommendfrs.data.j, ?> mvcSocketResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.j> mvcNetMessage) {
        int b = b(mvcNetMessage);
        nu(b);
        if (!this.dEy.get(b, false)) {
            this.dEy.put(b, true);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
            nVar.eZ(1005);
            nVar.pageType = b;
            nVar.aAQ = false;
            nVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            nVar.aAF = mvcSocketResponsedMessage.performanceData.qD;
            nVar.aAG = mvcSocketResponsedMessage.performanceData.qE;
            nVar.aAH = mvcSocketResponsedMessage.performanceData.qF;
            nVar.aAI = mvcSocketResponsedMessage.performanceData.qG;
            nVar.aAJ = mvcSocketResponsedMessage.performanceData.qH;
            nVar.aAO = mvcSocketResponsedMessage.getDownSize();
            nVar.errCode = mvcSocketResponsedMessage.getError();
            nVar.aAP = 0L;
            a(nVar, b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.recommendfrs.data.j> mvcHttpResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.j> mvcNetMessage) {
        int b = b(mvcNetMessage);
        nu(b);
        if (!this.dEy.get(b, false)) {
            this.dEy.put(b, true);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
            nVar.eZ(1005);
            nVar.pageType = b;
            nVar.aAQ = true;
            nVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            nVar.aAF = mvcHttpResponsedMessage.performanceData.qD;
            nVar.aAG = mvcHttpResponsedMessage.performanceData.qE;
            nVar.aAH = mvcHttpResponsedMessage.performanceData.qF;
            nVar.aAI = mvcHttpResponsedMessage.performanceData.qG;
            nVar.aAJ = mvcHttpResponsedMessage.performanceData.qH;
            nVar.aAO = 0L;
            nVar.aAP = mvcHttpResponsedMessage.getDownSize();
            nVar.socketErrNo = mvcHttpResponsedMessage.performanceData.qI;
            nVar.socketCostTime = mvcHttpResponsedMessage.performanceData.qJ;
            nVar.errCode = mvcHttpResponsedMessage.getError();
            a(nVar, b);
        }
    }

    public void nu(int i) {
        if (!this.dEx.get(i, false) && com.baidu.tieba.recommendfrs.a.aER().getCreateTime() > 0) {
            this.dEx.put(i, true);
            this.aAL = System.currentTimeMillis() - com.baidu.tieba.recommendfrs.a.aER().nq(i);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
            nVar.eZ(1005);
            nVar.pageType = i;
            nVar.aAE = 0L;
            nVar.aAL = this.aAL;
            nVar.FS();
        }
    }

    public void a(com.baidu.tbadk.performanceLog.n nVar, int i) {
        if (nVar != null) {
            nVar.aAE = 0L;
            com.baidu.tieba.recommendfrs.a.aER().setCreateTime(0L);
            nVar.aAK = com.baidu.tieba.recommendfrs.a.aER().nr(i);
            nVar.aAL = this.aAL == 0 ? System.currentTimeMillis() - com.baidu.tieba.recommendfrs.a.aER().nq(i) : this.aAL;
            nVar.FT();
        }
    }
}
