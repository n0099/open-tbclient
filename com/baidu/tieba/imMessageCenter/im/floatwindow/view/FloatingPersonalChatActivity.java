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
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatActivity extends CommonPersonalChatActivity<FloatingPersonalChatActivity> {
    private com.baidu.tbadk.coreExtra.relationship.b dmT;
    private UserData mUser;
    private Handler mHandler = new Handler();
    private String aEL = "";
    private long dmS = 0;
    private String dmU = TbadkCoreApplication.getCurrentAccount();
    private boolean dpR = false;
    private Runnable dmX = new m(this);
    private com.baidu.adp.framework.listener.e dmZ = new q(this, 205101, true);
    private CustomMessageListener dna = new r(this, 0);
    private a.InterfaceC0005a locationCallBack = new s(this);
    private FloatingPersonalChatView dpS = null;
    private View.OnClickListener dpT = new t(this);
    private final CustomMessageListener cWe = new u(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void apu() {
        UserData user;
        super.apu();
        if ((this.cUl instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.cUl).getUser()) != null) {
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
            window.setBackgroundDrawableResource(t.d.common_color_10065);
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.yA().er(this.aEL);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.aEL, 2)));
        if (this.cUl != null && (this.cUl instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.cUl).ayJ();
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
        if (this.cUl != null && FloatingPersonalChatActivityStatic.getList() != null && FloatingPersonalChatActivityStatic.getList().size() > 0 && !this.dpR) {
            this.dpR = true;
            this.dpS = new FloatingPersonalChatView(this, this.cUl.getIsAcceptNotify(), FloatingPersonalChatActivityStatic.getList());
            this.cUk = this.dpS;
            this.dpS.setOnClickListener(this.dpT);
            this.cUk.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            int i = com.baidu.tieba.im.c.a.dks;
            if ((this.cUl instanceof PersonalMsglistModel) && (user = (personalMsglistModel = (PersonalMsglistModel) this.cUl).getUser()) != null) {
                this.mUser = user;
                this.dpS.a(this.mUser.getUserName(), this.dmT);
                this.cUk.bindDataAndRefresh(personalMsglistModel.getData(), i);
                this.cUk.setRecordCallback(new n(this));
                personalMsglistModel.setIsFriend(user.getIsFriend());
            }
        }
    }

    public void awM() {
        if (TbadkCoreApplication.m9getInst().getLocationShared() && this.mUser != null) {
            String str = String.valueOf(this.dmU) + "&" + this.mUser.getUserId();
            if (!FloatingPersonalChatActivityStatic.aya().mb(str)) {
                com.baidu.adp.lib.e.a.dU().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b mc = FloatingPersonalChatActivityStatic.aya().mc(str);
            if (mc != null) {
                this.dpS.a(this.mUser.getUserName(), mc);
                this.dmS = ma(ba.r(mc.getTime()));
                if (this.dmS != 0) {
                    this.mHandler.postDelayed(this.dmX, this.dmS);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean k(Bundle bundle) {
        try {
            registerListener(this.dmZ);
            if (FloatingPersonalChatActivityStatic.aya() == null) {
                FloatingPersonalChatActivityStatic.c(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.cUl = new PersonalMsglistModel(this);
            this.cUl.setLoadDataCallBack(this.cUw);
            if (bundle != null) {
                i(bundle);
            } else {
                apv();
            }
            return apw();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        if (this.cUl != null) {
            this.cUl.loadFirst(alVar);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a mx;
        ChatMessage msg;
        String G;
        super.a(view, i, i2, j);
        if (this.cUl != null) {
            switch (i) {
                case 2:
                    ChatMessage msg2 = this.cUl.getMsg(i2);
                    if (msg2 != null && msg2.getUserInfo() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                        return;
                    }
                    return;
                case 4:
                    if (aqj() && (msg = this.cUl.getMsg(i2)) != null && com.baidu.tieba.im.util.h.q(msg) && (G = com.baidu.tieba.im.util.h.G(msg.getContent(), true)) != null && (this.cUl instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.cUl).getUser() != null) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), G, ((CommonPersonalMsglistModel) this.cUl).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                        return;
                    }
                    return;
                case 14:
                    ChatMessage msg3 = this.cUl.getMsg(i2);
                    if (msg3 != null && msg3.getContent() != null && (mx = com.baidu.tieba.imMessageCenter.im.stranger.c.mx(msg3.getContent())) != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(mx.threadId, mx.postId, null)));
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
        apB();
        if (this.cUl instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.cUl).setIsFriend(bundle.getInt("key_is_friend"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void q(Intent intent) {
        super.q(intent);
        apB();
        if (this.cUl instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.cUl).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        }
    }

    private void apB() {
        if (this.cUl == null || !(this.cUl instanceof PersonalMsglistModel)) {
            this.aEL = "";
            return;
        }
        UserData user = ((PersonalMsglistModel) this.cUl).getUser();
        if (user != null) {
            this.aEL = String.valueOf(user.getUserId());
        } else {
            this.aEL = "";
        }
        ChatStatusManager.getInst().setCurId(0, this.aEL);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void apz() {
        super.apz();
        this.handler.postDelayed(new o(this), 60L);
        awM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apA() {
        if (getIntent() != null && this.cUl != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.cUl.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.cUl.sendTextMessage(stringExtra2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aEL = "";
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dmX);
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.axm().axv();
        com.baidu.adp.lib.e.a.dU().a(this.locationCallBack);
    }

    public List<UserData> getUserDataList() {
        return FloatingPersonalChatActivityStatic.getList();
    }

    public void me(int i) {
        List<UserData> list;
        if ((this.cUl instanceof PersonalMsglistModel) && (list = FloatingPersonalChatActivityStatic.getList()) != null && list.size() > 0 && i < list.size()) {
            PersonalMsglistModel personalMsglistModel = (PersonalMsglistModel) this.cUl;
            personalMsglistModel.setUser(list.get(i));
            if (personalMsglistModel.getUser() != null) {
                this.aEL = personalMsglistModel.getUser().getUserId();
            }
            ChatStatusManager.getInst().setCurId(0, this.aEL);
            if (personalMsglistModel.getData() != null && personalMsglistModel.getData().getChatMessages() != null) {
                personalMsglistModel.getData().getChatMessages().clear();
            }
            personalMsglistModel.setIsFriend(this.dpS.mo(this.aEL) ? 1 : 0);
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cWe);
        registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.dna);
        registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.dna);
        registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.dna);
        registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.dna);
        registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.dna);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ma(String str) {
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
            this.dpS.ayf();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
