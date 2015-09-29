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
    private av cOn = null;
    private com.baidu.tieba.setting.model.j cOo = null;
    private com.baidu.tbadk.core.dialog.a cOp;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cOn = new av(this);
        this.cOo = new com.baidu.tieba.setting.model.j(this);
        if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
            this.cOn.asZ().mB();
        } else {
            this.cOn.asZ().mC();
        }
        this.cOn.ata().setTip(getPageContext().getString(i.h.calc_cache_size));
        this.cOn.ata().displayTip();
        this.cOo.a(new ap(this, this));
        registerListener(new aq(this, CmdConfigCustom.IM_CLEAR_MSG));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cOo != null) {
            this.cOo.arn();
        }
        arp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cOn.onChangeSkinType(i);
    }

    private void arp() {
        this.cOn.atd().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cOn != null) {
            if (view == this.cOn.ata()) {
                if (this.cOo != null) {
                    if (TextUtils.isEmpty(this.cOn.ata().getTip())) {
                        showToast(i.h.no_cache_delete);
                    } else {
                        this.cOp = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bF(i.h.alert_clear_all_cache).a(i.h.alert_yes_button, new ar(this)).b(i.h.alert_no_button, new as(this)).b(getPageContext()).sR();
                    }
                }
            } else if (view == this.cOn.atb()) {
                if (this.cOo != null) {
                    this.cOp = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bF(i.h.alert_clear_cache).a(i.h.alert_yes_button, new at(this)).b(i.h.alert_no_button, new au(this)).b(getPageContext()).sR();
                }
            } else if (view == this.cOn.atd()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.cOn.atc()) {
                asY();
            }
        }
    }

    private void asY() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_MY_WALLET, new IntentConfig(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.cOn.asZ())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.cOo.setHeadsetModeOn(true);
            } else {
                this.cOo.setHeadsetModeOn(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cOp != null && this.cOp.isShowing()) {
            this.cOp.dismiss();
        }
        super.onDestroy();
    }
}
