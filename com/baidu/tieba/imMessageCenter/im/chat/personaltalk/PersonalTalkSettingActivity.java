package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements BdSwitchView.a, r.a {
    private w cdR;
    private r cdS;
    private com.baidu.adp.framework.listener.e cdT = new f(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.cdS.acD());
        registerListener(104102, this.cdS.acD());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.cdS.acE());
        registerListener(this.cdT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cdS.onDestory();
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
        this.cdS = new r(this, this, this.userId);
    }

    private void initView() {
        this.cdR = new w(this);
        this.cdR.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ac(i == 1);
        this.cdR.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == n.g.user_info_lin) {
            if (this.cdS != null && this.cdS.acB() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.cdS.acB().name)));
            }
        } else if (id == n.g.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cF(getPageContext().getContext().getString(n.j.add_black_alert, this.cdS.acB().name)).a(n.j.alert_yes_button, new h(this)).b(n.j.alert_no_button, new i(this)).b(getPageContext());
            aVar.tf();
        } else if (id == n.g.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cF(getPageContext().getContext().getString(n.j.remove_personal_history)).a(n.j.alert_yes_button, new j(this)).b(n.j.alert_no_button, new m(this)).b(getPageContext());
            aVar2.tf();
        } else if (id == n.g.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cE(getPageContext().getContext().getString(n.j.sure_add_somebody_to_black, this.cdS.acB().name));
            aVar3.cF(getPageContext().getContext().getString(n.j.remove_black_alert)).a(n.j.alert_yes_button, new n(this)).b(n.j.alert_no_button, new o(this)).b(getPageContext());
            aVar3.tf();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r.a
    public void vN() {
        closeLoadingDialog();
        if (this.cdR != null && this.cdS != null) {
            this.cdR.e(this.cdS);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xS().xU() || !com.baidu.tbadk.coreExtra.messageCenter.c.xS().ya()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.bG(n.j.error_open_personal_single_alloff);
                aVar.b(getResources().getString(n.j.group_create_private_isee), new p(this, aVar));
                aVar.b(getPageContext());
                aVar.tf();
                i(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.cdS.dV(z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.cdS.dV(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, boolean z2) {
        if (z) {
            boolean acA = this.cdS.acA();
            this.cdS.dU(z2);
            this.cdR.dX(z2);
            new q(this, z2).execute(new Void[0]);
            if (acA != this.cdS.acA()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.h.h.hj().postDelayed(new g(this, z2), 500L);
    }
}
