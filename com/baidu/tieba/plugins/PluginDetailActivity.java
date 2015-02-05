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
    private TextView aAn;
    private HeadImageView aEw;
    private TextView bMe;
    private TextView bMf;
    private TextView bMg;
    private TextView bMh;
    private String bMi;
    private PluginNetConfigInfos.PluginConfig bMj;
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
        this.aEw = (HeadImageView) findViewById(w.icon);
        this.aAn = (TextView) findViewById(w.name);
        this.bMe = (TextView) findViewById(w.status);
        this.bMf = (TextView) findViewById(w.changelog);
        this.bMg = (TextView) findViewById(w.size);
        this.bMh = (TextView) findViewById(w.enable);
        this.bMh.setOnClickListener(this);
        this.bMi = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.il().im() != null) {
            this.bMj = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.il().im().getPluginConfig(this.bMi);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.bMj != null) {
            this.aEw.d(this.bMj.icon, 10, false);
            if (this.bMj.display_name == null) {
                this.bMj.display_name = "";
            }
            this.aAn.setText(this.bMj.display_name);
            acf();
            if (this.bMj.newest != null) {
                if (TextUtils.isEmpty(this.bMj.newest.change_log)) {
                    this.bMf.setText("");
                } else {
                    this.bMf.setText(this.bMj.newest.change_log);
                }
                if (this.bMj.newest.size <= 0) {
                    this.bMg.setText("");
                } else {
                    this.bMg.setText(String.valueOf(getPageContext().getString(z.plugin_size)) + String.valueOf(this.bMj.newest.size / 1024) + "KB");
                }
            }
            this.bMh.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acf() {
        if (PluginPackageManager.hV().bh(this.bMi) && PluginPackageManager.hV().bf(this.bMi)) {
            this.bMe.setText(z.plugin_enabled);
            this.bMh.setText(z.plugin_update);
            this.bMh.setEnabled(true);
            bc.b(this.bMh, t.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.hV().bf(this.bMi)) {
            this.bMh.setEnabled(true);
            bc.b(this.bMh, t.cp_cont_g, 1);
            if (PluginPackageManager.hV().bg(this.bMi)) {
                this.bMe.setText(z.plugin_unenabled);
                this.bMh.setText(z.plugin_enable);
                this.mStatus = 2;
                return;
            }
            this.bMe.setText(z.plugin_enabled);
            this.bMh.setText(z.plugin_unenable);
            this.mStatus = 3;
        } else {
            this.bMe.setText(z.plugin_disabled);
            this.bMh.setText(z.plugin_enable);
            this.bMh.setEnabled(true);
            bc.b(this.bMh, t.cp_cont_g, 1);
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
        if (view == this.bMh) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                acg();
            } else if (this.mStatus == 3) {
                PluginPackageManager.hV().bd(this.bMi);
                acf();
            } else if (this.mStatus == 2) {
                PluginPackageManager.hV().be(this.bMi);
                acf();
            }
        }
    }

    private void acg() {
        if (!com.baidu.adp.lib.util.i.ff()) {
            showToast(z.neterror);
            return;
        }
        bc.b(this.bMh, t.cp_cont_d, 1);
        this.bMh.setEnabled(false);
        PluginPackageManager.hV().a(this.bMj, new d(this));
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
