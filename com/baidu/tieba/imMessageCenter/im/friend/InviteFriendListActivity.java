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
    private p dqC;
    private y dqD;
    private boolean dqG;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> dqE = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> dqF = new LinkedList<>();
    private final AtomicBoolean dqH = new AtomicBoolean(false);
    private CustomMessageListener dqI = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e cjp = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.cjp);
        registerListener(this.dqI);
        Intent intent = getIntent();
        aa();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.dqD.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.dqD.initWithBundle(bundle);
        }
        initView();
        Rt();
        if (z) {
            ays();
        }
    }

    private void ays() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dqD.l(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.dqC.ayB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dqC.ayC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dqD.cancelLoadData();
        if (this.dqC != null) {
            this.dqC.onDestroy();
        }
    }

    private void aa() {
        this.dqD = new y(this);
    }

    private void initView() {
        this.dqC = new p(this, this.isFromInviteChat);
        this.dqC.mi(100);
    }

    private void Rt() {
        ayt();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.dqC.getRootView(), true);
        }
    }

    public void ayt() {
        String trim;
        if (!isFinishing()) {
            if (this.dqE == null) {
                if (!this.dqH.get()) {
                    this.dqH.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String searchText = this.dqC.getSearchText();
            if (searchText == null) {
                trim = "";
            } else {
                trim = searchText.trim();
            }
            if (this.dqE.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(t.j.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.dqG = false;
                this.dqC.g(this.dqE, false);
                return;
            }
            this.dqF.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.dqE) {
                String An = aVar.An();
                if (An != null && An.contains(trim)) {
                    this.dqF.add(aVar);
                }
            }
            this.dqG = true;
            this.dqC.g(this.dqF, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dqC != null) {
            this.dqC.ayF();
            if (view.getId() == this.dqC.ayz()) {
                ayk();
                this.dqD.ms(this.dqC.ayA());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.dqG) {
                if (this.dqF != null && i < this.dqF.size()) {
                    aVar = this.dqF.get(i);
                }
                aVar = null;
            } else {
                if (this.dqE != null && i < this.dqE.size()) {
                    aVar = this.dqE.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.Ao(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).dqP;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.dqC.ayy()) {
            this.dqC.ayx();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void ayk() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dqC.wq();
    }
}
