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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView bmr;
    private boolean cMt;
    private TextView cTS;
    private HeadImageView eWM;
    private TextView eWN;
    private TextView eWO;
    private TextView eWP;
    private PluginNetConfigInfos.PluginConfig eWQ;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private com.baidu.adp.plugin.packageManager.e xI = new e(this);
    private final CustomMessageListener FQ = new f(this, 2000994);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.navigation_bar);
        this.mNavigationBar.setTitleText(t.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.eWM = (HeadImageView) findViewById(t.g.icon);
        this.cTS = (TextView) findViewById(t.g.name);
        this.bmr = (TextView) findViewById(t.g.status);
        this.eWN = (TextView) findViewById(t.g.changelog);
        this.eWO = (TextView) findViewById(t.g.size);
        this.eWP = (TextView) findViewById(t.g.enable);
        this.eWP.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.iY().iZ() != null) {
            this.eWQ = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.iY().iZ().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.iB().bt(this.mPluginName)) {
            PluginPackageManager.iB().a(this.xI);
            av.c(this.eWP, t.d.cp_cont_d, 1);
            this.eWP.setEnabled(false);
        }
        registerListener(this.FQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eWQ != null) {
            this.eWM.c(this.eWQ.icon, 10, false);
            if (this.eWQ.display_name == null) {
                this.eWQ.display_name = "";
            }
            this.cTS.setText(this.eWQ.display_name);
            aZZ();
            if (this.eWQ.newest != null) {
                if (TextUtils.isEmpty(this.eWQ.newest.change_log)) {
                    this.eWN.setText("");
                } else {
                    this.eWN.setText(this.eWQ.newest.change_log);
                }
                if (this.eWQ.newest.size <= 0) {
                    this.eWO.setText("");
                } else {
                    this.eWO.setText(String.valueOf(getPageContext().getString(t.j.plugin_size)) + String.valueOf(this.eWQ.newest.size / 1024) + "KB");
                }
            }
            this.eWP.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZZ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.iB().br(this.mPluginName) && PluginPackageManager.iB().bp(this.mPluginName)) {
            this.bmr.setText(t.j.plugin_enabled);
            this.eWP.setText(t.j.plugin_update);
            this.eWP.setEnabled(true);
            av.c(this.eWP, t.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.iB().bp(this.mPluginName)) {
            this.eWP.setEnabled(true);
            av.c(this.eWP, t.d.cp_cont_g, 1);
            if (PluginPackageManager.iB().bq(this.mPluginName)) {
                this.bmr.setText(t.j.plugin_unenabled);
                this.eWP.setText(t.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bmr.setText(t.j.plugin_enabled);
                this.eWP.setText(t.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bmr.setText(t.j.plugin_disabled);
            this.eWP.setText(t.j.plugin_enable);
            this.eWP.setEnabled(true);
            av.c(this.eWP, t.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.iB().bt(this.mPluginName)) {
            av.c(this.eWP, t.d.cp_cont_d, 1);
            this.eWP.setEnabled(false);
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
        if (view == this.eWP) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                baa();
            } else if (this.mStatus == 3) {
                PluginPackageManager.iB().bn(this.mPluginName);
                aZZ();
            } else if (this.mStatus == 2) {
                PluginPackageManager.iB().bo(this.mPluginName);
                aZZ();
            }
        }
    }

    private void baa() {
        if (!com.baidu.adp.lib.util.i.gm()) {
            showToast(t.j.neterror);
        } else if (com.baidu.adp.lib.util.i.go()) {
            bab();
        } else {
            av.c(this.eWP, t.d.cp_cont_d, 1);
            this.eWP.setEnabled(false);
            PluginPackageManager.iB().a(this.eWQ, this.xI);
        }
    }

    private void bab() {
        String string;
        String string2;
        if (this.eWQ != null && this.eWQ.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.eWQ.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(t.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(t.j.download_update);
            } else {
                string = getResources().getString(t.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(t.j.download);
            }
            aVar.cB(string);
            aVar.a(string2, new h(this));
            aVar.b(t.j.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.sX();
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
