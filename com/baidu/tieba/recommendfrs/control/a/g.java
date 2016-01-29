package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.performanceLog.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.recommendfrs.personalize.RecPersonalizeHttpResponse;
import com.baidu.tieba.recommendfrs.personalize.RecPersonalizeRequest;
import com.baidu.tieba.recommendfrs.personalize.RecPersonalizeSocketResponse;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private long aAL;
    private boolean bnE;
    private boolean bnF;
    private com.baidu.adp.framework.listener.a dEl;
    private a dEm;

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, int i, String str);

        void b(long j, DataRes dataRes, boolean z);
    }

    public g(com.baidu.adp.base.h<BaseFragmentActivity> hVar, BdUniqueId bdUniqueId) {
        super(hVar);
        this.dEl = new h(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        this.aAL = 0L;
        this.bnE = false;
        this.bnF = false;
        setUniqueId(bdUniqueId);
        KI();
        KH();
        registerListener(this.dEl);
    }

    public void a(a aVar) {
        this.dEm = aVar;
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
        recPersonalizeRequest.setLoadType(i);
        recPersonalizeRequest.setNeedTag(z);
        recPersonalizeRequest.setRequestTagCode(i2);
        recPersonalizeRequest.setThreadCount(i3);
        recPersonalizeRequest.setTag(getUniqueId());
        recPersonalizeRequest.setPn(i4);
        recPersonalizeRequest.setSuggestCount(i5);
        recPersonalizeRequest.setTagCode(i2);
        sendMessage(recPersonalizeRequest);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        sendMessage(new RecPersonalizeRequest());
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    private void KH() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.i(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void KI() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, com.baidu.tieba.tbadkCore.a.a.am(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        Rb();
        if (!this.bnF) {
            this.bnF = true;
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
            nVar.eZ(1005);
            nVar.pageType = 1;
            nVar.aAQ = false;
            nVar.isSuccess = responsedMessage.hasError() ? false : true;
            nVar.aAF = responsedMessage.performanceData.qD;
            nVar.aAG = responsedMessage.performanceData.qE;
            nVar.aAH = responsedMessage.performanceData.qF;
            nVar.aAI = responsedMessage.performanceData.qG;
            nVar.aAJ = responsedMessage.performanceData.qH;
            nVar.aAO = responsedMessage.getDownSize();
            nVar.errCode = responsedMessage.getError();
            nVar.aAP = 0L;
            e(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ResponsedMessage<?> responsedMessage) {
        Rb();
        if (!this.bnF) {
            this.bnF = true;
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
            nVar.eZ(1005);
            nVar.pageType = 1;
            nVar.aAQ = true;
            nVar.isSuccess = responsedMessage.hasError() ? false : true;
            nVar.aAF = responsedMessage.performanceData.qD;
            nVar.aAG = responsedMessage.performanceData.qE;
            nVar.aAH = responsedMessage.performanceData.qF;
            nVar.aAI = responsedMessage.performanceData.qG;
            nVar.aAJ = responsedMessage.performanceData.qH;
            nVar.aAO = 0L;
            nVar.aAP = responsedMessage.getDownSize();
            nVar.socketErrNo = responsedMessage.performanceData.qI;
            nVar.socketCostTime = responsedMessage.performanceData.qJ;
            nVar.errCode = responsedMessage.getError();
            e(nVar);
        }
    }

    public void Rb() {
        if (!this.bnE) {
            this.bnE = true;
            if (com.baidu.tieba.recommendfrs.a.aER().nq(1) >= 0) {
                this.aAL = System.currentTimeMillis() - com.baidu.tieba.recommendfrs.a.aER().nq(1);
                com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
                nVar.eZ(1005);
                nVar.pageType = 1;
                nVar.aAE = com.baidu.tieba.recommendfrs.a.aER().getCreateTime();
                nVar.aAL = this.aAL;
                nVar.FS();
            }
        }
    }

    public void e(v vVar) {
        if (vVar != null && com.baidu.tieba.recommendfrs.a.aER().getCreateTime() > 0) {
            vVar.aAE = com.baidu.tieba.recommendfrs.a.aER().getCreateTime();
            com.baidu.tieba.recommendfrs.a.aER().setCreateTime(0L);
            vVar.aAK = com.baidu.tieba.recommendfrs.a.aER().nr(1);
            vVar.aAL = this.aAL == 0 ? System.currentTimeMillis() - com.baidu.tieba.recommendfrs.a.aER().nq(1) : this.aAL;
            vVar.FT();
        }
    }
}
