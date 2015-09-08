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
    private p bJS;
    private y bJT;
    private boolean bJW;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> bJU = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> bJV = new LinkedList<>();
    private final AtomicBoolean bJX = new AtomicBoolean(false);
    private CustomMessageListener bJY = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e mListener = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.bJY);
        Intent intent = getIntent();
        HE();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.bJT.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bJT.initWithBundle(bundle);
        }
        initView();
        JM();
        if (z) {
            YF();
        }
    }

    private void YF() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bJT.i(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bJS.YP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bJS.YQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bJT.cancelLoadData();
        if (this.bJS != null) {
            this.bJS.onDestroy();
        }
    }

    private void HE() {
        this.bJT = new y(this);
    }

    private void initView() {
        this.bJS = new p(this, this.isFromInviteChat);
        this.bJS.hJ(100);
    }

    private void JM() {
        YG();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.bJS.getRootView(), true);
        }
    }

    public void YG() {
        String trim;
        if (!isFinishing()) {
            if (this.bJU == null) {
                if (!this.bJX.get()) {
                    this.bJX.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String YN = this.bJS.YN();
            if (YN == null) {
                trim = "";
            } else {
                trim = YN.trim();
            }
            if (this.bJU.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(i.h.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.bJW = false;
                this.bJS.c(this.bJU, false);
                return;
            }
            this.bJV.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bJU) {
                String yM = aVar.yM();
                if (yM != null && yM.contains(trim)) {
                    this.bJV.add(aVar);
                }
            }
            this.bJW = true;
            this.bJS.c(this.bJV, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bJS != null) {
            this.bJS.YT();
            if (view.getId() == this.bJS.YM()) {
                Yx();
                this.bJT.iF(this.bJS.YO());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.bJW) {
                if (this.bJV != null && i < this.bJV.size()) {
                    aVar = this.bJV.get(i);
                }
                aVar = null;
            } else {
                if (this.bJU != null && i < this.bJU.size()) {
                    aVar = this.bJU.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).bKe;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bJS.YL()) {
            this.bJS.YK();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void Yx() {
        showLoadingDialog(null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bJS.vI();
    }
}
