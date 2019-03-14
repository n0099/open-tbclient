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
/* loaded from: classes4.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    private d gvR;
    private e gvS;
    private boolean gvW;
    private boolean isFromInviteChat;
    private boolean gvT = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> gvU = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> gvV = new LinkedList<>();
    private final AtomicBoolean gvX = new AtomicBoolean(false);
    private CustomMessageListener gvY = new CustomMessageListener(2001184) { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof GetContactListResponsedMessage) {
                InviteFriendListActivity.this.gvT = true;
                InviteFriendListActivity.this.gvX.set(false);
                InviteFriendListActivity.this.hideLoadingView(InviteFriendListActivity.this.gvR.getRootView());
                List<com.baidu.tbadk.coreExtra.relationship.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
                if (contacts == null) {
                    contacts = new LinkedList<>();
                }
                InviteFriendListActivity.this.gvU = contacts;
                if (InviteFriendListActivity.this.gvR != null) {
                    InviteFriendListActivity.this.bwW();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gaF = new com.baidu.adp.framework.listener.c(205002) { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            InviteFriendListActivity.this.closeLoadingDialog();
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205002 && (socketResponsedMessage instanceof ResponseCommitInviteMessage)) {
                ResponseCommitInviteMessage responseCommitInviteMessage = (ResponseCommitInviteMessage) socketResponsedMessage;
                if (responseCommitInviteMessage.getError() != 0) {
                    InviteFriendListActivity.this.showToast(StringUtils.isNull(responseCommitInviteMessage.getErrorString()) ? InviteFriendListActivity.this.getResources().getString(d.j.neterror) : responseCommitInviteMessage.getErrorString());
                    return;
                }
                InviteFriendListActivity.this.showToast(InviteFriendListActivity.this.getPageContext().getString(d.j.send_success), false);
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
        registerListener(this.gaF);
        registerListener(this.gvY);
        Intent intent = getIntent();
        fb();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.gvS.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.gvS.initWithBundle(bundle);
        }
        initView();
        loadData();
        if (z) {
            bwV();
        }
    }

    private void bwV() {
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
        this.gvS.X(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gvR.bxf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gvR.bxg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gvS.cancelLoadData();
        if (this.gvR != null) {
            this.gvR.onDestroy();
        }
    }

    private void fb() {
        this.gvS = new e(this);
    }

    private void initView() {
        this.gvR = new d(this, this.isFromInviteChat);
        this.gvR.uw(100);
    }

    private void loadData() {
        bwW();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.gvT) {
            showLoadingView(this.gvR.getRootView(), true);
        }
    }

    public void bwW() {
        String trim;
        if (!isFinishing()) {
            if (this.gvU == null) {
                if (!this.gvX.get()) {
                    this.gvX.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String bxd = this.gvR.bxd();
            if (bxd == null) {
                trim = "";
            } else {
                trim = bxd.trim();
            }
            if (this.gvU.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(d.j.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.gvW = false;
                this.gvR.o(this.gvU, false);
                return;
            }
            this.gvV.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.gvU) {
                String ajN = aVar.ajN();
                if (ajN != null && ajN.contains(trim)) {
                    this.gvV.add(aVar);
                }
            }
            this.gvW = true;
            this.gvR.o(this.gvV, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gvR != null) {
            this.gvR.hideKeyboard();
            if (view.getId() == this.gvR.bxc()) {
                showLoadingDialog();
                this.gvS.xE(this.gvR.bxe());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.gvW) {
                if (this.gvV != null && i < this.gvV.size()) {
                    aVar = this.gvV.get(i);
                }
                aVar = null;
            } else {
                if (this.gvU != null && i < this.gvU.size()) {
                    aVar = this.gvU.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.ajQ(), aVar.ajO(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof c.a)) {
            TbCheckBox tbCheckBox = ((c.a) tag).gwe;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gvR.bxb()) {
            this.gvR.bxa();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void showLoadingDialog() {
        showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (InviteFriendListActivity.this.gvS != null) {
                    InviteFriendListActivity.this.gvS.cancelLoadData();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.gvR.aeK();
    }
}
