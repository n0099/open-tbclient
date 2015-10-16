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
    private av cOM = null;
    private com.baidu.tieba.setting.model.j cON = null;
    private com.baidu.tbadk.core.dialog.a cOO;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cOM = new av(this);
        this.cON = new com.baidu.tieba.setting.model.j(this);
        if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
            this.cOM.atf().mB();
        } else {
            this.cOM.atf().mC();
        }
        this.cOM.atg().setTip(getPageContext().getString(i.h.calc_cache_size));
        this.cOM.atg().displayTip();
        this.cON.a(new ap(this, this));
        registerListener(new aq(this, CmdConfigCustom.IM_CLEAR_MSG));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cON != null) {
            this.cON.art();
        }
        arv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cOM.onChangeSkinType(i);
    }

    private void arv() {
        this.cOM.atj().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cOM != null) {
            if (view == this.cOM.atg()) {
                if (this.cON != null) {
                    if (TextUtils.isEmpty(this.cOM.atg().getTip())) {
                        showToast(i.h.no_cache_delete);
                    } else {
                        this.cOO = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bF(i.h.alert_clear_all_cache).a(i.h.alert_yes_button, new ar(this)).b(i.h.alert_no_button, new as(this)).b(getPageContext()).sR();
                    }
                }
            } else if (view == this.cOM.ath()) {
                if (this.cON != null) {
                    this.cOO = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bF(i.h.alert_clear_cache).a(i.h.alert_yes_button, new at(this)).b(i.h.alert_no_button, new au(this)).b(getPageContext()).sR();
                }
            } else if (view == this.cOM.atj()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.cOM.ati()) {
                ate();
            }
        }
    }

    private void ate() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_MY_WALLET, new IntentConfig(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.cOM.atf())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.cON.setHeadsetModeOn(true);
            } else {
                this.cON.setHeadsetModeOn(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cOO != null && this.cOO.isShowing()) {
            this.cOO.dismiss();
        }
        super.onDestroy();
    }
}
