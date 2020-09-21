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
/* loaded from: classes20.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String cJU;
    private TextView dVY;
    private TextView gPi;
    private HeadImageView lES;
    private TextView lET;
    private TextView lEU;
    private TextView lEV;
    private ProgressBar lEW;
    private PluginNetConfigInfos.PluginConfig lEX;
    private ShadowLayout lEY;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Tq = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.lEX != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.lEX.package_name) && !PluginDetailActivity.this.mFinished) {
                ap.setViewTextColor(PluginDetailActivity.this.lEV, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.lEY.setShadowColor(0);
                PluginDetailActivity.this.lEV.setEnabled(false);
                PluginDetailActivity.this.lEV.setVisibility(8);
                PluginDetailActivity.this.lEW.setVisibility(0);
                PluginDetailActivity.this.dVY.setVisibility(0);
                PluginDetailActivity.this.lEW.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.lEX != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.lEX.package_name)) {
                PluginDetailActivity.this.lEV.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.lEV.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.lEX != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.lEX.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.dow();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.dow();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.dow();
        }
    };
    private final CustomMessageListener dWI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.dow();
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
        this.lES = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.gPi = (TextView) findViewById(R.id.status);
        this.lEW = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.dVY = (TextView) findViewById(R.id.plugin_download_text);
        this.lET = (TextView) findViewById(R.id.changelog);
        this.lEU = (TextView) findViewById(R.id.size);
        this.lEV = (TextView) findViewById(R.id.enable);
        this.lEV.setOnClickListener(this);
        this.lEY = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.cJU = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qp().qq() != null) {
            this.lEX = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qp().qq().getPluginConfig(this.cJU);
        }
        if (PluginPackageManager.pT().cG(this.cJU)) {
            PluginPackageManager.pT().a(this.Tq);
            ap.setViewTextColor(this.lEV, R.color.cp_cont_d, 1);
            this.lEV.setEnabled(false);
        }
        registerListener(this.dWI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.lEX != null) {
            this.lES.startLoad(this.lEX.icon, 10, false);
            if (this.lEX.display_name == null) {
                this.lEX.display_name = "";
            }
            this.mName.setText(this.lEX.display_name);
            dow();
            if (this.lEX.newest != null) {
                if (TextUtils.isEmpty(this.lEX.newest.change_log)) {
                    this.lET.setText("");
                } else {
                    this.lET.setText(this.lEX.newest.change_log);
                }
                if (this.lEX.newest.size <= 0) {
                    this.lEU.setText("");
                } else {
                    this.lEU.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.lEX.newest.size / 1024) + "KB");
                }
            }
            this.lEV.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a;
        super.onResume();
        if (this.lEW != null && PluginPackageManager.pT().cG(this.cJU) && (a = a(this.lEX)) < 100) {
            ap.setViewTextColor(this.lEV, R.color.cp_cont_d, 1);
            this.lEY.setShadowColor(0);
            this.lEV.setEnabled(false);
            this.lEV.setVisibility(8);
            this.lEW.setVisibility(0);
            this.dVY.setVisibility(0);
            this.lEW.setProgress(a);
        }
        PluginPackageManager.pT().a(this.Tq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.pT().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dow() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.pT().cE(this.cJU) && PluginPackageManager.pT().cC(this.cJU)) {
            this.gPi.setText(R.string.plugin_enabled);
            this.lEV.setVisibility(0);
            this.lEV.setText(R.string.download_update);
            this.lEV.setEnabled(true);
            ap.setBackgroundResource(this.lEV, R.drawable.selector_blue_gradient_button);
            this.lEY.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.lEV, R.color.cp_cont_g, 1);
            this.lEW.setVisibility(8);
            this.dVY.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.pT().cC(this.cJU)) {
            this.lEV.setEnabled(true);
            ap.setViewTextColor(this.lEV, R.color.cp_cont_g, 1);
            this.lEV.setVisibility(0);
            this.lEW.setVisibility(8);
            this.dVY.setVisibility(8);
            if (PluginPackageManager.pT().cD(this.cJU)) {
                this.gPi.setText(R.string.plugin_unenabled);
                this.lEV.setText(R.string.plugin_enable);
                ap.setBackgroundResource(this.lEV, R.drawable.selector_blue_gradient_button);
                this.lEY.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.gPi.setText(R.string.plugin_enabled);
            this.lEV.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.lEX != null && this.lEX.can_forbidden == 1) {
                this.lEV.setEnabled(false);
                this.lEV.setVisibility(8);
                this.lEY.setShadowColor(0);
                return;
            }
            this.lEV.setEnabled(true);
            this.lEV.setVisibility(0);
            ap.setBackgroundResource(this.lEV, R.drawable.button_plugin_forbidden);
            this.lEY.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.lEV.setVisibility(0);
            this.gPi.setText(R.string.plugin_disabled);
            this.lEV.setText(R.string.install_app);
            this.lEV.setEnabled(true);
            ap.setBackgroundResource(this.lEV, R.drawable.selector_blue_gradient_button);
            this.lEY.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.lEV, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.lEW.setVisibility(8);
            this.dVY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lEW.setProgressDrawable(ap.getDrawable(R.drawable.download_progressbar));
        this.lEW.setIndeterminateDrawable(ap.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lEV) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                dox();
            } else if (this.mStatus == 3) {
                PluginPackageManager.pT().cA(this.cJU);
                dow();
            } else if (this.mStatus == 2) {
                PluginPackageManager.pT().cB(this.cJU);
                dow();
            }
        }
    }

    private void dox() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            doy();
        } else if (this.lEX != null && !TextUtils.isEmpty(this.lEX.package_name) && !PluginPackageManager.pT().cG(this.lEX.package_name)) {
            this.lEV.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.pT().a(this.lEX, this.Tq);
        }
    }

    private void doy() {
        String string;
        String string2;
        if (this.lEX != null && this.lEX.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.lEX.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.zV(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ap.setViewTextColor(PluginDetailActivity.this.lEV, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.lEV.setEnabled(false);
                    PluginPackageManager.pT().a(PluginDetailActivity.this.lEX, PluginDetailActivity.this.Tq);
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
            aVar.bia();
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
