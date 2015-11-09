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
import com.baidu.tieba.i;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    private p bND;
    private y bNE;
    private boolean bNH;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> bNF = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> bNG = new LinkedList<>();
    private final AtomicBoolean bNI = new AtomicBoolean(false);
    private CustomMessageListener bNJ = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e mListener = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.bNJ);
        Intent intent = getIntent();
        Hr();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.bNE.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bNE.initWithBundle(bundle);
        }
        initView();
        JT();
        if (z) {
            ZE();
        }
    }

    private void ZE() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bNE.j(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bND.ZO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bND.ZP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bNE.cancelLoadData();
        if (this.bND != null) {
            this.bND.onDestroy();
        }
    }

    private void Hr() {
        this.bNE = new y(this);
    }

    private void initView() {
        this.bND = new p(this, this.isFromInviteChat);
        this.bND.ic(100);
    }

    private void JT() {
        ZF();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.bND.getRootView(), true);
        }
    }

    public void ZF() {
        String trim;
        if (!isFinishing()) {
            if (this.bNF == null) {
                if (!this.bNI.get()) {
                    this.bNI.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String ZM = this.bND.ZM();
            if (ZM == null) {
                trim = "";
            } else {
                trim = ZM.trim();
            }
            if (this.bNF.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(i.h.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.bNH = false;
                this.bND.d(this.bNF, false);
                return;
            }
            this.bNG.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bNF) {
                String yy = aVar.yy();
                if (yy != null && yy.contains(trim)) {
                    this.bNG.add(aVar);
                }
            }
            this.bNH = true;
            this.bND.d(this.bNG, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bND != null) {
            this.bND.ZS();
            if (view.getId() == this.bND.ZL()) {
                Zw();
                this.bNE.iL(this.bND.ZN());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.bNH) {
                if (this.bNG != null && i < this.bNG.size()) {
                    aVar = this.bNG.get(i);
                }
                aVar = null;
            } else {
                if (this.bNF != null && i < this.bNF.size()) {
                    aVar = this.bNF.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).bNP;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bND.ZK()) {
            this.bND.ZJ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void Zw() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bND.vB();
    }
}
