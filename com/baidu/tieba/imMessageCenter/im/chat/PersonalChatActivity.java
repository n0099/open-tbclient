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
    private com.baidu.tbadk.coreExtra.relationship.b cYo;
    private PersonalMsglistModel cYq;
    private PersonalChatView cYr;
    private UserData mUser;
    private CustomMessageListener cYm = new a(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private Handler mHandler = new Handler();
    private long cYn = 0;
    private String cYp = TbadkCoreApplication.getCurrentAccount();
    private Runnable cYs = new d(this);
    private CustomMessageListener cYt = new e(this, CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    private com.baidu.adp.framework.listener.e cYu = new f(this, 205101, true);
    private CustomMessageListener cYv = new g(this, 0);
    private a.InterfaceC0005a locationCallBack = new h(this);
    private boolean cYw = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void akL() {
        ari();
        super.akL();
    }

    private void ari() {
        boolean z;
        ChatMessage chatMessage;
        boolean z2;
        ChatMessage chatMessage2;
        List<ChatMessage> chatMessages = this.cFR.getData().getChatMessages();
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
            this.cFR.doSendText(chatMessage);
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
            this.cFR.doSendText(chatMessage2);
        }
    }

    public long lk(String str) {
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
    protected void ajV() {
        UserData user;
        super.ajV();
        if ((this.cFR instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.cFR).getUser()) != null) {
            com.baidu.tbadk.util.t.b(new i(this, user), new j(this));
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
        if (!this.cYw) {
            this.cYw = true;
            arj();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.xn().ep(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.cFR != null && (this.cFR instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.cFR).atj();
        }
    }

    private void arj() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tbadk.util.t.b(new k(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.cFQ = new PersonalChatView(this, this.cFR.getIsAcceptNotify());
        this.cFQ.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.cYr = (PersonalChatView) this.cFQ;
        int i = com.baidu.tieba.im.c.a.cVO;
        if ((this.cFR instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cFR).getUser()) != null) {
            this.mUser = user;
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.arM().lw(this.mUser.getUserId());
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.arM().ls(this.mUser.getUserId());
            this.cFQ.refreshPersonalHeadFooter(this.mUser.getUserName(), this.cYo);
            this.cFQ.bindDataAndRefresh(this.cFR.getData(), i);
            this.cFQ.setRecordCallback(new b(this));
            if (!arn()) {
                arl();
            }
            if (!TextUtils.isEmpty(this.cYq.ath())) {
                this.cYq.lF(this.cYq.ath());
            }
            String ati = this.cYq.ati();
            if (!TextUtils.isEmpty(ati)) {
                this.cYq.lG(ati);
            }
        }
    }

    public PersonalMsglistModel ark() {
        return this.cYq;
    }

    private void arl() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.cFQ.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.cFR instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cFR).getUser()) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.cYr.arr()) {
            if (this.cYq.atk() == PersonalMsglistModel.CardStatus.APPLY || this.cYq.atk() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.cYq.getUser().getUserId(), this.cYq.getUser().getUserName(), this.cYq.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.cYq.atk() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.Eh().b(com.baidu.adp.lib.h.b.c(this.cYq.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    public void arm() {
        if (TbadkCoreApplication.m9getInst().getLocationShared()) {
            String str = String.valueOf(this.cYp) + "&" + this.mUser.getUserId();
            if (!PersonalChatActivityStatic.aro().ll(str)) {
                com.baidu.adp.lib.e.a.da().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b lm = PersonalChatActivityStatic.aro().lm(str);
            this.cFQ.refreshPersonalHeadFooter(this.mUser.getUserName(), lm);
            this.cYn = lk(ba.x(lm.getTime()));
            if (this.cYn != 0) {
                this.mHandler.postDelayed(this.cYs, this.cYn);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean n(Bundle bundle) {
        try {
            registerListener(this.cYu);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.cYv);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.cYv);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.cYv);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.cYv);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.cYv);
            registerListener(this.cYt);
            registerListener(this.cYm);
            if (PersonalChatActivityStatic.aro() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.cFR = new PersonalMsglistModel(this);
            this.cFR.setLoadDataCallBack(this.cGc);
            this.cYq = (PersonalMsglistModel) this.cFR;
            if (bundle != null) {
                l(bundle);
            } else {
                ajW();
            }
            return ajX();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        this.cFR.loadFirst(alVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a lH;
        ChatMessage msg;
        String C;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.cFR.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (akK() && (msg = this.cFR.getMsg(i2)) != null && com.baidu.tieba.im.util.h.q(msg) && (C = com.baidu.tieba.im.util.h.C(msg.getContent(), true)) != null && (this.cFR instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.cFR).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), C, ((CommonPersonalMsglistModel) this.cFR).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.cFR.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (lH = com.baidu.tieba.imMessageCenter.im.stranger.c.lH(msg3.getContent())) != null) {
                    if (lH.threadType == 33) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), lH.threadId).ol()));
                        return;
                    } else if (lH.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(lH.threadId, lH.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(lH.threadId, lH.postId, null)));
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void m(Bundle bundle) {
        super.m(bundle);
        akc();
        ((PersonalMsglistModel) this.cFR).setIsFriend(bundle.getInt("key_is_friend"));
        ((PersonalMsglistModel) this.cFR).lD(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
        ((PersonalMsglistModel) this.cFR).lE(bundle.getString(PersonalChatActivityConfig.KEY_ECOMM_INFO));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void p(Intent intent) {
        super.p(intent);
        akc();
        ((PersonalMsglistModel) this.cFR).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        ((PersonalMsglistModel) this.cFR).lD(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
        ((PersonalMsglistModel) this.cFR).lE(intent.getStringExtra(PersonalChatActivityConfig.KEY_ECOMM_INFO));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("key_is_friend", ((PersonalMsglistModel) this.cFR).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.cFR).ath());
        bundle.putString(PersonalChatActivityConfig.KEY_ECOMM_INFO, ((PersonalMsglistModel) this.cFR).ati());
    }

    private void akc() {
        if (this.cFR == null || !(this.cFR instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.cFR).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void aka() {
        super.aka();
        this.handler.postDelayed(new c(this), 60L);
        arm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akb() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.cFR.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.cFR.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean arn() {
        return ((PersonalMsglistModel) this.cFR).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.arM().lt(this.mUser.getUserId());
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cYs);
        }
        com.baidu.adp.lib.e.a.da().a(this.locationCallBack);
    }
}
