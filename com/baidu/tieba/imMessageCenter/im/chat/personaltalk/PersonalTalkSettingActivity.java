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
    private w bHb;
    private r bHc;
    private com.baidu.adp.framework.listener.e bHd = new f(this, 104102);
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.bHc.Xp());
        registerListener(104102, this.bHc.Xp());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.bHc.Xq());
        registerListener(this.bHd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bHc.onDestory();
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
        this.bHc = new r(this, this, this.userId);
    }

    private void initView() {
        this.bHb = new w(this);
        this.bHb.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        this.bHb.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == i.f.user_info_lin) {
            if (this.bHc != null && this.bHc.Xn() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.bHc.Xn().name)));
            }
        } else if (id == i.f.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.ct(getPageContext().getContext().getString(i.h.add_black_alert, this.bHc.Xn().name)).a(i.h.alert_yes_button, new h(this)).b(i.h.alert_no_button, new i(this)).b(getPageContext());
            aVar.sU();
        } else if (id == i.f.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.ct(getPageContext().getContext().getString(i.h.remove_personal_history)).a(i.h.alert_yes_button, new j(this)).b(i.h.alert_no_button, new m(this)).b(getPageContext());
            aVar2.sU();
        } else if (id == i.f.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cs(getPageContext().getContext().getString(i.h.sure_add_somebody_to_black, this.bHc.Xn().name));
            aVar3.ct(getPageContext().getContext().getString(i.h.remove_black_alert)).a(i.h.alert_yes_button, new n(this)).b(i.h.alert_no_button, new o(this)).b(getPageContext());
            aVar3.sU();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.r.a
    public void vE() {
        closeLoadingDialog();
        if (this.bHb != null && this.bHc != null) {
            this.bHb.e(this.bHc);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xw().xy() || !com.baidu.tbadk.coreExtra.messageCenter.c.xw().xE()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.bF(i.h.error_open_personal_single_alloff);
                aVar.b(getResources().getString(i.h.group_create_private_isee), new p(this, aVar));
                aVar.b(getPageContext());
                aVar.sU();
                g(false, z);
                return;
            }
            showLoadingDialog(null);
            this.bHc.dy(z);
            return;
        }
        showLoadingDialog(null);
        this.bHc.dy(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        if (z) {
            boolean Xm = this.bHc.Xm();
            this.bHc.dx(z2);
            this.bHb.dA(z2);
            new q(this, z2).execute(new Void[0]);
            if (Xm != this.bHc.Xm()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.h.hf().postDelayed(new g(this, z2), 500L);
    }
}
