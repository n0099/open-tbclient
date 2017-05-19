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
/* loaded from: classes2.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView bjA;
    private boolean cBh;
    private HeadImageView eQG;
    private TextView eTB;
    private TextView eTC;
    private TextView eTD;
    private PluginNetConfigInfos.PluginConfig eTE;
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
        this.eQG = (HeadImageView) findViewById(w.h.icon);
        this.mName = (TextView) findViewById(w.h.name);
        this.bjA = (TextView) findViewById(w.h.status);
        this.eTB = (TextView) findViewById(w.h.changelog);
        this.eTC = (TextView) findViewById(w.h.size);
        this.eTD = (TextView) findViewById(w.h.enable);
        this.eTD.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().jV() != null) {
            this.eTE = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().jV().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.jx().bh(this.mPluginName)) {
            PluginPackageManager.jx().a(this.Er);
            aq.c(this.eTD, w.e.cp_cont_d, 1);
            this.eTD.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eTE != null) {
            this.eQG.c(this.eTE.icon, 10, false);
            if (this.eTE.display_name == null) {
                this.eTE.display_name = "";
            }
            this.mName.setText(this.eTE.display_name);
            aWN();
            if (this.eTE.newest != null) {
                if (TextUtils.isEmpty(this.eTE.newest.change_log)) {
                    this.eTB.setText("");
                } else {
                    this.eTB.setText(this.eTE.newest.change_log);
                }
                if (this.eTE.newest.size <= 0) {
                    this.eTC.setText("");
                } else {
                    this.eTC.setText(String.valueOf(getPageContext().getString(w.l.plugin_size)) + String.valueOf(this.eTE.newest.size / 1024) + "KB");
                }
            }
            this.eTD.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWN() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.jx().bf(this.mPluginName) && PluginPackageManager.jx().bd(this.mPluginName)) {
            this.bjA.setText(w.l.plugin_enabled);
            this.eTD.setText(w.l.download_update);
            this.eTD.setEnabled(true);
            aq.c(this.eTD, w.e.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.jx().bd(this.mPluginName)) {
            this.eTD.setEnabled(true);
            aq.c(this.eTD, w.e.cp_cont_g, 1);
            if (PluginPackageManager.jx().be(this.mPluginName)) {
                this.bjA.setText(w.l.plugin_unenabled);
                this.eTD.setText(w.l.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bjA.setText(w.l.plugin_enabled);
                this.eTD.setText(w.l.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bjA.setText(w.l.plugin_disabled);
            this.eTD.setText(w.l.plugin_enable);
            this.eTD.setEnabled(true);
            aq.c(this.eTD, w.e.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.jx().bh(this.mPluginName)) {
            aq.c(this.eTD, w.e.cp_cont_d, 1);
            this.eTD.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eTD) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                aWO();
            } else if (this.mStatus == 3) {
                PluginPackageManager.jx().bb(this.mPluginName);
                aWN();
            } else if (this.mStatus == 2) {
                PluginPackageManager.jx().bc(this.mPluginName);
                aWN();
            }
        }
    }

    private void aWO() {
        if (!com.baidu.adp.lib.util.i.hk()) {
            showToast(w.l.neterror);
        } else if (com.baidu.adp.lib.util.i.hm()) {
            aWP();
        } else {
            aq.c(this.eTD, w.e.cp_cont_d, 1);
            this.eTD.setEnabled(false);
            PluginPackageManager.jx().a(this.eTE, this.Er);
        }
    }

    private void aWP() {
        String string;
        String string2;
        if (this.eTE != null && this.eTE.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.eTE.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(w.l.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(w.l.download_update);
            } else {
                string = getResources().getString(w.l.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(w.l.download);
            }
            aVar.cC(string);
            aVar.a(string2, new h(this));
            aVar.b(w.l.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.td();
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
        PluginPackageManager.jx().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
