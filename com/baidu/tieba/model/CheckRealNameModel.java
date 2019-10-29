package com.baidu.tieba.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.model.message.CheckRealNameHttpResponseMessage;
import com.baidu.tieba.model.message.CheckRealNameRequestNetMessage;
import com.baidu.tieba.model.message.CheckRealNameSocketResponseMessage;
/* loaded from: classes.dex */
public class CheckRealNameModel extends BdBaseModel {
    public static final String TYPE_APP_FIRST_START = "app_first_start";
    public static final String TYPE_LIVE_SHARE = "live_share";
    public static final String TYPE_PB_SHARE = "pb_share";
    private a hwx;
    private com.baidu.adp.framework.listener.a hwy;

    /* loaded from: classes.dex */
    public interface a {
        void b(int i, String str, String str2, Object obj);
    }

    public CheckRealNameModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hwy = new com.baidu.adp.framework.listener.a(1003325, CmdConfigSocket.CMD_CHECK_REAL_NAME) { // from class: com.baidu.tieba.model.CheckRealNameModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if (((responsedMessage instanceof CheckRealNameHttpResponseMessage) || (responsedMessage instanceof CheckRealNameSocketResponseMessage)) && (responsedMessage.getOrginalMessage().getExtra() instanceof CheckRealNameRequestNetMessage)) {
                        CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = (CheckRealNameRequestNetMessage) responsedMessage.getOrginalMessage().getExtra();
                        if (CheckRealNameModel.this.hwx != null) {
                            CheckRealNameModel.this.hwx.b(responsedMessage.getError(), responsedMessage.getErrorString(), checkRealNameRequestNetMessage.getObjSource(), checkRealNameRequestNetMessage.getObjTag());
                        }
                    }
                }
            }
        };
        bMr();
        registerListener(this.hwy);
    }

    private void bMr() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_CHECK_REAL_NAME, CheckRealNameSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_CHECK_REAL_NAME, 1003325, TbConfig.URL_CHECK_REAL_NAME, CheckRealNameHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void zK(String str) {
        CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = new CheckRealNameRequestNetMessage();
        checkRealNameRequestNetMessage.setObjSource(str);
        sendMessage(checkRealNameRequestNetMessage);
    }

    public void m(String str, Object obj) {
        CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = new CheckRealNameRequestNetMessage();
        checkRealNameRequestNetMessage.setObjSource(str);
        checkRealNameRequestNetMessage.setObjTag(obj);
        sendMessage(checkRealNameRequestNetMessage);
    }

    public void a(a aVar) {
        this.hwx = aVar;
    }
}
