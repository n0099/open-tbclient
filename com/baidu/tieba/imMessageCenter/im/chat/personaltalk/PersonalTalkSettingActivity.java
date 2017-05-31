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
/* loaded from: classes2.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements BdSwitchView.a, r.a {
    private w djO;
    private r djP;
    private com.baidu.adp.framework.listener.e djQ = new f(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.djP.atl());
        registerListener(104102, this.djP.atl());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.djP.atm());
        registerListener(this.djQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.djP.onDestory();
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
        this.djP = new r(this, this, this.userId);
    }

    private void initView() {
        this.djO = new w(this);
        this.djO.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        this.djO.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == w.h.user_info_lin) {
            if (this.djP != null && this.djP.atj() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.djP.atj().name)));
            }
        } else if (id == w.h.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cB(getPageContext().getContext().getString(w.l.add_black_alert, this.djP.atj().name)).a(w.l.alert_yes_button, new h(this)).b(w.l.alert_no_button, new i(this)).b(getPageContext());
            aVar.tc();
        } else if (id == w.h.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cB(getPageContext().getContext().getString(w.l.remove_personal_history)).a(w.l.alert_yes_button, new j(this)).b(w.l.alert_no_button, new m(this)).b(getPageContext());
            aVar2.tc();
        } else if (id == w.h.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cA(getPageContext().getContext().getString(w.l.sure_add_somebody_to_black, this.djP.atj().name));
            aVar3.cB(getPageContext().getContext().getString(w.l.remove_black_alert)).a(w.l.alert_yes_button, new n(this)).b(w.l.alert_no_button, new o(this)).b(getPageContext());
            aVar3.tc();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r.a
    public void we() {
        closeLoadingDialog();
        if (this.djO != null && this.djP != null) {
            this.djO.e(this.djP);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yK().yM() || !com.baidu.tbadk.coreExtra.messageCenter.c.yK().yS()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.bY(w.l.error_open_personal_single_alloff);
                aVar.b(getResources().getString(w.l.group_create_private_isee), new p(this, aVar));
                aVar.b(getPageContext());
                aVar.tc();
                s(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.djP.gm(z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.djP.gm(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z, boolean z2) {
        if (z) {
            boolean ati = this.djP.ati();
            this.djP.gl(z2);
            this.djO.go(z2);
            new q(this, z2).execute(new Void[0]);
            if (ati != this.djP.ati()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h.fS().postDelayed(new g(this, z2), 500L);
    }
}
