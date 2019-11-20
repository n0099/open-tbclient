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
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.d;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugin.ShadowLayout;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String bMg;
    private TextView eqt;
    private TextView fWB;
    private HeadImageView iAA;
    private TextView iAB;
    private TextView iAC;
    private TextView iAD;
    private ProgressBar iAE;
    private PluginNetConfigInfos.PluginConfig iAF;
    private ShadowLayout iAG;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d vA = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iAF != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iAF.package_name) && !PluginDetailActivity.this.mFinished) {
                am.setViewTextColor(PluginDetailActivity.this.iAD, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.iAG.setShadowColor(0);
                PluginDetailActivity.this.iAD.setEnabled(false);
                PluginDetailActivity.this.iAD.setVisibility(8);
                PluginDetailActivity.this.iAE.setVisibility(0);
                PluginDetailActivity.this.fWB.setVisibility(0);
                PluginDetailActivity.this.iAE.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iAF != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iAF.package_name)) {
                PluginDetailActivity.this.iAD.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.iAD.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iAF != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iAF.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.cdr();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.cdr();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.cdr();
        }
    };
    private final CustomMessageListener bUR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.cdr();
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
        this.iAA = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.eqt = (TextView) findViewById(R.id.status);
        this.iAE = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.fWB = (TextView) findViewById(R.id.plugin_download_text);
        this.iAB = (TextView) findViewById(R.id.changelog);
        this.iAC = (TextView) findViewById(R.id.size);
        this.iAD = (TextView) findViewById(R.id.enable);
        this.iAD.setOnClickListener(this);
        this.iAG = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.bMg = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jj().jk() != null) {
            this.iAF = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jj().jk().getPluginConfig(this.bMg);
        }
        if (PluginPackageManager.iL().aV(this.bMg)) {
            PluginPackageManager.iL().a(this.vA);
            am.setViewTextColor(this.iAD, R.color.cp_cont_d, 1);
            this.iAD.setEnabled(false);
        }
        registerListener(this.bUR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iAF != null) {
            this.iAA.startLoad(this.iAF.icon, 10, false);
            if (this.iAF.display_name == null) {
                this.iAF.display_name = "";
            }
            this.mName.setText(this.iAF.display_name);
            cdr();
            if (this.iAF.newest != null) {
                if (TextUtils.isEmpty(this.iAF.newest.change_log)) {
                    this.iAB.setText("");
                } else {
                    this.iAB.setText(this.iAF.newest.change_log);
                }
                if (this.iAF.newest.size <= 0) {
                    this.iAC.setText("");
                } else {
                    this.iAC.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.iAF.newest.size / 1024) + "KB");
                }
            }
            this.iAD.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PluginPackageManager.iL().a(this.vA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.iL().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.iL().aT(this.bMg) && PluginPackageManager.iL().aR(this.bMg)) {
            this.eqt.setText(R.string.plugin_enabled);
            this.iAD.setVisibility(0);
            this.iAD.setText(R.string.download_update);
            this.iAD.setEnabled(true);
            am.setBackgroundResource(this.iAD, R.drawable.selector_blue_gradient_button);
            this.iAG.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.iAD, R.color.cp_cont_g, 1);
            this.iAE.setVisibility(8);
            this.fWB.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.iL().aR(this.bMg)) {
            this.iAD.setEnabled(true);
            am.setViewTextColor(this.iAD, R.color.cp_cont_g, 1);
            this.iAD.setVisibility(0);
            this.iAE.setVisibility(8);
            this.fWB.setVisibility(8);
            if (PluginPackageManager.iL().aS(this.bMg)) {
                this.eqt.setText(R.string.plugin_unenabled);
                this.iAD.setText(R.string.plugin_enable);
                am.setBackgroundResource(this.iAD, R.drawable.selector_blue_gradient_button);
                this.iAG.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.eqt.setText(R.string.plugin_enabled);
            this.iAD.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.iAF != null && this.iAF.can_forbidden == 1) {
                this.iAD.setEnabled(false);
                this.iAD.setVisibility(8);
                this.iAG.setShadowColor(0);
                return;
            }
            this.iAD.setEnabled(true);
            this.iAD.setVisibility(0);
            am.setBackgroundResource(this.iAD, R.drawable.button_plugin_forbidden);
            this.iAG.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.iAD.setVisibility(0);
            this.eqt.setText(R.string.plugin_disabled);
            this.iAD.setText(R.string.install_app);
            this.iAD.setEnabled(true);
            am.setBackgroundResource(this.iAD, R.drawable.selector_blue_gradient_button);
            this.iAG.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.iAD, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.iAE.setVisibility(8);
            this.fWB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iAE.setProgressDrawable(am.getDrawable(R.drawable.download_progressbar));
        this.iAE.setIndeterminateDrawable(am.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iAD) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                cds();
            } else if (this.mStatus == 3) {
                PluginPackageManager.iL().aP(this.bMg);
                cdr();
            } else if (this.mStatus == 2) {
                PluginPackageManager.iL().aQ(this.bMg);
                cdr();
            }
        }
    }

    private void cds() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            cdt();
        } else if (this.iAF != null && !TextUtils.isEmpty(this.iAF.package_name) && !PluginPackageManager.iL().aV(this.iAF.package_name)) {
            this.iAD.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.iL().a(this.iAF, this.vA);
        }
    }

    private void cdt() {
        String string;
        String string2;
        if (this.iAF != null && this.iAF.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.iAF.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.nn(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    am.setViewTextColor(PluginDetailActivity.this.iAD, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.iAD.setEnabled(false);
                    PluginPackageManager.iL().a(PluginDetailActivity.this.iAF, PluginDetailActivity.this.vA);
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
            aVar.akM();
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
}
