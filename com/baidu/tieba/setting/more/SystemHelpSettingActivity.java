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
    private av cHm = null;
    private com.baidu.tieba.setting.model.j cHn = null;
    private com.baidu.tbadk.core.dialog.a cHo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cHm = new av(this);
        this.cHn = new com.baidu.tieba.setting.model.j(this);
        if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
            this.cHm.aqH().mA();
        } else {
            this.cHm.aqH().mB();
        }
        this.cHm.aqI().setTip(getPageContext().getString(i.h.calc_cache_size));
        this.cHm.aqI().displayTip();
        this.cHn.a(new ap(this, this));
        registerListener(new aq(this, CmdConfigCustom.IM_CLEAR_MSG));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cHn != null) {
            this.cHn.aoV();
        }
        aoX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cHm.onChangeSkinType(i);
    }

    private void aoX() {
        this.cHm.aqL().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cHm != null) {
            if (view == this.cHm.aqI()) {
                if (this.cHn != null) {
                    if (TextUtils.isEmpty(this.cHm.aqI().getTip())) {
                        showToast(i.h.no_cache_delete);
                    } else {
                        this.cHo = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bF(i.h.alert_clear_all_cache).a(i.h.alert_yes_button, new ar(this)).b(i.h.alert_no_button, new as(this)).b(getPageContext()).sU();
                    }
                }
            } else if (view == this.cHm.aqJ()) {
                if (this.cHn != null) {
                    this.cHo = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bF(i.h.alert_clear_cache).a(i.h.alert_yes_button, new at(this)).b(i.h.alert_no_button, new au(this)).b(getPageContext()).sU();
                }
            } else if (view == this.cHm.aqL()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.cHm.aqK()) {
                aqG();
            }
        }
    }

    private void aqG() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_MY_WALLET, new IntentConfig(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.cHm.aqH())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.cHn.setHeadsetModeOn(true);
            } else {
                this.cHn.setHeadsetModeOn(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cHo != null && this.cHo.isShowing()) {
            this.cHo.dismiss();
        }
        super.onDestroy();
    }
}
