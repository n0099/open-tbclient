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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugin.ShadowLayout;
import com.baidu.tieba.R;
import java.io.File;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes15.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String czH;
    private TextView dKC;
    private TextView gzq;
    private TextView lfA;
    private ProgressBar lfB;
    private PluginNetConfigInfos.PluginConfig lfC;
    private ShadowLayout lfD;
    private HeadImageView lfx;
    private TextView lfy;
    private TextView lfz;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Sr = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.lfC != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.lfC.package_name) && !PluginDetailActivity.this.mFinished) {
                ao.setViewTextColor(PluginDetailActivity.this.lfA, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.lfD.setShadowColor(0);
                PluginDetailActivity.this.lfA.setEnabled(false);
                PluginDetailActivity.this.lfA.setVisibility(8);
                PluginDetailActivity.this.lfB.setVisibility(0);
                PluginDetailActivity.this.dKC.setVisibility(0);
                PluginDetailActivity.this.lfB.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.lfC != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.lfC.package_name)) {
                PluginDetailActivity.this.lfA.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.lfA.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.lfC != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.lfC.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.cZI();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.cZI();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.cZI();
        }
    };
    private final CustomMessageListener dLm = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.cZI();
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
        this.lfx = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.gzq = (TextView) findViewById(R.id.status);
        this.lfB = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.dKC = (TextView) findViewById(R.id.plugin_download_text);
        this.lfy = (TextView) findViewById(R.id.changelog);
        this.lfz = (TextView) findViewById(R.id.size);
        this.lfA = (TextView) findViewById(R.id.enable);
        this.lfA.setOnClickListener(this);
        this.lfD = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.czH = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.oL().oM() != null) {
            this.lfC = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.oL().oM().getPluginConfig(this.czH);
        }
        if (PluginPackageManager.op().cy(this.czH)) {
            PluginPackageManager.op().a(this.Sr);
            ao.setViewTextColor(this.lfA, R.color.cp_cont_d, 1);
            this.lfA.setEnabled(false);
        }
        registerListener(this.dLm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.lfC != null) {
            this.lfx.startLoad(this.lfC.icon, 10, false);
            if (this.lfC.display_name == null) {
                this.lfC.display_name = "";
            }
            this.mName.setText(this.lfC.display_name);
            cZI();
            if (this.lfC.newest != null) {
                if (TextUtils.isEmpty(this.lfC.newest.change_log)) {
                    this.lfy.setText("");
                } else {
                    this.lfy.setText(this.lfC.newest.change_log);
                }
                if (this.lfC.newest.size <= 0) {
                    this.lfz.setText("");
                } else {
                    this.lfz.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.lfC.newest.size / 1024) + "KB");
                }
            }
            this.lfA.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a;
        super.onResume();
        if (this.lfB != null && PluginPackageManager.op().cy(this.czH) && (a = a(this.lfC)) < 100) {
            ao.setViewTextColor(this.lfA, R.color.cp_cont_d, 1);
            this.lfD.setShadowColor(0);
            this.lfA.setEnabled(false);
            this.lfA.setVisibility(8);
            this.lfB.setVisibility(0);
            this.dKC.setVisibility(0);
            this.lfB.setProgress(a);
        }
        PluginPackageManager.op().a(this.Sr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.op().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZI() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.op().cw(this.czH) && PluginPackageManager.op().cu(this.czH)) {
            this.gzq.setText(R.string.plugin_enabled);
            this.lfA.setVisibility(0);
            this.lfA.setText(R.string.download_update);
            this.lfA.setEnabled(true);
            ao.setBackgroundResource(this.lfA, R.drawable.selector_blue_gradient_button);
            this.lfD.setShadowColor(R.color.plugin_button_shadow_blue);
            ao.setViewTextColor(this.lfA, R.color.cp_cont_g, 1);
            this.lfB.setVisibility(8);
            this.dKC.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.op().cu(this.czH)) {
            this.lfA.setEnabled(true);
            ao.setViewTextColor(this.lfA, R.color.cp_cont_g, 1);
            this.lfA.setVisibility(0);
            this.lfB.setVisibility(8);
            this.dKC.setVisibility(8);
            if (PluginPackageManager.op().cv(this.czH)) {
                this.gzq.setText(R.string.plugin_unenabled);
                this.lfA.setText(R.string.plugin_enable);
                ao.setBackgroundResource(this.lfA, R.drawable.selector_blue_gradient_button);
                this.lfD.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.gzq.setText(R.string.plugin_enabled);
            this.lfA.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.lfC != null && this.lfC.can_forbidden == 1) {
                this.lfA.setEnabled(false);
                this.lfA.setVisibility(8);
                this.lfD.setShadowColor(0);
                return;
            }
            this.lfA.setEnabled(true);
            this.lfA.setVisibility(0);
            ao.setBackgroundResource(this.lfA, R.drawable.button_plugin_forbidden);
            this.lfD.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.lfA.setVisibility(0);
            this.gzq.setText(R.string.plugin_disabled);
            this.lfA.setText(R.string.install_app);
            this.lfA.setEnabled(true);
            ao.setBackgroundResource(this.lfA, R.drawable.selector_blue_gradient_button);
            this.lfD.setShadowColor(R.color.plugin_button_shadow_blue);
            ao.setViewTextColor(this.lfA, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.lfB.setVisibility(8);
            this.dKC.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lfB.setProgressDrawable(ao.getDrawable(R.drawable.download_progressbar));
        this.lfB.setIndeterminateDrawable(ao.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lfA) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                cZJ();
            } else if (this.mStatus == 3) {
                PluginPackageManager.op().cs(this.czH);
                cZI();
            } else if (this.mStatus == 2) {
                PluginPackageManager.op().ct(this.czH);
                cZI();
            }
        }
    }

    private void cZJ() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            cZK();
        } else if (this.lfC != null && !TextUtils.isEmpty(this.lfC.package_name) && !PluginPackageManager.op().cy(this.lfC.package_name)) {
            this.lfA.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.op().a(this.lfC, this.Sr);
        }
    }

    private void cZK() {
        String string;
        String string2;
        if (this.lfC != null && this.lfC.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.lfC.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.xl(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ao.setViewTextColor(PluginDetailActivity.this.lfA, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.lfA.setEnabled(false);
                    PluginPackageManager.op().a(PluginDetailActivity.this.lfC, PluginDetailActivity.this.Sr);
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
            aVar.aYL();
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
        if (pluginConfig == null || (findPluginSetting = c.oR().findPluginSetting(pluginConfig.package_name)) == null) {
            return 0;
        }
        String f = Util.f(findPluginSetting);
        if (as.isEmpty(f)) {
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
