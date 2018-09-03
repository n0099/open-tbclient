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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.relationship.b;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.g;
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
    private b eDK;
    private PersonalMsglistModel eDM;
    private PersonalChatView eDN;
    private UserData mUser;
    private CustomMessageListener eDI = new CustomMessageListener(2001305) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseNewFriendDataMessage)) {
                a data = ((ResponseNewFriendDataMessage) customResponsedMessage).getData();
                PersonalMsglistModel.CardStatus j = PersonalChatActivity.this.eDM.j(data);
                PersonalChatActivity.this.eDM.a(j);
                if (j != PersonalMsglistModel.CardStatus.AGREE) {
                    PersonalChatActivity.this.eDN.a(j, false, new String[0]);
                    return;
                }
                PersonalChatActivity.this.eDN.a(j, false, data.getContent());
            }
        }
    };
    private Handler mHandler = new Handler();
    private long eDJ = 0;
    private String eDL = TbadkCoreApplication.getCurrentAccount();
    private Runnable eDO = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.4
        @Override // java.lang.Runnable
        public void run() {
            PersonalChatActivity.this.elx.refreshPersonalHeadFooter(PersonalChatActivity.this.mUser.getName_show(), PersonalChatActivity.this.eDK);
            if (PersonalChatActivity.this.eDJ != 0) {
                PersonalChatActivity.this.mHandler.postDelayed(PersonalChatActivity.this.eDO, PersonalChatActivity.this.eDJ);
            }
        }
    };
    private CustomMessageListener eDP = new CustomMessageListener(2001214) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001214 && PersonalChatActivity.this.elx != null && PersonalChatActivity.this.elx.getAdapter() != null) {
                PersonalChatActivity.this.elx.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private c eDQ = new c(205101, true) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UserData user;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
                PersonalChatActivity.this.eDK = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
                if (PersonalChatActivity.this.eDK != null && (user = ((PersonalMsglistModel) PersonalChatActivity.this.ely).getUser()) != null) {
                    PersonalChatActivity.this.elx.refreshPersonalHeadFooter(user.getName_show(), PersonalChatActivity.this.eDK);
                    PersonalChatActivity.this.eDJ = PersonalChatActivity.this.oV(ap.u(PersonalChatActivity.this.eDK.getTime()));
                    if (PersonalChatActivity.this.eDJ != 0) {
                        PersonalChatActivity.this.mHandler.postDelayed(PersonalChatActivity.this.eDO, PersonalChatActivity.this.eDJ);
                    }
                    PersonalChatActivityStatic.aNU().a(PersonalChatActivity.this.eDL + "&" + user.getUserId(), new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(PersonalChatActivity.this.eDK, System.currentTimeMillis()));
                }
            }
        }
    };
    private CustomMessageListener eDR = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.7
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
                            if (optJSONObject != null && optJSONObject.optLong("user_id") == com.baidu.adp.lib.g.b.c(PersonalChatActivity.this.eDM.getUser().getUserId(), 0L)) {
                                String optString = optJSONObject.optString("message");
                                if (cmd.equals("apply_new_friend")) {
                                    PersonalChatActivity.this.eDN.a(PersonalMsglistModel.CardStatus.AGREE, true, optString);
                                    PersonalChatActivity.this.eDM.a(PersonalMsglistModel.CardStatus.AGREE);
                                } else if (cmd.equals("passed_new_friend")) {
                                    PersonalChatActivity.this.eDN.a(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                                    PersonalChatActivity.this.eDM.a(PersonalMsglistModel.CardStatus.PASS);
                                    PersonalChatActivity.this.eDM.setIsFriend(1);
                                    PersonalChatActivity.this.eDM.setFollowStatus(1);
                                    PersonalChatActivity.this.eDN.getBtnGroupInfo().setVisibility(0);
                                } else if (cmd.equals("apply_add_friend")) {
                                    PersonalChatActivity.this.eDN.a(PersonalMsglistModel.CardStatus.WAIT, true, new String[0]);
                                    PersonalChatActivity.this.eDM.a(PersonalMsglistModel.CardStatus.WAIT);
                                } else if (cmd.equals("apply_pass_friend")) {
                                    PersonalChatActivity.this.eDN.a(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                                    PersonalChatActivity.this.eDM.a(PersonalMsglistModel.CardStatus.PASS);
                                    PersonalChatActivity.this.eDM.setIsFriend(1);
                                    PersonalChatActivity.this.eDM.setFollowStatus(1);
                                    PersonalChatActivity.this.eDN.getBtnGroupInfo().setVisibility(0);
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
    private a.InterfaceC0014a locationCallBack = new a.InterfaceC0014a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.8
        @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                UserData user = ((PersonalMsglistModel) PersonalChatActivity.this.ely).getUser();
                if (user != null) {
                    PersonalChatActivity.this.mUser = user;
                    PersonalChatActivity.this.sendMessage(new RequestPersonalLbsInfoMessage(205101, user.getUserIdLong(), valueOf, valueOf2));
                }
            }
        }
    };
    private boolean eDS = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void aHy() {
        aNP();
        super.aHy();
    }

    private void aNP() {
        ChatMessage chatMessage;
        boolean z;
        Iterator<ChatMessage> it = this.ely.getData().getChatMessages().iterator();
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
            this.ely.doSendText(chatMessage);
        }
    }

    public long oV(String str) {
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
    public void aGL() {
        final UserData user;
        super.aGL();
        if ((this.ely instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.ely).getUser()) != null) {
            v.b(new u<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.9
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    return Boolean.valueOf(e.aNt().bt(TbadkCoreApplication.getCurrentAccount(), String.valueOf(user.getUserId())));
                }
            }, new g<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
                public void onReturnDataInUI(Boolean bool) {
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            PersonalChatActivity.this.elx.closeNotNotify();
                        } else {
                            PersonalChatActivity.this.elx.showNotNotfiy();
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
        if (!this.eDS) {
            this.eDS = true;
            aNQ();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().fG(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        if (this.ely != null && (this.ely instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.ely).aOC();
        }
    }

    private void aNQ() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void c(final UserData userData) {
        v.b(new u<Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: Rx */
            public Void doInBackground() {
                e.aNt().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        UserData user;
        this.elx = new PersonalChatView(this, this.ely.getIsAcceptNotify());
        this.elx.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.eDN = (PersonalChatView) this.elx;
        long longValue = com.baidu.tieba.im.sendmessage.a.eBm.longValue();
        if ((this.ely instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.ely).getUser()) != null) {
            this.mUser = user;
            this.elx.refreshPersonalHeadFooter(this.mUser.getName_show(), this.eDK);
            this.elx.bindDataAndRefresh(this.ely.getData(), longValue);
            this.elx.setRecordCallback(new AbsMsglistView.a() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.2
                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void d(VoiceData.VoiceModel voiceModel) {
                    if (voiceModel != null) {
                        PersonalChatActivity.this.ely.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
                    }
                }

                @Override // com.baidu.tieba.im.chat.AbsMsglistView.a
                public void aGK() {
                }
            });
            if (!aNT()) {
                aNS();
            }
            if (!TextUtils.isEmpty(this.eDM.aOB())) {
                this.eDM.oZ(this.eDM.aOB());
            }
        }
    }

    public PersonalMsglistModel aNR() {
        return this.eDM;
    }

    private void aNS() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.elx.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            if ((this.ely instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) this.ely).getUser()) != null) {
                sendMessage(new CustomMessage(2002001, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
            }
        } else if (view == this.eDN.aNX()) {
            if (this.eDM.aOD() == PersonalMsglistModel.CardStatus.APPLY || this.eDM.aOD() == PersonalMsglistModel.CardStatus.WAIT) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.eDM.getUser().getUserId(), this.eDM.getUser().getUserName(), this.eDM.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            } else if (this.eDM.aOD() == PersonalMsglistModel.CardStatus.AGREE) {
                com.baidu.tbadk.newFriends.a.b(com.baidu.adp.lib.g.b.c(this.eDM.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    protected boolean o(Bundle bundle) {
        try {
            registerListener(this.eDQ);
            registerListener(2001172, this.eDR);
            registerListener(2001173, this.eDR);
            registerListener(2001219, this.eDR);
            registerListener(2001220, this.eDR);
            registerListener(2001221, this.eDR);
            registerListener(this.eDP);
            registerListener(this.eDI);
            if (PersonalChatActivityStatic.aNU() == null) {
                PersonalChatActivityStatic.a(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.ely = new PersonalMsglistModel(this);
            this.ely.setLoadDataCallBack(this.elI);
            this.eDM = (PersonalMsglistModel) this.ely;
            if (bundle != null) {
                p(bundle);
            } else {
                aGM();
            }
            return aGN();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(d dVar) {
        this.ely.loadFirst(dVar);
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        a.C0185a pa;
        ChatMessage msg;
        String F;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg2 = this.ely.getMsg(i2);
                if (msg2 != null && msg2.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 4:
                if (aHx() && (msg = this.ely.getMsg(i2)) != null && com.baidu.tieba.im.util.e.t(msg) && (F = com.baidu.tieba.im.util.e.F(msg.getContent(), true)) != null && (this.ely instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.ely).getUser() != null) {
                    sendMessage(new CustomMessage(2002001, new PersonalMsgImageActivityConfig(getPageContext().getContext(), F, ((CommonPersonalMsglistModel) this.ely).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                    return;
                }
                return;
            case 14:
                ChatMessage msg3 = this.ely.getMsg(i2);
                if (msg3 != null && msg3.getContent() != null && (pa = com.baidu.tieba.imMessageCenter.im.stranger.a.pa(msg3.getContent())) != null) {
                    if (pa.type == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(pa.threadId, pa.postId, null, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(pa.threadId, pa.postId, null)));
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
    public void q(Bundle bundle) {
        super.q(bundle);
        aGS();
        ((PersonalMsglistModel) this.ely).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
        ((PersonalMsglistModel) this.ely).setFollowStatus(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FOLLOW));
        ((PersonalMsglistModel) this.ely).oY(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void M(Intent intent) {
        super.M(intent);
        aGS();
        ((PersonalMsglistModel) this.ely).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
        ((PersonalMsglistModel) this.ely).setFollowStatus(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FOLLOW, 1));
        ((PersonalMsglistModel) this.ely).oY(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.ely).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.ely).aOB());
    }

    private void aGS() {
        if (this.ely == null || !(this.ely instanceof PersonalMsglistModel)) {
            ChatStatusManager.getInst().setCurId(0, "");
            return;
        }
        UserData user = ((PersonalMsglistModel) this.ely).getUser();
        if (user != null) {
            ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
        } else {
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void aGQ() {
        super.aGQ();
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivity.3
            @Override // java.lang.Runnable
            public void run() {
                PersonalChatActivity.this.aGR();
            }
        }, 60L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGR() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            if (!k.isEmpty(stringExtra)) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
                this.ely.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            if (!k.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
                this.ely.sendTextMessage(stringExtra2);
            }
        }
    }

    public boolean aNT() {
        return ((PersonalMsglistModel) this.ely).getIsFriend() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.eDO);
        }
        com.baidu.adp.lib.d.a.hB().a(this.locationCallBack);
    }
}
