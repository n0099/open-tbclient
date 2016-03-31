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
    private w csW;
    private r csX;
    private com.baidu.adp.framework.listener.e csY = new f(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.csX.ajg());
        registerListener(104102, this.csX.ajg());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.csX.ajh());
        registerListener(this.csY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.csX.onDestory();
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
        this.csX = new r(this, this, this.userId);
    }

    private void initView() {
        this.csW = new w(this);
        this.csW.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        this.csW.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == t.g.user_info_lin) {
            if (this.csX != null && this.csX.aje() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.csX.aje().name)));
            }
        } else if (id == t.g.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cC(getPageContext().getContext().getString(t.j.add_black_alert, this.csX.aje().name)).a(t.j.alert_yes_button, new h(this)).b(t.j.alert_no_button, new i(this)).b(getPageContext());
            aVar.up();
        } else if (id == t.g.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cC(getPageContext().getContext().getString(t.j.remove_personal_history)).a(t.j.alert_yes_button, new j(this)).b(t.j.alert_no_button, new m(this)).b(getPageContext());
            aVar2.up();
        } else if (id == t.g.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cB(getPageContext().getContext().getString(t.j.sure_add_somebody_to_black, this.csX.aje().name));
            aVar3.cC(getPageContext().getContext().getString(t.j.remove_black_alert)).a(t.j.alert_yes_button, new n(this)).b(t.j.alert_no_button, new o(this)).b(getPageContext());
            aVar3.up();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r.a
    public void xo() {
        closeLoadingDialog();
        if (this.csW != null && this.csX != null) {
            this.csW.e(this.csX);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().zO() || !com.baidu.tbadk.coreExtra.messageCenter.c.zM().zU()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.ca(t.j.error_open_personal_single_alloff);
                aVar.b(getResources().getString(t.j.group_create_private_isee), new p(this, aVar));
                aVar.b(getPageContext());
                aVar.up();
                m(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.csX.ey(z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.csX.ey(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z, boolean z2) {
        if (z) {
            boolean ajd = this.csX.ajd();
            this.csX.ex(z2);
            this.csW.eA(z2);
            new q(this, z2).execute(new Void[0]);
            if (ajd != this.csX.ajd()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.h.h.hx().postDelayed(new g(this, z2), 500L);
    }
}
