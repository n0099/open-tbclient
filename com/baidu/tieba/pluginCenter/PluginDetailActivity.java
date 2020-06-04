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
    private TextView ggX;
    private TextView hRp;
    private HeadImageView kEf;
    private TextView kEg;
    private TextView kEh;
    private TextView kEi;
    private ProgressBar kEj;
    private PluginNetConfigInfos.PluginConfig kEk;
    private ShadowLayout kEl;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d RT = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.kEk != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.kEk.package_name) && !PluginDetailActivity.this.mFinished) {
                am.setViewTextColor(PluginDetailActivity.this.kEi, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.kEl.setShadowColor(0);
                PluginDetailActivity.this.kEi.setEnabled(false);
                PluginDetailActivity.this.kEi.setVisibility(8);
                PluginDetailActivity.this.kEj.setVisibility(0);
                PluginDetailActivity.this.hRp.setVisibility(0);
                PluginDetailActivity.this.kEj.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.kEk != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.kEk.package_name)) {
                PluginDetailActivity.this.kEi.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.kEi.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.kEk != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.kEk.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.cSl();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.cSl();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.cSl();
        }
    };
    private final CustomMessageListener dyW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.cSl();
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
        this.kEf = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.ggX = (TextView) findViewById(R.id.status);
        this.kEj = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.hRp = (TextView) findViewById(R.id.plugin_download_text);
        this.kEg = (TextView) findViewById(R.id.changelog);
        this.kEh = (TextView) findViewById(R.id.size);
        this.kEi = (TextView) findViewById(R.id.enable);
        this.kEi.setOnClickListener(this);
        this.kEl = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.cst = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ou().ov() != null) {
            this.kEk = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ou().ov().getPluginConfig(this.cst);
        }
        if (PluginPackageManager.nX().cz(this.cst)) {
            PluginPackageManager.nX().a(this.RT);
            am.setViewTextColor(this.kEi, R.color.cp_cont_d, 1);
            this.kEi.setEnabled(false);
        }
        registerListener(this.dyW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.kEk != null) {
            this.kEf.startLoad(this.kEk.icon, 10, false);
            if (this.kEk.display_name == null) {
                this.kEk.display_name = "";
            }
            this.mName.setText(this.kEk.display_name);
            cSl();
            if (this.kEk.newest != null) {
                if (TextUtils.isEmpty(this.kEk.newest.change_log)) {
                    this.kEg.setText("");
                } else {
                    this.kEg.setText(this.kEk.newest.change_log);
                }
                if (this.kEk.newest.size <= 0) {
                    this.kEh.setText("");
                } else {
                    this.kEh.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.kEk.newest.size / 1024) + "KB");
                }
            }
            this.kEi.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a;
        super.onResume();
        if (this.kEj != null && PluginPackageManager.nX().cz(this.cst) && (a = a(this.kEk)) < 100) {
            am.setViewTextColor(this.kEi, R.color.cp_cont_d, 1);
            this.kEl.setShadowColor(0);
            this.kEi.setEnabled(false);
            this.kEi.setVisibility(8);
            this.kEj.setVisibility(0);
            this.hRp.setVisibility(0);
            this.kEj.setProgress(a);
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
    public void cSl() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.nX().cx(this.cst) && PluginPackageManager.nX().cv(this.cst)) {
            this.ggX.setText(R.string.plugin_enabled);
            this.kEi.setVisibility(0);
            this.kEi.setText(R.string.download_update);
            this.kEi.setEnabled(true);
            am.setBackgroundResource(this.kEi, R.drawable.selector_blue_gradient_button);
            this.kEl.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.kEi, R.color.cp_cont_g, 1);
            this.kEj.setVisibility(8);
            this.hRp.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.nX().cv(this.cst)) {
            this.kEi.setEnabled(true);
            am.setViewTextColor(this.kEi, R.color.cp_cont_g, 1);
            this.kEi.setVisibility(0);
            this.kEj.setVisibility(8);
            this.hRp.setVisibility(8);
            if (PluginPackageManager.nX().cw(this.cst)) {
                this.ggX.setText(R.string.plugin_unenabled);
                this.kEi.setText(R.string.plugin_enable);
                am.setBackgroundResource(this.kEi, R.drawable.selector_blue_gradient_button);
                this.kEl.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.ggX.setText(R.string.plugin_enabled);
            this.kEi.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.kEk != null && this.kEk.can_forbidden == 1) {
                this.kEi.setEnabled(false);
                this.kEi.setVisibility(8);
                this.kEl.setShadowColor(0);
                return;
            }
            this.kEi.setEnabled(true);
            this.kEi.setVisibility(0);
            am.setBackgroundResource(this.kEi, R.drawable.button_plugin_forbidden);
            this.kEl.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.kEi.setVisibility(0);
            this.ggX.setText(R.string.plugin_disabled);
            this.kEi.setText(R.string.install_app);
            this.kEi.setEnabled(true);
            am.setBackgroundResource(this.kEi, R.drawable.selector_blue_gradient_button);
            this.kEl.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.kEi, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.kEj.setVisibility(8);
            this.hRp.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kEj.setProgressDrawable(am.getDrawable(R.drawable.download_progressbar));
        this.kEj.setIndeterminateDrawable(am.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kEi) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                cSm();
            } else if (this.mStatus == 3) {
                PluginPackageManager.nX().ct(this.cst);
                cSl();
            } else if (this.mStatus == 2) {
                PluginPackageManager.nX().cu(this.cst);
                cSl();
            }
        }
    }

    private void cSm() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            cSn();
        } else if (this.kEk != null && !TextUtils.isEmpty(this.kEk.package_name) && !PluginPackageManager.nX().cz(this.kEk.package_name)) {
            this.kEi.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.nX().a(this.kEk, this.RT);
        }
    }

    private void cSn() {
        String string;
        String string2;
        if (this.kEk != null && this.kEk.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.kEk.newest.size / 1048576.0f;
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
                    am.setViewTextColor(PluginDetailActivity.this.kEi, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.kEi.setEnabled(false);
                    PluginPackageManager.nX().a(PluginDetailActivity.this.kEk, PluginDetailActivity.this.RT);
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
