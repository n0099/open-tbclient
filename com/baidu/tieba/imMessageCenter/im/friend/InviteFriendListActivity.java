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
    private p bJl;
    private y bJm;
    private boolean bJp;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> bJn = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> bJo = new LinkedList<>();
    private final AtomicBoolean bJq = new AtomicBoolean(false);
    private CustomMessageListener bJr = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e mListener = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.bJr);
        Intent intent = getIntent();
        HQ();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.bJm.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bJm.initWithBundle(bundle);
        }
        initView();
        JY();
        if (z) {
            YD();
        }
    }

    private void YD() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bJm.i(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bJl.YN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bJl.YO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bJm.cancelLoadData();
        if (this.bJl != null) {
            this.bJl.onDestroy();
        }
    }

    private void HQ() {
        this.bJm = new y(this);
    }

    private void initView() {
        this.bJl = new p(this, this.isFromInviteChat);
        this.bJl.hz(100);
    }

    private void JY() {
        YE();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.bJl.getRootView(), true);
        }
    }

    public void YE() {
        String trim;
        if (!isFinishing()) {
            if (this.bJn == null) {
                if (!this.bJq.get()) {
                    this.bJq.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String YL = this.bJl.YL();
            if (YL == null) {
                trim = "";
            } else {
                trim = YL.trim();
            }
            if (this.bJn.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(i.C0057i.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.bJp = false;
                this.bJl.c(this.bJn, false);
                return;
            }
            this.bJo.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bJn) {
                String yF = aVar.yF();
                if (yF != null && yF.contains(trim)) {
                    this.bJo.add(aVar);
                }
            }
            this.bJp = true;
            this.bJl.c(this.bJo, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bJl != null) {
            this.bJl.YR();
            if (view.getId() == this.bJl.YK()) {
                Yv();
                this.bJm.iw(this.bJl.YM());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.bJp) {
                if (this.bJo != null && i < this.bJo.size()) {
                    aVar = this.bJo.get(i);
                }
                aVar = null;
            } else {
                if (this.bJn != null && i < this.bJn.size()) {
                    aVar = this.bJn.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).bJx;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bJl.YJ()) {
            this.bJl.YI();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void Yv() {
        showLoadingDialog(null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bJl.vD();
    }
}
