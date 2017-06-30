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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView bou;
    private boolean cOC;
    private HeadImageView fjH;
    private TextView fmM;
    private TextView fmN;
    private TextView fmO;
    private PluginNetConfigInfos.PluginConfig fmP;
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
        this.fjH = (HeadImageView) findViewById(w.h.icon);
        this.mName = (TextView) findViewById(w.h.name);
        this.bou = (TextView) findViewById(w.h.status);
        this.fmM = (TextView) findViewById(w.h.changelog);
        this.fmN = (TextView) findViewById(w.h.size);
        this.fmO = (TextView) findViewById(w.h.enable);
        this.fmO.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT() != null) {
            this.fmP = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.jw().bm(this.mPluginName)) {
            PluginPackageManager.jw().a(this.Er);
            as.c(this.fmO, w.e.cp_cont_d, 1);
            this.fmO.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fmP != null) {
            this.fjH.c(this.fmP.icon, 10, false);
            if (this.fmP.display_name == null) {
                this.fmP.display_name = "";
            }
            this.mName.setText(this.fmP.display_name);
            bcr();
            if (this.fmP.newest != null) {
                if (TextUtils.isEmpty(this.fmP.newest.change_log)) {
                    this.fmM.setText("");
                } else {
                    this.fmM.setText(this.fmP.newest.change_log);
                }
                if (this.fmP.newest.size <= 0) {
                    this.fmN.setText("");
                } else {
                    this.fmN.setText(String.valueOf(getPageContext().getString(w.l.plugin_size)) + String.valueOf(this.fmP.newest.size / 1024) + "KB");
                }
            }
            this.fmO.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.jw().bk(this.mPluginName) && PluginPackageManager.jw().bi(this.mPluginName)) {
            this.bou.setText(w.l.plugin_enabled);
            this.fmO.setText(w.l.download_update);
            this.fmO.setEnabled(true);
            as.c(this.fmO, w.e.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.jw().bi(this.mPluginName)) {
            this.fmO.setEnabled(true);
            as.c(this.fmO, w.e.cp_cont_g, 1);
            if (PluginPackageManager.jw().bj(this.mPluginName)) {
                this.bou.setText(w.l.plugin_unenabled);
                this.fmO.setText(w.l.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bou.setText(w.l.plugin_enabled);
                this.fmO.setText(w.l.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bou.setText(w.l.plugin_disabled);
            this.fmO.setText(w.l.plugin_enable);
            this.fmO.setEnabled(true);
            as.c(this.fmO, w.e.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.jw().bm(this.mPluginName)) {
            as.c(this.fmO, w.e.cp_cont_d, 1);
            this.fmO.setEnabled(false);
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
        if (view == this.fmO) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bcs();
            } else if (this.mStatus == 3) {
                PluginPackageManager.jw().bg(this.mPluginName);
                bcr();
            } else if (this.mStatus == 2) {
                PluginPackageManager.jw().bh(this.mPluginName);
                bcr();
            }
        }
    }

    private void bcs() {
        if (!com.baidu.adp.lib.util.i.hj()) {
            showToast(w.l.neterror);
        } else if (com.baidu.adp.lib.util.i.hl()) {
            bct();
        } else {
            as.c(this.fmO, w.e.cp_cont_d, 1);
            this.fmO.setEnabled(false);
            PluginPackageManager.jw().a(this.fmP, this.Er);
        }
    }

    private void bct() {
        String string;
        String string2;
        if (this.fmP != null && this.fmP.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.fmP.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(w.l.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(w.l.download_update);
            } else {
                string = getResources().getString(w.l.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(w.l.download);
            }
            aVar.cI(string);
            aVar.a(string2, new h(this));
            aVar.b(w.l.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.ta();
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
        PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
