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
    private p cgH;
    private y cgI;
    private boolean cgL;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> cgJ = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> cgK = new LinkedList<>();
    private final AtomicBoolean cgM = new AtomicBoolean(false);
    private CustomMessageListener cgN = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e mListener = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.cgN);
        Intent intent = getIntent();
        Jb();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.cgI.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.cgI.initWithBundle(bundle);
        }
        initView();
        Kn();
        if (z) {
            adT();
        }
    }

    private void adT() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cgI.f(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.cgH.aed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.cgH.aee();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cgI.cancelLoadData();
        if (this.cgH != null) {
            this.cgH.onDestroy();
        }
    }

    private void Jb() {
        this.cgI = new y(this);
    }

    private void initView() {
        this.cgH = new p(this, this.isFromInviteChat);
        this.cgH.jp(100);
    }

    private void Kn() {
        adU();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.cgH.getRootView(), true);
        }
    }

    public void adU() {
        String trim;
        if (!isFinishing()) {
            if (this.cgJ == null) {
                if (!this.cgM.get()) {
                    this.cgM.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String aeb = this.cgH.aeb();
            if (aeb == null) {
                trim = "";
            } else {
                trim = aeb.trim();
            }
            if (this.cgJ.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(n.j.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.cgL = false;
                this.cgH.d(this.cgJ, false);
                return;
            }
            this.cgK.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.cgJ) {
                String zg = aVar.zg();
                if (zg != null && zg.contains(trim)) {
                    this.cgK.add(aVar);
                }
            }
            this.cgL = true;
            this.cgH.d(this.cgK, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cgH != null) {
            this.cgH.aeh();
            if (view.getId() == this.cgH.aea()) {
                adL();
                this.cgI.jt(this.cgH.aec());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.cgL) {
                if (this.cgK != null && i < this.cgK.size()) {
                    aVar = this.cgK.get(i);
                }
                aVar = null;
            } else {
                if (this.cgJ != null && i < this.cgJ.size()) {
                    aVar = this.cgJ.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).cgT;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.cgH.adZ()) {
            this.cgH.adY();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void adL() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cgH.vR();
    }
}
