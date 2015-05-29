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
    private bc cgO = null;
    private az cgP = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cgO = new bc(this);
        this.cgP = new az(this);
        if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
            this.cgO.ajW().mt();
        } else {
            this.cgO.ajW().mu();
        }
        this.cgO.ajX().setTip(getPageContext().getString(com.baidu.tieba.t.calc_cache_size));
        this.cgO.ajX().displayTip();
        this.cgP.a(new at(this, this));
        registerListener(new au(this, 2008016));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cgP != null) {
            this.cgP.ajV();
        }
        ais();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cgO.onChangeSkinType(i);
    }

    private void ais() {
        this.cgO.ajZ().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cgO.ajX()) {
            if (this.cgP != null) {
                if (TextUtils.isEmpty(this.cgO.ajX().getTip())) {
                    showToast(com.baidu.tieba.t.no_cache_delete);
                } else {
                    new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bu(com.baidu.tieba.t.alert_clear_all_cache).a(com.baidu.tieba.t.alert_yes_button, new av(this)).b(com.baidu.tieba.t.alert_no_button, new aw(this)).b(getPageContext()).rL();
                }
            }
        } else if (view == this.cgO.ajY()) {
            new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bu(com.baidu.tieba.t.alert_clear_cache).a(com.baidu.tieba.t.alert_yes_button, new ax(this)).b(com.baidu.tieba.t.alert_no_button, new ay(this)).b(getPageContext()).rL();
        } else if (view == this.cgO.ajZ()) {
            sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.cgO.ajW())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.cgP.setHeadsetModeOn(true);
            } else {
                this.cgP.setHeadsetModeOn(false);
            }
        }
    }
}
