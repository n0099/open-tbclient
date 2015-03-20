package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.ax;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatActivity extends CommonPersonalChatActivity<FloatingPersonalChatActivity> {
    private com.baidu.tbadk.coreExtra.relationship.b boP;
    private UserData mUser;
    private Handler mHandler = new Handler();
    private String aqu = "";
    private long boO = 0;
    private String boQ = TbadkCoreApplication.getCurrentAccount();
    private boolean brE = false;
    private Runnable boT = new o(this);
    private com.baidu.adp.framework.listener.e boV = new s(this, 205101, true);
    private CustomMessageListener boW = new t(this, 0);
    private com.baidu.adp.lib.d.d locationCallBack = new u(this);
    private FloatingPersonalChatView brF = null;
    private View.OnClickListener brG = new v(this);
    private final CustomMessageListener aZC = new w(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        UserData user;
        super.refreshHeadIcon();
        if ((this.mListModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.mListModel).getUser()) != null) {
            com.baidu.tieba.im.l.a(new x(this, user), new y(this));
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
        ChatStatusManager.getInst().setIsOpen(0, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.uT().dq(this.aqu);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(this.aqu, 2)));
        if (this.mListModel != null && (this.mListModel instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.mListModel).sendHasReadReceiveOther();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tieba.im.l.a(new z(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        PersonalMsglistModel personalMsglistModel;
        UserData user;
        setActivityBgTransparent();
        if (this.mListModel != null && FloatingPersonalChatActivityStatic.getList() != null && FloatingPersonalChatActivityStatic.getList().size() > 0 && !this.brE) {
            this.brE = true;
            this.brF = new FloatingPersonalChatView(this, this.mListModel.getIsAcceptNotify(), FloatingPersonalChatActivityStatic.getList());
            this.mListView = this.brF;
            this.brF.setOnClickListener(this.brG);
            this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            int i = com.baidu.tieba.im.c.a.bmu;
            if ((this.mListModel instanceof PersonalMsglistModel) && (user = (personalMsglistModel = (PersonalMsglistModel) this.mListModel).getUser()) != null) {
                this.mUser = user;
                this.brF.a(this.mUser.getUserName(), this.boP);
                this.mListView.bindDataAndRefresh(personalMsglistModel.getData(), i);
                this.mListView.setRecordCallback(new p(this));
                personalMsglistModel.setIsFriend(user.getIsFriend());
            }
        }
    }

    public void TO() {
        if (TbadkCoreApplication.m411getInst().getLocationShared() && this.mUser != null) {
            String str = String.valueOf(this.boQ) + "&" + this.mUser.getUserId();
            if (!FloatingPersonalChatActivityStatic.UZ().gY(str)) {
                com.baidu.adp.lib.d.a.gZ().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b gZ = FloatingPersonalChatActivityStatic.UZ().gZ(str);
            if (gZ != null) {
                this.brF.a(this.mUser.getUserName(), gZ);
                this.boO = gX(bd.m(gZ.getTime()));
                if (this.boO != 0) {
                    this.mHandler.postDelayed(this.boT, this.boO);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean initData(Bundle bundle) {
        try {
            registerListener(this.boV);
            if (FloatingPersonalChatActivityStatic.UZ() == null) {
                FloatingPersonalChatActivityStatic.c(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f());
            }
            this.mListModel = new PersonalMsglistModel(this);
            this.mListModel.setLoadDataCallBack(this.mMsgCallback);
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
        if (this.mListModel != null) {
            this.mListModel.loadFirst(axVar);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        com.baidu.tieba.imMessageCenter.im.stranger.d ho;
        ChatMessage msg;
        String t;
        super.onItemViewClick(view, i, i2, j);
        if (this.mListModel != null) {
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
                    if (msg3 != null && msg3.getContent() != null && (ho = com.baidu.tieba.imMessageCenter.im.stranger.c.ho(msg3.getContent())) != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(ho.threadId, ho.postId, null)));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Bundle bundle) {
        super.onInitParam(bundle);
        initCurId();
        if (this.mListModel instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.mListModel).setIsFriend(bundle.getInt("key_is_friend"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Intent intent) {
        super.onInitParam(intent);
        initCurId();
        if (this.mListModel instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.mListModel).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        }
    }

    private void initCurId() {
        if (this.mListModel == null || !(this.mListModel instanceof PersonalMsglistModel)) {
            this.aqu = "";
            return;
        }
        UserData user = ((PersonalMsglistModel) this.mListModel).getUser();
        if (user != null) {
            this.aqu = String.valueOf(user.getUserId());
        } else {
            this.aqu = "";
        }
        ChatStatusManager.getInst().setCurId(0, this.aqu);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void onPageInited() {
        super.onPageInited();
        this.handler.postDelayed(new q(this), 60L);
        TO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nu() {
        if (getIntent() != null && this.mListModel != null) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aqu = "";
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.boT);
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Ul().Uu();
        com.baidu.adp.lib.d.a.gZ().a(this.locationCallBack);
    }

    public List<UserData> getUserDataList() {
        return FloatingPersonalChatActivityStatic.getList();
    }

    public void gy(int i) {
        if ((this.mListModel instanceof PersonalMsglistModel) && FloatingPersonalChatActivityStatic.getList() != null && FloatingPersonalChatActivityStatic.getList().size() > 0) {
            PersonalMsglistModel personalMsglistModel = (PersonalMsglistModel) this.mListModel;
            personalMsglistModel.setUser(FloatingPersonalChatActivityStatic.getList().get(i));
            if (personalMsglistModel.getUser() != null) {
                this.aqu = personalMsglistModel.getUser().getUserId();
            }
            ChatStatusManager.getInst().setCurId(0, this.aqu);
            if (personalMsglistModel.getData() != null && personalMsglistModel.getData().getChatMessages() != null) {
                personalMsglistModel.getData().getChatMessages().clear();
            }
            personalMsglistModel.setIsFriend(this.brF.hj(this.aqu) ? 1 : 0);
            personalMsglistModel.loadFirst(new r(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (FloatingPersonalChatActivityStatic.getList() == null || FloatingPersonalChatActivityStatic.getList().isEmpty()) {
            finish();
            return;
        }
        registerListener(2016003, this.aZC);
        registerListener(2001176, this.boW);
        registerListener(2001177, this.boW);
        registerListener(2001225, this.boW);
        registerListener(2001226, this.boW);
        registerListener(2001227, this.boW);
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.brF.Ve();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
