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
    private t bvt;
    private ac bvu;
    private boolean bvx;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> bvv = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> bvw = new LinkedList<>();
    private final AtomicBoolean bvy = new AtomicBoolean(false);
    private CustomMessageListener bvz = new l(this, 2001188);
    private final com.baidu.adp.framework.listener.e mListener = new m(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.bvz);
        Intent intent = getIntent();
        GY();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.bvu.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bvu.initWithBundle(bundle);
        }
        initView();
        Jj();
        if (z) {
            WY();
        }
    }

    private void WY() {
        registerListener(new o(this, 2001316));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bvu.i(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bvu.cancelLoadData();
    }

    private void GY() {
        this.bvu = new ac(this);
    }

    private void initView() {
        this.bvt = new t(this, this.isFromInviteChat);
        this.bvt.gV(100);
    }

    private void Jj() {
        WZ();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.bvt.getRootView(), true);
        }
    }

    public void WZ() {
        String trim;
        if (!isFinishing()) {
            if (this.bvv == null) {
                if (!this.bvy.get()) {
                    this.bvy.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String Xg = this.bvt.Xg();
            if (Xg == null) {
                trim = "";
            } else {
                trim = Xg.trim();
            }
            if (this.bvv.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(com.baidu.tieba.t.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.bvx = false;
                this.bvt.a(this.bvv, false);
                return;
            }
            this.bvw.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bvv) {
                String xv = aVar.xv();
                if (xv != null && xv.contains(trim)) {
                    this.bvw.add(aVar);
                }
            }
            this.bvx = true;
            this.bvt.a((List<com.baidu.tbadk.coreExtra.relationship.a>) this.bvw, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bvt != null) {
            this.bvt.Xk();
            if (view.getId() == this.bvt.Xf()) {
                WO();
                this.bvu.hT(this.bvt.Xh());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.bvx) {
                if (this.bvw != null && i < this.bvw.size()) {
                    aVar = this.bvw.get(i);
                }
                aVar = null;
            } else {
                if (this.bvv != null && i < this.bvv.size()) {
                    aVar = this.bvv.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof r)) {
            TbCheckBox tbCheckBox = ((r) tag).bvG;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bvt.Xe()) {
            this.bvt.Xd();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void WO() {
        showLoadingDialog(null, new p(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bvt.uy();
    }
}
