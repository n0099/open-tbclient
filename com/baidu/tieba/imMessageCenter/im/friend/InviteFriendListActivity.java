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
import com.baidu.tieba.r;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    private p dhR;
    private y dhS;
    private boolean dhV;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> dhT = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> dhU = new LinkedList<>();
    private final AtomicBoolean dhW = new AtomicBoolean(false);
    private CustomMessageListener dhX = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e caD = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.caD);
        registerListener(this.dhX);
        Intent intent = getIntent();
        aa();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.dhS.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.dhS.initWithBundle(bundle);
        }
        initView();
        MR();
        if (z) {
            avp();
        }
    }

    private void avp() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dhS.m(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.dhR.avz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dhR.avA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dhS.cancelLoadData();
        if (this.dhR != null) {
            this.dhR.onDestroy();
        }
    }

    private void aa() {
        this.dhS = new y(this);
    }

    private void initView() {
        this.dhR = new p(this, this.isFromInviteChat);
        this.dhR.mo(100);
    }

    private void MR() {
        avq();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.dhR.getRootView(), true);
        }
    }

    public void avq() {
        String trim;
        if (!isFinishing()) {
            if (this.dhT == null) {
                if (!this.dhW.get()) {
                    this.dhW.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String avx = this.dhR.avx();
            if (avx == null) {
                trim = "";
            } else {
                trim = avx.trim();
            }
            if (this.dhT.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(r.l.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.dhV = false;
                this.dhR.i(this.dhT, false);
                return;
            }
            this.dhU.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.dhT) {
                String Af = aVar.Af();
                if (Af != null && Af.contains(trim)) {
                    this.dhU.add(aVar);
                }
            }
            this.dhV = true;
            this.dhR.i(this.dhU, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dhR != null) {
            this.dhR.avD();
            if (view.getId() == this.dhR.avw()) {
                avh();
                this.dhS.lu(this.dhR.avy());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.dhV) {
                if (this.dhU != null && i < this.dhU.size()) {
                    aVar = this.dhU.get(i);
                }
                aVar = null;
            } else {
                if (this.dhT != null && i < this.dhT.size()) {
                    aVar = this.dhT.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.Ag(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).did;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.dhR.avv()) {
            this.dhR.avu();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void avh() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dhR.ws();
    }
}
