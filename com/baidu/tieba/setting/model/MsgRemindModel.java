package com.baidu.tieba.setting.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateForumMask;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateForumMask;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.FriendAndStrangerReqMsg;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.FriendAndStrangerSwitchResMsg;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
/* loaded from: classes5.dex */
public class MsgRemindModel extends BdBaseModel {
    public static final int ACCEPT_MSG = 1;
    public static final int OFFICIAL_PUSH_MSG_ID = 1501754229;
    public static final int SWITCH_ALL = 14;
    public static final int SWITCH_AT_ME = 2;
    public static final int SWITCH_FANS = 3;
    public static final int SWITCH_FRIEND_MSG = 8;
    public static final int SWITCH_GROUP_MSG = 4;
    public static final int SWITCH_OFFICIAL_PUSH_MSG = 6;
    public static final int SWITCH_PRIVATE_MSG = 5;
    public static final int SWITCH_REMIND_FORUM_MSG = 7;
    public static final int SWITCH_REPLY_ME = 1;
    public static final int SWITCH_STRANGER_MSG = 9;
    public static final int SWITCH_TYPE_NUM = 8;
    public static final int SWITCH_YY_MSG = 6;
    public static final int SWITCH_ZAN = 20;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f20987e;

    /* renamed from: f  reason: collision with root package name */
    public e f20988f;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessageListener f20989g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.c.g.c f20990h;
    public d.b.b.c.g.c i;
    public d.b.b.c.g.c j;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            MsgRemindModel.this.f20987e.hideProgressBar();
            if ((httpResponsedMessage instanceof FriendAndStrangerSwitchResMsg) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                FriendAndStrangerReqMsg friendAndStrangerReqMsg = (FriendAndStrangerReqMsg) httpResponsedMessage.getOrginalMessage();
                FriendAndStrangerSwitchResMsg friendAndStrangerSwitchResMsg = (FriendAndStrangerSwitchResMsg) httpResponsedMessage;
                if (friendAndStrangerSwitchResMsg.getError() == 0) {
                    GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE = friendAndStrangerReqMsg.mMaskType;
                }
                int i = friendAndStrangerReqMsg.mMaskType;
                if (i == 3) {
                    MsgRemindModel.this.u(8, friendAndStrangerSwitchResMsg.getError() == 0, false, friendAndStrangerSwitchResMsg.getErrorString());
                } else if (i == 0) {
                    MsgRemindModel.this.u(9, friendAndStrangerSwitchResMsg.getError() == 0, true, friendAndStrangerSwitchResMsg.getErrorString());
                } else if (i == 1) {
                    int i2 = friendAndStrangerReqMsg.mRequestType;
                    if (i2 == 8) {
                        MsgRemindModel.this.u(8, friendAndStrangerSwitchResMsg.getError() == 0, true, friendAndStrangerSwitchResMsg.getErrorString());
                    } else if (i2 == 9) {
                        MsgRemindModel.this.u(9, friendAndStrangerSwitchResMsg.getError() == 0, false, friendAndStrangerSwitchResMsg.getErrorString());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.b.b.c.g.c {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MsgRemindModel.this.f20987e.hideProgressBar();
            if ((socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage();
                MsgRemindModel.this.u(requestUpdateMaskInfoMessage.getMaskType(), responseUpdateMaskInfoMessage.getError() == 0, requestUpdateMaskInfoMessage.isSettingMask(), responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.b.b.c.g.c {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MsgRemindModel.this.f20987e.hideProgressBar();
            if ((socketResponsedMessage instanceof ResponseUpdateMaskMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskMessage)) {
                ResponseUpdateMaskMessage responseUpdateMaskMessage = (ResponseUpdateMaskMessage) socketResponsedMessage;
                MsgRemindModel.this.u(4, responseUpdateMaskMessage.getError() == 0, ((RequestUpdateMaskMessage) socketResponsedMessage.getOrginalMessage()).isSettingMask(), responseUpdateMaskMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d.b.b.c.g.c {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MsgRemindModel.this.f20987e.hideProgressBar();
            if (socketResponsedMessage instanceof ResponseUpdateForumMask) {
                ResponseUpdateForumMask responseUpdateForumMask = (ResponseUpdateForumMask) socketResponsedMessage;
                MsgRemindModel.this.u(7, responseUpdateForumMask.getError() == 0, !((RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage()).getFlag(), responseUpdateForumMask.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(int i, boolean z, boolean z2);
    }

    public MsgRemindModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f20989g = new a(CmdConfigHttp.CMD_FRIEND_AND_STRANGER_MSG_SWITCH);
        this.f20990h = new b(104102);
        this.i = new c(104101);
        this.j = new d(104106);
        this.f20987e = baseActivity;
        registerListener(this.i);
        registerListener(this.f20990h);
        registerListener(this.j);
        registerListener(this.f20989g);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public final void u(int i, boolean z, boolean z2, String str) {
        if (z) {
            BaseActivity baseActivity = this.f20987e;
            baseActivity.showToast(baseActivity.getResources().getString(R.string.success));
            e eVar = this.f20988f;
            if (eVar != null) {
                eVar.a(i, true, z2);
                if (i != 14) {
                    if (d.b.h0.s.d.d.d().o() || d.b.h0.s.d.d.d().p() || d.b.h0.s.d.d.d().r() || d.b.h0.s.d.d.d().t() || d.b.h0.s.d.d.d().w() || d.b.h0.s.d.d.d().n() || d.b.h0.s.d.d.d().z()) {
                        return;
                    }
                    this.f20988f.a(14, true, false);
                    return;
                }
                this.f20988f.a(2, true, z2);
                this.f20988f.a(3, true, z2);
                this.f20988f.a(4, true, z2);
                this.f20988f.a(5, true, z2);
                this.f20988f.a(1, true, z2);
                this.f20988f.a(20, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f20987e.showToast(str);
        } else {
            this.f20987e.showToast(R.string.setdefualt_error);
        }
        e eVar2 = this.f20988f;
        if (eVar2 != null) {
            eVar2.a(i, false, z2);
        }
    }

    public void v(int i, boolean z, e eVar) {
        Message<?> friendAndStrangerReqMsg;
        Message<?> friendAndStrangerReqMsg2;
        if (i == 14 || i == 2 || i == 3 || i == 4 || i == 5 || i == 1 || i == 7 || i == 8 || i == 9 || i == 20 || i == 6) {
            this.f20988f = eVar;
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
            } else if (i == 6) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
                requestUpdateMaskInfoMessage.setMaskType(6);
                requestUpdateMaskInfoMessage.setG_id(1501754229L);
                if (z) {
                    requestUpdateMaskInfoMessage.setIsMask(1);
                } else {
                    requestUpdateMaskInfoMessage.setIsMask(0);
                }
                requestUpdateMaskInfoMessage.setCallFrom(5);
                MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
            } else {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage2 = new RequestUpdateMaskInfoMessage();
                requestUpdateMaskInfoMessage2.setMaskType(i);
                requestUpdateMaskInfoMessage2.setSettingMask(z);
                sendMessage(requestUpdateMaskInfoMessage2);
            }
            this.f20987e.showProgressBar();
        }
    }
}
