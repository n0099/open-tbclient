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
import com.baidu.tbadk.core.util.ay;
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
    private com.baidu.tbadk.coreExtra.relationship.b csb;
    private UserData mUser;
    private Handler mHandler = new Handler();
    private String aDP = "";
    private long csa = 0;
    private String csc = TbadkCoreApplication.getCurrentAccount();
    private boolean cuZ = false;
    private Runnable csf = new m(this);
    private com.baidu.adp.framework.listener.e csh = new q(this, 205101, true);
    private CustomMessageListener csi = new r(this, 0);
    private a.InterfaceC0005a locationCallBack = new s(this);
    private FloatingPersonalChatView cva = null;
    private View.OnClickListener cvb = new t(this);
    private final CustomMessageListener cbJ = new u(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void abI() {
        UserData user;
        super.abI();
        if ((this.cac instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.cac).getUser()) != null) {
            com.baidu.tbadk.util.q.b(new v(this, user), new w(this));
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
        com.baidu.tbadk.coreExtra.messageCenter.a.zp().eo(this.aDP);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.aDP, 2)));
        if (this.cac != null && (this.cac instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.cac).akO();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    protected void a(UserData userData) {
        com.baidu.tbadk.util.q.b(new x(this, userData), null);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void initView() {
        PersonalMsglistModel personalMsglistModel;
        UserData user;
        setActivityBgTransparent();
        if (this.cac != null && FloatingPersonalChatActivityStatic.UL() != null && FloatingPersonalChatActivityStatic.UL().size() > 0 && !this.cuZ) {
            this.cuZ = true;
            this.cva = new FloatingPersonalChatView(this, this.cac.getIsAcceptNotify(), FloatingPersonalChatActivityStatic.UL());
            this.cab = this.cva;
            this.cva.setOnClickListener(this.cvb);
            this.cab.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            int i = com.baidu.tieba.im.c.a.cpB;
            if ((this.cac instanceof PersonalMsglistModel) && (user = (personalMsglistModel = (PersonalMsglistModel) this.cac).getUser()) != null) {
                this.mUser = user;
                this.cva.a(this.mUser.getUserName(), this.csb);
                this.cab.bindDataAndRefresh(personalMsglistModel.getData(), i);
                this.cab.setRecordCallback(new n(this));
                personalMsglistModel.setIsFriend(user.getIsFriend());
            }
        }
    }

    public void aiP() {
        if (TbadkCoreApplication.m411getInst().getLocationShared() && this.mUser != null) {
            String str = String.valueOf(this.csc) + "&" + this.mUser.getUserId();
            if (!FloatingPersonalChatActivityStatic.ake().jP(str)) {
                com.baidu.adp.lib.e.a.gL().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b jQ = FloatingPersonalChatActivityStatic.ake().jQ(str);
            if (jQ != null) {
                this.cva.a(this.mUser.getUserName(), jQ);
                this.csa = jO(ay.v(jQ.getTime()));
                if (this.csa != 0) {
                    this.mHandler.postDelayed(this.csf, this.csa);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean l(Bundle bundle) {
        try {
            registerListener(this.csh);
            if (FloatingPersonalChatActivityStatic.ake() == null) {
                FloatingPersonalChatActivityStatic.c(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.cac = new PersonalMsglistModel(this);
            this.cac.setLoadDataCallBack(this.can);
            if (bundle != null) {
                j(bundle);
            } else {
                abJ();
            }
            return abK();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        if (this.cac != null) {
            this.cac.loadFirst(alVar);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a kj;
        ChatMessage msg;
        String z;
        super.a(view, i, i2, j);
        if (this.cac != null) {
            switch (i) {
                case 2:
                    ChatMessage msg2 = this.cac.getMsg(i2);
                    if (msg2 != null && msg2.getUserInfo() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                        return;
                    }
                    return;
                case 4:
                    if (KK() && (msg = this.cac.getMsg(i2)) != null && com.baidu.tieba.im.util.h.p(msg) && (z = com.baidu.tieba.im.util.h.z(msg.getContent(), true)) != null && (this.cac instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.cac).getUser() != null) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), z, ((CommonPersonalMsglistModel) this.cac).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                        return;
                    }
                    return;
                case 14:
                    ChatMessage msg3 = this.cac.getMsg(i2);
                    if (msg3 != null && msg3.getContent() != null && (kj = com.baidu.tieba.imMessageCenter.im.stranger.c.kj(msg3.getContent())) != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(kj.threadId, kj.postId, null)));
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
    public void k(Bundle bundle) {
        super.k(bundle);
        abO();
        if (this.cac instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.cac).setIsFriend(bundle.getInt("key_is_friend"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void m(Intent intent) {
        super.m(intent);
        abO();
        if (this.cac instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.cac).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        }
    }

    private void abO() {
        if (this.cac == null || !(this.cac instanceof PersonalMsglistModel)) {
            this.aDP = "";
            return;
        }
        UserData user = ((PersonalMsglistModel) this.cac).getUser();
        if (user != null) {
            this.aDP = String.valueOf(user.getUserId());
        } else {
            this.aDP = "";
        }
        ChatStatusManager.getInst().setCurId(0, this.aDP);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void abM() {
        super.abM();
        this.handler.postDelayed(new o(this), 60L);
        aiP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abN() {
        if (getIntent() != null && this.cac != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.cac.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.cac.sendTextMessage(stringExtra2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aDP = "";
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.csf);
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq().ajz();
        com.baidu.adp.lib.e.a.gL().a(this.locationCallBack);
    }

    public List<UserData> getUserDataList() {
        return FloatingPersonalChatActivityStatic.UL();
    }

    public void kp(int i) {
        List<UserData> UL;
        if ((this.cac instanceof PersonalMsglistModel) && (UL = FloatingPersonalChatActivityStatic.UL()) != null && UL.size() > 0 && i < UL.size()) {
            PersonalMsglistModel personalMsglistModel = (PersonalMsglistModel) this.cac;
            personalMsglistModel.setUser(UL.get(i));
            if (personalMsglistModel.getUser() != null) {
                this.aDP = personalMsglistModel.getUser().getUserId();
            }
            ChatStatusManager.getInst().setCurId(0, this.aDP);
            if (personalMsglistModel.getData() != null && personalMsglistModel.getData().getChatMessages() != null) {
                personalMsglistModel.getData().getChatMessages().clear();
            }
            personalMsglistModel.setIsFriend(this.cva.kc(this.aDP) ? 1 : 0);
            personalMsglistModel.loadFirst(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (FloatingPersonalChatActivityStatic.UL() == null || FloatingPersonalChatActivityStatic.UL().isEmpty()) {
            finish();
            return;
        }
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cbJ);
        registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.csi);
        registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.csi);
        registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.csi);
        registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.csi);
        registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.csi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long jO(String str) {
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
            this.cva.akj();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
