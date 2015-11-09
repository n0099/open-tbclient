package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.i;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.al;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.stranger.c;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatActivity extends CommonPersonalChatActivity<FloatingPersonalChatActivity> {
    private com.baidu.tbadk.coreExtra.relationship.b bJS;
    private UserData mUser;
    private Handler mHandler = new Handler();
    private String ayp = "";
    private long bJR = 0;
    private String bJT = TbadkCoreApplication.getCurrentAccount();
    private boolean bMP = false;
    private Runnable bJW = new m(this);
    private com.baidu.adp.framework.listener.e bJY = new q(this, 205101, true);
    private CustomMessageListener bJZ = new r(this, 0);
    private a.InterfaceC0003a locationCallBack = new s(this);
    private FloatingPersonalChatView bMQ = null;
    private View.OnClickListener bMR = new t(this);
    private final CustomMessageListener buE = new u(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        UserData user;
        super.refreshHeadIcon();
        if ((this.mListModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.mListModel).getUser()) != null) {
            com.baidu.tbadk.util.m.b(new v(this, user), new w(this));
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
        setActivityBgTransparent();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(i.c.floating_chat_bg);
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.wM().dX(this.ayp);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.ayp, 2)));
        if (this.mListModel != null && (this.mListModel instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.mListModel).ZV();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tbadk.util.m.b(new x(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        PersonalMsglistModel personalMsglistModel;
        UserData user;
        setActivityBgTransparent();
        if (this.mListModel != null && FloatingPersonalChatActivityStatic.getList() != null && FloatingPersonalChatActivityStatic.getList().size() > 0 && !this.bMP) {
            this.bMP = true;
            this.bMQ = new FloatingPersonalChatView(this, this.mListModel.getIsAcceptNotify(), FloatingPersonalChatActivityStatic.getList());
            this.mListView = this.bMQ;
            this.bMQ.setOnClickListener(this.bMR);
            this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            int i = com.baidu.tieba.im.c.a.bHs;
            if ((this.mListModel instanceof PersonalMsglistModel) && (user = (personalMsglistModel = (PersonalMsglistModel) this.mListModel).getUser()) != null) {
                this.mUser = user;
                this.bMQ.a(this.mUser.getUserName(), this.bJS);
                this.mListView.bindDataAndRefresh(personalMsglistModel.getData(), i);
                this.mListView.setRecordCallback(new n(this));
                personalMsglistModel.setIsFriend(user.getIsFriend());
            }
        }
    }

    public void XY() {
        if (TbadkCoreApplication.m411getInst().getLocationShared() && this.mUser != null) {
            String str = String.valueOf(this.bJT) + "&" + this.mUser.getUserId();
            if (!FloatingPersonalChatActivityStatic.Zm().iw(str)) {
                com.baidu.adp.lib.d.a.gC().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b ix = FloatingPersonalChatActivityStatic.Zm().ix(str);
            if (ix != null) {
                this.bMQ.a(this.mUser.getUserName(), ix);
                this.bJR = iv(as.l(ix.getTime()));
                if (this.bJR != 0) {
                    this.mHandler.postDelayed(this.bJW, this.bJR);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean initData(Bundle bundle) {
        try {
            registerListener(this.bJY);
            if (FloatingPersonalChatActivityStatic.Zm() == null) {
                FloatingPersonalChatActivityStatic.c(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
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
    protected boolean first(al alVar) {
        if (this.mListModel != null) {
            this.mListModel.loadFirst(alVar);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        c.a iO;
        ChatMessage msg;
        String x;
        super.onItemViewClick(view, i, i2, j);
        if (this.mListModel != null) {
            switch (i) {
                case 2:
                    ChatMessage msg2 = this.mListModel.getMsg(i2);
                    if (msg2 != null && msg2.getUserInfo() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                        return;
                    }
                    return;
                case 4:
                    if (isExStorageOk() && (msg = this.mListModel.getMsg(i2)) != null && com.baidu.tieba.im.util.h.p(msg) && (x = com.baidu.tieba.im.util.h.x(msg.getContent(), true)) != null && (this.mListModel instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.mListModel).getUser() != null) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), x, ((CommonPersonalMsglistModel) this.mListModel).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                        return;
                    }
                    return;
                case 14:
                    ChatMessage msg3 = this.mListModel.getMsg(i2);
                    if (msg3 != null && msg3.getContent() != null && (iO = com.baidu.tieba.imMessageCenter.im.stranger.c.iO(msg3.getContent())) != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(iO.threadId, iO.postId, null)));
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
            this.ayp = "";
            return;
        }
        UserData user = ((PersonalMsglistModel) this.mListModel).getUser();
        if (user != null) {
            this.ayp = String.valueOf(user.getUserId());
        } else {
            this.ayp = "";
        }
        ChatStatusManager.getInst().setCurId(0, this.ayp);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void onPageInited() {
        super.onPageInited();
        this.handler.postDelayed(new o(this), 60L);
        XY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RJ() {
        if (getIntent() != null && this.mListModel != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.mListModel.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.mListModel.sendTextMessage(stringExtra2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ayp = "";
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bJW);
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yy().YH();
        com.baidu.adp.lib.d.a.gC().a(this.locationCallBack);
    }

    public List<UserData> getUserDataList() {
        return FloatingPersonalChatActivityStatic.getList();
    }

    public void hY(int i) {
        List<UserData> list;
        if ((this.mListModel instanceof PersonalMsglistModel) && (list = FloatingPersonalChatActivityStatic.getList()) != null && list.size() > 0 && i < list.size()) {
            PersonalMsglistModel personalMsglistModel = (PersonalMsglistModel) this.mListModel;
            personalMsglistModel.setUser(list.get(i));
            if (personalMsglistModel.getUser() != null) {
                this.ayp = personalMsglistModel.getUser().getUserId();
            }
            ChatStatusManager.getInst().setCurId(0, this.ayp);
            if (personalMsglistModel.getData() != null && personalMsglistModel.getData().getChatMessages() != null) {
                personalMsglistModel.getData().getChatMessages().clear();
            }
            personalMsglistModel.setIsFriend(this.bMQ.iH(this.ayp) ? 1 : 0);
            personalMsglistModel.loadFirst(new p(this));
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.buE);
        registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.bJZ);
        registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.bJZ);
        registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.bJZ);
        registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.bJZ);
        registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.bJZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long iv(String str) {
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
            this.bMQ.Zr();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
