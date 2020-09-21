package com.baidu.tieba.imMessageCenter.im.chat;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbEnum;
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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.relationship.b;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
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
/* loaded from: classes21.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    private PersonalMsglistModel jJB;
    private PersonalChatView jJC;
    private b jJz;
    private UserData mUser;
    private CustomMessageListener jJx = new CustomMessageListener(CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseNewFriendDataMessage)) {
                a data = ((ResponseNewFriendDataMessage) customResponsedMessage).getData();
                PersonalMsglistModel.CardStatus j = PersonalChatActivity.this.jJB.j(data);
                PersonalChatActivity.this.jJB.a(j);
                if (j != PersonalMsglistModel.CardStatus.AGREE) {
                    PersonalChatActivity.this.jJC.a(j, false, new String[0]);
                    return;
                }
                PersonalChatActivity.this.jJC.a(j, false, data.getContent());
            }
        }
    };
    private Handler mHandler = new Handler();
    private long jJy = 0;
    private String jJA = TbadkCoreApplication.getCurrentAccount();
    private Runnable jJD = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.4
        @Override // java.lang.Runnable
        public void run() {
            PersonalChatActivity.this.jpl.refreshPersonalHeadFooter(PersonalChatActivity.this.mUser.getName_show(), PersonalChatActivity.this.jJz);
            if (PersonalChatActivity.this.jJy != 0) {
                PersonalChatActivity.this.mHandler.postDelayed(PersonalChatActivity.this.jJD, PersonalChatActivity.this.jJy);
            }
        }
    };
    private CustomMessageListener jJE = new CustomMessageListener(CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001214 && PersonalChatActivity.this.jpl != null && PersonalChatActivity.this.jpl.getAdapter() != null) {
                PersonalChatActivity.this.jpl.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private c jJF = new c(CmdConfigSocket.CMD_PERSONAL_CHAT_LBS_INFO, true) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UserData user;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
                PersonalChatActivity.this.jJz = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
                if (PersonalChatActivity.this.jJz != null && (user = ((PersonalMsglistModel) PersonalChatActivity.this.jpm).getUser()) != null) {
                    PersonalChatActivity.this.jpl.refreshPersonalHeadFooter(user.getName_show(), PersonalChatActivity.this.jJz);
                    PersonalChatActivity.this.jJy = PersonalChatActivity.this.LL(at.getTimeInterval(PersonalChatActivity.this.jJz.getTime()));
                    if (PersonalChatActivity.this.jJy != 0) {
                        PersonalChatActivity.this.mHandler.postDelayed(PersonalChatActivity.this.jJD, PersonalChatActivity.this.jJy);
                    }
                    PersonalChatActivityStatic.cMt().a(PersonalChatActivity.this.jJA + ETAG.ITEM_SEPARATOR + user.getUserId(), new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(PersonalChatActivity.this.jJz, System.currentTimeMillis()));
                }
            }
        }
    };
    private CustomMessageListener jJG = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.7
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
                            JSONObject optJSONObject = new JSONObject(content).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                            if (optJSONObject != null && optJSONObject.optLong("user_id") == com.baidu.adp.lib.f.b.toLong(PersonalChatActivity.this.jJB.getUser().getUserId(), 0L)) {
                                String optString = optJSONObject.optString("message");
                                if (cmd.equals("apply_new_friend")) {
                                    PersonalChatActivity.this.jJC.a(PersonalMsglistModel.CardStatus.AGREE, true, optString);
                                    PersonalChatActivity.this.jJB.a(PersonalMsglistModel.CardStatus.AGREE);
                                } else if (cmd.equals("passed_new_friend")) {
                                    PersonalChatActivity.this.jJC.a(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                                    PersonalChatActivity.this.jJB.a(PersonalMsglistModel.CardStatus.PASS);
                                    PersonalChatActivity.this.jJB.setIsFriend(1);
                                    PersonalChatActivity.this.jJB.setFollowStatus(1);
                                    PersonalChatActivity.this.jJC.getBtnGroupInfo().setVisibility(0);
                                } else if (cmd.equals("apply_add_friend")) {
                                    PersonalChatActivity.this.jJC.a(PersonalMsglistModel.CardStatus.WAIT, true, new String[0]);
                                    PersonalChatActivity.this.jJB.a(PersonalMsglistModel.CardStatus.WAIT);
                                } else if (cmd.equals("apply_pass_friend")) {
                                    PersonalChatActivity.this.jJC.a(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                                    PersonalChatActivity.this.jJB.a(PersonalMsglistModel.CardStatus.PASS);
                                    PersonalChatActivity.this.jJB.setIsFriend(1);
                                    PersonalChatActivity.this.jJB.setFollowStatus(1);
                                    PersonalChatActivity.this.jJC.getBtnGroupInfo().setVisibility(0);
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
    private a.InterfaceC0019a locationCallBack = new a.InterfaceC0019a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.8
        @Override // com.baidu.adp.lib.c.a.InterfaceC0019a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                UserData user = ((PersonalMsglistModel) PersonalChatActivity.this.jpm).getUser();
                if (user != null) {
                    PersonalChatActivity.this.mUser = user;
                    PersonalChatActivity.this.sendMessage(new RequestPersonalLbsInfoMessage(CmdConfigSocket.CMD_PERSONAL_CHAT_LBS_INFO, user.getUserIdLong(), valueOf, valueOf2));
                }
            }
        }
    };
    private boolean jJH = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void cFF() {
        cMn();
        super.cFF();
    }

    private void cMn() {
        ChatMessage chatMessage;
        boolean z;
        Iterator<ChatMessage> it = this.jpm.getData().getChatMessages().iterator();
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
            this.jpm.doSendText(chatMessage);
        }
    }

    public long LL(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        if (str.contains("分钟") || str.contains("刚刚")) {
            return 60000L;
        }
        if (str.contains("小时")) {
            return BdKVCache.MILLS_1Hour;
        }
        return str.contains("天") ? 86400000L : 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void cES() {
        final UserData user;
        super.cES();
        if ((this.jpm instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.jpm).getUser()) != null) {
            ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.9
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ad
                public Boolean doInBackground() {
                    return Boolean.valueOf(e.cLR().fh(TbadkCoreApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                }
            }, new m<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                public void onReturnDataInUI(Boolean bool) {
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            PersonalChatActivity.this.jpl.closeNotNotify();
                        } else {
                            PersonalChatActivity.this.jpl.showNotNotfiy();
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
        if (!this.jJH) {
            this.jJH = true;
            cMo();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.b.boP().Bx(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.jpm != null && (this.jpm instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.jpm).cNa();
        }
    }

    private void cMo() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void b(final UserData userData) {
        ae.b(new ad<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bCO */
            public Void doInBackground() {
                e.cLR().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.jpl = new PersonalChatView(this, this.jpm.getIsAcceptNotify());
        this.jpl.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.jJC = (PersonalChatView) this.jpl;
        long longValue = com.baidu.tieba.im.sendmessage.a.jHd.longValue();
        if ((this.jpm instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.jpm).getUser()) != null) {
            this.mUser = user;
            this.jpl.refreshPersonalHeadFooter(this.mUser.getName_show(), this.jJz);
            this.jpl.bindDataAndRefresh(this.jpm.getData(), longValue);
            this.jpl.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.2
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void e(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        PersonalChatActivity.this.jpm.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void cER() {
                }
            });
            if (!cMr()) {
                cMq();
            }
            if (!TextUtils.isEmpty(this.jJB.cMZ())) {
                this.jJB.LP(this.jJB.cMZ());
            }
        }
    }

    public PersonalMsglistModel cMp() {
        return this.jJB;
    }

    private void cMq() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.jpl.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.jpm instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.jpm).getUser()) != null) {
                if (user.getUserType() == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
                }
            }
        } else if (view == this.jJC.cMw()) {
            if (this.jJB.cNb() == PersonalMsglistModel.CardStatus.APPLY || this.jJB.cNb() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.jJB.getUser().getUserId(), this.jJB.getUser().getUserName(), this.jJB.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.jJB.cNb() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.g(com.baidu.adp.lib.f.b.toLong(this.jJB.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean at(Bundle bundle) {
        try {
            registerListener(this.jJF);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.jJG);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.jJG);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.jJG);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.jJG);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.jJG);
            registerListener(this.jJE);
            registerListener(this.jJx);
            if (PersonalChatActivityStatic.cMt() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.jpm = new PersonalMsglistModel(this);
            this.jpm.setLoadDataCallBack(this.jpw);
            this.jJB = (PersonalMsglistModel) this.jpm;
            if (bundle != null) {
                au(bundle);
            } else {
                cET();
            }
            return cEU();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(d dVar) {
        this.jpm.loadFirst(dVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        a.C0724a LQ;
        ChatMessage msg;
        String aL;
        super.onItemViewClick(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.jpm.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (cFE() && (msg = this.jpm.getMsg(i2)) != null && com.baidu.tieba.im.util.e.o(msg) && (aL = com.baidu.tieba.im.util.e.aL(msg.getContent(), true)) != null && (this.jpm instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.jpm).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), aL, ((CommonPersonalMsglistModel) this.jpm).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.jpm.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (LQ = com.baidu.tieba.imMessageCenter.im.stranger.a.LQ(msg3.getContent())) != null) {
                    if (LQ.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(LQ.threadId, LQ.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(LQ.threadId, LQ.postId, null)));
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
    public void av(Bundle bundle) {
        super.av(bundle);
        cEZ();
        ((PersonalMsglistModel) this.jpm).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
        ((PersonalMsglistModel) this.jpm).setFollowStatus(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FOLLOW));
        ((PersonalMsglistModel) this.jpm).LO(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void Y(Intent intent) {
        super.Y(intent);
        cEZ();
        ((PersonalMsglistModel) this.jpm).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
        ((PersonalMsglistModel) this.jpm).setFollowStatus(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FOLLOW, 1));
        ((PersonalMsglistModel) this.jpm).LO(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.jpm).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.jpm).cMZ());
    }

    private void cEZ() {
        if (this.jpm == null || !(this.jpm instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.jpm).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void cEX() {
        super.cEX();
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.3
            @Override // java.lang.Runnable
            public void run() {
                PersonalChatActivity.this.cEY();
            }
        }, 60L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEY() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            if (!k.isEmpty(stringExtra)) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
                this.jpm.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            if (!k.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
                this.jpm.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean cMr() {
        return ((PersonalMsglistModel) this.jpm).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.jJD);
        }
        com.baidu.adp.lib.c.a.mj().a(this.locationCallBack);
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (!cMs()) {
            super.finish();
        }
    }

    private boolean cMs() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this).areNotificationsEnabled();
        boolean z = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_private_chat_show_notification", false);
        if (areNotificationsEnabled || z) {
            return false;
        }
        com.baidu.tbadk.coreExtra.c.a.a(getPageContext(), new boolean[]{true, false}, 3);
        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_private_chat_show_notification", true);
        return true;
    }
}
