package com.baidu.tieba.lego.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.lego.c.e;
import tbclient.Lego.DataRes;
/* loaded from: classes8.dex */
public class LegoPageModel extends BdBaseModel {
    private com.baidu.adp.framework.listener.a eBn;
    private a kYa;

    /* loaded from: classes8.dex */
    public interface a {
        void a(long j, String str, DataRes dataRes, boolean z, int i);

        void b(long j, String str, int i, String str2);

        void b(long j, String str, DataRes dataRes, boolean z);
    }

    public LegoPageModel(f fVar, BdUniqueId bdUniqueId) {
        super(fVar);
        this.eBn = new com.baidu.adp.framework.listener.a(1003079, CmdConfigSocket.CMD_ENTERTAINMENT) { // from class: com.baidu.tieba.lego.model.LegoPageModel.1
            /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
            @Override // com.baidu.adp.framework.listener.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                int i;
                boolean z;
                boolean z2;
                if (responsedMessage != null && LegoPageModel.this.kYa != null) {
                    long j = 0;
                    String str = "";
                    if (responsedMessage.getOrginalMessage() != null) {
                        Object extra = responsedMessage.getOrginalMessage().getExtra();
                        if (extra instanceof LegoPageRequest) {
                            LegoPageRequest legoPageRequest = (LegoPageRequest) extra;
                            j = legoPageRequest.getTagCode();
                            str = legoPageRequest.getItemId();
                            i = legoPageRequest.getPn();
                            boolean z3 = legoPageRequest.getPn() == 1;
                            z = legoPageRequest.getPageType() == 2;
                            z2 = z3;
                            if (responsedMessage.getError() == 0) {
                                LegoPageModel.this.kYa.b(j, str, responsedMessage.getError(), responsedMessage.getErrorString());
                                return;
                            }
                            DataRes dataRes = null;
                            if (responsedMessage instanceof LegoSocketResponse) {
                                dataRes = ((LegoSocketResponse) responsedMessage).getResultData();
                            } else if (responsedMessage instanceof LegoHttpResponse) {
                                dataRes = ((LegoHttpResponse) responsedMessage).getResultData();
                            }
                            if (!z) {
                                LegoPageModel.this.kYa.b(j, str, dataRes, z2);
                            } else {
                                if (z2 && dataRes != null) {
                                    com.baidu.tbadk.core.c.a.bpZ().Aa("tb.lego_update").asyncSetForever(j + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (TextUtils.isEmpty(str) ? "" : str), dataRes.toByteArray());
                                }
                                LegoPageModel.this.kYa.a(j, str, dataRes, z2, i);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_LOAD_DATA_SUCCESS, dataRes));
                            return;
                        }
                    }
                    i = 1;
                    z = false;
                    z2 = false;
                    if (responsedMessage.getError() == 0) {
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        bqN();
        this.eBn.getSocketMessageListener().setSelfListener(true);
        this.eBn.getHttpMessageListener().setSelfListener(true);
        registerListener(this.eBn);
    }

    public void a(a aVar) {
        this.kYa = aVar;
    }

    public void b(int i, long j, String str, int i2, String str2) {
        LegoPageRequest legoPageRequest = new LegoPageRequest();
        legoPageRequest.setNetType(NetMessage.NetType.HTTP);
        legoPageRequest.setTag(getUniqueId());
        legoPageRequest.setPn(i2);
        legoPageRequest.setItemId(str);
        legoPageRequest.setLastRank(str2);
        legoPageRequest.setTagCode(j);
        legoPageRequest.setPageType(i);
        e u = e.u(j, str);
        if (u != null) {
            legoPageRequest.setRn(u.rn);
            legoPageRequest.setParams(u.params);
        }
        legoPageRequest.getHttpMessage().addParam("page_id", j);
        sendMessage(legoPageRequest);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    private void bqN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003079, com.baidu.tieba.tbadkCore.a.a.bU(TbConfig.ENTERTAINMENT_ADDRESS, CmdConfigSocket.CMD_ENTERTAINMENT));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(LegoHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
