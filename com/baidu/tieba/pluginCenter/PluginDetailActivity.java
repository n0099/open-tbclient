package com.baidu.tieba.pluginCenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private com.baidu.adp.plugin.packageManager.i DE = new e(this);
    private HeadImageView aMJ;
    private TextView bXj;
    private TextView bXk;
    private TextView bXl;
    private TextView bXm;
    private String bXn;
    private PluginNetConfigInfos.PluginConfig bXo;
    private TextView baH;
    private boolean mFinished;
    private NavigationBar mNavigationBar;
    private int mStatus;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(q.navigation_bar);
        this.mNavigationBar.setTitleText(t.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        this.aMJ = (HeadImageView) findViewById(q.icon);
        this.baH = (TextView) findViewById(q.name);
        this.bXj = (TextView) findViewById(q.status);
        this.bXk = (TextView) findViewById(q.changelog);
        this.bXl = (TextView) findViewById(q.size);
        this.bXm = (TextView) findViewById(q.enable);
        this.bXm.setOnClickListener(this);
        this.bXn = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mc().md() != null) {
            this.bXo = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mc().md().getPluginConfig(this.bXn);
        }
        if (PluginPackageManager.lM().bA(this.bXn)) {
            PluginPackageManager.lM().a(this.DE);
            ay.b(this.bXm, com.baidu.tieba.n.cp_cont_d, 1);
            this.bXm.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bXo != null) {
            this.aMJ.c(this.bXo.icon, 10, false);
            if (this.bXo.display_name == null) {
                this.bXo.display_name = "";
            }
            this.baH.setText(this.bXo.display_name);
            afO();
            if (this.bXo.newest != null) {
                if (TextUtils.isEmpty(this.bXo.newest.change_log)) {
                    this.bXk.setText("");
                } else {
                    this.bXk.setText(this.bXo.newest.change_log);
                }
                if (this.bXo.newest.size <= 0) {
                    this.bXl.setText("");
                } else {
                    this.bXl.setText(String.valueOf(getPageContext().getString(t.plugin_size)) + String.valueOf(this.bXo.newest.size / 1024) + "KB");
                }
            }
            this.bXm.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afO() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001310));
        if (PluginPackageManager.lM().by(this.bXn) && PluginPackageManager.lM().bw(this.bXn)) {
            this.bXj.setText(t.plugin_enabled);
            this.bXm.setText(t.plugin_update);
            this.bXm.setEnabled(true);
            ay.b(this.bXm, com.baidu.tieba.n.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.lM().bw(this.bXn)) {
            this.bXm.setEnabled(true);
            ay.b(this.bXm, com.baidu.tieba.n.cp_cont_g, 1);
            if (PluginPackageManager.lM().bx(this.bXn)) {
                this.bXj.setText(t.plugin_unenabled);
                this.bXm.setText(t.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bXj.setText(t.plugin_enabled);
                this.bXm.setText(t.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bXj.setText(t.plugin_disabled);
            this.bXm.setText(t.plugin_enable);
            this.bXm.setEnabled(true);
            ay.b(this.bXm, com.baidu.tieba.n.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.lM().bA(this.bXn)) {
            ay.b(this.bXm, com.baidu.tieba.n.cp_cont_d, 1);
            this.bXm.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bXm) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                afP();
            } else if (this.mStatus == 3) {
                PluginPackageManager.lM().bu(this.bXn);
                afO();
            } else if (this.mStatus == 2) {
                PluginPackageManager.lM().bv(this.bXn);
                afO();
            }
        }
    }

    private void afP() {
        if (!com.baidu.adp.lib.util.k.iX()) {
            showToast(t.neterror);
            return;
        }
        ay.b(this.bXm, com.baidu.tieba.n.cp_cont_d, 1);
        this.bXm.setEnabled(false);
        PluginPackageManager.lM().a(this.bXo, this.DE);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PluginPackageManager.lM().a((com.baidu.adp.plugin.packageManager.i) null);
    }
}
