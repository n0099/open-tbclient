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
    private p bNi;
    private y bNj;
    private boolean bNm;
    private boolean isFromInviteChat;
    private boolean isLoaded = false;
    public List<com.baidu.tbadk.coreExtra.relationship.a> bNk = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.a> bNl = new LinkedList<>();
    private final AtomicBoolean bNn = new AtomicBoolean(false);
    private CustomMessageListener bNo = new j(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private final com.baidu.adp.framework.listener.e mListener = new k(this, 205002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.bNo);
        Intent intent = getIntent();
        Hy();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.bNj.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bNj.initWithBundle(bundle);
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
        this.bNj.j(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bNi.Zx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bNi.Zy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bNj.cancelLoadData();
        if (this.bNi != null) {
            this.bNi.onDestroy();
        }
    }

    private void Hy() {
        this.bNj = new y(this);
    }

    private void initView() {
        this.bNi = new p(this, this.isFromInviteChat);
        this.bNi.hP(100);
    }

    private void JH() {
        Zo();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.isLoaded) {
            showLoadingView(this.bNi.getRootView(), true);
        }
    }

    public void Zo() {
        String trim;
        if (!isFinishing()) {
            if (this.bNk == null) {
                if (!this.bNn.get()) {
                    this.bNn.set(true);
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String Zv = this.bNi.Zv();
            if (Zv == null) {
                trim = "";
            } else {
                trim = Zv.trim();
            }
            if (this.bNk.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(i.h.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.bNm = false;
                this.bNi.d(this.bNk, false);
                return;
            }
            this.bNl.clear();
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bNk) {
                String yw = aVar.yw();
                if (yw != null && yw.contains(trim)) {
                    this.bNl.add(aVar);
                }
            }
            this.bNm = true;
            this.bNi.d(this.bNl, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bNi != null) {
            this.bNi.ZB();
            if (view.getId() == this.bNi.Zu()) {
                Zf();
                this.bNj.iJ(this.bNi.Zw());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.a aVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.bNm) {
                if (this.bNl != null && i < this.bNl.size()) {
                    aVar = this.bNl.get(i);
                }
                aVar = null;
            } else {
                if (this.bNk != null && i < this.bNk.size()) {
                    aVar = this.bNk.get(i);
                }
                aVar = null;
            }
            if (aVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.getUserName(), aVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof o.a)) {
            TbCheckBox tbCheckBox = ((o.a) tag).bNu;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bNi.Zt()) {
            this.bNi.Zs();
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
        this.bNi.vA();
    }
}
