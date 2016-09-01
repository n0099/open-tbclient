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
    private w dnO;
    private r dnP;
    private com.baidu.adp.framework.listener.e dnQ = new f(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.dnP.axc());
        registerListener(104102, this.dnP.axc());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.dnP.axd());
        registerListener(this.dnQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dnP.onDestory();
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
        this.dnP = new r(this, this, this.userId);
    }

    private void initView() {
        this.dnO = new w(this);
        this.dnO.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        this.dnO.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == t.g.user_info_lin) {
            if (this.dnP != null && this.dnP.axa() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.dnP.axa().name)));
            }
        } else if (id == t.g.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cB(getPageContext().getContext().getString(t.j.add_black_alert, this.dnP.axa().name)).a(t.j.alert_yes_button, new h(this)).b(t.j.alert_no_button, new i(this)).b(getPageContext());
            aVar.sX();
        } else if (id == t.g.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cB(getPageContext().getContext().getString(t.j.remove_personal_history)).a(t.j.alert_yes_button, new j(this)).b(t.j.alert_no_button, new m(this)).b(getPageContext());
            aVar2.sX();
        } else if (id == t.g.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cA(getPageContext().getContext().getString(t.j.sure_add_somebody_to_black, this.dnP.axa().name));
            aVar3.cB(getPageContext().getContext().getString(t.j.remove_black_alert)).a(t.j.alert_yes_button, new n(this)).b(t.j.alert_no_button, new o(this)).b(getPageContext());
            aVar3.sX();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r.a
    public void wc() {
        closeLoadingDialog();
        if (this.dnO != null && this.dnP != null) {
            this.dnO.e(this.dnP);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yX().yZ() || !com.baidu.tbadk.coreExtra.messageCenter.c.yX().zf()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.bZ(t.j.error_open_personal_single_alloff);
                aVar.b(getResources().getString(t.j.group_create_private_isee), new p(this, aVar));
                aVar.b(getPageContext());
                aVar.sX();
                p(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.dnP.gn(z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.dnP.gn(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, boolean z2) {
        if (z) {
            boolean awZ = this.dnP.awZ();
            this.dnP.gm(z2);
            this.dnO.gp(z2);
            new q(this, z2).execute(new Void[0]);
            if (awZ != this.dnP.awZ()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.h.h.eG().postDelayed(new g(this, z2), 500L);
    }
}
