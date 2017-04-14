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
    private TextView bgT;
    private boolean cEG;
    private HeadImageView eSq;
    private TextView eVk;
    private TextView eVl;
    private TextView eVm;
    private PluginNetConfigInfos.PluginConfig eVn;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private com.baidu.adp.plugin.packageManager.e Eo = new e(this);
    private final CustomMessageListener mNetworkChangedMessageListener = new f(this, 2000994);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.navigation_bar);
        this.mNavigationBar.setTitleText(w.l.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.eSq = (HeadImageView) findViewById(w.h.icon);
        this.mName = (TextView) findViewById(w.h.name);
        this.bgT = (TextView) findViewById(w.h.status);
        this.eVk = (TextView) findViewById(w.h.changelog);
        this.eVl = (TextView) findViewById(w.h.size);
        this.eVm = (TextView) findViewById(w.h.enable);
        this.eVm.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().jV() != null) {
            this.eVn = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().jV().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.jx().bh(this.mPluginName)) {
            PluginPackageManager.jx().a(this.Eo);
            aq.c(this.eVm, w.e.cp_cont_d, 1);
            this.eVm.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eVn != null) {
            this.eSq.c(this.eVn.icon, 10, false);
            if (this.eVn.display_name == null) {
                this.eVn.display_name = "";
            }
            this.mName.setText(this.eVn.display_name);
            aYn();
            if (this.eVn.newest != null) {
                if (TextUtils.isEmpty(this.eVn.newest.change_log)) {
                    this.eVk.setText("");
                } else {
                    this.eVk.setText(this.eVn.newest.change_log);
                }
                if (this.eVn.newest.size <= 0) {
                    this.eVl.setText("");
                } else {
                    this.eVl.setText(String.valueOf(getPageContext().getString(w.l.plugin_size)) + String.valueOf(this.eVn.newest.size / 1024) + "KB");
                }
            }
            this.eVm.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYn() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.jx().bf(this.mPluginName) && PluginPackageManager.jx().bd(this.mPluginName)) {
            this.bgT.setText(w.l.plugin_enabled);
            this.eVm.setText(w.l.download_update);
            this.eVm.setEnabled(true);
            aq.c(this.eVm, w.e.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.jx().bd(this.mPluginName)) {
            this.eVm.setEnabled(true);
            aq.c(this.eVm, w.e.cp_cont_g, 1);
            if (PluginPackageManager.jx().be(this.mPluginName)) {
                this.bgT.setText(w.l.plugin_unenabled);
                this.eVm.setText(w.l.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bgT.setText(w.l.plugin_enabled);
                this.eVm.setText(w.l.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bgT.setText(w.l.plugin_disabled);
            this.eVm.setText(w.l.plugin_enable);
            this.eVm.setEnabled(true);
            aq.c(this.eVm, w.e.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.jx().bh(this.mPluginName)) {
            aq.c(this.eVm, w.e.cp_cont_d, 1);
            this.eVm.setEnabled(false);
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
        if (view == this.eVm) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                aYo();
            } else if (this.mStatus == 3) {
                PluginPackageManager.jx().bb(this.mPluginName);
                aYn();
            } else if (this.mStatus == 2) {
                PluginPackageManager.jx().bc(this.mPluginName);
                aYn();
            }
        }
    }

    private void aYo() {
        if (!com.baidu.adp.lib.util.i.hj()) {
            showToast(w.l.neterror);
        } else if (com.baidu.adp.lib.util.i.hl()) {
            aYp();
        } else {
            aq.c(this.eVm, w.e.cp_cont_d, 1);
            this.eVm.setEnabled(false);
            PluginPackageManager.jx().a(this.eVn, this.Eo);
        }
    }

    private void aYp() {
        String string;
        String string2;
        if (this.eVn != null && this.eVn.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.eVn.newest.size / 1048576.0f;
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
        PluginPackageManager.jx().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
