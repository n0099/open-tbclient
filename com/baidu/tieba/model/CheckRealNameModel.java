package com.baidu.tieba.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.model.message.CheckRealNameHttpResponseMessage;
import com.baidu.tieba.model.message.CheckRealNameRequestNetMessage;
import com.baidu.tieba.model.message.CheckRealNameSocketResponseMessage;
/* loaded from: classes.dex */
public class CheckRealNameModel extends BdBaseModel {
    public static final String TYPE_APP_FIRST_START = "app_first_start";
    public static final String TYPE_LIVE_SHARE = "live_share";
    public static final String TYPE_PB_SHARE = "pb_share";
    private a ecv;
    private com.baidu.adp.framework.listener.a ecw;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, String str2, Object obj);
    }

    public CheckRealNameModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ecw = new com.baidu.tieba.model.a(this, CmdConfigHttp.CMD_CHECK_REAL_NAME, 309456);
        aHS();
        registerListener(this.ecw);
    }

    private void aHS() {
        com.baidu.tieba.tbadkCore.a.a.a(309456, CheckRealNameSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309456, CmdConfigHttp.CMD_CHECK_REAL_NAME, TbConfig.URL_CHECK_REAL_NAME, CheckRealNameHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void nC(String str) {
        CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = new CheckRealNameRequestNetMessage();
        checkRealNameRequestNetMessage.setObjSource(str);
        sendMessage(checkRealNameRequestNetMessage);
    }

    public void p(String str, Object obj) {
        CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = new CheckRealNameRequestNetMessage();
        checkRealNameRequestNetMessage.setObjSource(str);
        checkRealNameRequestNetMessage.setObjTag(obj);
        sendMessage(checkRealNameRequestNetMessage);
    }

    public void aHT() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_CHECK_REAL_NAME, getUniqueId());
        MessageManager.getInstance().removeMessage(309456, getUniqueId());
    }

    public void a(a aVar) {
        this.ecv = aVar;
    }
}
