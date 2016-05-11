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
    private com.baidu.tbadk.coreExtra.relationship.b csY;
    private PersonalMsglistModel cta;
    private PersonalChatView ctb;
    private UserData mUser;
    private CustomMessageListener csW = new a(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private Handler mHandler = new Handler();
    private long csX = 0;
    private String csZ = TbadkCoreApplication.getCurrentAccount();
    private Runnable ctc = new d(this);
    private CustomMessageListener ctd = new e(this, CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
    private com.baidu.adp.framework.listener.e cte = new f(this, 205101, true);
    private CustomMessageListener ctf = new g(this, 0);
    private a.InterfaceC0005a locationCallBack = new h(this);
    private boolean ctg = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void acx() {
        boolean z;
        ChatMessage chatMessage;
        Iterator<ChatMessage> it = this.caH.getData().getChatMessages().iterator();
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
            this.caH.doSendText(chatMessage);
        }
        super.acx();
    }

    public long jR(String str) {
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
    protected void abH() {
        UserData user;
        super.abH();
        if ((this.caH instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.caH).getUser()) != null) {
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
        if (!this.ctg) {
            this.ctg = true;
            aiT();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.xi().el(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.caH != null && (this.caH instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.caH).akU();
        }
    }

    private void aiT() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tbadk.util.t.b(new k(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.caG = new PersonalChatView(this, this.caH.getIsAcceptNotify());
        this.caG.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.ctb = (PersonalChatView) this.caG;
        int i = com.baidu.tieba.im.c.a.cqy;
        if ((this.caH instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.caH).getUser()) != null) {
            this.mUser = user;
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajw().kd(this.mUser.getUserId());
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajw().jZ(this.mUser.getUserId());
            this.caG.refreshPersonalHeadFooter(this.mUser.getUserName(), this.csY);
            this.caG.bindDataAndRefresh(this.caH.getData(), i);
            this.caG.setRecordCallback(new b(this));
            if (!aiX()) {
                aiV();
            }
            if (!TextUtils.isEmpty(this.cta.akT())) {
                this.cta.kl(this.cta.akT());
            }
        }
    }

    public PersonalMsglistModel aiU() {
        return this.cta;
    }

    private void aiV() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.caG.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.caH instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.caH).getUser()) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.ctb.ajb()) {
            if (this.cta.akV() == PersonalMsglistModel.CardStatus.APPLY || this.cta.akV() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.cta.getUser().getUserId(), this.cta.getUser().getUserName(), this.cta.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.cta.akV() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.DX().b(com.baidu.adp.lib.h.b.c(this.cta.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    public void aiW() {
        if (TbadkCoreApplication.m11getInst().getLocationShared()) {
            String str = String.valueOf(this.csZ) + "&" + this.mUser.getUserId();
            if (!PersonalChatActivityStatic.aiY().jS(str)) {
                com.baidu.adp.lib.e.a.cZ().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b jT = PersonalChatActivityStatic.aiY().jT(str);
            this.caG.refreshPersonalHeadFooter(this.mUser.getUserName(), jT);
            this.csX = jR(ay.w(jT.getTime()));
            if (this.csX != 0) {
                this.mHandler.postDelayed(this.ctc, this.csX);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean m(Bundle bundle) {
        try {
            registerListener(this.cte);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.ctf);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.ctf);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.ctf);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.ctf);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.ctf);
            registerListener(this.ctd);
            registerListener(this.csW);
            if (PersonalChatActivityStatic.aiY() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.caH = new PersonalMsglistModel(this);
            this.caH.setLoadDataCallBack(this.caS);
            this.cta = (PersonalMsglistModel) this.caH;
            if (bundle != null) {
                k(bundle);
            } else {
                abI();
            }
            return abJ();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        this.caH.loadFirst(alVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a km;
        ChatMessage msg;
        String A;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.caH.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (acw() && (msg = this.caH.getMsg(i2)) != null && com.baidu.tieba.im.util.h.p(msg) && (A = com.baidu.tieba.im.util.h.A(msg.getContent(), true)) != null && (this.caH instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.caH).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), A, ((CommonPersonalMsglistModel) this.caH).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.caH.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (km = com.baidu.tieba.imMessageCenter.im.stranger.c.km(msg3.getContent())) != null) {
                    if (km.threadType == 33) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), km.threadId).oq()));
                        return;
                    } else if (km.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(km.threadId, km.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(km.threadId, km.postId, null)));
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void l(Bundle bundle) {
        super.l(bundle);
        abO();
        ((PersonalMsglistModel) this.caH).setIsFriend(bundle.getInt("key_is_friend"));
        ((PersonalMsglistModel) this.caH).kk(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void n(Intent intent) {
        super.n(intent);
        abO();
        ((PersonalMsglistModel) this.caH).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        ((PersonalMsglistModel) this.caH).kk(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("key_is_friend", ((PersonalMsglistModel) this.caH).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.caH).akT());
    }

    private void abO() {
        if (this.caH == null || !(this.caH instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.caH).getUser();
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
        aiW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abN() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.caH.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.caH.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean aiX() {
        return ((PersonalMsglistModel) this.caH).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajw().ka(this.mUser.getUserId());
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ctc);
        }
        com.baidu.adp.lib.e.a.cZ().a(this.locationCallBack);
    }
}
