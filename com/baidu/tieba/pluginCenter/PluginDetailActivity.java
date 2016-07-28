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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private HeadImageView bFm;
    private TextView baU;
    private boolean cAO;
    private TextView cIn;
    private TextView ePC;
    private TextView ePD;
    private TextView ePE;
    private PluginNetConfigInfos.PluginConfig ePF;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private com.baidu.adp.plugin.packageManager.e vw = new e(this);
    private final CustomMessageListener DE = new f(this, 2000994);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.navigation_bar);
        this.mNavigationBar.setTitleText(u.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.bFm = (HeadImageView) findViewById(u.g.icon);
        this.cIn = (TextView) findViewById(u.g.name);
        this.baU = (TextView) findViewById(u.g.status);
        this.ePC = (TextView) findViewById(u.g.changelog);
        this.ePD = (TextView) findViewById(u.g.size);
        this.ePE = (TextView) findViewById(u.g.enable);
        this.ePE.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.id().ie() != null) {
            this.ePF = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.id().ie().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.hG().bs(this.mPluginName)) {
            PluginPackageManager.hG().a(this.vw);
            av.c(this.ePE, u.d.cp_cont_d, 1);
            this.ePE.setEnabled(false);
        }
        registerListener(this.DE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.ePF != null) {
            this.bFm.c(this.ePF.icon, 10, false);
            if (this.ePF.display_name == null) {
                this.ePF.display_name = "";
            }
            this.cIn.setText(this.ePF.display_name);
            aWG();
            if (this.ePF.newest != null) {
                if (TextUtils.isEmpty(this.ePF.newest.change_log)) {
                    this.ePC.setText("");
                } else {
                    this.ePC.setText(this.ePF.newest.change_log);
                }
                if (this.ePF.newest.size <= 0) {
                    this.ePD.setText("");
                } else {
                    this.ePD.setText(String.valueOf(getPageContext().getString(u.j.plugin_size)) + String.valueOf(this.ePF.newest.size / 1024) + "KB");
                }
            }
            this.ePE.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWG() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.hG().bq(this.mPluginName) && PluginPackageManager.hG().bo(this.mPluginName)) {
            this.baU.setText(u.j.plugin_enabled);
            this.ePE.setText(u.j.plugin_update);
            this.ePE.setEnabled(true);
            av.c(this.ePE, u.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.hG().bo(this.mPluginName)) {
            this.ePE.setEnabled(true);
            av.c(this.ePE, u.d.cp_cont_g, 1);
            if (PluginPackageManager.hG().bp(this.mPluginName)) {
                this.baU.setText(u.j.plugin_unenabled);
                this.ePE.setText(u.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.baU.setText(u.j.plugin_enabled);
                this.ePE.setText(u.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.baU.setText(u.j.plugin_disabled);
            this.ePE.setText(u.j.plugin_enable);
            this.ePE.setEnabled(true);
            av.c(this.ePE, u.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.hG().bs(this.mPluginName)) {
            av.c(this.ePE, u.d.cp_cont_d, 1);
            this.ePE.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().af(i == 1);
        getLayoutMode().w(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ePE) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                aWH();
            } else if (this.mStatus == 3) {
                PluginPackageManager.hG().bm(this.mPluginName);
                aWG();
            } else if (this.mStatus == 2) {
                PluginPackageManager.hG().bn(this.mPluginName);
                aWG();
            }
        }
    }

    private void aWH() {
        if (!com.baidu.adp.lib.util.i.fq()) {
            showToast(u.j.neterror);
        } else if (com.baidu.adp.lib.util.i.fs()) {
            aWI();
        } else {
            av.c(this.ePE, u.d.cp_cont_d, 1);
            this.ePE.setEnabled(false);
            PluginPackageManager.hG().a(this.ePF, this.vw);
        }
    }

    private void aWI() {
        String string;
        String string2;
        if (this.ePF != null && this.ePF.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.ePF.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(u.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(u.j.download_update);
            } else {
                string = getResources().getString(u.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(u.j.download);
            }
            aVar.cz(string);
            aVar.a(string2, new h(this));
            aVar.b(u.j.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.rS();
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
        PluginPackageManager.hG().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
