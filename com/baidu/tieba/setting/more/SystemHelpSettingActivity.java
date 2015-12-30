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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements BdSwitchView.a {
    private ay dvR = null;
    private com.baidu.tieba.setting.model.j dvS = null;
    private com.baidu.tbadk.core.dialog.a dvT;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dvR = new ay(this);
        this.dvS = new com.baidu.tieba.setting.model.j(this);
        if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
            this.dvR.aBp().me();
        } else {
            this.dvR.aBp().mf();
        }
        this.dvR.aBq().setTip(getPageContext().getString(n.j.calc_cache_size));
        this.dvR.aBq().displayTip();
        this.dvS.a(new as(this, this));
        registerListener(new at(this, CmdConfigCustom.IM_CLEAR_MSG));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dvS != null) {
            this.dvS.azz();
        }
        azB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dvR.onChangeSkinType(i);
    }

    private void azB() {
        this.dvR.aBt().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dvR != null) {
            if (view == this.dvR.aBq()) {
                if (this.dvS != null) {
                    if (TextUtils.isEmpty(this.dvR.aBq().getTip())) {
                        showToast(n.j.no_cache_delete);
                    } else {
                        this.dvT = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bG(n.j.alert_clear_all_cache).a(n.j.alert_yes_button, new au(this)).b(n.j.alert_no_button, new av(this)).b(getPageContext()).tf();
                    }
                }
            } else if (view == this.dvR.aBr()) {
                if (this.dvS != null) {
                    this.dvT = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bG(n.j.alert_clear_cache).a(n.j.alert_yes_button, new aw(this)).b(n.j.alert_no_button, new ax(this)).b(getPageContext()).tf();
                }
            } else if (view == this.dvR.aBt()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.dvR.aBs()) {
                aBo();
            }
        }
    }

    private void aBo() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_MY_WALLET, new IntentConfig(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.dvR.aBp())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.dvS.setHeadsetModeOn(true);
            } else {
                this.dvS.setHeadsetModeOn(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dvT != null && this.dvT.isShowing()) {
            this.dvT.dismiss();
        }
        super.onDestroy();
    }
}
