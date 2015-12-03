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
    private w bZQ;
    private r bZR;
    private com.baidu.adp.framework.listener.e bZS = new f(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.bZR.abu());
        registerListener(104102, this.bZR.abu());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.bZR.abv());
        registerListener(this.bZS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bZR.onDestory();
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
        this.bZR = new r(this, this, this.userId);
    }

    private void initView() {
        this.bZQ = new w(this);
        this.bZQ.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().af(i == 1);
        this.bZQ.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == n.f.user_info_lin) {
            if (this.bZR != null && this.bZR.abs() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.bZR.abs().name)));
            }
        } else if (id == n.f.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cC(getPageContext().getContext().getString(n.i.add_black_alert, this.bZR.abs().name)).a(n.i.alert_yes_button, new h(this)).b(n.i.alert_no_button, new i(this)).b(getPageContext());
            aVar.tv();
        } else if (id == n.f.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cC(getPageContext().getContext().getString(n.i.remove_personal_history)).a(n.i.alert_yes_button, new j(this)).b(n.i.alert_no_button, new m(this)).b(getPageContext());
            aVar2.tv();
        } else if (id == n.f.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cB(getPageContext().getContext().getString(n.i.sure_add_somebody_to_black, this.bZR.abs().name));
            aVar3.cC(getPageContext().getContext().getString(n.i.remove_black_alert)).a(n.i.alert_yes_button, new n(this)).b(n.i.alert_no_button, new o(this)).b(getPageContext());
            aVar3.tv();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r.a
    public void wd() {
        closeLoadingDialog();
        if (this.bZQ != null && this.bZR != null) {
            this.bZQ.e(this.bZR);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yg().yi() || !com.baidu.tbadk.coreExtra.messageCenter.c.yg().yo()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.bN(n.i.error_open_personal_single_alloff);
                aVar.b(getResources().getString(n.i.group_create_private_isee), new p(this, aVar));
                aVar.b(getPageContext());
                aVar.tv();
                g(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.bZR.dV(z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.bZR.dV(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        if (z) {
            boolean abr = this.bZR.abr();
            this.bZR.dU(z2);
            this.bZQ.dX(z2);
            new q(this, z2).execute(new Void[0]);
            if (abr != this.bZR.abr()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.h.h.hj().postDelayed(new g(this, z2), 500L);
    }
}
