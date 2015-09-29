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
    private p bMX;
    private y bMY;
    private boolean bNb;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> bMZ = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> bNa = new LinkedList<>();
    private final AtomicBoolean bNc = new AtomicBoolean(false);
    private CustomMessageListener bNd = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e mListener = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.bNd);
        Intent intent = getIntent();
        Hy();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.bMY.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bMY.initWithBundle(bundle);
        }
        initView();
        JH();
        if (z) {
            Zn();
        }
    }

    private void Zn() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bMY.j(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bMX.Zx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bMX.Zy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bMY.cancelLoadData();
        if (this.bMX != null) {
            this.bMX.onDestroy();
        }
    }

    private void Hy() {
        this.bMY = new y(this);
    }

    private void initView() {
        this.bMX = new p(this, this.isFromInviteChat);
        this.bMX.hP(100);
    }

    private void JH() {
        Zo();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.bMX.getRootView(), true);
        }
    }

    public void Zo() {
        String trim;
        if (!isFinishing()) {
            if (this.bMZ == null) {
                if (!this.bNc.get()) {
                    this.bNc.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String Zv = this.bMX.Zv();
            if (Zv == null) {
                trim = "";
            } else {
                trim = Zv.trim();
            }
            if (this.bMZ.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(i.h.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.bNb = false;
                this.bMX.d(this.bMZ, false);
                return;
            }
            this.bNa.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bMZ) {
                String yw = aVar.yw();
                if (yw != null && yw.contains(trim)) {
                    this.bNa.add(aVar);
                }
            }
            this.bNb = true;
            this.bMX.d(this.bNa, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bMX != null) {
            this.bMX.ZB();
            if (view.getId() == this.bMX.Zu()) {
                Zf();
                this.bMY.iJ(this.bMX.Zw());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.bNb) {
                if (this.bNa != null && i < this.bNa.size()) {
                    aVar = this.bNa.get(i);
                }
                aVar = null;
            } else {
                if (this.bMZ != null && i < this.bMZ.size()) {
                    aVar = this.bMZ.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).bNj;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bMX.Zt()) {
            this.bMX.Zs();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void Zf() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bMX.vA();
    }
}
