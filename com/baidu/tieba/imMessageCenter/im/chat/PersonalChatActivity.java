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
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestNewFriendDataMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.stranger.c;
import java.util.Iterator;
/* loaded from: classes.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    private com.baidu.tbadk.coreExtra.relationship.b djr;
    private PersonalMsglistModel djt;
    private PersonalChatView dju;
    private UserData mUser;
    private CustomMessageListener djp = new a(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private Handler mHandler = new Handler();
    private long djq = 0;
    private String djs = TbadkCoreApplication.getCurrentAccount();
    private Runnable djv = new d(this);
    private CustomMessageListener djw = new e(this, CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    private com.baidu.adp.framework.listener.e djx = new f(this, 205101, true);
    private CustomMessageListener djy = new g(this, 0);
    private a.InterfaceC0004a locationCallBack = new h(this);
    private boolean djz = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void aoD() {
        auY();
        super.aoD();
    }

    private void auY() {
        boolean z;
        ChatMessage chatMessage;
        Iterator<ChatMessage> it = this.cQL.getData().getChatMessages().iterator();
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
            this.cQL.doSendText(chatMessage);
        }
    }

    public long kY(String str) {
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
    protected void anQ() {
        UserData user;
        super.anQ();
        if ((this.cQL instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.cQL).getUser()) != null) {
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
        if (!this.djz) {
            this.djz = true;
            auZ();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.zj().em(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.cQL != null && (this.cQL instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.cQL).avW();
        }
    }

    private void auZ() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tbadk.util.t.b(new k(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.cQK = new PersonalChatView(this, this.cQL.getIsAcceptNotify());
        this.cQK.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.dju = (PersonalChatView) this.cQK;
        int i = com.baidu.tieba.im.sendmessage.a.dgL;
        if ((this.cQL instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cQL).getUser()) != null) {
            this.mUser = user;
            this.cQK.refreshPersonalHeadFooter(this.mUser.getUserName(), this.djr);
            this.cQK.bindDataAndRefresh(this.cQL.getData(), i);
            this.cQK.setRecordCallback(new b(this));
            if (!avd()) {
                avb();
            }
            if (!TextUtils.isEmpty(this.djt.avV())) {
                this.djt.le(this.djt.avV());
            }
        }
    }

    public PersonalMsglistModel ava() {
        return this.djt;
    }

    private void avb() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.cQK.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.cQL instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cQL).getUser()) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.dju.avh()) {
            if (this.djt.avX() == PersonalMsglistModel.CardStatus.APPLY || this.djt.avX() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.djt.getUser().getUserId(), this.djt.getUser().getUserName(), this.djt.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.djt.avX() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.b(com.baidu.adp.lib.g.b.c(this.djt.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    public void avc() {
        if (TbadkCoreApplication.m9getInst().getLocationShared()) {
            String str = String.valueOf(this.djs) + "&" + this.mUser.getUserId();
            if (!PersonalChatActivityStatic.ave().kZ(str)) {
                com.baidu.adp.lib.d.a.fg().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b la = PersonalChatActivityStatic.ave().la(str);
            this.cQK.refreshPersonalHeadFooter(this.mUser.getUserName(), la);
            this.djq = kY(au.o(la.getTime()));
            if (this.djq != 0) {
                this.mHandler.postDelayed(this.djv, this.djq);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean l(Bundle bundle) {
        try {
            registerListener(this.djx);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.djy);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.djy);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.djy);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.djy);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.djy);
            registerListener(this.djw);
            registerListener(this.djp);
            if (PersonalChatActivityStatic.ave() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.cQL = new PersonalMsglistModel(this);
            this.cQL.setLoadDataCallBack(this.cQW);
            this.djt = (PersonalMsglistModel) this.cQL;
            if (bundle != null) {
                j(bundle);
            } else {
                anR();
            }
            return anS();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(ak akVar) {
        this.cQL.loadFirst(akVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        c.a lf;
        ChatMessage msg;
        String I;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.cQL.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (aoC() && (msg = this.cQL.getMsg(i2)) != null && com.baidu.tieba.im.util.h.q(msg) && (I = com.baidu.tieba.im.util.h.I(msg.getContent(), true)) != null && (this.cQL instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.cQL).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), I, ((CommonPersonalMsglistModel) this.cQL).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.cQL.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (lf = com.baidu.tieba.imMessageCenter.im.stranger.c.lf(msg3.getContent())) != null) {
                    if (lf.threadType == 33) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), lf.threadId).pE()));
                        return;
                    } else if (lf.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(lf.threadId, lf.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(lf.threadId, lf.postId, null)));
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
        anX();
        ((PersonalMsglistModel) this.cQL).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
        ((PersonalMsglistModel) this.cQL).ld(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void M(Intent intent) {
        super.M(intent);
        anX();
        ((PersonalMsglistModel) this.cQL).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
        ((PersonalMsglistModel) this.cQL).ld(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.cQL).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.cQL).avV());
    }

    private void anX() {
        if (this.cQL == null || !(this.cQL instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.cQL).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void anV() {
        super.anV();
        this.handler.postDelayed(new c(this), 60L);
        avc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anW() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
                this.cQL.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
                this.cQL.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean avd() {
        return ((PersonalMsglistModel) this.cQL).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.djv);
        }
        com.baidu.adp.lib.d.a.fg().a(this.locationCallBack);
    }
}
