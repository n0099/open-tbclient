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
import com.baidu.tbadk.core.util.ax;
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
    private com.baidu.tbadk.coreExtra.relationship.b dtZ;
    private PersonalMsglistModel dub;
    private PersonalChatView duc;
    private UserData mUser;
    private CustomMessageListener dtX = new a(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private Handler mHandler = new Handler();
    private long dtY = 0;
    private String dua = TbadkCoreApplication.getCurrentAccount();
    private Runnable dud = new d(this);
    private CustomMessageListener due = new e(this, CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    private com.baidu.adp.framework.listener.e duf = new f(this, 205101, true);
    private CustomMessageListener dug = new g(this, 0);
    private a.InterfaceC0005a locationCallBack = new h(this);
    private boolean duh = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void asG() {
        aze();
        super.asG();
    }

    private void aze() {
        boolean z;
        ChatMessage chatMessage;
        boolean z2;
        ChatMessage chatMessage2;
        List<ChatMessage> chatMessages = this.dbq.getData().getChatMessages();
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
            this.dbq.doSendText(chatMessage);
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
            this.dbq.doSendText(chatMessage2);
        }
    }

    public long mA(String str) {
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
    protected void arQ() {
        UserData user;
        super.arQ();
        if ((this.dbq instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.dbq).getUser()) != null) {
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
        if (!this.duh) {
            this.duh = true;
            azf();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.yK().ew(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.dbq != null && (this.dbq instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.dbq).aBe();
        }
    }

    private void azf() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tbadk.util.t.b(new k(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.dbp = new PersonalChatView(this, this.dbq.getIsAcceptNotify());
        this.dbp.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.duc = (PersonalChatView) this.dbp;
        int i = com.baidu.tieba.im.c.a.drz;
        if ((this.dbq instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.dbq).getUser()) != null) {
            this.mUser = user;
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI().mM(this.mUser.getUserId());
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI().mI(this.mUser.getUserId());
            this.dbp.refreshPersonalHeadFooter(this.mUser.getUserName(), this.dtZ);
            this.dbp.bindDataAndRefresh(this.dbq.getData(), i);
            this.dbp.setRecordCallback(new b(this));
            if (!azj()) {
                azh();
            }
            if (!TextUtils.isEmpty(this.dub.aBc())) {
                this.dub.mV(this.dub.aBc());
            }
            String aBd = this.dub.aBd();
            if (!TextUtils.isEmpty(aBd)) {
                this.dub.mW(aBd);
            }
        }
    }

    public PersonalMsglistModel azg() {
        return this.dub;
    }

    private void azh() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.dbp.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.dbq instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.dbq).getUser()) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.duc.azn()) {
            if (this.dub.aBf() == PersonalMsglistModel.CardStatus.APPLY || this.dub.aBf() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.dub.getUser().getUserId(), this.dub.getUser().getUserName(), this.dub.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.dub.aBf() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.b(com.baidu.adp.lib.h.b.c(this.dub.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    public void azi() {
        if (TbadkCoreApplication.m9getInst().getLocationShared()) {
            String str = String.valueOf(this.dua) + "&" + this.mUser.getUserId();
            if (!PersonalChatActivityStatic.azk().mB(str)) {
                com.baidu.adp.lib.e.a.dU().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b mC = PersonalChatActivityStatic.azk().mC(str);
            this.dbp.refreshPersonalHeadFooter(this.mUser.getUserName(), mC);
            this.dtY = mA(ax.q(mC.getTime()));
            if (this.dtY != 0) {
                this.mHandler.postDelayed(this.dud, this.dtY);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean k(Bundle bundle) {
        try {
            registerListener(this.duf);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.dug);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.dug);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.dug);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.dug);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.dug);
            registerListener(this.due);
            registerListener(this.dtX);
            if (PersonalChatActivityStatic.azk() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.dbq = new PersonalMsglistModel(this);
            this.dbq.setLoadDataCallBack(this.dbB);
            this.dub = (PersonalMsglistModel) this.dbq;
            if (bundle != null) {
                i(bundle);
            } else {
                arR();
            }
            return arS();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        this.dbq.loadFirst(alVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a mX;
        ChatMessage msg;
        String H;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.dbq.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (asF() && (msg = this.dbq.getMsg(i2)) != null && com.baidu.tieba.im.util.h.q(msg) && (H = com.baidu.tieba.im.util.h.H(msg.getContent(), true)) != null && (this.dbq instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.dbq).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), H, ((CommonPersonalMsglistModel) this.dbq).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.dbq.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (mX = com.baidu.tieba.imMessageCenter.im.stranger.c.mX(msg3.getContent())) != null) {
                    if (mX.threadType == 33) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), mX.threadId).oZ()));
                        return;
                    } else if (mX.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(mX.threadId, mX.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(mX.threadId, mX.postId, null)));
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
        arX();
        ((PersonalMsglistModel) this.dbq).setIsFriend(bundle.getInt("key_is_friend"));
        ((PersonalMsglistModel) this.dbq).mT(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
        ((PersonalMsglistModel) this.dbq).mU(bundle.getString(PersonalChatActivityConfig.KEY_ECOMM_INFO));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void p(Intent intent) {
        super.p(intent);
        arX();
        ((PersonalMsglistModel) this.dbq).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        ((PersonalMsglistModel) this.dbq).mT(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
        ((PersonalMsglistModel) this.dbq).mU(intent.getStringExtra(PersonalChatActivityConfig.KEY_ECOMM_INFO));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("key_is_friend", ((PersonalMsglistModel) this.dbq).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.dbq).aBc());
        bundle.putString(PersonalChatActivityConfig.KEY_ECOMM_INFO, ((PersonalMsglistModel) this.dbq).aBd());
    }

    private void arX() {
        if (this.dbq == null || !(this.dbq instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.dbq).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void arV() {
        super.arV();
        this.handler.postDelayed(new c(this), 60L);
        azi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arW() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.dbq.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.dbq.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean azj() {
        return ((PersonalMsglistModel) this.dbq).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI().mJ(this.mUser.getUserId());
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dud);
        }
        com.baidu.adp.lib.e.a.dU().a(this.locationCallBack);
    }
}
