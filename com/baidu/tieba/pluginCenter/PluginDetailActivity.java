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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private boolean bFR;
    private TextView bLD;
    private HeadImageView bfy;
    private TextView dje;
    private TextView djf;
    private TextView djg;
    private TextView djh;
    private PluginNetConfigInfos.PluginConfig dji;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private com.baidu.adp.plugin.packageManager.e Eh = new e(this);
    private final CustomMessageListener mNetworkChangedMessageListener = new f(this, 2000994);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.navigation_bar);
        this.mNavigationBar.setTitleText(n.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.bfy = (HeadImageView) findViewById(n.g.icon);
        this.bLD = (TextView) findViewById(n.g.name);
        this.dje = (TextView) findViewById(n.g.status);
        this.djf = (TextView) findViewById(n.g.changelog);
        this.djg = (TextView) findViewById(n.g.size);
        this.djh = (TextView) findViewById(n.g.enable);
        this.djh.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lJ().lK() != null) {
            this.dji = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lJ().lK().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.ls().bA(this.mPluginName)) {
            PluginPackageManager.ls().a(this.Eh);
            as.b(this.djh, n.d.cp_cont_d, 1);
            this.djh.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dji != null) {
            this.bfy.d(this.dji.icon, 10, false);
            if (this.dji.display_name == null) {
                this.dji.display_name = "";
            }
            this.bLD.setText(this.dji.display_name);
            awi();
            if (this.dji.newest != null) {
                if (TextUtils.isEmpty(this.dji.newest.change_log)) {
                    this.djf.setText("");
                } else {
                    this.djf.setText(this.dji.newest.change_log);
                }
                if (this.dji.newest.size <= 0) {
                    this.djg.setText("");
                } else {
                    this.djg.setText(String.valueOf(getPageContext().getString(n.j.plugin_size)) + String.valueOf(this.dji.newest.size / 1024) + "KB");
                }
            }
            this.djh.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awi() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.ls().by(this.mPluginName) && PluginPackageManager.ls().bw(this.mPluginName)) {
            this.dje.setText(n.j.plugin_enabled);
            this.djh.setText(n.j.plugin_update);
            this.djh.setEnabled(true);
            as.b(this.djh, n.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.ls().bw(this.mPluginName)) {
            this.djh.setEnabled(true);
            as.b(this.djh, n.d.cp_cont_g, 1);
            if (PluginPackageManager.ls().bx(this.mPluginName)) {
                this.dje.setText(n.j.plugin_unenabled);
                this.djh.setText(n.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.dje.setText(n.j.plugin_enabled);
                this.djh.setText(n.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.dje.setText(n.j.plugin_disabled);
            this.djh.setText(n.j.plugin_enable);
            this.djh.setEnabled(true);
            as.b(this.djh, n.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.ls().bA(this.mPluginName)) {
            as.b(this.djh, n.d.cp_cont_d, 1);
            this.djh.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().k(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.djh) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                awj();
            } else if (this.mStatus == 3) {
                PluginPackageManager.ls().bu(this.mPluginName);
                awi();
            } else if (this.mStatus == 2) {
                PluginPackageManager.ls().bv(this.mPluginName);
                awi();
            }
        }
    }

    private void awj() {
        if (!com.baidu.adp.lib.util.i.iQ()) {
            showToast(n.j.neterror);
        } else if (com.baidu.adp.lib.util.i.iS()) {
            awk();
        } else {
            as.b(this.djh, n.d.cp_cont_d, 1);
            this.djh.setEnabled(false);
            PluginPackageManager.ls().a(this.dji, this.Eh);
        }
    }

    private void awk() {
        String string;
        String string2;
        if (this.dji != null && this.dji.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.dji.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(n.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(n.j.download_update);
            } else {
                string = getResources().getString(n.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(n.j.download);
            }
            aVar.cF(string);
            aVar.a(string2, new h(this));
            aVar.b(n.j.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.tf();
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
