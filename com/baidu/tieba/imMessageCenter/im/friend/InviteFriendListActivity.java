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
import com.baidu.tieba.w;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    private p dss;
    private y dst;
    private boolean dsw;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> dsu = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> dsv = new LinkedList<>();
    private final AtomicBoolean dsx = new AtomicBoolean(false);
    private CustomMessageListener dsy = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e cWs = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.cWs);
        registerListener(this.dsy);
        Intent intent = getIntent();
        bj();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.dst.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.dst.initWithBundle(bundle);
        }
        initView();
        OZ();
        if (z) {
            axd();
        }
    }

    private void axd() {
        registerListener(new m(this, CmdConfigCustom.CMD_PERSONAL_CHAT_INITED));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dst.n(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.dss.axn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dss.axo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dst.cancelLoadData();
        if (this.dss != null) {
            this.dss.onDestroy();
        }
    }

    private void bj() {
        this.dst = new y(this);
    }

    private void initView() {
        this.dss = new p(this, this.isFromInviteChat);
        this.dss.mD(100);
    }

    private void OZ() {
        axe();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.dss.getRootView(), true);
        }
    }

    public void axe() {
        String trim;
        if (!isFinishing()) {
            if (this.dsu == null) {
                if (!this.dsx.get()) {
                    this.dsx.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String axl = this.dss.axl();
            if (axl == null) {
                trim = "";
            } else {
                trim = axl.trim();
            }
            if (this.dsu.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(w.l.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.dsw = false;
                this.dss.l(this.dsu, false);
                return;
            }
            this.dsv.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.dsu) {
                String Au = aVar.Au();
                if (Au != null && Au.contains(trim)) {
                    this.dsv.add(aVar);
                }
            }
            this.dsw = true;
            this.dss.l(this.dsv, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dss != null) {
            this.dss.axr();
            if (view.getId() == this.dss.axk()) {
                Qx();
                this.dst.mn(this.dss.axm());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.dsw) {
                if (this.dsv != null && i < this.dsv.size()) {
                    aVar = this.dsv.get(i);
                }
                aVar = null;
            } else {
                if (this.dsu != null && i < this.dsu.size()) {
                    aVar = this.dsu.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.Av(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).dsF;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.dss.axj()) {
            this.dss.axi();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void Qx() {
        showLoadingDialog((String) null, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dss.wK();
    }
}
