package com.baidu.tieba.lego.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import tbclient.Lego.DataRes;
/* loaded from: classes2.dex */
public class LegoPageModel extends BdBaseModel {
    private a gLx;
    private com.baidu.adp.framework.listener.a mNetMessageListener;

    /* loaded from: classes2.dex */
    public interface a {
        void a(long j, String str, DataRes dataRes, boolean z, int i);

        void b(long j, String str, int i, String str2);

        void b(long j, String str, DataRes dataRes, boolean z);
    }

    public LegoPageModel(e eVar, BdUniqueId bdUniqueId) {
        super(eVar);
        this.mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ENTERTAINMENT, 309312) { // from class: com.baidu.tieba.lego.model.LegoPageModel.1
            /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
            @Override // com.baidu.adp.framework.listener.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                int i;
                boolean z2;
                if (responsedMessage != null && LegoPageModel.this.gLx != null) {
                    String str = "";
                    if (responsedMessage.getOrginalMessage() != null) {
                        Object extra = responsedMessage.getOrginalMessage().getExtra();
                        if (extra instanceof LegoPageRequest) {
                            LegoPageRequest legoPageRequest = (LegoPageRequest) extra;
                            long tagCode = legoPageRequest.getTagCode();
                            str = legoPageRequest.getItemId();
                            i = legoPageRequest.getPn();
                            boolean z3 = legoPageRequest.getPn() == 1;
                            z = legoPageRequest.getPageType() == 2;
                            z2 = z3;
                            j = tagCode;
                            if (responsedMessage.getError() == 0) {
                                LegoPageModel.this.gLx.b(j, str, responsedMessage.getError(), responsedMessage.getErrorString());
                                return;
                            }
                            DataRes dataRes = null;
                            if (responsedMessage instanceof LegoSocketResponse) {
                                dataRes = ((LegoSocketResponse) responsedMessage).getResultData();
                            } else if (responsedMessage instanceof LegoHttpResponse) {
                                dataRes = ((LegoHttpResponse) responsedMessage).getResultData();
                            }
                            if (!z) {
                                LegoPageModel.this.gLx.b(j, str, dataRes, z2);
                            } else {
                                if (z2 && dataRes != null) {
                                    com.baidu.tbadk.core.c.a.aaW().lu("tb.lego_update").f(j + "_" + (TextUtils.isEmpty(str) ? "" : str), dataRes.toByteArray());
                                }
                                LegoPageModel.this.gLx.a(j, str, dataRes, z2, i);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016455, dataRes));
                            return;
                        }
                    }
                    z = false;
                    j = 0;
                    i = 1;
                    z2 = false;
                    if (responsedMessage.getError() == 0) {
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        aOR();
        this.mNetMessageListener.getSocketMessageListener().setSelfListener(true);
        this.mNetMessageListener.getHttpMessageListener().setSelfListener(true);
        registerListener(this.mNetMessageListener);
    }

    public void a(a aVar) {
        this.gLx = aVar;
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
        com.baidu.tieba.lego.c.e o = com.baidu.tieba.lego.c.e.o(j, str);
        if (o != null) {
            legoPageRequest.setRn(o.rn);
            legoPageRequest.setParams(o.params);
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

    private void aOR() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ENTERTAINMENT, com.baidu.tieba.tbadkCore.a.a.br(TbConfig.ENTERTAINMENT_ADDRESS, 309312));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(LegoHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
