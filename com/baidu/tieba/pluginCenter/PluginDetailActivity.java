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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView bHW;
    private HeadImageView bbz;
    private TextView ddA;
    private TextView ddB;
    private PluginNetConfigInfos.PluginConfig ddC;
    private boolean ddD;
    private TextView ddy;
    private TextView ddz;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private com.baidu.adp.plugin.packageManager.e DO = new e(this);
    private final CustomMessageListener mNetworkChangedMessageListener = new f(this, 2000994);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.navigation_bar);
        this.mNavigationBar.setTitleText(n.i.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.bbz = (HeadImageView) findViewById(n.f.icon);
        this.bHW = (TextView) findViewById(n.f.name);
        this.ddy = (TextView) findViewById(n.f.status);
        this.ddz = (TextView) findViewById(n.f.changelog);
        this.ddA = (TextView) findViewById(n.f.size);
        this.ddB = (TextView) findViewById(n.f.enable);
        this.ddB.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ml().mm() != null) {
            this.ddC = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ml().mm().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.lU().bx(this.mPluginName)) {
            PluginPackageManager.lU().a(this.DO);
            as.b(this.ddB, n.c.cp_cont_d, 1);
            this.ddB.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.ddC != null) {
            this.bbz.d(this.ddC.icon, 10, false);
            if (this.ddC.display_name == null) {
                this.ddC.display_name = "";
            }
            this.bHW.setText(this.ddC.display_name);
            aup();
            if (this.ddC.newest != null) {
                if (TextUtils.isEmpty(this.ddC.newest.change_log)) {
                    this.ddz.setText("");
                } else {
                    this.ddz.setText(this.ddC.newest.change_log);
                }
                if (this.ddC.newest.size <= 0) {
                    this.ddA.setText("");
                } else {
                    this.ddA.setText(String.valueOf(getPageContext().getString(n.i.plugin_size)) + String.valueOf(this.ddC.newest.size / 1024) + "KB");
                }
            }
            this.ddB.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aup() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.lU().bv(this.mPluginName) && PluginPackageManager.lU().bt(this.mPluginName)) {
            this.ddy.setText(n.i.plugin_enabled);
            this.ddB.setText(n.i.plugin_update);
            this.ddB.setEnabled(true);
            as.b(this.ddB, n.c.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.lU().bt(this.mPluginName)) {
            this.ddB.setEnabled(true);
            as.b(this.ddB, n.c.cp_cont_g, 1);
            if (PluginPackageManager.lU().bu(this.mPluginName)) {
                this.ddy.setText(n.i.plugin_unenabled);
                this.ddB.setText(n.i.plugin_enable);
                this.mStatus = 2;
            } else {
                this.ddy.setText(n.i.plugin_enabled);
                this.ddB.setText(n.i.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.ddy.setText(n.i.plugin_disabled);
            this.ddB.setText(n.i.plugin_enable);
            this.ddB.setEnabled(true);
            as.b(this.ddB, n.c.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.lU().bx(this.mPluginName)) {
            as.b(this.ddB, n.c.cp_cont_d, 1);
            this.ddB.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().af(i == 1);
        getLayoutMode().k(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ddB) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                auq();
            } else if (this.mStatus == 3) {
                PluginPackageManager.lU().br(this.mPluginName);
                aup();
            } else if (this.mStatus == 2) {
                PluginPackageManager.lU().bs(this.mPluginName);
                aup();
            }
        }
    }

    private void auq() {
        if (!com.baidu.adp.lib.util.i.iP()) {
            showToast(n.i.neterror);
        } else if (com.baidu.adp.lib.util.i.iR()) {
            aur();
        } else {
            as.b(this.ddB, n.c.cp_cont_d, 1);
            this.ddB.setEnabled(false);
            PluginPackageManager.lU().a(this.ddC, this.DO);
        }
    }

    private void aur() {
        String string;
        String string2;
        if (this.ddC != null && this.ddC.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.ddC.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(n.i.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(n.i.download_update);
            } else {
                string = getResources().getString(n.i.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(n.i.download);
            }
            aVar.cC(string);
            aVar.a(string2, new h(this));
            aVar.b(n.i.cancel, new i(this));
            aVar.b(getPageContext());
            aVar.tv();
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
        PluginPackageManager.lU().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
