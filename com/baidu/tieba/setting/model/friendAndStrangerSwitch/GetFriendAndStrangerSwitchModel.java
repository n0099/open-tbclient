package com.baidu.tieba.setting.model.friendAndStrangerSwitch;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.more.MoreActivity;
/* loaded from: classes13.dex */
public class GetFriendAndStrangerSwitchModel extends BdBaseModel<MoreActivity> {
    public static int FRIEND_AND_STRANGER_MASK_TYPE = -1;
    private HttpMessageListener jTs;

    public GetFriendAndStrangerSwitchModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jTs = new HttpMessageListener(1003319) { // from class: com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel.1
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
        registerListener(this.jTs);
        LoadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        sendMessage(new HttpMessage(1003319));
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
