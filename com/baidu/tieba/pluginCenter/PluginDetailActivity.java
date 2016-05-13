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
    private boolean bTZ;
    private HeadImageView bip;
    private TextView cao;
    private TextView dUA;
    private PluginNetConfigInfos.PluginConfig dUB;
    private TextView dUx;
    private TextView dUy;
    private TextView dUz;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private com.baidu.adp.plugin.packageManager.e uT = new e(this);
    private final CustomMessageListener Dc = new f(this, 2000994);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.navigation_bar);
        this.mNavigationBar.setTitleText(t.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.bip = (HeadImageView) findViewById(t.g.icon);
        this.cao = (TextView) findViewById(t.g.name);
        this.dUx = (TextView) findViewById(t.g.status);
        this.dUy = (TextView) findViewById(t.g.changelog);
        this.dUz = (TextView) findViewById(t.g.size);
        this.dUA = (TextView) findViewById(t.g.enable);
        this.dUA.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ic().id() != null) {
            this.dUB = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ic().id().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.hF().br(this.mPluginName)) {
            PluginPackageManager.hF().a(this.uT);
            at.c(this.dUA, t.d.cp_cont_d, 1);
            this.dUA.setEnabled(false);
        }
        registerListener(this.Dc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dUB != null) {
            this.bip.c(this.dUB.icon, 10, false);
            if (this.dUB.display_name == null) {
                this.dUB.display_name = "";
            }
            this.cao.setText(this.dUB.display_name);
            aKy();
            if (this.dUB.newest != null) {
                if (TextUtils.isEmpty(this.dUB.newest.change_log)) {
                    this.dUy.setText("");
                } else {
                    this.dUy.setText(this.dUB.newest.change_log);
                }
                if (this.dUB.newest.size <= 0) {
                    this.dUz.setText("");
                } else {
                    this.dUz.setText(String.valueOf(getPageContext().getString(t.j.plugin_size)) + String.valueOf(this.dUB.newest.size / 1024) + "KB");
                }
            }
            this.dUA.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKy() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.hF().bp(this.mPluginName) && PluginPackageManager.hF().bn(this.mPluginName)) {
            this.dUx.setText(t.j.plugin_enabled);
            this.dUA.setText(t.j.plugin_update);
            this.dUA.setEnabled(true);
            at.c(this.dUA, t.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.hF().bn(this.mPluginName)) {
            this.dUA.setEnabled(true);
            at.c(this.dUA, t.d.cp_cont_g, 1);
            if (PluginPackageManager.hF().bo(this.mPluginName)) {
                this.dUx.setText(t.j.plugin_unenabled);
                this.dUA.setText(t.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.dUx.setText(t.j.plugin_enabled);
                this.dUA.setText(t.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.dUx.setText(t.j.plugin_disabled);
            this.dUA.setText(t.j.plugin_enable);
            this.dUA.setEnabled(true);
            at.c(this.dUA, t.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.hF().br(this.mPluginName)) {
            at.c(this.dUA, t.d.cp_cont_d, 1);
            this.dUA.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ae(i == 1);
        getLayoutMode().x(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dUA) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                aKz();
            } else if (this.mStatus == 3) {
                PluginPackageManager.hF().bl(this.mPluginName);
                aKy();
            } else if (this.mStatus == 2) {
                PluginPackageManager.hF().bm(this.mPluginName);
                aKy();
            }
        }
    }

    private void aKz() {
        if (!com.baidu.adp.lib.util.i.fq()) {
            showToast(t.j.neterror);
        } else if (com.baidu.adp.lib.util.i.fs()) {
            aKA();
        } else {
            at.c(this.dUA, t.d.cp_cont_d, 1);
            this.dUA.setEnabled(false);
            PluginPackageManager.hF().a(this.dUB, this.uT);
        }
    }

    private void aKA() {
        String string;
        String string2;
        if (this.dUB != null && this.dUB.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.dUB.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(t.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(t.j.download_update);
            } else {
                string = getResources().getString(t.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(t.j.download);
            }
            aVar.cA(string);
            aVar.a(string2, new h(this));
            aVar.b(t.j.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.rV();
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
        PluginPackageManager.hF().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
