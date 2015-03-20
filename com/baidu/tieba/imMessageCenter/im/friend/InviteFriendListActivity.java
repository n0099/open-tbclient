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
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    private t bss;
    private ac bst;
    private boolean bsw;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> bsu = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> bsv = new LinkedList<>();
    private final AtomicBoolean bsx = new AtomicBoolean(false);
    private CustomMessageListener bsy = new l(this, 2001188);
    private final com.baidu.adp.framework.listener.e mListener = new m(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.bsy);
        Intent intent = getIntent();
        FS();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.bst.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bst.initWithBundle(bundle);
        }
        initView();
        Id();
        if (z) {
            Vt();
        }
    }

    private void Vt() {
        registerListener(new o(this, 2001316));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bst.i(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bst.cancelLoadData();
    }

    private void FS() {
        this.bst = new ac(this);
    }

    private void initView() {
        this.bss = new t(this, this.isFromInviteChat);
        this.bss.gC(100);
    }

    private void Id() {
        Vu();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.bss.getRootView(), true);
        }
    }

    public void Vu() {
        String trim;
        if (!isFinishing()) {
            if (this.bsu == null) {
                if (!this.bsx.get()) {
                    this.bsx.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String VB = this.bss.VB();
            if (VB == null) {
                trim = "";
            } else {
                trim = VB.trim();
            }
            if (this.bsu.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(com.baidu.tieba.y.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.bsw = false;
                this.bss.a(this.bsu, false);
                return;
            }
            this.bsv.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bsu) {
                String wC = aVar.wC();
                if (wC != null && wC.contains(trim)) {
                    this.bsv.add(aVar);
                }
            }
            this.bsw = true;
            this.bss.a((List<com.baidu.tbadk.coreExtra.relationship.a>) this.bsv, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bss != null) {
            this.bss.VF();
            if (view.getId() == this.bss.VA()) {
                Vj();
                this.bst.hn(this.bss.VC());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.bsw) {
                if (this.bsv != null && i < this.bsv.size()) {
                    aVar = this.bsv.get(i);
                }
                aVar = null;
            } else {
                if (this.bsu != null && i < this.bsu.size()) {
                    aVar = this.bsu.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof r)) {
            TbCheckBox tbCheckBox = ((r) tag).bsG;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bss.Vz()) {
            this.bss.Vy();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void Vj() {
        showLoadingDialog(null, new p(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bss.tP();
    }
}
