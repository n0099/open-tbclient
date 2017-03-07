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
import com.baidu.tieba.w;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    private p dkj;
    private y dkk;
    private boolean dkn;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> dkl = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> dkm = new LinkedList<>();
    private final AtomicBoolean dko = new AtomicBoolean(false);
    private CustomMessageListener dkp = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e cOh = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.cOh);
        registerListener(this.dkp);
        Intent intent = getIntent();
        bk();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.dkk.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.dkk.initWithBundle(bundle);
        }
        initView();
        NE();
        if (z) {
            auK();
        }
    }

    private void auK() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dkk.m(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.dkj.auV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dkj.auW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dkk.cancelLoadData();
        if (this.dkj != null) {
            this.dkj.onDestroy();
        }
    }

    private void bk() {
        this.dkk = new y(this);
    }

    private void initView() {
        this.dkj = new p(this, this.isFromInviteChat);
        this.dkj.me(100);
    }

    private void NE() {
        auL();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.dkj.getRootView(), true);
        }
    }

    public void auL() {
        String trim;
        if (!isFinishing()) {
            if (this.dkl == null) {
                if (!this.dko.get()) {
                    this.dko.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String auT = this.dkj.auT();
            if (auT == null) {
                trim = "";
            } else {
                trim = auT.trim();
            }
            if (this.dkl.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(w.l.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.dkn = false;
                this.dkj.i(this.dkl, false);
                return;
            }
            this.dkm.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.dkl) {
                String Aw = aVar.Aw();
                if (Aw != null && Aw.contains(trim)) {
                    this.dkm.add(aVar);
                }
            }
            this.dkn = true;
            this.dkj.i(this.dkm, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dkj != null) {
            this.dkj.auZ();
            if (view.getId() == this.dkj.auS()) {
                auC();
                this.dkk.kV(this.dkj.auU());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.dkn) {
                if (this.dkm != null && i < this.dkm.size()) {
                    aVar = this.dkm.get(i);
                }
                aVar = null;
            } else {
                if (this.dkl != null && i < this.dkl.size()) {
                    aVar = this.dkl.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.Ax(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).dkv;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.dkj.auR()) {
            this.dkj.auQ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void auC() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dkj.wP();
    }
}
