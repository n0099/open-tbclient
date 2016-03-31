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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements BdSwitchView.a {
    private ba eev = null;
    private com.baidu.tieba.setting.model.k eew = null;
    private com.baidu.tbadk.core.dialog.a eex;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eev = new ba(this);
        this.eew = new com.baidu.tieba.setting.model.k(this);
        if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
            this.eev.aPl().mk();
        } else {
            this.eev.aPl().ml();
        }
        this.eev.aPm().setTip(getPageContext().getString(t.j.calc_cache_size));
        this.eev.aPm().displayTip();
        this.eew.a(new au(this, this));
        registerListener(new av(this, CmdConfigCustom.IM_CLEAR_MSG));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eew != null) {
            this.eew.aNq();
        }
        aNs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eev.onChangeSkinType(i);
    }

    private void aNs() {
        this.eev.aPp().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eev != null) {
            if (view == this.eev.aPm()) {
                if (this.eew != null) {
                    if (TextUtils.isEmpty(this.eev.aPm().getTip())) {
                        showToast(t.j.no_cache_delete);
                    } else {
                        this.eex = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ca(t.j.alert_clear_all_cache).a(t.j.alert_yes_button, new aw(this)).b(t.j.alert_no_button, new ax(this)).b(getPageContext()).up();
                    }
                }
            } else if (view == this.eev.aPn()) {
                if (this.eew != null) {
                    this.eex = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ca(t.j.alert_clear_cache).a(t.j.alert_yes_button, new ay(this)).b(t.j.alert_no_button, new az(this)).b(getPageContext()).up();
                }
            } else if (view == this.eev.aPp()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.eev.aPo()) {
                aPk();
            }
        }
    }

    private void aPk() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_MY_WALLET, new IntentConfig(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.eev.aPl())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.eew.setHeadsetModeOn(true);
            } else {
                this.eew.setHeadsetModeOn(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eex != null && this.eex.isShowing()) {
            this.eex.dismiss();
        }
        super.onDestroy();
    }
}
