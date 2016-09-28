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
import com.baidu.tbadk.core.util.az;
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
    private com.baidu.tbadk.coreExtra.relationship.b dor;
    private UserData mUser;
    private Handler mHandler = new Handler();
    private String aEj = "";
    private long doq = 0;
    private String dos = TbadkCoreApplication.getCurrentAccount();
    private boolean dro = false;
    private Runnable dov = new m(this);
    private com.baidu.adp.framework.listener.e dox = new q(this, 205101, true);
    private CustomMessageListener doy = new r(this, 0);
    private a.InterfaceC0005a locationCallBack = new s(this);
    private FloatingPersonalChatView drp = null;
    private View.OnClickListener drq = new t(this);
    private final CustomMessageListener cXB = new u(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void apT() {
        UserData user;
        super.apT();
        if ((this.cVF instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) this.cVF).getUser()) != null) {
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
            window.setBackgroundDrawableResource(r.d.common_color_10065);
        }
        ChatStatusManager.getInst().setIsOpen(0, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.yD().eu(this.aEj);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.aEj, 2)));
        if (this.cVF != null && (this.cVF instanceof PersonalMsglistModel)) {
            ((PersonalMsglistModel) this.cVF).azh();
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
        if (this.cVF != null && FloatingPersonalChatActivityStatic.getList() != null && FloatingPersonalChatActivityStatic.getList().size() > 0 && !this.dro) {
            this.dro = true;
            this.drp = new FloatingPersonalChatView(this, this.cVF.getIsAcceptNotify(), FloatingPersonalChatActivityStatic.getList());
            this.cVE = this.drp;
            this.drp.setOnClickListener(this.drq);
            this.cVE.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            int i = com.baidu.tieba.im.c.a.dlP;
            if ((this.cVF instanceof PersonalMsglistModel) && (user = (personalMsglistModel = (PersonalMsglistModel) this.cVF).getUser()) != null) {
                this.mUser = user;
                this.drp.a(this.mUser.getUserName(), this.dor);
                this.cVE.bindDataAndRefresh(personalMsglistModel.getData(), i);
                this.cVE.setRecordCallback(new n(this));
                personalMsglistModel.setIsFriend(user.getIsFriend());
            }
        }
    }

    public void axl() {
        if (TbadkCoreApplication.m9getInst().getLocationShared() && this.mUser != null) {
            String str = String.valueOf(this.dos) + "&" + this.mUser.getUserId();
            if (!FloatingPersonalChatActivityStatic.ayy().mo(str)) {
                com.baidu.adp.lib.e.a.dU().a(true, this.locationCallBack);
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.b mp = FloatingPersonalChatActivityStatic.ayy().mp(str);
            if (mp != null) {
                this.drp.a(this.mUser.getUserName(), mp);
                this.doq = mn(az.r(mp.getTime()));
                if (this.doq != 0) {
                    this.mHandler.postDelayed(this.dov, this.doq);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean k(Bundle bundle) {
        try {
            registerListener(this.dox);
            if (FloatingPersonalChatActivityStatic.ayy() == null) {
                FloatingPersonalChatActivityStatic.c(new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e());
            }
            this.cVF = new PersonalMsglistModel(this);
            this.cVF.setLoadDataCallBack(this.cVQ);
            if (bundle != null) {
                i(bundle);
            } else {
                apU();
            }
            return apV();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(al alVar) {
        if (this.cVF != null) {
            this.cVF.loadFirst(alVar);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    public void a(View view, int i, int i2, long j) {
        c.a mK;
        ChatMessage msg;
        String H;
        super.a(view, i, i2, j);
        if (this.cVF != null) {
            switch (i) {
                case 2:
                    ChatMessage msg2 = this.cVF.getMsg(i2);
                    if (msg2 != null && msg2.getUserInfo() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg2.getUserInfo().getUserId(), msg2.getUserInfo().getUserName())));
                        return;
                    }
                    return;
                case 4:
                    if (aqI() && (msg = this.cVF.getMsg(i2)) != null && com.baidu.tieba.im.util.h.q(msg) && (H = com.baidu.tieba.im.util.h.H(msg.getContent(), true)) != null && (this.cVF instanceof CommonPersonalMsglistModel) && ((CommonPersonalMsglistModel) this.cVF).getUser() != null) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalMsgImageActivityConfig(getPageContext().getContext(), H, ((CommonPersonalMsglistModel) this.cVF).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
                        return;
                    }
                    return;
                case 14:
                    ChatMessage msg3 = this.cVF.getMsg(i2);
                    if (msg3 != null && msg3.getContent() != null && (mK = com.baidu.tieba.imMessageCenter.im.stranger.c.mK(msg3.getContent())) != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(mK.threadId, mK.postId, null)));
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
        aqa();
        if (this.cVF instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.cVF).setIsFriend(bundle.getInt("key_is_friend"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void p(Intent intent) {
        super.p(intent);
        aqa();
        if (this.cVF instanceof PersonalMsglistModel) {
            ((PersonalMsglistModel) this.cVF).setIsFriend(intent.getIntExtra("key_is_friend", 1));
        }
    }

    private void aqa() {
        if (this.cVF == null || !(this.cVF instanceof PersonalMsglistModel)) {
            this.aEj = "";
            return;
        }
        UserData user = ((PersonalMsglistModel) this.cVF).getUser();
        if (user != null) {
            this.aEj = String.valueOf(user.getUserId());
        } else {
            this.aEj = "";
        }
        ChatStatusManager.getInst().setCurId(0, this.aEj);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void apY() {
        super.apY();
        this.handler.postDelayed(new o(this), 60L);
        axl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apZ() {
        if (getIntent() != null && this.cVF != null) {
            String stringExtra = getIntent().getStringExtra("key_share_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra)) {
                getIntent().removeExtra("key_share_msg");
                this.cVF.sendExtraMessage(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_leave_msg");
            if (!com.baidu.adp.lib.util.j.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra("key_leave_msg");
                this.cVF.sendTextMessage(stringExtra2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aEj = "";
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dov);
        }
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.axL().axU();
        com.baidu.adp.lib.e.a.dU().a(this.locationCallBack);
    }

    public List<UserData> getUserDataList() {
        return FloatingPersonalChatActivityStatic.getList();
    }

    public void mm(int i) {
        List<UserData> list;
        if ((this.cVF instanceof PersonalMsglistModel) && (list = FloatingPersonalChatActivityStatic.getList()) != null && list.size() > 0 && i < list.size()) {
            PersonalMsglistModel personalMsglistModel = (PersonalMsglistModel) this.cVF;
            personalMsglistModel.setUser(list.get(i));
            if (personalMsglistModel.getUser() != null) {
                this.aEj = personalMsglistModel.getUser().getUserId();
            }
            ChatStatusManager.getInst().setCurId(0, this.aEj);
            if (personalMsglistModel.getData() != null && personalMsglistModel.getData().getChatMessages() != null) {
                personalMsglistModel.getData().getChatMessages().clear();
            }
            personalMsglistModel.setIsFriend(this.drp.mB(this.aEj) ? 1 : 0);
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cXB);
        registerListener(CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL, this.doy);
        registerListener(CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL, this.doy);
        registerListener(CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE, this.doy);
        registerListener(CmdConfigCustom.CMD_APPLY_ADDFRIEND, this.doy);
        registerListener(CmdConfigCustom.CMD_APPLY_PASSFRIEND, this.doy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long mn(String str) {
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
            this.drp.ayD();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
