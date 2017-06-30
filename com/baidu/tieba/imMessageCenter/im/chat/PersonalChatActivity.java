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
import com.baidu.adp.lib.d.a;
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
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestNewFriendDataMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.stranger.c;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    private com.baidu.tbadk.coreExtra.relationship.b dqK;
    private PersonalMsglistModel dqM;
    private PersonalChatView dqN;
    private UserData mUser;
    private CustomMessageListener dqI = new a(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private Handler mHandler = new Handler();
    private long dqJ = 0;
    private String dqL = TbadkCoreApplication.getCurrentAccount();
    private Runnable dqO = new d(this);
    private CustomMessageListener dqP = new e(this, CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    private com.baidu.adp.framework.listener.e dqQ = new f(this, 205101, true);
    private CustomMessageListener dqR = new g(this, 0);
    private a.InterfaceC0004a locationCallBack = new h(this);
    private boolean dqS = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void aqh() {
        awC();
        super.aqh();
    }

    private void awC() {
        boolean z;
        ChatMessage chatMessage;
        Iterator<ChatMessage> it = this.cYh.getData().getChatMessages().iterator();
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
            this.cYh.doSendText(chatMessage);
        }
    }

    public long ml(String str) {
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
        if ((this.cYh instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.cYh).getUser()) != null) {
            x.b(new i(this, user), new j(this));
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
        if (!this.dqS) {
            this.dqS = true;
            awD();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.yG().eD(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.cYh != null && (this.cYh instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.cYh).axu();
        }
    }

    private void awD() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        x.b(new k(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.cYg = new PersonalChatView(this, this.cYh.getIsAcceptNotify());
        this.cYg.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.dqN = (PersonalChatView) this.cYg;
        int i = com.baidu.tieba.im.sendmessage.a.dof;
        if ((this.cYh instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cYh).getUser()) != null) {
            this.mUser = user;
            this.cYg.refreshPersonalHeadFooter(this.mUser.getName_show(), this.dqK);
            this.cYg.bindDataAndRefresh(this.cYh.getData(), i);
            this.cYg.setRecordCallback(new b(this));
            if (!awG()) {
                awF();
            }
            if (!TextUtils.isEmpty(this.dqM.axt())) {
                this.dqM.mp(this.dqM.axt());
            }
        }
    }

    public PersonalMsglistModel awE() {
        return this.dqM;
    }

    private void awF() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.cYg.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.cYh instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cYh).getUser()) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.dqN.awK()) {
            if (this.dqM.axv() == PersonalMsglistModel.CardStatus.APPLY || this.dqM.axv() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.dqM.getUser().getUserId(), this.dqM.getUser().getUserName(), this.dqM.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.dqM.axv() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.b(com.baidu.adp.lib.g.b.c(this.dqM.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean l(Bundle bundle) {
        try {
            registerListener(this.dqQ);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.dqR);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.dqR);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.dqR);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.dqR);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.dqR);
            registerListener(this.dqP);
            registerListener(this.dqI);
            if (PersonalChatActivityStatic.awH() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.cYh = new PersonalMsglistModel(this);
            this.cYh.setLoadDataCallBack(this.cYs);
            this.dqM = (PersonalMsglistModel) this.cYh;
            if (bundle != null) {
                j(bundle);
            } else {
                apv();
            }
            return apw();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(ak akVar) {
        this.cYh.loadFirst(akVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        c.a mq;
        ChatMessage msg;
        String K;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.cYh.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (aqg() && (msg = this.cYh.getMsg(i2)) != null && com.baidu.tieba.im.util.h.q(msg) && (K = com.baidu.tieba.im.util.h.K(msg.getContent(), true)) != null && (this.cYh instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.cYh).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), K, ((CommonPersonalMsglistModel) this.cYh).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.cYh.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (mq = com.baidu.tieba.imMessageCenter.im.stranger.c.mq(msg3.getContent())) != null) {
                    if (mq.threadType == 33) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), mq.threadId).pa()));
                        return;
                    } else if (mq.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(mq.threadId, mq.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(mq.threadId, mq.postId, null)));
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
        apB();
        ((PersonalMsglistModel) this.cYh).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
        ((PersonalMsglistModel) this.cYh).mo(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void O(Intent intent) {
        super.O(intent);
        apB();
        ((PersonalMsglistModel) this.cYh).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
        ((PersonalMsglistModel) this.cYh).mo(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.cYh).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.cYh).axt());
    }

    private void apB() {
        if (this.cYh == null || !(this.cYh instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.cYh).getUser();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apA() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
                this.cYh.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
                this.cYh.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean awG() {
        return ((PersonalMsglistModel) this.cYh).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dqO);
        }
        com.baidu.adp.lib.d.a.ff().a(this.locationCallBack);
    }
}
