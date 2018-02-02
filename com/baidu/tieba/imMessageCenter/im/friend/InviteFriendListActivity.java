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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
    private boolean eMC;
    private d eMy;
    private e eMz;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> eMA = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> eMB = new LinkedList<>();
    private final AtomicBoolean eMD = new AtomicBoolean(false);
    private CustomMessageListener eME = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_CONTACT_LIST) { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof GetContactListResponsedMessage) {
                InviteFriendListActivity.this.isLoaded = true;
                InviteFriendListActivity.this.eMD.set(false);
                InviteFriendListActivity.this.hideLoadingView(InviteFriendListActivity.this.eMy.getRootView());
                List<com.baidu.tbadk.coreExtra.relationship.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
                if (contacts == null) {
                    contacts = new LinkedList<>();
                }
                InviteFriendListActivity.this.eMA = contacts;
                if (InviteFriendListActivity.this.eMy != null) {
                    InviteFriendListActivity.this.aLt();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eqQ = new com.baidu.adp.framework.listener.c(205002) { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.4
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
        registerListener(this.eqQ);
        registerListener(this.eME);
        Intent intent = getIntent();
        iO();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.eMz.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.eMz.initWithBundle(bundle);
        }
        initView();
        VB();
        if (z) {
            aLs();
        }
    }

    private void aLs() {
        registerListener(new CustomMessageListener(CmdConfigCustom.CMD_PERSONAL_CHAT_INITED) { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.1
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
        this.eMz.t(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.eMy.aLC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eMy.aLD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eMz.cancelLoadData();
        if (this.eMy != null) {
            this.eMy.onDestroy();
        }
    }

    private void iO() {
        this.eMz = new e(this);
    }

    private void initView() {
        this.eMy = new d(this, this.isFromInviteChat);
        this.eMy.qJ(100);
    }

    private void VB() {
        aLt();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.eMy.getRootView(), true);
        }
    }

    public void aLt() {
        String trim;
        if (!isFinishing()) {
            if (this.eMA == null) {
                if (!this.eMD.get()) {
                    this.eMD.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String aLA = this.eMy.aLA();
            if (aLA == null) {
                trim = "";
            } else {
                trim = aLA.trim();
            }
            if (this.eMA.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(d.j.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.eMC = false;
                this.eMy.k(this.eMA, false);
                return;
            }
            this.eMB.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.eMA) {
                String Im = aVar.Im();
                if (Im != null && Im.contains(trim)) {
                    this.eMB.add(aVar);
                }
            }
            this.eMC = true;
            this.eMy.k(this.eMB, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eMy != null) {
            this.eMy.aLG();
            if (view.getId() == this.eMy.aLz()) {
                showLoadingDialog();
                this.eMz.nN(this.eMy.aLB());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.eMC) {
                if (this.eMB != null && i < this.eMB.size()) {
                    aVar = this.eMB.get(i);
                }
                aVar = null;
            } else {
                if (this.eMA != null && i < this.eMA.size()) {
                    aVar = this.eMA.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.In(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof c.a)) {
            TbCheckBox tbCheckBox = ((c.a) tag).eMK;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.eMy.aLy()) {
            this.eMy.aLx();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void showLoadingDialog() {
        showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (InviteFriendListActivity.this.eMz != null) {
                    InviteFriendListActivity.this.eMz.cancelLoadData();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eMy.DT();
    }
}
