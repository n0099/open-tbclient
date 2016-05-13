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
    private p cwI;
    private y cwJ;
    private boolean cwM;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> cwK = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> cwL = new LinkedList<>();
    private final AtomicBoolean cwN = new AtomicBoolean(false);
    private CustomMessageListener cwO = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e bfe = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.bfe);
        registerListener(this.cwO);
        Intent intent = getIntent();
        akw();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.cwJ.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.cwJ.initWithBundle(bundle);
        }
        initView();
        ME();
        if (z) {
            akF();
        }
    }

    private void akF() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cwJ.n(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.cwI.akP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.cwI.akQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cwJ.cancelLoadData();
        if (this.cwI != null) {
            this.cwI.onDestroy();
        }
    }

    private void akw() {
        this.cwJ = new y(this);
    }

    private void initView() {
        this.cwI = new p(this, this.isFromInviteChat);
        this.cwI.jX(100);
    }

    private void ME() {
        akG();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.cwI.getRootView(), true);
        }
    }

    public void akG() {
        String trim;
        if (!isFinishing()) {
            if (this.cwK == null) {
                if (!this.cwN.get()) {
                    this.cwN.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String akN = this.cwI.akN();
            if (akN == null) {
                trim = "";
            } else {
                trim = akN.trim();
            }
            if (this.cwK.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(t.j.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.cwM = false;
                this.cwI.e(this.cwK, false);
                return;
            }
            this.cwL.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.cwK) {
                String yV = aVar.yV();
                if (yV != null && yV.contains(trim)) {
                    this.cwL.add(aVar);
                }
            }
            this.cwM = true;
            this.cwI.e(this.cwL, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cwI != null) {
            this.cwI.akT();
            if (view.getId() == this.cwI.akM()) {
                akx();
                this.cwJ.kj(this.cwI.akO());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.cwM) {
                if (this.cwL != null && i < this.cwL.size()) {
                    aVar = this.cwL.get(i);
                }
                aVar = null;
            } else {
                if (this.cwK != null && i < this.cwK.size()) {
                    aVar = this.cwK.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).cwV;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.cwI.akL()) {
            this.cwI.akK();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void akx() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cwI.vm();
    }
}
