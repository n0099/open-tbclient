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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private com.baidu.adp.plugin.packageManager.i DN = new c(this);
    private HeadImageView aKC;
    private TextView aYa;
    private TextView bUF;
    private TextView bUG;
    private TextView bUH;
    private TextView bUI;
    private String bUJ;
    private PluginNetConfigInfos.PluginConfig bUK;
    private boolean mFinished;
    private NavigationBar mNavigationBar;
    private int mStatus;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(v.navigation_bar);
        this.mNavigationBar.setTitleText(y.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.aKC = (HeadImageView) findViewById(v.icon);
        this.aYa = (TextView) findViewById(v.name);
        this.bUF = (TextView) findViewById(v.status);
        this.bUG = (TextView) findViewById(v.changelog);
        this.bUH = (TextView) findViewById(v.size);
        this.bUI = (TextView) findViewById(v.enable);
        this.bUI.setOnClickListener(this);
        this.bUJ = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lJ().lK() != null) {
            this.bUK = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lJ().lK().getPluginConfig(this.bUJ);
        }
        if (PluginPackageManager.ls().bq(this.bUJ)) {
            PluginPackageManager.ls().a(this.DN);
            ba.b(this.bUI, s.cp_cont_d, 1);
            this.bUI.setEnabled(false);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.bUK != null) {
            this.aKC.c(this.bUK.icon, 10, false);
            if (this.bUK.display_name == null) {
                this.bUK.display_name = "";
            }
            this.aYa.setText(this.bUK.display_name);
            aeI();
            if (this.bUK.newest != null) {
                if (TextUtils.isEmpty(this.bUK.newest.change_log)) {
                    this.bUG.setText("");
                } else {
                    this.bUG.setText(this.bUK.newest.change_log);
                }
                if (this.bUK.newest.size <= 0) {
                    this.bUH.setText("");
                } else {
                    this.bUH.setText(String.valueOf(getPageContext().getString(y.plugin_size)) + String.valueOf(this.bUK.newest.size / 1024) + "KB");
                }
            }
            this.bUI.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeI() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001310));
        if (PluginPackageManager.ls().bo(this.bUJ) && PluginPackageManager.ls().bm(this.bUJ)) {
            this.bUF.setText(y.plugin_enabled);
            this.bUI.setText(y.plugin_update);
            this.bUI.setEnabled(true);
            ba.b(this.bUI, s.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.ls().bm(this.bUJ)) {
            this.bUI.setEnabled(true);
            ba.b(this.bUI, s.cp_cont_g, 1);
            if (PluginPackageManager.ls().bn(this.bUJ)) {
                this.bUF.setText(y.plugin_unenabled);
                this.bUI.setText(y.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bUF.setText(y.plugin_enabled);
                this.bUI.setText(y.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bUF.setText(y.plugin_disabled);
            this.bUI.setText(y.plugin_enable);
            this.bUI.setEnabled(true);
            ba.b(this.bUI, s.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.ls().bq(this.bUJ)) {
            ba.b(this.bUI, s.cp_cont_d, 1);
            this.bUI.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bUI) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                aeJ();
            } else if (this.mStatus == 3) {
                PluginPackageManager.ls().bk(this.bUJ);
                aeI();
            } else if (this.mStatus == 2) {
                PluginPackageManager.ls().bl(this.bUJ);
                aeI();
            }
        }
    }

    private void aeJ() {
        if (!com.baidu.adp.lib.util.k.iH()) {
            showToast(y.neterror);
            return;
        }
        ba.b(this.bUI, s.cp_cont_d, 1);
        this.bUI.setEnabled(false);
        PluginPackageManager.ls().a(this.bUK, this.DN);
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
        PluginPackageManager.ls().a((com.baidu.adp.plugin.packageManager.i) null);
    }
}
