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
    private String cst;
    private TextView ggM;
    private TextView hQC;
    private HeadImageView kCX;
    private TextView kCY;
    private TextView kCZ;
    private TextView kDa;
    private ProgressBar kDb;
    private PluginNetConfigInfos.PluginConfig kDc;
    private ShadowLayout kDd;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d RT = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.kDc != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.kDc.package_name) && !PluginDetailActivity.this.mFinished) {
                am.setViewTextColor(PluginDetailActivity.this.kDa, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.kDd.setShadowColor(0);
                PluginDetailActivity.this.kDa.setEnabled(false);
                PluginDetailActivity.this.kDa.setVisibility(8);
                PluginDetailActivity.this.kDb.setVisibility(0);
                PluginDetailActivity.this.hQC.setVisibility(0);
                PluginDetailActivity.this.kDb.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.kDc != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.kDc.package_name)) {
                PluginDetailActivity.this.kDa.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.kDa.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.kDc != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.kDc.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.cRV();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.cRV();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.cRV();
        }
    };
    private final CustomMessageListener dyW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.cRV();
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
        this.kCX = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.ggM = (TextView) findViewById(R.id.status);
        this.kDb = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.hQC = (TextView) findViewById(R.id.plugin_download_text);
        this.kCY = (TextView) findViewById(R.id.changelog);
        this.kCZ = (TextView) findViewById(R.id.size);
        this.kDa = (TextView) findViewById(R.id.enable);
        this.kDa.setOnClickListener(this);
        this.kDd = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.cst = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ou().ov() != null) {
            this.kDc = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ou().ov().getPluginConfig(this.cst);
        }
        if (PluginPackageManager.nX().cz(this.cst)) {
            PluginPackageManager.nX().a(this.RT);
            am.setViewTextColor(this.kDa, R.color.cp_cont_d, 1);
            this.kDa.setEnabled(false);
        }
        registerListener(this.dyW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.kDc != null) {
            this.kCX.startLoad(this.kDc.icon, 10, false);
            if (this.kDc.display_name == null) {
                this.kDc.display_name = "";
            }
            this.mName.setText(this.kDc.display_name);
            cRV();
            if (this.kDc.newest != null) {
                if (TextUtils.isEmpty(this.kDc.newest.change_log)) {
                    this.kCY.setText("");
                } else {
                    this.kCY.setText(this.kDc.newest.change_log);
                }
                if (this.kDc.newest.size <= 0) {
                    this.kCZ.setText("");
                } else {
                    this.kCZ.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.kDc.newest.size / 1024) + "KB");
                }
            }
            this.kDa.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a;
        super.onResume();
        if (this.kDb != null && PluginPackageManager.nX().cz(this.cst) && (a = a(this.kDc)) < 100) {
            am.setViewTextColor(this.kDa, R.color.cp_cont_d, 1);
            this.kDd.setShadowColor(0);
            this.kDa.setEnabled(false);
            this.kDa.setVisibility(8);
            this.kDb.setVisibility(0);
            this.hQC.setVisibility(0);
            this.kDb.setProgress(a);
        }
        PluginPackageManager.nX().a(this.RT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.nX().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRV() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.nX().cx(this.cst) && PluginPackageManager.nX().cv(this.cst)) {
            this.ggM.setText(R.string.plugin_enabled);
            this.kDa.setVisibility(0);
            this.kDa.setText(R.string.download_update);
            this.kDa.setEnabled(true);
            am.setBackgroundResource(this.kDa, R.drawable.selector_blue_gradient_button);
            this.kDd.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.kDa, R.color.cp_cont_g, 1);
            this.kDb.setVisibility(8);
            this.hQC.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.nX().cv(this.cst)) {
            this.kDa.setEnabled(true);
            am.setViewTextColor(this.kDa, R.color.cp_cont_g, 1);
            this.kDa.setVisibility(0);
            this.kDb.setVisibility(8);
            this.hQC.setVisibility(8);
            if (PluginPackageManager.nX().cw(this.cst)) {
                this.ggM.setText(R.string.plugin_unenabled);
                this.kDa.setText(R.string.plugin_enable);
                am.setBackgroundResource(this.kDa, R.drawable.selector_blue_gradient_button);
                this.kDd.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.ggM.setText(R.string.plugin_enabled);
            this.kDa.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.kDc != null && this.kDc.can_forbidden == 1) {
                this.kDa.setEnabled(false);
                this.kDa.setVisibility(8);
                this.kDd.setShadowColor(0);
                return;
            }
            this.kDa.setEnabled(true);
            this.kDa.setVisibility(0);
            am.setBackgroundResource(this.kDa, R.drawable.button_plugin_forbidden);
            this.kDd.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.kDa.setVisibility(0);
            this.ggM.setText(R.string.plugin_disabled);
            this.kDa.setText(R.string.install_app);
            this.kDa.setEnabled(true);
            am.setBackgroundResource(this.kDa, R.drawable.selector_blue_gradient_button);
            this.kDd.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.kDa, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.kDb.setVisibility(8);
            this.hQC.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kDb.setProgressDrawable(am.getDrawable(R.drawable.download_progressbar));
        this.kDb.setIndeterminateDrawable(am.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kDa) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                cRW();
            } else if (this.mStatus == 3) {
                PluginPackageManager.nX().ct(this.cst);
                cRV();
            } else if (this.mStatus == 2) {
                PluginPackageManager.nX().cu(this.cst);
                cRV();
            }
        }
    }

    private void cRW() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            cRX();
        } else if (this.kDc != null && !TextUtils.isEmpty(this.kDc.package_name) && !PluginPackageManager.nX().cz(this.kDc.package_name)) {
            this.kDa.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.nX().a(this.kDc, this.RT);
        }
    }

    private void cRX() {
        String string;
        String string2;
        if (this.kDc != null && this.kDc.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.kDc.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.vO(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    am.setViewTextColor(PluginDetailActivity.this.kDa, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.kDa.setEnabled(false);
                    PluginPackageManager.nX().a(PluginDetailActivity.this.kDc, PluginDetailActivity.this.RT);
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
            aVar.aST();
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
        if (pluginConfig == null || (findPluginSetting = c.oA().findPluginSetting(pluginConfig.package_name)) == null) {
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
