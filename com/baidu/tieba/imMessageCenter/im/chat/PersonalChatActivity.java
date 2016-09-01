package com.baidu.tieba.imMessageCenter.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.e.a;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.al;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestNewFriendDataMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.stranger.c;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    private com.baidu.tbadk.coreExtra.relationship.b dmT;
    private PersonalMsglistModel dmV;
    private PersonalChatView dmW;
    private UserData mUser;
    private CustomMessageListener dmR = new a(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private Handler mHandler = new Handler();
    private long dmS = 0;
    private String dmU = TbadkCoreApplication.getCurrentAccount();
    private Runnable dmX = new d(this);
    private CustomMessageListener dmY = new e(this, CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    private com.baidu.adp.framework.listener.e dmZ = new f(this, 205101, true);
    private CustomMessageListener dna = new g(this, 0);
    private a.InterfaceC0005a locationCallBack = new h(this);
    private boolean dnb = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void aqk() {
        awI();
        super.aqk();
    }

    private void awI() {
        boolean z;
        ChatMessage chatMessage;
        boolean z2;
        ChatMessage chatMessage2;
        List<ChatMessage> chatMessages = this.cUl.getData().getChatMessages();
        Iterator<ChatMessage> it = chatMessages.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            chatMessage = it.next();
            if (chatMessage.getMsgType() == 23) {
                if (chatMessage.getLocalData().getStatus().shortValue() != 3) {
                    z = false;
                }
            }
        }
        chatMessage = null;
        z = true;
        if (!z) {
            chatMessage.setSt_type("aio");
            this.cUl.doSendText(chatMessage);
        }
        Iterator<ChatMessage> it2 = chatMessages.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            chatMessage2 = it2.next();
            if (chatMessage2.getMsgType() == 26) {
                if (chatMessage2.getLocalData().getStatus().shortValue() != 3) {
                    z2 = false;
                }
            }
        }
        chatMessage2 = null;
        z2 = true;
        if (!z2) {
            this.cUl.doSendText(chatMessage2);
        }
    }

    public long ma(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        if (str.contains("分钟") || str.contains("刚刚")) {
            return TbConfig.USE_TIME_INTERVAL;
        }
        if (str.contains("小时")) {
            return 3600000L;
        }
        return str.contains("天") ? 86400000L : 0L;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void apu() {
        UserData user;
        super.apu();
        if ((this.cUl instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.cUl).getUser()) != null) {
            com.baidu.tbadk.util.u.b(new i(this, user), new j(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ChatStatusManager.getInst().setIsOpen(0, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.dnb) {
            this.dnb = true;
            awJ();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.yA().er(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.cUl != null && (this.cUl instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.cUl).ayJ();
        }
    }

    private void awJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tbadk.util.u.b(new k(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.cUk = new PersonalChatView(this, this.cUl.getIsAcceptNotify());
        this.cUk.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.dmW = (PersonalChatView) this.cUk;
        int i = com.baidu.tieba.im.c.a.dks;
        if ((this.cUl instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cUl).getUser()) != null) {
            this.mUser = user;
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm().mm(this.mUser.getUserId());
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm().mi(this.mUser.getUserId());
            this.cUk.refreshPersonalHeadFooter(this.mUser.getUserName(), this.dmT);
            this.cUk.bindDataAndRefresh(this.cUl.getData(), i);
            this.cUk.setRecordCallback(new b(this));
            if (!awN()) {
                awL();
            }
            if (!TextUtils.isEmpty(this.dmV.ayH())) {
                this.dmV.mv(this.dmV.ayH());
            }
            String ayI = this.dmV.ayI();
            if (!TextUtils.isEmpty(ayI)) {
                this.dmV.mw(ayI);
            }
        }
    }

    public PersonalMsglistModel awK() {
        return this.dmV;
    }

    private void awL() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.cUk.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.cUl instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cUl).getUser()) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.dmW.awR()) {
            if (this.dmV.ayK() == PersonalMsglistModel.CardStatus.APPLY || this.dmV.ayK() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.dmV.getUser().getUserId(), this.dmV.getUser().getUserName(), this.dmV.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.dmV.ayK() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.FA().b(com.baidu.adp.lib.h.b.c(this.dmV.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    public void awM() {
        if (TbadkCoreApplication.m9getInst().getLocationShared()) {
            String str = String.valueOf(this.dmU) + "&" + this.mUser.getUserId();
            if (!PersonalChatActivityStatic.awO().mb(str)) {
                com.baidu.adp.lib.e.a.dU().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b mc = PersonalChatActivityStatic.awO().mc(str);
            this.cUk.refreshPersonalHeadFooter(this.mUser.getUserName(), mc);
            this.dmS = ma(ba.r(mc.getTime()));
            if (this.dmS != 0) {
                this.mHandler.postDelayed(this.dmX, this.dmS);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean k(Bundle bundle) {
        try {
            registerListener(this.dmZ);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.dna);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.dna);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.dna);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.dna);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.dna);
            registerListener(this.dmY);
            registerListener(this.dmR);
            if (PersonalChatActivityStatic.awO() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.cUl = new PersonalMsglistModel(this);
            this.cUl.setLoadDataCallBack(this.cUw);
            this.dmV = (PersonalMsglistModel) this.cUl;
            if (bundle != null) {
                i(bundle);
            } else {
                apv();
            }
            return apw();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        this.cUl.loadFirst(alVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a mx;
        ChatMessage msg;
        String G;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.cUl.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (aqj() && (msg = this.cUl.getMsg(i2)) != null && com.baidu.tieba.im.util.h.q(msg) && (G = com.baidu.tieba.im.util.h.G(msg.getContent(), true)) != null && (this.cUl instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.cUl).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), G, ((CommonPersonalMsglistModel) this.cUl).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.cUl.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (mx = com.baidu.tieba.imMessageCenter.im.stranger.c.mx(msg3.getContent())) != null) {
                    if (mx.threadType == 33) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), mx.threadId).oW()));
                        return;
                    } else if (mx.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(mx.threadId, mx.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(mx.threadId, mx.postId, null)));
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void j(Bundle bundle) {
        super.j(bundle);
        apB();
        ((PersonalMsglistModel) this.cUl).setIsFriend(bundle.getInt("key_is_friend"));
        ((PersonalMsglistModel) this.cUl).mt(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
        ((PersonalMsglistModel) this.cUl).mu(bundle.getString(PersonalChatActivityConfig.KEY_ECOMM_INFO));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void q(Intent intent) {
        super.q(intent);
        apB();
        ((PersonalMsglistModel) this.cUl).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        ((PersonalMsglistModel) this.cUl).mt(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
        ((PersonalMsglistModel) this.cUl).mu(intent.getStringExtra(PersonalChatActivityConfig.KEY_ECOMM_INFO));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("key_is_friend", ((PersonalMsglistModel) this.cUl).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.cUl).ayH());
        bundle.putString(PersonalChatActivityConfig.KEY_ECOMM_INFO, ((PersonalMsglistModel) this.cUl).ayI());
    }

    private void apB() {
        if (this.cUl == null || !(this.cUl instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.cUl).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void apz() {
        super.apz();
        this.handler.postDelayed(new c(this), 60L);
        awM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apA() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.cUl.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.cUl.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean awN() {
        return ((PersonalMsglistModel) this.cUl).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm().mj(this.mUser.getUserId());
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dmX);
        }
        com.baidu.adp.lib.e.a.dU().a(this.locationCallBack);
    }
}
