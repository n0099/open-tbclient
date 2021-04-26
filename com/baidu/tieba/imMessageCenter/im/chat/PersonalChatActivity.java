package com.baidu.tieba.imMessageCenter.im.chat;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.imMessageCenter.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestNewFriendDataMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.RequestPersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.webkit.sdk.VideoCloudSetting;
import d.a.c.e.i.a;
import d.a.i0.z0.f0;
import d.a.i0.z0.h0;
import d.a.i0.z0.n;
import d.a.j0.f1.a.e.a;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    public PersonalMsglistModel mCurrentModel;
    public PersonalChatView mCurrentView;
    public d.a.i0.s.f.b mLbs;
    public UserData mUser;
    public CustomMessageListener getNewFriend = new c(2001305);
    public Handler mHandler = new Handler();
    public long timeGrade = 0;
    public String curruntId = TbadkCoreApplication.getCurrentAccount();
    public Runnable mRefreshTitleRunnable = new d();
    public CustomMessageListener joinGroupListener = new e(2001214);
    public d.a.c.c.g.c getLbsInfoListener = new f(205101, true);
    public CustomMessageListener addFriendStateChanged = new g(0);
    public a.c locationCallBack = new h();
    public boolean sendFinishMessage = false;

    /* loaded from: classes4.dex */
    public class a implements AbsMsglistView.f {
        public a() {
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.f
        public void a() {
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.f
        public void b(VoiceData$VoiceModel voiceData$VoiceModel) {
            if (voiceData$VoiceModel != null) {
                PersonalChatActivity.this.mListModel.sendMsgVoice(voiceData$VoiceModel.voiceId, voiceData$VoiceModel.duration);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PersonalChatActivity.this.sendAutoMessage();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseNewFriendDataMessage)) {
                return;
            }
            d.a.j0.e1.g.a data = ((ResponseNewFriendDataMessage) customResponsedMessage).getData();
            PersonalMsglistModel.CardStatus C = PersonalChatActivity.this.mCurrentModel.C(data);
            PersonalChatActivity.this.mCurrentModel.J(C);
            if (C != PersonalMsglistModel.CardStatus.AGREE) {
                PersonalChatActivity.this.mCurrentView.n(C, false, new String[0]);
                return;
            }
            PersonalChatActivity.this.mCurrentView.n(C, false, data.a());
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PersonalChatActivity.this.mListView.refreshPersonalHeadFooter(PersonalChatActivity.this.mUser.getName_show(), PersonalChatActivity.this.mLbs);
            if (PersonalChatActivity.this.timeGrade != 0) {
                PersonalChatActivity.this.mHandler.postDelayed(PersonalChatActivity.this.mRefreshTitleRunnable, PersonalChatActivity.this.timeGrade);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001214 || PersonalChatActivity.this.mListView == null || PersonalChatActivity.this.mListView.getAdapter() == null) {
                return;
            }
            PersonalChatActivity.this.mListView.getAdapter().g();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends d.a.c.c.g.c {
        public f(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UserData user;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
                PersonalChatActivity.this.mLbs = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
                if (PersonalChatActivity.this.mLbs == null || (user = ((PersonalMsglistModel) PersonalChatActivity.this.mListModel).getUser()) == null) {
                    return;
                }
                PersonalChatActivity.this.mListView.refreshPersonalHeadFooter(user.getName_show(), PersonalChatActivity.this.mLbs);
                PersonalChatActivity personalChatActivity = PersonalChatActivity.this;
                personalChatActivity.timeGrade = personalChatActivity.getTimeGrade(StringHelper.getTimeInterval(personalChatActivity.mLbs.c()));
                if (PersonalChatActivity.this.timeGrade != 0) {
                    PersonalChatActivity.this.mHandler.postDelayed(PersonalChatActivity.this.mRefreshTitleRunnable, PersonalChatActivity.this.timeGrade);
                }
                d.a.j0.f1.a.b.b.e b2 = PersonalChatActivityStatic.b();
                b2.a(PersonalChatActivity.this.curruntId + "&" + user.getUserId(), new d.a.j0.f1.a.b.b.a(PersonalChatActivity.this.mLbs, System.currentTimeMillis()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage == null || !(customResponsedMessage instanceof PushMessage) || (p = ((PushMessage) customResponsedMessage).getP()) == null) {
                return;
            }
            String cmd = p.getCmd();
            if (TextUtils.isEmpty(cmd)) {
                return;
            }
            String content = p.getContent();
            if (TextUtils.isEmpty(content)) {
                return;
            }
            try {
                JSONObject optJSONObject = new JSONObject(content).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject != null && optJSONObject.optLong("user_id") == d.a.c.e.m.b.f(PersonalChatActivity.this.mCurrentModel.getUser().getUserId(), 0L)) {
                    String optString = optJSONObject.optString("message");
                    if (cmd.equals("apply_new_friend")) {
                        PersonalChatActivity.this.mCurrentView.n(PersonalMsglistModel.CardStatus.AGREE, true, optString);
                        PersonalChatActivity.this.mCurrentModel.J(PersonalMsglistModel.CardStatus.AGREE);
                    } else if (cmd.equals("passed_new_friend")) {
                        PersonalChatActivity.this.mCurrentView.n(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                        PersonalChatActivity.this.mCurrentModel.J(PersonalMsglistModel.CardStatus.PASS);
                        PersonalChatActivity.this.mCurrentModel.setIsFriend(1);
                        PersonalChatActivity.this.mCurrentModel.setFollowStatus(1);
                        PersonalChatActivity.this.mCurrentView.getBtnGroupInfo().setVisibility(0);
                    } else if (cmd.equals("apply_add_friend")) {
                        PersonalChatActivity.this.mCurrentView.n(PersonalMsglistModel.CardStatus.WAIT, true, new String[0]);
                        PersonalChatActivity.this.mCurrentModel.J(PersonalMsglistModel.CardStatus.WAIT);
                    } else if (cmd.equals("apply_pass_friend")) {
                        PersonalChatActivity.this.mCurrentView.n(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                        PersonalChatActivity.this.mCurrentModel.J(PersonalMsglistModel.CardStatus.PASS);
                        PersonalChatActivity.this.mCurrentModel.setIsFriend(1);
                        PersonalChatActivity.this.mCurrentModel.setFollowStatus(1);
                        PersonalChatActivity.this.mCurrentView.getBtnGroupInfo().setVisibility(0);
                    }
                }
            } catch (JSONException e2) {
                BdLog.i(e2.getMessage());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.c {
        public h() {
        }

        @Override // d.a.c.e.i.a.c
        public void onLocationGeted(int i2, String str, Address address) {
            if (i2 != 0 || address == null) {
                return;
            }
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            UserData user = ((PersonalMsglistModel) PersonalChatActivity.this.mListModel).getUser();
            if (user == null) {
                return;
            }
            PersonalChatActivity.this.mUser = user;
            PersonalChatActivity.this.sendMessage(new RequestPersonalLbsInfoMessage(205101, user.getUserIdLong(), valueOf, valueOf2));
        }
    }

    /* loaded from: classes4.dex */
    public class i extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserData f18204a;

        public i(UserData userData) {
            this.f18204a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.i0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.a.j0.e1.t.e.j().c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f18204a.getUserId())));
        }
    }

    /* loaded from: classes4.dex */
    public class j implements n<Boolean> {
        public j() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            if (bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                PersonalChatActivity.this.mListView.closeNotNotify();
            } else {
                PersonalChatActivity.this.mListView.showNotNotfiy();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserData f18207a;

        public k(UserData userData) {
            this.f18207a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.a.j0.e1.t.e.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.f18207a);
            return null;
        }
    }

    private boolean checkShowNotificationOpen() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this).areNotificationsEnabled();
        boolean g2 = d.a.i0.r.d0.b.j().g("key_private_chat_show_notification", false);
        if (areNotificationsEnabled || g2) {
            return false;
        }
        d.a.i0.s.h.a.f(getPageContext(), new boolean[]{true, false}, 3);
        d.a.i0.r.d0.b.j().t("key_private_chat_show_notification", true);
        return true;
    }

    private void dispatchFinishResponse() {
        MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
    }

    private void initCurId() {
        MsglistModel msglistModel = this.mListModel;
        if (msglistModel != null && (msglistModel instanceof PersonalMsglistModel)) {
            UserData user = ((PersonalMsglistModel) msglistModel).getUser();
            if (user != null) {
                ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
                return;
            } else {
                ChatStatusManager.getInst().setCurId(0, "");
                return;
            }
        }
        ChatStatusManager.getInst().setCurId(0, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAutoMessage() {
        if (getIntent() == null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
        if (!d.a.c.e.p.k.isEmpty(stringExtra)) {
            getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            this.mListModel.sendExtraMessage(stringExtra);
        }
        String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
        if (d.a.c.e.p.k.isEmpty(stringExtra2) || stringExtra2.trim().length() <= 0) {
            return;
        }
        getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
        this.mListModel.sendTextMessage(stringExtra2);
    }

    private void sendCards() {
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
        z = true;
        chatMessage = null;
        if (z) {
            return;
        }
        chatMessage.setSt_type("aio");
        this.mListModel.doSendText(chatMessage);
    }

    private void showAddFriendStatus() {
        sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (checkShowNotificationOpen()) {
            return;
        }
        super.finish();
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean first(d.a.j0.e1.f.c cVar) {
        this.mListModel.loadFirst(cVar);
        return true;
    }

    public PersonalMsglistModel getCurrentModel() {
        return this.mCurrentModel;
    }

    public long getTimeGrade(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        if (str.contains("分钟") || str.contains("刚刚")) {
            return 60000L;
        }
        return str.contains("小时") ? VideoCloudSetting.HOUR_MILLISECOND : str.contains("天") ? 86400000L : 0L;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public boolean initData(Bundle bundle) {
        try {
            registerListener(this.getLbsInfoListener);
            registerListener(2001172, this.addFriendStateChanged);
            registerListener(2001173, this.addFriendStateChanged);
            registerListener(2001219, this.addFriendStateChanged);
            registerListener(2001220, this.addFriendStateChanged);
            registerListener(2001221, this.addFriendStateChanged);
            registerListener(this.joinGroupListener);
            registerListener(this.getNewFriend);
            if (PersonalChatActivityStatic.b() == null) {
                PersonalChatActivityStatic.d(new d.a.j0.f1.a.b.b.e());
            }
            PersonalMsglistModel personalMsglistModel = new PersonalMsglistModel(this);
            this.mListModel = personalMsglistModel;
            personalMsglistModel.setLoadDataCallBack(this.mMsgCallback);
            this.mCurrentModel = (PersonalMsglistModel) this.mListModel;
            if (bundle != null) {
                initParam(bundle);
            } else {
                initParam();
            }
            return checkParam();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void initView() {
        UserData user;
        this.mListView = new PersonalChatView(this, this.mListModel.getIsAcceptNotify());
        this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        this.mCurrentView = (PersonalChatView) this.mListView;
        long longValue = d.a.j0.e1.s.a.f53799i.longValue();
        MsglistModel msglistModel = this.mListModel;
        if ((msglistModel instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) msglistModel).getUser()) != null) {
            this.mUser = user;
            this.mListView.refreshPersonalHeadFooter(user.getName_show(), this.mLbs);
            this.mListView.bindDataAndRefresh(this.mListModel.getData(), longValue);
            this.mListView.setRecordCallback(new a());
            if (!isFriend()) {
                showAddFriendStatus();
            }
            if (TextUtils.isEmpty(this.mCurrentModel.E())) {
                return;
            }
            PersonalMsglistModel personalMsglistModel = this.mCurrentModel;
            personalMsglistModel.F(personalMsglistModel.E());
        }
    }

    public boolean isFollow() {
        return ((PersonalMsglistModel) this.mListModel).getFollowStatus() == 1;
    }

    public boolean isFriend() {
        return ((PersonalMsglistModel) this.mListModel).getIsFriend() == 1;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        super.onClick(view);
        if (view == this.mListView.getBtnGroupInfo()) {
            TiebaStatic.log("personal_chat_page_morebutton");
            MsglistModel msglistModel = this.mListModel;
            if ((msglistModel instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) msglistModel).getUser()) != null) {
                if (user.getUserType() == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                } else {
                    sendMessage(new CustomMessage(2002001, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
                }
            }
        } else if (view == this.mCurrentView.l()) {
            if (this.mCurrentModel.B() != PersonalMsglistModel.CardStatus.APPLY && this.mCurrentModel.B() != PersonalMsglistModel.CardStatus.WAIT) {
                if (this.mCurrentModel.B() == PersonalMsglistModel.CardStatus.AGREE) {
                    d.a.i0.h0.a.a(d.a.c.e.m.b.f(this.mCurrentModel.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                    TiebaStatic.eventStat(getActivity(), "add_fri_aio", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.mCurrentModel.getUser().getUserId(), this.mCurrentModel.getUser().getUserName(), this.mCurrentModel.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ChatStatusManager.getInst().setCurId(0, "");
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mRefreshTitleRunnable);
        }
        d.a.c.e.i.a.l().q(this.locationCallBack);
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Bundle bundle) {
        super.onInitParam(bundle);
        initCurId();
        ((PersonalMsglistModel) this.mListModel).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
        ((PersonalMsglistModel) this.mListModel).setFollowStatus(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FOLLOW));
        ((PersonalMsglistModel) this.mListModel).K(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, d.a.c.e.h.a
    public void onItemViewClick(View view, int i2, int i3, long j2) {
        ChatMessage msg;
        String f2;
        ChatMessage msg2;
        a.C1254a a2;
        super.onItemViewClick(view, i2, i3, j2);
        if (i2 == 2) {
            ChatMessage msg3 = this.mListModel.getMsg(i3);
            if (msg3 == null || msg3.getUserInfo() == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), msg3.getUserInfo().getUserId(), msg3.getUserInfo().getUserName())));
        } else if (i2 != 4) {
            if (i2 != 14 || (msg2 = this.mListModel.getMsg(i3)) == null || msg2.getContent() == null || (a2 = d.a.j0.f1.a.e.a.a(msg2.getContent())) == null) {
                return;
            }
            if (a2.f54100h == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(a2.f54097e, a2.f54098f, null, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(a2.f54097e, a2.f54098f, null)));
            }
        } else if (isExStorageOk() && (msg = this.mListModel.getMsg(i3)) != null && d.a.j0.e1.w.c.s(msg) && (f2 = d.a.j0.e1.w.c.f(msg.getContent(), true)) != null) {
            MsglistModel msglistModel = this.mListModel;
            if (!(msglistModel instanceof CommonPersonalMsglistModel) || ((CommonPersonalMsglistModel) msglistModel).getUser() == null) {
                return;
            }
            sendMessage(new CustomMessage(2002001, new PersonalMsgImageActivityConfig(getPageContext().getContext(), f2, ((CommonPersonalMsglistModel) this.mListModel).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void onPageInited() {
        super.onPageInited();
        this.handler.postDelayed(new b(), 60L);
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ChatStatusManager.getInst().setIsOpen(0, false);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.sendFinishMessage) {
            this.sendFinishMessage = true;
            dispatchFinishResponse();
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        String curId = ChatStatusManager.getInst().getCurId(0);
        d.a.i0.s.d.b.g0().s(curId);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
        MsglistModel msglistModel = this.mListModel;
        if (msglistModel == null || !(msglistModel instanceof PersonalMsglistModel)) {
            return;
        }
        ((PersonalMsglistModel) msglistModel).I();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.mListModel).getIsFriend());
        bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.mListModel).E());
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        UserData user;
        super.refreshHeadIcon();
        MsglistModel msglistModel = this.mListModel;
        if ((msglistModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) != null) {
            h0.c(new i(user), new j());
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void saveToUserData(UserData userData) {
        h0.c(new k(userData), null);
    }

    public void sendLbsMessage() {
        if (TbadkCoreApplication.getInst().getLocationShared()) {
            String str = this.curruntId + "&" + this.mUser.getUserId();
            if (!PersonalChatActivityStatic.b().b(str)) {
                d.a.c.e.i.a.l().i(true, this.locationCallBack);
                return;
            }
            d.a.i0.s.f.b c2 = PersonalChatActivityStatic.b().c(str);
            this.mListView.refreshPersonalHeadFooter(this.mUser.getName_show(), c2);
            long timeGrade = getTimeGrade(StringHelper.getTimeInterval(c2.c()));
            this.timeGrade = timeGrade;
            if (timeGrade != 0) {
                this.mHandler.postDelayed(this.mRefreshTitleRunnable, timeGrade);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void sendTextMsg() {
        sendCards();
        super.sendTextMsg();
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Intent intent) {
        super.onInitParam(intent);
        initCurId();
        ((PersonalMsglistModel) this.mListModel).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
        ((PersonalMsglistModel) this.mListModel).setFollowStatus(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FOLLOW, 1));
        ((PersonalMsglistModel) this.mListModel).K(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
    }
}
