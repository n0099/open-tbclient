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
/* loaded from: classes15.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String cHQ;
    private TextView dTK;
    private TextView gLN;
    private HeadImageView lvQ;
    private TextView lvR;
    private TextView lvS;
    private TextView lvT;
    private ProgressBar lvU;
    private PluginNetConfigInfos.PluginConfig lvV;
    private ShadowLayout lvW;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d SY = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.lvV != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.lvV.package_name) && !PluginDetailActivity.this.mFinished) {
                ap.setViewTextColor(PluginDetailActivity.this.lvT, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.lvW.setShadowColor(0);
                PluginDetailActivity.this.lvT.setEnabled(false);
                PluginDetailActivity.this.lvT.setVisibility(8);
                PluginDetailActivity.this.lvU.setVisibility(0);
                PluginDetailActivity.this.dTK.setVisibility(0);
                PluginDetailActivity.this.lvU.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.lvV != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.lvV.package_name)) {
                PluginDetailActivity.this.lvT.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.lvT.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.lvV != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.lvV.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.dkM();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.dkM();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.dkM();
        }
    };
    private final CustomMessageListener dUu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.dkM();
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
        this.lvQ = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.gLN = (TextView) findViewById(R.id.status);
        this.lvU = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.dTK = (TextView) findViewById(R.id.plugin_download_text);
        this.lvR = (TextView) findViewById(R.id.changelog);
        this.lvS = (TextView) findViewById(R.id.size);
        this.lvT = (TextView) findViewById(R.id.enable);
        this.lvT.setOnClickListener(this);
        this.lvW = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.cHQ = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qk().ql() != null) {
            this.lvV = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qk().ql().getPluginConfig(this.cHQ);
        }
        if (PluginPackageManager.pO().cD(this.cHQ)) {
            PluginPackageManager.pO().a(this.SY);
            ap.setViewTextColor(this.lvT, R.color.cp_cont_d, 1);
            this.lvT.setEnabled(false);
        }
        registerListener(this.dUu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.lvV != null) {
            this.lvQ.startLoad(this.lvV.icon, 10, false);
            if (this.lvV.display_name == null) {
                this.lvV.display_name = "";
            }
            this.mName.setText(this.lvV.display_name);
            dkM();
            if (this.lvV.newest != null) {
                if (TextUtils.isEmpty(this.lvV.newest.change_log)) {
                    this.lvR.setText("");
                } else {
                    this.lvR.setText(this.lvV.newest.change_log);
                }
                if (this.lvV.newest.size <= 0) {
                    this.lvS.setText("");
                } else {
                    this.lvS.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.lvV.newest.size / 1024) + "KB");
                }
            }
            this.lvT.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a;
        super.onResume();
        if (this.lvU != null && PluginPackageManager.pO().cD(this.cHQ) && (a = a(this.lvV)) < 100) {
            ap.setViewTextColor(this.lvT, R.color.cp_cont_d, 1);
            this.lvW.setShadowColor(0);
            this.lvT.setEnabled(false);
            this.lvT.setVisibility(8);
            this.lvU.setVisibility(0);
            this.dTK.setVisibility(0);
            this.lvU.setProgress(a);
        }
        PluginPackageManager.pO().a(this.SY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.pO().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkM() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.pO().cB(this.cHQ) && PluginPackageManager.pO().cz(this.cHQ)) {
            this.gLN.setText(R.string.plugin_enabled);
            this.lvT.setVisibility(0);
            this.lvT.setText(R.string.download_update);
            this.lvT.setEnabled(true);
            ap.setBackgroundResource(this.lvT, R.drawable.selector_blue_gradient_button);
            this.lvW.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.lvT, R.color.cp_cont_g, 1);
            this.lvU.setVisibility(8);
            this.dTK.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.pO().cz(this.cHQ)) {
            this.lvT.setEnabled(true);
            ap.setViewTextColor(this.lvT, R.color.cp_cont_g, 1);
            this.lvT.setVisibility(0);
            this.lvU.setVisibility(8);
            this.dTK.setVisibility(8);
            if (PluginPackageManager.pO().cA(this.cHQ)) {
                this.gLN.setText(R.string.plugin_unenabled);
                this.lvT.setText(R.string.plugin_enable);
                ap.setBackgroundResource(this.lvT, R.drawable.selector_blue_gradient_button);
                this.lvW.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.gLN.setText(R.string.plugin_enabled);
            this.lvT.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.lvV != null && this.lvV.can_forbidden == 1) {
                this.lvT.setEnabled(false);
                this.lvT.setVisibility(8);
                this.lvW.setShadowColor(0);
                return;
            }
            this.lvT.setEnabled(true);
            this.lvT.setVisibility(0);
            ap.setBackgroundResource(this.lvT, R.drawable.button_plugin_forbidden);
            this.lvW.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.lvT.setVisibility(0);
            this.gLN.setText(R.string.plugin_disabled);
            this.lvT.setText(R.string.install_app);
            this.lvT.setEnabled(true);
            ap.setBackgroundResource(this.lvT, R.drawable.selector_blue_gradient_button);
            this.lvW.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.lvT, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.lvU.setVisibility(8);
            this.dTK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lvU.setProgressDrawable(ap.getDrawable(R.drawable.download_progressbar));
        this.lvU.setIndeterminateDrawable(ap.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lvT) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                dkN();
            } else if (this.mStatus == 3) {
                PluginPackageManager.pO().cx(this.cHQ);
                dkM();
            } else if (this.mStatus == 2) {
                PluginPackageManager.pO().cy(this.cHQ);
                dkM();
            }
        }
    }

    private void dkN() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            dkO();
        } else if (this.lvV != null && !TextUtils.isEmpty(this.lvV.package_name) && !PluginPackageManager.pO().cD(this.lvV.package_name)) {
            this.lvT.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.pO().a(this.lvV, this.SY);
        }
    }

    private void dkO() {
        String string;
        String string2;
        if (this.lvV != null && this.lvV.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.lvV.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.zz(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ap.setViewTextColor(PluginDetailActivity.this.lvT, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.lvT.setEnabled(false);
                    PluginPackageManager.pO().a(PluginDetailActivity.this.lvV, PluginDetailActivity.this.SY);
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
            aVar.bhg();
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
        if (pluginConfig == null || (findPluginSetting = c.qq().findPluginSetting(pluginConfig.package_name)) == null) {
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
