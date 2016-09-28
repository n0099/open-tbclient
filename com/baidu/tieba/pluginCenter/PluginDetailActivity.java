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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView bmE;
    private boolean cNk;
    private TextView cVm;
    private HeadImageView eZt;
    private TextView eZu;
    private TextView eZv;
    private TextView eZw;
    private PluginNetConfigInfos.PluginConfig eZx;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private com.baidu.adp.plugin.packageManager.e xI = new e(this);
    private final CustomMessageListener FQ = new f(this, 2000994);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.navigation_bar);
        this.mNavigationBar.setTitleText(r.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.eZt = (HeadImageView) findViewById(r.g.icon);
        this.cVm = (TextView) findViewById(r.g.name);
        this.bmE = (TextView) findViewById(r.g.status);
        this.eZu = (TextView) findViewById(r.g.changelog);
        this.eZv = (TextView) findViewById(r.g.size);
        this.eZw = (TextView) findViewById(r.g.enable);
        this.eZw.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.iY().iZ() != null) {
            this.eZx = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.iY().iZ().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.iB().bt(this.mPluginName)) {
            PluginPackageManager.iB().a(this.xI);
            av.c(this.eZw, r.d.cp_cont_d, 1);
            this.eZw.setEnabled(false);
        }
        registerListener(this.FQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eZx != null) {
            this.eZt.c(this.eZx.icon, 10, false);
            if (this.eZx.display_name == null) {
                this.eZx.display_name = "";
            }
            this.cVm.setText(this.eZx.display_name);
            baG();
            if (this.eZx.newest != null) {
                if (TextUtils.isEmpty(this.eZx.newest.change_log)) {
                    this.eZu.setText("");
                } else {
                    this.eZu.setText(this.eZx.newest.change_log);
                }
                if (this.eZx.newest.size <= 0) {
                    this.eZv.setText("");
                } else {
                    this.eZv.setText(String.valueOf(getPageContext().getString(r.j.plugin_size)) + String.valueOf(this.eZx.newest.size / 1024) + "KB");
                }
            }
            this.eZw.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baG() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.iB().br(this.mPluginName) && PluginPackageManager.iB().bp(this.mPluginName)) {
            this.bmE.setText(r.j.plugin_enabled);
            this.eZw.setText(r.j.plugin_update);
            this.eZw.setEnabled(true);
            av.c(this.eZw, r.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.iB().bp(this.mPluginName)) {
            this.eZw.setEnabled(true);
            av.c(this.eZw, r.d.cp_cont_g, 1);
            if (PluginPackageManager.iB().bq(this.mPluginName)) {
                this.bmE.setText(r.j.plugin_unenabled);
                this.eZw.setText(r.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bmE.setText(r.j.plugin_enabled);
                this.eZw.setText(r.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bmE.setText(r.j.plugin_disabled);
            this.eZw.setText(r.j.plugin_enable);
            this.eZw.setEnabled(true);
            av.c(this.eZw, r.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.iB().bt(this.mPluginName)) {
            av.c(this.eZw, r.d.cp_cont_d, 1);
            this.eZw.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eZw) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                baH();
            } else if (this.mStatus == 3) {
                PluginPackageManager.iB().bn(this.mPluginName);
                baG();
            } else if (this.mStatus == 2) {
                PluginPackageManager.iB().bo(this.mPluginName);
                baG();
            }
        }
    }

    private void baH() {
        if (!com.baidu.adp.lib.util.i.gm()) {
            showToast(r.j.neterror);
        } else if (com.baidu.adp.lib.util.i.go()) {
            baI();
        } else {
            av.c(this.eZw, r.d.cp_cont_d, 1);
            this.eZw.setEnabled(false);
            PluginPackageManager.iB().a(this.eZx, this.xI);
        }
    }

    private void baI() {
        String string;
        String string2;
        if (this.eZx != null && this.eZx.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.eZx.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(r.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(r.j.download_update);
            } else {
                string = getResources().getString(r.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(r.j.download);
            }
            aVar.cD(string);
            aVar.a(string2, new h(this));
            aVar.b(r.j.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.tm();
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
