package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.recommendfrs.personalize.RecPersonalizeHttpResponse;
import com.baidu.tieba.recommendfrs.personalize.RecPersonalizeRequest;
import com.baidu.tieba.recommendfrs.personalize.RecPersonalizeSocketResponse;
import java.util.ArrayList;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private boolean bsB;
    private boolean bsC;
    private com.baidu.adp.framework.listener.a cIL;
    private a dWd;
    private String dWe;
    private String dWf;
    private ArrayList<String> dWg;
    private int dWh;
    private CustomMessageListener dWi;
    private CustomMessageListener dWj;
    private CustomMessageListener dWk;

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, DataRes dataRes, boolean z);

        void e(long j, int i, String str);
    }

    public g(com.baidu.adp.base.h<BaseFragmentActivity> hVar, BdUniqueId bdUniqueId) {
        super(hVar);
        this.cIL = new h(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        this.bsB = false;
        this.bsC = false;
        this.dWh = 0;
        this.dWi = new i(this, CmdConfigCustom.CMD_SET_NU_SEX_GUIDE);
        this.dWj = new j(this, CmdConfigCustom.CMD_SET_NU_AGE_GUIDE);
        this.dWk = new k(this, CmdConfigCustom.CMD_SET_INTEREST_GUIDE);
        setUniqueId(bdUniqueId);
        Mc();
        Mb();
        registerListener(this.cIL);
        registerListener(this.dWi);
        registerListener(this.dWj);
        registerListener(this.dWk);
    }

    public void a(a aVar) {
        this.dWd = aVar;
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
        if ((!StringUtils.isNull(this.dWe) || !StringUtils.isNull(this.dWf)) && !com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("close_new_user_guide_tip", false)) {
            recPersonalizeRequest.setSexTag(this.dWe);
            recPersonalizeRequest.seAgeTag(this.dWf);
        } else if (this.dWg != null) {
            recPersonalizeRequest.setInterestGuideTag(this.dWg);
        }
        recPersonalizeRequest.setTagType(this.dWh);
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

    private void Mb() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.h(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void Mc() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, com.baidu.tieba.tbadkCore.a.a.au(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (!this.bsC) {
            this.bsC = true;
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
            nVar.fh(1005);
            nVar.pageType = 1;
            nVar.aBH = false;
            nVar.isSuccess = responsedMessage.hasError() ? false : true;
            nVar.aBv = responsedMessage.performanceData.qH;
            nVar.aBw = responsedMessage.performanceData.qI;
            nVar.aBx = responsedMessage.performanceData.qJ;
            nVar.oL = responsedMessage.performanceData.qK;
            nVar.oM = responsedMessage.performanceData.qL;
            nVar.aBy = responsedMessage.performanceData.qM;
            nVar.aBz = responsedMessage.performanceData.qN;
            nVar.aBA = responsedMessage.performanceData.qO;
            nVar.aBA += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            nVar.aBF = responsedMessage.getDownSize();
            nVar.errCode = responsedMessage.getError();
            nVar.aBG = 0L;
            nVar.sequenceID = ((RecPersonalizeSocketResponse) responsedMessage).sequenceID;
            d(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ResponsedMessage<?> responsedMessage) {
        if (!this.bsC) {
            this.bsC = true;
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
            nVar.fh(1005);
            nVar.pageType = 1;
            nVar.aBH = true;
            nVar.isSuccess = responsedMessage.hasError() ? false : true;
            nVar.aBv = responsedMessage.performanceData.qH;
            nVar.aBw = responsedMessage.performanceData.qI;
            nVar.aBx = responsedMessage.performanceData.qJ;
            nVar.oL = responsedMessage.performanceData.qK;
            nVar.oM = responsedMessage.performanceData.qL;
            nVar.aBy = responsedMessage.performanceData.qM;
            nVar.aBz = responsedMessage.performanceData.qN;
            nVar.aBA = responsedMessage.performanceData.qO;
            nVar.aBA += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            nVar.aBI = responsedMessage.performanceData.qR;
            nVar.aBJ = responsedMessage.performanceData.qS;
            nVar.aBF = 0L;
            nVar.aBG = responsedMessage.getDownSize();
            nVar.socketErrNo = responsedMessage.performanceData.qP;
            nVar.socketCostTime = responsedMessage.performanceData.qQ;
            nVar.errCode = responsedMessage.getError();
            nVar.aBL = responsedMessage.getOrginalMessage().getClientLogID();
            d(nVar);
        }
    }

    public void d(com.baidu.tbadk.performanceLog.v vVar) {
        if (vVar != null && com.baidu.tieba.recommendfrs.a.aLJ().getCreateTime() > 0) {
            long ov = com.baidu.tieba.recommendfrs.a.aLJ().ov(1);
            vVar.aBu = com.baidu.tieba.recommendfrs.a.aLJ().getCreateTime();
            vVar.aBB = com.baidu.tieba.recommendfrs.a.aLJ().ou(1);
            vVar.aBC = ov + vVar.aBu;
            vVar.GP();
            com.baidu.tieba.recommendfrs.a.aLJ().setCreateTime(0L);
        }
    }
}
