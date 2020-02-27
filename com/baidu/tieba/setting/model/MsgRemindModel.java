package com.baidu.tieba.setting.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.message.RequestUpdateForumMask;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateForumMask;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskMessage;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.FriendAndStrangerReqMsg;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.FriendAndStrangerSwitchResMsg;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
/* loaded from: classes13.dex */
public class MsgRemindModel extends BdBaseModel {
    public static final int SWITCH_ALL = 14;
    public static final int SWITCH_AT_ME = 2;
    public static final int SWITCH_FANS = 3;
    public static final int SWITCH_FRIEND_MSG = 8;
    public static final int SWITCH_GROUP_MSG = 4;
    public static final int SWITCH_PRIVATE_MSG = 5;
    public static final int SWITCH_REMIND_FORUM_MSG = 7;
    public static final int SWITCH_REPLY_ME = 1;
    public static final int SWITCH_STRANGER_MSG = 9;
    public static final int SWITCH_TYPE_NUM = 8;
    public static final int SWITCH_YY_MSG = 6;
    public static final int SWITCH_ZAN = 20;
    private BaseActivity jRr;
    private a jRs;
    private HttpMessageListener jRt;
    private c jRu;
    private c jRv;
    private c jRw;

    /* loaded from: classes13.dex */
    public interface a {
        void h(int i, boolean z, boolean z2);
    }

    public MsgRemindModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jRt = new HttpMessageListener(1003318) { // from class: com.baidu.tieba.setting.model.MsgRemindModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                MsgRemindModel.this.jRr.hideProgressBar();
                if ((httpResponsedMessage instanceof FriendAndStrangerSwitchResMsg) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                    FriendAndStrangerReqMsg friendAndStrangerReqMsg = (FriendAndStrangerReqMsg) httpResponsedMessage.getOrginalMessage();
                    FriendAndStrangerSwitchResMsg friendAndStrangerSwitchResMsg = (FriendAndStrangerSwitchResMsg) httpResponsedMessage;
                    if (friendAndStrangerSwitchResMsg.getError() == 0) {
                        GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE = friendAndStrangerReqMsg.mMaskType;
                    }
                    if (friendAndStrangerReqMsg.mMaskType == 3) {
                        MsgRemindModel.this.a(8, friendAndStrangerSwitchResMsg.getError() == 0, false, friendAndStrangerSwitchResMsg.getErrorString());
                    } else if (friendAndStrangerReqMsg.mMaskType == 0) {
                        MsgRemindModel.this.a(9, friendAndStrangerSwitchResMsg.getError() == 0, true, friendAndStrangerSwitchResMsg.getErrorString());
                    } else if (friendAndStrangerReqMsg.mMaskType == 1) {
                        if (friendAndStrangerReqMsg.mRequestType == 8) {
                            MsgRemindModel.this.a(8, friendAndStrangerSwitchResMsg.getError() == 0, true, friendAndStrangerSwitchResMsg.getErrorString());
                        } else if (friendAndStrangerReqMsg.mRequestType == 9) {
                            MsgRemindModel.this.a(9, friendAndStrangerSwitchResMsg.getError() == 0, false, friendAndStrangerSwitchResMsg.getErrorString());
                        }
                    }
                }
            }
        };
        this.jRu = new c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.setting.model.MsgRemindModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                MsgRemindModel.this.jRr.hideProgressBar();
                if ((socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage();
                    MsgRemindModel.this.a(requestUpdateMaskInfoMessage.getMaskType(), responseUpdateMaskInfoMessage.getError() == 0, requestUpdateMaskInfoMessage.isSettingMask(), responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        };
        this.jRv = new c(CmdConfigSocket.CMD_UPDATE_MASK) { // from class: com.baidu.tieba.setting.model.MsgRemindModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                MsgRemindModel.this.jRr.hideProgressBar();
                if ((socketResponsedMessage instanceof ResponseUpdateMaskMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskMessage)) {
                    ResponseUpdateMaskMessage responseUpdateMaskMessage = (ResponseUpdateMaskMessage) socketResponsedMessage;
                    MsgRemindModel.this.a(4, responseUpdateMaskMessage.getError() == 0, ((RequestUpdateMaskMessage) socketResponsedMessage.getOrginalMessage()).isSettingMask(), responseUpdateMaskMessage.getErrorString());
                }
            }
        };
        this.jRw = new c(CmdConfigSocket.CMD_UPDATE_FORUM_MAST_STAT) { // from class: com.baidu.tieba.setting.model.MsgRemindModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                MsgRemindModel.this.jRr.hideProgressBar();
                if (socketResponsedMessage instanceof ResponseUpdateForumMask) {
                    ResponseUpdateForumMask responseUpdateForumMask = (ResponseUpdateForumMask) socketResponsedMessage;
                    MsgRemindModel.this.a(7, responseUpdateForumMask.getError() == 0, !((RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage()).getFlag(), responseUpdateForumMask.getErrorString());
                }
            }
        };
        this.jRr = baseActivity;
        registerListener(this.jRv);
        registerListener(this.jRu);
        registerListener(this.jRw);
        registerListener(this.jRt);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(int i, boolean z, a aVar) {
        Message<?> friendAndStrangerReqMsg;
        Message<?> friendAndStrangerReqMsg2;
        if (i == 14 || i == 2 || i == 3 || i == 4 || i == 5 || i == 1 || i == 7 || i == 8 || i == 9 || i == 20) {
            this.jRs = aVar;
            if (i == 4) {
                RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
                requestUpdateMaskMessage.setSettingMask(z);
                sendMessage(requestUpdateMaskMessage);
            } else if (i == 7) {
                RequestUpdateForumMask requestUpdateForumMask = new RequestUpdateForumMask();
                requestUpdateForumMask.setType(1);
                requestUpdateForumMask.setFlag(z);
                sendMessage(requestUpdateForumMask);
            } else if (i == 8) {
                if (z) {
                    friendAndStrangerReqMsg2 = new FriendAndStrangerReqMsg(1, i);
                } else {
                    friendAndStrangerReqMsg2 = new FriendAndStrangerReqMsg(3, i);
                }
                sendMessage(friendAndStrangerReqMsg2);
            } else if (i == 9) {
                if (z) {
                    friendAndStrangerReqMsg = new FriendAndStrangerReqMsg(0, i);
                } else {
                    friendAndStrangerReqMsg = new FriendAndStrangerReqMsg(1, i);
                }
                sendMessage(friendAndStrangerReqMsg);
            } else {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
                requestUpdateMaskInfoMessage.setMaskType(i);
                requestUpdateMaskInfoMessage.setSettingMask(z);
                sendMessage(requestUpdateMaskInfoMessage);
            }
            this.jRr.showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, boolean z2, String str) {
        if (z) {
            this.jRr.showToast(this.jRr.getResources().getString(R.string.success));
            if (this.jRs != null) {
                this.jRs.h(i, true, z2);
                if (i != 14) {
                    if (!d.aLj().aLo() && !d.aLj().aLr() && !d.aLj().aLp() && !d.aLj().aLq() && !d.aLj().aLA() && !d.aLj().aLz() && !d.aLj().aLn()) {
                        this.jRs.h(14, true, false);
                        return;
                    }
                    return;
                }
                this.jRs.h(2, true, z2);
                this.jRs.h(3, true, z2);
                this.jRs.h(4, true, z2);
                this.jRs.h(5, true, z2);
                this.jRs.h(1, true, z2);
                this.jRs.h(20, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.jRr.showToast(str);
        } else {
            this.jRr.showToast(R.string.setdefualt_error);
        }
        if (this.jRs != null) {
            this.jRs.h(i, false, z2);
        }
    }
}
