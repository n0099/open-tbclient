package com.baidu.tieba.plugins;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView aAq;
    private HeadImageView aEz;
    private TextView bMf;
    private TextView bMg;
    private TextView bMh;
    private TextView bMi;
    private String bMj;
    private PluginNetConfigInfos.PluginConfig bMk;
    private boolean mFinished;
    private NavigationBar mNavigationBar;
    private int mStatus;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PluginDetailActivityConfig.class, PluginDetailActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(w.navigation_bar);
        this.mNavigationBar.setTitleText(z.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        this.aEz = (HeadImageView) findViewById(w.icon);
        this.aAq = (TextView) findViewById(w.name);
        this.bMf = (TextView) findViewById(w.status);
        this.bMg = (TextView) findViewById(w.changelog);
        this.bMh = (TextView) findViewById(w.size);
        this.bMi = (TextView) findViewById(w.enable);
        this.bMi.setOnClickListener(this);
        this.bMj = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.is().it() != null) {
            this.bMk = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.is().it().getPluginConfig(this.bMj);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.bMk != null) {
            this.aEz.d(this.bMk.icon, 10, false);
            if (this.bMk.display_name == null) {
                this.bMk.display_name = "";
            }
            this.aAq.setText(this.bMk.display_name);
            ack();
            if (this.bMk.newest != null) {
                if (TextUtils.isEmpty(this.bMk.newest.change_log)) {
                    this.bMg.setText("");
                } else {
                    this.bMg.setText(this.bMk.newest.change_log);
                }
                if (this.bMk.newest.size <= 0) {
                    this.bMh.setText("");
                } else {
                    this.bMh.setText(String.valueOf(getPageContext().getString(z.plugin_size)) + String.valueOf(this.bMk.newest.size / 1024) + "KB");
                }
            }
            this.bMi.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ack() {
        if (PluginPackageManager.ic().bk(this.bMj) && PluginPackageManager.ic().bi(this.bMj)) {
            this.bMf.setText(z.plugin_enabled);
            this.bMi.setText(z.plugin_update);
            this.bMi.setEnabled(true);
            bc.b(this.bMi, t.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.ic().bi(this.bMj)) {
            this.bMi.setEnabled(true);
            bc.b(this.bMi, t.cp_cont_g, 1);
            if (PluginPackageManager.ic().bj(this.bMj)) {
                this.bMf.setText(z.plugin_unenabled);
                this.bMi.setText(z.plugin_enable);
                this.mStatus = 2;
                return;
            }
            this.bMf.setText(z.plugin_enabled);
            this.bMi.setText(z.plugin_unenable);
            this.mStatus = 3;
        } else {
            this.bMf.setText(z.plugin_disabled);
            this.bMi.setText(z.plugin_enable);
            this.bMi.setEnabled(true);
            bc.b(this.bMi, t.cp_cont_g, 1);
            this.mStatus = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bMi) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                acl();
            } else if (this.mStatus == 3) {
                PluginPackageManager.ic().bg(this.bMj);
                ack();
            } else if (this.mStatus == 2) {
                PluginPackageManager.ic().bh(this.bMj);
                ack();
            }
        }
    }

    private void acl() {
        if (!com.baidu.adp.lib.util.i.ff()) {
            showToast(z.neterror);
            return;
        }
        bc.b(this.bMi, t.cp_cont_d, 1);
        this.bMi.setEnabled(false);
        PluginPackageManager.ic().a(this.bMk, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
