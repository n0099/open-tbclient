package com.baidu.tieba.pluginCenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView cGh;
    private boolean cxH;
    private HeadImageView eGS;
    private TextView eKh;
    private TextView eKi;
    private TextView eKj;
    private TextView eKk;
    private PluginNetConfigInfos.PluginConfig eKl;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private com.baidu.adp.plugin.packageManager.e xI = new e(this);
    private final CustomMessageListener FT = new f(this, 2000994);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.navigation_bar);
        this.mNavigationBar.setTitleText(r.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.eGS = (HeadImageView) findViewById(r.g.icon);
        this.cGh = (TextView) findViewById(r.g.name);
        this.eKh = (TextView) findViewById(r.g.status);
        this.eKi = (TextView) findViewById(r.g.changelog);
        this.eKj = (TextView) findViewById(r.g.size);
        this.eKk = (TextView) findViewById(r.g.enable);
        this.eKk.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.iY().iZ() != null) {
            this.eKl = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.iY().iZ().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.iB().bt(this.mPluginName)) {
            PluginPackageManager.iB().a(this.xI);
            ar.c(this.eKk, r.d.cp_cont_d, 1);
            this.eKk.setEnabled(false);
        }
        registerListener(this.FT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eKl != null) {
            this.eGS.c(this.eKl.icon, 10, false);
            if (this.eKl.display_name == null) {
                this.eKl.display_name = "";
            }
            this.cGh.setText(this.eKl.display_name);
            aWL();
            if (this.eKl.newest != null) {
                if (TextUtils.isEmpty(this.eKl.newest.change_log)) {
                    this.eKi.setText("");
                } else {
                    this.eKi.setText(this.eKl.newest.change_log);
                }
                if (this.eKl.newest.size <= 0) {
                    this.eKj.setText("");
                } else {
                    this.eKj.setText(String.valueOf(getPageContext().getString(r.j.plugin_size)) + String.valueOf(this.eKl.newest.size / 1024) + "KB");
                }
            }
            this.eKk.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWL() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.iB().br(this.mPluginName) && PluginPackageManager.iB().bp(this.mPluginName)) {
            this.eKh.setText(r.j.plugin_enabled);
            this.eKk.setText(r.j.plugin_update);
            this.eKk.setEnabled(true);
            ar.c(this.eKk, r.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.iB().bp(this.mPluginName)) {
            this.eKk.setEnabled(true);
            ar.c(this.eKk, r.d.cp_cont_g, 1);
            if (PluginPackageManager.iB().bq(this.mPluginName)) {
                this.eKh.setText(r.j.plugin_unenabled);
                this.eKk.setText(r.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.eKh.setText(r.j.plugin_enabled);
                this.eKk.setText(r.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.eKh.setText(r.j.plugin_disabled);
            this.eKk.setText(r.j.plugin_enable);
            this.eKk.setEnabled(true);
            ar.c(this.eKk, r.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.iB().bt(this.mPluginName)) {
            ar.c(this.eKk, r.d.cp_cont_d, 1);
            this.eKk.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().x(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eKk) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                aWM();
            } else if (this.mStatus == 3) {
                PluginPackageManager.iB().bn(this.mPluginName);
                aWL();
            } else if (this.mStatus == 2) {
                PluginPackageManager.iB().bo(this.mPluginName);
                aWL();
            }
        }
    }

    private void aWM() {
        if (!com.baidu.adp.lib.util.i.gm()) {
            showToast(r.j.neterror);
        } else if (com.baidu.adp.lib.util.i.go()) {
            aWN();
        } else {
            ar.c(this.eKk, r.d.cp_cont_d, 1);
            this.eKk.setEnabled(false);
            PluginPackageManager.iB().a(this.eKl, this.xI);
        }
    }

    private void aWN() {
        String string;
        String string2;
        if (this.eKl != null && this.eKl.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.eKl.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(r.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(r.j.download_update);
            } else {
                string = getResources().getString(r.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(r.j.download);
            }
            aVar.cG(string);
            aVar.a(string2, new h(this));
            aVar.b(r.j.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.tb();
        }
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
        PluginPackageManager.iB().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
