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
import com.baidu.tieba.n;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    private p ccH;
    private y ccI;
    private boolean ccL;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> ccJ = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> ccK = new LinkedList<>();
    private final AtomicBoolean ccM = new AtomicBoolean(false);
    private CustomMessageListener ccN = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e mListener = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.ccN);
        Intent intent = getIntent();
        IK();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.ccI.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.ccI.initWithBundle(bundle);
        }
        initView();
        JU();
        if (z) {
            acK();
        }
    }

    private void acK() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ccI.j(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.ccH.acU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.ccH.acV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ccI.cancelLoadData();
        if (this.ccH != null) {
            this.ccH.onDestroy();
        }
    }

    private void IK() {
        this.ccI = new y(this);
    }

    private void initView() {
        this.ccH = new p(this, this.isFromInviteChat);
        this.ccH.iQ(100);
    }

    private void JU() {
        acL();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.ccH.getRootView(), true);
        }
    }

    public void acL() {
        String trim;
        if (!isFinishing()) {
            if (this.ccJ == null) {
                if (!this.ccM.get()) {
                    this.ccM.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String acS = this.ccH.acS();
            if (acS == null) {
                trim = "";
            } else {
                trim = acS.trim();
            }
            if (this.ccJ.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(n.i.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.ccL = false;
                this.ccH.d(this.ccJ, false);
                return;
            }
            this.ccK.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.ccJ) {
                String zu = aVar.zu();
                if (zu != null && zu.contains(trim)) {
                    this.ccK.add(aVar);
                }
            }
            this.ccL = true;
            this.ccH.d(this.ccK, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ccH != null) {
            this.ccH.acY();
            if (view.getId() == this.ccH.acR()) {
                acC();
                this.ccI.jf(this.ccH.acT());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.ccL) {
                if (this.ccK != null && i < this.ccK.size()) {
                    aVar = this.ccK.get(i);
                }
                aVar = null;
            } else {
                if (this.ccJ != null && i < this.ccJ.size()) {
                    aVar = this.ccJ.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).ccT;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.ccH.acQ()) {
            this.ccH.acP();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void acC() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.ccH.wh();
    }
}
