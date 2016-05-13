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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements BdSwitchView.a, r.a {
    private w ctU;
    private r ctV;
    private com.baidu.adp.framework.listener.e ctW = new f(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.ctV.ajo());
        registerListener(104102, this.ctV.ajo());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.ctV.ajp());
        registerListener(this.ctW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ctV.onDestory();
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
        this.ctV = new r(this, this, this.userId);
    }

    private void initView() {
        this.ctU = new w(this);
        this.ctU.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ae(i == 1);
        this.ctU.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == t.g.user_info_lin) {
            if (this.ctV != null && this.ctV.ajm() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.ctV.ajm().name)));
            }
        } else if (id == t.g.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cA(getPageContext().getContext().getString(t.j.add_black_alert, this.ctV.ajm().name)).a(t.j.alert_yes_button, new h(this)).b(t.j.alert_no_button, new i(this)).b(getPageContext());
            aVar.rV();
        } else if (id == t.g.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cA(getPageContext().getContext().getString(t.j.remove_personal_history)).a(t.j.alert_yes_button, new j(this)).b(t.j.alert_no_button, new m(this)).b(getPageContext());
            aVar2.rV();
        } else if (id == t.g.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cz(getPageContext().getContext().getString(t.j.sure_add_somebody_to_black, this.ctV.ajm().name));
            aVar3.cA(getPageContext().getContext().getString(t.j.remove_black_alert)).a(t.j.alert_yes_button, new n(this)).b(t.j.alert_no_button, new o(this)).b(getPageContext());
            aVar3.rV();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r.a
    public void uY() {
        closeLoadingDialog();
        if (this.ctU != null && this.ctV != null) {
            this.ctU.e(this.ctV);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xG().xI() || !com.baidu.tbadk.coreExtra.messageCenter.c.xG().xO()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.bL(t.j.error_open_personal_single_alloff);
                aVar.b(getResources().getString(t.j.group_create_private_isee), new p(this, aVar));
                aVar.b(getPageContext());
                aVar.rV();
                l(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.ctV.fa(z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.ctV.fa(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z, boolean z2) {
        if (z) {
            boolean ajl = this.ctV.ajl();
            this.ctV.eZ(z2);
            this.ctU.fc(z2);
            new q(this, z2).execute(new Void[0]);
            if (ajl != this.ctV.ajl()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.h.h.dL().postDelayed(new g(this, z2), 500L);
    }
}
