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
import com.baidu.tbadk.core.util.aw;
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
    private com.baidu.tbadk.coreExtra.relationship.b chw;
    private PersonalMsglistModel chy;
    private PersonalChatView chz;
    private UserData mUser;
    private CustomMessageListener chu = new a(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private Handler mHandler = new Handler();
    private long chv = 0;
    private String chx = TbadkCoreApplication.getCurrentAccount();
    private Runnable chA = new d(this);
    private CustomMessageListener chB = new e(this, CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    private com.baidu.adp.framework.listener.e chC = new f(this, 205101, true);
    private CustomMessageListener chD = new g(this, 0);
    private a.InterfaceC0004a locationCallBack = new h(this);
    private boolean chE = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void Zd() {
        boolean z;
        ChatMessage chatMessage;
        Iterator<ChatMessage> it = this.bPK.getData().getChatMessages().iterator();
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
            this.bPK.doSendText(chatMessage);
        }
        super.Zd();
    }

    public long jf(String str) {
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
    protected void Yp() {
        UserData user;
        super.Yp();
        if ((this.bPK instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.bPK).getUser()) != null) {
            com.baidu.tbadk.util.n.b(new i(this, user), new j(this));
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
        if (!this.chE) {
            this.chE = true;
            afs();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.yN().eh(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.bPK != null && (this.bPK instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.bPK).ahu();
        }
    }

    private void afs() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tbadk.util.n.b(new k(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.bPJ = new PersonalChatView(this, this.bPK.getIsAcceptNotify());
        this.bPJ.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.chz = (PersonalChatView) this.bPJ;
        int i = com.baidu.tieba.im.c.a.ceW;
        if ((this.bPK instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.bPK).getUser()) != null) {
            this.mUser = user;
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.afW().jr(this.mUser.getUserId());
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.afW().jn(this.mUser.getUserId());
            this.bPJ.refreshPersonalHeadFooter(this.mUser.getUserName(), this.chw);
            this.bPJ.bindDataAndRefresh(this.bPK.getData(), i);
            this.bPJ.setRecordCallback(new b(this));
            if (!afw()) {
                afu();
            }
            if (!TextUtils.isEmpty(this.chy.aht())) {
                this.chy.jz(this.chy.aht());
            }
        }
    }

    public PersonalMsglistModel aft() {
        return this.chy;
    }

    private void afu() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.bPJ.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.bPK instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.bPK).getUser()) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.chz.afA()) {
            if (this.chy.ahv() == PersonalMsglistModel.CardStatus.APPLY || this.chy.ahv() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.chy.getUser().getUserId(), this.chy.getUser().getUserName(), this.chy.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.chy.ahv() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.Fs().b(com.baidu.adp.lib.h.b.c(this.chy.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    public void afv() {
        if (TbadkCoreApplication.m411getInst().getLocationShared()) {
            String str = String.valueOf(this.chx) + "&" + this.mUser.getUserId();
            if (!PersonalChatActivityStatic.afx().jg(str)) {
                com.baidu.adp.lib.e.a.gL().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b jh = PersonalChatActivityStatic.afx().jh(str);
            this.bPJ.refreshPersonalHeadFooter(this.mUser.getUserName(), jh);
            this.chv = jf(aw.s(jh.getTime()));
            if (this.chv != 0) {
                this.mHandler.postDelayed(this.chA, this.chv);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean j(Bundle bundle) {
        try {
            registerListener(this.chC);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.chD);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.chD);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.chD);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.chD);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.chD);
            registerListener(this.chB);
            registerListener(this.chu);
            if (PersonalChatActivityStatic.afx() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.bPK = new PersonalMsglistModel(this);
            this.bPK.setLoadDataCallBack(this.bPV);
            this.chy = (PersonalMsglistModel) this.bPK;
            if (bundle != null) {
                h(bundle);
            } else {
                Yq();
            }
            return Yr();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        this.bPK.loadFirst(alVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a jA;
        ChatMessage msg;
        String y;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.bPK.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (Jp() && (msg = this.bPK.getMsg(i2)) != null && com.baidu.tieba.im.util.h.p(msg) && (y = com.baidu.tieba.im.util.h.y(msg.getContent(), true)) != null && (this.bPK instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.bPK).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), y, ((CommonPersonalMsglistModel) this.bPK).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.bPK.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (jA = com.baidu.tieba.imMessageCenter.im.stranger.c.jA(msg3.getContent())) != null) {
                    if (jA.threadType == 33) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), jA.threadId).rC()));
                        return;
                    } else if (jA.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(jA.threadId, jA.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(jA.threadId, jA.postId, null)));
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void i(Bundle bundle) {
        super.i(bundle);
        Yv();
        ((PersonalMsglistModel) this.bPK).setIsFriend(bundle.getInt("key_is_friend"));
        ((PersonalMsglistModel) this.bPK).jy(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void P(Intent intent) {
        super.P(intent);
        Yv();
        ((PersonalMsglistModel) this.bPK).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        ((PersonalMsglistModel) this.bPK).jy(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("key_is_friend", ((PersonalMsglistModel) this.bPK).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.bPK).aht());
    }

    private void Yv() {
        if (this.bPK == null || !(this.bPK instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.bPK).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void Yt() {
        super.Yt();
        this.handler.postDelayed(new c(this), 60L);
        afv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yu() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.bPK.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.bPK.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean afw() {
        return ((PersonalMsglistModel) this.bPK).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.afW().jo(this.mUser.getUserId());
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.chA);
        }
        com.baidu.adp.lib.e.a.gL().a(this.locationCallBack);
    }
}
