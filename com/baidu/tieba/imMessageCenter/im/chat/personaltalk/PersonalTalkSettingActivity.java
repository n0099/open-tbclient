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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements BdSwitchView.a, r.a {
    private w dia;
    private r dib;
    private com.baidu.adp.framework.listener.e dic = new f(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.dib.aus());
        registerListener(104102, this.dib.aus());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.dib.aut());
        registerListener(this.dic);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dib.onDestory();
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
        this.dib = new r(this, this, this.userId);
    }

    private void initView() {
        this.dia = new w(this);
        this.dia.c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aj(i == 1);
        this.dia.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == w.h.user_info_lin) {
            if (this.dib != null && this.dib.auq() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.dib.auq().name)));
            }
        } else if (id == w.h.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cE(getPageContext().getContext().getString(w.l.add_black_alert, this.dib.auq().name)).a(w.l.alert_yes_button, new h(this)).b(w.l.alert_no_button, new i(this)).b(getPageContext());
            aVar.tQ();
        } else if (id == w.h.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cE(getPageContext().getContext().getString(w.l.remove_personal_history)).a(w.l.alert_yes_button, new j(this)).b(w.l.alert_no_button, new m(this)).b(getPageContext());
            aVar2.tQ();
        } else if (id == w.h.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cD(getPageContext().getContext().getString(w.l.sure_add_somebody_to_black, this.dib.auq().name));
            aVar3.cE(getPageContext().getContext().getString(w.l.remove_black_alert)).a(w.l.alert_yes_button, new n(this)).b(w.l.alert_no_button, new o(this)).b(getPageContext());
            aVar3.tQ();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r.a
    public void wU() {
        closeLoadingDialog();
        if (this.dia != null && this.dib != null) {
            this.dia.e(this.dib);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().zI() || !com.baidu.tbadk.coreExtra.messageCenter.c.zG().zO()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.bZ(w.l.error_open_personal_single_alloff);
                aVar.b(getResources().getString(w.l.group_create_private_isee), new p(this, aVar));
                aVar.b(getPageContext());
                aVar.tQ();
                p(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.dib.go(z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.dib.go(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, boolean z2) {
        if (z) {
            boolean aup = this.dib.aup();
            this.dib.gn(z2);
            this.dia.gq(z2);
            new q(this, z2).execute(new Void[0]);
            if (aup != this.dib.aup()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h.fR().postDelayed(new g(this, z2), 500L);
    }
}
