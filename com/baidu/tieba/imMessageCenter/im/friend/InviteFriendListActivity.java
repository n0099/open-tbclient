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
    private p cvL;
    private y cvM;
    private boolean cvP;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> cvN = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> cvO = new LinkedList<>();
    private final AtomicBoolean cvQ = new AtomicBoolean(false);
    private CustomMessageListener cvR = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e bje = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.bje);
        registerListener(this.cvR);
        Intent intent = getIntent();
        ako();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.cvM.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.cvM.initWithBundle(bundle);
        }
        initView();
        NS();
        if (z) {
            akx();
        }
    }

    private void akx() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cvM.m(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.cvL.akH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.cvL.akI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cvM.cancelLoadData();
        if (this.cvL != null) {
            this.cvL.onDestroy();
        }
    }

    private void ako() {
        this.cvM = new y(this);
    }

    private void initView() {
        this.cvL = new p(this, this.isFromInviteChat);
        this.cvL.kt(100);
    }

    private void NS() {
        aky();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.cvL.getRootView(), true);
        }
    }

    public void aky() {
        String trim;
        if (!isFinishing()) {
            if (this.cvN == null) {
                if (!this.cvQ.get()) {
                    this.cvQ.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String akF = this.cvL.akF();
            if (akF == null) {
                trim = "";
            } else {
                trim = akF.trim();
            }
            if (this.cvN.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(t.j.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.cvP = false;
                this.cvL.d(this.cvN, false);
                return;
            }
            this.cvO.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.cvN) {
                String Bb = aVar.Bb();
                if (Bb != null && Bb.contains(trim)) {
                    this.cvO.add(aVar);
                }
            }
            this.cvP = true;
            this.cvL.d(this.cvO, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cvL != null) {
            this.cvL.akL();
            if (view.getId() == this.cvL.akE()) {
                akp();
                this.cvM.kg(this.cvL.akG());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.cvP) {
                if (this.cvO != null && i < this.cvO.size()) {
                    aVar = this.cvO.get(i);
                }
                aVar = null;
            } else {
                if (this.cvN != null && i < this.cvN.size()) {
                    aVar = this.cvN.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).cvY;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.cvL.akD()) {
            this.cvL.akC();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void akp() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cvL.xy();
    }
}
