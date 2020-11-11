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
/* loaded from: classes22.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    private b kqS;
    private PersonalMsglistModel kqU;
    private PersonalChatView kqV;
    private UserData mUser;
    private CustomMessageListener kqQ = new CustomMessageListener(CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseNewFriendDataMessage)) {
                a data = ((ResponseNewFriendDataMessage) customResponsedMessage).getData();
                PersonalMsglistModel.CardStatus j = PersonalChatActivity.this.kqU.j(data);
                PersonalChatActivity.this.kqU.a(j);
                if (j != PersonalMsglistModel.CardStatus.AGREE) {
                    PersonalChatActivity.this.kqV.a(j, false, new String[0]);
                    return;
                }
                PersonalChatActivity.this.kqV.a(j, false, data.getContent());
            }
        }
    };
    private Handler mHandler = new Handler();
    private long kqR = 0;
    private String kqT = TbadkCoreApplication.getCurrentAccount();
    private Runnable kqW = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.4
        @Override // java.lang.Runnable
        public void run() {
            PersonalChatActivity.this.jWE.refreshPersonalHeadFooter(PersonalChatActivity.this.mUser.getName_show(), PersonalChatActivity.this.kqS);
            if (PersonalChatActivity.this.kqR != 0) {
                PersonalChatActivity.this.mHandler.postDelayed(PersonalChatActivity.this.kqW, PersonalChatActivity.this.kqR);
            }
        }
    };
    private CustomMessageListener kqX = new CustomMessageListener(CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001214 && PersonalChatActivity.this.jWE != null && PersonalChatActivity.this.jWE.getAdapter() != null) {
                PersonalChatActivity.this.jWE.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private c kqY = new c(CmdConfigSocket.CMD_PERSONAL_CHAT_LBS_INFO, true) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UserData user;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
                PersonalChatActivity.this.kqS = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
                if (PersonalChatActivity.this.kqS != null && (user = ((PersonalMsglistModel) PersonalChatActivity.this.jWF).getUser()) != null) {
                    PersonalChatActivity.this.jWE.refreshPersonalHeadFooter(user.getName_show(), PersonalChatActivity.this.kqS);
                    PersonalChatActivity.this.kqR = PersonalChatActivity.this.Np(at.getTimeInterval(PersonalChatActivity.this.kqS.getTime()));
                    if (PersonalChatActivity.this.kqR != 0) {
                        PersonalChatActivity.this.mHandler.postDelayed(PersonalChatActivity.this.kqW, PersonalChatActivity.this.kqR);
                    }
                    PersonalChatActivityStatic.cVJ().a(PersonalChatActivity.this.kqT + ETAG.ITEM_SEPARATOR + user.getUserId(), new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(PersonalChatActivity.this.kqS, System.currentTimeMillis()));
                }
            }
        }
    };
    private CustomMessageListener kqZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.7
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
                            if (optJSONObject != null && optJSONObject.optLong("user_id") == com.baidu.adp.lib.f.b.toLong(PersonalChatActivity.this.kqU.getUser().getUserId(), 0L)) {
                                String optString = optJSONObject.optString("message");
                                if (cmd.equals("apply_new_friend")) {
                                    PersonalChatActivity.this.kqV.a(PersonalMsglistModel.CardStatus.AGREE, true, optString);
                                    PersonalChatActivity.this.kqU.a(PersonalMsglistModel.CardStatus.AGREE);
                                } else if (cmd.equals("passed_new_friend")) {
                                    PersonalChatActivity.this.kqV.a(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                                    PersonalChatActivity.this.kqU.a(PersonalMsglistModel.CardStatus.PASS);
                                    PersonalChatActivity.this.kqU.setIsFriend(1);
                                    PersonalChatActivity.this.kqU.setFollowStatus(1);
                                    PersonalChatActivity.this.kqV.getBtnGroupInfo().setVisibility(0);
                                } else if (cmd.equals("apply_add_friend")) {
                                    PersonalChatActivity.this.kqV.a(PersonalMsglistModel.CardStatus.WAIT, true, new String[0]);
                                    PersonalChatActivity.this.kqU.a(PersonalMsglistModel.CardStatus.WAIT);
                                } else if (cmd.equals("apply_pass_friend")) {
                                    PersonalChatActivity.this.kqV.a(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                                    PersonalChatActivity.this.kqU.a(PersonalMsglistModel.CardStatus.PASS);
                                    PersonalChatActivity.this.kqU.setIsFriend(1);
                                    PersonalChatActivity.this.kqU.setFollowStatus(1);
                                    PersonalChatActivity.this.kqV.getBtnGroupInfo().setVisibility(0);
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
    private a.InterfaceC0020a locationCallBack = new a.InterfaceC0020a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.8
        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                UserData user = ((PersonalMsglistModel) PersonalChatActivity.this.jWF).getUser();
                if (user != null) {
                    PersonalChatActivity.this.mUser = user;
                    PersonalChatActivity.this.sendMessage(new RequestPersonalLbsInfoMessage(CmdConfigSocket.CMD_PERSONAL_CHAT_LBS_INFO, user.getUserIdLong(), valueOf, valueOf2));
                }
            }
        }
    };
    private boolean kra = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void cOW() {
        cVD();
        super.cOW();
    }

    private void cVD() {
        ChatMessage chatMessage;
        boolean z;
        Iterator<ChatMessage> it = this.jWF.getData().getChatMessages().iterator();
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
            this.jWF.doSendText(chatMessage);
        }
    }

    public long Np(String str) {
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
    public void cOj() {
        final UserData user;
        super.cOj();
        if ((this.jWF instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.jWF).getUser()) != null) {
            ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.9
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ad
                public Boolean doInBackground() {
                    return Boolean.valueOf(e.cVh().ft(TbadkCoreApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                }
            }, new m<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                public void onReturnDataInUI(Boolean bool) {
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            PersonalChatActivity.this.jWE.closeNotNotify();
                        } else {
                            PersonalChatActivity.this.jWE.showNotNotfiy();
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
        if (!this.kra) {
            this.kra = true;
            cVE();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.b.bvS().CQ(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.jWF != null && (this.jWF instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.jWF).cWq();
        }
    }

    private void cVE() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void b(final UserData userData) {
        ae.b(new ad<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bJS */
            public Void doInBackground() {
                e.cVh().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.jWE = new PersonalChatView(this, this.jWF.getIsAcceptNotify());
        this.jWE.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.kqV = (PersonalChatView) this.jWE;
        long longValue = com.baidu.tieba.im.sendmessage.a.kox.longValue();
        if ((this.jWF instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.jWF).getUser()) != null) {
            this.mUser = user;
            this.jWE.refreshPersonalHeadFooter(this.mUser.getName_show(), this.kqS);
            this.jWE.bindDataAndRefresh(this.jWF.getData(), longValue);
            this.jWE.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.2
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void e(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        PersonalChatActivity.this.jWF.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void cOi() {
                }
            });
            if (!cVH()) {
                cVG();
            }
            if (!TextUtils.isEmpty(this.kqU.cWp())) {
                this.kqU.Nt(this.kqU.cWp());
            }
        }
    }

    public PersonalMsglistModel cVF() {
        return this.kqU;
    }

    private void cVG() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.jWE.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.jWF instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.jWF).getUser()) != null) {
                if (user.getUserType() == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
                }
            }
        } else if (view == this.kqV.cVM()) {
            if (this.kqU.cWr() == PersonalMsglistModel.CardStatus.APPLY || this.kqU.cWr() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.kqU.getUser().getUserId(), this.kqU.getUser().getUserName(), this.kqU.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.kqU.cWr() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.i(com.baidu.adp.lib.f.b.toLong(this.kqU.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean at(Bundle bundle) {
        try {
            registerListener(this.kqY);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.kqZ);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.kqZ);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.kqZ);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.kqZ);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.kqZ);
            registerListener(this.kqX);
            registerListener(this.kqQ);
            if (PersonalChatActivityStatic.cVJ() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.jWF = new PersonalMsglistModel(this);
            this.jWF.setLoadDataCallBack(this.jWP);
            this.kqU = (PersonalMsglistModel) this.jWF;
            if (bundle != null) {
                au(bundle);
            } else {
                cOk();
            }
            return cOl();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(d dVar) {
        this.jWF.loadFirst(dVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        a.C0772a Nu;
        ChatMessage msg;
        String aR;
        super.onItemViewClick(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.jWF.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (cOV() && (msg = this.jWF.getMsg(i2)) != null && com.baidu.tieba.im.util.e.o(msg) && (aR = com.baidu.tieba.im.util.e.aR(msg.getContent(), true)) != null && (this.jWF instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.jWF).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), aR, ((CommonPersonalMsglistModel) this.jWF).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.jWF.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (Nu = com.baidu.tieba.imMessageCenter.im.stranger.a.Nu(msg3.getContent())) != null) {
                    if (Nu.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(Nu.threadId, Nu.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(Nu.threadId, Nu.postId, null)));
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
        cOq();
        ((PersonalMsglistModel) this.jWF).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
        ((PersonalMsglistModel) this.jWF).setFollowStatus(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FOLLOW));
        ((PersonalMsglistModel) this.jWF).Ns(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void W(Intent intent) {
        super.W(intent);
        cOq();
        ((PersonalMsglistModel) this.jWF).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
        ((PersonalMsglistModel) this.jWF).setFollowStatus(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FOLLOW, 1));
        ((PersonalMsglistModel) this.jWF).Ns(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.jWF).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.jWF).cWp());
    }

    private void cOq() {
        if (this.jWF == null || !(this.jWF instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.jWF).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void cOo() {
        super.cOo();
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.3
            @Override // java.lang.Runnable
            public void run() {
                PersonalChatActivity.this.cOp();
            }
        }, 60L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOp() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            if (!k.isEmpty(stringExtra)) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
                this.jWF.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            if (!k.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
                this.jWF.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean cVH() {
        return ((PersonalMsglistModel) this.jWF).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.kqW);
        }
        com.baidu.adp.lib.c.a.mk().a(this.locationCallBack);
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (!cVI()) {
            super.finish();
        }
    }

    private boolean cVI() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this).areNotificationsEnabled();
        boolean z = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("key_private_chat_show_notification", false);
        if (areNotificationsEnabled || z) {
            return false;
        }
        com.baidu.tbadk.coreExtra.c.a.a(getPageContext(), new boolean[]{true, false}, 3);
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_private_chat_show_notification", true);
        return true;
    }
}
