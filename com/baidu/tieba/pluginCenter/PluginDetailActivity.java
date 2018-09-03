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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView cfH;
    private HeadImageView gij;
    private TextView gik;
    private TextView gil;
    private TextView gim;
    private String gin;
    private PluginNetConfigInfos.PluginConfig gio;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Ij = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gio.package_name) && !PluginDetailActivity.this.mFinished) {
                am.c(PluginDetailActivity.this.gim, f.d.cp_cont_d, 1);
                PluginDetailActivity.this.gim.setText(PluginDetailActivity.this.getPageContext().getResources().getString(f.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.gim.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gio.package_name)) {
                PluginDetailActivity.this.gim.setText(PluginDetailActivity.this.getPageContext().getString(f.j.plugin_download_finished));
                PluginDetailActivity.this.gim.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gio.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bld();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(f.j.plugin_installation_finished));
                PluginDetailActivity.this.bld();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(f.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bld();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jE()) {
                PluginDetailActivity.this.bld();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(f.g.navigation_bar);
        this.mNavigationBar.setTitleText(f.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PluginDetailActivity.this.closeActivity();
            }
        });
        this.gij = (HeadImageView) findViewById(f.g.icon);
        this.mName = (TextView) findViewById(f.g.name);
        this.cfH = (TextView) findViewById(f.g.status);
        this.gik = (TextView) findViewById(f.g.changelog);
        this.gil = (TextView) findViewById(f.g.size);
        this.gim = (TextView) findViewById(f.g.enable);
        this.gim.setOnClickListener(this);
        this.gin = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk() != null) {
            this.gio = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk().getPluginConfig(this.gin);
        }
        if (PluginPackageManager.lN().bL(this.gin)) {
            PluginPackageManager.lN().a(this.Ij);
            am.c(this.gim, f.d.cp_cont_d, 1);
            this.gim.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gio != null) {
            this.gij.startLoad(this.gio.icon, 10, false);
            if (this.gio.display_name == null) {
                this.gio.display_name = "";
            }
            this.mName.setText(this.gio.display_name);
            bld();
            if (this.gio.newest != null) {
                if (TextUtils.isEmpty(this.gio.newest.change_log)) {
                    this.gik.setText("");
                } else {
                    this.gik.setText(this.gio.newest.change_log);
                }
                if (this.gio.newest.size <= 0) {
                    this.gil.setText("");
                } else {
                    this.gil.setText(getPageContext().getString(f.j.plugin_size) + String.valueOf(this.gio.newest.size / 1024) + "KB");
                }
            }
            this.gim.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bld() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.lN().bJ(this.gin) && PluginPackageManager.lN().bH(this.gin)) {
            this.cfH.setText(f.j.plugin_enabled);
            this.gim.setText(f.j.download_update);
            this.gim.setEnabled(true);
            am.c(this.gim, f.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.lN().bH(this.gin)) {
            this.gim.setEnabled(true);
            am.c(this.gim, f.d.cp_cont_g, 1);
            if (PluginPackageManager.lN().bI(this.gin)) {
                this.cfH.setText(f.j.plugin_unenabled);
                this.gim.setText(f.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.cfH.setText(f.j.plugin_enabled);
                this.gim.setText(f.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.cfH.setText(f.j.plugin_disabled);
            this.gim.setText(f.j.plugin_enable);
            this.gim.setEnabled(true);
            am.c(this.gim, f.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.lN().bL(this.gin)) {
            am.c(this.gim, f.d.cp_cont_d, 1);
            this.gim.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gim) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                ble();
            } else if (this.mStatus == 3) {
                PluginPackageManager.lN().bF(this.gin);
                bld();
            } else if (this.mStatus == 2) {
                PluginPackageManager.lN().bG(this.gin);
                bld();
            }
        }
    }

    private void ble() {
        if (!j.jE()) {
            showToast(f.j.neterror);
        } else if (j.jG()) {
            blf();
        } else {
            am.c(this.gim, f.d.cp_cont_d, 1);
            this.gim.setEnabled(false);
            PluginPackageManager.lN().a(this.gio, this.Ij);
        }
    }

    private void blf() {
        String string;
        String string2;
        if (this.gio != null && this.gio.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.gio.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(f.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(f.j.download_update);
            } else {
                string = getResources().getString(f.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(f.j.download);
            }
            aVar.dB(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    am.c(PluginDetailActivity.this.gim, f.d.cp_cont_d, 1);
                    PluginDetailActivity.this.gim.setEnabled(false);
                    PluginPackageManager.lN().a(PluginDetailActivity.this.gio, PluginDetailActivity.this.Ij);
                    aVar2.dismiss();
                }
            });
            aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.xe();
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
        PluginPackageManager.lN().a((d) null);
    }
}
