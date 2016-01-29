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
import com.baidu.tbadk.core.util.aw;
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
    private com.baidu.tbadk.coreExtra.relationship.b chw;
    private UserData mUser;
    private Handler mHandler = new Handler();
    private String aCR = "";
    private long chv = 0;
    private String chx = TbadkCoreApplication.getCurrentAccount();
    private boolean ckt = false;
    private Runnable chA = new m(this);
    private com.baidu.adp.framework.listener.e chC = new q(this, 205101, true);
    private CustomMessageListener chD = new r(this, 0);
    private a.InterfaceC0004a locationCallBack = new s(this);
    private FloatingPersonalChatView cku = null;
    private View.OnClickListener ckv = new t(this);
    private final CustomMessageListener bRp = new u(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void Yp() {
        UserData user;
        super.Yp();
        if ((this.bPK instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.bPK).getUser()) != null) {
            com.baidu.tbadk.util.n.b(new v(this, user), new w(this));
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
            window.setBackgroundDrawableResource(t.d.floating_chat_bg);
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.yN().eh(this.aCR);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.aCR, 2)));
        if (this.bPK != null && (this.bPK instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.bPK).ahu();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tbadk.util.n.b(new x(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        PersonalMsglistModel personalMsglistModel;
        UserData user;
        setActivityBgTransparent();
        if (this.bPK != null && FloatingPersonalChatActivityStatic.SU() != null && FloatingPersonalChatActivityStatic.SU().size() > 0 && !this.ckt) {
            this.ckt = true;
            this.cku = new FloatingPersonalChatView(this, this.bPK.getIsAcceptNotify(), FloatingPersonalChatActivityStatic.SU());
            this.bPJ = this.cku;
            this.cku.setOnClickListener(this.ckv);
            this.bPJ.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            int i = com.baidu.tieba.im.c.a.ceW;
            if ((this.bPK instanceof PersonalMsglistModel) && (user = (personalMsglistModel = (PersonalMsglistModel) this.bPK).getUser()) != null) {
                this.mUser = user;
                this.cku.a(this.mUser.getUserName(), this.chw);
                this.bPJ.bindDataAndRefresh(personalMsglistModel.getData(), i);
                this.bPJ.setRecordCallback(new n(this));
                personalMsglistModel.setIsFriend(user.getIsFriend());
            }
        }
    }

    public void afv() {
        if (TbadkCoreApplication.m411getInst().getLocationShared() && this.mUser != null) {
            String str = String.valueOf(this.chx) + "&" + this.mUser.getUserId();
            if (!FloatingPersonalChatActivityStatic.agK().jg(str)) {
                com.baidu.adp.lib.e.a.gL().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b jh = FloatingPersonalChatActivityStatic.agK().jh(str);
            if (jh != null) {
                this.cku.a(this.mUser.getUserName(), jh);
                this.chv = jf(aw.s(jh.getTime()));
                if (this.chv != 0) {
                    this.mHandler.postDelayed(this.chA, this.chv);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean j(Bundle bundle) {
        try {
            registerListener(this.chC);
            if (FloatingPersonalChatActivityStatic.agK() == null) {
                FloatingPersonalChatActivityStatic.c(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.bPK = new PersonalMsglistModel(this);
            this.bPK.setLoadDataCallBack(this.bPV);
            if (bundle != null) {
                h(bundle);
            } else {
                Yq();
            }
            return Yr();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        if (this.bPK != null) {
            this.bPK.loadFirst(alVar);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a jA;
        ChatMessage msg;
        String y;
        super.a(view, i, i2, j);
        if (this.bPK != null) {
            switch (i) {
                case 2:
                    ChatMessage msg2 = this.bPK.getMsg(i2);
                    if (msg2 != null && msg2.getUserInfo() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                        return;
                    }
                    return;
                case 4:
                    if (Jp() && (msg = this.bPK.getMsg(i2)) != null && com.baidu.tieba.im.util.h.p(msg) && (y = com.baidu.tieba.im.util.h.y(msg.getContent(), true)) != null && (this.bPK instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.bPK).getUser() != null) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), y, ((CommonPersonalMsglistModel) this.bPK).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                        return;
                    }
                    return;
                case 14:
                    ChatMessage msg3 = this.bPK.getMsg(i2);
                    if (msg3 != null && msg3.getContent() != null && (jA = com.baidu.tieba.imMessageCenter.im.stranger.c.jA(msg3.getContent())) != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(jA.threadId, jA.postId, null)));
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
    public void i(Bundle bundle) {
        super.i(bundle);
        Yv();
        if (this.bPK instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.bPK).setIsFriend(bundle.getInt("key_is_friend"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void P(Intent intent) {
        super.P(intent);
        Yv();
        if (this.bPK instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.bPK).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        }
    }

    private void Yv() {
        if (this.bPK == null || !(this.bPK instanceof PersonalMsglistModel)) {
            this.aCR = "";
            return;
        }
        UserData user = ((PersonalMsglistModel) this.bPK).getUser();
        if (user != null) {
            this.aCR = String.valueOf(user.getUserId());
        } else {
            this.aCR = "";
        }
        ChatStatusManager.getInst().setCurId(0, this.aCR);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void Yt() {
        super.Yt();
        this.handler.postDelayed(new o(this), 60L);
        afv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yu() {
        if (getIntent() != null && this.bPK != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.bPK.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.bPK.sendTextMessage(stringExtra2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aCR = "";
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.chA);
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.afW().agf();
        com.baidu.adp.lib.e.a.gL().a(this.locationCallBack);
    }

    public List<UserData> getUserDataList() {
        return FloatingPersonalChatActivityStatic.SU();
    }

    public void jJ(int i) {
        List<UserData> SU;
        if ((this.bPK instanceof PersonalMsglistModel) && (SU = FloatingPersonalChatActivityStatic.SU()) != null && SU.size() > 0 && i < SU.size()) {
            PersonalMsglistModel personalMsglistModel = (PersonalMsglistModel) this.bPK;
            personalMsglistModel.setUser(SU.get(i));
            if (personalMsglistModel.getUser() != null) {
                this.aCR = personalMsglistModel.getUser().getUserId();
            }
            ChatStatusManager.getInst().setCurId(0, this.aCR);
            if (personalMsglistModel.getData() != null && personalMsglistModel.getData().getChatMessages() != null) {
                personalMsglistModel.getData().getChatMessages().clear();
            }
            personalMsglistModel.setIsFriend(this.cku.jt(this.aCR) ? 1 : 0);
            personalMsglistModel.loadFirst(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (FloatingPersonalChatActivityStatic.SU() == null || FloatingPersonalChatActivityStatic.SU().isEmpty()) {
            finish();
            return;
        }
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.bRp);
        registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.chD);
        registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.chD);
        registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.chD);
        registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.chD);
        registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.chD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long jf(String str) {
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
            this.cku.agP();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
