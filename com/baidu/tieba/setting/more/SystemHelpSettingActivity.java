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
    private ax doE = null;
    private com.baidu.tieba.setting.model.j doF = null;
    private com.baidu.tbadk.core.dialog.a doG;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.doE = new ax(this);
        this.doF = new com.baidu.tieba.setting.model.j(this);
        if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
            this.doE.azj().mG();
        } else {
            this.doE.azj().mH();
        }
        this.doE.azk().setTip(getPageContext().getString(n.i.calc_cache_size));
        this.doE.azk().displayTip();
        this.doF.a(new ar(this, this));
        registerListener(new as(this, CmdConfigCustom.IM_CLEAR_MSG));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.doF != null) {
            this.doF.axt();
        }
        axv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.doE.onChangeSkinType(i);
    }

    private void axv() {
        this.doE.azn().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.doE != null) {
            if (view == this.doE.azk()) {
                if (this.doF != null) {
                    if (TextUtils.isEmpty(this.doE.azk().getTip())) {
                        showToast(n.i.no_cache_delete);
                    } else {
                        this.doG = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bN(n.i.alert_clear_all_cache).a(n.i.alert_yes_button, new at(this)).b(n.i.alert_no_button, new au(this)).b(getPageContext()).tv();
                    }
                }
            } else if (view == this.doE.azl()) {
                if (this.doF != null) {
                    this.doG = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bN(n.i.alert_clear_cache).a(n.i.alert_yes_button, new av(this)).b(n.i.alert_no_button, new aw(this)).b(getPageContext()).tv();
                }
            } else if (view == this.doE.azn()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.doE.azm()) {
                azi();
            }
        }
    }

    private void azi() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_MY_WALLET, new IntentConfig(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.doE.azj())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.doF.setHeadsetModeOn(true);
            } else {
                this.doF.setHeadsetModeOn(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.doG != null && this.doG.isShowing()) {
            this.doG.dismiss();
        }
        super.onDestroy();
    }
}
