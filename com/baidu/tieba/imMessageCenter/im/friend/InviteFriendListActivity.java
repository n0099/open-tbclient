package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import com.baidu.tieba.t;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    private p clh;
    private y cli;
    private boolean cll;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> clj = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> clk = new LinkedList<>();
    private final AtomicBoolean clm = new AtomicBoolean(false);
    private CustomMessageListener cln = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e ber = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.ber);
        registerListener(this.cln);
        Intent intent = getIntent();
        agU();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.cli.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.cli.initWithBundle(bundle);
        }
        initView();
        Me();
        if (z) {
            ahd();
        }
    }

    private void ahd() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cli.k(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.clh.ahn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.clh.aho();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cli.cancelLoadData();
        if (this.clh != null) {
            this.clh.onDestroy();
        }
    }

    private void agU() {
        this.cli = new y(this);
    }

    private void initView() {
        this.clh = new p(this, this.isFromInviteChat);
        this.clh.jN(100);
    }

    private void Me() {
        ahe();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.clh.getRootView(), true);
        }
    }

    public void ahe() {
        String trim;
        if (!isFinishing()) {
            if (this.clj == null) {
                if (!this.clm.get()) {
                    this.clm.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String ahl = this.clh.ahl();
            if (ahl == null) {
                trim = "";
            } else {
                trim = ahl.trim();
            }
            if (this.clj.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(t.j.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.cll = false;
                this.clh.c(this.clj, false);
                return;
            }
            this.clk.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.clj) {
                String Ay = aVar.Ay();
                if (Ay != null && Ay.contains(trim)) {
                    this.clk.add(aVar);
                }
            }
            this.cll = true;
            this.clh.c(this.clk, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.clh != null) {
            this.clh.ahr();
            if (view.getId() == this.clh.ahk()) {
                agV();
                this.cli.jx(this.clh.ahm());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.cll) {
                if (this.clk != null && i < this.clk.size()) {
                    aVar = this.clk.get(i);
                }
                aVar = null;
            } else {
                if (this.clj != null && i < this.clj.size()) {
                    aVar = this.clj.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).clv;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.clh.ahj()) {
            this.clh.ahi();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void agV() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.clh.xf();
    }
}
