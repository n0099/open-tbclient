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
    private TextView bKj;
    private boolean dva;
    private HeadImageView fNs;
    private TextView fRF;
    private TextView fRG;
    private TextView fRH;
    private PluginNetConfigInfos.PluginConfig fRI;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private d Dz = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fRI.package_name) && !PluginDetailActivity.this.dva) {
                aj.c(PluginDetailActivity.this.fRH, d.C0096d.cp_cont_d, 1);
                PluginDetailActivity.this.fRH.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.fRH.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fRI.package_name)) {
                PluginDetailActivity.this.fRH.setText(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                PluginDetailActivity.this.fRH.setEnabled(false);
                PluginDetailActivity.this.dva = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fRI.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bjQ();
                PluginDetailActivity.this.dva = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_finished));
                PluginDetailActivity.this.bjQ();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bjQ();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.hh()) {
                PluginDetailActivity.this.bjQ();
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
        this.fNs = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.bKj = (TextView) findViewById(d.g.status);
        this.fRF = (TextView) findViewById(d.g.changelog);
        this.fRG = (TextView) findViewById(d.g.size);
        this.fRH = (TextView) findViewById(d.g.enable);
        this.fRH.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jO().jP() != null) {
            this.fRI = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jO().jP().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.js().br(this.mPluginName)) {
            PluginPackageManager.js().a(this.Dz);
            aj.c(this.fRH, d.C0096d.cp_cont_d, 1);
            this.fRH.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fRI != null) {
            this.fNs.startLoad(this.fRI.icon, 10, false);
            if (this.fRI.display_name == null) {
                this.fRI.display_name = "";
            }
            this.mName.setText(this.fRI.display_name);
            bjQ();
            if (this.fRI.newest != null) {
                if (TextUtils.isEmpty(this.fRI.newest.change_log)) {
                    this.fRF.setText("");
                } else {
                    this.fRF.setText(this.fRI.newest.change_log);
                }
                if (this.fRI.newest.size <= 0) {
                    this.fRG.setText("");
                } else {
                    this.fRG.setText(getPageContext().getString(d.j.plugin_size) + String.valueOf(this.fRI.newest.size / 1024) + "KB");
                }
            }
            this.fRH.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjQ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.js().bp(this.mPluginName) && PluginPackageManager.js().bn(this.mPluginName)) {
            this.bKj.setText(d.j.plugin_enabled);
            this.fRH.setText(d.j.download_update);
            this.fRH.setEnabled(true);
            aj.c(this.fRH, d.C0096d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.js().bn(this.mPluginName)) {
            this.fRH.setEnabled(true);
            aj.c(this.fRH, d.C0096d.cp_cont_g, 1);
            if (PluginPackageManager.js().bo(this.mPluginName)) {
                this.bKj.setText(d.j.plugin_unenabled);
                this.fRH.setText(d.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bKj.setText(d.j.plugin_enabled);
                this.fRH.setText(d.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bKj.setText(d.j.plugin_disabled);
            this.fRH.setText(d.j.plugin_enable);
            this.fRH.setEnabled(true);
            aj.c(this.fRH, d.C0096d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.js().br(this.mPluginName)) {
            aj.c(this.fRH, d.C0096d.cp_cont_d, 1);
            this.fRH.setEnabled(false);
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
        if (view == this.fRH) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bjR();
            } else if (this.mStatus == 3) {
                PluginPackageManager.js().bl(this.mPluginName);
                bjQ();
            } else if (this.mStatus == 2) {
                PluginPackageManager.js().bm(this.mPluginName);
                bjQ();
            }
        }
    }

    private void bjR() {
        if (!j.hh()) {
            showToast(d.j.neterror);
        } else if (j.hj()) {
            bjS();
        } else {
            aj.c(this.fRH, d.C0096d.cp_cont_d, 1);
            this.fRH.setEnabled(false);
            PluginPackageManager.js().a(this.fRI, this.Dz);
        }
    }

    private void bjS() {
        String string;
        String string2;
        if (this.fRI != null && this.fRI.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.fRI.newest.size / 1048576.0f;
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
                    aj.c(PluginDetailActivity.this.fRH, d.C0096d.cp_cont_d, 1);
                    PluginDetailActivity.this.fRH.setEnabled(false);
                    PluginPackageManager.js().a(PluginDetailActivity.this.fRI, PluginDetailActivity.this.Dz);
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
            aVar.th();
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
