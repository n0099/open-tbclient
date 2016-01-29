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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private com.baidu.adp.plugin.packageManager.e Ev = new e(this);
    private final CustomMessageListener MF = new f(this, 2000994);
    private boolean bJb;
    private TextView bPr;
    private HeadImageView bie;
    private TextView dwY;
    private TextView dwZ;
    private TextView dxa;
    private TextView dxb;
    private PluginNetConfigInfos.PluginConfig dxc;
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
        this.bie = (HeadImageView) findViewById(t.g.icon);
        this.bPr = (TextView) findViewById(t.g.name);
        this.dwY = (TextView) findViewById(t.g.status);
        this.dwZ = (TextView) findViewById(t.g.changelog);
        this.dxa = (TextView) findViewById(t.g.size);
        this.dxb = (TextView) findViewById(t.g.enable);
        this.dxb.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lW().lX() != null) {
            this.dxc = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lW().lX().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.lD().bA(this.mPluginName)) {
            PluginPackageManager.lD().a(this.Ev);
            ar.b(this.dxb, t.d.cp_cont_d, 1);
            this.dxb.setEnabled(false);
        }
        registerListener(this.MF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dxc != null) {
            this.bie.d(this.dxc.icon, 10, false);
            if (this.dxc.display_name == null) {
                this.dxc.display_name = "";
            }
            this.bPr.setText(this.dxc.display_name);
            aCD();
            if (this.dxc.newest != null) {
                if (TextUtils.isEmpty(this.dxc.newest.change_log)) {
                    this.dwZ.setText("");
                } else {
                    this.dwZ.setText(this.dxc.newest.change_log);
                }
                if (this.dxc.newest.size <= 0) {
                    this.dxa.setText("");
                } else {
                    this.dxa.setText(String.valueOf(getPageContext().getString(t.j.plugin_size)) + String.valueOf(this.dxc.newest.size / 1024) + "KB");
                }
            }
            this.dxb.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCD() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.lD().by(this.mPluginName) && PluginPackageManager.lD().bw(this.mPluginName)) {
            this.dwY.setText(t.j.plugin_enabled);
            this.dxb.setText(t.j.plugin_update);
            this.dxb.setEnabled(true);
            ar.b(this.dxb, t.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.lD().bw(this.mPluginName)) {
            this.dxb.setEnabled(true);
            ar.b(this.dxb, t.d.cp_cont_g, 1);
            if (PluginPackageManager.lD().bx(this.mPluginName)) {
                this.dwY.setText(t.j.plugin_unenabled);
                this.dxb.setText(t.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.dwY.setText(t.j.plugin_enabled);
                this.dxb.setText(t.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.dwY.setText(t.j.plugin_disabled);
            this.dxb.setText(t.j.plugin_enable);
            this.dxb.setEnabled(true);
            ar.b(this.dxb, t.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.lD().bA(this.mPluginName)) {
            ar.b(this.dxb, t.d.cp_cont_d, 1);
            this.dxb.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().x(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dxb) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                aCE();
            } else if (this.mStatus == 3) {
                PluginPackageManager.lD().bu(this.mPluginName);
                aCD();
            } else if (this.mStatus == 2) {
                PluginPackageManager.lD().bv(this.mPluginName);
                aCD();
            }
        }
    }

    private void aCE() {
        if (!com.baidu.adp.lib.util.i.iZ()) {
            showToast(t.j.neterror);
        } else if (com.baidu.adp.lib.util.i.jb()) {
            aCF();
        } else {
            ar.b(this.dxb, t.d.cp_cont_d, 1);
            this.dxb.setEnabled(false);
            PluginPackageManager.lD().a(this.dxc, this.Ev);
        }
    }

    private void aCF() {
        String string;
        String string2;
        if (this.dxc != null && this.dxc.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.dxc.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(t.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(t.j.download_update);
            } else {
                string = getResources().getString(t.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(t.j.download);
            }
            aVar.cE(string);
            aVar.a(string2, new h(this));
            aVar.b(t.j.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.uj();
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
        PluginPackageManager.lD().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
