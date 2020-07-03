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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugin.ShadowLayout;
import com.baidu.tieba.R;
import java.io.File;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String cxh;
    private TextView dEF;
    private TextView gtT;
    private HeadImageView kYb;
    private TextView kYc;
    private TextView kYd;
    private TextView kYe;
    private ProgressBar kYf;
    private PluginNetConfigInfos.PluginConfig kYg;
    private ShadowLayout kYh;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Sv = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.kYg != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.kYg.package_name) && !PluginDetailActivity.this.mFinished) {
                an.setViewTextColor(PluginDetailActivity.this.kYe, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.kYh.setShadowColor(0);
                PluginDetailActivity.this.kYe.setEnabled(false);
                PluginDetailActivity.this.kYe.setVisibility(8);
                PluginDetailActivity.this.kYf.setVisibility(0);
                PluginDetailActivity.this.dEF.setVisibility(0);
                PluginDetailActivity.this.kYf.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.kYg != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.kYg.package_name)) {
                PluginDetailActivity.this.kYe.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.kYe.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.kYg != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.kYg.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.cWB();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.cWB();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.cWB();
        }
    };
    private final CustomMessageListener dFp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.cWB();
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
        this.kYb = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.gtT = (TextView) findViewById(R.id.status);
        this.kYf = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.dEF = (TextView) findViewById(R.id.plugin_download_text);
        this.kYc = (TextView) findViewById(R.id.changelog);
        this.kYd = (TextView) findViewById(R.id.size);
        this.kYe = (TextView) findViewById(R.id.enable);
        this.kYe.setOnClickListener(this);
        this.kYh = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.cxh = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.oK().oL() != null) {
            this.kYg = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.oK().oL().getPluginConfig(this.cxh);
        }
        if (PluginPackageManager.oo().cA(this.cxh)) {
            PluginPackageManager.oo().a(this.Sv);
            an.setViewTextColor(this.kYe, R.color.cp_cont_d, 1);
            this.kYe.setEnabled(false);
        }
        registerListener(this.dFp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.kYg != null) {
            this.kYb.startLoad(this.kYg.icon, 10, false);
            if (this.kYg.display_name == null) {
                this.kYg.display_name = "";
            }
            this.mName.setText(this.kYg.display_name);
            cWB();
            if (this.kYg.newest != null) {
                if (TextUtils.isEmpty(this.kYg.newest.change_log)) {
                    this.kYc.setText("");
                } else {
                    this.kYc.setText(this.kYg.newest.change_log);
                }
                if (this.kYg.newest.size <= 0) {
                    this.kYd.setText("");
                } else {
                    this.kYd.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.kYg.newest.size / 1024) + "KB");
                }
            }
            this.kYe.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a;
        super.onResume();
        if (this.kYf != null && PluginPackageManager.oo().cA(this.cxh) && (a = a(this.kYg)) < 100) {
            an.setViewTextColor(this.kYe, R.color.cp_cont_d, 1);
            this.kYh.setShadowColor(0);
            this.kYe.setEnabled(false);
            this.kYe.setVisibility(8);
            this.kYf.setVisibility(0);
            this.dEF.setVisibility(0);
            this.kYf.setProgress(a);
        }
        PluginPackageManager.oo().a(this.Sv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.oo().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWB() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.oo().cy(this.cxh) && PluginPackageManager.oo().cw(this.cxh)) {
            this.gtT.setText(R.string.plugin_enabled);
            this.kYe.setVisibility(0);
            this.kYe.setText(R.string.download_update);
            this.kYe.setEnabled(true);
            an.setBackgroundResource(this.kYe, R.drawable.selector_blue_gradient_button);
            this.kYh.setShadowColor(R.color.plugin_button_shadow_blue);
            an.setViewTextColor(this.kYe, R.color.cp_cont_g, 1);
            this.kYf.setVisibility(8);
            this.dEF.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.oo().cw(this.cxh)) {
            this.kYe.setEnabled(true);
            an.setViewTextColor(this.kYe, R.color.cp_cont_g, 1);
            this.kYe.setVisibility(0);
            this.kYf.setVisibility(8);
            this.dEF.setVisibility(8);
            if (PluginPackageManager.oo().cx(this.cxh)) {
                this.gtT.setText(R.string.plugin_unenabled);
                this.kYe.setText(R.string.plugin_enable);
                an.setBackgroundResource(this.kYe, R.drawable.selector_blue_gradient_button);
                this.kYh.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.gtT.setText(R.string.plugin_enabled);
            this.kYe.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.kYg != null && this.kYg.can_forbidden == 1) {
                this.kYe.setEnabled(false);
                this.kYe.setVisibility(8);
                this.kYh.setShadowColor(0);
                return;
            }
            this.kYe.setEnabled(true);
            this.kYe.setVisibility(0);
            an.setBackgroundResource(this.kYe, R.drawable.button_plugin_forbidden);
            this.kYh.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.kYe.setVisibility(0);
            this.gtT.setText(R.string.plugin_disabled);
            this.kYe.setText(R.string.install_app);
            this.kYe.setEnabled(true);
            an.setBackgroundResource(this.kYe, R.drawable.selector_blue_gradient_button);
            this.kYh.setShadowColor(R.color.plugin_button_shadow_blue);
            an.setViewTextColor(this.kYe, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.kYf.setVisibility(8);
            this.dEF.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kYf.setProgressDrawable(an.getDrawable(R.drawable.download_progressbar));
        this.kYf.setIndeterminateDrawable(an.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kYe) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                cWC();
            } else if (this.mStatus == 3) {
                PluginPackageManager.oo().cu(this.cxh);
                cWB();
            } else if (this.mStatus == 2) {
                PluginPackageManager.oo().cv(this.cxh);
                cWB();
            }
        }
    }

    private void cWC() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            cWD();
        } else if (this.kYg != null && !TextUtils.isEmpty(this.kYg.package_name) && !PluginPackageManager.oo().cA(this.kYg.package_name)) {
            this.kYe.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.oo().a(this.kYg, this.Sv);
        }
    }

    private void cWD() {
        String string;
        String string2;
        if (this.kYg != null && this.kYg.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.kYg.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.we(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    an.setViewTextColor(PluginDetailActivity.this.kYe, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.kYe.setEnabled(false);
                    PluginPackageManager.oo().a(PluginDetailActivity.this.kYg, PluginDetailActivity.this.Sv);
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
            aVar.aUN();
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
        if (pluginConfig == null || (findPluginSetting = c.oQ().findPluginSetting(pluginConfig.package_name)) == null) {
            return 0;
        }
        String f = Util.f(findPluginSetting);
        if (ar.isEmpty(f)) {
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
