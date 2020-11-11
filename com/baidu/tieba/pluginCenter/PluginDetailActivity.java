package com.baidu.tieba.pluginCenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.d;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.adp.plugin.util.Util;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugin.ShadowLayout;
import com.baidu.tieba.R;
import java.io.File;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes21.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String dkt;
    private TextView ewr;
    private TextView hvZ;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private HeadImageView mmD;
    private TextView mmE;
    private TextView mmF;
    private TextView mmG;
    private ProgressBar mmH;
    private PluginNetConfigInfos.PluginConfig mmI;
    private ShadowLayout mmJ;
    private d TI = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mmI != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mmI.package_name) && !PluginDetailActivity.this.mFinished) {
                ap.setViewTextColor(PluginDetailActivity.this.mmG, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.mmJ.setShadowColor(0);
                PluginDetailActivity.this.mmG.setEnabled(false);
                PluginDetailActivity.this.mmG.setVisibility(8);
                PluginDetailActivity.this.mmH.setVisibility(0);
                PluginDetailActivity.this.ewr.setVisibility(0);
                PluginDetailActivity.this.mmH.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mmI != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mmI.package_name)) {
                PluginDetailActivity.this.mmG.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.mmG.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mmI != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mmI.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.dxQ();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.dxQ();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.dxQ();
        }
    };
    private final CustomMessageListener exb = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.dxQ();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.plugin_center));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PluginDetailActivity.this.closeActivity();
            }
        });
        this.mmD = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.hvZ = (TextView) findViewById(R.id.status);
        this.mmH = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.ewr = (TextView) findViewById(R.id.plugin_download_text);
        this.mmE = (TextView) findViewById(R.id.changelog);
        this.mmF = (TextView) findViewById(R.id.size);
        this.mmG = (TextView) findViewById(R.id.enable);
        this.mmG.setOnClickListener(this);
        this.mmJ = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.dkt = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qp().qq() != null) {
            this.mmI = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qp().qq().getPluginConfig(this.dkt);
        }
        if (PluginPackageManager.pT().cG(this.dkt)) {
            PluginPackageManager.pT().a(this.TI);
            ap.setViewTextColor(this.mmG, R.color.cp_cont_d, 1);
            this.mmG.setEnabled(false);
        }
        registerListener(this.exb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mmI != null) {
            this.mmD.startLoad(this.mmI.icon, 10, false);
            if (this.mmI.display_name == null) {
                this.mmI.display_name = "";
            }
            this.mName.setText(this.mmI.display_name);
            dxQ();
            if (this.mmI.newest != null) {
                if (TextUtils.isEmpty(this.mmI.newest.change_log)) {
                    this.mmE.setText("");
                } else {
                    this.mmE.setText(this.mmI.newest.change_log);
                }
                if (this.mmI.newest.size <= 0) {
                    this.mmF.setText("");
                } else {
                    this.mmF.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.mmI.newest.size / 1024) + "KB");
                }
            }
            this.mmG.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a2;
        super.onResume();
        if (this.mmH != null && PluginPackageManager.pT().cG(this.dkt) && (a2 = a(this.mmI)) < 100) {
            ap.setViewTextColor(this.mmG, R.color.cp_cont_d, 1);
            this.mmJ.setShadowColor(0);
            this.mmG.setEnabled(false);
            this.mmG.setVisibility(8);
            this.mmH.setVisibility(0);
            this.ewr.setVisibility(0);
            this.mmH.setProgress(a2);
        }
        PluginPackageManager.pT().a(this.TI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.pT().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxQ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.pT().cE(this.dkt) && PluginPackageManager.pT().cC(this.dkt)) {
            this.hvZ.setText(R.string.plugin_enabled);
            this.mmG.setVisibility(0);
            this.mmG.setText(R.string.download_update);
            this.mmG.setEnabled(true);
            ap.setBackgroundResource(this.mmG, R.drawable.selector_blue_gradient_button);
            this.mmJ.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.mmG, R.color.cp_cont_g, 1);
            this.mmH.setVisibility(8);
            this.ewr.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.pT().cC(this.dkt)) {
            this.mmG.setEnabled(true);
            ap.setViewTextColor(this.mmG, R.color.cp_cont_g, 1);
            this.mmG.setVisibility(0);
            this.mmH.setVisibility(8);
            this.ewr.setVisibility(8);
            if (PluginPackageManager.pT().cD(this.dkt)) {
                this.hvZ.setText(R.string.plugin_unenabled);
                this.mmG.setText(R.string.plugin_enable);
                ap.setBackgroundResource(this.mmG, R.drawable.selector_blue_gradient_button);
                this.mmJ.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.hvZ.setText(R.string.plugin_enabled);
            this.mmG.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.mmI != null && this.mmI.can_forbidden == 1) {
                this.mmG.setEnabled(false);
                this.mmG.setVisibility(8);
                this.mmJ.setShadowColor(0);
                return;
            }
            this.mmG.setEnabled(true);
            this.mmG.setVisibility(0);
            ap.setBackgroundResource(this.mmG, R.drawable.button_plugin_forbidden);
            this.mmJ.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.mmG.setVisibility(0);
            this.hvZ.setText(R.string.plugin_disabled);
            this.mmG.setText(R.string.install_app);
            this.mmG.setEnabled(true);
            ap.setBackgroundResource(this.mmG, R.drawable.selector_blue_gradient_button);
            this.mmJ.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.mmG, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.mmH.setVisibility(8);
            this.ewr.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mmH.setProgressDrawable(ap.getDrawable(R.drawable.download_progressbar));
        this.mmH.setIndeterminateDrawable(ap.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mmG) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                dxR();
            } else if (this.mStatus == 3) {
                PluginPackageManager.pT().cA(this.dkt);
                dxQ();
            } else if (this.mStatus == 2) {
                PluginPackageManager.pT().cB(this.dkt);
                dxQ();
            }
        }
    }

    private void dxR() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            dxS();
        } else if (this.mmI != null && !TextUtils.isEmpty(this.mmI.package_name) && !PluginPackageManager.pT().cG(this.mmI.package_name)) {
            this.mmG.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.pT().a(this.mmI, this.TI);
        }
    }

    private void dxS() {
        String string;
        String string2;
        if (this.mmI != null && this.mmI.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.mmI.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.Bo(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ap.setViewTextColor(PluginDetailActivity.this.mmG, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.mmG.setEnabled(false);
                    PluginPackageManager.pT().a(PluginDetailActivity.this.mmI, PluginDetailActivity.this.TI);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.bpc();
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

    private int a(PluginNetConfigInfos.PluginConfig pluginConfig) {
        PluginSetting findPluginSetting;
        if (pluginConfig == null || (findPluginSetting = c.qv().findPluginSetting(pluginConfig.package_name)) == null) {
            return 0;
        }
        String f = Util.f(findPluginSetting);
        if (at.isEmpty(f)) {
            return 0;
        }
        try {
            File file = new File(f + ".tmp");
            if (!file.exists() || findPluginSetting.size <= 0) {
                return 0;
            }
            return (int) (((file.length() * 1.0d) / findPluginSetting.size) * 100.0d);
        } catch (Exception e) {
            BdLog.e(e);
            return 0;
        }
    }
}
