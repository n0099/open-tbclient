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
    private TextView aZV;
    private HeadImageView bEc;
    private TextView cFy;
    private boolean cxZ;
    private TextView eDT;
    private TextView eDU;
    private TextView eDV;
    private PluginNetConfigInfos.PluginConfig eDW;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private com.baidu.adp.plugin.packageManager.e uV = new e(this);
    private final CustomMessageListener Dd = new f(this, 2000994);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.navigation_bar);
        this.mNavigationBar.setTitleText(u.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.bEc = (HeadImageView) findViewById(u.g.icon);
        this.cFy = (TextView) findViewById(u.g.name);
        this.aZV = (TextView) findViewById(u.g.status);
        this.eDT = (TextView) findViewById(u.g.changelog);
        this.eDU = (TextView) findViewById(u.g.size);
        this.eDV = (TextView) findViewById(u.g.enable);
        this.eDV.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ie().m5if() != null) {
            this.eDW = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ie().m5if().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.hH().br(this.mPluginName)) {
            PluginPackageManager.hH().a(this.uV);
            av.c(this.eDV, u.d.cp_cont_d, 1);
            this.eDV.setEnabled(false);
        }
        registerListener(this.Dd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eDW != null) {
            this.bEc.c(this.eDW.icon, 10, false);
            if (this.eDW.display_name == null) {
                this.eDW.display_name = "";
            }
            this.cFy.setText(this.eDW.display_name);
            aTD();
            if (this.eDW.newest != null) {
                if (TextUtils.isEmpty(this.eDW.newest.change_log)) {
                    this.eDT.setText("");
                } else {
                    this.eDT.setText(this.eDW.newest.change_log);
                }
                if (this.eDW.newest.size <= 0) {
                    this.eDU.setText("");
                } else {
                    this.eDU.setText(String.valueOf(getPageContext().getString(u.j.plugin_size)) + String.valueOf(this.eDW.newest.size / 1024) + "KB");
                }
            }
            this.eDV.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTD() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.hH().bp(this.mPluginName) && PluginPackageManager.hH().bn(this.mPluginName)) {
            this.aZV.setText(u.j.plugin_enabled);
            this.eDV.setText(u.j.plugin_update);
            this.eDV.setEnabled(true);
            av.c(this.eDV, u.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.hH().bn(this.mPluginName)) {
            this.eDV.setEnabled(true);
            av.c(this.eDV, u.d.cp_cont_g, 1);
            if (PluginPackageManager.hH().bo(this.mPluginName)) {
                this.aZV.setText(u.j.plugin_unenabled);
                this.eDV.setText(u.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.aZV.setText(u.j.plugin_enabled);
                this.eDV.setText(u.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.aZV.setText(u.j.plugin_disabled);
            this.eDV.setText(u.j.plugin_enable);
            this.eDV.setEnabled(true);
            av.c(this.eDV, u.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.hH().br(this.mPluginName)) {
            av.c(this.eDV, u.d.cp_cont_d, 1);
            this.eDV.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().w(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eDV) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                aTE();
            } else if (this.mStatus == 3) {
                PluginPackageManager.hH().bl(this.mPluginName);
                aTD();
            } else if (this.mStatus == 2) {
                PluginPackageManager.hH().bm(this.mPluginName);
                aTD();
            }
        }
    }

    private void aTE() {
        if (!com.baidu.adp.lib.util.i.fr()) {
            showToast(u.j.neterror);
        } else if (com.baidu.adp.lib.util.i.ft()) {
            aTF();
        } else {
            av.c(this.eDV, u.d.cp_cont_d, 1);
            this.eDV.setEnabled(false);
            PluginPackageManager.hH().a(this.eDW, this.uV);
        }
    }

    private void aTF() {
        String string;
        String string2;
        if (this.eDW != null && this.eDW.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.eDW.newest.size / 1048576.0f;
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
            aVar.rT();
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
        PluginPackageManager.hH().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
