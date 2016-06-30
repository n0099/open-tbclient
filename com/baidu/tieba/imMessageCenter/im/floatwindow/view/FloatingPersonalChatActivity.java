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
    private com.baidu.tbadk.coreExtra.relationship.b cYo;
    private UserData mUser;
    private Handler mHandler = new Handler();
    private String aAO = "";
    private long cYn = 0;
    private String cYp = TbadkCoreApplication.getCurrentAccount();
    private boolean dbm = false;
    private Runnable cYs = new m(this);
    private com.baidu.adp.framework.listener.e cYu = new q(this, 205101, true);
    private CustomMessageListener cYv = new r(this, 0);
    private a.InterfaceC0005a locationCallBack = new s(this);
    private FloatingPersonalChatView dbn = null;
    private View.OnClickListener dbo = new t(this);
    private final CustomMessageListener cHK = new u(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void ajV() {
        UserData user;
        super.ajV();
        if ((this.cFR instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.cFR).getUser()) != null) {
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
            window.setBackgroundDrawableResource(u.d.common_color_10065);
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.xn().ep(this.aAO);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.aAO, 2)));
        if (this.cFR != null && (this.cFR instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.cFR).atj();
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
        if (this.cFR != null && FloatingPersonalChatActivityStatic.getList() != null && FloatingPersonalChatActivityStatic.getList().size() > 0 && !this.dbm) {
            this.dbm = true;
            this.dbn = new FloatingPersonalChatView(this, this.cFR.getIsAcceptNotify(), FloatingPersonalChatActivityStatic.getList());
            this.cFQ = this.dbn;
            this.dbn.setOnClickListener(this.dbo);
            this.cFQ.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            int i = com.baidu.tieba.im.c.a.cVO;
            if ((this.cFR instanceof PersonalMsglistModel) && (user = (personalMsglistModel = (PersonalMsglistModel) this.cFR).getUser()) != null) {
                this.mUser = user;
                this.dbn.a(this.mUser.getUserName(), this.cYo);
                this.cFQ.bindDataAndRefresh(personalMsglistModel.getData(), i);
                this.cFQ.setRecordCallback(new n(this));
                personalMsglistModel.setIsFriend(user.getIsFriend());
            }
        }
    }

    public void arm() {
        if (TbadkCoreApplication.m9getInst().getLocationShared() && this.mUser != null) {
            String str = String.valueOf(this.cYp) + "&" + this.mUser.getUserId();
            if (!FloatingPersonalChatActivityStatic.asA().ll(str)) {
                com.baidu.adp.lib.e.a.da().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b lm = FloatingPersonalChatActivityStatic.asA().lm(str);
            if (lm != null) {
                this.dbn.a(this.mUser.getUserName(), lm);
                this.cYn = lk(ba.x(lm.getTime()));
                if (this.cYn != 0) {
                    this.mHandler.postDelayed(this.cYs, this.cYn);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean n(Bundle bundle) {
        try {
            registerListener(this.cYu);
            if (FloatingPersonalChatActivityStatic.asA() == null) {
                FloatingPersonalChatActivityStatic.c(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.cFR = new PersonalMsglistModel(this);
            this.cFR.setLoadDataCallBack(this.cGc);
            if (bundle != null) {
                l(bundle);
            } else {
                ajW();
            }
            return ajX();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        if (this.cFR != null) {
            this.cFR.loadFirst(alVar);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a lH;
        ChatMessage msg;
        String C;
        super.a(view, i, i2, j);
        if (this.cFR != null) {
            switch (i) {
                case 2:
                    ChatMessage msg2 = this.cFR.getMsg(i2);
                    if (msg2 != null && msg2.getUserInfo() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                        return;
                    }
                    return;
                case 4:
                    if (akK() && (msg = this.cFR.getMsg(i2)) != null && com.baidu.tieba.im.util.h.q(msg) && (C = com.baidu.tieba.im.util.h.C(msg.getContent(), true)) != null && (this.cFR instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.cFR).getUser() != null) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), C, ((CommonPersonalMsglistModel) this.cFR).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                        return;
                    }
                    return;
                case 14:
                    ChatMessage msg3 = this.cFR.getMsg(i2);
                    if (msg3 != null && msg3.getContent() != null && (lH = com.baidu.tieba.imMessageCenter.im.stranger.c.lH(msg3.getContent())) != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(lH.threadId, lH.postId, null)));
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
    public void m(Bundle bundle) {
        super.m(bundle);
        akc();
        if (this.cFR instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.cFR).setIsFriend(bundle.getInt("key_is_friend"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void p(Intent intent) {
        super.p(intent);
        akc();
        if (this.cFR instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.cFR).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        }
    }

    private void akc() {
        if (this.cFR == null || !(this.cFR instanceof PersonalMsglistModel)) {
            this.aAO = "";
            return;
        }
        UserData user = ((PersonalMsglistModel) this.cFR).getUser();
        if (user != null) {
            this.aAO = String.valueOf(user.getUserId());
        } else {
            this.aAO = "";
        }
        ChatStatusManager.getInst().setCurId(0, this.aAO);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void aka() {
        super.aka();
        this.handler.postDelayed(new o(this), 60L);
        arm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akb() {
        if (getIntent() != null && this.cFR != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.cFR.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.cFR.sendTextMessage(stringExtra2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aAO = "";
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cYs);
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.arM().arV();
        com.baidu.adp.lib.e.a.da().a(this.locationCallBack);
    }

    public List<UserData> getUserDataList() {
        return FloatingPersonalChatActivityStatic.getList();
    }

    public void lv(int i) {
        List<UserData> list;
        if ((this.cFR instanceof PersonalMsglistModel) && (list = FloatingPersonalChatActivityStatic.getList()) != null && list.size() > 0 && i < list.size()) {
            PersonalMsglistModel personalMsglistModel = (PersonalMsglistModel) this.cFR;
            personalMsglistModel.setUser(list.get(i));
            if (personalMsglistModel.getUser() != null) {
                this.aAO = personalMsglistModel.getUser().getUserId();
            }
            ChatStatusManager.getInst().setCurId(0, this.aAO);
            if (personalMsglistModel.getData() != null && personalMsglistModel.getData().getChatMessages() != null) {
                personalMsglistModel.getData().getChatMessages().clear();
            }
            personalMsglistModel.setIsFriend(this.dbn.ly(this.aAO) ? 1 : 0);
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cHK);
        registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.cYv);
        registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.cYv);
        registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.cYv);
        registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.cYv);
        registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.cYv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long lk(String str) {
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
            this.dbn.asF();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
