package com.baidu.tieba.pluginCenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.d;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView bKf;
    private boolean dtV;
    private HeadImageView fMA;
    private TextView fQM;
    private TextView fQN;
    private TextView fQO;
    private PluginNetConfigInfos.PluginConfig fQP;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private d DA = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fQP.package_name) && !PluginDetailActivity.this.dtV) {
                aj.c(PluginDetailActivity.this.fQO, d.C0082d.cp_cont_d, 1);
                PluginDetailActivity.this.fQO.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.fQO.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fQP.package_name)) {
                PluginDetailActivity.this.fQO.setText(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                PluginDetailActivity.this.fQO.setEnabled(false);
                PluginDetailActivity.this.dtV = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fQP.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bjJ();
                PluginDetailActivity.this.dtV = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_finished));
                PluginDetailActivity.this.bjJ();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bjJ();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.hh()) {
                PluginDetailActivity.this.bjJ();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.setTitleText(d.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PluginDetailActivity.this.closeActivity();
            }
        });
        this.fMA = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.bKf = (TextView) findViewById(d.g.status);
        this.fQM = (TextView) findViewById(d.g.changelog);
        this.fQN = (TextView) findViewById(d.g.size);
        this.fQO = (TextView) findViewById(d.g.enable);
        this.fQO.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jO().jP() != null) {
            this.fQP = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jO().jP().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.js().br(this.mPluginName)) {
            PluginPackageManager.js().a(this.DA);
            aj.c(this.fQO, d.C0082d.cp_cont_d, 1);
            this.fQO.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fQP != null) {
            this.fMA.startLoad(this.fQP.icon, 10, false);
            if (this.fQP.display_name == null) {
                this.fQP.display_name = "";
            }
            this.mName.setText(this.fQP.display_name);
            bjJ();
            if (this.fQP.newest != null) {
                if (TextUtils.isEmpty(this.fQP.newest.change_log)) {
                    this.fQM.setText("");
                } else {
                    this.fQM.setText(this.fQP.newest.change_log);
                }
                if (this.fQP.newest.size <= 0) {
                    this.fQN.setText("");
                } else {
                    this.fQN.setText(getPageContext().getString(d.j.plugin_size) + String.valueOf(this.fQP.newest.size / 1024) + "KB");
                }
            }
            this.fQO.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.js().bp(this.mPluginName) && PluginPackageManager.js().bn(this.mPluginName)) {
            this.bKf.setText(d.j.plugin_enabled);
            this.fQO.setText(d.j.download_update);
            this.fQO.setEnabled(true);
            aj.c(this.fQO, d.C0082d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.js().bn(this.mPluginName)) {
            this.fQO.setEnabled(true);
            aj.c(this.fQO, d.C0082d.cp_cont_g, 1);
            if (PluginPackageManager.js().bo(this.mPluginName)) {
                this.bKf.setText(d.j.plugin_unenabled);
                this.fQO.setText(d.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bKf.setText(d.j.plugin_enabled);
                this.fQO.setText(d.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bKf.setText(d.j.plugin_disabled);
            this.fQO.setText(d.j.plugin_enable);
            this.fQO.setEnabled(true);
            aj.c(this.fQO, d.C0082d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.js().br(this.mPluginName)) {
            aj.c(this.fQO, d.C0082d.cp_cont_d, 1);
            this.fQO.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fQO) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bjK();
            } else if (this.mStatus == 3) {
                PluginPackageManager.js().bl(this.mPluginName);
                bjJ();
            } else if (this.mStatus == 2) {
                PluginPackageManager.js().bm(this.mPluginName);
                bjJ();
            }
        }
    }

    private void bjK() {
        if (!j.hh()) {
            showToast(d.j.neterror);
        } else if (j.hj()) {
            bjL();
        } else {
            aj.c(this.fQO, d.C0082d.cp_cont_d, 1);
            this.fQO.setEnabled(false);
            PluginPackageManager.js().a(this.fQP, this.DA);
        }
    }

    private void bjL() {
        String string;
        String string2;
        if (this.fQP != null && this.fQP.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.fQP.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.j.download_update);
            } else {
                string = getResources().getString(d.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.j.download);
            }
            aVar.cS(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aj.c(PluginDetailActivity.this.fQO, d.C0082d.cp_cont_d, 1);
                    PluginDetailActivity.this.fQO.setEnabled(false);
                    PluginPackageManager.js().a(PluginDetailActivity.this.fQP, PluginDetailActivity.this.DA);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.tk();
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
        PluginPackageManager.js().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
