package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements BdSwitchView.a {
    private av cQi = null;
    private com.baidu.tieba.setting.model.j cQj = null;
    private com.baidu.tbadk.core.dialog.a cQk;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cQi = new av(this);
        this.cQj = new com.baidu.tieba.setting.model.j(this);
        if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
            this.cQi.atH().mC();
        } else {
            this.cQi.atH().mD();
        }
        this.cQi.atI().setTip(getPageContext().getString(i.h.calc_cache_size));
        this.cQi.atI().displayTip();
        this.cQj.a(new ap(this, this));
        registerListener(new aq(this, CmdConfigCustom.IM_CLEAR_MSG));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cQj != null) {
            this.cQj.arV();
        }
        arX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cQi.onChangeSkinType(i);
    }

    private void arX() {
        this.cQi.atL().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cQi != null) {
            if (view == this.cQi.atI()) {
                if (this.cQj != null) {
                    if (TextUtils.isEmpty(this.cQi.atI().getTip())) {
                        showToast(i.h.no_cache_delete);
                    } else {
                        this.cQk = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bF(i.h.alert_clear_all_cache).a(i.h.alert_yes_button, new ar(this)).b(i.h.alert_no_button, new as(this)).b(getPageContext()).sR();
                    }
                }
            } else if (view == this.cQi.atJ()) {
                if (this.cQj != null) {
                    this.cQk = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bF(i.h.alert_clear_cache).a(i.h.alert_yes_button, new at(this)).b(i.h.alert_no_button, new au(this)).b(getPageContext()).sR();
                }
            } else if (view == this.cQi.atL()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.cQi.atK()) {
                atG();
            }
        }
    }

    private void atG() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_MY_WALLET, new IntentConfig(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.cQi.atH())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.cQj.setHeadsetModeOn(true);
            } else {
                this.cQj.setHeadsetModeOn(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cQk != null && this.cQk.isShowing()) {
            this.cQk.dismiss();
        }
        super.onDestroy();
    }
}
