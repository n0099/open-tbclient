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
import com.baidu.adp.lib.e.a;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.al;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.stranger.c;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatActivity extends CommonPersonalChatActivity<FloatingPersonalChatActivity> {
    private com.baidu.tbadk.coreExtra.relationship.b dtZ;
    private UserData mUser;
    private Handler mHandler = new Handler();
    private String aEZ = "";
    private long dtY = 0;
    private String dua = TbadkCoreApplication.getCurrentAccount();
    private boolean dwV = false;
    private Runnable dud = new m(this);
    private com.baidu.adp.framework.listener.e duf = new q(this, 205101, true);
    private CustomMessageListener dug = new r(this, 0);
    private a.InterfaceC0005a locationCallBack = new s(this);
    private FloatingPersonalChatView dwW = null;
    private View.OnClickListener dwX = new t(this);
    private final CustomMessageListener ddn = new u(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void arQ() {
        UserData user;
        super.arQ();
        if ((this.dbq instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.dbq).getUser()) != null) {
            com.baidu.tbadk.util.t.b(new v(this, user), new w(this));
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
            window.setBackgroundDrawableResource(r.d.common_color_10065);
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.yK().ew(this.aEZ);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.aEZ, 2)));
        if (this.dbq != null && (this.dbq instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.dbq).aBe();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tbadk.util.t.b(new x(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        PersonalMsglistModel personalMsglistModel;
        UserData user;
        setActivityBgTransparent();
        if (this.dbq != null && FloatingPersonalChatActivityStatic.getList() != null && FloatingPersonalChatActivityStatic.getList().size() > 0 && !this.dwV) {
            this.dwV = true;
            this.dwW = new FloatingPersonalChatView(this, this.dbq.getIsAcceptNotify(), FloatingPersonalChatActivityStatic.getList());
            this.dbp = this.dwW;
            this.dwW.setOnClickListener(this.dwX);
            this.dbp.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            int i = com.baidu.tieba.im.c.a.drz;
            if ((this.dbq instanceof PersonalMsglistModel) && (user = (personalMsglistModel = (PersonalMsglistModel) this.dbq).getUser()) != null) {
                this.mUser = user;
                this.dwW.a(this.mUser.getUserName(), this.dtZ);
                this.dbp.bindDataAndRefresh(personalMsglistModel.getData(), i);
                this.dbp.setRecordCallback(new n(this));
                personalMsglistModel.setIsFriend(user.getIsFriend());
            }
        }
    }

    public void azi() {
        if (TbadkCoreApplication.m9getInst().getLocationShared() && this.mUser != null) {
            String str = String.valueOf(this.dua) + "&" + this.mUser.getUserId();
            if (!FloatingPersonalChatActivityStatic.aAv().mB(str)) {
                com.baidu.adp.lib.e.a.dU().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b mC = FloatingPersonalChatActivityStatic.aAv().mC(str);
            if (mC != null) {
                this.dwW.a(this.mUser.getUserName(), mC);
                this.dtY = mA(ax.q(mC.getTime()));
                if (this.dtY != 0) {
                    this.mHandler.postDelayed(this.dud, this.dtY);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean k(Bundle bundle) {
        try {
            registerListener(this.duf);
            if (FloatingPersonalChatActivityStatic.aAv() == null) {
                FloatingPersonalChatActivityStatic.c(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.dbq = new PersonalMsglistModel(this);
            this.dbq.setLoadDataCallBack(this.dbB);
            if (bundle != null) {
                i(bundle);
            } else {
                arR();
            }
            return arS();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        if (this.dbq != null) {
            this.dbq.loadFirst(alVar);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a mX;
        ChatMessage msg;
        String H;
        super.a(view, i, i2, j);
        if (this.dbq != null) {
            switch (i) {
                case 2:
                    ChatMessage msg2 = this.dbq.getMsg(i2);
                    if (msg2 != null && msg2.getUserInfo() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                        return;
                    }
                    return;
                case 4:
                    if (asF() && (msg = this.dbq.getMsg(i2)) != null && com.baidu.tieba.im.util.h.q(msg) && (H = com.baidu.tieba.im.util.h.H(msg.getContent(), true)) != null && (this.dbq instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.dbq).getUser() != null) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), H, ((CommonPersonalMsglistModel) this.dbq).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                        return;
                    }
                    return;
                case 14:
                    ChatMessage msg3 = this.dbq.getMsg(i2);
                    if (msg3 != null && msg3.getContent() != null && (mX = com.baidu.tieba.imMessageCenter.im.stranger.c.mX(msg3.getContent())) != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(mX.threadId, mX.postId, null)));
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
    public void j(Bundle bundle) {
        super.j(bundle);
        arX();
        if (this.dbq instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.dbq).setIsFriend(bundle.getInt("key_is_friend"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void p(Intent intent) {
        super.p(intent);
        arX();
        if (this.dbq instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.dbq).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        }
    }

    private void arX() {
        if (this.dbq == null || !(this.dbq instanceof PersonalMsglistModel)) {
            this.aEZ = "";
            return;
        }
        UserData user = ((PersonalMsglistModel) this.dbq).getUser();
        if (user != null) {
            this.aEZ = String.valueOf(user.getUserId());
        } else {
            this.aEZ = "";
        }
        ChatStatusManager.getInst().setCurId(0, this.aEZ);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void arV() {
        super.arV();
        this.handler.postDelayed(new o(this), 60L);
        azi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arW() {
        if (getIntent() != null && this.dbq != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.dbq.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.dbq.sendTextMessage(stringExtra2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aEZ = "";
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dud);
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.azI().azR();
        com.baidu.adp.lib.e.a.dU().a(this.locationCallBack);
    }

    public List<UserData> getUserDataList() {
        return FloatingPersonalChatActivityStatic.getList();
    }

    public void mu(int i) {
        List<UserData> list;
        if ((this.dbq instanceof PersonalMsglistModel) && (list = FloatingPersonalChatActivityStatic.getList()) != null && list.size() > 0 && i < list.size()) {
            PersonalMsglistModel personalMsglistModel = (PersonalMsglistModel) this.dbq;
            personalMsglistModel.setUser(list.get(i));
            if (personalMsglistModel.getUser() != null) {
                this.aEZ = personalMsglistModel.getUser().getUserId();
            }
            ChatStatusManager.getInst().setCurId(0, this.aEZ);
            if (personalMsglistModel.getData() != null && personalMsglistModel.getData().getChatMessages() != null) {
                personalMsglistModel.getData().getChatMessages().clear();
            }
            personalMsglistModel.setIsFriend(this.dwW.mO(this.aEZ) ? 1 : 0);
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.ddn);
        registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.dug);
        registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.dug);
        registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.dug);
        registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.dug);
        registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.dug);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long mA(String str) {
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
            this.dwW.aAA();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
