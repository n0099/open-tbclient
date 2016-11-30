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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements BdSwitchView.a, r.a {
    private w duU;
    private r duV;
    private com.baidu.adp.framework.listener.e duW = new f(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.duV.azy());
        registerListener(104102, this.duV.azy());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.duV.azz());
        registerListener(this.duW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.duV.onDestory();
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
        this.duV = new r(this, this, this.userId);
    }

    private void initView() {
        this.duU = new w(this);
        this.duU.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        this.duU.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == r.g.user_info_lin) {
            if (this.duV != null && this.duV.azw() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.duV.azw().name)));
            }
        } else if (id == r.g.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cF(getPageContext().getContext().getString(r.j.add_black_alert, this.duV.azw().name)).a(r.j.alert_yes_button, new h(this)).b(r.j.alert_no_button, new i(this)).b(getPageContext());
            aVar.tq();
        } else if (id == r.g.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cF(getPageContext().getContext().getString(r.j.remove_personal_history)).a(r.j.alert_yes_button, new j(this)).b(r.j.alert_no_button, new m(this)).b(getPageContext());
            aVar2.tq();
        } else if (id == r.g.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cE(getPageContext().getContext().getString(r.j.sure_add_somebody_to_black, this.duV.azw().name));
            aVar3.cF(getPageContext().getContext().getString(r.j.remove_black_alert)).a(r.j.alert_yes_button, new n(this)).b(r.j.alert_no_button, new o(this)).b(getPageContext());
            aVar3.tq();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r.a
    public void ww() {
        closeLoadingDialog();
        if (this.duU != null && this.duV != null) {
            this.duU.e(this.duV);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zj() || !com.baidu.tbadk.coreExtra.messageCenter.c.zh().zp()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.ca(r.j.error_open_personal_single_alloff);
                aVar.b(getResources().getString(r.j.group_create_private_isee), new p(this, aVar));
                aVar.b(getPageContext());
                aVar.tq();
                r(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.duV.gK(z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.duV.gK(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        if (z) {
            boolean azv = this.duV.azv();
            this.duV.gJ(z2);
            this.duU.gM(z2);
            new q(this, z2).execute(new Void[0]);
            if (azv != this.duV.azv()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.h.h.eG().postDelayed(new g(this, z2), 500L);
    }
}
