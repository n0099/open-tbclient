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
    private String bIe;
    private TextView fnh;
    private TextView gQB;
    private ShadowLayout jzA;
    private HeadImageView jzu;
    private TextView jzv;
    private TextView jzw;
    private TextView jzx;
    private ProgressBar jzy;
    private PluginNetConfigInfos.PluginConfig jzz;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d yy = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.jzz != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.jzz.package_name) && !PluginDetailActivity.this.mFinished) {
                am.setViewTextColor(PluginDetailActivity.this.jzx, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.jzA.setShadowColor(0);
                PluginDetailActivity.this.jzx.setEnabled(false);
                PluginDetailActivity.this.jzx.setVisibility(8);
                PluginDetailActivity.this.jzy.setVisibility(0);
                PluginDetailActivity.this.gQB.setVisibility(0);
                PluginDetailActivity.this.jzy.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.jzz != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.jzz.package_name)) {
                PluginDetailActivity.this.jzx.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.jzx.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.jzz != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.jzz.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.czT();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.czT();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.czT();
        }
    };
    private final CustomMessageListener cLz = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.czT();
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
        this.jzu = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.fnh = (TextView) findViewById(R.id.status);
        this.jzy = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.gQB = (TextView) findViewById(R.id.plugin_download_text);
        this.jzv = (TextView) findViewById(R.id.changelog);
        this.jzw = (TextView) findViewById(R.id.size);
        this.jzx = (TextView) findViewById(R.id.enable);
        this.jzx.setOnClickListener(this);
        this.jzA = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.bIe = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jP().jQ() != null) {
            this.jzz = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jP().jQ().getPluginConfig(this.bIe);
        }
        if (PluginPackageManager.js().bj(this.bIe)) {
            PluginPackageManager.js().a(this.yy);
            am.setViewTextColor(this.jzx, R.color.cp_cont_d, 1);
            this.jzx.setEnabled(false);
        }
        registerListener(this.cLz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jzz != null) {
            this.jzu.startLoad(this.jzz.icon, 10, false);
            if (this.jzz.display_name == null) {
                this.jzz.display_name = "";
            }
            this.mName.setText(this.jzz.display_name);
            czT();
            if (this.jzz.newest != null) {
                if (TextUtils.isEmpty(this.jzz.newest.change_log)) {
                    this.jzv.setText("");
                } else {
                    this.jzv.setText(this.jzz.newest.change_log);
                }
                if (this.jzz.newest.size <= 0) {
                    this.jzw.setText("");
                } else {
                    this.jzw.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.jzz.newest.size / 1024) + "KB");
                }
            }
            this.jzx.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a;
        super.onResume();
        if (this.jzy != null && PluginPackageManager.js().bj(this.bIe) && (a = a(this.jzz)) < 100) {
            am.setViewTextColor(this.jzx, R.color.cp_cont_d, 1);
            this.jzA.setShadowColor(0);
            this.jzx.setEnabled(false);
            this.jzx.setVisibility(8);
            this.jzy.setVisibility(0);
            this.gQB.setVisibility(0);
            this.jzy.setProgress(a);
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
    public void czT() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.js().bh(this.bIe) && PluginPackageManager.js().bf(this.bIe)) {
            this.fnh.setText(R.string.plugin_enabled);
            this.jzx.setVisibility(0);
            this.jzx.setText(R.string.download_update);
            this.jzx.setEnabled(true);
            am.setBackgroundResource(this.jzx, R.drawable.selector_blue_gradient_button);
            this.jzA.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.jzx, R.color.cp_cont_g, 1);
            this.jzy.setVisibility(8);
            this.gQB.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.js().bf(this.bIe)) {
            this.jzx.setEnabled(true);
            am.setViewTextColor(this.jzx, R.color.cp_cont_g, 1);
            this.jzx.setVisibility(0);
            this.jzy.setVisibility(8);
            this.gQB.setVisibility(8);
            if (PluginPackageManager.js().bg(this.bIe)) {
                this.fnh.setText(R.string.plugin_unenabled);
                this.jzx.setText(R.string.plugin_enable);
                am.setBackgroundResource(this.jzx, R.drawable.selector_blue_gradient_button);
                this.jzA.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.fnh.setText(R.string.plugin_enabled);
            this.jzx.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.jzz != null && this.jzz.can_forbidden == 1) {
                this.jzx.setEnabled(false);
                this.jzx.setVisibility(8);
                this.jzA.setShadowColor(0);
                return;
            }
            this.jzx.setEnabled(true);
            this.jzx.setVisibility(0);
            am.setBackgroundResource(this.jzx, R.drawable.button_plugin_forbidden);
            this.jzA.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.jzx.setVisibility(0);
            this.fnh.setText(R.string.plugin_disabled);
            this.jzx.setText(R.string.install_app);
            this.jzx.setEnabled(true);
            am.setBackgroundResource(this.jzx, R.drawable.selector_blue_gradient_button);
            this.jzA.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.jzx, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.jzy.setVisibility(8);
            this.gQB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jzy.setProgressDrawable(am.getDrawable(R.drawable.download_progressbar));
        this.jzy.setIndeterminateDrawable(am.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jzx) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                czU();
            } else if (this.mStatus == 3) {
                PluginPackageManager.js().bd(this.bIe);
                czT();
            } else if (this.mStatus == 2) {
                PluginPackageManager.js().be(this.bIe);
                czT();
            }
        }
    }

    private void czU() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            czV();
        } else if (this.jzz != null && !TextUtils.isEmpty(this.jzz.package_name) && !PluginPackageManager.js().bj(this.jzz.package_name)) {
            this.jzx.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.js().a(this.jzz, this.yy);
        }
    }

    private void czV() {
        String string;
        String string2;
        if (this.jzz != null && this.jzz.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.jzz.newest.size / 1048576.0f;
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
                    am.setViewTextColor(PluginDetailActivity.this.jzx, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.jzx.setEnabled(false);
                    PluginPackageManager.js().a(PluginDetailActivity.this.jzz, PluginDetailActivity.this.yy);
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
            aVar.aEC();
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
