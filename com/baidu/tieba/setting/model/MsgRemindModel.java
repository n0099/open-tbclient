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
    public BaseActivity f21235e;

    /* renamed from: f  reason: collision with root package name */
    public e f21236f;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessageListener f21237g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.c f21238h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.c f21239i;
    public d.a.c.c.g.c j;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            MsgRemindModel.this.f21235e.hideProgressBar();
            if ((httpResponsedMessage instanceof FriendAndStrangerSwitchResMsg) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                FriendAndStrangerReqMsg friendAndStrangerReqMsg = (FriendAndStrangerReqMsg) httpResponsedMessage.getOrginalMessage();
                FriendAndStrangerSwitchResMsg friendAndStrangerSwitchResMsg = (FriendAndStrangerSwitchResMsg) httpResponsedMessage;
                if (friendAndStrangerSwitchResMsg.getError() == 0) {
                    GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE = friendAndStrangerReqMsg.mMaskType;
                }
                int i2 = friendAndStrangerReqMsg.mMaskType;
                if (i2 == 3) {
                    MsgRemindModel.this.u(8, friendAndStrangerSwitchResMsg.getError() == 0, false, friendAndStrangerSwitchResMsg.getErrorString());
                } else if (i2 == 0) {
                    MsgRemindModel.this.u(9, friendAndStrangerSwitchResMsg.getError() == 0, true, friendAndStrangerSwitchResMsg.getErrorString());
                } else if (i2 == 1) {
                    int i3 = friendAndStrangerReqMsg.mRequestType;
                    if (i3 == 8) {
                        MsgRemindModel.this.u(8, friendAndStrangerSwitchResMsg.getError() == 0, true, friendAndStrangerSwitchResMsg.getErrorString());
                    } else if (i3 == 9) {
                        MsgRemindModel.this.u(9, friendAndStrangerSwitchResMsg.getError() == 0, false, friendAndStrangerSwitchResMsg.getErrorString());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.c.c.g.c {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MsgRemindModel.this.f21235e.hideProgressBar();
            if ((socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage();
                MsgRemindModel.this.u(requestUpdateMaskInfoMessage.getMaskType(), responseUpdateMaskInfoMessage.getError() == 0, requestUpdateMaskInfoMessage.isSettingMask(), responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.a.c.c.g.c {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MsgRemindModel.this.f21235e.hideProgressBar();
            if ((socketResponsedMessage instanceof ResponseUpdateMaskMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskMessage)) {
                ResponseUpdateMaskMessage responseUpdateMaskMessage = (ResponseUpdateMaskMessage) socketResponsedMessage;
                MsgRemindModel.this.u(4, responseUpdateMaskMessage.getError() == 0, ((RequestUpdateMaskMessage) socketResponsedMessage.getOrginalMessage()).isSettingMask(), responseUpdateMaskMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d.a.c.c.g.c {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            MsgRemindModel.this.f21235e.hideProgressBar();
            if (socketResponsedMessage instanceof ResponseUpdateForumMask) {
                ResponseUpdateForumMask responseUpdateForumMask = (ResponseUpdateForumMask) socketResponsedMessage;
                MsgRemindModel.this.u(7, responseUpdateForumMask.getError() == 0, !((RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage()).getFlag(), responseUpdateForumMask.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(int i2, boolean z, boolean z2);
    }

    public MsgRemindModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f21237g = new a(CmdConfigHttp.CMD_FRIEND_AND_STRANGER_MSG_SWITCH);
        this.f21238h = new b(104102);
        this.f21239i = new c(104101);
        this.j = new d(104106);
        this.f21235e = baseActivity;
        registerListener(this.f21239i);
        registerListener(this.f21238h);
        registerListener(this.j);
        registerListener(this.f21237g);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public final void u(int i2, boolean z, boolean z2, String str) {
        if (z) {
            BaseActivity baseActivity = this.f21235e;
            baseActivity.showToast(baseActivity.getResources().getString(R.string.success));
            e eVar = this.f21236f;
            if (eVar != null) {
                eVar.a(i2, true, z2);
                if (i2 != 14) {
                    if (d.a.i0.s.d.d.d().o() || d.a.i0.s.d.d.d().p() || d.a.i0.s.d.d.d().r() || d.a.i0.s.d.d.d().t() || d.a.i0.s.d.d.d().w() || d.a.i0.s.d.d.d().n() || d.a.i0.s.d.d.d().z()) {
                        return;
                    }
                    this.f21236f.a(14, true, false);
                    return;
                }
                this.f21236f.a(2, true, z2);
                this.f21236f.a(3, true, z2);
                this.f21236f.a(4, true, z2);
                this.f21236f.a(5, true, z2);
                this.f21236f.a(1, true, z2);
                this.f21236f.a(20, true, z2);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f21235e.showToast(str);
        } else {
            this.f21235e.showToast(R.string.setdefualt_error);
        }
        e eVar2 = this.f21236f;
        if (eVar2 != null) {
            eVar2.a(i2, false, z2);
        }
    }

    public void v(int i2, boolean z, e eVar) {
        Message<?> friendAndStrangerReqMsg;
        Message<?> friendAndStrangerReqMsg2;
        if (i2 == 14 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 1 || i2 == 7 || i2 == 8 || i2 == 9 || i2 == 20 || i2 == 6) {
            this.f21236f = eVar;
            if (i2 == 4) {
                RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
                requestUpdateMaskMessage.setSettingMask(z);
                sendMessage(requestUpdateMaskMessage);
            } else if (i2 == 7) {
                RequestUpdateForumMask requestUpdateForumMask = new RequestUpdateForumMask();
                requestUpdateForumMask.setType(1);
                requestUpdateForumMask.setFlag(z);
                sendMessage(requestUpdateForumMask);
            } else if (i2 == 8) {
                if (z) {
                    friendAndStrangerReqMsg2 = new FriendAndStrangerReqMsg(1, i2);
                } else {
                    friendAndStrangerReqMsg2 = new FriendAndStrangerReqMsg(3, i2);
                }
                sendMessage(friendAndStrangerReqMsg2);
            } else if (i2 == 9) {
                if (z) {
                    friendAndStrangerReqMsg = new FriendAndStrangerReqMsg(0, i2);
                } else {
                    friendAndStrangerReqMsg = new FriendAndStrangerReqMsg(1, i2);
                }
                sendMessage(friendAndStrangerReqMsg);
            } else if (i2 == 6) {
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
                requestUpdateMaskInfoMessage2.setMaskType(i2);
                requestUpdateMaskInfoMessage2.setSettingMask(z);
                sendMessage(requestUpdateMaskInfoMessage2);
            }
            this.f21235e.showProgressBar();
        }
    }
}
