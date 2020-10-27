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
    private String dey;
    private TextView eqy;
    private TextView hqb;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private HeadImageView mgF;
    private TextView mgG;
    private TextView mgH;
    private TextView mgI;
    private ProgressBar mgJ;
    private PluginNetConfigInfos.PluginConfig mgK;
    private ShadowLayout mgL;
    private d TI = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mgK != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mgK.package_name) && !PluginDetailActivity.this.mFinished) {
                ap.setViewTextColor(PluginDetailActivity.this.mgI, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.mgL.setShadowColor(0);
                PluginDetailActivity.this.mgI.setEnabled(false);
                PluginDetailActivity.this.mgI.setVisibility(8);
                PluginDetailActivity.this.mgJ.setVisibility(0);
                PluginDetailActivity.this.eqy.setVisibility(0);
                PluginDetailActivity.this.mgJ.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mgK != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mgK.package_name)) {
                PluginDetailActivity.this.mgI.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.mgI.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mgK != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mgK.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.dvo();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.dvo();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.dvo();
        }
    };
    private final CustomMessageListener eri = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.dvo();
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
        this.mgF = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.hqb = (TextView) findViewById(R.id.status);
        this.mgJ = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.eqy = (TextView) findViewById(R.id.plugin_download_text);
        this.mgG = (TextView) findViewById(R.id.changelog);
        this.mgH = (TextView) findViewById(R.id.size);
        this.mgI = (TextView) findViewById(R.id.enable);
        this.mgI.setOnClickListener(this);
        this.mgL = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.dey = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qp().qq() != null) {
            this.mgK = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qp().qq().getPluginConfig(this.dey);
        }
        if (PluginPackageManager.pT().cG(this.dey)) {
            PluginPackageManager.pT().a(this.TI);
            ap.setViewTextColor(this.mgI, R.color.cp_cont_d, 1);
            this.mgI.setEnabled(false);
        }
        registerListener(this.eri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mgK != null) {
            this.mgF.startLoad(this.mgK.icon, 10, false);
            if (this.mgK.display_name == null) {
                this.mgK.display_name = "";
            }
            this.mName.setText(this.mgK.display_name);
            dvo();
            if (this.mgK.newest != null) {
                if (TextUtils.isEmpty(this.mgK.newest.change_log)) {
                    this.mgG.setText("");
                } else {
                    this.mgG.setText(this.mgK.newest.change_log);
                }
                if (this.mgK.newest.size <= 0) {
                    this.mgH.setText("");
                } else {
                    this.mgH.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.mgK.newest.size / 1024) + "KB");
                }
            }
            this.mgI.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a2;
        super.onResume();
        if (this.mgJ != null && PluginPackageManager.pT().cG(this.dey) && (a2 = a(this.mgK)) < 100) {
            ap.setViewTextColor(this.mgI, R.color.cp_cont_d, 1);
            this.mgL.setShadowColor(0);
            this.mgI.setEnabled(false);
            this.mgI.setVisibility(8);
            this.mgJ.setVisibility(0);
            this.eqy.setVisibility(0);
            this.mgJ.setProgress(a2);
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
    public void dvo() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.pT().cE(this.dey) && PluginPackageManager.pT().cC(this.dey)) {
            this.hqb.setText(R.string.plugin_enabled);
            this.mgI.setVisibility(0);
            this.mgI.setText(R.string.download_update);
            this.mgI.setEnabled(true);
            ap.setBackgroundResource(this.mgI, R.drawable.selector_blue_gradient_button);
            this.mgL.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.mgI, R.color.cp_cont_g, 1);
            this.mgJ.setVisibility(8);
            this.eqy.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.pT().cC(this.dey)) {
            this.mgI.setEnabled(true);
            ap.setViewTextColor(this.mgI, R.color.cp_cont_g, 1);
            this.mgI.setVisibility(0);
            this.mgJ.setVisibility(8);
            this.eqy.setVisibility(8);
            if (PluginPackageManager.pT().cD(this.dey)) {
                this.hqb.setText(R.string.plugin_unenabled);
                this.mgI.setText(R.string.plugin_enable);
                ap.setBackgroundResource(this.mgI, R.drawable.selector_blue_gradient_button);
                this.mgL.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.hqb.setText(R.string.plugin_enabled);
            this.mgI.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.mgK != null && this.mgK.can_forbidden == 1) {
                this.mgI.setEnabled(false);
                this.mgI.setVisibility(8);
                this.mgL.setShadowColor(0);
                return;
            }
            this.mgI.setEnabled(true);
            this.mgI.setVisibility(0);
            ap.setBackgroundResource(this.mgI, R.drawable.button_plugin_forbidden);
            this.mgL.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.mgI.setVisibility(0);
            this.hqb.setText(R.string.plugin_disabled);
            this.mgI.setText(R.string.install_app);
            this.mgI.setEnabled(true);
            ap.setBackgroundResource(this.mgI, R.drawable.selector_blue_gradient_button);
            this.mgL.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.mgI, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.mgJ.setVisibility(8);
            this.eqy.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mgJ.setProgressDrawable(ap.getDrawable(R.drawable.download_progressbar));
        this.mgJ.setIndeterminateDrawable(ap.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mgI) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                dvp();
            } else if (this.mStatus == 3) {
                PluginPackageManager.pT().cA(this.dey);
                dvo();
            } else if (this.mStatus == 2) {
                PluginPackageManager.pT().cB(this.dey);
                dvo();
            }
        }
    }

    private void dvp() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            dvq();
        } else if (this.mgK != null && !TextUtils.isEmpty(this.mgK.package_name) && !PluginPackageManager.pT().cG(this.mgK.package_name)) {
            this.mgI.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.pT().a(this.mgK, this.TI);
        }
    }

    private void dvq() {
        String string;
        String string2;
        if (this.mgK != null && this.mgK.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.mgK.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.Ba(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ap.setViewTextColor(PluginDetailActivity.this.mgI, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.mgI.setEnabled(false);
                    PluginPackageManager.pT().a(PluginDetailActivity.this.mgK, PluginDetailActivity.this.TI);
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
            aVar.bmC();
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
