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
import com.baidu.tbadk.core.util.ay;
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
/* loaded from: classes.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    private com.baidu.tbadk.coreExtra.relationship.b csb;
    private PersonalMsglistModel csd;
    private PersonalChatView cse;
    private UserData mUser;
    private CustomMessageListener crZ = new a(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private Handler mHandler = new Handler();
    private long csa = 0;
    private String csc = TbadkCoreApplication.getCurrentAccount();
    private Runnable csf = new d(this);
    private CustomMessageListener csg = new e(this, CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    private com.baidu.adp.framework.listener.e csh = new f(this, 205101, true);
    private CustomMessageListener csi = new g(this, 0);
    private a.InterfaceC0005a locationCallBack = new h(this);
    private boolean csj = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void acw() {
        boolean z;
        ChatMessage chatMessage;
        Iterator<ChatMessage> it = this.cac.getData().getChatMessages().iterator();
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
            this.cac.doSendText(chatMessage);
        }
        super.acw();
    }

    public long jO(String str) {
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
    protected void abI() {
        UserData user;
        super.abI();
        if ((this.cac instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.cac).getUser()) != null) {
            com.baidu.tbadk.util.q.b(new i(this, user), new j(this));
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
        if (!this.csj) {
            this.csj = true;
            aiM();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.zp().eo(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.cac != null && (this.cac instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.cac).akO();
        }
    }

    private void aiM() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tbadk.util.q.b(new k(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.cab = new PersonalChatView(this, this.cac.getIsAcceptNotify());
        this.cab.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.cse = (PersonalChatView) this.cab;
        int i = com.baidu.tieba.im.c.a.cpB;
        if ((this.cac instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cac).getUser()) != null) {
            this.mUser = user;
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq().ka(this.mUser.getUserId());
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq().jW(this.mUser.getUserId());
            this.cab.refreshPersonalHeadFooter(this.mUser.getUserName(), this.csb);
            this.cab.bindDataAndRefresh(this.cac.getData(), i);
            this.cab.setRecordCallback(new b(this));
            if (!aiQ()) {
                aiO();
            }
            if (!TextUtils.isEmpty(this.csd.akN())) {
                this.csd.ki(this.csd.akN());
            }
        }
    }

    public PersonalMsglistModel aiN() {
        return this.csd;
    }

    private void aiO() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.cab.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.cac instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cac).getUser()) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.cse.aiU()) {
            if (this.csd.akP() == PersonalMsglistModel.CardStatus.APPLY || this.csd.akP() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.csd.getUser().getUserId(), this.csd.getUser().getUserName(), this.csd.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.csd.akP() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.Gf().b(com.baidu.adp.lib.h.b.c(this.csd.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    public void aiP() {
        if (TbadkCoreApplication.m411getInst().getLocationShared()) {
            String str = String.valueOf(this.csc) + "&" + this.mUser.getUserId();
            if (!PersonalChatActivityStatic.aiR().jP(str)) {
                com.baidu.adp.lib.e.a.gL().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b jQ = PersonalChatActivityStatic.aiR().jQ(str);
            this.cab.refreshPersonalHeadFooter(this.mUser.getUserName(), jQ);
            this.csa = jO(ay.v(jQ.getTime()));
            if (this.csa != 0) {
                this.mHandler.postDelayed(this.csf, this.csa);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean l(Bundle bundle) {
        try {
            registerListener(this.csh);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.csi);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.csi);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.csi);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.csi);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.csi);
            registerListener(this.csg);
            registerListener(this.crZ);
            if (PersonalChatActivityStatic.aiR() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.cac = new PersonalMsglistModel(this);
            this.cac.setLoadDataCallBack(this.can);
            this.csd = (PersonalMsglistModel) this.cac;
            if (bundle != null) {
                j(bundle);
            } else {
                abJ();
            }
            return abK();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        this.cac.loadFirst(alVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a kj;
        ChatMessage msg;
        String z;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.cac.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (KK() && (msg = this.cac.getMsg(i2)) != null && com.baidu.tieba.im.util.h.p(msg) && (z = com.baidu.tieba.im.util.h.z(msg.getContent(), true)) != null && (this.cac instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.cac).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), z, ((CommonPersonalMsglistModel) this.cac).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.cac.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (kj = com.baidu.tieba.imMessageCenter.im.stranger.c.kj(msg3.getContent())) != null) {
                    if (kj.threadType == 33) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), kj.threadId).qT()));
                        return;
                    } else if (kj.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(kj.threadId, kj.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(kj.threadId, kj.postId, null)));
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void k(Bundle bundle) {
        super.k(bundle);
        abO();
        ((PersonalMsglistModel) this.cac).setIsFriend(bundle.getInt("key_is_friend"));
        ((PersonalMsglistModel) this.cac).kh(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void m(Intent intent) {
        super.m(intent);
        abO();
        ((PersonalMsglistModel) this.cac).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        ((PersonalMsglistModel) this.cac).kh(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("key_is_friend", ((PersonalMsglistModel) this.cac).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.cac).akN());
    }

    private void abO() {
        if (this.cac == null || !(this.cac instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.cac).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void abM() {
        super.abM();
        this.handler.postDelayed(new c(this), 60L);
        aiP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abN() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.cac.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.cac.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean aiQ() {
        return ((PersonalMsglistModel) this.cac).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq().jX(this.mUser.getUserId());
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.csf);
        }
        com.baidu.adp.lib.e.a.gL().a(this.locationCallBack);
    }
}
