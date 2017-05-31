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
    private TextView bkH;
    private boolean cGG;
    private HeadImageView eZr;
    private TextView fcw;
    private TextView fcx;
    private TextView fcy;
    private PluginNetConfigInfos.PluginConfig fcz;
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
        this.eZr = (HeadImageView) findViewById(w.h.icon);
        this.mName = (TextView) findViewById(w.h.name);
        this.bkH = (TextView) findViewById(w.h.status);
        this.fcw = (TextView) findViewById(w.h.changelog);
        this.fcx = (TextView) findViewById(w.h.size);
        this.fcy = (TextView) findViewById(w.h.enable);
        this.fcy.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().jV() != null) {
            this.fcz = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().jV().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.jx().bh(this.mPluginName)) {
            PluginPackageManager.jx().a(this.Er);
            aq.c(this.fcy, w.e.cp_cont_d, 1);
            this.fcy.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fcz != null) {
            this.eZr.c(this.fcz.icon, 10, false);
            if (this.fcz.display_name == null) {
                this.fcz.display_name = "";
            }
            this.mName.setText(this.fcz.display_name);
            aYg();
            if (this.fcz.newest != null) {
                if (TextUtils.isEmpty(this.fcz.newest.change_log)) {
                    this.fcw.setText("");
                } else {
                    this.fcw.setText(this.fcz.newest.change_log);
                }
                if (this.fcz.newest.size <= 0) {
                    this.fcx.setText("");
                } else {
                    this.fcx.setText(String.valueOf(getPageContext().getString(w.l.plugin_size)) + String.valueOf(this.fcz.newest.size / 1024) + "KB");
                }
            }
            this.fcy.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.jx().bf(this.mPluginName) && PluginPackageManager.jx().bd(this.mPluginName)) {
            this.bkH.setText(w.l.plugin_enabled);
            this.fcy.setText(w.l.download_update);
            this.fcy.setEnabled(true);
            aq.c(this.fcy, w.e.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.jx().bd(this.mPluginName)) {
            this.fcy.setEnabled(true);
            aq.c(this.fcy, w.e.cp_cont_g, 1);
            if (PluginPackageManager.jx().be(this.mPluginName)) {
                this.bkH.setText(w.l.plugin_unenabled);
                this.fcy.setText(w.l.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bkH.setText(w.l.plugin_enabled);
                this.fcy.setText(w.l.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bkH.setText(w.l.plugin_disabled);
            this.fcy.setText(w.l.plugin_enable);
            this.fcy.setEnabled(true);
            aq.c(this.fcy, w.e.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.jx().bh(this.mPluginName)) {
            aq.c(this.fcy, w.e.cp_cont_d, 1);
            this.fcy.setEnabled(false);
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
        if (view == this.fcy) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                aYh();
            } else if (this.mStatus == 3) {
                PluginPackageManager.jx().bb(this.mPluginName);
                aYg();
            } else if (this.mStatus == 2) {
                PluginPackageManager.jx().bc(this.mPluginName);
                aYg();
            }
        }
    }

    private void aYh() {
        if (!com.baidu.adp.lib.util.i.hk()) {
            showToast(w.l.neterror);
        } else if (com.baidu.adp.lib.util.i.hm()) {
            aYi();
        } else {
            aq.c(this.fcy, w.e.cp_cont_d, 1);
            this.fcy.setEnabled(false);
            PluginPackageManager.jx().a(this.fcz, this.Er);
        }
    }

    private void aYi() {
        String string;
        String string2;
        if (this.fcz != null && this.fcz.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.fcz.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(w.l.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(w.l.download_update);
            } else {
                string = getResources().getString(w.l.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(w.l.download);
            }
            aVar.cB(string);
            aVar.a(string2, new h(this));
            aVar.b(w.l.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.tc();
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
