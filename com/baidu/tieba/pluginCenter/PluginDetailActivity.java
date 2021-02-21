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
/* loaded from: classes8.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String dsg;
    private TextView eII;
    private TextView hRn;
    private boolean mFinished;
    private HeadImageView mLi;
    private TextView mLj;
    private TextView mLk;
    private TextView mLl;
    private ProgressBar mLm;
    private PluginNetConfigInfos.PluginConfig mLn;
    private ShadowLayout mLo;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Uz = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mLn != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mLn.package_name) && !PluginDetailActivity.this.mFinished) {
                ap.setViewTextColor(PluginDetailActivity.this.mLl, R.color.CAM_X0109, 1);
                PluginDetailActivity.this.mLo.setShadowColor(0);
                PluginDetailActivity.this.mLl.setEnabled(false);
                PluginDetailActivity.this.mLl.setVisibility(8);
                PluginDetailActivity.this.mLm.setVisibility(0);
                PluginDetailActivity.this.eII.setVisibility(0);
                PluginDetailActivity.this.mLm.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mLn != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mLn.package_name)) {
                PluginDetailActivity.this.mLl.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.mLl.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.mLn != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.mLn.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.dAX();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.dAX();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.dAX();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.dAX();
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
        this.mLi = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.hRn = (TextView) findViewById(R.id.status);
        this.mLm = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.eII = (TextView) findViewById(R.id.plugin_download_text);
        this.mLj = (TextView) findViewById(R.id.changelog);
        this.mLk = (TextView) findViewById(R.id.size);
        this.mLl = (TextView) findViewById(R.id.enable);
        this.mLl.setOnClickListener(this);
        this.mLo = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.dsg = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pR().pS() != null) {
            this.mLn = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pR().pS().getPluginConfig(this.dsg);
        }
        if (PluginPackageManager.pv().cE(this.dsg)) {
            PluginPackageManager.pv().a(this.Uz);
            ap.setViewTextColor(this.mLl, R.color.CAM_X0109, 1);
            this.mLl.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mLn != null) {
            this.mLi.startLoad(this.mLn.icon, 10, false);
            if (this.mLn.display_name == null) {
                this.mLn.display_name = "";
            }
            this.mName.setText(this.mLn.display_name);
            dAX();
            if (this.mLn.newest != null) {
                if (TextUtils.isEmpty(this.mLn.newest.change_log)) {
                    this.mLj.setText("");
                } else {
                    this.mLj.setText(this.mLn.newest.change_log);
                }
                if (this.mLn.newest.size <= 0) {
                    this.mLk.setText("");
                } else {
                    this.mLk.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.mLn.newest.size / 1024) + "KB");
                }
            }
            this.mLl.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a2;
        super.onResume();
        if (this.mLm != null && PluginPackageManager.pv().cE(this.dsg) && (a2 = a(this.mLn)) < 100) {
            ap.setViewTextColor(this.mLl, R.color.CAM_X0109, 1);
            this.mLo.setShadowColor(0);
            this.mLl.setEnabled(false);
            this.mLl.setVisibility(8);
            this.mLm.setVisibility(0);
            this.eII.setVisibility(0);
            this.mLm.setProgress(a2);
        }
        PluginPackageManager.pv().a(this.Uz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.pv().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAX() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.pv().cC(this.dsg) && PluginPackageManager.pv().cA(this.dsg)) {
            this.hRn.setText(R.string.plugin_enabled);
            this.mLl.setVisibility(0);
            this.mLl.setText(R.string.download_update);
            this.mLl.setEnabled(true);
            ap.setBackgroundResource(this.mLl, R.drawable.selector_blue_gradient_button);
            this.mLo.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.mLl, R.color.CAM_X0111, 1);
            this.mLm.setVisibility(8);
            this.eII.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.pv().cA(this.dsg)) {
            this.mLl.setEnabled(true);
            ap.setViewTextColor(this.mLl, R.color.CAM_X0111, 1);
            this.mLl.setVisibility(0);
            this.mLm.setVisibility(8);
            this.eII.setVisibility(8);
            if (PluginPackageManager.pv().cB(this.dsg)) {
                this.hRn.setText(R.string.plugin_unenabled);
                this.mLl.setText(R.string.plugin_enable);
                ap.setBackgroundResource(this.mLl, R.drawable.selector_blue_gradient_button);
                this.mLo.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.hRn.setText(R.string.plugin_enabled);
            this.mLl.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.mLn != null && this.mLn.can_forbidden == 1) {
                this.mLl.setEnabled(false);
                this.mLl.setVisibility(8);
                this.mLo.setShadowColor(0);
                return;
            }
            this.mLl.setEnabled(true);
            this.mLl.setVisibility(0);
            ap.setBackgroundResource(this.mLl, R.drawable.button_plugin_forbidden);
            this.mLo.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.mLl.setVisibility(0);
            this.hRn.setText(R.string.plugin_disabled);
            this.mLl.setText(R.string.install_app);
            this.mLl.setEnabled(true);
            ap.setBackgroundResource(this.mLl, R.drawable.selector_blue_gradient_button);
            this.mLo.setShadowColor(R.color.plugin_button_shadow_blue);
            ap.setViewTextColor(this.mLl, R.color.CAM_X0111, 1);
            this.mStatus = 0;
            this.mLm.setVisibility(8);
            this.eII.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mLm.setProgressDrawable(ap.getDrawable(R.drawable.download_progressbar));
        this.mLm.setIndeterminateDrawable(ap.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mLl) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                dAY();
            } else if (this.mStatus == 3) {
                PluginPackageManager.pv().cy(this.dsg);
                dAX();
            } else if (this.mStatus == 2) {
                PluginPackageManager.pv().cz(this.dsg);
                dAX();
            }
        }
    }

    private void dAY() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            dAZ();
        } else if (this.mLn != null && !TextUtils.isEmpty(this.mLn.package_name) && !PluginPackageManager.pv().cE(this.mLn.package_name)) {
            this.mLl.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.pv().a(this.mLn, this.Uz);
        }
    }

    private void dAZ() {
        String string;
        String string2;
        if (this.mLn != null && this.mLn.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.mLn.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.Au(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ap.setViewTextColor(PluginDetailActivity.this.mLl, R.color.CAM_X0109, 1);
                    PluginDetailActivity.this.mLl.setEnabled(false);
                    PluginPackageManager.pv().a(PluginDetailActivity.this.mLn, PluginDetailActivity.this.Uz);
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
            aVar.bqx();
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
