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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.relationship.b;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
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
import com.baidu.webkit.internal.ETAG;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    private b faR;
    private PersonalMsglistModel faT;
    private PersonalChatView faU;
    private UserData mUser;
    private CustomMessageListener faP = new CustomMessageListener(2001305) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseNewFriendDataMessage)) {
                a data = ((ResponseNewFriendDataMessage) customResponsedMessage).getData();
                PersonalMsglistModel.CardStatus j = PersonalChatActivity.this.faT.j(data);
                PersonalChatActivity.this.faT.a(j);
                if (j != PersonalMsglistModel.CardStatus.AGREE) {
                    PersonalChatActivity.this.faU.a(j, false, new String[0]);
                    return;
                }
                PersonalChatActivity.this.faU.a(j, false, data.getContent());
            }
        }
    };
    private Handler mHandler = new Handler();
    private long faQ = 0;
    private String faS = TbadkCoreApplication.getCurrentAccount();
    private Runnable faV = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.4
        @Override // java.lang.Runnable
        public void run() {
            PersonalChatActivity.this.eIQ.refreshPersonalHeadFooter(PersonalChatActivity.this.mUser.getName_show(), PersonalChatActivity.this.faR);
            if (PersonalChatActivity.this.faQ != 0) {
                PersonalChatActivity.this.mHandler.postDelayed(PersonalChatActivity.this.faV, PersonalChatActivity.this.faQ);
            }
        }
    };
    private CustomMessageListener faW = new CustomMessageListener(2001214) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001214 && PersonalChatActivity.this.eIQ != null && PersonalChatActivity.this.eIQ.getAdapter() != null) {
                PersonalChatActivity.this.eIQ.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private c faX = new c(205101, true) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UserData user;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
                PersonalChatActivity.this.faR = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
                if (PersonalChatActivity.this.faR != null && (user = ((PersonalMsglistModel) PersonalChatActivity.this.eIR).getUser()) != null) {
                    PersonalChatActivity.this.eIQ.refreshPersonalHeadFooter(user.getName_show(), PersonalChatActivity.this.faR);
                    PersonalChatActivity.this.faQ = PersonalChatActivity.this.qF(ao.J(PersonalChatActivity.this.faR.getTime()));
                    if (PersonalChatActivity.this.faQ != 0) {
                        PersonalChatActivity.this.mHandler.postDelayed(PersonalChatActivity.this.faV, PersonalChatActivity.this.faQ);
                    }
                    PersonalChatActivityStatic.aUM().a(PersonalChatActivity.this.faS + ETAG.ITEM_SEPARATOR + user.getUserId(), new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(PersonalChatActivity.this.faR, System.currentTimeMillis()));
                }
            }
        }
    };
    private CustomMessageListener faY = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.7
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
                            if (optJSONObject != null && optJSONObject.optLong("user_id") == com.baidu.adp.lib.g.b.d(PersonalChatActivity.this.faT.getUser().getUserId(), 0L)) {
                                String optString = optJSONObject.optString("message");
                                if (cmd.equals("apply_new_friend")) {
                                    PersonalChatActivity.this.faU.a(PersonalMsglistModel.CardStatus.AGREE, true, optString);
                                    PersonalChatActivity.this.faT.a(PersonalMsglistModel.CardStatus.AGREE);
                                } else if (cmd.equals("passed_new_friend")) {
                                    PersonalChatActivity.this.faU.a(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                                    PersonalChatActivity.this.faT.a(PersonalMsglistModel.CardStatus.PASS);
                                    PersonalChatActivity.this.faT.setIsFriend(1);
                                    PersonalChatActivity.this.faT.setFollowStatus(1);
                                    PersonalChatActivity.this.faU.getBtnGroupInfo().setVisibility(0);
                                } else if (cmd.equals("apply_add_friend")) {
                                    PersonalChatActivity.this.faU.a(PersonalMsglistModel.CardStatus.WAIT, true, new String[0]);
                                    PersonalChatActivity.this.faT.a(PersonalMsglistModel.CardStatus.WAIT);
                                } else if (cmd.equals("apply_pass_friend")) {
                                    PersonalChatActivity.this.faU.a(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                                    PersonalChatActivity.this.faT.a(PersonalMsglistModel.CardStatus.PASS);
                                    PersonalChatActivity.this.faT.setIsFriend(1);
                                    PersonalChatActivity.this.faT.setFollowStatus(1);
                                    PersonalChatActivity.this.faU.getBtnGroupInfo().setVisibility(0);
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
    private a.InterfaceC0017a locationCallBack = new a.InterfaceC0017a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.8
        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                UserData user = ((PersonalMsglistModel) PersonalChatActivity.this.eIR).getUser();
                if (user != null) {
                    PersonalChatActivity.this.mUser = user;
                    PersonalChatActivity.this.sendMessage(new RequestPersonalLbsInfoMessage(205101, user.getUserIdLong(), valueOf, valueOf2));
                }
            }
        }
    };
    private boolean faZ = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void aOu() {
        aUH();
        super.aOu();
    }

    private void aUH() {
        ChatMessage chatMessage;
        boolean z;
        Iterator<ChatMessage> it = this.eIR.getData().getChatMessages().iterator();
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
            this.eIR.doSendText(chatMessage);
        }
    }

    public long qF(String str) {
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
    public void aNH() {
        final UserData user;
        super.aNH();
        if ((this.eIR instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.eIR).getUser()) != null) {
            x.b(new w<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.9
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.w
                public Boolean doInBackground() {
                    return Boolean.valueOf(e.aUl().bS(TbadkCoreApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                }
            }, new h<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                public void onReturnDataInUI(Boolean bool) {
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            PersonalChatActivity.this.eIQ.closeNotNotify();
                        } else {
                            PersonalChatActivity.this.eIQ.showNotNotfiy();
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
        if (!this.faZ) {
            this.faZ = true;
            aUI();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.HP().gK(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.eIR != null && (this.eIR instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.eIR).aVu();
        }
    }

    private void aUI() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void c(final UserData userData) {
        x.b(new w<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: Ww */
            public Void doInBackground() {
                e.aUl().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.eIQ = new PersonalChatView(this, this.eIR.getIsAcceptNotify());
        this.eIQ.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.faU = (PersonalChatView) this.eIQ;
        long longValue = com.baidu.tieba.im.sendmessage.a.eYu.longValue();
        if ((this.eIR instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.eIR).getUser()) != null) {
            this.mUser = user;
            this.eIQ.refreshPersonalHeadFooter(this.mUser.getName_show(), this.faR);
            this.eIQ.bindDataAndRefresh(this.eIR.getData(), longValue);
            this.eIQ.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.2
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        PersonalChatActivity.this.eIR.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void aNG() {
                }
            });
            if (!aUL()) {
                aUK();
            }
            if (!TextUtils.isEmpty(this.faT.aVt())) {
                this.faT.qJ(this.faT.aVt());
            }
        }
    }

    public PersonalMsglistModel aUJ() {
        return this.faT;
    }

    private void aUK() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.eIQ.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.eIR instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.eIR).getUser()) != null) {
                if (user.getUserType() == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    sendMessage(new CustomMessage(2002001, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
                }
            }
        } else if (view == this.faU.aUP()) {
            if (this.faT.aVv() == PersonalMsglistModel.CardStatus.APPLY || this.faT.aVv() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.faT.getUser().getUserId(), this.faT.getUser().getUserName(), this.faT.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.faT.aVv() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.e(com.baidu.adp.lib.g.b.d(this.faT.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean v(Bundle bundle) {
        try {
            registerListener(this.faX);
            registerListener(2001172, this.faY);
            registerListener(2001173, this.faY);
            registerListener(2001219, this.faY);
            registerListener(2001220, this.faY);
            registerListener(2001221, this.faY);
            registerListener(this.faW);
            registerListener(this.faP);
            if (PersonalChatActivityStatic.aUM() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.eIR = new PersonalMsglistModel(this);
            this.eIR.setLoadDataCallBack(this.eJb);
            this.faT = (PersonalMsglistModel) this.eIR;
            if (bundle != null) {
                w(bundle);
            } else {
                aNI();
            }
            return aNJ();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(d dVar) {
        this.eIR.loadFirst(dVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        a.C0258a qK;
        ChatMessage msg;
        String P;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.eIR.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (aOt() && (msg = this.eIR.getMsg(i2)) != null && com.baidu.tieba.im.util.e.t(msg) && (P = com.baidu.tieba.im.util.e.P(msg.getContent(), true)) != null && (this.eIR instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.eIR).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new PersonalMsgImageActivityConfig(getPageContext().getContext(), P, ((CommonPersonalMsglistModel) this.eIR).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.eIR.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (qK = com.baidu.tieba.imMessageCenter.im.stranger.a.qK(msg3.getContent())) != null) {
                    if (qK.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(qK.threadId, qK.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(qK.threadId, qK.postId, null)));
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
    public void x(Bundle bundle) {
        super.x(bundle);
        aNO();
        ((PersonalMsglistModel) this.eIR).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
        ((PersonalMsglistModel) this.eIR).setFollowStatus(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FOLLOW));
        ((PersonalMsglistModel) this.eIR).qI(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void Q(Intent intent) {
        super.Q(intent);
        aNO();
        ((PersonalMsglistModel) this.eIR).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
        ((PersonalMsglistModel) this.eIR).setFollowStatus(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FOLLOW, 1));
        ((PersonalMsglistModel) this.eIR).qI(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.eIR).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.eIR).aVt());
    }

    private void aNO() {
        if (this.eIR == null || !(this.eIR instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.eIR).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void aNM() {
        super.aNM();
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.3
            @Override // java.lang.Runnable
            public void run() {
                PersonalChatActivity.this.aNN();
            }
        }, 60L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNN() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            if (!k.isEmpty(stringExtra)) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
                this.eIR.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            if (!k.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
                this.eIR.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean aUL() {
        return ((PersonalMsglistModel) this.eIR).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.faV);
        }
        com.baidu.adp.lib.d.a.iW().a(this.locationCallBack);
    }
}
