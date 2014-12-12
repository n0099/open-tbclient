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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private HeadImageView aDy;
    private TextView azp;
    private TextView bKu;
    private TextView bKv;
    private TextView bKw;
    private TextView bKx;
    private String bKy;
    private PluginNetConfigInfos.PluginConfig bKz;
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
        this.aDy = (HeadImageView) findViewById(w.icon);
        this.azp = (TextView) findViewById(w.name);
        this.bKu = (TextView) findViewById(w.status);
        this.bKv = (TextView) findViewById(w.changelog);
        this.bKw = (TextView) findViewById(w.size);
        this.bKx = (TextView) findViewById(w.enable);
        this.bKx.setOnClickListener(this);
        this.bKy = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.is().it() != null) {
            this.bKz = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.is().it().getPluginConfig(this.bKy);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.bKz != null) {
            this.aDy.d(this.bKz.icon, 10, false);
            if (this.bKz.display_name == null) {
                this.bKz.display_name = "";
            }
            this.azp.setText(this.bKz.display_name);
            abG();
            if (this.bKz.newest != null) {
                if (TextUtils.isEmpty(this.bKz.newest.change_log)) {
                    this.bKv.setText("");
                } else {
                    this.bKv.setText(this.bKz.newest.change_log);
                }
                if (this.bKz.newest.size <= 0) {
                    this.bKw.setText("");
                } else {
                    this.bKw.setText(String.valueOf(getPageContext().getString(z.plugin_size)) + String.valueOf(this.bKz.newest.size / 1024) + "KB");
                }
            }
            this.bKx.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abG() {
        if (PluginPackageManager.ic().bk(this.bKy) && PluginPackageManager.ic().bi(this.bKy)) {
            this.bKu.setText(z.plugin_enabled);
            this.bKx.setText(z.plugin_update);
            this.bKx.setEnabled(true);
            ax.b(this.bKx, t.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.ic().bi(this.bKy)) {
            this.bKx.setEnabled(true);
            ax.b(this.bKx, t.cp_cont_g, 1);
            if (PluginPackageManager.ic().bj(this.bKy)) {
                this.bKu.setText(z.plugin_unenabled);
                this.bKx.setText(z.plugin_enable);
                this.mStatus = 2;
                return;
            }
            this.bKu.setText(z.plugin_enabled);
            this.bKx.setText(z.plugin_unenable);
            this.mStatus = 3;
        } else {
            this.bKu.setText(z.plugin_disabled);
            this.bKx.setText(z.plugin_enable);
            this.bKx.setEnabled(true);
            ax.b(this.bKx, t.cp_cont_g, 1);
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
        if (view == this.bKx) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                abH();
            } else if (this.mStatus == 3) {
                PluginPackageManager.ic().bg(this.bKy);
                abG();
            } else if (this.mStatus == 2) {
                PluginPackageManager.ic().bh(this.bKy);
                abG();
            }
        }
    }

    private void abH() {
        if (!com.baidu.adp.lib.util.i.fg()) {
            showToast(z.neterror);
            return;
        }
        ax.b(this.bKx, t.cp_cont_d, 1);
        this.bKx.setEnabled(false);
        PluginPackageManager.ic().a(this.bKz, new d(this));
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
