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
    private com.baidu.tbadk.coreExtra.relationship.b dbl;
    private PersonalMsglistModel dbn;
    private PersonalChatView dbo;
    private UserData mUser;
    private CustomMessageListener dbj = new a(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private Handler mHandler = new Handler();
    private long dbk = 0;
    private String dbm = TbadkCoreApplication.getCurrentAccount();
    private Runnable dbp = new d(this);
    private CustomMessageListener dbq = new e(this, CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    private com.baidu.adp.framework.listener.e dbr = new f(this, 205101, true);
    private CustomMessageListener dbs = new g(this, 0);
    private a.InterfaceC0005a locationCallBack = new h(this);
    private boolean dbt = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void alv() {
        arU();
        super.alv();
    }

    private void arU() {
        boolean z;
        ChatMessage chatMessage;
        boolean z2;
        ChatMessage chatMessage2;
        List<ChatMessage> chatMessages = this.cIG.getData().getChatMessages();
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
            this.cIG.doSendText(chatMessage);
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
            this.cIG.doSendText(chatMessage2);
        }
    }

    public long lr(String str) {
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
    protected void akF() {
        UserData user;
        super.akF();
        if ((this.cIG instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.cIG).getUser()) != null) {
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
        if (!this.dbt) {
            this.dbt = true;
            arV();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.xn().eo(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.cIG != null && (this.cIG instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.cIG).atV();
        }
    }

    private void arV() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tbadk.util.u.b(new k(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.cIF = new PersonalChatView(this, this.cIG.getIsAcceptNotify());
        this.cIF.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.dbo = (PersonalChatView) this.cIF;
        int i = com.baidu.tieba.im.c.a.cYJ;
        if ((this.cIG instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cIG).getUser()) != null) {
            this.mUser = user;
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.asy().lD(this.mUser.getUserId());
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.asy().lz(this.mUser.getUserId());
            this.cIF.refreshPersonalHeadFooter(this.mUser.getUserName(), this.dbl);
            this.cIF.bindDataAndRefresh(this.cIG.getData(), i);
            this.cIF.setRecordCallback(new b(this));
            if (!arZ()) {
                arX();
            }
            if (!TextUtils.isEmpty(this.dbn.atT())) {
                this.dbn.lM(this.dbn.atT());
            }
            String atU = this.dbn.atU();
            if (!TextUtils.isEmpty(atU)) {
                this.dbn.lN(atU);
            }
        }
    }

    public PersonalMsglistModel arW() {
        return this.dbn;
    }

    private void arX() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.cIF.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.cIG instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cIG).getUser()) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.dbo.asd()) {
            if (this.dbn.atW() == PersonalMsglistModel.CardStatus.APPLY || this.dbn.atW() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.dbn.getUser().getUserId(), this.dbn.getUser().getUserName(), this.dbn.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.dbn.atW() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.Eg().b(com.baidu.adp.lib.h.b.c(this.dbn.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    public void arY() {
        if (TbadkCoreApplication.m10getInst().getLocationShared()) {
            String str = String.valueOf(this.dbm) + "&" + this.mUser.getUserId();
            if (!PersonalChatActivityStatic.asa().ls(str)) {
                com.baidu.adp.lib.e.a.cZ().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b lt = PersonalChatActivityStatic.asa().lt(str);
            this.cIF.refreshPersonalHeadFooter(this.mUser.getUserName(), lt);
            this.dbk = lr(ba.s(lt.getTime()));
            if (this.dbk != 0) {
                this.mHandler.postDelayed(this.dbp, this.dbk);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean k(Bundle bundle) {
        try {
            registerListener(this.dbr);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.dbs);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.dbs);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.dbs);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.dbs);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.dbs);
            registerListener(this.dbq);
            registerListener(this.dbj);
            if (PersonalChatActivityStatic.asa() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.cIG = new PersonalMsglistModel(this);
            this.cIG.setLoadDataCallBack(this.cIR);
            this.dbn = (PersonalMsglistModel) this.cIG;
            if (bundle != null) {
                i(bundle);
            } else {
                akG();
            }
            return akH();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        this.cIG.loadFirst(alVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a lO;
        ChatMessage msg;
        String C;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.cIG.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (alu() && (msg = this.cIG.getMsg(i2)) != null && com.baidu.tieba.im.util.h.q(msg) && (C = com.baidu.tieba.im.util.h.C(msg.getContent(), true)) != null && (this.cIG instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.cIG).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), C, ((CommonPersonalMsglistModel) this.cIG).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.cIG.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (lO = com.baidu.tieba.imMessageCenter.im.stranger.c.lO(msg3.getContent())) != null) {
                    if (lO.threadType == 33) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), lO.threadId).oa()));
                        return;
                    } else if (lO.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(lO.threadId, lO.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(lO.threadId, lO.postId, null)));
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
        akM();
        ((PersonalMsglistModel) this.cIG).setIsFriend(bundle.getInt("key_is_friend"));
        ((PersonalMsglistModel) this.cIG).lK(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
        ((PersonalMsglistModel) this.cIG).lL(bundle.getString(PersonalChatActivityConfig.KEY_ECOMM_INFO));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void q(Intent intent) {
        super.q(intent);
        akM();
        ((PersonalMsglistModel) this.cIG).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        ((PersonalMsglistModel) this.cIG).lK(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
        ((PersonalMsglistModel) this.cIG).lL(intent.getStringExtra(PersonalChatActivityConfig.KEY_ECOMM_INFO));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("key_is_friend", ((PersonalMsglistModel) this.cIG).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.cIG).atT());
        bundle.putString(PersonalChatActivityConfig.KEY_ECOMM_INFO, ((PersonalMsglistModel) this.cIG).atU());
    }

    private void akM() {
        if (this.cIG == null || !(this.cIG instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.cIG).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void akK() {
        super.akK();
        this.handler.postDelayed(new c(this), 60L);
        arY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akL() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.cIG.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.cIG.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean arZ() {
        return ((PersonalMsglistModel) this.cIG).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.asy().lA(this.mUser.getUserId());
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dbp);
        }
        com.baidu.adp.lib.e.a.cZ().a(this.locationCallBack);
    }
}
