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
    private TextView bap;
    private TextView bgZ;
    private boolean cGh;
    private HeadImageView eUr;
    private TextView eXl;
    private TextView eXm;
    private TextView eXn;
    private PluginNetConfigInfos.PluginConfig eXo;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private com.baidu.adp.plugin.packageManager.e EN = new e(this);
    private final CustomMessageListener mNetworkChangedMessageListener = new f(this, 2000994);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.navigation_bar);
        this.mNavigationBar.setTitleText(w.l.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.eUr = (HeadImageView) findViewById(w.h.icon);
        this.bap = (TextView) findViewById(w.h.name);
        this.bgZ = (TextView) findViewById(w.h.status);
        this.eXl = (TextView) findViewById(w.h.changelog);
        this.eXm = (TextView) findViewById(w.h.size);
        this.eXn = (TextView) findViewById(w.h.enable);
        this.eXn.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jQ().jR() != null) {
            this.eXo = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jQ().jR().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.jt().bm(this.mPluginName)) {
            PluginPackageManager.jt().a(this.EN);
            aq.c(this.eXn, w.e.cp_cont_d, 1);
            this.eXn.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eXo != null) {
            this.eUr.c(this.eXo.icon, 10, false);
            if (this.eXo.display_name == null) {
                this.eXo.display_name = "";
            }
            this.bap.setText(this.eXo.display_name);
            aYe();
            if (this.eXo.newest != null) {
                if (TextUtils.isEmpty(this.eXo.newest.change_log)) {
                    this.eXl.setText("");
                } else {
                    this.eXl.setText(this.eXo.newest.change_log);
                }
                if (this.eXo.newest.size <= 0) {
                    this.eXm.setText("");
                } else {
                    this.eXm.setText(String.valueOf(getPageContext().getString(w.l.plugin_size)) + String.valueOf(this.eXo.newest.size / 1024) + "KB");
                }
            }
            this.eXn.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYe() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.jt().bk(this.mPluginName) && PluginPackageManager.jt().bi(this.mPluginName)) {
            this.bgZ.setText(w.l.plugin_enabled);
            this.eXn.setText(w.l.download_update);
            this.eXn.setEnabled(true);
            aq.c(this.eXn, w.e.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.jt().bi(this.mPluginName)) {
            this.eXn.setEnabled(true);
            aq.c(this.eXn, w.e.cp_cont_g, 1);
            if (PluginPackageManager.jt().bj(this.mPluginName)) {
                this.bgZ.setText(w.l.plugin_unenabled);
                this.eXn.setText(w.l.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bgZ.setText(w.l.plugin_enabled);
                this.eXn.setText(w.l.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bgZ.setText(w.l.plugin_disabled);
            this.eXn.setText(w.l.plugin_enable);
            this.eXn.setEnabled(true);
            aq.c(this.eXn, w.e.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.jt().bm(this.mPluginName)) {
            aq.c(this.eXn, w.e.cp_cont_d, 1);
            this.eXn.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eXn) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                aYf();
            } else if (this.mStatus == 3) {
                PluginPackageManager.jt().bg(this.mPluginName);
                aYe();
            } else if (this.mStatus == 2) {
                PluginPackageManager.jt().bh(this.mPluginName);
                aYe();
            }
        }
    }

    private void aYf() {
        if (!com.baidu.adp.lib.util.i.he()) {
            showToast(w.l.neterror);
        } else if (com.baidu.adp.lib.util.i.hg()) {
            aYg();
        } else {
            aq.c(this.eXn, w.e.cp_cont_d, 1);
            this.eXn.setEnabled(false);
            PluginPackageManager.jt().a(this.eXo, this.EN);
        }
    }

    private void aYg() {
        String string;
        String string2;
        if (this.eXo != null && this.eXo.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.eXo.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(w.l.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(w.l.download_update);
            } else {
                string = getResources().getString(w.l.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(w.l.download);
            }
            aVar.cx(string);
            aVar.a(string2, new h(this));
            aVar.b(w.l.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.ts();
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
        PluginPackageManager.jt().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
