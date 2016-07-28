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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements BdSwitchView.a, r.a {
    private w dcg;
    private r dch;
    private com.baidu.adp.framework.listener.e dci = new f(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.dch.aso());
        registerListener(104102, this.dch.aso());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.dch.asp());
        registerListener(this.dci);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dch.onDestory();
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
        this.dch = new r(this, this, this.userId);
    }

    private void initView() {
        this.dcg = new w(this);
        this.dcg.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().af(i == 1);
        this.dcg.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == u.g.user_info_lin) {
            if (this.dch != null && this.dch.asm() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.dch.asm().name)));
            }
        } else if (id == u.g.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cz(getPageContext().getContext().getString(u.j.add_black_alert, this.dch.asm().name)).a(u.j.alert_yes_button, new h(this)).b(u.j.alert_no_button, new i(this)).b(getPageContext());
            aVar.rS();
        } else if (id == u.g.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cz(getPageContext().getContext().getString(u.j.remove_personal_history)).a(u.j.alert_yes_button, new j(this)).b(u.j.alert_no_button, new m(this)).b(getPageContext());
            aVar2.rS();
        } else if (id == u.g.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cy(getPageContext().getContext().getString(u.j.sure_add_somebody_to_black, this.dch.asm().name));
            aVar3.cz(getPageContext().getContext().getString(u.j.remove_black_alert)).a(u.j.alert_yes_button, new n(this)).b(u.j.alert_no_button, new o(this)).b(getPageContext());
            aVar3.rS();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r.a
    public void uY() {
        closeLoadingDialog();
        if (this.dcg != null && this.dch != null) {
            this.dcg.e(this.dch);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xM() || !com.baidu.tbadk.coreExtra.messageCenter.c.xK().xS()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.bM(u.j.error_open_personal_single_alloff);
                aVar.b(getResources().getString(u.j.group_create_private_isee), new p(this, aVar));
                aVar.b(getPageContext());
                aVar.rS();
                m(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.dch.fR(z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.dch.fR(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z, boolean z2) {
        if (z) {
            boolean asl = this.dch.asl();
            this.dch.fQ(z2);
            this.dcg.fT(z2);
            new q(this, z2).execute(new Void[0]);
            if (asl != this.dch.asl()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.h.h.dL().postDelayed(new g(this, z2), 500L);
    }
}
