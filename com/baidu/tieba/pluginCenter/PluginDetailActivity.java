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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.plugin.ShadowLayout;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView dOU;
    private TextView fzK;
    private HeadImageView iaQ;
    private TextView iaR;
    private TextView iaS;
    private TextView iaT;
    private ProgressBar iaU;
    private String iaV;
    private PluginNetConfigInfos.PluginConfig iaW;
    private ShadowLayout iaX;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Lt = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iaW != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iaW.package_name) && !PluginDetailActivity.this.mFinished) {
                al.d(PluginDetailActivity.this.iaT, d.C0236d.cp_cont_d, 1);
                PluginDetailActivity.this.iaX.setShadowColor(0);
                PluginDetailActivity.this.iaT.setEnabled(false);
                PluginDetailActivity.this.iaT.setVisibility(8);
                PluginDetailActivity.this.iaU.setVisibility(0);
                PluginDetailActivity.this.fzK.setVisibility(0);
                PluginDetailActivity.this.iaU.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iaW != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iaW.package_name)) {
                PluginDetailActivity.this.iaT.setText(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                PluginDetailActivity.this.iaT.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iaW != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iaW.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bUt();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_finished));
                PluginDetailActivity.this.bUt();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bUt();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kY()) {
                PluginDetailActivity.this.bUt();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getString(d.j.plugin_center));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PluginDetailActivity.this.closeActivity();
            }
        });
        this.iaQ = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.dOU = (TextView) findViewById(d.g.status);
        this.iaU = (ProgressBar) findViewById(d.g.plugin_download_progress);
        this.fzK = (TextView) findViewById(d.g.plugin_download_text);
        this.iaR = (TextView) findViewById(d.g.changelog);
        this.iaS = (TextView) findViewById(d.g.size);
        this.iaT = (TextView) findViewById(d.g.enable);
        this.iaT.setOnClickListener(this);
        this.iaX = (ShadowLayout) findViewById(d.g.plugin_status_container);
        this.iaV = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nF().nG() != null) {
            this.iaW = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nF().nG().getPluginConfig(this.iaV);
        }
        if (PluginPackageManager.ni().cc(this.iaV)) {
            PluginPackageManager.ni().a(this.Lt);
            al.d(this.iaT, d.C0236d.cp_cont_d, 1);
            this.iaT.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iaW != null) {
            this.iaQ.startLoad(this.iaW.icon, 10, false);
            if (this.iaW.display_name == null) {
                this.iaW.display_name = "";
            }
            this.mName.setText(this.iaW.display_name);
            bUt();
            if (this.iaW.newest != null) {
                if (TextUtils.isEmpty(this.iaW.newest.change_log)) {
                    this.iaR.setText("");
                } else {
                    this.iaR.setText(this.iaW.newest.change_log);
                }
                if (this.iaW.newest.size <= 0) {
                    this.iaS.setText("");
                } else {
                    this.iaS.setText(getPageContext().getString(d.j.plugin_size) + String.valueOf(this.iaW.newest.size / 1024) + "KB");
                }
            }
            this.iaT.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PluginPackageManager.ni().a(this.Lt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.ni().a((com.baidu.adp.plugin.packageManager.d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUt() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.ni().ca(this.iaV) && PluginPackageManager.ni().bY(this.iaV)) {
            this.dOU.setText(d.j.plugin_enabled);
            this.iaT.setVisibility(0);
            this.iaT.setText(d.j.download_update);
            this.iaT.setEnabled(true);
            al.k(this.iaT, d.f.selector_blue_gradient_button);
            this.iaX.setShadowColor(d.C0236d.plugin_button_shadow_blue);
            al.d(this.iaT, d.C0236d.cp_cont_g, 1);
            this.iaU.setVisibility(8);
            this.fzK.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.ni().bY(this.iaV)) {
            this.iaT.setEnabled(true);
            al.d(this.iaT, d.C0236d.cp_cont_g, 1);
            this.iaT.setVisibility(0);
            this.iaU.setVisibility(8);
            this.fzK.setVisibility(8);
            if (PluginPackageManager.ni().bZ(this.iaV)) {
                this.dOU.setText(d.j.plugin_unenabled);
                this.iaT.setText(d.j.plugin_enable);
                al.k(this.iaT, d.f.selector_blue_gradient_button);
                this.iaX.setShadowColor(d.C0236d.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.dOU.setText(d.j.plugin_enabled);
            this.iaT.setText(d.j.plugin_unenable);
            this.mStatus = 3;
            if (this.iaW != null && this.iaW.can_forbidden == 1) {
                this.iaT.setEnabled(false);
                this.iaT.setVisibility(8);
                this.iaX.setShadowColor(0);
                return;
            }
            this.iaT.setEnabled(true);
            this.iaT.setVisibility(0);
            al.k(this.iaT, d.f.button_plugin_forbidden);
            this.iaX.setShadowColor(d.C0236d.plugin_button_shadow_red);
        } else {
            this.iaT.setVisibility(0);
            this.dOU.setText(d.j.plugin_disabled);
            this.iaT.setText(d.j.install_app);
            this.iaT.setEnabled(true);
            al.k(this.iaT, d.f.selector_blue_gradient_button);
            this.iaX.setShadowColor(d.C0236d.plugin_button_shadow_blue);
            al.d(this.iaT, d.C0236d.cp_cont_g, 1);
            this.mStatus = 0;
            this.iaU.setVisibility(8);
            this.fzK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iaU.setProgressDrawable(al.getDrawable(d.f.download_progressbar));
        this.iaU.setIndeterminateDrawable(al.getDrawable(d.f.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iaT) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bUu();
            } else if (this.mStatus == 3) {
                PluginPackageManager.ni().bW(this.iaV);
                bUt();
            } else if (this.mStatus == 2) {
                PluginPackageManager.ni().bX(this.iaV);
                bUt();
            }
        }
    }

    private void bUu() {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (j.la()) {
            bUv();
        } else if (this.iaW != null && !TextUtils.isEmpty(this.iaW.package_name) && !PluginPackageManager.ni().cc(this.iaW.package_name)) {
            this.iaT.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.ni().a(this.iaW, this.Lt);
        }
    }

    private void bUv() {
        String string;
        String string2;
        if (this.iaW != null && this.iaW.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.iaW.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.j.download_update);
            } else {
                string = getResources().getString(d.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.j.download);
            }
            aVar.ly(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    al.d(PluginDetailActivity.this.iaT, d.C0236d.cp_cont_d, 1);
                    PluginDetailActivity.this.iaT.setEnabled(false);
                    PluginPackageManager.ni().a(PluginDetailActivity.this.iaW, PluginDetailActivity.this.Lt);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.aaZ();
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
