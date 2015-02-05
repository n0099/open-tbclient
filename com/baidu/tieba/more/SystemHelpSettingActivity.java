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
    private bi byb = null;
    private bf byc = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(SystemHelpSettingActivityConfig.class, SystemHelpSettingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.byb = new bi(this);
        this.byc = new bf(this);
        if (TbadkCoreApplication.m255getInst().isHeadsetModeOn()) {
            this.byb.Ws().iE();
        } else {
            this.byb.Ws().iF();
        }
        this.byb.Wt().setTip(getPageContext().getString(com.baidu.tieba.z.calc_cache_size));
        this.byb.Wt().tP();
        this.byc.a(new az(this, this));
        registerListener(new ba(this, 2008016));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.byc != null) {
            this.byc.Wr();
        }
        this.byb.Wv().refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.byb.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byb.Wt()) {
            if (this.byc != null) {
                if (TextUtils.isEmpty(this.byb.Wt().getTip())) {
                    showToast(com.baidu.tieba.z.no_cache_delete);
                } else {
                    new AlertDialog.Builder(getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.z.alert_clear_all_cache).setPositiveButton(com.baidu.tieba.z.alert_yes_button, new bb(this)).setNegativeButton(com.baidu.tieba.z.alert_no_button, new bc(this)).create().show();
                }
            }
        } else if (view == this.byb.Wu()) {
            new AlertDialog.Builder(getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.z.alert_clear_cache).setPositiveButton(com.baidu.tieba.z.alert_yes_button, new bd(this)).setNegativeButton(com.baidu.tieba.z.alert_no_button, new be(this)).create().show();
        } else if (view == this.byb.Wv()) {
            startActivity(new Intent(getPageContext().getPageActivity(), PluginCenterActivity.class));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.byb.Ws())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.byc.setHeadsetModeOn(true);
            } else {
                this.byc.setHeadsetModeOn(false);
            }
        }
    }
}
