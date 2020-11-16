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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugin.ShadowLayout;
import com.baidu.tieba.R;
import java.io.File;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes20.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String diM;
    private TextView euI;
    private TextView hvG;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private HeadImageView mmX;
    private TextView mmY;
    private TextView mmZ;
    private TextView mna;
    private ProgressBar mnb;
    private PluginNetConfigInfos.PluginConfig mnc;
    private ShadowLayout mnd;
    private d TJ = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mnc != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mnc.package_name) && !PluginDetailActivity.this.mFinished) {
                ap.setViewTextColor(PluginDetailActivity.this.mna, R.color.CAM_X0109, 1);
                PluginDetailActivity.this.mnd.setShadowColor(0);
                PluginDetailActivity.this.mna.setEnabled(false);
                PluginDetailActivity.this.mna.setVisibility(8);
                PluginDetailActivity.this.mnb.setVisibility(0);
                PluginDetailActivity.this.euI.setVisibility(0);
                PluginDetailActivity.this.mnb.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mnc != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mnc.package_name)) {
                PluginDetailActivity.this.mna.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.mna.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mnc != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mnc.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.dxq();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.dxq();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.dxq();
        }
    };
    private final CustomMessageListener evs = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.dxq();
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
        this.mmX = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.hvG = (TextView) findViewById(R.id.status);
        this.mnb = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.euI = (TextView) findViewById(R.id.plugin_download_text);
        this.mmY = (TextView) findViewById(R.id.changelog);
        this.mmZ = (TextView) findViewById(R.id.size);
        this.mna = (TextView) findViewById(R.id.enable);
        this.mna.setOnClickListener(this);
        this.mnd = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.diM = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qp().qq() != null) {
            this.mnc = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qp().qq().getPluginConfig(this.diM);
        }
        if (PluginPackageManager.pT().cI(this.diM)) {
            PluginPackageManager.pT().a(this.TJ);
            ap.setViewTextColor(this.mna, R.color.CAM_X0109, 1);
            this.mna.setEnabled(false);
        }
        registerListener(this.evs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mnc != null) {
            this.mmX.startLoad(this.mnc.icon, 10, false);
            if (this.mnc.display_name == null) {
                this.mnc.display_name = "";
            }
            this.mName.setText(this.mnc.display_name);
            dxq();
            if (this.mnc.newest != null) {
                if (TextUtils.isEmpty(this.mnc.newest.change_log)) {
                    this.mmY.setText("");
                } else {
                    this.mmY.setText(this.mnc.newest.change_log);
                }
                if (this.mnc.newest.size <= 0) {
                    this.mmZ.setText("");
                } else {
                    this.mmZ.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.mnc.newest.size / 1024) + "KB");
                }
            }
            this.mna.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a2;
        super.onResume();
        if (this.mnb != null && PluginPackageManager.pT().cI(this.diM) && (a2 = a(this.mnc)) < 100) {
            ap.setViewTextColor(this.mna, R.color.CAM_X0109, 1);
            this.mnd.setShadowColor(0);
            this.mna.setEnabled(false);
            this.mna.setVisibility(8);
            this.mnb.setVisibility(0);
            this.euI.setVisibility(0);
            this.mnb.setProgress(a2);
        }
        PluginPackageManager.pT().a(this.TJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.pT().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxq() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.pT().cG(this.diM) && PluginPackageManager.pT().cE(this.diM)) {
            this.hvG.setText(R.string.plugin_enabled);
            this.mna.setVisibility(0);
            this.mna.setText(R.string.download_update);
            this.mna.setEnabled(true);
            ap.setBackgroundResource(this.mna, R.drawable.selector_blue_gradient_button);
            this.mnd.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.mna, R.color.CAM_X0111, 1);
            this.mnb.setVisibility(8);
            this.euI.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.pT().cE(this.diM)) {
            this.mna.setEnabled(true);
            ap.setViewTextColor(this.mna, R.color.CAM_X0111, 1);
            this.mna.setVisibility(0);
            this.mnb.setVisibility(8);
            this.euI.setVisibility(8);
            if (PluginPackageManager.pT().cF(this.diM)) {
                this.hvG.setText(R.string.plugin_unenabled);
                this.mna.setText(R.string.plugin_enable);
                ap.setBackgroundResource(this.mna, R.drawable.selector_blue_gradient_button);
                this.mnd.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.hvG.setText(R.string.plugin_enabled);
            this.mna.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.mnc != null && this.mnc.can_forbidden == 1) {
                this.mna.setEnabled(false);
                this.mna.setVisibility(8);
                this.mnd.setShadowColor(0);
                return;
            }
            this.mna.setEnabled(true);
            this.mna.setVisibility(0);
            ap.setBackgroundResource(this.mna, R.drawable.button_plugin_forbidden);
            this.mnd.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.mna.setVisibility(0);
            this.hvG.setText(R.string.plugin_disabled);
            this.mna.setText(R.string.install_app);
            this.mna.setEnabled(true);
            ap.setBackgroundResource(this.mna, R.drawable.selector_blue_gradient_button);
            this.mnd.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.mna, R.color.CAM_X0111, 1);
            this.mStatus = 0;
            this.mnb.setVisibility(8);
            this.euI.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mnb.setProgressDrawable(ap.getDrawable(R.drawable.download_progressbar));
        this.mnb.setIndeterminateDrawable(ap.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mna) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                dxr();
            } else if (this.mStatus == 3) {
                PluginPackageManager.pT().cC(this.diM);
                dxq();
            } else if (this.mStatus == 2) {
                PluginPackageManager.pT().cD(this.diM);
                dxq();
            }
        }
    }

    private void dxr() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            dxs();
        } else if (this.mnc != null && !TextUtils.isEmpty(this.mnc.package_name) && !PluginPackageManager.pT().cI(this.mnc.package_name)) {
            this.mna.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.pT().a(this.mnc, this.TJ);
        }
    }

    private void dxs() {
        String string;
        String string2;
        if (this.mnc != null && this.mnc.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.mnc.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.AJ(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ap.setViewTextColor(PluginDetailActivity.this.mna, R.color.CAM_X0109, 1);
                    PluginDetailActivity.this.mna.setEnabled(false);
                    PluginPackageManager.pT().a(PluginDetailActivity.this.mnc, PluginDetailActivity.this.TJ);
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
            aVar.bog();
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
        if (au.isEmpty(f)) {
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
