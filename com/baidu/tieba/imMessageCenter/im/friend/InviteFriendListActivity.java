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
    private t bsI;
    private ac bsJ;
    private boolean bsM;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> bsK = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> bsL = new LinkedList<>();
    private final AtomicBoolean bsN = new AtomicBoolean(false);
    private CustomMessageListener bsO = new l(this, 2001188);
    private final com.baidu.adp.framework.listener.e mListener = new m(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.bsO);
        Intent intent = getIntent();
        FY();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.bsJ.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bsJ.initWithBundle(bundle);
        }
        initView();
        Ij();
        if (z) {
            VG();
        }
    }

    private void VG() {
        registerListener(new o(this, 2001316));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bsJ.i(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bsJ.cancelLoadData();
    }

    private void FY() {
        this.bsJ = new ac(this);
    }

    private void initView() {
        this.bsI = new t(this, this.isFromInviteChat);
        this.bsI.gE(100);
    }

    private void Ij() {
        VH();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.bsI.getRootView(), true);
        }
    }

    public void VH() {
        String trim;
        if (!isFinishing()) {
            if (this.bsK == null) {
                if (!this.bsN.get()) {
                    this.bsN.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String VO = this.bsI.VO();
            if (VO == null) {
                trim = "";
            } else {
                trim = VO.trim();
            }
            if (this.bsK.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(com.baidu.tieba.y.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.bsM = false;
                this.bsI.a(this.bsK, false);
                return;
            }
            this.bsL.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bsK) {
                String wI = aVar.wI();
                if (wI != null && wI.contains(trim)) {
                    this.bsL.add(aVar);
                }
            }
            this.bsM = true;
            this.bsI.a((List<com.baidu.tbadk.coreExtra.relationship.a>) this.bsL, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bsI != null) {
            this.bsI.VS();
            if (view.getId() == this.bsI.VN()) {
                Vw();
                this.bsJ.hq(this.bsI.VP());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.bsM) {
                if (this.bsL != null && i < this.bsL.size()) {
                    aVar = this.bsL.get(i);
                }
                aVar = null;
            } else {
                if (this.bsK != null && i < this.bsK.size()) {
                    aVar = this.bsK.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof r)) {
            TbCheckBox tbCheckBox = ((r) tag).bsW;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bsI.VM()) {
            this.bsI.VL();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void Vw() {
        showLoadingDialog(null, new p(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bsI.tP();
    }
}
