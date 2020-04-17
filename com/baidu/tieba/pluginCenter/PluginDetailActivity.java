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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugin.ShadowLayout;
import com.baidu.tieba.R;
import java.io.File;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String cgY;
    private TextView fRW;
    private TextView hBJ;
    private HeadImageView kkY;
    private TextView kkZ;
    private TextView kla;
    private TextView klb;
    private ProgressBar klc;
    private PluginNetConfigInfos.PluginConfig kld;
    private ShadowLayout kle;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d RD = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.kld != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.kld.package_name) && !PluginDetailActivity.this.mFinished) {
                am.setViewTextColor(PluginDetailActivity.this.klb, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.kle.setShadowColor(0);
                PluginDetailActivity.this.klb.setEnabled(false);
                PluginDetailActivity.this.klb.setVisibility(8);
                PluginDetailActivity.this.klc.setVisibility(0);
                PluginDetailActivity.this.hBJ.setVisibility(0);
                PluginDetailActivity.this.klc.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.kld != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.kld.package_name)) {
                PluginDetailActivity.this.klb.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.klb.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.kld != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.kld.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.cKX();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.cKX();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.cKX();
        }
    };
    private final CustomMessageListener dkS = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.cKX();
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
        this.kkY = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.fRW = (TextView) findViewById(R.id.status);
        this.klc = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.hBJ = (TextView) findViewById(R.id.plugin_download_text);
        this.kkZ = (TextView) findViewById(R.id.changelog);
        this.kla = (TextView) findViewById(R.id.size);
        this.klb = (TextView) findViewById(R.id.enable);
        this.klb.setOnClickListener(this);
        this.kle = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.cgY = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ot().ou() != null) {
            this.kld = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ot().ou().getPluginConfig(this.cgY);
        }
        if (PluginPackageManager.nV().cy(this.cgY)) {
            PluginPackageManager.nV().a(this.RD);
            am.setViewTextColor(this.klb, R.color.cp_cont_d, 1);
            this.klb.setEnabled(false);
        }
        registerListener(this.dkS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.kld != null) {
            this.kkY.startLoad(this.kld.icon, 10, false);
            if (this.kld.display_name == null) {
                this.kld.display_name = "";
            }
            this.mName.setText(this.kld.display_name);
            cKX();
            if (this.kld.newest != null) {
                if (TextUtils.isEmpty(this.kld.newest.change_log)) {
                    this.kkZ.setText("");
                } else {
                    this.kkZ.setText(this.kld.newest.change_log);
                }
                if (this.kld.newest.size <= 0) {
                    this.kla.setText("");
                } else {
                    this.kla.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.kld.newest.size / 1024) + "KB");
                }
            }
            this.klb.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a;
        super.onResume();
        if (this.klc != null && PluginPackageManager.nV().cy(this.cgY) && (a = a(this.kld)) < 100) {
            am.setViewTextColor(this.klb, R.color.cp_cont_d, 1);
            this.kle.setShadowColor(0);
            this.klb.setEnabled(false);
            this.klb.setVisibility(8);
            this.klc.setVisibility(0);
            this.hBJ.setVisibility(0);
            this.klc.setProgress(a);
        }
        PluginPackageManager.nV().a(this.RD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.nV().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKX() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.nV().cw(this.cgY) && PluginPackageManager.nV().cu(this.cgY)) {
            this.fRW.setText(R.string.plugin_enabled);
            this.klb.setVisibility(0);
            this.klb.setText(R.string.download_update);
            this.klb.setEnabled(true);
            am.setBackgroundResource(this.klb, R.drawable.selector_blue_gradient_button);
            this.kle.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.klb, R.color.cp_cont_g, 1);
            this.klc.setVisibility(8);
            this.hBJ.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.nV().cu(this.cgY)) {
            this.klb.setEnabled(true);
            am.setViewTextColor(this.klb, R.color.cp_cont_g, 1);
            this.klb.setVisibility(0);
            this.klc.setVisibility(8);
            this.hBJ.setVisibility(8);
            if (PluginPackageManager.nV().cv(this.cgY)) {
                this.fRW.setText(R.string.plugin_unenabled);
                this.klb.setText(R.string.plugin_enable);
                am.setBackgroundResource(this.klb, R.drawable.selector_blue_gradient_button);
                this.kle.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.fRW.setText(R.string.plugin_enabled);
            this.klb.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.kld != null && this.kld.can_forbidden == 1) {
                this.klb.setEnabled(false);
                this.klb.setVisibility(8);
                this.kle.setShadowColor(0);
                return;
            }
            this.klb.setEnabled(true);
            this.klb.setVisibility(0);
            am.setBackgroundResource(this.klb, R.drawable.button_plugin_forbidden);
            this.kle.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.klb.setVisibility(0);
            this.fRW.setText(R.string.plugin_disabled);
            this.klb.setText(R.string.install_app);
            this.klb.setEnabled(true);
            am.setBackgroundResource(this.klb, R.drawable.selector_blue_gradient_button);
            this.kle.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.klb, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.klc.setVisibility(8);
            this.hBJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.klc.setProgressDrawable(am.getDrawable(R.drawable.download_progressbar));
        this.klc.setIndeterminateDrawable(am.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.klb) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                cKY();
            } else if (this.mStatus == 3) {
                PluginPackageManager.nV().cs(this.cgY);
                cKX();
            } else if (this.mStatus == 2) {
                PluginPackageManager.nV().ct(this.cgY);
                cKX();
            }
        }
    }

    private void cKY() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            cKZ();
        } else if (this.kld != null && !TextUtils.isEmpty(this.kld.package_name) && !PluginPackageManager.nV().cy(this.kld.package_name)) {
            this.klb.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.nV().a(this.kld, this.RD);
        }
    }

    private void cKZ() {
        String string;
        String string2;
        if (this.kld != null && this.kld.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.kld.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.uf(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    am.setViewTextColor(PluginDetailActivity.this.klb, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.klb.setEnabled(false);
                    PluginPackageManager.nV().a(PluginDetailActivity.this.kld, PluginDetailActivity.this.RD);
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
            aVar.aMU();
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
        if (pluginConfig == null || (findPluginSetting = c.oz().findPluginSetting(pluginConfig.package_name)) == null) {
            return 0;
        }
        String f = Util.f(findPluginSetting);
        if (aq.isEmpty(f)) {
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
