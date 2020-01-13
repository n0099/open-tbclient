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
/* loaded from: classes6.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String bDX;
    private TextView fjZ;
    private TextView gOn;
    private HeadImageView jyl;
    private TextView jym;
    private TextView jyn;
    private TextView jyo;
    private ProgressBar jyp;
    private PluginNetConfigInfos.PluginConfig jyq;
    private ShadowLayout jyr;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d yg = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.jyq != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.jyq.package_name) && !PluginDetailActivity.this.mFinished) {
                am.setViewTextColor(PluginDetailActivity.this.jyo, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.jyr.setShadowColor(0);
                PluginDetailActivity.this.jyo.setEnabled(false);
                PluginDetailActivity.this.jyo.setVisibility(8);
                PluginDetailActivity.this.jyp.setVisibility(0);
                PluginDetailActivity.this.gOn.setVisibility(0);
                PluginDetailActivity.this.jyp.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.jyq != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.jyq.package_name)) {
                PluginDetailActivity.this.jyo.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.jyo.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.jyq != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.jyq.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.cyt();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.cyt();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.cyt();
        }
    };
    private final CustomMessageListener cHu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.cyt();
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
        this.jyl = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.fjZ = (TextView) findViewById(R.id.status);
        this.jyp = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.gOn = (TextView) findViewById(R.id.plugin_download_text);
        this.jym = (TextView) findViewById(R.id.changelog);
        this.jyn = (TextView) findViewById(R.id.size);
        this.jyo = (TextView) findViewById(R.id.enable);
        this.jyo.setOnClickListener(this);
        this.jyr = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.bDX = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jA().jB() != null) {
            this.jyq = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jA().jB().getPluginConfig(this.bDX);
        }
        if (PluginPackageManager.jd().bh(this.bDX)) {
            PluginPackageManager.jd().a(this.yg);
            am.setViewTextColor(this.jyo, R.color.cp_cont_d, 1);
            this.jyo.setEnabled(false);
        }
        registerListener(this.cHu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jyq != null) {
            this.jyl.startLoad(this.jyq.icon, 10, false);
            if (this.jyq.display_name == null) {
                this.jyq.display_name = "";
            }
            this.mName.setText(this.jyq.display_name);
            cyt();
            if (this.jyq.newest != null) {
                if (TextUtils.isEmpty(this.jyq.newest.change_log)) {
                    this.jym.setText("");
                } else {
                    this.jym.setText(this.jyq.newest.change_log);
                }
                if (this.jyq.newest.size <= 0) {
                    this.jyn.setText("");
                } else {
                    this.jyn.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.jyq.newest.size / 1024) + "KB");
                }
            }
            this.jyo.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a;
        super.onResume();
        if (this.jyp != null && PluginPackageManager.jd().bh(this.bDX) && (a = a(this.jyq)) < 100) {
            am.setViewTextColor(this.jyo, R.color.cp_cont_d, 1);
            this.jyr.setShadowColor(0);
            this.jyo.setEnabled(false);
            this.jyo.setVisibility(8);
            this.jyp.setVisibility(0);
            this.gOn.setVisibility(0);
            this.jyp.setProgress(a);
        }
        PluginPackageManager.jd().a(this.yg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.jd().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyt() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.jd().bf(this.bDX) && PluginPackageManager.jd().bd(this.bDX)) {
            this.fjZ.setText(R.string.plugin_enabled);
            this.jyo.setVisibility(0);
            this.jyo.setText(R.string.download_update);
            this.jyo.setEnabled(true);
            am.setBackgroundResource(this.jyo, R.drawable.selector_blue_gradient_button);
            this.jyr.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.jyo, R.color.cp_cont_g, 1);
            this.jyp.setVisibility(8);
            this.gOn.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.jd().bd(this.bDX)) {
            this.jyo.setEnabled(true);
            am.setViewTextColor(this.jyo, R.color.cp_cont_g, 1);
            this.jyo.setVisibility(0);
            this.jyp.setVisibility(8);
            this.gOn.setVisibility(8);
            if (PluginPackageManager.jd().be(this.bDX)) {
                this.fjZ.setText(R.string.plugin_unenabled);
                this.jyo.setText(R.string.plugin_enable);
                am.setBackgroundResource(this.jyo, R.drawable.selector_blue_gradient_button);
                this.jyr.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.fjZ.setText(R.string.plugin_enabled);
            this.jyo.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.jyq != null && this.jyq.can_forbidden == 1) {
                this.jyo.setEnabled(false);
                this.jyo.setVisibility(8);
                this.jyr.setShadowColor(0);
                return;
            }
            this.jyo.setEnabled(true);
            this.jyo.setVisibility(0);
            am.setBackgroundResource(this.jyo, R.drawable.button_plugin_forbidden);
            this.jyr.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.jyo.setVisibility(0);
            this.fjZ.setText(R.string.plugin_disabled);
            this.jyo.setText(R.string.install_app);
            this.jyo.setEnabled(true);
            am.setBackgroundResource(this.jyo, R.drawable.selector_blue_gradient_button);
            this.jyr.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.jyo, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.jyp.setVisibility(8);
            this.gOn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jyp.setProgressDrawable(am.getDrawable(R.drawable.download_progressbar));
        this.jyp.setIndeterminateDrawable(am.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jyo) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                cyu();
            } else if (this.mStatus == 3) {
                PluginPackageManager.jd().bb(this.bDX);
                cyt();
            } else if (this.mStatus == 2) {
                PluginPackageManager.jd().bc(this.bDX);
                cyt();
            }
        }
    }

    private void cyu() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            cyv();
        } else if (this.jyq != null && !TextUtils.isEmpty(this.jyq.package_name) && !PluginPackageManager.jd().bh(this.jyq.package_name)) {
            this.jyo.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.jd().a(this.jyq, this.yg);
        }
    }

    private void cyv() {
        String string;
        String string2;
        if (this.jyq != null && this.jyq.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.jyq.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.sC(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    am.setViewTextColor(PluginDetailActivity.this.jyo, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.jyo.setEnabled(false);
                    PluginPackageManager.jd().a(PluginDetailActivity.this.jyq, PluginDetailActivity.this.yg);
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
            aVar.aCp();
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
        if (pluginConfig == null || (findPluginSetting = c.jG().findPluginSetting(pluginConfig.package_name)) == null) {
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
