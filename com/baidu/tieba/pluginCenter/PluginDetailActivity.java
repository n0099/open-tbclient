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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugin.ShadowLayout;
import com.baidu.tieba.R;
import java.io.File;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String duK;
    private TextView eLn;
    private TextView hRl;
    private boolean mFinished;
    private HeadImageView mGt;
    private TextView mGu;
    private TextView mGv;
    private TextView mGw;
    private ProgressBar mGx;
    private PluginNetConfigInfos.PluginConfig mGy;
    private ShadowLayout mGz;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d UE = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mGy != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mGy.package_name) && !PluginDetailActivity.this.mFinished) {
                ao.setViewTextColor(PluginDetailActivity.this.mGw, R.color.CAM_X0109, 1);
                PluginDetailActivity.this.mGz.setShadowColor(0);
                PluginDetailActivity.this.mGw.setEnabled(false);
                PluginDetailActivity.this.mGw.setVisibility(8);
                PluginDetailActivity.this.mGx.setVisibility(0);
                PluginDetailActivity.this.eLn.setVisibility(0);
                PluginDetailActivity.this.mGx.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mGy != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mGy.package_name)) {
                PluginDetailActivity.this.mGw.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.mGw.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mGy != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mGy.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.dCy();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.dCy();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.dCy();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.dCy();
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
        this.mGt = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.hRl = (TextView) findViewById(R.id.status);
        this.mGx = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.eLn = (TextView) findViewById(R.id.plugin_download_text);
        this.mGu = (TextView) findViewById(R.id.changelog);
        this.mGv = (TextView) findViewById(R.id.size);
        this.mGw = (TextView) findViewById(R.id.enable);
        this.mGw.setOnClickListener(this);
        this.mGz = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.duK = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pT().pU() != null) {
            this.mGy = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pT().pU().getPluginConfig(this.duK);
        }
        if (PluginPackageManager.px().cE(this.duK)) {
            PluginPackageManager.px().a(this.UE);
            ao.setViewTextColor(this.mGw, R.color.CAM_X0109, 1);
            this.mGw.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mGy != null) {
            this.mGt.startLoad(this.mGy.icon, 10, false);
            if (this.mGy.display_name == null) {
                this.mGy.display_name = "";
            }
            this.mName.setText(this.mGy.display_name);
            dCy();
            if (this.mGy.newest != null) {
                if (TextUtils.isEmpty(this.mGy.newest.change_log)) {
                    this.mGu.setText("");
                } else {
                    this.mGu.setText(this.mGy.newest.change_log);
                }
                if (this.mGy.newest.size <= 0) {
                    this.mGv.setText("");
                } else {
                    this.mGv.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.mGy.newest.size / 1024) + "KB");
                }
            }
            this.mGw.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a2;
        super.onResume();
        if (this.mGx != null && PluginPackageManager.px().cE(this.duK) && (a2 = a(this.mGy)) < 100) {
            ao.setViewTextColor(this.mGw, R.color.CAM_X0109, 1);
            this.mGz.setShadowColor(0);
            this.mGw.setEnabled(false);
            this.mGw.setVisibility(8);
            this.mGx.setVisibility(0);
            this.eLn.setVisibility(0);
            this.mGx.setProgress(a2);
        }
        PluginPackageManager.px().a(this.UE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.px().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCy() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.px().cC(this.duK) && PluginPackageManager.px().cA(this.duK)) {
            this.hRl.setText(R.string.plugin_enabled);
            this.mGw.setVisibility(0);
            this.mGw.setText(R.string.download_update);
            this.mGw.setEnabled(true);
            ao.setBackgroundResource(this.mGw, R.drawable.selector_blue_gradient_button);
            this.mGz.setShadowColor(R.color.plugin_button_shadow_blue);
            ao.setViewTextColor(this.mGw, R.color.CAM_X0111, 1);
            this.mGx.setVisibility(8);
            this.eLn.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.px().cA(this.duK)) {
            this.mGw.setEnabled(true);
            ao.setViewTextColor(this.mGw, R.color.CAM_X0111, 1);
            this.mGw.setVisibility(0);
            this.mGx.setVisibility(8);
            this.eLn.setVisibility(8);
            if (PluginPackageManager.px().cB(this.duK)) {
                this.hRl.setText(R.string.plugin_unenabled);
                this.mGw.setText(R.string.plugin_enable);
                ao.setBackgroundResource(this.mGw, R.drawable.selector_blue_gradient_button);
                this.mGz.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.hRl.setText(R.string.plugin_enabled);
            this.mGw.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.mGy != null && this.mGy.can_forbidden == 1) {
                this.mGw.setEnabled(false);
                this.mGw.setVisibility(8);
                this.mGz.setShadowColor(0);
                return;
            }
            this.mGw.setEnabled(true);
            this.mGw.setVisibility(0);
            ao.setBackgroundResource(this.mGw, R.drawable.button_plugin_forbidden);
            this.mGz.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.mGw.setVisibility(0);
            this.hRl.setText(R.string.plugin_disabled);
            this.mGw.setText(R.string.install_app);
            this.mGw.setEnabled(true);
            ao.setBackgroundResource(this.mGw, R.drawable.selector_blue_gradient_button);
            this.mGz.setShadowColor(R.color.plugin_button_shadow_blue);
            ao.setViewTextColor(this.mGw, R.color.CAM_X0111, 1);
            this.mStatus = 0;
            this.mGx.setVisibility(8);
            this.eLn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mGx.setProgressDrawable(ao.getDrawable(R.drawable.download_progressbar));
        this.mGx.setIndeterminateDrawable(ao.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mGw) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                dCz();
            } else if (this.mStatus == 3) {
                PluginPackageManager.px().cy(this.duK);
                dCy();
            } else if (this.mStatus == 2) {
                PluginPackageManager.px().cz(this.duK);
                dCy();
            }
        }
    }

    private void dCz() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            dCA();
        } else if (this.mGy != null && !TextUtils.isEmpty(this.mGy.package_name) && !PluginPackageManager.px().cE(this.mGy.package_name)) {
            this.mGw.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.px().a(this.mGy, this.UE);
        }
    }

    private void dCA() {
        String string;
        String string2;
        if (this.mGy != null && this.mGy.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.mGy.newest.size / 1048576.0f;
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
                    ao.setViewTextColor(PluginDetailActivity.this.mGw, R.color.CAM_X0109, 1);
                    PluginDetailActivity.this.mGw.setEnabled(false);
                    PluginPackageManager.px().a(PluginDetailActivity.this.mGy, PluginDetailActivity.this.UE);
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
            aVar.btY();
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
        if (pluginConfig == null || (findPluginSetting = c.pZ().findPluginSetting(pluginConfig.package_name)) == null) {
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
