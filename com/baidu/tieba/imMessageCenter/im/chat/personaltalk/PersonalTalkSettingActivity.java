package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements BdSwitchView.a, r.a {
    private w bGu;
    private r bGv;
    private com.baidu.adp.framework.listener.e bGw = new f(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.bGv.Xn());
        registerListener(104102, this.bGv.Xn());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.bGv.Xo());
        registerListener(this.bGw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bGv.onDestory();
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
        this.bGv = new r(this, this, this.userId);
    }

    private void initView() {
        this.bGu = new w(this);
        this.bGu.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        this.bGu.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == i.f.user_info_lin) {
            if (this.bGv != null && this.bGv.Xl() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.bGv.Xl().name)));
            }
        } else if (id == i.f.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cn(getPageContext().getContext().getString(i.C0057i.add_black_alert, this.bGv.Xl().name)).a(i.C0057i.alert_yes_button, new h(this)).b(i.C0057i.alert_no_button, new i(this)).b(getPageContext());
            aVar.sP();
        } else if (id == i.f.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cn(getPageContext().getContext().getString(i.C0057i.remove_personal_history)).a(i.C0057i.alert_yes_button, new j(this)).b(i.C0057i.alert_no_button, new m(this)).b(getPageContext());
            aVar2.sP();
        } else if (id == i.f.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cm(getPageContext().getContext().getString(i.C0057i.sure_add_somebody_to_black, this.bGv.Xl().name));
            aVar3.cn(getPageContext().getContext().getString(i.C0057i.remove_black_alert)).a(i.C0057i.alert_yes_button, new n(this)).b(i.C0057i.alert_no_button, new o(this)).b(getPageContext());
            aVar3.sP();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r.a
    public void vz() {
        closeLoadingDialog();
        if (this.bGu != null && this.bGv != null) {
            this.bGu.e(this.bGv);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xq().xs() || !com.baidu.tbadk.coreExtra.messageCenter.c.xq().xy()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.bC(i.C0057i.error_open_personal_single_alloff);
                aVar.b(getResources().getString(i.C0057i.group_create_private_isee), new p(this, aVar));
                aVar.b(getPageContext());
                aVar.sP();
                g(false, z);
                return;
            }
            showLoadingDialog(null);
            this.bGv.dt(z);
            return;
        }
        showLoadingDialog(null);
        this.bGv.dt(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        if (z) {
            boolean Xk = this.bGv.Xk();
            this.bGv.ds(z2);
            this.bGu.dv(z2);
            new q(this, z2).execute(new Void[0]);
            if (Xk != this.bGv.Xk()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h.hi().postDelayed(new g(this, z2), 500L);
    }
}
