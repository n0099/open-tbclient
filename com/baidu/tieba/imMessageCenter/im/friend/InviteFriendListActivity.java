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
    private p drZ;
    private y dsa;
    private boolean dsd;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> dsb = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> dsc = new LinkedList<>();
    private final AtomicBoolean dse = new AtomicBoolean(false);
    private CustomMessageListener dsf = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e cjN = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.cjN);
        registerListener(this.dsf);
        Intent intent = getIntent();
        aa();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.dsa.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.dsa.initWithBundle(bundle);
        }
        initView();
        RL();
        if (z) {
            ayQ();
        }
    }

    private void ayQ() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dsa.l(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.drZ.ayZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.drZ.aza();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dsa.cancelLoadData();
        if (this.drZ != null) {
            this.drZ.onDestroy();
        }
    }

    private void aa() {
        this.dsa = new y(this);
    }

    private void initView() {
        this.drZ = new p(this, this.isFromInviteChat);
        this.drZ.mq(100);
    }

    private void RL() {
        ayR();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.drZ.getRootView(), true);
        }
    }

    public void ayR() {
        String trim;
        if (!isFinishing()) {
            if (this.dsb == null) {
                if (!this.dse.get()) {
                    this.dse.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String searchText = this.drZ.getSearchText();
            if (searchText == null) {
                trim = "";
            } else {
                trim = searchText.trim();
            }
            if (this.dsb.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(r.j.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.dsd = false;
                this.drZ.g(this.dsb, false);
                return;
            }
            this.dsc.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.dsb) {
                String Aq = aVar.Aq();
                if (Aq != null && Aq.contains(trim)) {
                    this.dsc.add(aVar);
                }
            }
            this.dsd = true;
            this.drZ.g(this.dsc, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.drZ != null) {
            this.drZ.azd();
            if (view.getId() == this.drZ.ayX()) {
                ayI();
                this.dsa.mF(this.drZ.ayY());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.dsd) {
                if (this.dsc != null && i < this.dsc.size()) {
                    aVar = this.dsc.get(i);
                }
                aVar = null;
            } else {
                if (this.dsb != null && i < this.dsb.size()) {
                    aVar = this.dsb.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.Ar(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).dsm;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.drZ.ayW()) {
            this.drZ.ayV();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void ayI() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.drZ.wH();
    }
}
