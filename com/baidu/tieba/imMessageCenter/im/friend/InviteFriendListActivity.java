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
    private t bvu;
    private ac bvv;
    private boolean bvy;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> bvw = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> bvx = new LinkedList<>();
    private final AtomicBoolean bvz = new AtomicBoolean(false);
    private CustomMessageListener bvA = new l(this, 2001188);
    private final com.baidu.adp.framework.listener.e mListener = new m(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.bvA);
        Intent intent = getIntent();
        GZ();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.bvv.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bvv.initWithBundle(bundle);
        }
        initView();
        Jk();
        if (z) {
            WZ();
        }
    }

    private void WZ() {
        registerListener(new o(this, 2001316));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bvv.i(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bvv.cancelLoadData();
    }

    private void GZ() {
        this.bvv = new ac(this);
    }

    private void initView() {
        this.bvu = new t(this, this.isFromInviteChat);
        this.bvu.gV(100);
    }

    private void Jk() {
        Xa();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.bvu.getRootView(), true);
        }
    }

    public void Xa() {
        String trim;
        if (!isFinishing()) {
            if (this.bvw == null) {
                if (!this.bvz.get()) {
                    this.bvz.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String Xh = this.bvu.Xh();
            if (Xh == null) {
                trim = "";
            } else {
                trim = Xh.trim();
            }
            if (this.bvw.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(com.baidu.tieba.t.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.bvy = false;
                this.bvu.a(this.bvw, false);
                return;
            }
            this.bvx.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bvw) {
                String xw = aVar.xw();
                if (xw != null && xw.contains(trim)) {
                    this.bvx.add(aVar);
                }
            }
            this.bvy = true;
            this.bvu.a((List<com.baidu.tbadk.coreExtra.relationship.a>) this.bvx, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bvu != null) {
            this.bvu.Xl();
            if (view.getId() == this.bvu.Xg()) {
                WP();
                this.bvv.hT(this.bvu.Xi());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.bvy) {
                if (this.bvx != null && i < this.bvx.size()) {
                    aVar = this.bvx.get(i);
                }
                aVar = null;
            } else {
                if (this.bvw != null && i < this.bvw.size()) {
                    aVar = this.bvw.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof r)) {
            TbCheckBox tbCheckBox = ((r) tag).bvH;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bvu.Xf()) {
            this.bvu.Xe();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void WP() {
        showLoadingDialog(null, new p(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bvu.uy();
    }
}
