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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView aUd;
    private TextView bao;
    private boolean cEL;
    private HeadImageView eQN;
    private TextView eTF;
    private TextView eTG;
    private TextView eTH;
    private PluginNetConfigInfos.PluginConfig eTI;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private com.baidu.adp.plugin.packageManager.e xz = new e(this);
    private final CustomMessageListener mNetworkChangedMessageListener = new f(this, 2000994);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.j.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(r.h.navigation_bar);
        this.mNavigationBar.setTitleText(r.l.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.eQN = (HeadImageView) findViewById(r.h.icon);
        this.aUd = (TextView) findViewById(r.h.name);
        this.bao = (TextView) findViewById(r.h.status);
        this.eTF = (TextView) findViewById(r.h.changelog);
        this.eTG = (TextView) findViewById(r.h.size);
        this.eTH = (TextView) findViewById(r.h.enable);
        this.eTH.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.iW().iX() != null) {
            this.eTI = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.iW().iX().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.iz().bs(this.mPluginName)) {
            PluginPackageManager.iz().a(this.xz);
            ap.c(this.eTH, r.e.cp_cont_d, 1);
            this.eTH.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eTI != null) {
            this.eQN.c(this.eTI.icon, 10, false);
            if (this.eTI.display_name == null) {
                this.eTI.display_name = "";
            }
            this.aUd.setText(this.eTI.display_name);
            aYz();
            if (this.eTI.newest != null) {
                if (TextUtils.isEmpty(this.eTI.newest.change_log)) {
                    this.eTF.setText("");
                } else {
                    this.eTF.setText(this.eTI.newest.change_log);
                }
                if (this.eTI.newest.size <= 0) {
                    this.eTG.setText("");
                } else {
                    this.eTG.setText(String.valueOf(getPageContext().getString(r.l.plugin_size)) + String.valueOf(this.eTI.newest.size / 1024) + "KB");
                }
            }
            this.eTH.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYz() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.iz().bq(this.mPluginName) && PluginPackageManager.iz().bo(this.mPluginName)) {
            this.bao.setText(r.l.plugin_enabled);
            this.eTH.setText(r.l.download_update);
            this.eTH.setEnabled(true);
            ap.c(this.eTH, r.e.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.iz().bo(this.mPluginName)) {
            this.eTH.setEnabled(true);
            ap.c(this.eTH, r.e.cp_cont_g, 1);
            if (PluginPackageManager.iz().bp(this.mPluginName)) {
                this.bao.setText(r.l.plugin_unenabled);
                this.eTH.setText(r.l.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bao.setText(r.l.plugin_enabled);
                this.eTH.setText(r.l.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bao.setText(r.l.plugin_disabled);
            this.eTH.setText(r.l.plugin_enable);
            this.eTH.setEnabled(true);
            ap.c(this.eTH, r.e.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.iz().bs(this.mPluginName)) {
            ap.c(this.eTH, r.e.cp_cont_d, 1);
            this.eTH.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().v(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eTH) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                aYA();
            } else if (this.mStatus == 3) {
                PluginPackageManager.iz().bm(this.mPluginName);
                aYz();
            } else if (this.mStatus == 2) {
                PluginPackageManager.iz().bn(this.mPluginName);
                aYz();
            }
        }
    }

    private void aYA() {
        if (!com.baidu.adp.lib.util.i.gk()) {
            showToast(r.l.neterror);
        } else if (com.baidu.adp.lib.util.i.gm()) {
            aYB();
        } else {
            ap.c(this.eTH, r.e.cp_cont_d, 1);
            this.eTH.setEnabled(false);
            PluginPackageManager.iz().a(this.eTI, this.xz);
        }
    }

    private void aYB() {
        String string;
        String string2;
        if (this.eTI != null && this.eTI.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.eTI.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(r.l.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(r.l.download_update);
            } else {
                string = getResources().getString(r.l.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(r.l.download);
            }
            aVar.cE(string);
            aVar.a(string2, new h(this));
            aVar.b(r.l.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.sV();
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
        PluginPackageManager.iz().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
