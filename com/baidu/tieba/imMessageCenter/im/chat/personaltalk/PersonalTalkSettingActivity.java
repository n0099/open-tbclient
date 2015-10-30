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
    private w bKr;
    private r bKs;
    private com.baidu.adp.framework.listener.e bKt = new f(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.bKs.XT());
        registerListener(104102, this.bKs.XT());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.bKs.XU());
        registerListener(this.bKt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bKs.onDestory();
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
        this.bKs = new r(this, this, this.userId);
    }

    private void initView() {
        this.bKr = new w(this);
        this.bKr.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        this.bKr.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == i.f.user_info_lin) {
            if (this.bKs != null && this.bKs.XR() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.bKs.XR().name)));
            }
        } else if (id == i.f.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cu(getPageContext().getContext().getString(i.h.add_black_alert, this.bKs.XR().name)).a(i.h.alert_yes_button, new h(this)).b(i.h.alert_no_button, new i(this)).b(getPageContext());
            aVar.sO();
        } else if (id == i.f.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cu(getPageContext().getContext().getString(i.h.remove_personal_history)).a(i.h.alert_yes_button, new j(this)).b(i.h.alert_no_button, new m(this)).b(getPageContext());
            aVar2.sO();
        } else if (id == i.f.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.ct(getPageContext().getContext().getString(i.h.sure_add_somebody_to_black, this.bKs.XR().name));
            aVar3.cu(getPageContext().getContext().getString(i.h.remove_black_alert)).a(i.h.alert_yes_button, new n(this)).b(i.h.alert_no_button, new o(this)).b(getPageContext());
            aVar3.sO();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r.a
    public void vt() {
        closeLoadingDialog();
        if (this.bKr != null && this.bKs != null) {
            this.bKr.e(this.bKs);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xe().xg() || !com.baidu.tbadk.coreExtra.messageCenter.c.xe().xm()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.bF(i.h.error_open_personal_single_alloff);
                aVar.b(getResources().getString(i.h.group_create_private_isee), new p(this, aVar));
                aVar.b(getPageContext());
                aVar.sO();
                g(false, z);
                return;
            }
            showLoadingDialog(null);
            this.bKs.dy(z);
            return;
        }
        showLoadingDialog(null);
        this.bKs.dy(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        if (z) {
            boolean XQ = this.bKs.XQ();
            this.bKs.dx(z2);
            this.bKr.dA(z2);
            new q(this, z2).execute(new Void[0]);
            if (XQ != this.bKs.XQ()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h.hg().postDelayed(new g(this, z2), 500L);
    }
}
