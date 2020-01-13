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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.relationship.b;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.l;
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
/* loaded from: classes7.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    private b hJq;
    private PersonalMsglistModel hJs;
    private PersonalChatView hJt;
    private UserData mUser;
    private CustomMessageListener hJo = new CustomMessageListener(CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseNewFriendDataMessage)) {
                a data = ((ResponseNewFriendDataMessage) customResponsedMessage).getData();
                PersonalMsglistModel.CardStatus j = PersonalChatActivity.this.hJs.j(data);
                PersonalChatActivity.this.hJs.a(j);
                if (j != PersonalMsglistModel.CardStatus.AGREE) {
                    PersonalChatActivity.this.hJt.a(j, false, new String[0]);
                    return;
                }
                PersonalChatActivity.this.hJt.a(j, false, data.getContent());
            }
        }
    };
    private Handler mHandler = new Handler();
    private long hJp = 0;
    private String hJr = TbadkCoreApplication.getCurrentAccount();
    private Runnable hJu = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.4
        @Override // java.lang.Runnable
        public void run() {
            PersonalChatActivity.this.hrn.refreshPersonalHeadFooter(PersonalChatActivity.this.mUser.getName_show(), PersonalChatActivity.this.hJq);
            if (PersonalChatActivity.this.hJp != 0) {
                PersonalChatActivity.this.mHandler.postDelayed(PersonalChatActivity.this.hJu, PersonalChatActivity.this.hJp);
            }
        }
    };
    private CustomMessageListener hJv = new CustomMessageListener(CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001214 && PersonalChatActivity.this.hrn != null && PersonalChatActivity.this.hrn.getAdapter() != null) {
                PersonalChatActivity.this.hrn.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private c hJw = new c(CmdConfigSocket.CMD_PERSONAL_CHAT_LBS_INFO, true) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UserData user;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
                PersonalChatActivity.this.hJq = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
                if (PersonalChatActivity.this.hJq != null && (user = ((PersonalMsglistModel) PersonalChatActivity.this.hro).getUser()) != null) {
                    PersonalChatActivity.this.hrn.refreshPersonalHeadFooter(user.getName_show(), PersonalChatActivity.this.hJq);
                    PersonalChatActivity.this.hJp = PersonalChatActivity.this.Do(aq.getTimeInterval(PersonalChatActivity.this.hJq.getTime()));
                    if (PersonalChatActivity.this.hJp != 0) {
                        PersonalChatActivity.this.mHandler.postDelayed(PersonalChatActivity.this.hJu, PersonalChatActivity.this.hJp);
                    }
                    PersonalChatActivityStatic.bXa().a(PersonalChatActivity.this.hJr + ETAG.ITEM_SEPARATOR + user.getUserId(), new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(PersonalChatActivity.this.hJq, System.currentTimeMillis()));
                }
            }
        }
    };
    private CustomMessageListener hJx = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.7
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
                            if (optJSONObject != null && optJSONObject.optLong("user_id") == com.baidu.adp.lib.f.b.toLong(PersonalChatActivity.this.hJs.getUser().getUserId(), 0L)) {
                                String optString = optJSONObject.optString("message");
                                if (cmd.equals("apply_new_friend")) {
                                    PersonalChatActivity.this.hJt.a(PersonalMsglistModel.CardStatus.AGREE, true, optString);
                                    PersonalChatActivity.this.hJs.a(PersonalMsglistModel.CardStatus.AGREE);
                                } else if (cmd.equals("passed_new_friend")) {
                                    PersonalChatActivity.this.hJt.a(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                                    PersonalChatActivity.this.hJs.a(PersonalMsglistModel.CardStatus.PASS);
                                    PersonalChatActivity.this.hJs.setIsFriend(1);
                                    PersonalChatActivity.this.hJs.setFollowStatus(1);
                                    PersonalChatActivity.this.hJt.getBtnGroupInfo().setVisibility(0);
                                } else if (cmd.equals("apply_add_friend")) {
                                    PersonalChatActivity.this.hJt.a(PersonalMsglistModel.CardStatus.WAIT, true, new String[0]);
                                    PersonalChatActivity.this.hJs.a(PersonalMsglistModel.CardStatus.WAIT);
                                } else if (cmd.equals("apply_pass_friend")) {
                                    PersonalChatActivity.this.hJt.a(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                                    PersonalChatActivity.this.hJs.a(PersonalMsglistModel.CardStatus.PASS);
                                    PersonalChatActivity.this.hJs.setIsFriend(1);
                                    PersonalChatActivity.this.hJs.setFollowStatus(1);
                                    PersonalChatActivity.this.hJt.getBtnGroupInfo().setVisibility(0);
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
    private a.InterfaceC0016a locationCallBack = new a.InterfaceC0016a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.8
        @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                UserData user = ((PersonalMsglistModel) PersonalChatActivity.this.hro).getUser();
                if (user != null) {
                    PersonalChatActivity.this.mUser = user;
                    PersonalChatActivity.this.sendMessage(new RequestPersonalLbsInfoMessage(CmdConfigSocket.CMD_PERSONAL_CHAT_LBS_INFO, user.getUserIdLong(), valueOf, valueOf2));
                }
            }
        }
    };
    private boolean hJy = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void bQO() {
        bWV();
        super.bQO();
    }

    private void bWV() {
        ChatMessage chatMessage;
        boolean z;
        Iterator<ChatMessage> it = this.hro.getData().getChatMessages().iterator();
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
            this.hro.doSendText(chatMessage);
        }
    }

    public long Do(String str) {
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
    public void bQb() {
        final UserData user;
        super.bQb();
        if ((this.hro instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.hro).getUser()) != null) {
            ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.9
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    return Boolean.valueOf(e.bWz().dx(TbadkCoreApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                }
            }, new l<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                public void onReturnDataInUI(Boolean bool) {
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            PersonalChatActivity.this.hrn.closeNotNotify();
                        } else {
                            PersonalChatActivity.this.hrn.showNotNotfiy();
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
        if (!this.hJy) {
            this.hJy = true;
            bWW();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.b.aIj().tX(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.hro != null && (this.hro instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.hro).bXG();
        }
    }

    private void bWW() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void b(final UserData userData) {
        ac.b(new ab<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: aWq */
            public Void doInBackground() {
                e.bWz().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.hrn = new PersonalChatView(this, this.hro.getIsAcceptNotify());
        this.hrn.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.hJt = (PersonalChatView) this.hrn;
        long longValue = com.baidu.tieba.im.sendmessage.a.hGW.longValue();
        if ((this.hro instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.hro).getUser()) != null) {
            this.mUser = user;
            this.hrn.refreshPersonalHeadFooter(this.mUser.getName_show(), this.hJq);
            this.hrn.bindDataAndRefresh(this.hro.getData(), longValue);
            this.hrn.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.2
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        PersonalChatActivity.this.hro.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void bQa() {
                }
            });
            if (!bWZ()) {
                bWY();
            }
            if (!TextUtils.isEmpty(this.hJs.bXF())) {
                this.hJs.Ds(this.hJs.bXF());
            }
        }
    }

    public PersonalMsglistModel bWX() {
        return this.hJs;
    }

    private void bWY() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.hrn.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.hro instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.hro).getUser()) != null) {
                if (user.getUserType() == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
                }
            }
        } else if (view == this.hJt.bXd()) {
            if (this.hJs.bXH() == PersonalMsglistModel.CardStatus.APPLY || this.hJs.bXH() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.hJs.getUser().getUserId(), this.hJs.getUser().getUserName(), this.hJs.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.hJs.bXH() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.c(com.baidu.adp.lib.f.b.toLong(this.hJs.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean am(Bundle bundle) {
        try {
            registerListener(this.hJw);
            registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.hJx);
            registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.hJx);
            registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.hJx);
            registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.hJx);
            registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.hJx);
            registerListener(this.hJv);
            registerListener(this.hJo);
            if (PersonalChatActivityStatic.bXa() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.hro = new PersonalMsglistModel(this);
            this.hro.setLoadDataCallBack(this.hry);
            this.hJs = (PersonalMsglistModel) this.hro;
            if (bundle != null) {
                an(bundle);
            } else {
                bQc();
            }
            return bQd();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(d dVar) {
        this.hro.loadFirst(dVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        a.C0534a Dt;
        ChatMessage msg;
        String ao;
        super.onItemViewClick(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.hro.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (bQN() && (msg = this.hro.getMsg(i2)) != null && com.baidu.tieba.im.util.e.o(msg) && (ao = com.baidu.tieba.im.util.e.ao(msg.getContent(), true)) != null && (this.hro instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.hro).getUser() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), ao, ((CommonPersonalMsglistModel) this.hro).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.hro.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (Dt = com.baidu.tieba.imMessageCenter.im.stranger.a.Dt(msg3.getContent())) != null) {
                    if (Dt.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(Dt.threadId, Dt.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(Dt.threadId, Dt.postId, null)));
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
    public void ao(Bundle bundle) {
        super.ao(bundle);
        bQi();
        ((PersonalMsglistModel) this.hro).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
        ((PersonalMsglistModel) this.hro).setFollowStatus(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FOLLOW));
        ((PersonalMsglistModel) this.hro).Dr(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void an(Intent intent) {
        super.an(intent);
        bQi();
        ((PersonalMsglistModel) this.hro).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
        ((PersonalMsglistModel) this.hro).setFollowStatus(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FOLLOW, 1));
        ((PersonalMsglistModel) this.hro).Dr(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.hro).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.hro).bXF());
    }

    private void bQi() {
        if (this.hro == null || !(this.hro instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.hro).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void bQg() {
        super.bQg();
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.3
            @Override // java.lang.Runnable
            public void run() {
                PersonalChatActivity.this.bQh();
            }
        }, 60L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQh() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            if (!k.isEmpty(stringExtra)) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
                this.hro.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            if (!k.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
                this.hro.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean bWZ() {
        return ((PersonalMsglistModel) this.hro).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.hJu);
        }
        com.baidu.adp.lib.c.a.fK().a(this.locationCallBack);
    }
}
