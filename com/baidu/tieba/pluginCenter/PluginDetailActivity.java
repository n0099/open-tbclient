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
    private String bIp;
    private TextView fnG;
    private TextView gRI;
    private HeadImageView jAT;
    private TextView jAU;
    private TextView jAV;
    private TextView jAW;
    private ProgressBar jAX;
    private PluginNetConfigInfos.PluginConfig jAY;
    private ShadowLayout jAZ;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d yy = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.jAY != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.jAY.package_name) && !PluginDetailActivity.this.mFinished) {
                am.setViewTextColor(PluginDetailActivity.this.jAW, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.jAZ.setShadowColor(0);
                PluginDetailActivity.this.jAW.setEnabled(false);
                PluginDetailActivity.this.jAW.setVisibility(8);
                PluginDetailActivity.this.jAX.setVisibility(0);
                PluginDetailActivity.this.gRI.setVisibility(0);
                PluginDetailActivity.this.jAX.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.jAY != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.jAY.package_name)) {
                PluginDetailActivity.this.jAW.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.jAW.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.jAY != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.jAY.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.cAn();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.cAn();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.cAn();
        }
    };
    private final CustomMessageListener cLK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.cAn();
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
        this.jAT = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.fnG = (TextView) findViewById(R.id.status);
        this.jAX = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.gRI = (TextView) findViewById(R.id.plugin_download_text);
        this.jAU = (TextView) findViewById(R.id.changelog);
        this.jAV = (TextView) findViewById(R.id.size);
        this.jAW = (TextView) findViewById(R.id.enable);
        this.jAW.setOnClickListener(this);
        this.jAZ = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.bIp = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jP().jQ() != null) {
            this.jAY = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jP().jQ().getPluginConfig(this.bIp);
        }
        if (PluginPackageManager.js().bj(this.bIp)) {
            PluginPackageManager.js().a(this.yy);
            am.setViewTextColor(this.jAW, R.color.cp_cont_d, 1);
            this.jAW.setEnabled(false);
        }
        registerListener(this.cLK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jAY != null) {
            this.jAT.startLoad(this.jAY.icon, 10, false);
            if (this.jAY.display_name == null) {
                this.jAY.display_name = "";
            }
            this.mName.setText(this.jAY.display_name);
            cAn();
            if (this.jAY.newest != null) {
                if (TextUtils.isEmpty(this.jAY.newest.change_log)) {
                    this.jAU.setText("");
                } else {
                    this.jAU.setText(this.jAY.newest.change_log);
                }
                if (this.jAY.newest.size <= 0) {
                    this.jAV.setText("");
                } else {
                    this.jAV.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.jAY.newest.size / 1024) + "KB");
                }
            }
            this.jAW.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a;
        super.onResume();
        if (this.jAX != null && PluginPackageManager.js().bj(this.bIp) && (a = a(this.jAY)) < 100) {
            am.setViewTextColor(this.jAW, R.color.cp_cont_d, 1);
            this.jAZ.setShadowColor(0);
            this.jAW.setEnabled(false);
            this.jAW.setVisibility(8);
            this.jAX.setVisibility(0);
            this.gRI.setVisibility(0);
            this.jAX.setProgress(a);
        }
        PluginPackageManager.js().a(this.yy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.js().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAn() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.js().bh(this.bIp) && PluginPackageManager.js().bf(this.bIp)) {
            this.fnG.setText(R.string.plugin_enabled);
            this.jAW.setVisibility(0);
            this.jAW.setText(R.string.download_update);
            this.jAW.setEnabled(true);
            am.setBackgroundResource(this.jAW, R.drawable.selector_blue_gradient_button);
            this.jAZ.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.jAW, R.color.cp_cont_g, 1);
            this.jAX.setVisibility(8);
            this.gRI.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.js().bf(this.bIp)) {
            this.jAW.setEnabled(true);
            am.setViewTextColor(this.jAW, R.color.cp_cont_g, 1);
            this.jAW.setVisibility(0);
            this.jAX.setVisibility(8);
            this.gRI.setVisibility(8);
            if (PluginPackageManager.js().bg(this.bIp)) {
                this.fnG.setText(R.string.plugin_unenabled);
                this.jAW.setText(R.string.plugin_enable);
                am.setBackgroundResource(this.jAW, R.drawable.selector_blue_gradient_button);
                this.jAZ.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.fnG.setText(R.string.plugin_enabled);
            this.jAW.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.jAY != null && this.jAY.can_forbidden == 1) {
                this.jAW.setEnabled(false);
                this.jAW.setVisibility(8);
                this.jAZ.setShadowColor(0);
                return;
            }
            this.jAW.setEnabled(true);
            this.jAW.setVisibility(0);
            am.setBackgroundResource(this.jAW, R.drawable.button_plugin_forbidden);
            this.jAZ.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.jAW.setVisibility(0);
            this.fnG.setText(R.string.plugin_disabled);
            this.jAW.setText(R.string.install_app);
            this.jAW.setEnabled(true);
            am.setBackgroundResource(this.jAW, R.drawable.selector_blue_gradient_button);
            this.jAZ.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.jAW, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.jAX.setVisibility(8);
            this.gRI.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jAX.setProgressDrawable(am.getDrawable(R.drawable.download_progressbar));
        this.jAX.setIndeterminateDrawable(am.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jAW) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                cAo();
            } else if (this.mStatus == 3) {
                PluginPackageManager.js().bd(this.bIp);
                cAn();
            } else if (this.mStatus == 2) {
                PluginPackageManager.js().be(this.bIp);
                cAn();
            }
        }
    }

    private void cAo() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            cAp();
        } else if (this.jAY != null && !TextUtils.isEmpty(this.jAY.package_name) && !PluginPackageManager.js().bj(this.jAY.package_name)) {
            this.jAW.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.js().a(this.jAY, this.yy);
        }
    }

    private void cAp() {
        String string;
        String string2;
        if (this.jAY != null && this.jAY.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.jAY.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.sS(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    am.setViewTextColor(PluginDetailActivity.this.jAW, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.jAW.setEnabled(false);
                    PluginPackageManager.js().a(PluginDetailActivity.this.jAY, PluginDetailActivity.this.yy);
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
            aVar.aEG();
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
        if (pluginConfig == null || (findPluginSetting = c.jV().findPluginSetting(pluginConfig.package_name)) == null) {
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
