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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView bpz;
    private boolean cSA;
    private TextView daX;
    private HeadImageView fdr;
    private TextView fgP;
    private TextView fgQ;
    private TextView fgR;
    private PluginNetConfigInfos.PluginConfig fgS;
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
        this.fdr = (HeadImageView) findViewById(r.g.icon);
        this.daX = (TextView) findViewById(r.g.name);
        this.bpz = (TextView) findViewById(r.g.status);
        this.fgP = (TextView) findViewById(r.g.changelog);
        this.fgQ = (TextView) findViewById(r.g.size);
        this.fgR = (TextView) findViewById(r.g.enable);
        this.fgR.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.iY().iZ() != null) {
            this.fgS = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.iY().iZ().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.iB().bt(this.mPluginName)) {
            PluginPackageManager.iB().a(this.xI);
            at.c(this.fgR, r.d.cp_cont_d, 1);
            this.fgR.setEnabled(false);
        }
        registerListener(this.FT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fgS != null) {
            this.fdr.c(this.fgS.icon, 10, false);
            if (this.fgS.display_name == null) {
                this.fgS.display_name = "";
            }
            this.daX.setText(this.fgS.display_name);
            bde();
            if (this.fgS.newest != null) {
                if (TextUtils.isEmpty(this.fgS.newest.change_log)) {
                    this.fgP.setText("");
                } else {
                    this.fgP.setText(this.fgS.newest.change_log);
                }
                if (this.fgS.newest.size <= 0) {
                    this.fgQ.setText("");
                } else {
                    this.fgQ.setText(String.valueOf(getPageContext().getString(r.j.plugin_size)) + String.valueOf(this.fgS.newest.size / 1024) + "KB");
                }
            }
            this.fgR.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bde() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.iB().br(this.mPluginName) && PluginPackageManager.iB().bp(this.mPluginName)) {
            this.bpz.setText(r.j.plugin_enabled);
            this.fgR.setText(r.j.plugin_update);
            this.fgR.setEnabled(true);
            at.c(this.fgR, r.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.iB().bp(this.mPluginName)) {
            this.fgR.setEnabled(true);
            at.c(this.fgR, r.d.cp_cont_g, 1);
            if (PluginPackageManager.iB().bq(this.mPluginName)) {
                this.bpz.setText(r.j.plugin_unenabled);
                this.fgR.setText(r.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bpz.setText(r.j.plugin_enabled);
                this.fgR.setText(r.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bpz.setText(r.j.plugin_disabled);
            this.fgR.setText(r.j.plugin_enable);
            this.fgR.setEnabled(true);
            at.c(this.fgR, r.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.iB().bt(this.mPluginName)) {
            at.c(this.fgR, r.d.cp_cont_d, 1);
            this.fgR.setEnabled(false);
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
        if (view == this.fgR) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bdf();
            } else if (this.mStatus == 3) {
                PluginPackageManager.iB().bn(this.mPluginName);
                bde();
            } else if (this.mStatus == 2) {
                PluginPackageManager.iB().bo(this.mPluginName);
                bde();
            }
        }
    }

    private void bdf() {
        if (!com.baidu.adp.lib.util.i.gm()) {
            showToast(r.j.neterror);
        } else if (com.baidu.adp.lib.util.i.go()) {
            bdg();
        } else {
            at.c(this.fgR, r.d.cp_cont_d, 1);
            this.fgR.setEnabled(false);
            PluginPackageManager.iB().a(this.fgS, this.xI);
        }
    }

    private void bdg() {
        String string;
        String string2;
        if (this.fgS != null && this.fgS.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.fgS.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(r.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(r.j.download_update);
            } else {
                string = getResources().getString(r.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(r.j.download);
            }
            aVar.cF(string);
            aVar.a(string2, new h(this));
            aVar.b(r.j.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.tq();
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
