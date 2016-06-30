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
    private w cZj;
    private r cZk;
    private com.baidu.adp.framework.listener.e cZl = new f(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.cZk.arC());
        registerListener(104102, this.cZk.arC());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.cZk.arD());
        registerListener(this.cZl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cZk.onDestory();
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
        this.cZk = new r(this, this, this.userId);
    }

    private void initView() {
        this.cZj = new w(this);
        this.cZj.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        this.cZj.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == u.g.user_info_lin) {
            if (this.cZk != null && this.cZk.arA() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.cZk.arA().name)));
            }
        } else if (id == u.g.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cz(getPageContext().getContext().getString(u.j.add_black_alert, this.cZk.arA().name)).a(u.j.alert_yes_button, new h(this)).b(u.j.alert_no_button, new i(this)).b(getPageContext());
            aVar.rT();
        } else if (id == u.g.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cz(getPageContext().getContext().getString(u.j.remove_personal_history)).a(u.j.alert_yes_button, new j(this)).b(u.j.alert_no_button, new m(this)).b(getPageContext());
            aVar2.rT();
        } else if (id == u.g.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cy(getPageContext().getContext().getString(u.j.sure_add_somebody_to_black, this.cZk.arA().name));
            aVar3.cz(getPageContext().getContext().getString(u.j.remove_black_alert)).a(u.j.alert_yes_button, new n(this)).b(u.j.alert_no_button, new o(this)).b(getPageContext());
            aVar3.rT();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r.a
    public void uY() {
        closeLoadingDialog();
        if (this.cZj != null && this.cZk != null) {
            this.cZj.e(this.cZk);
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
                aVar.rT();
                m(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.cZk.fO(z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.cZk.fO(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z, boolean z2) {
        if (z) {
            boolean arz = this.cZk.arz();
            this.cZk.fN(z2);
            this.cZj.fQ(z2);
            new q(this, z2).execute(new Void[0]);
            if (arz != this.cZk.arz()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.h.h.dM().postDelayed(new g(this, z2), 500L);
    }
}
