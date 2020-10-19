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
    private String cVX;
    private TextView eia;
    private TextView hef;
    private HeadImageView lUg;
    private TextView lUh;
    private TextView lUi;
    private TextView lUj;
    private ProgressBar lUk;
    private PluginNetConfigInfos.PluginConfig lUl;
    private ShadowLayout lUm;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d TH = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.lUl != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.lUl.package_name) && !PluginDetailActivity.this.mFinished) {
                ap.setViewTextColor(PluginDetailActivity.this.lUj, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.lUm.setShadowColor(0);
                PluginDetailActivity.this.lUj.setEnabled(false);
                PluginDetailActivity.this.lUj.setVisibility(8);
                PluginDetailActivity.this.lUk.setVisibility(0);
                PluginDetailActivity.this.eia.setVisibility(0);
                PluginDetailActivity.this.lUk.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.lUl != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.lUl.package_name)) {
                PluginDetailActivity.this.lUj.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.lUj.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.lUl != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.lUl.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.dsh();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.dsh();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.dsh();
        }
    };
    private final CustomMessageListener eiK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.dsh();
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
        this.lUg = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.hef = (TextView) findViewById(R.id.status);
        this.lUk = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.eia = (TextView) findViewById(R.id.plugin_download_text);
        this.lUh = (TextView) findViewById(R.id.changelog);
        this.lUi = (TextView) findViewById(R.id.size);
        this.lUj = (TextView) findViewById(R.id.enable);
        this.lUj.setOnClickListener(this);
        this.lUm = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.cVX = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qp().qq() != null) {
            this.lUl = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qp().qq().getPluginConfig(this.cVX);
        }
        if (PluginPackageManager.pT().cG(this.cVX)) {
            PluginPackageManager.pT().a(this.TH);
            ap.setViewTextColor(this.lUj, R.color.cp_cont_d, 1);
            this.lUj.setEnabled(false);
        }
        registerListener(this.eiK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.lUl != null) {
            this.lUg.startLoad(this.lUl.icon, 10, false);
            if (this.lUl.display_name == null) {
                this.lUl.display_name = "";
            }
            this.mName.setText(this.lUl.display_name);
            dsh();
            if (this.lUl.newest != null) {
                if (TextUtils.isEmpty(this.lUl.newest.change_log)) {
                    this.lUh.setText("");
                } else {
                    this.lUh.setText(this.lUl.newest.change_log);
                }
                if (this.lUl.newest.size <= 0) {
                    this.lUi.setText("");
                } else {
                    this.lUi.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.lUl.newest.size / 1024) + "KB");
                }
            }
            this.lUj.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a2;
        super.onResume();
        if (this.lUk != null && PluginPackageManager.pT().cG(this.cVX) && (a2 = a(this.lUl)) < 100) {
            ap.setViewTextColor(this.lUj, R.color.cp_cont_d, 1);
            this.lUm.setShadowColor(0);
            this.lUj.setEnabled(false);
            this.lUj.setVisibility(8);
            this.lUk.setVisibility(0);
            this.eia.setVisibility(0);
            this.lUk.setProgress(a2);
        }
        PluginPackageManager.pT().a(this.TH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.pT().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsh() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.pT().cE(this.cVX) && PluginPackageManager.pT().cC(this.cVX)) {
            this.hef.setText(R.string.plugin_enabled);
            this.lUj.setVisibility(0);
            this.lUj.setText(R.string.download_update);
            this.lUj.setEnabled(true);
            ap.setBackgroundResource(this.lUj, R.drawable.selector_blue_gradient_button);
            this.lUm.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.lUj, R.color.cp_cont_g, 1);
            this.lUk.setVisibility(8);
            this.eia.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.pT().cC(this.cVX)) {
            this.lUj.setEnabled(true);
            ap.setViewTextColor(this.lUj, R.color.cp_cont_g, 1);
            this.lUj.setVisibility(0);
            this.lUk.setVisibility(8);
            this.eia.setVisibility(8);
            if (PluginPackageManager.pT().cD(this.cVX)) {
                this.hef.setText(R.string.plugin_unenabled);
                this.lUj.setText(R.string.plugin_enable);
                ap.setBackgroundResource(this.lUj, R.drawable.selector_blue_gradient_button);
                this.lUm.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.hef.setText(R.string.plugin_enabled);
            this.lUj.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.lUl != null && this.lUl.can_forbidden == 1) {
                this.lUj.setEnabled(false);
                this.lUj.setVisibility(8);
                this.lUm.setShadowColor(0);
                return;
            }
            this.lUj.setEnabled(true);
            this.lUj.setVisibility(0);
            ap.setBackgroundResource(this.lUj, R.drawable.button_plugin_forbidden);
            this.lUm.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.lUj.setVisibility(0);
            this.hef.setText(R.string.plugin_disabled);
            this.lUj.setText(R.string.install_app);
            this.lUj.setEnabled(true);
            ap.setBackgroundResource(this.lUj, R.drawable.selector_blue_gradient_button);
            this.lUm.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.lUj, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.lUk.setVisibility(8);
            this.eia.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lUk.setProgressDrawable(ap.getDrawable(R.drawable.download_progressbar));
        this.lUk.setIndeterminateDrawable(ap.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lUj) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                dsi();
            } else if (this.mStatus == 3) {
                PluginPackageManager.pT().cA(this.cVX);
                dsh();
            } else if (this.mStatus == 2) {
                PluginPackageManager.pT().cB(this.cVX);
                dsh();
            }
        }
    }

    private void dsi() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            dsj();
        } else if (this.lUl != null && !TextUtils.isEmpty(this.lUl.package_name) && !PluginPackageManager.pT().cG(this.lUl.package_name)) {
            this.lUj.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.pT().a(this.lUl, this.TH);
        }
    }

    private void dsj() {
        String string;
        String string2;
        if (this.lUl != null && this.lUl.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.lUl.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.AH(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ap.setViewTextColor(PluginDetailActivity.this.lUj, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.lUj.setEnabled(false);
                    PluginPackageManager.pT().a(PluginDetailActivity.this.lUl, PluginDetailActivity.this.TH);
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
            aVar.bkJ();
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
