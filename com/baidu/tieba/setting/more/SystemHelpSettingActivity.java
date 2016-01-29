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
    private ay dLV = null;
    private com.baidu.tieba.setting.model.j dLW = null;
    private com.baidu.tbadk.core.dialog.a dLX;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dLV = new ay(this);
        this.dLW = new com.baidu.tieba.setting.model.j(this);
        if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
            this.dLV.aIw().ms();
        } else {
            this.dLV.aIw().mt();
        }
        this.dLV.aIx().setTip(getPageContext().getString(t.j.calc_cache_size));
        this.dLV.aIx().displayTip();
        this.dLW.a(new as(this, this));
        registerListener(new at(this, CmdConfigCustom.IM_CLEAR_MSG));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dLW != null) {
            this.dLW.aGG();
        }
        aGI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dLV.onChangeSkinType(i);
    }

    private void aGI() {
        this.dLV.aIA().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dLV != null) {
            if (view == this.dLV.aIx()) {
                if (this.dLW != null) {
                    if (TextUtils.isEmpty(this.dLV.aIx().getTip())) {
                        showToast(t.j.no_cache_delete);
                    } else {
                        this.dLX = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bY(t.j.alert_clear_all_cache).a(t.j.alert_yes_button, new au(this)).b(t.j.alert_no_button, new av(this)).b(getPageContext()).uj();
                    }
                }
            } else if (view == this.dLV.aIy()) {
                if (this.dLW != null) {
                    this.dLX = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bY(t.j.alert_clear_cache).a(t.j.alert_yes_button, new aw(this)).b(t.j.alert_no_button, new ax(this)).b(getPageContext()).uj();
                }
            } else if (view == this.dLV.aIA()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.dLV.aIz()) {
                aIv();
            }
        }
    }

    private void aIv() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_MY_WALLET, new IntentConfig(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.dLV.aIw())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.dLW.setHeadsetModeOn(true);
            } else {
                this.dLW.setHeadsetModeOn(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dLX != null && this.dLX.isShowing()) {
            this.dLX.dismiss();
        }
        super.onDestroy();
    }
}
