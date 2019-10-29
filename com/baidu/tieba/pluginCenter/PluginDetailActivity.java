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
    private String bMX;
    private TextView erk;
    private TextView fXs;
    private HeadImageView iBr;
    private TextView iBs;
    private TextView iBt;
    private TextView iBu;
    private ProgressBar iBv;
    private PluginNetConfigInfos.PluginConfig iBw;
    private ShadowLayout iBx;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d wa = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iBw != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iBw.package_name) && !PluginDetailActivity.this.mFinished) {
                am.setViewTextColor(PluginDetailActivity.this.iBu, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.iBx.setShadowColor(0);
                PluginDetailActivity.this.iBu.setEnabled(false);
                PluginDetailActivity.this.iBu.setVisibility(8);
                PluginDetailActivity.this.iBv.setVisibility(0);
                PluginDetailActivity.this.fXs.setVisibility(0);
                PluginDetailActivity.this.iBv.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iBw != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iBw.package_name)) {
                PluginDetailActivity.this.iBu.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.iBu.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iBw != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iBw.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.cdt();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.cdt();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.cdt();
        }
    };
    private final CustomMessageListener bVI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.cdt();
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
        this.iBr = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.erk = (TextView) findViewById(R.id.status);
        this.iBv = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.fXs = (TextView) findViewById(R.id.plugin_download_text);
        this.iBs = (TextView) findViewById(R.id.changelog);
        this.iBt = (TextView) findViewById(R.id.size);
        this.iBu = (TextView) findViewById(R.id.enable);
        this.iBu.setOnClickListener(this);
        this.iBx = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.bMX = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jj().jk() != null) {
            this.iBw = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jj().jk().getPluginConfig(this.bMX);
        }
        if (PluginPackageManager.iL().aV(this.bMX)) {
            PluginPackageManager.iL().a(this.wa);
            am.setViewTextColor(this.iBu, R.color.cp_cont_d, 1);
            this.iBu.setEnabled(false);
        }
        registerListener(this.bVI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iBw != null) {
            this.iBr.startLoad(this.iBw.icon, 10, false);
            if (this.iBw.display_name == null) {
                this.iBw.display_name = "";
            }
            this.mName.setText(this.iBw.display_name);
            cdt();
            if (this.iBw.newest != null) {
                if (TextUtils.isEmpty(this.iBw.newest.change_log)) {
                    this.iBs.setText("");
                } else {
                    this.iBs.setText(this.iBw.newest.change_log);
                }
                if (this.iBw.newest.size <= 0) {
                    this.iBt.setText("");
                } else {
                    this.iBt.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.iBw.newest.size / 1024) + "KB");
                }
            }
            this.iBu.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PluginPackageManager.iL().a(this.wa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.iL().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdt() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.iL().aT(this.bMX) && PluginPackageManager.iL().aR(this.bMX)) {
            this.erk.setText(R.string.plugin_enabled);
            this.iBu.setVisibility(0);
            this.iBu.setText(R.string.download_update);
            this.iBu.setEnabled(true);
            am.setBackgroundResource(this.iBu, R.drawable.selector_blue_gradient_button);
            this.iBx.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.iBu, R.color.cp_cont_g, 1);
            this.iBv.setVisibility(8);
            this.fXs.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.iL().aR(this.bMX)) {
            this.iBu.setEnabled(true);
            am.setViewTextColor(this.iBu, R.color.cp_cont_g, 1);
            this.iBu.setVisibility(0);
            this.iBv.setVisibility(8);
            this.fXs.setVisibility(8);
            if (PluginPackageManager.iL().aS(this.bMX)) {
                this.erk.setText(R.string.plugin_unenabled);
                this.iBu.setText(R.string.plugin_enable);
                am.setBackgroundResource(this.iBu, R.drawable.selector_blue_gradient_button);
                this.iBx.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.erk.setText(R.string.plugin_enabled);
            this.iBu.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.iBw != null && this.iBw.can_forbidden == 1) {
                this.iBu.setEnabled(false);
                this.iBu.setVisibility(8);
                this.iBx.setShadowColor(0);
                return;
            }
            this.iBu.setEnabled(true);
            this.iBu.setVisibility(0);
            am.setBackgroundResource(this.iBu, R.drawable.button_plugin_forbidden);
            this.iBx.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.iBu.setVisibility(0);
            this.erk.setText(R.string.plugin_disabled);
            this.iBu.setText(R.string.install_app);
            this.iBu.setEnabled(true);
            am.setBackgroundResource(this.iBu, R.drawable.selector_blue_gradient_button);
            this.iBx.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.iBu, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.iBv.setVisibility(8);
            this.fXs.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iBv.setProgressDrawable(am.getDrawable(R.drawable.download_progressbar));
        this.iBv.setIndeterminateDrawable(am.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iBu) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                cdu();
            } else if (this.mStatus == 3) {
                PluginPackageManager.iL().aP(this.bMX);
                cdt();
            } else if (this.mStatus == 2) {
                PluginPackageManager.iL().aQ(this.bMX);
                cdt();
            }
        }
    }

    private void cdu() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            cdv();
        } else if (this.iBw != null && !TextUtils.isEmpty(this.iBw.package_name) && !PluginPackageManager.iL().aV(this.iBw.package_name)) {
            this.iBu.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.iL().a(this.iBw, this.wa);
        }
    }

    private void cdv() {
        String string;
        String string2;
        if (this.iBw != null && this.iBw.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.iBw.newest.size / 1048576.0f;
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
                    am.setViewTextColor(PluginDetailActivity.this.iBu, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.iBu.setEnabled(false);
                    PluginPackageManager.iL().a(PluginDetailActivity.this.iBw, PluginDetailActivity.this.wa);
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
            aVar.akO();
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
