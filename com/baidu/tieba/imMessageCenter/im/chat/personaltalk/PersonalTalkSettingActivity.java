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
    private w cir;
    private r cis;
    private com.baidu.adp.framework.listener.e cit = new f(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.cis.afM());
        registerListener(104102, this.cis.afM());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.cis.afN());
        registerListener(this.cit);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cis.onDestory();
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
        this.cis = new r(this, this, this.userId);
    }

    private void initView() {
        this.cir = new w(this);
        this.cir.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ac(i == 1);
        this.cir.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == t.g.user_info_lin) {
            if (this.cis != null && this.cis.afK() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.cis.afK().name)));
            }
        } else if (id == t.g.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cE(getPageContext().getContext().getString(t.j.add_black_alert, this.cis.afK().name)).a(t.j.alert_yes_button, new h(this)).b(t.j.alert_no_button, new i(this)).b(getPageContext());
            aVar.uj();
        } else if (id == t.g.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cE(getPageContext().getContext().getString(t.j.remove_personal_history)).a(t.j.alert_yes_button, new j(this)).b(t.j.alert_no_button, new m(this)).b(getPageContext());
            aVar2.uj();
        } else if (id == t.g.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cD(getPageContext().getContext().getString(t.j.sure_add_somebody_to_black, this.cis.afK().name));
            aVar3.cE(getPageContext().getContext().getString(t.j.remove_black_alert)).a(t.j.alert_yes_button, new n(this)).b(t.j.alert_no_button, new o(this)).b(getPageContext());
            aVar3.uj();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r.a
    public void wV() {
        closeLoadingDialog();
        if (this.cir != null && this.cis != null) {
            this.cir.e(this.cis);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zm() || !com.baidu.tbadk.coreExtra.messageCenter.c.zk().zs()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.bY(t.j.error_open_personal_single_alloff);
                aVar.b(getResources().getString(t.j.group_create_private_isee), new p(this, aVar));
                aVar.b(getPageContext());
                aVar.uj();
                k(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.cis.ec(z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.cis.ec(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z, boolean z2) {
        if (z) {
            boolean afJ = this.cis.afJ();
            this.cis.eb(z2);
            this.cir.ee(z2);
            new q(this, z2).execute(new Void[0]);
            if (afJ != this.cis.afJ()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.h.h.hr().postDelayed(new g(this, z2), 500L);
    }
}
