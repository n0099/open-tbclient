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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView bjd;
    private boolean cGX;
    private HeadImageView eUG;
    private TextView eXB;
    private TextView eXC;
    private TextView eXD;
    private PluginNetConfigInfos.PluginConfig eXE;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private com.baidu.adp.plugin.packageManager.e Er = new e(this);
    private final CustomMessageListener mNetworkChangedMessageListener = new f(this, 2000994);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.navigation_bar);
        this.mNavigationBar.setTitleText(w.l.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.eUG = (HeadImageView) findViewById(w.h.icon);
        this.mName = (TextView) findViewById(w.h.name);
        this.bjd = (TextView) findViewById(w.h.status);
        this.eXB = (TextView) findViewById(w.h.changelog);
        this.eXC = (TextView) findViewById(w.h.size);
        this.eXD = (TextView) findViewById(w.h.enable);
        this.eXD.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jV().jW() != null) {
            this.eXE = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jV().jW().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.jy().bh(this.mPluginName)) {
            PluginPackageManager.jy().a(this.Er);
            aq.c(this.eXD, w.e.cp_cont_d, 1);
            this.eXD.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eXE != null) {
            this.eUG.c(this.eXE.icon, 10, false);
            if (this.eXE.display_name == null) {
                this.eXE.display_name = "";
            }
            this.mName.setText(this.eXE.display_name);
            aZo();
            if (this.eXE.newest != null) {
                if (TextUtils.isEmpty(this.eXE.newest.change_log)) {
                    this.eXB.setText("");
                } else {
                    this.eXB.setText(this.eXE.newest.change_log);
                }
                if (this.eXE.newest.size <= 0) {
                    this.eXC.setText("");
                } else {
                    this.eXC.setText(String.valueOf(getPageContext().getString(w.l.plugin_size)) + String.valueOf(this.eXE.newest.size / 1024) + "KB");
                }
            }
            this.eXD.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZo() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.jy().bf(this.mPluginName) && PluginPackageManager.jy().bd(this.mPluginName)) {
            this.bjd.setText(w.l.plugin_enabled);
            this.eXD.setText(w.l.download_update);
            this.eXD.setEnabled(true);
            aq.c(this.eXD, w.e.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.jy().bd(this.mPluginName)) {
            this.eXD.setEnabled(true);
            aq.c(this.eXD, w.e.cp_cont_g, 1);
            if (PluginPackageManager.jy().be(this.mPluginName)) {
                this.bjd.setText(w.l.plugin_unenabled);
                this.eXD.setText(w.l.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bjd.setText(w.l.plugin_enabled);
                this.eXD.setText(w.l.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bjd.setText(w.l.plugin_disabled);
            this.eXD.setText(w.l.plugin_enable);
            this.eXD.setEnabled(true);
            aq.c(this.eXD, w.e.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.jy().bh(this.mPluginName)) {
            aq.c(this.eXD, w.e.cp_cont_d, 1);
            this.eXD.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().aj(i == 1);
        getLayoutMode().t(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eXD) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                aZp();
            } else if (this.mStatus == 3) {
                PluginPackageManager.jy().bb(this.mPluginName);
                aZo();
            } else if (this.mStatus == 2) {
                PluginPackageManager.jy().bc(this.mPluginName);
                aZo();
            }
        }
    }

    private void aZp() {
        if (!com.baidu.adp.lib.util.i.hk()) {
            showToast(w.l.neterror);
        } else if (com.baidu.adp.lib.util.i.hm()) {
            aZq();
        } else {
            aq.c(this.eXD, w.e.cp_cont_d, 1);
            this.eXD.setEnabled(false);
            PluginPackageManager.jy().a(this.eXE, this.Er);
        }
    }

    private void aZq() {
        String string;
        String string2;
        if (this.eXE != null && this.eXE.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.eXE.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(w.l.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(w.l.download_update);
            } else {
                string = getResources().getString(w.l.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(w.l.download);
            }
            aVar.cE(string);
            aVar.a(string2, new h(this));
            aVar.b(w.l.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.tQ();
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
        PluginPackageManager.jy().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
