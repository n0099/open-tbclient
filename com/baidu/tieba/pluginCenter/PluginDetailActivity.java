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
/* loaded from: classes7.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String dtJ;
    private TextView eKj;
    private TextView hSW;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private HeadImageView mNk;
    private TextView mNl;
    private TextView mNm;
    private TextView mNn;
    private ProgressBar mNo;
    private PluginNetConfigInfos.PluginConfig mNp;
    private ShadowLayout mNq;
    private int mStatus;
    private d VW = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mNp != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mNp.package_name) && !PluginDetailActivity.this.mFinished) {
                ap.setViewTextColor(PluginDetailActivity.this.mNn, R.color.CAM_X0109, 1);
                PluginDetailActivity.this.mNq.setShadowColor(0);
                PluginDetailActivity.this.mNn.setEnabled(false);
                PluginDetailActivity.this.mNn.setVisibility(8);
                PluginDetailActivity.this.mNo.setVisibility(0);
                PluginDetailActivity.this.eKj.setVisibility(0);
                PluginDetailActivity.this.mNo.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mNp != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mNp.package_name)) {
                PluginDetailActivity.this.mNn.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.mNn.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mNp != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mNp.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.dBf();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.dBf();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.dBf();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.dBf();
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
        this.mNk = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.hSW = (TextView) findViewById(R.id.status);
        this.mNo = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.eKj = (TextView) findViewById(R.id.plugin_download_text);
        this.mNl = (TextView) findViewById(R.id.changelog);
        this.mNm = (TextView) findViewById(R.id.size);
        this.mNn = (TextView) findViewById(R.id.enable);
        this.mNn.setOnClickListener(this);
        this.mNq = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.dtJ = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pR().pS() != null) {
            this.mNp = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pR().pS().getPluginConfig(this.dtJ);
        }
        if (PluginPackageManager.pv().cI(this.dtJ)) {
            PluginPackageManager.pv().a(this.VW);
            ap.setViewTextColor(this.mNn, R.color.CAM_X0109, 1);
            this.mNn.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNp != null) {
            this.mNk.startLoad(this.mNp.icon, 10, false);
            if (this.mNp.display_name == null) {
                this.mNp.display_name = "";
            }
            this.mName.setText(this.mNp.display_name);
            dBf();
            if (this.mNp.newest != null) {
                if (TextUtils.isEmpty(this.mNp.newest.change_log)) {
                    this.mNl.setText("");
                } else {
                    this.mNl.setText(this.mNp.newest.change_log);
                }
                if (this.mNp.newest.size <= 0) {
                    this.mNm.setText("");
                } else {
                    this.mNm.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.mNp.newest.size / 1024) + "KB");
                }
            }
            this.mNn.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a2;
        super.onResume();
        if (this.mNo != null && PluginPackageManager.pv().cI(this.dtJ) && (a2 = a(this.mNp)) < 100) {
            ap.setViewTextColor(this.mNn, R.color.CAM_X0109, 1);
            this.mNq.setShadowColor(0);
            this.mNn.setEnabled(false);
            this.mNn.setVisibility(8);
            this.mNo.setVisibility(0);
            this.eKj.setVisibility(0);
            this.mNo.setProgress(a2);
        }
        PluginPackageManager.pv().a(this.VW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.pv().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBf() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.pv().cG(this.dtJ) && PluginPackageManager.pv().cE(this.dtJ)) {
            this.hSW.setText(R.string.plugin_enabled);
            this.mNn.setVisibility(0);
            this.mNn.setText(R.string.download_update);
            this.mNn.setEnabled(true);
            ap.setBackgroundResource(this.mNn, R.drawable.selector_blue_gradient_button);
            this.mNq.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.mNn, R.color.CAM_X0111, 1);
            this.mNo.setVisibility(8);
            this.eKj.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.pv().cE(this.dtJ)) {
            this.mNn.setEnabled(true);
            ap.setViewTextColor(this.mNn, R.color.CAM_X0111, 1);
            this.mNn.setVisibility(0);
            this.mNo.setVisibility(8);
            this.eKj.setVisibility(8);
            if (PluginPackageManager.pv().cF(this.dtJ)) {
                this.hSW.setText(R.string.plugin_unenabled);
                this.mNn.setText(R.string.plugin_enable);
                ap.setBackgroundResource(this.mNn, R.drawable.selector_blue_gradient_button);
                this.mNq.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.hSW.setText(R.string.plugin_enabled);
            this.mNn.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.mNp != null && this.mNp.can_forbidden == 1) {
                this.mNn.setEnabled(false);
                this.mNn.setVisibility(8);
                this.mNq.setShadowColor(0);
                return;
            }
            this.mNn.setEnabled(true);
            this.mNn.setVisibility(0);
            ap.setBackgroundResource(this.mNn, R.drawable.button_plugin_forbidden);
            this.mNq.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.mNn.setVisibility(0);
            this.hSW.setText(R.string.plugin_disabled);
            this.mNn.setText(R.string.install_app);
            this.mNn.setEnabled(true);
            ap.setBackgroundResource(this.mNn, R.drawable.selector_blue_gradient_button);
            this.mNq.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.mNn, R.color.CAM_X0111, 1);
            this.mStatus = 0;
            this.mNo.setVisibility(8);
            this.eKj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNo.setProgressDrawable(ap.getDrawable(R.drawable.download_progressbar));
        this.mNo.setIndeterminateDrawable(ap.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mNn) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                dBg();
            } else if (this.mStatus == 3) {
                PluginPackageManager.pv().cC(this.dtJ);
                dBf();
            } else if (this.mStatus == 2) {
                PluginPackageManager.pv().cD(this.dtJ);
                dBf();
            }
        }
    }

    private void dBg() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            dBh();
        } else if (this.mNp != null && !TextUtils.isEmpty(this.mNp.package_name) && !PluginPackageManager.pv().cI(this.mNp.package_name)) {
            this.mNn.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.pv().a(this.mNp, this.VW);
        }
    }

    private void dBh() {
        String string;
        String string2;
        if (this.mNp != null && this.mNp.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.mNp.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.AB(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ap.setViewTextColor(PluginDetailActivity.this.mNn, R.color.CAM_X0109, 1);
                    PluginDetailActivity.this.mNn.setEnabled(false);
                    PluginPackageManager.pv().a(PluginDetailActivity.this.mNp, PluginDetailActivity.this.VW);
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
            aVar.bqz();
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
        if (pluginConfig == null || (findPluginSetting = c.pX().findPluginSetting(pluginConfig.package_name)) == null) {
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
