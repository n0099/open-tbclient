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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.imMessageCenter.im.chat.PersonalChatDisplayResponse;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes22.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    private boolean isFromInviteChat;
    private d kGn;
    private e kGo;
    private boolean kGs;
    private boolean kGp = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> kGq = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> kGr = new LinkedList<>();
    private final AtomicBoolean kGt = new AtomicBoolean(false);
    private CustomMessageListener kGu = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_CONTACT_LIST) { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof GetContactListResponsedMessage) {
                InviteFriendListActivity.this.kGp = true;
                InviteFriendListActivity.this.kGt.set(false);
                InviteFriendListActivity.this.hideLoadingView(InviteFriendListActivity.this.kGn.getRootView());
                List<com.baidu.tbadk.coreExtra.relationship.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
                if (contacts == null) {
                    contacts = new LinkedList<>();
                }
                InviteFriendListActivity.this.kGq = contacts;
                if (InviteFriendListActivity.this.kGn != null) {
                    InviteFriendListActivity.this.daT();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c kjh = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_COMMIT_INVITE) { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            InviteFriendListActivity.this.closeLoadingDialog();
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205002 && (socketResponsedMessage instanceof ResponseCommitInviteMessage)) {
                ResponseCommitInviteMessage responseCommitInviteMessage = (ResponseCommitInviteMessage) socketResponsedMessage;
                if (responseCommitInviteMessage.getError() != 0) {
                    InviteFriendListActivity.this.showToast(StringUtils.isNull(responseCommitInviteMessage.getErrorString()) ? InviteFriendListActivity.this.getResources().getString(R.string.neterror) : responseCommitInviteMessage.getErrorString());
                    return;
                }
                InviteFriendListActivity.this.showToast(InviteFriendListActivity.this.getPageContext().getString(R.string.send_success), false);
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
        registerListener(this.kjh);
        registerListener(this.kGu);
        Intent intent = getIntent();
        KR();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.kGo.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.kGo.initWithBundle(bundle);
        }
        initView();
        loadData();
        if (z) {
            daS();
        }
    }

    private void daS() {
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
        this.kGo.ay(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.kGn.dbc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.kGn.dbd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kGo.cancelLoadData();
        if (this.kGn != null) {
            this.kGn.onDestroy();
        }
    }

    private void KR() {
        this.kGo = new e(this);
    }

    private void initView() {
        this.kGn = new d(this, this.isFromInviteChat);
        this.kGn.EO(100);
    }

    private void loadData() {
        daT();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.kGp) {
            showLoadingView(this.kGn.getRootView(), true);
        }
    }

    public void daT() {
        String trim;
        if (!isFinishing()) {
            if (this.kGq == null) {
                if (!this.kGt.get()) {
                    this.kGt.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String dba = this.kGn.dba();
            if (dba == null) {
                trim = "";
            } else {
                trim = dba.trim();
            }
            if (this.kGq.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(R.string.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.kGs = false;
                this.kGn.s(this.kGq, false);
                return;
            }
            this.kGr.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.kGq) {
                String bAf = aVar.bAf();
                if (bAf != null && bAf.contains(trim)) {
                    this.kGr.add(aVar);
                }
            }
            this.kGs = true;
            this.kGn.s(this.kGr, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kGn != null) {
            this.kGn.hideKeyboard();
            if (view.getId() == this.kGn.daZ()) {
                showLoadingDialog();
                this.kGo.Oa(this.kGn.dbb());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.kGs) {
                if (this.kGr != null && i < this.kGr.size()) {
                    aVar = this.kGr.get(i);
                }
                aVar = null;
            } else {
                if (this.kGq != null && i < this.kGq.size()) {
                    aVar = this.kGq.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.bAh(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof c.a)) {
            TbCheckBox tbCheckBox = ((c.a) tag).kGA;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kGn.daY()) {
            this.kGn.daX();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void showLoadingDialog() {
        showLoadingDialog((String) null, new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (InviteFriendListActivity.this.kGo != null) {
                    InviteFriendListActivity.this.kGo.cancelLoadData();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kGn.bvt();
    }
}
