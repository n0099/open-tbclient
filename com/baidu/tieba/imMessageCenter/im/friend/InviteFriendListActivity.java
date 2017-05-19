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
/* loaded from: classes2.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    private p dfc;
    private y dfd;
    private boolean dfg;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> dfe = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> dff = new LinkedList<>();
    private final AtomicBoolean dfh = new AtomicBoolean(false);
    private CustomMessageListener dfi = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e cIY = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.cIY);
        registerListener(this.dfi);
        Intent intent = getIntent();
        bj();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.dfd.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.dfd.initWithBundle(bundle);
        }
        initView();
        NA();
        if (z) {
            asz();
        }
    }

    private void asz() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dfd.n(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.dfc.asK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dfc.asL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dfd.cancelLoadData();
        if (this.dfc != null) {
            this.dfc.onDestroy();
        }
    }

    private void bj() {
        this.dfd = new y(this);
    }

    private void initView() {
        this.dfc = new p(this, this.isFromInviteChat);
        this.dfc.lY(100);
    }

    private void NA() {
        asA();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.dfc.getRootView(), true);
        }
    }

    public void asA() {
        String trim;
        if (!isFinishing()) {
            if (this.dfe == null) {
                if (!this.dfh.get()) {
                    this.dfh.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String asI = this.dfc.asI();
            if (asI == null) {
                trim = "";
            } else {
                trim = asI.trim();
            }
            if (this.dfe.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(w.l.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.dfg = false;
                this.dfc.k(this.dfe, false);
                return;
            }
            this.dff.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.dfe) {
                String Ag = aVar.Ag();
                if (Ag != null && Ag.contains(trim)) {
                    this.dff.add(aVar);
                }
            }
            this.dfg = true;
            this.dfc.k(this.dff, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dfc != null) {
            this.dfc.asO();
            if (view.getId() == this.dfc.asH()) {
                asr();
                this.dfd.lg(this.dfc.asJ());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.dfg) {
                if (this.dff != null && i < this.dff.size()) {
                    aVar = this.dff.get(i);
                }
                aVar = null;
            } else {
                if (this.dfe != null && i < this.dfe.size()) {
                    aVar = this.dfe.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.Ah(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).dfp;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.dfc.asG()) {
            this.dfc.asF();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void asr() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dfc.ww();
    }
}
