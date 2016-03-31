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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private com.baidu.adp.plugin.packageManager.e EA = new e(this);
    private final CustomMessageListener ML = new f(this, 2000994);
    private boolean bTx;
    private TextView bZJ;
    private HeadImageView bmQ;
    private TextView dRF;
    private TextView dRG;
    private TextView dRH;
    private TextView dRI;
    private PluginNetConfigInfos.PluginConfig dRJ;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.navigation_bar);
        this.mNavigationBar.setTitleText(t.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.bmQ = (HeadImageView) findViewById(t.g.icon);
        this.bZJ = (TextView) findViewById(t.g.name);
        this.dRF = (TextView) findViewById(t.g.status);
        this.dRG = (TextView) findViewById(t.g.changelog);
        this.dRH = (TextView) findViewById(t.g.size);
        this.dRI = (TextView) findViewById(t.g.enable);
        this.dRI.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lO().lP() != null) {
            this.dRJ = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lO().lP().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.ls().by(this.mPluginName)) {
            PluginPackageManager.ls().a(this.EA);
            at.b(this.dRI, t.d.cp_cont_d, 1);
            this.dRI.setEnabled(false);
        }
        registerListener(this.ML);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dRJ != null) {
            this.bmQ.c(this.dRJ.icon, 10, false);
            if (this.dRJ.display_name == null) {
                this.dRJ.display_name = "";
            }
            this.bZJ.setText(this.dRJ.display_name);
            aKr();
            if (this.dRJ.newest != null) {
                if (TextUtils.isEmpty(this.dRJ.newest.change_log)) {
                    this.dRG.setText("");
                } else {
                    this.dRG.setText(this.dRJ.newest.change_log);
                }
                if (this.dRJ.newest.size <= 0) {
                    this.dRH.setText("");
                } else {
                    this.dRH.setText(String.valueOf(getPageContext().getString(t.j.plugin_size)) + String.valueOf(this.dRJ.newest.size / 1024) + "KB");
                }
            }
            this.dRI.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.ls().bw(this.mPluginName) && PluginPackageManager.ls().bu(this.mPluginName)) {
            this.dRF.setText(t.j.plugin_enabled);
            this.dRI.setText(t.j.plugin_update);
            this.dRI.setEnabled(true);
            at.b(this.dRI, t.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.ls().bu(this.mPluginName)) {
            this.dRI.setEnabled(true);
            at.b(this.dRI, t.d.cp_cont_g, 1);
            if (PluginPackageManager.ls().bv(this.mPluginName)) {
                this.dRF.setText(t.j.plugin_unenabled);
                this.dRI.setText(t.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.dRF.setText(t.j.plugin_enabled);
                this.dRI.setText(t.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.dRF.setText(t.j.plugin_disabled);
            this.dRI.setText(t.j.plugin_enable);
            this.dRI.setEnabled(true);
            at.b(this.dRI, t.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.ls().by(this.mPluginName)) {
            at.b(this.dRI, t.d.cp_cont_d, 1);
            this.dRI.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dRI) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                aKs();
            } else if (this.mStatus == 3) {
                PluginPackageManager.ls().bs(this.mPluginName);
                aKr();
            } else if (this.mStatus == 2) {
                PluginPackageManager.ls().bt(this.mPluginName);
                aKr();
            }
        }
    }

    private void aKs() {
        if (!com.baidu.adp.lib.util.i.jf()) {
            showToast(t.j.neterror);
        } else if (com.baidu.adp.lib.util.i.jh()) {
            aKt();
        } else {
            at.b(this.dRI, t.d.cp_cont_d, 1);
            this.dRI.setEnabled(false);
            PluginPackageManager.ls().a(this.dRJ, this.EA);
        }
    }

    private void aKt() {
        String string;
        String string2;
        if (this.dRJ != null && this.dRJ.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.dRJ.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(t.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(t.j.download_update);
            } else {
                string = getResources().getString(t.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(t.j.download);
            }
            aVar.cC(string);
            aVar.a(string2, new h(this));
            aVar.b(t.j.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.up();
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
        PluginPackageManager.ls().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
