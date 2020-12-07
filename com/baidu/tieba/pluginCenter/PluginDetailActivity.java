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
/* loaded from: classes21.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String dpL;
    private TextView eBK;
    private TextView hFj;
    private HeadImageView mBa;
    private TextView mBb;
    private TextView mBc;
    private TextView mBd;
    private ProgressBar mBe;
    private PluginNetConfigInfos.PluginConfig mBf;
    private ShadowLayout mBh;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d UC = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mBf != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mBf.package_name) && !PluginDetailActivity.this.mFinished) {
                ap.setViewTextColor(PluginDetailActivity.this.mBd, R.color.CAM_X0109, 1);
                PluginDetailActivity.this.mBh.setShadowColor(0);
                PluginDetailActivity.this.mBd.setEnabled(false);
                PluginDetailActivity.this.mBd.setVisibility(8);
                PluginDetailActivity.this.mBe.setVisibility(0);
                PluginDetailActivity.this.eBK.setVisibility(0);
                PluginDetailActivity.this.mBe.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mBf != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mBf.package_name)) {
                PluginDetailActivity.this.mBd.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.mBd.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mBf != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mBf.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.dCH();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.dCH();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.dCH();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.dCH();
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
        this.mBa = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.hFj = (TextView) findViewById(R.id.status);
        this.mBe = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.eBK = (TextView) findViewById(R.id.plugin_download_text);
        this.mBb = (TextView) findViewById(R.id.changelog);
        this.mBc = (TextView) findViewById(R.id.size);
        this.mBd = (TextView) findViewById(R.id.enable);
        this.mBd.setOnClickListener(this);
        this.mBh = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.dpL = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qr().qs() != null) {
            this.mBf = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qr().qs().getPluginConfig(this.dpL);
        }
        if (PluginPackageManager.pV().cL(this.dpL)) {
            PluginPackageManager.pV().a(this.UC);
            ap.setViewTextColor(this.mBd, R.color.CAM_X0109, 1);
            this.mBd.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mBf != null) {
            this.mBa.startLoad(this.mBf.icon, 10, false);
            if (this.mBf.display_name == null) {
                this.mBf.display_name = "";
            }
            this.mName.setText(this.mBf.display_name);
            dCH();
            if (this.mBf.newest != null) {
                if (TextUtils.isEmpty(this.mBf.newest.change_log)) {
                    this.mBb.setText("");
                } else {
                    this.mBb.setText(this.mBf.newest.change_log);
                }
                if (this.mBf.newest.size <= 0) {
                    this.mBc.setText("");
                } else {
                    this.mBc.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.mBf.newest.size / 1024) + "KB");
                }
            }
            this.mBd.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a2;
        super.onResume();
        if (this.mBe != null && PluginPackageManager.pV().cL(this.dpL) && (a2 = a(this.mBf)) < 100) {
            ap.setViewTextColor(this.mBd, R.color.CAM_X0109, 1);
            this.mBh.setShadowColor(0);
            this.mBd.setEnabled(false);
            this.mBd.setVisibility(8);
            this.mBe.setVisibility(0);
            this.eBK.setVisibility(0);
            this.mBe.setProgress(a2);
        }
        PluginPackageManager.pV().a(this.UC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.pV().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCH() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.pV().cJ(this.dpL) && PluginPackageManager.pV().cH(this.dpL)) {
            this.hFj.setText(R.string.plugin_enabled);
            this.mBd.setVisibility(0);
            this.mBd.setText(R.string.download_update);
            this.mBd.setEnabled(true);
            ap.setBackgroundResource(this.mBd, R.drawable.selector_blue_gradient_button);
            this.mBh.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.mBd, R.color.CAM_X0111, 1);
            this.mBe.setVisibility(8);
            this.eBK.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.pV().cH(this.dpL)) {
            this.mBd.setEnabled(true);
            ap.setViewTextColor(this.mBd, R.color.CAM_X0111, 1);
            this.mBd.setVisibility(0);
            this.mBe.setVisibility(8);
            this.eBK.setVisibility(8);
            if (PluginPackageManager.pV().cI(this.dpL)) {
                this.hFj.setText(R.string.plugin_unenabled);
                this.mBd.setText(R.string.plugin_enable);
                ap.setBackgroundResource(this.mBd, R.drawable.selector_blue_gradient_button);
                this.mBh.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.hFj.setText(R.string.plugin_enabled);
            this.mBd.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.mBf != null && this.mBf.can_forbidden == 1) {
                this.mBd.setEnabled(false);
                this.mBd.setVisibility(8);
                this.mBh.setShadowColor(0);
                return;
            }
            this.mBd.setEnabled(true);
            this.mBd.setVisibility(0);
            ap.setBackgroundResource(this.mBd, R.drawable.button_plugin_forbidden);
            this.mBh.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.mBd.setVisibility(0);
            this.hFj.setText(R.string.plugin_disabled);
            this.mBd.setText(R.string.install_app);
            this.mBd.setEnabled(true);
            ap.setBackgroundResource(this.mBd, R.drawable.selector_blue_gradient_button);
            this.mBh.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.mBd, R.color.CAM_X0111, 1);
            this.mStatus = 0;
            this.mBe.setVisibility(8);
            this.eBK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mBe.setProgressDrawable(ap.getDrawable(R.drawable.download_progressbar));
        this.mBe.setIndeterminateDrawable(ap.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mBd) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                dCI();
            } else if (this.mStatus == 3) {
                PluginPackageManager.pV().cF(this.dpL);
                dCH();
            } else if (this.mStatus == 2) {
                PluginPackageManager.pV().cG(this.dpL);
                dCH();
            }
        }
    }

    private void dCI() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            dCJ();
        } else if (this.mBf != null && !TextUtils.isEmpty(this.mBf.package_name) && !PluginPackageManager.pV().cL(this.mBf.package_name)) {
            this.mBd.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.pV().a(this.mBf, this.UC);
        }
    }

    private void dCJ() {
        String string;
        String string2;
        if (this.mBf != null && this.mBf.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.mBf.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.Bq(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ap.setViewTextColor(PluginDetailActivity.this.mBd, R.color.CAM_X0109, 1);
                    PluginDetailActivity.this.mBd.setEnabled(false);
                    PluginPackageManager.pV().a(PluginDetailActivity.this.mBf, PluginDetailActivity.this.UC);
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
            aVar.brv();
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
        if (pluginConfig == null || (findPluginSetting = c.qx().findPluginSetting(pluginConfig.package_name)) == null) {
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
