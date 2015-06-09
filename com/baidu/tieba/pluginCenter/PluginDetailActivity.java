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
    private HeadImageView aMK;
    private TextView bXk;
    private TextView bXl;
    private TextView bXm;
    private TextView bXn;
    private String bXo;
    private PluginNetConfigInfos.PluginConfig bXp;
    private TextView baI;
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
        this.aMK = (HeadImageView) findViewById(q.icon);
        this.baI = (TextView) findViewById(q.name);
        this.bXk = (TextView) findViewById(q.status);
        this.bXl = (TextView) findViewById(q.changelog);
        this.bXm = (TextView) findViewById(q.size);
        this.bXn = (TextView) findViewById(q.enable);
        this.bXn.setOnClickListener(this);
        this.bXo = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mc().md() != null) {
            this.bXp = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mc().md().getPluginConfig(this.bXo);
        }
        if (PluginPackageManager.lM().bA(this.bXo)) {
            PluginPackageManager.lM().a(this.DE);
            ay.b(this.bXn, com.baidu.tieba.n.cp_cont_d, 1);
            this.bXn.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bXp != null) {
            this.aMK.c(this.bXp.icon, 10, false);
            if (this.bXp.display_name == null) {
                this.bXp.display_name = "";
            }
            this.baI.setText(this.bXp.display_name);
            afP();
            if (this.bXp.newest != null) {
                if (TextUtils.isEmpty(this.bXp.newest.change_log)) {
                    this.bXl.setText("");
                } else {
                    this.bXl.setText(this.bXp.newest.change_log);
                }
                if (this.bXp.newest.size <= 0) {
                    this.bXm.setText("");
                } else {
                    this.bXm.setText(String.valueOf(getPageContext().getString(t.plugin_size)) + String.valueOf(this.bXp.newest.size / 1024) + "KB");
                }
            }
            this.bXn.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afP() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001310));
        if (PluginPackageManager.lM().by(this.bXo) && PluginPackageManager.lM().bw(this.bXo)) {
            this.bXk.setText(t.plugin_enabled);
            this.bXn.setText(t.plugin_update);
            this.bXn.setEnabled(true);
            ay.b(this.bXn, com.baidu.tieba.n.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.lM().bw(this.bXo)) {
            this.bXn.setEnabled(true);
            ay.b(this.bXn, com.baidu.tieba.n.cp_cont_g, 1);
            if (PluginPackageManager.lM().bx(this.bXo)) {
                this.bXk.setText(t.plugin_unenabled);
                this.bXn.setText(t.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bXk.setText(t.plugin_enabled);
                this.bXn.setText(t.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bXk.setText(t.plugin_disabled);
            this.bXn.setText(t.plugin_enable);
            this.bXn.setEnabled(true);
            ay.b(this.bXn, com.baidu.tieba.n.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.lM().bA(this.bXo)) {
            ay.b(this.bXn, com.baidu.tieba.n.cp_cont_d, 1);
            this.bXn.setEnabled(false);
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
        if (view == this.bXn) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                afQ();
            } else if (this.mStatus == 3) {
                PluginPackageManager.lM().bu(this.bXo);
                afP();
            } else if (this.mStatus == 2) {
                PluginPackageManager.lM().bv(this.bXo);
                afP();
            }
        }
    }

    private void afQ() {
        if (!com.baidu.adp.lib.util.k.iX()) {
            showToast(t.neterror);
            return;
        }
        ay.b(this.bXn, com.baidu.tieba.n.cp_cont_d, 1);
        this.bXn.setEnabled(false);
        PluginPackageManager.lM().a(this.bXp, this.DE);
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
