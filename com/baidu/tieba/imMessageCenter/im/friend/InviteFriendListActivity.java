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
    private p dkZ;
    private y dla;
    private boolean dld;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> dlb = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> dlc = new LinkedList<>();
    private final AtomicBoolean dle = new AtomicBoolean(false);
    private CustomMessageListener dlf = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e cOV = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.cOV);
        registerListener(this.dlf);
        Intent intent = getIntent();
        bj();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.dla.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.dla.initWithBundle(bundle);
        }
        initView();
        Ol();
        if (z) {
            avE();
        }
    }

    private void avE() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dla.n(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.dkZ.avP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dkZ.avQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dla.cancelLoadData();
        if (this.dkZ != null) {
            this.dkZ.onDestroy();
        }
    }

    private void bj() {
        this.dla = new y(this);
    }

    private void initView() {
        this.dkZ = new p(this, this.isFromInviteChat);
        this.dkZ.ml(100);
    }

    private void Ol() {
        avF();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.dkZ.getRootView(), true);
        }
    }

    public void avF() {
        String trim;
        if (!isFinishing()) {
            if (this.dlb == null) {
                if (!this.dle.get()) {
                    this.dle.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String avN = this.dkZ.avN();
            if (avN == null) {
                trim = "";
            } else {
                trim = avN.trim();
            }
            if (this.dlb.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(w.l.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.dld = false;
                this.dkZ.i(this.dlb, false);
                return;
            }
            this.dlc.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.dlb) {
                String AV = aVar.AV();
                if (AV != null && AV.contains(trim)) {
                    this.dlc.add(aVar);
                }
            }
            this.dld = true;
            this.dkZ.i(this.dlc, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dkZ != null) {
            this.dkZ.avT();
            if (view.getId() == this.dkZ.avM()) {
                avw();
                this.dla.lc(this.dkZ.avO());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.dld) {
                if (this.dlc != null && i < this.dlc.size()) {
                    aVar = this.dlc.get(i);
                }
                aVar = null;
            } else {
                if (this.dlb != null && i < this.dlb.size()) {
                    aVar = this.dlb.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.AW(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).dll;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.dkZ.avL()) {
            this.dkZ.avK();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void avw() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dkZ.xl();
    }
}
