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
    private String bId;
    private TextView fmU;
    private TextView gQp;
    private HeadImageView jzi;
    private TextView jzj;
    private TextView jzk;
    private TextView jzl;
    private ProgressBar jzm;
    private PluginNetConfigInfos.PluginConfig jzn;
    private ShadowLayout jzo;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d yy = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.jzn != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.jzn.package_name) && !PluginDetailActivity.this.mFinished) {
                am.setViewTextColor(PluginDetailActivity.this.jzl, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.jzo.setShadowColor(0);
                PluginDetailActivity.this.jzl.setEnabled(false);
                PluginDetailActivity.this.jzl.setVisibility(8);
                PluginDetailActivity.this.jzm.setVisibility(0);
                PluginDetailActivity.this.gQp.setVisibility(0);
                PluginDetailActivity.this.jzm.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.jzn != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.jzn.package_name)) {
                PluginDetailActivity.this.jzl.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.jzl.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.jzn != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.jzn.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.czS();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.czS();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.czS();
        }
    };
    private final CustomMessageListener cLy = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.czS();
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
        this.jzi = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.fmU = (TextView) findViewById(R.id.status);
        this.jzm = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.gQp = (TextView) findViewById(R.id.plugin_download_text);
        this.jzj = (TextView) findViewById(R.id.changelog);
        this.jzk = (TextView) findViewById(R.id.size);
        this.jzl = (TextView) findViewById(R.id.enable);
        this.jzl.setOnClickListener(this);
        this.jzo = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.bId = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jP().jQ() != null) {
            this.jzn = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jP().jQ().getPluginConfig(this.bId);
        }
        if (PluginPackageManager.js().bj(this.bId)) {
            PluginPackageManager.js().a(this.yy);
            am.setViewTextColor(this.jzl, R.color.cp_cont_d, 1);
            this.jzl.setEnabled(false);
        }
        registerListener(this.cLy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jzn != null) {
            this.jzi.startLoad(this.jzn.icon, 10, false);
            if (this.jzn.display_name == null) {
                this.jzn.display_name = "";
            }
            this.mName.setText(this.jzn.display_name);
            czS();
            if (this.jzn.newest != null) {
                if (TextUtils.isEmpty(this.jzn.newest.change_log)) {
                    this.jzj.setText("");
                } else {
                    this.jzj.setText(this.jzn.newest.change_log);
                }
                if (this.jzn.newest.size <= 0) {
                    this.jzk.setText("");
                } else {
                    this.jzk.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.jzn.newest.size / 1024) + "KB");
                }
            }
            this.jzl.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a;
        super.onResume();
        if (this.jzm != null && PluginPackageManager.js().bj(this.bId) && (a = a(this.jzn)) < 100) {
            am.setViewTextColor(this.jzl, R.color.cp_cont_d, 1);
            this.jzo.setShadowColor(0);
            this.jzl.setEnabled(false);
            this.jzl.setVisibility(8);
            this.jzm.setVisibility(0);
            this.gQp.setVisibility(0);
            this.jzm.setProgress(a);
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
    public void czS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.js().bh(this.bId) && PluginPackageManager.js().bf(this.bId)) {
            this.fmU.setText(R.string.plugin_enabled);
            this.jzl.setVisibility(0);
            this.jzl.setText(R.string.download_update);
            this.jzl.setEnabled(true);
            am.setBackgroundResource(this.jzl, R.drawable.selector_blue_gradient_button);
            this.jzo.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.jzl, R.color.cp_cont_g, 1);
            this.jzm.setVisibility(8);
            this.gQp.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.js().bf(this.bId)) {
            this.jzl.setEnabled(true);
            am.setViewTextColor(this.jzl, R.color.cp_cont_g, 1);
            this.jzl.setVisibility(0);
            this.jzm.setVisibility(8);
            this.gQp.setVisibility(8);
            if (PluginPackageManager.js().bg(this.bId)) {
                this.fmU.setText(R.string.plugin_unenabled);
                this.jzl.setText(R.string.plugin_enable);
                am.setBackgroundResource(this.jzl, R.drawable.selector_blue_gradient_button);
                this.jzo.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.fmU.setText(R.string.plugin_enabled);
            this.jzl.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.jzn != null && this.jzn.can_forbidden == 1) {
                this.jzl.setEnabled(false);
                this.jzl.setVisibility(8);
                this.jzo.setShadowColor(0);
                return;
            }
            this.jzl.setEnabled(true);
            this.jzl.setVisibility(0);
            am.setBackgroundResource(this.jzl, R.drawable.button_plugin_forbidden);
            this.jzo.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.jzl.setVisibility(0);
            this.fmU.setText(R.string.plugin_disabled);
            this.jzl.setText(R.string.install_app);
            this.jzl.setEnabled(true);
            am.setBackgroundResource(this.jzl, R.drawable.selector_blue_gradient_button);
            this.jzo.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.jzl, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.jzm.setVisibility(8);
            this.gQp.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jzm.setProgressDrawable(am.getDrawable(R.drawable.download_progressbar));
        this.jzm.setIndeterminateDrawable(am.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jzl) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                czT();
            } else if (this.mStatus == 3) {
                PluginPackageManager.js().bd(this.bId);
                czS();
            } else if (this.mStatus == 2) {
                PluginPackageManager.js().be(this.bId);
                czS();
            }
        }
    }

    private void czT() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            czU();
        } else if (this.jzn != null && !TextUtils.isEmpty(this.jzn.package_name) && !PluginPackageManager.js().bj(this.jzn.package_name)) {
            this.jzl.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.js().a(this.jzn, this.yy);
        }
    }

    private void czU() {
        String string;
        String string2;
        if (this.jzn != null && this.jzn.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.jzn.newest.size / 1048576.0f;
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
                    am.setViewTextColor(PluginDetailActivity.this.jzl, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.jzl.setEnabled(false);
                    PluginPackageManager.js().a(PluginDetailActivity.this.jzn, PluginDetailActivity.this.yy);
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
