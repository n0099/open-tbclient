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
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.d;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugin.ShadowLayout;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String btO;
    private TextView ecG;
    private TextView fWg;
    private HeadImageView iAD;
    private TextView iAE;
    private TextView iAF;
    private TextView iAG;
    private ProgressBar iAH;
    private PluginNetConfigInfos.PluginConfig iAI;
    private ShadowLayout iAJ;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Jr = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iAI != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iAI.package_name) && !PluginDetailActivity.this.mFinished) {
                am.f(PluginDetailActivity.this.iAG, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.iAJ.setShadowColor(0);
                PluginDetailActivity.this.iAG.setEnabled(false);
                PluginDetailActivity.this.iAG.setVisibility(8);
                PluginDetailActivity.this.iAH.setVisibility(0);
                PluginDetailActivity.this.fWg.setVisibility(0);
                PluginDetailActivity.this.iAH.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iAI != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iAI.package_name)) {
                PluginDetailActivity.this.iAG.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.iAG.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iAI != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iAI.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.cfF();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.cfF();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.cfF();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kc()) {
                PluginDetailActivity.this.cfF();
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
        this.iAD = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.ecG = (TextView) findViewById(R.id.status);
        this.iAH = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.fWg = (TextView) findViewById(R.id.plugin_download_text);
        this.iAE = (TextView) findViewById(R.id.changelog);
        this.iAF = (TextView) findViewById(R.id.size);
        this.iAG = (TextView) findViewById(R.id.enable);
        this.iAG.setOnClickListener(this);
        this.iAJ = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.btO = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mQ().mR() != null) {
            this.iAI = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mQ().mR().getPluginConfig(this.btO);
        }
        if (PluginPackageManager.ms().bO(this.btO)) {
            PluginPackageManager.ms().a(this.Jr);
            am.f(this.iAG, R.color.cp_cont_d, 1);
            this.iAG.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iAI != null) {
            this.iAD.startLoad(this.iAI.icon, 10, false);
            if (this.iAI.display_name == null) {
                this.iAI.display_name = "";
            }
            this.mName.setText(this.iAI.display_name);
            cfF();
            if (this.iAI.newest != null) {
                if (TextUtils.isEmpty(this.iAI.newest.change_log)) {
                    this.iAE.setText("");
                } else {
                    this.iAE.setText(this.iAI.newest.change_log);
                }
                if (this.iAI.newest.size <= 0) {
                    this.iAF.setText("");
                } else {
                    this.iAF.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.iAI.newest.size / 1024) + "KB");
                }
            }
            this.iAG.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PluginPackageManager.ms().a(this.Jr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.ms().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfF() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.ms().bM(this.btO) && PluginPackageManager.ms().bK(this.btO)) {
            this.ecG.setText(R.string.plugin_enabled);
            this.iAG.setVisibility(0);
            this.iAG.setText(R.string.download_update);
            this.iAG.setEnabled(true);
            am.k(this.iAG, R.drawable.selector_blue_gradient_button);
            this.iAJ.setShadowColor(R.color.plugin_button_shadow_blue);
            am.f(this.iAG, R.color.cp_cont_g, 1);
            this.iAH.setVisibility(8);
            this.fWg.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.ms().bK(this.btO)) {
            this.iAG.setEnabled(true);
            am.f(this.iAG, R.color.cp_cont_g, 1);
            this.iAG.setVisibility(0);
            this.iAH.setVisibility(8);
            this.fWg.setVisibility(8);
            if (PluginPackageManager.ms().bL(this.btO)) {
                this.ecG.setText(R.string.plugin_unenabled);
                this.iAG.setText(R.string.plugin_enable);
                am.k(this.iAG, R.drawable.selector_blue_gradient_button);
                this.iAJ.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.ecG.setText(R.string.plugin_enabled);
            this.iAG.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.iAI != null && this.iAI.can_forbidden == 1) {
                this.iAG.setEnabled(false);
                this.iAG.setVisibility(8);
                this.iAJ.setShadowColor(0);
                return;
            }
            this.iAG.setEnabled(true);
            this.iAG.setVisibility(0);
            am.k(this.iAG, R.drawable.button_plugin_forbidden);
            this.iAJ.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.iAG.setVisibility(0);
            this.ecG.setText(R.string.plugin_disabled);
            this.iAG.setText(R.string.install_app);
            this.iAG.setEnabled(true);
            am.k(this.iAG, R.drawable.selector_blue_gradient_button);
            this.iAJ.setShadowColor(R.color.plugin_button_shadow_blue);
            am.f(this.iAG, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.iAH.setVisibility(8);
            this.fWg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iAH.setProgressDrawable(am.getDrawable(R.drawable.download_progressbar));
        this.iAH.setIndeterminateDrawable(am.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iAG) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                cfG();
            } else if (this.mStatus == 3) {
                PluginPackageManager.ms().bI(this.btO);
                cfF();
            } else if (this.mStatus == 2) {
                PluginPackageManager.ms().bJ(this.btO);
                cfF();
            }
        }
    }

    private void cfG() {
        if (!j.kc()) {
            showToast(R.string.neterror);
        } else if (j.ke()) {
            cfH();
        } else if (this.iAI != null && !TextUtils.isEmpty(this.iAI.package_name) && !PluginPackageManager.ms().bO(this.iAI.package_name)) {
            this.iAG.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.ms().a(this.iAI, this.Jr);
        }
    }

    private void cfH() {
        String string;
        String string2;
        if (this.iAI != null && this.iAI.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.iAI.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.mO(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    am.f(PluginDetailActivity.this.iAG, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.iAG.setEnabled(false);
                    PluginPackageManager.ms().a(PluginDetailActivity.this.iAI, PluginDetailActivity.this.Jr);
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
            aVar.agK();
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
}
