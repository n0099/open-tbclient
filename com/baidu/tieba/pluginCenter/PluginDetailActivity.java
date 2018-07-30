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
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView cfK;
    private HeadImageView gik;
    private TextView gil;
    private TextView gim;
    private TextView gin;
    private String gio;
    private PluginNetConfigInfos.PluginConfig gip;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Ij = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gip.package_name) && !PluginDetailActivity.this.mFinished) {
                am.c(PluginDetailActivity.this.gin, d.C0140d.cp_cont_d, 1);
                PluginDetailActivity.this.gin.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.gin.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gip.package_name)) {
                PluginDetailActivity.this.gin.setText(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                PluginDetailActivity.this.gin.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gip.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.blg();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_finished));
                PluginDetailActivity.this.blg();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.blg();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jE()) {
                PluginDetailActivity.this.blg();
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
        this.gik = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.cfK = (TextView) findViewById(d.g.status);
        this.gil = (TextView) findViewById(d.g.changelog);
        this.gim = (TextView) findViewById(d.g.size);
        this.gin = (TextView) findViewById(d.g.enable);
        this.gin.setOnClickListener(this);
        this.gio = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk() != null) {
            this.gip = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk().getPluginConfig(this.gio);
        }
        if (PluginPackageManager.lN().bL(this.gio)) {
            PluginPackageManager.lN().a(this.Ij);
            am.c(this.gin, d.C0140d.cp_cont_d, 1);
            this.gin.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gip != null) {
            this.gik.startLoad(this.gip.icon, 10, false);
            if (this.gip.display_name == null) {
                this.gip.display_name = "";
            }
            this.mName.setText(this.gip.display_name);
            blg();
            if (this.gip.newest != null) {
                if (TextUtils.isEmpty(this.gip.newest.change_log)) {
                    this.gil.setText("");
                } else {
                    this.gil.setText(this.gip.newest.change_log);
                }
                if (this.gip.newest.size <= 0) {
                    this.gim.setText("");
                } else {
                    this.gim.setText(getPageContext().getString(d.j.plugin_size) + String.valueOf(this.gip.newest.size / 1024) + "KB");
                }
            }
            this.gin.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.lN().bJ(this.gio) && PluginPackageManager.lN().bH(this.gio)) {
            this.cfK.setText(d.j.plugin_enabled);
            this.gin.setText(d.j.download_update);
            this.gin.setEnabled(true);
            am.c(this.gin, d.C0140d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.lN().bH(this.gio)) {
            this.gin.setEnabled(true);
            am.c(this.gin, d.C0140d.cp_cont_g, 1);
            if (PluginPackageManager.lN().bI(this.gio)) {
                this.cfK.setText(d.j.plugin_unenabled);
                this.gin.setText(d.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.cfK.setText(d.j.plugin_enabled);
                this.gin.setText(d.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.cfK.setText(d.j.plugin_disabled);
            this.gin.setText(d.j.plugin_enable);
            this.gin.setEnabled(true);
            am.c(this.gin, d.C0140d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.lN().bL(this.gio)) {
            am.c(this.gin, d.C0140d.cp_cont_d, 1);
            this.gin.setEnabled(false);
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
        if (view == this.gin) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                blh();
            } else if (this.mStatus == 3) {
                PluginPackageManager.lN().bF(this.gio);
                blg();
            } else if (this.mStatus == 2) {
                PluginPackageManager.lN().bG(this.gio);
                blg();
            }
        }
    }

    private void blh() {
        if (!j.jE()) {
            showToast(d.j.neterror);
        } else if (j.jG()) {
            bli();
        } else {
            am.c(this.gin, d.C0140d.cp_cont_d, 1);
            this.gin.setEnabled(false);
            PluginPackageManager.lN().a(this.gip, this.Ij);
        }
    }

    private void bli() {
        String string;
        String string2;
        if (this.gip != null && this.gip.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.gip.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.j.download_update);
            } else {
                string = getResources().getString(d.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.j.download);
            }
            aVar.dB(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    am.c(PluginDetailActivity.this.gin, d.C0140d.cp_cont_d, 1);
                    PluginDetailActivity.this.gin.setEnabled(false);
                    PluginPackageManager.lN().a(PluginDetailActivity.this.gip, PluginDetailActivity.this.Ij);
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
            aVar.xf();
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
        PluginPackageManager.lN().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
