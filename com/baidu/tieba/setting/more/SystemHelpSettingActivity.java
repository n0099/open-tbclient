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
    private av cyO = null;
    private com.baidu.tieba.setting.model.j cyP = null;
    private com.baidu.tbadk.core.dialog.a cyQ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cyO = new av(this);
        this.cyP = new com.baidu.tieba.setting.model.j(this);
        if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
            this.cyO.amy().mD();
        } else {
            this.cyO.amy().mE();
        }
        this.cyO.amz().setTip(getPageContext().getString(i.C0057i.calc_cache_size));
        this.cyO.amz().displayTip();
        this.cyP.a(new ap(this, this));
        registerListener(new aq(this, CmdConfigCustom.IM_CLEAR_MSG));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cyP != null) {
            this.cyP.akO();
        }
        akQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cyO.onChangeSkinType(i);
    }

    private void akQ() {
        this.cyO.amC().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cyO != null) {
            if (view == this.cyO.amz()) {
                if (this.cyP != null) {
                    if (TextUtils.isEmpty(this.cyO.amz().getTip())) {
                        showToast(i.C0057i.no_cache_delete);
                    } else {
                        this.cyQ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bC(i.C0057i.alert_clear_all_cache).a(i.C0057i.alert_yes_button, new ar(this)).b(i.C0057i.alert_no_button, new as(this)).b(getPageContext()).sP();
                    }
                }
            } else if (view == this.cyO.amA()) {
                if (this.cyP != null) {
                    this.cyQ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bC(i.C0057i.alert_clear_cache).a(i.C0057i.alert_yes_button, new at(this)).b(i.C0057i.alert_no_button, new au(this)).b(getPageContext()).sP();
                }
            } else if (view == this.cyO.amC()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.cyO.amB()) {
                amx();
            }
        }
    }

    private void amx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_MY_WALLET, new IntentConfig(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.cyO.amy())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.cyP.setHeadsetModeOn(true);
            } else {
                this.cyP.setHeadsetModeOn(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cyQ != null && this.cyQ.isShowing()) {
            this.cyQ.dismiss();
        }
        super.onDestroy();
    }
}
