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
    private p diI;
    private y diJ;
    private boolean diM;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> diK = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> diL = new LinkedList<>();
    private final AtomicBoolean diN = new AtomicBoolean(false);
    private CustomMessageListener diO = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e cME = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.cME);
        registerListener(this.diO);
        Intent intent = getIntent();
        bj();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.diJ.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.diJ.initWithBundle(bundle);
        }
        initView();
        Oc();
        if (z) {
            auD();
        }
    }

    private void auD() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.diJ.n(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.diI.auO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.diI.auP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.diJ.cancelLoadData();
        if (this.diI != null) {
            this.diI.onDestroy();
        }
    }

    private void bj() {
        this.diJ = new y(this);
    }

    private void initView() {
        this.diI = new p(this, this.isFromInviteChat);
        this.diI.mf(100);
    }

    private void Oc() {
        auE();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.diI.getRootView(), true);
        }
    }

    public void auE() {
        String trim;
        if (!isFinishing()) {
            if (this.diK == null) {
                if (!this.diN.get()) {
                    this.diN.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String auM = this.diI.auM();
            if (auM == null) {
                trim = "";
            } else {
                trim = auM.trim();
            }
            if (this.diK.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(w.l.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.diM = false;
                this.diI.i(this.diK, false);
                return;
            }
            this.diL.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.diK) {
                String AV = aVar.AV();
                if (AV != null && AV.contains(trim)) {
                    this.diL.add(aVar);
                }
            }
            this.diM = true;
            this.diI.i(this.diL, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.diI != null) {
            this.diI.auS();
            if (view.getId() == this.diI.auL()) {
                auv();
                this.diJ.lb(this.diI.auN());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.diM) {
                if (this.diL != null && i < this.diL.size()) {
                    aVar = this.diL.get(i);
                }
                aVar = null;
            } else {
                if (this.diK != null && i < this.diK.size()) {
                    aVar = this.diK.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.AW(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).diU;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.diI.auK()) {
            this.diI.auJ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void auv() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.diI.xl();
    }
}
