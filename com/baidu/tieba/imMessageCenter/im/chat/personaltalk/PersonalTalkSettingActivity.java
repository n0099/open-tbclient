package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tieba.im.message.SettingChangeMessage;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements com.baidu.adp.widget.BdSwitchView.b, x {
    private y bsC;
    private s bsD;
    private com.baidu.adp.framework.listener.e bsE = new g(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.bsD.VF());
        registerListener(104102, this.bsD.VF());
        registerListener(2001118, this.bsD.VG());
        registerListener(this.bsE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bsD.onDestory();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("userId", this.userId);
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            this.userId = getIntent().getLongExtra("userId", 0L);
        } else {
            this.userId = bundle.getLong("userId");
        }
        this.bsD = new s(this, this, this.userId);
    }

    private void initView() {
        this.bsC = new y(this);
        this.bsC.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        this.bsC.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.q.user_info_lin) {
            if (this.bsD != null && this.bsD.VD() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.bsD.VD().name)));
            }
        } else if (id == com.baidu.tieba.q.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cn(getPageContext().getContext().getString(com.baidu.tieba.t.add_black_alert, this.bsD.VD().name)).a(com.baidu.tieba.t.alert_yes_button, new i(this)).b(com.baidu.tieba.t.alert_no_button, new j(this)).b(getPageContext());
            aVar.rL();
        } else if (id == com.baidu.tieba.q.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cn(getPageContext().getContext().getString(com.baidu.tieba.t.remove_personal_history)).a(com.baidu.tieba.t.alert_yes_button, new k(this)).b(com.baidu.tieba.t.alert_no_button, new n(this)).b(getPageContext());
            aVar2.rL();
        } else if (id == com.baidu.tieba.q.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cm(getPageContext().getContext().getString(com.baidu.tieba.t.sure_add_somebody_to_black, this.bsD.VD().name));
            aVar3.cn(getPageContext().getContext().getString(com.baidu.tieba.t.remove_black_alert)).a(com.baidu.tieba.t.alert_yes_button, new o(this)).b(com.baidu.tieba.t.alert_no_button, new p(this)).b(getPageContext());
            aVar3.rL();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.x
    public void uv() {
        closeLoadingDialog();
        if (this.bsC != null && this.bsD != null) {
            this.bsC.e(this.bsD);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wi() || !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.bu(com.baidu.tieba.t.error_open_personal_single_alloff);
                aVar.b(getResources().getString(com.baidu.tieba.t.group_create_private_isee), new q(this, aVar));
                aVar.b(getPageContext());
                aVar.rL();
                d(false, z);
                return;
            }
            showLoadingDialog(null);
            this.bsD.dq(z);
            return;
        }
        showLoadingDialog(null);
        this.bsD.dq(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, boolean z2) {
        if (z) {
            boolean VC = this.bsD.VC();
            this.bsD.dp(z2);
            if (z2) {
                this.bsC.ds(true);
            }
            new r(this, z2).execute(new Void[0]);
            if (VC != this.bsD.VC()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.i.hs().postDelayed(new h(this, z2), 500L);
    }
}
