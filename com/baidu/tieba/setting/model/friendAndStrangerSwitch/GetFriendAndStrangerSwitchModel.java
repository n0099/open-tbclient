package com.baidu.tieba.setting.model.friendAndStrangerSwitch;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.setting.more.MoreActivity;
/* loaded from: classes5.dex */
public class GetFriendAndStrangerSwitchModel extends BdBaseModel<MoreActivity> {
    public static int FRIEND_AND_STRANGER_MASK_TYPE = -1;

    /* renamed from: e  reason: collision with root package name */
    public HttpMessageListener f21000e;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(GetFriendAndStrangerSwitchModel getFriendAndStrangerSwitchModel, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            if ((httpResponsedMessage instanceof GetFriendAndStrangerSwitchResMsg) && (i = ((GetFriendAndStrangerSwitchResMsg) httpResponsedMessage).mMaskType) > -1) {
                GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE = i;
            }
        }
    }

    public GetFriendAndStrangerSwitchModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        a aVar = new a(this, CmdConfigHttp.CMD_GET_FRIEND_AND_STRANGER_MSG_SWITCH);
        this.f21000e = aVar;
        registerListener(aVar);
        LoadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FRIEND_AND_STRANGER_MSG_SWITCH));
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
