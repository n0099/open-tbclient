package com.baidu.tieba.setting.officialAccountPush;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetOfficialSwitch.OfficialList;
/* loaded from: classes8.dex */
public class OfficialAccountPushModel extends BdBaseModel {
    public static int NET_SUCCESS = 0;
    private a nca;
    public List<OfficialList> official_list;
    public ArrayList<OfficialAccountPushInfo> list = new ArrayList<>();
    private com.baidu.adp.framework.listener.a ndW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_OFFICIAL_ACCOUNT_PUSH, 309620) { // from class: com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            OfficialAccountPushHttpResponseMessage officialAccountPushHttpResponseMessage;
            if (responsedMessage instanceof OfficialAccountPushSocketResponseMessage) {
                OfficialAccountPushSocketResponseMessage officialAccountPushSocketResponseMessage = (OfficialAccountPushSocketResponseMessage) responsedMessage;
                if (officialAccountPushSocketResponseMessage != null && officialAccountPushSocketResponseMessage.getList() != null) {
                    OfficialAccountPushModel.this.nca.a(officialAccountPushSocketResponseMessage.getList(), officialAccountPushSocketResponseMessage.getError(), officialAccountPushSocketResponseMessage.getErrorString());
                } else {
                    return;
                }
            }
            if ((responsedMessage instanceof OfficialAccountPushHttpResponseMessage) && (officialAccountPushHttpResponseMessage = (OfficialAccountPushHttpResponseMessage) responsedMessage) != null) {
                OfficialAccountPushModel.this.nca.a(officialAccountPushHttpResponseMessage.getList(), officialAccountPushHttpResponseMessage.getError(), officialAccountPushHttpResponseMessage.getErrorString());
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str);
    }

    public OfficialAccountPushModel(a aVar) {
        this.nca = aVar;
        registerListener(this.ndW);
        com.baidu.tieba.tbadkCore.a.a.c(309620, OfficialAccountPushSocketResponseMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(309620, CmdConfigHttp.CMD_OFFICIAL_ACCOUNT_PUSH, TbConfig.CHECK_OFFICIAL_SWITCH_URL, OfficialAccountPushHttpResponseMessage.class, true, false, true, false);
    }

    public void dKw() {
        sendMessage(new OfficialAccountPushRequestMessage());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        super.cancelMessage();
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ndW);
    }
}
