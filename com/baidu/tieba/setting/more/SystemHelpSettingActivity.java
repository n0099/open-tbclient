package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
/* loaded from: classes.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements com.baidu.adp.widget.BdSwitchView.b {
    private bc cgP = null;
    private az cgQ = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cgP = new bc(this);
        this.cgQ = new az(this);
        if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
            this.cgP.ajX().mt();
        } else {
            this.cgP.ajX().mu();
        }
        this.cgP.ajY().setTip(getPageContext().getString(com.baidu.tieba.t.calc_cache_size));
        this.cgP.ajY().displayTip();
        this.cgQ.a(new at(this, this));
        registerListener(new au(this, 2008016));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cgQ != null) {
            this.cgQ.ajW();
        }
        ait();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cgP.onChangeSkinType(i);
    }

    private void ait() {
        this.cgP.aka().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cgP.ajY()) {
            if (this.cgQ != null) {
                if (TextUtils.isEmpty(this.cgP.ajY().getTip())) {
                    showToast(com.baidu.tieba.t.no_cache_delete);
                } else {
                    new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bu(com.baidu.tieba.t.alert_clear_all_cache).a(com.baidu.tieba.t.alert_yes_button, new av(this)).b(com.baidu.tieba.t.alert_no_button, new aw(this)).b(getPageContext()).rL();
                }
            }
        } else if (view == this.cgP.ajZ()) {
            new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bu(com.baidu.tieba.t.alert_clear_cache).a(com.baidu.tieba.t.alert_yes_button, new ax(this)).b(com.baidu.tieba.t.alert_no_button, new ay(this)).b(getPageContext()).rL();
        } else if (view == this.cgP.aka()) {
            sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.cgP.ajX())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.cgQ.setHeadsetModeOn(true);
            } else {
                this.cgQ.setHeadsetModeOn(false);
            }
        }
    }
}
