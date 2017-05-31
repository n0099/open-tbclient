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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.w;
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
    private com.baidu.tbadk.coreExtra.relationship.b diO;
    private PersonalMsglistModel diQ;
    private PersonalChatView diR;
    private UserData mUser;
    private CustomMessageListener diM = new a(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private Handler mHandler = new Handler();
    private long diN = 0;
    private String diP = TbadkCoreApplication.getCurrentAccount();
    private Runnable diS = new d(this);
    private CustomMessageListener diT = new e(this, CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    private com.baidu.adp.framework.listener.e diU = new f(this, 205101, true);
    private CustomMessageListener diV = new g(this, 0);
    private a.InterfaceC0004a locationCallBack = new h(this);
    private boolean diW = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void amw() {
        asR();
        super.amw();
    }

    private void asR() {
        boolean z;
        ChatMessage chatMessage;
        Iterator<ChatMessage> it = this.cQl.getData().getChatMessages().iterator();
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
            this.cQl.doSendText(chatMessage);
        }
    }

    public long lm(String str) {
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
    protected void alJ() {
        UserData user;
        super.alJ();
        if ((this.cQl instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.cQl).getUser()) != null) {
            w.b(new i(this, user), new j(this));
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
        if (!this.diW) {
            this.diW = true;
            asS();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.yn().ej(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.cQl != null && (this.cQl instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.cQl).atM();
        }
    }

    private void asS() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void b(UserData userData) {
        w.b(new k(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.cQk = new PersonalChatView(this, this.cQl.getIsAcceptNotify());
        this.cQk.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.diR = (PersonalChatView) this.cQk;
        int i = com.baidu.tieba.im.sendmessage.a.dgj;
        if ((this.cQl instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cQl).getUser()) != null) {
            this.mUser = user;
            this.cQk.refreshPersonalHeadFooter(this.mUser.getUserName(), this.diO);
            this.cQk.bindDataAndRefresh(this.cQl.getData(), i);
            this.cQk.setRecordCallback(new b(this));
            if (!asW()) {
                asU();
            }
            if (!TextUtils.isEmpty(this.diQ.atL())) {
                this.diQ.ls(this.diQ.atL());
            }
        }
    }

    public PersonalMsglistModel asT() {
        return this.diQ;
    }

    private void asU() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.cQk.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.cQl instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cQl).getUser()) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.diR.ata()) {
            if (this.diQ.atN() == PersonalMsglistModel.CardStatus.APPLY || this.diQ.atN() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.diQ.getUser().getUserId(), this.diQ.getUser().getUserName(), this.diQ.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.diQ.atN() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.b(com.baidu.adp.lib.g.b.c(this.diQ.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    public void asV() {
        if (TbadkCoreApplication.m9getInst().getLocationShared()) {
            String str = String.valueOf(this.diP) + "&" + this.mUser.getUserId();
            if (!PersonalChatActivityStatic.asX().ln(str)) {
                com.baidu.adp.lib.d.a.fg().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b lo = PersonalChatActivityStatic.asX().lo(str);
            this.cQk.refreshPersonalHeadFooter(this.mUser.getUserName(), lo);
            this.diN = lm(au.o(lo.getTime()));
            if (this.diN != 0) {
                this.mHandler.postDelayed(this.diS, this.diN);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean l(Bundle bundle) {
        try {
            registerListener(this.diU);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.diV);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.diV);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.diV);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.diV);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.diV);
            registerListener(this.diT);
            registerListener(this.diM);
            if (PersonalChatActivityStatic.asX() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.cQl = new PersonalMsglistModel(this);
            this.cQl.setLoadDataCallBack(this.cQw);
            this.diQ = (PersonalMsglistModel) this.cQl;
            if (bundle != null) {
                j(bundle);
            } else {
                alK();
            }
            return alL();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(ak akVar) {
        this.cQl.loadFirst(akVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        c.a lt;
        ChatMessage msg;
        String F;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.cQl.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (amv() && (msg = this.cQl.getMsg(i2)) != null && com.baidu.tieba.im.util.h.q(msg) && (F = com.baidu.tieba.im.util.h.F(msg.getContent(), true)) != null && (this.cQl instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.cQl).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), F, ((CommonPersonalMsglistModel) this.cQl).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.cQl.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (lt = com.baidu.tieba.imMessageCenter.im.stranger.c.lt(msg3.getContent())) != null) {
                    if (lt.threadType == 33) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), lt.threadId).pd()));
                        return;
                    } else if (lt.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(lt.threadId, lt.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(lt.threadId, lt.postId, null)));
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
        alQ();
        ((PersonalMsglistModel) this.cQl).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
        ((PersonalMsglistModel) this.cQl).lr(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void O(Intent intent) {
        super.O(intent);
        alQ();
        ((PersonalMsglistModel) this.cQl).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
        ((PersonalMsglistModel) this.cQl).lr(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.cQl).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.cQl).atL());
    }

    private void alQ() {
        if (this.cQl == null || !(this.cQl instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.cQl).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void alO() {
        super.alO();
        this.handler.postDelayed(new c(this), 60L);
        asV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alP() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
                this.cQl.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
                this.cQl.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean asW() {
        return ((PersonalMsglistModel) this.cQl).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.diS);
        }
        com.baidu.adp.lib.d.a.fg().a(this.locationCallBack);
    }
}
