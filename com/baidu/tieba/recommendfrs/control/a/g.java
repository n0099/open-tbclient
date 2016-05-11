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
    private boolean bri;
    private boolean brj;
    private com.baidu.adp.framework.listener.a cJp;
    private a dZn;
    private String dZo;
    private String dZp;
    private ArrayList<String> dZq;
    private int dZr;
    private CustomMessageListener dZs;
    private CustomMessageListener dZt;
    private CustomMessageListener dZu;

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, DataRes dataRes, boolean z);

        void e(long j, int i, String str);
    }

    public g(com.baidu.adp.base.h<BaseFragmentActivity> hVar, BdUniqueId bdUniqueId) {
        super(hVar);
        this.cJp = new h(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        this.bri = false;
        this.brj = false;
        this.dZr = 0;
        this.dZs = new i(this, CmdConfigCustom.CMD_SET_NU_SEX_GUIDE);
        this.dZt = new j(this, CmdConfigCustom.CMD_SET_NU_AGE_GUIDE);
        this.dZu = new k(this, CmdConfigCustom.CMD_SET_INTEREST_GUIDE);
        setUniqueId(bdUniqueId);
        KL();
        KK();
        registerListener(this.cJp);
        registerListener(this.dZs);
        registerListener(this.dZt);
        registerListener(this.dZu);
    }

    public void a(a aVar) {
        this.dZn = aVar;
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
        if ((!StringUtils.isNull(this.dZo) || !StringUtils.isNull(this.dZp)) && !com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("close_new_user_guide_tip", false)) {
            recPersonalizeRequest.setSexTag(this.dZo);
            recPersonalizeRequest.seAgeTag(this.dZp);
        } else if (this.dZq != null) {
            recPersonalizeRequest.setInterestGuideTag(this.dZq);
        }
        recPersonalizeRequest.setTagType(this.dZr);
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

    private void KK() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.h(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void KL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, com.baidu.tieba.tbadkCore.a.a.ay(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (!this.brj) {
            this.brj = true;
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
            nVar.eM(1005);
            nVar.pageType = 1;
            nVar.axK = false;
            nVar.isSuccess = responsedMessage.hasError() ? false : true;
            nVar.axy = responsedMessage.performanceData.gv;
            nVar.axz = responsedMessage.performanceData.gw;
            nVar.axA = responsedMessage.performanceData.gx;
            nVar.eD = responsedMessage.performanceData.gy;
            nVar.eE = responsedMessage.performanceData.gz;
            nVar.axB = responsedMessage.performanceData.gA;
            nVar.axC = responsedMessage.performanceData.gB;
            nVar.axD = responsedMessage.performanceData.gC;
            nVar.axD += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            nVar.axI = responsedMessage.getDownSize();
            nVar.errCode = responsedMessage.getError();
            nVar.axJ = 0L;
            nVar.sequenceID = ((RecPersonalizeSocketResponse) responsedMessage).sequenceID;
            d(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ResponsedMessage<?> responsedMessage) {
        if (!this.brj) {
            this.brj = true;
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n();
            nVar.eM(1005);
            nVar.pageType = 1;
            nVar.axK = true;
            nVar.isSuccess = responsedMessage.hasError() ? false : true;
            nVar.axy = responsedMessage.performanceData.gv;
            nVar.axz = responsedMessage.performanceData.gw;
            nVar.axA = responsedMessage.performanceData.gx;
            nVar.eD = responsedMessage.performanceData.gy;
            nVar.eE = responsedMessage.performanceData.gz;
            nVar.axB = responsedMessage.performanceData.gA;
            nVar.axC = responsedMessage.performanceData.gB;
            nVar.axD = responsedMessage.performanceData.gC;
            nVar.axD += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            nVar.axL = responsedMessage.performanceData.gF;
            nVar.axM = responsedMessage.performanceData.gG;
            nVar.axI = 0L;
            nVar.axJ = responsedMessage.getDownSize();
            nVar.socketErrNo = responsedMessage.performanceData.gD;
            nVar.socketCostTime = responsedMessage.performanceData.gE;
            nVar.errCode = responsedMessage.getError();
            nVar.axO = responsedMessage.getOrginalMessage().getClientLogID();
            d(nVar);
        }
    }

    public void d(com.baidu.tbadk.performanceLog.v vVar) {
        if (vVar != null && com.baidu.tieba.recommendfrs.a.aLN().getCreateTime() > 0) {
            long ol = com.baidu.tieba.recommendfrs.a.aLN().ol(1);
            vVar.axx = com.baidu.tieba.recommendfrs.a.aLN().getCreateTime();
            vVar.axE = com.baidu.tieba.recommendfrs.a.aLN().ok(1);
            vVar.axF = ol + vVar.axx;
            vVar.EH();
            com.baidu.tieba.recommendfrs.a.aLN().setCreateTime(0L);
        }
    }
}
