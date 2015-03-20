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
    private y bpH;
    private s bpI;
    private com.baidu.adp.framework.listener.e bpJ = new g(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.bpI.Ub());
        registerListener(104102, this.bpI.Ub());
        registerListener(2001118, this.bpI.Uc());
        registerListener(this.bpJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bpI.onDestory();
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
        this.bpI = new s(this, this, this.userId);
    }

    private void initView() {
        this.bpH = new y(this);
        this.bpH.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().X(i == 1);
        this.bpH.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.v.user_info_lin) {
            if (this.bpI != null && this.bpI.TZ() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.bpI.TZ().name)));
            }
        } else if (id == com.baidu.tieba.v.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.ca(getPageContext().getContext().getString(com.baidu.tieba.y.add_black_alert, this.bpI.TZ().name)).a(com.baidu.tieba.y.alert_yes_button, new i(this)).b(com.baidu.tieba.y.alert_no_button, new j(this)).b(getPageContext());
            aVar.re();
        } else if (id == com.baidu.tieba.v.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.ca(getPageContext().getContext().getString(com.baidu.tieba.y.remove_personal_history, this.bpI.TZ().name)).a(com.baidu.tieba.y.alert_yes_button, new k(this)).b(com.baidu.tieba.y.alert_no_button, new n(this)).b(getPageContext());
            aVar2.re();
        } else if (id == com.baidu.tieba.v.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.ca(getPageContext().getContext().getString(com.baidu.tieba.y.remove_black_alert, this.bpI.TZ().name)).a(com.baidu.tieba.y.alert_yes_button, new o(this)).b(com.baidu.tieba.y.alert_no_button, new p(this)).b(getPageContext());
            aVar3.re();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.x
    public void tM() {
        closeLoadingDialog();
        if (this.bpH != null && this.bpI != null) {
            this.bpH.e(this.bpI);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vs() || !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.bx(com.baidu.tieba.y.error_open_personal_single_alloff);
                aVar.c(getResources().getString(com.baidu.tieba.y.group_create_private_isee), new q(this, aVar));
                aVar.b(getPageContext());
                aVar.re();
                c(false, z);
                return;
            }
            showLoadingDialog(null);
            this.bpI.dg(z);
            return;
        }
        showLoadingDialog(null);
        this.bpI.dg(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2) {
        if (z) {
            boolean TY = this.bpI.TY();
            this.bpI.df(z2);
            new r(this, z2).execute(new Void[0]);
            if (TY != this.bpI.TY()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.i.hI().postDelayed(new h(this, z2), 500L);
    }
}
