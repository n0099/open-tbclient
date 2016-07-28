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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.chat.al;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.stranger.c;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatActivity extends CommonPersonalChatActivity<FloatingPersonalChatActivity> {
    private com.baidu.tbadk.coreExtra.relationship.b dbl;
    private UserData mUser;
    private Handler mHandler = new Handler();
    private String aBE = "";
    private long dbk = 0;
    private String dbm = TbadkCoreApplication.getCurrentAccount();
    private boolean dej = false;
    private Runnable dbp = new m(this);
    private com.baidu.adp.framework.listener.e dbr = new q(this, 205101, true);
    private CustomMessageListener dbs = new r(this, 0);
    private a.InterfaceC0005a locationCallBack = new s(this);
    private FloatingPersonalChatView dek = null;
    private View.OnClickListener del = new t(this);
    private final CustomMessageListener cKz = new u(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void akF() {
        UserData user;
        super.akF();
        if ((this.cIG instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.cIG).getUser()) != null) {
            com.baidu.tbadk.util.u.b(new v(this, user), new w(this));
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
            window.setBackgroundDrawableResource(u.d.common_color_10065);
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.xn().eo(this.aBE);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.aBE, 2)));
        if (this.cIG != null && (this.cIG instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.cIG).atV();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tbadk.util.u.b(new x(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        PersonalMsglistModel personalMsglistModel;
        UserData user;
        setActivityBgTransparent();
        if (this.cIG != null && FloatingPersonalChatActivityStatic.getList() != null && FloatingPersonalChatActivityStatic.getList().size() > 0 && !this.dej) {
            this.dej = true;
            this.dek = new FloatingPersonalChatView(this, this.cIG.getIsAcceptNotify(), FloatingPersonalChatActivityStatic.getList());
            this.cIF = this.dek;
            this.dek.setOnClickListener(this.del);
            this.cIF.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            int i = com.baidu.tieba.im.c.a.cYJ;
            if ((this.cIG instanceof PersonalMsglistModel) && (user = (personalMsglistModel = (PersonalMsglistModel) this.cIG).getUser()) != null) {
                this.mUser = user;
                this.dek.a(this.mUser.getUserName(), this.dbl);
                this.cIF.bindDataAndRefresh(personalMsglistModel.getData(), i);
                this.cIF.setRecordCallback(new n(this));
                personalMsglistModel.setIsFriend(user.getIsFriend());
            }
        }
    }

    public void arY() {
        if (TbadkCoreApplication.m10getInst().getLocationShared() && this.mUser != null) {
            String str = String.valueOf(this.dbm) + "&" + this.mUser.getUserId();
            if (!FloatingPersonalChatActivityStatic.atm().ls(str)) {
                com.baidu.adp.lib.e.a.cZ().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b lt = FloatingPersonalChatActivityStatic.atm().lt(str);
            if (lt != null) {
                this.dek.a(this.mUser.getUserName(), lt);
                this.dbk = lr(ba.s(lt.getTime()));
                if (this.dbk != 0) {
                    this.mHandler.postDelayed(this.dbp, this.dbk);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean k(Bundle bundle) {
        try {
            registerListener(this.dbr);
            if (FloatingPersonalChatActivityStatic.atm() == null) {
                FloatingPersonalChatActivityStatic.c(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.cIG = new PersonalMsglistModel(this);
            this.cIG.setLoadDataCallBack(this.cIR);
            if (bundle != null) {
                i(bundle);
            } else {
                akG();
            }
            return akH();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        if (this.cIG != null) {
            this.cIG.loadFirst(alVar);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a lO;
        ChatMessage msg;
        String C;
        super.a(view, i, i2, j);
        if (this.cIG != null) {
            switch (i) {
                case 2:
                    ChatMessage msg2 = this.cIG.getMsg(i2);
                    if (msg2 != null && msg2.getUserInfo() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                        return;
                    }
                    return;
                case 4:
                    if (alu() && (msg = this.cIG.getMsg(i2)) != null && com.baidu.tieba.im.util.h.q(msg) && (C = com.baidu.tieba.im.util.h.C(msg.getContent(), true)) != null && (this.cIG instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.cIG).getUser() != null) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), C, ((CommonPersonalMsglistModel) this.cIG).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                        return;
                    }
                    return;
                case 14:
                    ChatMessage msg3 = this.cIG.getMsg(i2);
                    if (msg3 != null && msg3.getContent() != null && (lO = com.baidu.tieba.imMessageCenter.im.stranger.c.lO(msg3.getContent())) != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(lO.threadId, lO.postId, null)));
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
        akM();
        if (this.cIG instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.cIG).setIsFriend(bundle.getInt("key_is_friend"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void q(Intent intent) {
        super.q(intent);
        akM();
        if (this.cIG instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.cIG).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        }
    }

    private void akM() {
        if (this.cIG == null || !(this.cIG instanceof PersonalMsglistModel)) {
            this.aBE = "";
            return;
        }
        UserData user = ((PersonalMsglistModel) this.cIG).getUser();
        if (user != null) {
            this.aBE = String.valueOf(user.getUserId());
        } else {
            this.aBE = "";
        }
        ChatStatusManager.getInst().setCurId(0, this.aBE);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void akK() {
        super.akK();
        this.handler.postDelayed(new o(this), 60L);
        arY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akL() {
        if (getIntent() != null && this.cIG != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.cIG.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.cIG.sendTextMessage(stringExtra2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aBE = "";
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dbp);
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.asy().asH();
        com.baidu.adp.lib.e.a.cZ().a(this.locationCallBack);
    }

    public List<UserData> getUserDataList() {
        return FloatingPersonalChatActivityStatic.getList();
    }

    public void lB(int i) {
        List<UserData> list;
        if ((this.cIG instanceof PersonalMsglistModel) && (list = FloatingPersonalChatActivityStatic.getList()) != null && list.size() > 0 && i < list.size()) {
            PersonalMsglistModel personalMsglistModel = (PersonalMsglistModel) this.cIG;
            personalMsglistModel.setUser(list.get(i));
            if (personalMsglistModel.getUser() != null) {
                this.aBE = personalMsglistModel.getUser().getUserId();
            }
            ChatStatusManager.getInst().setCurId(0, this.aBE);
            if (personalMsglistModel.getData() != null && personalMsglistModel.getData().getChatMessages() != null) {
                personalMsglistModel.getData().getChatMessages().clear();
            }
            personalMsglistModel.setIsFriend(this.dek.lF(this.aBE) ? 1 : 0);
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cKz);
        registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.dbs);
        registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.dbs);
        registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.dbs);
        registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.dbs);
        registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.dbs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long lr(String str) {
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
            this.dek.atr();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
