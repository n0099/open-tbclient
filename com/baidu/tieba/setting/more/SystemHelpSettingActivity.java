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
    private bb cbW = null;
    private ay cbX = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cbW = new bb(this);
        this.cbX = new ay(this);
        if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
            this.cbW.ahQ().ma();
        } else {
            this.cbW.ahQ().mb();
        }
        this.cbW.ahR().setTip(getPageContext().getString(com.baidu.tieba.y.calc_cache_size));
        this.cbW.ahR().displayTip();
        this.cbX.a(new as(this, this));
        registerListener(new at(this, 2008016));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cbX != null) {
            this.cbX.ahP();
        }
        agk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cbW.onChangeSkinType(i);
    }

    private void agk() {
        this.cbW.ahT().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cbW.ahR()) {
            if (this.cbX != null) {
                if (TextUtils.isEmpty(this.cbW.ahR().getTip())) {
                    showToast(com.baidu.tieba.y.no_cache_delete);
                } else {
                    new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bw(com.baidu.tieba.y.alert_title).ac(false).bx(com.baidu.tieba.y.alert_clear_all_cache).a(com.baidu.tieba.y.alert_yes_button, new au(this)).b(com.baidu.tieba.y.alert_no_button, new av(this)).b(getPageContext()).re();
                }
            }
        } else if (view == this.cbW.ahS()) {
            new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bw(com.baidu.tieba.y.alert_title).ac(false).bx(com.baidu.tieba.y.alert_clear_cache).a(com.baidu.tieba.y.alert_yes_button, new aw(this)).b(com.baidu.tieba.y.alert_no_button, new ax(this)).b(getPageContext()).re();
        } else if (view == this.cbW.ahT()) {
            sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.cbW.ahQ())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.cbX.setHeadsetModeOn(true);
            } else {
                this.cbX.setHeadsetModeOn(false);
            }
        }
    }
}
