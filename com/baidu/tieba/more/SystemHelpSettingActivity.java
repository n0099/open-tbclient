package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SystemHelpSettingActivityConfig;
import com.baidu.tieba.plugins.PluginCenterActivity;
/* loaded from: classes.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements com.baidu.adp.widget.BdSwitchView.c {
    private bi byc = null;
    private bf byd = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(SystemHelpSettingActivityConfig.class, SystemHelpSettingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.byc = new bi(this);
        this.byd = new bf(this);
        if (TbadkCoreApplication.m255getInst().isHeadsetModeOn()) {
            this.byc.Wx().iL();
        } else {
            this.byc.Wx().iM();
        }
        this.byc.Wy().setTip(getPageContext().getString(com.baidu.tieba.z.calc_cache_size));
        this.byc.Wy().tV();
        this.byd.a(new az(this, this));
        registerListener(new ba(this, 2008016));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.byd != null) {
            this.byd.Ww();
        }
        this.byc.WA().refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.byc.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byc.Wy()) {
            if (this.byd != null) {
                if (TextUtils.isEmpty(this.byc.Wy().getTip())) {
                    showToast(com.baidu.tieba.z.no_cache_delete);
                } else {
                    new AlertDialog.Builder(getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.z.alert_clear_all_cache).setPositiveButton(com.baidu.tieba.z.alert_yes_button, new bb(this)).setNegativeButton(com.baidu.tieba.z.alert_no_button, new bc(this)).create().show();
                }
            }
        } else if (view == this.byc.Wz()) {
            new AlertDialog.Builder(getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.z.alert_clear_cache).setPositiveButton(com.baidu.tieba.z.alert_yes_button, new bd(this)).setNegativeButton(com.baidu.tieba.z.alert_no_button, new be(this)).create().show();
        } else if (view == this.byc.WA()) {
            startActivity(new Intent(getPageContext().getPageActivity(), PluginCenterActivity.class));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.byc.Wx())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.byd.setHeadsetModeOn(true);
            } else {
                this.byd.setHeadsetModeOn(false);
            }
        }
    }
}
