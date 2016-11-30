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
    private p dxF;
    private y dxG;
    private boolean dxJ;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> dxH = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> dxI = new LinkedList<>();
    private final AtomicBoolean dxK = new AtomicBoolean(false);
    private CustomMessageListener dxL = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e coV = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.coV);
        registerListener(this.dxL);
        Intent intent = getIntent();
        aa();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.dxG.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.dxG.initWithBundle(bundle);
        }
        initView();
        SN();
        if (z) {
            aAN();
        }
    }

    private void aAN() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dxG.l(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.dxF.aAW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dxF.aAX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dxG.cancelLoadData();
        if (this.dxF != null) {
            this.dxF.onDestroy();
        }
    }

    private void aa() {
        this.dxG = new y(this);
    }

    private void initView() {
        this.dxF = new p(this, this.isFromInviteChat);
        this.dxF.my(100);
    }

    private void SN() {
        aAO();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.dxF.getRootView(), true);
        }
    }

    public void aAO() {
        String trim;
        if (!isFinishing()) {
            if (this.dxH == null) {
                if (!this.dxK.get()) {
                    this.dxK.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String searchText = this.dxF.getSearchText();
            if (searchText == null) {
                trim = "";
            } else {
                trim = searchText.trim();
            }
            if (this.dxH.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(r.j.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.dxJ = false;
                this.dxF.g(this.dxH, false);
                return;
            }
            this.dxI.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.dxH) {
                String Ax = aVar.Ax();
                if (Ax != null && Ax.contains(trim)) {
                    this.dxI.add(aVar);
                }
            }
            this.dxJ = true;
            this.dxF.g(this.dxI, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dxF != null) {
            this.dxF.aBa();
            if (view.getId() == this.dxF.aAU()) {
                aAF();
                this.dxG.mS(this.dxF.aAV());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.dxJ) {
                if (this.dxI != null && i < this.dxI.size()) {
                    aVar = this.dxI.get(i);
                }
                aVar = null;
            } else {
                if (this.dxH != null && i < this.dxH.size()) {
                    aVar = this.dxH.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.Ay(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).dxR;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.dxF.aAT()) {
            this.dxF.aAS();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void aAF() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dxF.wM();
    }
}
