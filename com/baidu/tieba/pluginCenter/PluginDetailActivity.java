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
    private HeadImageView aKs;
    private TextView aXK;
    private TextView bUp;
    private TextView bUq;
    private TextView bUr;
    private TextView bUs;
    private String bUt;
    private PluginNetConfigInfos.PluginConfig bUu;
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
        this.aKs = (HeadImageView) findViewById(v.icon);
        this.aXK = (TextView) findViewById(v.name);
        this.bUp = (TextView) findViewById(v.status);
        this.bUq = (TextView) findViewById(v.changelog);
        this.bUr = (TextView) findViewById(v.size);
        this.bUs = (TextView) findViewById(v.enable);
        this.bUs.setOnClickListener(this);
        this.bUt = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lJ().lK() != null) {
            this.bUu = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lJ().lK().getPluginConfig(this.bUt);
        }
        if (PluginPackageManager.ls().bq(this.bUt)) {
            PluginPackageManager.ls().a(this.DN);
            ba.b(this.bUs, s.cp_cont_d, 1);
            this.bUs.setEnabled(false);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.bUu != null) {
            this.aKs.c(this.bUu.icon, 10, false);
            if (this.bUu.display_name == null) {
                this.bUu.display_name = "";
            }
            this.aXK.setText(this.bUu.display_name);
            aet();
            if (this.bUu.newest != null) {
                if (TextUtils.isEmpty(this.bUu.newest.change_log)) {
                    this.bUq.setText("");
                } else {
                    this.bUq.setText(this.bUu.newest.change_log);
                }
                if (this.bUu.newest.size <= 0) {
                    this.bUr.setText("");
                } else {
                    this.bUr.setText(String.valueOf(getPageContext().getString(y.plugin_size)) + String.valueOf(this.bUu.newest.size / 1024) + "KB");
                }
            }
            this.bUs.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aet() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001310));
        if (PluginPackageManager.ls().bo(this.bUt) && PluginPackageManager.ls().bm(this.bUt)) {
            this.bUp.setText(y.plugin_enabled);
            this.bUs.setText(y.plugin_update);
            this.bUs.setEnabled(true);
            ba.b(this.bUs, s.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.ls().bm(this.bUt)) {
            this.bUs.setEnabled(true);
            ba.b(this.bUs, s.cp_cont_g, 1);
            if (PluginPackageManager.ls().bn(this.bUt)) {
                this.bUp.setText(y.plugin_unenabled);
                this.bUs.setText(y.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bUp.setText(y.plugin_enabled);
                this.bUs.setText(y.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bUp.setText(y.plugin_disabled);
            this.bUs.setText(y.plugin_enable);
            this.bUs.setEnabled(true);
            ba.b(this.bUs, s.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.ls().bq(this.bUt)) {
            ba.b(this.bUs, s.cp_cont_d, 1);
            this.bUs.setEnabled(false);
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
        if (view == this.bUs) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                aeu();
            } else if (this.mStatus == 3) {
                PluginPackageManager.ls().bk(this.bUt);
                aet();
            } else if (this.mStatus == 2) {
                PluginPackageManager.ls().bl(this.bUt);
                aet();
            }
        }
    }

    private void aeu() {
        if (!com.baidu.adp.lib.util.k.iH()) {
            showToast(y.neterror);
            return;
        }
        ba.b(this.bUs, s.cp_cont_d, 1);
        this.bUs.setEnabled(false);
        PluginPackageManager.ls().a(this.bUu, this.DN);
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
