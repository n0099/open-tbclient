package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.imMessageCenter.im.chat.PersonalChatDisplayResponse;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    private d ekZ;
    private e ela;
    private boolean eld;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> elb = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> elc = new LinkedList<>();
    private final AtomicBoolean ele = new AtomicBoolean(false);
    private CustomMessageListener elf = new CustomMessageListener(2001184) { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof GetContactListResponsedMessage) {
                InviteFriendListActivity.this.isLoaded = true;
                InviteFriendListActivity.this.ele.set(false);
                InviteFriendListActivity.this.hideLoadingView(InviteFriendListActivity.this.ekZ.getRootView());
                List<com.baidu.tbadk.coreExtra.relationship.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
                if (contacts == null) {
                    contacts = new LinkedList<>();
                }
                InviteFriendListActivity.this.elb = contacts;
                if (InviteFriendListActivity.this.ekZ != null) {
                    InviteFriendListActivity.this.aHQ();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dPL = new com.baidu.adp.framework.listener.c(205002) { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            InviteFriendListActivity.this.closeLoadingDialog();
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205002 && (socketResponsedMessage instanceof ResponseCommitInviteMessage)) {
                ResponseCommitInviteMessage responseCommitInviteMessage = (ResponseCommitInviteMessage) socketResponsedMessage;
                if (responseCommitInviteMessage.getError() != 0) {
                    InviteFriendListActivity.this.showToast(StringUtils.isNull(responseCommitInviteMessage.getErrorString()) ? InviteFriendListActivity.this.getResources().getString(d.k.neterror) : responseCommitInviteMessage.getErrorString());
                    return;
                }
                InviteFriendListActivity.this.showToast(InviteFriendListActivity.this.getPageContext().getString(d.k.send_success), false);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!InviteFriendListActivity.this.isFinishing()) {
                            InviteFriendListActivity.this.finish();
                        }
                    }
                }, 400L);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.dPL);
        registerListener(this.elf);
        Intent intent = getIntent();
        aS();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.ela.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.ela.initWithBundle(bundle);
        }
        initView();
        OT();
        if (z) {
            aHP();
        }
    }

    private void aHP() {
        registerListener(new CustomMessageListener(2001309) { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof PersonalChatDisplayResponse) {
                    InviteFriendListActivity.this.finish();
                }
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ela.r(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.ekZ.aHZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.ekZ.aIa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ela.cancelLoadData();
        if (this.ekZ != null) {
            this.ekZ.onDestroy();
        }
    }

    private void aS() {
        this.ela = new e(this);
    }

    private void initView() {
        this.ekZ = new d(this, this.isFromInviteChat);
        this.ekZ.od(100);
    }

    private void OT() {
        aHQ();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.ekZ.getRootView(), true);
        }
    }

    public void aHQ() {
        String trim;
        if (!isFinishing()) {
            if (this.elb == null) {
                if (!this.ele.get()) {
                    this.ele.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String aHX = this.ekZ.aHX();
            if (aHX == null) {
                trim = "";
            } else {
                trim = aHX.trim();
            }
            if (this.elb.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(d.k.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.eld = false;
                this.ekZ.k(this.elb, false);
                return;
            }
            this.elc.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.elb) {
                String BG = aVar.BG();
                if (BG != null && BG.contains(trim)) {
                    this.elc.add(aVar);
                }
            }
            this.eld = true;
            this.ekZ.k(this.elc, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.ekZ != null) {
            this.ekZ.aId();
            if (view2.getId() == this.ekZ.aHW()) {
                showLoadingDialog();
                this.ela.ob(this.ekZ.aHY());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view2, i, j);
        if (this.isFromInviteChat) {
            if (this.eld) {
                if (this.elc != null && i < this.elc.size()) {
                    aVar = this.elc.get(i);
                }
                aVar = null;
            } else {
                if (this.elb != null && i < this.elb.size()) {
                    aVar = this.elb.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.BH(), 0)));
            }
        } else if (view2 != null && (tag = view2.getTag()) != null && (tag instanceof c.a)) {
            TbCheckBox tbCheckBox = ((c.a) tag).ell;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.ekZ.aHV()) {
            this.ekZ.aHU();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void showLoadingDialog() {
        showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (InviteFriendListActivity.this.ela != null) {
                    InviteFriendListActivity.this.ela.cancelLoadData();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.ekZ.wY();
    }
}
