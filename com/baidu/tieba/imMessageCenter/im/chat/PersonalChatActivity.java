package com.baidu.tieba.imMessageCenter.im.chat;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.relationship.b;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.d;
import com.baidu.tieba.im.data.a;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.settingcache.e;
import com.baidu.tieba.imMessageCenter.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestNewFriendDataMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.RequestPersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.stranger.a;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    private b dWN;
    private PersonalMsglistModel dWP;
    private PersonalChatView dWQ;
    private UserData mUser;
    private CustomMessageListener dWL = new CustomMessageListener(CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseNewFriendDataMessage)) {
                a data = ((ResponseNewFriendDataMessage) customResponsedMessage).getData();
                PersonalMsglistModel.CardStatus j = PersonalChatActivity.this.dWP.j(data);
                PersonalChatActivity.this.dWP.a(j);
                if (j != PersonalMsglistModel.CardStatus.AGREE) {
                    PersonalChatActivity.this.dWQ.a(j, false, new String[0]);
                    return;
                }
                PersonalChatActivity.this.dWQ.a(j, false, data.getContent());
            }
        }
    };
    private Handler mHandler = new Handler();
    private long dWM = 0;
    private String dWO = TbadkCoreApplication.getCurrentAccount();
    private Runnable dWR = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.4
        @Override // java.lang.Runnable
        public void run() {
            PersonalChatActivity.this.dEG.refreshPersonalHeadFooter(PersonalChatActivity.this.mUser.getName_show(), PersonalChatActivity.this.dWN);
            if (PersonalChatActivity.this.dWM != 0) {
                PersonalChatActivity.this.mHandler.postDelayed(PersonalChatActivity.this.dWR, PersonalChatActivity.this.dWM);
            }
        }
    };
    private CustomMessageListener dWS = new CustomMessageListener(CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001214 && PersonalChatActivity.this.dEG != null && PersonalChatActivity.this.dEG.getAdapter() != null) {
                PersonalChatActivity.this.dEG.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private c dWT = new c(205101, true) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UserData user;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
                PersonalChatActivity.this.dWN = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
                if (PersonalChatActivity.this.dWN != null && (user = ((PersonalMsglistModel) PersonalChatActivity.this.dEH).getUser()) != null) {
                    PersonalChatActivity.this.dEG.refreshPersonalHeadFooter(user.getUserName(), PersonalChatActivity.this.dWN);
                    PersonalChatActivity.this.dWM = PersonalChatActivity.this.nr(am.p(PersonalChatActivity.this.dWN.getTime()));
                    if (PersonalChatActivity.this.dWM != 0) {
                        PersonalChatActivity.this.mHandler.postDelayed(PersonalChatActivity.this.dWR, PersonalChatActivity.this.dWM);
                    }
                    PersonalChatActivityStatic.aDK().a(PersonalChatActivity.this.dWO + "&" + user.getUserId(), new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(PersonalChatActivity.this.dWN, System.currentTimeMillis()));
                }
            }
        }
    };
    private CustomMessageListener dWU = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
                String cmd = p.getCmd();
                if (!TextUtils.isEmpty(cmd)) {
                    String content = p.getContent();
                    if (!TextUtils.isEmpty(content)) {
                        try {
                            JSONObject optJSONObject = new JSONObject(content).optJSONObject("eventParam");
                            if (optJSONObject != null && optJSONObject.optLong("user_id") == com.baidu.adp.lib.g.b.c(PersonalChatActivity.this.dWP.getUser().getUserId(), 0L)) {
                                String optString = optJSONObject.optString(PushConstants.EXTRA_PUSH_MESSAGE);
                                if (cmd.equals("apply_new_friend")) {
                                    PersonalChatActivity.this.dWQ.a(PersonalMsglistModel.CardStatus.AGREE, true, optString);
                                    PersonalChatActivity.this.dWP.a(PersonalMsglistModel.CardStatus.AGREE);
                                } else if (cmd.equals("passed_new_friend")) {
                                    PersonalChatActivity.this.dWQ.a(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                                    PersonalChatActivity.this.dWP.a(PersonalMsglistModel.CardStatus.PASS);
                                    PersonalChatActivity.this.dWP.setIsFriend(1);
                                    PersonalChatActivity.this.dWP.setFollowStatus(1);
                                    PersonalChatActivity.this.dWQ.getBtnGroupInfo().setVisibility(0);
                                } else if (cmd.equals("apply_add_friend")) {
                                    PersonalChatActivity.this.dWQ.a(PersonalMsglistModel.CardStatus.WAIT, true, new String[0]);
                                    PersonalChatActivity.this.dWP.a(PersonalMsglistModel.CardStatus.WAIT);
                                } else if (cmd.equals("apply_pass_friend")) {
                                    PersonalChatActivity.this.dWQ.a(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                                    PersonalChatActivity.this.dWP.a(PersonalMsglistModel.CardStatus.PASS);
                                    PersonalChatActivity.this.dWP.setIsFriend(1);
                                    PersonalChatActivity.this.dWP.setFollowStatus(1);
                                    PersonalChatActivity.this.dWQ.getBtnGroupInfo().setVisibility(0);
                                }
                            }
                        } catch (JSONException e) {
                            BdLog.i(e.getMessage());
                        }
                    }
                }
            }
        }
    };
    private a.InterfaceC0004a locationCallBack = new a.InterfaceC0004a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.8
        @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                UserData user = ((PersonalMsglistModel) PersonalChatActivity.this.dEH).getUser();
                if (user != null) {
                    PersonalChatActivity.this.mUser = user;
                    PersonalChatActivity.this.sendMessage(new RequestPersonalLbsInfoMessage(205101, user.getUserIdLong(), valueOf, valueOf2));
                }
            }
        }
    };
    private boolean dWV = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void axu() {
        aDF();
        super.axu();
    }

    private void aDF() {
        ChatMessage chatMessage;
        boolean z;
        Iterator<ChatMessage> it = this.dEH.getData().getChatMessages().iterator();
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
            this.dEH.doSendText(chatMessage);
        }
    }

    public long nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        if (str.contains("分钟") || str.contains("刚刚")) {
            return 60000L;
        }
        if (str.contains("小时")) {
            return 3600000L;
        }
        return str.contains("天") ? 86400000L : 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void awH() {
        final UserData user;
        super.awH();
        if ((this.dEH instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.dEH).getUser()) != null) {
            v.b(new u<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.9
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    return Boolean.valueOf(e.aDi().bj(TbadkCoreApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                }
            }, new h<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                public void onReturnDataInUI(Boolean bool) {
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            PersonalChatActivity.this.dEG.closeNotNotify();
                        } else {
                            PersonalChatActivity.this.dEG.showNotNotfiy();
                        }
                    }
                }
            });
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
        if (!this.dWV) {
            this.dWV = true;
            aDG();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.yN().eP(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.dEH != null && (this.dEH instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.dEH).aEx();
        }
    }

    private void aDG() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void c(final UserData userData) {
        v.b(new u<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: MI */
            public Void doInBackground() {
                e.aDi().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.dEG = new PersonalChatView(this, this.dEH.getIsAcceptNotify());
        this.dEG.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.dWQ = (PersonalChatView) this.dEG;
        int i = com.baidu.tieba.im.sendmessage.a.dUh;
        if ((this.dEH instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.dEH).getUser()) != null) {
            this.mUser = user;
            this.dEG.refreshPersonalHeadFooter(this.mUser.getName_show(), this.dWN);
            this.dEG.bindDataAndRefresh(this.dEH.getData(), i);
            this.dEG.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.2
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        PersonalChatActivity.this.dEH.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void awG() {
                }
            });
            if (!aDJ()) {
                aDI();
            }
            if (!TextUtils.isEmpty(this.dWP.aEw())) {
                this.dWP.nv(this.dWP.aEw());
            }
        }
    }

    public PersonalMsglistModel aDH() {
        return this.dWP;
    }

    private void aDI() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.dEG.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.dEH instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.dEH).getUser()) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.dWQ.aDN()) {
            if (this.dWP.aEy() == PersonalMsglistModel.CardStatus.APPLY || this.dWP.aEy() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.dWP.getUser().getUserId(), this.dWP.getUser().getUserName(), this.dWP.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.dWP.aEy() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.b(com.baidu.adp.lib.g.b.c(this.dWP.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean o(Bundle bundle) {
        try {
            registerListener(this.dWT);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.dWU);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.dWU);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.dWU);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.dWU);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.dWU);
            registerListener(this.dWS);
            registerListener(this.dWL);
            if (PersonalChatActivityStatic.aDK() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.dEH = new PersonalMsglistModel(this);
            this.dEH.setLoadDataCallBack(this.dES);
            this.dWP = (PersonalMsglistModel) this.dEH;
            if (bundle != null) {
                m(bundle);
            } else {
                awI();
            }
            return awJ();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(d dVar) {
        this.dEH.loadFirst(dVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        a.C0117a nw;
        ChatMessage msg;
        String K;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.dEH.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (axt() && (msg = this.dEH.getMsg(i2)) != null && com.baidu.tieba.im.util.e.s(msg) && (K = com.baidu.tieba.im.util.e.K(msg.getContent(), true)) != null && (this.dEH instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.dEH).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), K, ((CommonPersonalMsglistModel) this.dEH).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.dEH.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (nw = com.baidu.tieba.imMessageCenter.im.stranger.a.nw(msg3.getContent())) != null) {
                    if (nw.threadType == 33) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), nw.threadId).pn()));
                        return;
                    } else if (nw.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(nw.threadId, nw.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(nw.threadId, nw.postId, null)));
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void n(Bundle bundle) {
        super.n(bundle);
        awO();
        ((PersonalMsglistModel) this.dEH).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
        ((PersonalMsglistModel) this.dEH).setFollowStatus(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FOLLOW));
        ((PersonalMsglistModel) this.dEH).nu(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void M(Intent intent) {
        super.M(intent);
        awO();
        ((PersonalMsglistModel) this.dEH).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
        ((PersonalMsglistModel) this.dEH).setFollowStatus(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FOLLOW, 1));
        ((PersonalMsglistModel) this.dEH).nu(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.dEH).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.dEH).aEw());
    }

    private void awO() {
        if (this.dEH == null || !(this.dEH instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.dEH).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void awM() {
        super.awM();
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.3
            @Override // java.lang.Runnable
            public void run() {
                PersonalChatActivity.this.awN();
            }
        }, 60L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awN() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            if (!k.isEmpty(stringExtra)) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
                this.dEH.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            if (!k.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
                this.dEH.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean aDJ() {
        return ((PersonalMsglistModel) this.dEH).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dWR);
        }
        com.baidu.adp.lib.d.a.fc().a(this.locationCallBack);
    }
}
