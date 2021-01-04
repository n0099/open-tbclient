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
    private ShadowLayout mGA;
    private HeadImageView mGu;
    private TextView mGv;
    private TextView mGw;
    private TextView mGx;
    private ProgressBar mGy;
    private PluginNetConfigInfos.PluginConfig mGz;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d UE = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mGz != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mGz.package_name) && !PluginDetailActivity.this.mFinished) {
                ao.setViewTextColor(PluginDetailActivity.this.mGx, R.color.CAM_X0109, 1);
                PluginDetailActivity.this.mGA.setShadowColor(0);
                PluginDetailActivity.this.mGx.setEnabled(false);
                PluginDetailActivity.this.mGx.setVisibility(8);
                PluginDetailActivity.this.mGy.setVisibility(0);
                PluginDetailActivity.this.eLn.setVisibility(0);
                PluginDetailActivity.this.mGy.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mGz != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mGz.package_name)) {
                PluginDetailActivity.this.mGx.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.mGx.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mGz != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mGz.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.dCx();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.dCx();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.dCx();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.dCx();
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
        this.mGu = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.hRl = (TextView) findViewById(R.id.status);
        this.mGy = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.eLn = (TextView) findViewById(R.id.plugin_download_text);
        this.mGv = (TextView) findViewById(R.id.changelog);
        this.mGw = (TextView) findViewById(R.id.size);
        this.mGx = (TextView) findViewById(R.id.enable);
        this.mGx.setOnClickListener(this);
        this.mGA = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.duK = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pT().pU() != null) {
            this.mGz = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pT().pU().getPluginConfig(this.duK);
        }
        if (PluginPackageManager.px().cE(this.duK)) {
            PluginPackageManager.px().a(this.UE);
            ao.setViewTextColor(this.mGx, R.color.CAM_X0109, 1);
            this.mGx.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mGz != null) {
            this.mGu.startLoad(this.mGz.icon, 10, false);
            if (this.mGz.display_name == null) {
                this.mGz.display_name = "";
            }
            this.mName.setText(this.mGz.display_name);
            dCx();
            if (this.mGz.newest != null) {
                if (TextUtils.isEmpty(this.mGz.newest.change_log)) {
                    this.mGv.setText("");
                } else {
                    this.mGv.setText(this.mGz.newest.change_log);
                }
                if (this.mGz.newest.size <= 0) {
                    this.mGw.setText("");
                } else {
                    this.mGw.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.mGz.newest.size / 1024) + "KB");
                }
            }
            this.mGx.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a2;
        super.onResume();
        if (this.mGy != null && PluginPackageManager.px().cE(this.duK) && (a2 = a(this.mGz)) < 100) {
            ao.setViewTextColor(this.mGx, R.color.CAM_X0109, 1);
            this.mGA.setShadowColor(0);
            this.mGx.setEnabled(false);
            this.mGx.setVisibility(8);
            this.mGy.setVisibility(0);
            this.eLn.setVisibility(0);
            this.mGy.setProgress(a2);
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
    public void dCx() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.px().cC(this.duK) && PluginPackageManager.px().cA(this.duK)) {
            this.hRl.setText(R.string.plugin_enabled);
            this.mGx.setVisibility(0);
            this.mGx.setText(R.string.download_update);
            this.mGx.setEnabled(true);
            ao.setBackgroundResource(this.mGx, R.drawable.selector_blue_gradient_button);
            this.mGA.setShadowColor(R.color.plugin_button_shadow_blue);
            ao.setViewTextColor(this.mGx, R.color.CAM_X0111, 1);
            this.mGy.setVisibility(8);
            this.eLn.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.px().cA(this.duK)) {
            this.mGx.setEnabled(true);
            ao.setViewTextColor(this.mGx, R.color.CAM_X0111, 1);
            this.mGx.setVisibility(0);
            this.mGy.setVisibility(8);
            this.eLn.setVisibility(8);
            if (PluginPackageManager.px().cB(this.duK)) {
                this.hRl.setText(R.string.plugin_unenabled);
                this.mGx.setText(R.string.plugin_enable);
                ao.setBackgroundResource(this.mGx, R.drawable.selector_blue_gradient_button);
                this.mGA.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.hRl.setText(R.string.plugin_enabled);
            this.mGx.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.mGz != null && this.mGz.can_forbidden == 1) {
                this.mGx.setEnabled(false);
                this.mGx.setVisibility(8);
                this.mGA.setShadowColor(0);
                return;
            }
            this.mGx.setEnabled(true);
            this.mGx.setVisibility(0);
            ao.setBackgroundResource(this.mGx, R.drawable.button_plugin_forbidden);
            this.mGA.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.mGx.setVisibility(0);
            this.hRl.setText(R.string.plugin_disabled);
            this.mGx.setText(R.string.install_app);
            this.mGx.setEnabled(true);
            ao.setBackgroundResource(this.mGx, R.drawable.selector_blue_gradient_button);
            this.mGA.setShadowColor(R.color.plugin_button_shadow_blue);
            ao.setViewTextColor(this.mGx, R.color.CAM_X0111, 1);
            this.mStatus = 0;
            this.mGy.setVisibility(8);
            this.eLn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mGy.setProgressDrawable(ao.getDrawable(R.drawable.download_progressbar));
        this.mGy.setIndeterminateDrawable(ao.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mGx) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                dCy();
            } else if (this.mStatus == 3) {
                PluginPackageManager.px().cy(this.duK);
                dCx();
            } else if (this.mStatus == 2) {
                PluginPackageManager.px().cz(this.duK);
                dCx();
            }
        }
    }

    private void dCy() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            dCz();
        } else if (this.mGz != null && !TextUtils.isEmpty(this.mGz.package_name) && !PluginPackageManager.px().cE(this.mGz.package_name)) {
            this.mGx.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.px().a(this.mGz, this.UE);
        }
    }

    private void dCz() {
        String string;
        String string2;
        if (this.mGz != null && this.mGz.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.mGz.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.Bp(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ao.setViewTextColor(PluginDetailActivity.this.mGx, R.color.CAM_X0109, 1);
                    PluginDetailActivity.this.mGx.setEnabled(false);
                    PluginPackageManager.px().a(PluginDetailActivity.this.mGz, PluginDetailActivity.this.UE);
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
            aVar.btX();
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
