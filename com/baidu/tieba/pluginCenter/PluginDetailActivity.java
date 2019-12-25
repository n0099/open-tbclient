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
/* loaded from: classes5.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String bDm;
    private TextView fgN;
    private TextView gLa;
    private HeadImageView juJ;
    private TextView juK;
    private TextView juL;
    private TextView juM;
    private ProgressBar juN;
    private PluginNetConfigInfos.PluginConfig juO;
    private ShadowLayout juP;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d yc = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.juO != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.juO.package_name) && !PluginDetailActivity.this.mFinished) {
                am.setViewTextColor(PluginDetailActivity.this.juM, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.juP.setShadowColor(0);
                PluginDetailActivity.this.juM.setEnabled(false);
                PluginDetailActivity.this.juM.setVisibility(8);
                PluginDetailActivity.this.juN.setVisibility(0);
                PluginDetailActivity.this.gLa.setVisibility(0);
                PluginDetailActivity.this.juN.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.juO != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.juO.package_name)) {
                PluginDetailActivity.this.juM.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.juM.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.juO != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.juO.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.cxm();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.cxm();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.cxm();
        }
    };
    private final CustomMessageListener cHi = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                PluginDetailActivity.this.cxm();
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
        this.juJ = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.fgN = (TextView) findViewById(R.id.status);
        this.juN = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.gLa = (TextView) findViewById(R.id.plugin_download_text);
        this.juK = (TextView) findViewById(R.id.changelog);
        this.juL = (TextView) findViewById(R.id.size);
        this.juM = (TextView) findViewById(R.id.enable);
        this.juM.setOnClickListener(this);
        this.juP = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.bDm = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jB().jC() != null) {
            this.juO = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jB().jC().getPluginConfig(this.bDm);
        }
        if (PluginPackageManager.je().bh(this.bDm)) {
            PluginPackageManager.je().a(this.yc);
            am.setViewTextColor(this.juM, R.color.cp_cont_d, 1);
            this.juM.setEnabled(false);
        }
        registerListener(this.cHi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.juO != null) {
            this.juJ.startLoad(this.juO.icon, 10, false);
            if (this.juO.display_name == null) {
                this.juO.display_name = "";
            }
            this.mName.setText(this.juO.display_name);
            cxm();
            if (this.juO.newest != null) {
                if (TextUtils.isEmpty(this.juO.newest.change_log)) {
                    this.juK.setText("");
                } else {
                    this.juK.setText(this.juO.newest.change_log);
                }
                if (this.juO.newest.size <= 0) {
                    this.juL.setText("");
                } else {
                    this.juL.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.juO.newest.size / 1024) + "KB");
                }
            }
            this.juM.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        int a;
        super.onResume();
        if (this.juN != null && PluginPackageManager.je().bh(this.bDm) && (a = a(this.juO)) < 100) {
            am.setViewTextColor(this.juM, R.color.cp_cont_d, 1);
            this.juP.setShadowColor(0);
            this.juM.setEnabled(false);
            this.juM.setVisibility(8);
            this.juN.setVisibility(0);
            this.gLa.setVisibility(0);
            this.juN.setProgress(a);
        }
        PluginPackageManager.je().a(this.yc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.je().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxm() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.je().bf(this.bDm) && PluginPackageManager.je().bd(this.bDm)) {
            this.fgN.setText(R.string.plugin_enabled);
            this.juM.setVisibility(0);
            this.juM.setText(R.string.download_update);
            this.juM.setEnabled(true);
            am.setBackgroundResource(this.juM, R.drawable.selector_blue_gradient_button);
            this.juP.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.juM, R.color.cp_cont_g, 1);
            this.juN.setVisibility(8);
            this.gLa.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.je().bd(this.bDm)) {
            this.juM.setEnabled(true);
            am.setViewTextColor(this.juM, R.color.cp_cont_g, 1);
            this.juM.setVisibility(0);
            this.juN.setVisibility(8);
            this.gLa.setVisibility(8);
            if (PluginPackageManager.je().be(this.bDm)) {
                this.fgN.setText(R.string.plugin_unenabled);
                this.juM.setText(R.string.plugin_enable);
                am.setBackgroundResource(this.juM, R.drawable.selector_blue_gradient_button);
                this.juP.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.fgN.setText(R.string.plugin_enabled);
            this.juM.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.juO != null && this.juO.can_forbidden == 1) {
                this.juM.setEnabled(false);
                this.juM.setVisibility(8);
                this.juP.setShadowColor(0);
                return;
            }
            this.juM.setEnabled(true);
            this.juM.setVisibility(0);
            am.setBackgroundResource(this.juM, R.drawable.button_plugin_forbidden);
            this.juP.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.juM.setVisibility(0);
            this.fgN.setText(R.string.plugin_disabled);
            this.juM.setText(R.string.install_app);
            this.juM.setEnabled(true);
            am.setBackgroundResource(this.juM, R.drawable.selector_blue_gradient_button);
            this.juP.setShadowColor(R.color.plugin_button_shadow_blue);
            am.setViewTextColor(this.juM, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.juN.setVisibility(8);
            this.gLa.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.juN.setProgressDrawable(am.getDrawable(R.drawable.download_progressbar));
        this.juN.setIndeterminateDrawable(am.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.juM) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                cxn();
            } else if (this.mStatus == 3) {
                PluginPackageManager.je().bb(this.bDm);
                cxm();
            } else if (this.mStatus == 2) {
                PluginPackageManager.je().bc(this.bDm);
                cxm();
            }
        }
    }

    private void cxn() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (j.isMobileNet()) {
            cxo();
        } else if (this.juO != null && !TextUtils.isEmpty(this.juO.package_name) && !PluginPackageManager.je().bh(this.juO.package_name)) {
            this.juM.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.je().a(this.juO, this.yc);
        }
    }

    private void cxo() {
        String string;
        String string2;
        if (this.juO != null && this.juO.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.juO.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.sz(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    am.setViewTextColor(PluginDetailActivity.this.juM, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.juM.setEnabled(false);
                    PluginPackageManager.je().a(PluginDetailActivity.this.juO, PluginDetailActivity.this.yc);
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
            aVar.aBW();
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
        if (pluginConfig == null || (findPluginSetting = c.jH().findPluginSetting(pluginConfig.package_name)) == null) {
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
