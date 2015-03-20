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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalTalkSettingActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.RequestNewFriendDataMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.ax;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
import java.util.Iterator;
/* loaded from: classes.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    private com.baidu.tbadk.coreExtra.relationship.b boP;
    private PersonalMsglistModel boR;
    private PersonalChatView boS;
    private UserData mUser;
    private CustomMessageListener boN = new a(this, 2001312);
    private Handler mHandler = new Handler();
    private long boO = 0;
    private String boQ = TbadkCoreApplication.getCurrentAccount();
    private Runnable boT = new d(this);
    private CustomMessageListener boU = new e(this, 2001220);
    private com.baidu.adp.framework.listener.e boV = new f(this, 205101, true);
    private CustomMessageListener boW = new g(this, 0);
    private com.baidu.adp.lib.d.d locationCallBack = new h(this);
    private boolean boX = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void sendTextMsg() {
        boolean z;
        ChatMessage chatMessage;
        Iterator<ChatMessage> it = this.mListModel.getData().getChatMessages().iterator();
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
            this.mListModel.doSendText(chatMessage);
        }
        super.sendTextMsg();
    }

    public long gX(String str) {
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
    protected void refreshHeadIcon() {
        UserData user;
        super.refreshHeadIcon();
        if ((this.mListModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.mListModel).getUser()) != null) {
            com.baidu.tieba.im.l.a(new i(this, user), new j(this));
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
        if (!this.boX) {
            this.boX = true;
            TL();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.uT().dq(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(curId, 2)));
        if (this.mListModel != null && (this.mListModel instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.mListModel).sendHasReadReceiveOther();
        }
    }

    private void TL() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tieba.im.l.a(new k(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.mListView = new PersonalChatView(this, this.mListModel.getIsAcceptNotify());
        this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.boS = (PersonalChatView) this.mListView;
        int i = com.baidu.tieba.im.c.a.bmu;
        if ((this.mListModel instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.mListModel).getUser()) != null) {
            this.mUser = user;
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul().hh(this.mUser.getUserId());
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul().he(this.mUser.getUserId());
            this.mListView.refreshPersonalHeadFooter(this.mUser.getUserName(), this.boP);
            this.mListView.bindDataAndRefresh(this.mListModel.getData(), i);
            this.mListView.setRecordCallback(new b(this));
            if (!TP()) {
                TN();
            }
            if (!TextUtils.isEmpty(this.boR.getReplyContent())) {
                this.boR.insertReplyCard(this.boR.getReplyContent());
            }
        }
    }

    public PersonalMsglistModel TM() {
        return this.boR;
    }

    private void TN() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.mListView.getBtnGroupInfo()) {
            com.baidu.tbadk.core.k.A(getPageContext().getContext(), "personal_chat_page_morebutton");
            if ((this.mListModel instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.mListModel).getUser()) != null) {
                sendMessage(new CustomMessage(2002001, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.boS.TS()) {
            if (this.boR.getCardStatus() == PersonalMsglistModel.CardStatus.APPLY || this.boR.getCardStatus() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.boR.getUser().getUserId(), this.boR.getUser().getUserName(), this.boR.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.boR.getCardStatus() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.Ca().a(com.baidu.adp.lib.g.c.a(this.boR.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    public void TO() {
        if (TbadkCoreApplication.m411getInst().getLocationShared()) {
            String str = String.valueOf(this.boQ) + "&" + this.mUser.getUserId();
            if (!PersonalChatActivityStatic.TQ().gY(str)) {
                com.baidu.adp.lib.d.a.gZ().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b gZ = PersonalChatActivityStatic.TQ().gZ(str);
            this.mListView.refreshPersonalHeadFooter(this.mUser.getUserName(), gZ);
            this.boO = gX(bd.m(gZ.getTime()));
            if (this.boO != 0) {
                this.mHandler.postDelayed(this.boT, this.boO);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean initData(Bundle bundle) {
        try {
            registerListener(this.boV);
            registerListener(2001176, this.boW);
            registerListener(2001177, this.boW);
            registerListener(2001225, this.boW);
            registerListener(2001226, this.boW);
            registerListener(2001227, this.boW);
            registerListener(this.boU);
            registerListener(this.boN);
            if (PersonalChatActivityStatic.TQ() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f());
            }
            this.mListModel = new PersonalMsglistModel(this);
            this.mListModel.setLoadDataCallBack(this.mMsgCallback);
            this.boR = (PersonalMsglistModel) this.mListModel;
            if (bundle != null) {
                initParam(bundle);
            } else {
                initParam();
            }
            return checkParam();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean first(ax axVar) {
        this.mListModel.loadFirst(axVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        String t;
        super.onItemViewClick(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.mListModel.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (isExStorageOk() && (msg = this.mListModel.getMsg(i2)) != null && com.baidu.tieba.im.util.i.p(msg) && (t = com.baidu.tieba.im.util.i.t(msg.getContent(), true)) != null && (this.mListModel instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.mListModel).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new PersonalMsgImageActivityConfig(getPageContext().getContext(), t, ((CommonPersonalMsglistModel) this.mListModel).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.mListModel.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null) {
                    com.baidu.tieba.imMessageCenter.im.stranger.d ho = com.baidu.tieba.imMessageCenter.im.stranger.c.ho(msg3.getContent());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(ho.threadId, ho.postId, null)));
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void onInitParam(Bundle bundle) {
        super.onInitParam(bundle);
        initCurId();
        ((PersonalMsglistModel) this.mListModel).setIsFriend(bundle.getInt("key_is_friend"));
        ((PersonalMsglistModel) this.mListModel).setReplyContent(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void onInitParam(Intent intent) {
        super.onInitParam(intent);
        initCurId();
        ((PersonalMsglistModel) this.mListModel).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        ((PersonalMsglistModel) this.mListModel).setReplyContent(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("key_is_friend", ((PersonalMsglistModel) this.mListModel).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.mListModel).getReplyContent());
    }

    private void initCurId() {
        if (this.mListModel == null || !(this.mListModel instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.mListModel).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void onPageInited() {
        super.onPageInited();
        this.handler.postDelayed(new c(this), 60L);
        TO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nu() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.m.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.mListModel.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.m.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.mListModel.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean TP() {
        return ((PersonalMsglistModel) this.mListModel).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul().hf(this.mUser.getUserId());
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.boT);
        }
        com.baidu.adp.lib.d.a.gZ().a(this.locationCallBack);
    }
}
