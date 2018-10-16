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
import com.baidu.tieba.e;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.imMessageCenter.im.chat.PersonalChatDisplayResponse;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    private d eTY;
    private e eTZ;
    private boolean eUd;
    private boolean isFromInviteChat;
    private boolean eUa = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> eUb = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> eUc = new LinkedList<>();
    private final AtomicBoolean eUe = new AtomicBoolean(false);
    private CustomMessageListener eUf = new CustomMessageListener(2001184) { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof GetContactListResponsedMessage) {
                InviteFriendListActivity.this.eUa = true;
                InviteFriendListActivity.this.eUe.set(false);
                InviteFriendListActivity.this.hideLoadingView(InviteFriendListActivity.this.eTY.getRootView());
                List<com.baidu.tbadk.coreExtra.relationship.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
                if (contacts == null) {
                    contacts = new LinkedList<>();
                }
                InviteFriendListActivity.this.eUb = contacts;
                if (InviteFriendListActivity.this.eTY != null) {
                    InviteFriendListActivity.this.aTP();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eyR = new com.baidu.adp.framework.listener.c(205002) { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            InviteFriendListActivity.this.closeLoadingDialog();
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205002 && (socketResponsedMessage instanceof ResponseCommitInviteMessage)) {
                ResponseCommitInviteMessage responseCommitInviteMessage = (ResponseCommitInviteMessage) socketResponsedMessage;
                if (responseCommitInviteMessage.getError() != 0) {
                    InviteFriendListActivity.this.showToast(StringUtils.isNull(responseCommitInviteMessage.getErrorString()) ? InviteFriendListActivity.this.getResources().getString(e.j.neterror) : responseCommitInviteMessage.getErrorString());
                    return;
                }
                InviteFriendListActivity.this.showToast(InviteFriendListActivity.this.getPageContext().getString(e.j.send_success), false);
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
        registerListener(this.eyR);
        registerListener(this.eUf);
        Intent intent = getIntent();
        fd();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.eTZ.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.eTZ.initWithBundle(bundle);
        }
        initView();
        loadData();
        if (z) {
            aTO();
        }
    }

    private void aTO() {
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
        this.eTZ.t(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.eTY.aTY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eTY.aTZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eTZ.cancelLoadData();
        if (this.eTY != null) {
            this.eTY.onDestroy();
        }
    }

    private void fd() {
        this.eTZ = new e(this);
    }

    private void initView() {
        this.eTY = new d(this, this.isFromInviteChat);
        this.eTY.pL(100);
    }

    private void loadData() {
        aTP();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.eUa) {
            showLoadingView(this.eTY.getRootView(), true);
        }
    }

    public void aTP() {
        String trim;
        if (!isFinishing()) {
            if (this.eUb == null) {
                if (!this.eUe.get()) {
                    this.eUe.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String aTW = this.eTY.aTW();
            if (aTW == null) {
                trim = "";
            } else {
                trim = aTW.trim();
            }
            if (this.eUb.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(e.j.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.eUd = false;
                this.eTY.m(this.eUb, false);
                return;
            }
            this.eUc.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.eUb) {
                String IK = aVar.IK();
                if (IK != null && IK.contains(trim)) {
                    this.eUc.add(aVar);
                }
            }
            this.eUd = true;
            this.eTY.m(this.eUc, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eTY != null) {
            this.eTY.aUc();
            if (view.getId() == this.eTY.aTV()) {
                showLoadingDialog();
                this.eTZ.qe(this.eTY.aTX());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.eUd) {
                if (this.eUc != null && i < this.eUc.size()) {
                    aVar = this.eUc.get(i);
                }
                aVar = null;
            } else {
                if (this.eUb != null && i < this.eUb.size()) {
                    aVar = this.eUb.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.IN(), aVar.IL(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof c.a)) {
            TbCheckBox tbCheckBox = ((c.a) tag).eUl;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.eTY.aTU()) {
            this.eTY.aTT();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void showLoadingDialog() {
        showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (InviteFriendListActivity.this.eTZ != null) {
                    InviteFriendListActivity.this.eTZ.cancelLoadData();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eTY.DV();
    }
}
