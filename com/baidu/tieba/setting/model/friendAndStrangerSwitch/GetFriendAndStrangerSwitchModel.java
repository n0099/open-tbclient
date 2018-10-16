package com.baidu.tieba.setting.model.friendAndStrangerSwitch;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.setting.more.MoreActivity;
/* loaded from: classes3.dex */
public class GetFriendAndStrangerSwitchModel extends BdBaseModel<MoreActivity> {
    public static int FRIEND_AND_STRANGER_MASK_TYPE = -1;
    private HttpMessageListener gNq;

    public GetFriendAndStrangerSwitchModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gNq = new HttpMessageListener(CmdConfigHttp.CMD_GET_FRIEND_AND_STRANGER_MSG_SWITCH) { // from class: com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetFriendAndStrangerSwitchResMsg) {
                    GetFriendAndStrangerSwitchResMsg getFriendAndStrangerSwitchResMsg = (GetFriendAndStrangerSwitchResMsg) httpResponsedMessage;
                    if (getFriendAndStrangerSwitchResMsg.mMaskType > -1) {
                        GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE = getFriendAndStrangerSwitchResMsg.mMaskType;
                    }
                }
            }
        };
        registerListener(this.gNq);
        LoadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FRIEND_AND_STRANGER_MSG_SWITCH));
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
