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
    private com.baidu.tbadk.coreExtra.relationship.b csY;
    private UserData mUser;
    private Handler mHandler = new Handler();
    private String azX = "";
    private long csX = 0;
    private String csZ = TbadkCoreApplication.getCurrentAccount();
    private boolean cvW = false;
    private Runnable ctc = new m(this);
    private com.baidu.adp.framework.listener.e cte = new q(this, 205101, true);
    private CustomMessageListener ctf = new r(this, 0);
    private a.InterfaceC0005a locationCallBack = new s(this);
    private FloatingPersonalChatView cvX = null;
    private View.OnClickListener cvY = new t(this);
    private final CustomMessageListener cco = new u(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void abJ() {
        UserData user;
        super.abJ();
        if ((this.caH instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.caH).getUser()) != null) {
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
            window.setBackgroundDrawableResource(t.d.floating_chat_bg);
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.xj().el(this.azX);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.azX, 2)));
        if (this.caH != null && (this.caH instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.caH).akW();
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
        if (this.caH != null && FloatingPersonalChatActivityStatic.getList() != null && FloatingPersonalChatActivityStatic.getList().size() > 0 && !this.cvW) {
            this.cvW = true;
            this.cvX = new FloatingPersonalChatView(this, this.caH.getIsAcceptNotify(), FloatingPersonalChatActivityStatic.getList());
            this.caG = this.cvX;
            this.cvX.setOnClickListener(this.cvY);
            this.caG.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            int i = com.baidu.tieba.im.c.a.cqy;
            if ((this.caH instanceof PersonalMsglistModel) && (user = (personalMsglistModel = (PersonalMsglistModel) this.caH).getUser()) != null) {
                this.mUser = user;
                this.cvX.a(this.mUser.getUserName(), this.csY);
                this.caG.bindDataAndRefresh(personalMsglistModel.getData(), i);
                this.caG.setRecordCallback(new n(this));
                personalMsglistModel.setIsFriend(user.getIsFriend());
            }
        }
    }

    public void aiY() {
        if (TbadkCoreApplication.m11getInst().getLocationShared() && this.mUser != null) {
            String str = String.valueOf(this.csZ) + "&" + this.mUser.getUserId();
            if (!FloatingPersonalChatActivityStatic.akm().jS(str)) {
                com.baidu.adp.lib.e.a.cZ().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b jT = FloatingPersonalChatActivityStatic.akm().jT(str);
            if (jT != null) {
                this.cvX.a(this.mUser.getUserName(), jT);
                this.csX = jR(ay.w(jT.getTime()));
                if (this.csX != 0) {
                    this.mHandler.postDelayed(this.ctc, this.csX);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean m(Bundle bundle) {
        try {
            registerListener(this.cte);
            if (FloatingPersonalChatActivityStatic.akm() == null) {
                FloatingPersonalChatActivityStatic.c(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.caH = new PersonalMsglistModel(this);
            this.caH.setLoadDataCallBack(this.caS);
            if (bundle != null) {
                k(bundle);
            } else {
                abK();
            }
            return abL();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        if (this.caH != null) {
            this.caH.loadFirst(alVar);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a km;
        ChatMessage msg;
        String A;
        super.a(view, i, i2, j);
        if (this.caH != null) {
            switch (i) {
                case 2:
                    ChatMessage msg2 = this.caH.getMsg(i2);
                    if (msg2 != null && msg2.getUserInfo() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                        return;
                    }
                    return;
                case 4:
                    if (acy() && (msg = this.caH.getMsg(i2)) != null && com.baidu.tieba.im.util.h.p(msg) && (A = com.baidu.tieba.im.util.h.A(msg.getContent(), true)) != null && (this.caH instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.caH).getUser() != null) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), A, ((CommonPersonalMsglistModel) this.caH).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                        return;
                    }
                    return;
                case 14:
                    ChatMessage msg3 = this.caH.getMsg(i2);
                    if (msg3 != null && msg3.getContent() != null && (km = com.baidu.tieba.imMessageCenter.im.stranger.c.km(msg3.getContent())) != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(km.threadId, km.postId, null)));
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
    public void l(Bundle bundle) {
        super.l(bundle);
        abQ();
        if (this.caH instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.caH).setIsFriend(bundle.getInt("key_is_friend"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void n(Intent intent) {
        super.n(intent);
        abQ();
        if (this.caH instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.caH).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        }
    }

    private void abQ() {
        if (this.caH == null || !(this.caH instanceof PersonalMsglistModel)) {
            this.azX = "";
            return;
        }
        UserData user = ((PersonalMsglistModel) this.caH).getUser();
        if (user != null) {
            this.azX = String.valueOf(user.getUserId());
        } else {
            this.azX = "";
        }
        ChatStatusManager.getInst().setCurId(0, this.azX);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void abO() {
        super.abO();
        this.handler.postDelayed(new o(this), 60L);
        aiY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abP() {
        if (getIntent() != null && this.caH != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.caH.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.caH.sendTextMessage(stringExtra2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.azX = "";
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ctc);
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajy().ajH();
        com.baidu.adp.lib.e.a.cZ().a(this.locationCallBack);
    }

    public List<UserData> getUserDataList() {
        return FloatingPersonalChatActivityStatic.getList();
    }

    public void jT(int i) {
        List<UserData> list;
        if ((this.caH instanceof PersonalMsglistModel) && (list = FloatingPersonalChatActivityStatic.getList()) != null && list.size() > 0 && i < list.size()) {
            PersonalMsglistModel personalMsglistModel = (PersonalMsglistModel) this.caH;
            personalMsglistModel.setUser(list.get(i));
            if (personalMsglistModel.getUser() != null) {
                this.azX = personalMsglistModel.getUser().getUserId();
            }
            ChatStatusManager.getInst().setCurId(0, this.azX);
            if (personalMsglistModel.getData() != null && personalMsglistModel.getData().getChatMessages() != null) {
                personalMsglistModel.getData().getChatMessages().clear();
            }
            personalMsglistModel.setIsFriend(this.cvX.kf(this.azX) ? 1 : 0);
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cco);
        registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.ctf);
        registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.ctf);
        registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.ctf);
        registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.ctf);
        registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.ctf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long jR(String str) {
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
            this.cvX.akr();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
