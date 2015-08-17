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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private com.baidu.adp.plugin.packageManager.d DA = new e(this);
    private HeadImageView aWa;
    private TextView boD;
    private TextView cod;
    private TextView coe;
    private TextView cof;
    private TextView cog;
    private PluginNetConfigInfos.PluginConfig coh;
    private boolean coi;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.navigation_bar);
        this.mNavigationBar.setTitleText(i.C0057i.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        this.aWa = (HeadImageView) findViewById(i.f.icon);
        this.boD = (TextView) findViewById(i.f.name);
        this.cod = (TextView) findViewById(i.f.status);
        this.coe = (TextView) findViewById(i.f.changelog);
        this.cof = (TextView) findViewById(i.f.size);
        this.cog = (TextView) findViewById(i.f.enable);
        this.cog.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk() != null) {
            this.coh = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.lT().bu(this.mPluginName)) {
            PluginPackageManager.lT().a(this.DA);
            al.b(this.cog, i.c.cp_cont_d, 1);
            this.cog.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.coh != null) {
            this.aWa.d(this.coh.icon, 10, false);
            if (this.coh.display_name == null) {
                this.coh.display_name = "";
            }
            this.boD.setText(this.coh.display_name);
            ahM();
            if (this.coh.newest != null) {
                if (TextUtils.isEmpty(this.coh.newest.change_log)) {
                    this.coe.setText("");
                } else {
                    this.coe.setText(this.coh.newest.change_log);
                }
                if (this.coh.newest.size <= 0) {
                    this.cof.setText("");
                } else {
                    this.cof.setText(String.valueOf(getPageContext().getString(i.C0057i.plugin_size)) + String.valueOf(this.coh.newest.size / 1024) + "KB");
                }
            }
            this.cog.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahM() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.lT().bs(this.mPluginName) && PluginPackageManager.lT().bq(this.mPluginName)) {
            this.cod.setText(i.C0057i.plugin_enabled);
            this.cog.setText(i.C0057i.plugin_update);
            this.cog.setEnabled(true);
            al.b(this.cog, i.c.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.lT().bq(this.mPluginName)) {
            this.cog.setEnabled(true);
            al.b(this.cog, i.c.cp_cont_g, 1);
            if (PluginPackageManager.lT().br(this.mPluginName)) {
                this.cod.setText(i.C0057i.plugin_unenabled);
                this.cog.setText(i.C0057i.plugin_enable);
                this.mStatus = 2;
            } else {
                this.cod.setText(i.C0057i.plugin_enabled);
                this.cog.setText(i.C0057i.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.cod.setText(i.C0057i.plugin_disabled);
            this.cog.setText(i.C0057i.plugin_enable);
            this.cog.setEnabled(true);
            al.b(this.cog, i.c.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.lT().bu(this.mPluginName)) {
            al.b(this.cog, i.c.cp_cont_d, 1);
            this.cog.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cog) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                ahN();
            } else if (this.mStatus == 3) {
                PluginPackageManager.lT().bo(this.mPluginName);
                ahM();
            } else if (this.mStatus == 2) {
                PluginPackageManager.lT().bp(this.mPluginName);
                ahM();
            }
        }
    }

    private void ahN() {
        if (!com.baidu.adp.lib.util.i.iO()) {
            showToast(i.C0057i.neterror);
        } else if (com.baidu.adp.lib.util.i.iQ()) {
            ahO();
        } else {
            al.b(this.cog, i.c.cp_cont_d, 1);
            this.cog.setEnabled(false);
            PluginPackageManager.lT().a(this.coh, this.DA);
        }
    }

    private void ahO() {
        String string;
        String string2;
        if (this.coh != null && this.coh.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.coh.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(i.C0057i.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(i.C0057i.download_update);
            } else {
                string = getResources().getString(i.C0057i.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(i.C0057i.download);
            }
            aVar.cn(string);
            aVar.a(string2, new g(this));
            aVar.b(i.C0057i.cancel, new h(this));
            aVar.b(getPageContext());
            aVar.sP();
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
        PluginPackageManager.lT().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
