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
import com.baidu.tbadk.core.util.az;
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
    private com.baidu.tbadk.coreExtra.relationship.b dor;
    private PersonalMsglistModel dot;
    private PersonalChatView dou;
    private UserData mUser;
    private CustomMessageListener dop = new a(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private Handler mHandler = new Handler();
    private long doq = 0;
    private String dos = TbadkCoreApplication.getCurrentAccount();
    private Runnable dov = new d(this);
    private CustomMessageListener dow = new e(this, CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    private com.baidu.adp.framework.listener.e dox = new f(this, 205101, true);
    private CustomMessageListener doy = new g(this, 0);
    private a.InterfaceC0005a locationCallBack = new h(this);
    private boolean doz = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void aqJ() {
        axh();
        super.aqJ();
    }

    private void axh() {
        boolean z;
        ChatMessage chatMessage;
        boolean z2;
        ChatMessage chatMessage2;
        List<ChatMessage> chatMessages = this.cVF.getData().getChatMessages();
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
            this.cVF.doSendText(chatMessage);
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
            this.cVF.doSendText(chatMessage2);
        }
    }

    public long mn(String str) {
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
    protected void apT() {
        UserData user;
        super.apT();
        if ((this.cVF instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.cVF).getUser()) != null) {
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
        if (!this.doz) {
            this.doz = true;
            axi();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.yD().eu(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.cVF != null && (this.cVF instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.cVF).azh();
        }
    }

    private void axi() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tbadk.util.u.b(new k(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.cVE = new PersonalChatView(this, this.cVF.getIsAcceptNotify());
        this.cVE.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.dou = (PersonalChatView) this.cVE;
        int i = com.baidu.tieba.im.c.a.dlP;
        if ((this.cVF instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cVF).getUser()) != null) {
            this.mUser = user;
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.axL().mz(this.mUser.getUserId());
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.axL().mv(this.mUser.getUserId());
            this.cVE.refreshPersonalHeadFooter(this.mUser.getUserName(), this.dor);
            this.cVE.bindDataAndRefresh(this.cVF.getData(), i);
            this.cVE.setRecordCallback(new b(this));
            if (!axm()) {
                axk();
            }
            if (!TextUtils.isEmpty(this.dot.azf())) {
                this.dot.mI(this.dot.azf());
            }
            String azg = this.dot.azg();
            if (!TextUtils.isEmpty(azg)) {
                this.dot.mJ(azg);
            }
        }
    }

    public PersonalMsglistModel axj() {
        return this.dot;
    }

    private void axk() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.cVE.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.cVF instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.cVF).getUser()) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.dou.axq()) {
            if (this.dot.azi() == PersonalMsglistModel.CardStatus.APPLY || this.dot.azi() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.dot.getUser().getUserId(), this.dot.getUser().getUserName(), this.dot.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.dot.azi() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.Fz().b(com.baidu.adp.lib.h.b.c(this.dot.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    public void axl() {
        if (TbadkCoreApplication.m9getInst().getLocationShared()) {
            String str = String.valueOf(this.dos) + "&" + this.mUser.getUserId();
            if (!PersonalChatActivityStatic.axn().mo(str)) {
                com.baidu.adp.lib.e.a.dU().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b mp = PersonalChatActivityStatic.axn().mp(str);
            this.cVE.refreshPersonalHeadFooter(this.mUser.getUserName(), mp);
            this.doq = mn(az.r(mp.getTime()));
            if (this.doq != 0) {
                this.mHandler.postDelayed(this.dov, this.doq);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean k(Bundle bundle) {
        try {
            registerListener(this.dox);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.doy);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.doy);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.doy);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.doy);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.doy);
            registerListener(this.dow);
            registerListener(this.dop);
            if (PersonalChatActivityStatic.axn() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.cVF = new PersonalMsglistModel(this);
            this.cVF.setLoadDataCallBack(this.cVQ);
            this.dot = (PersonalMsglistModel) this.cVF;
            if (bundle != null) {
                i(bundle);
            } else {
                apU();
            }
            return apV();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        this.cVF.loadFirst(alVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a mK;
        ChatMessage msg;
        String H;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.cVF.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (aqI() && (msg = this.cVF.getMsg(i2)) != null && com.baidu.tieba.im.util.h.q(msg) && (H = com.baidu.tieba.im.util.h.H(msg.getContent(), true)) != null && (this.cVF instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.cVF).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), H, ((CommonPersonalMsglistModel) this.cVF).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.cVF.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (mK = com.baidu.tieba.imMessageCenter.im.stranger.c.mK(msg3.getContent())) != null) {
                    if (mK.threadType == 33) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), mK.threadId).oX()));
                        return;
                    } else if (mK.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(mK.threadId, mK.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(mK.threadId, mK.postId, null)));
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
        aqa();
        ((PersonalMsglistModel) this.cVF).setIsFriend(bundle.getInt("key_is_friend"));
        ((PersonalMsglistModel) this.cVF).mG(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
        ((PersonalMsglistModel) this.cVF).mH(bundle.getString(PersonalChatActivityConfig.KEY_ECOMM_INFO));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void p(Intent intent) {
        super.p(intent);
        aqa();
        ((PersonalMsglistModel) this.cVF).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        ((PersonalMsglistModel) this.cVF).mG(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
        ((PersonalMsglistModel) this.cVF).mH(intent.getStringExtra(PersonalChatActivityConfig.KEY_ECOMM_INFO));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("key_is_friend", ((PersonalMsglistModel) this.cVF).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.cVF).azf());
        bundle.putString(PersonalChatActivityConfig.KEY_ECOMM_INFO, ((PersonalMsglistModel) this.cVF).azg());
    }

    private void aqa() {
        if (this.cVF == null || !(this.cVF instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.cVF).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void apY() {
        super.apY();
        this.handler.postDelayed(new c(this), 60L);
        axl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apZ() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.cVF.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.cVF.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean axm() {
        return ((PersonalMsglistModel) this.cVF).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.axL().mw(this.mUser.getUserId());
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dov);
        }
        com.baidu.adp.lib.e.a.dU().a(this.locationCallBack);
    }
}
