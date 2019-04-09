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
    private TextView dOi;
    private TextView fzx;
    private TextView iaA;
    private TextView iaB;
    private ProgressBar iaC;
    private String iaD;
    private PluginNetConfigInfos.PluginConfig iaE;
    private ShadowLayout iaF;
    private HeadImageView iay;
    private TextView iaz;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Lt = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iaE != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iaE.package_name) && !PluginDetailActivity.this.mFinished) {
                al.d(PluginDetailActivity.this.iaB, d.C0277d.cp_cont_d, 1);
                PluginDetailActivity.this.iaF.setShadowColor(0);
                PluginDetailActivity.this.iaB.setEnabled(false);
                PluginDetailActivity.this.iaB.setVisibility(8);
                PluginDetailActivity.this.iaC.setVisibility(0);
                PluginDetailActivity.this.fzx.setVisibility(0);
                PluginDetailActivity.this.iaC.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iaE != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iaE.package_name)) {
                PluginDetailActivity.this.iaB.setText(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                PluginDetailActivity.this.iaB.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iaE != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iaE.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bUs();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_finished));
                PluginDetailActivity.this.bUs();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bUs();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kY()) {
                PluginDetailActivity.this.bUs();
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
        this.iay = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.dOi = (TextView) findViewById(d.g.status);
        this.iaC = (ProgressBar) findViewById(d.g.plugin_download_progress);
        this.fzx = (TextView) findViewById(d.g.plugin_download_text);
        this.iaz = (TextView) findViewById(d.g.changelog);
        this.iaA = (TextView) findViewById(d.g.size);
        this.iaB = (TextView) findViewById(d.g.enable);
        this.iaB.setOnClickListener(this);
        this.iaF = (ShadowLayout) findViewById(d.g.plugin_status_container);
        this.iaD = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nF().nG() != null) {
            this.iaE = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nF().nG().getPluginConfig(this.iaD);
        }
        if (PluginPackageManager.ni().cc(this.iaD)) {
            PluginPackageManager.ni().a(this.Lt);
            al.d(this.iaB, d.C0277d.cp_cont_d, 1);
            this.iaB.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iaE != null) {
            this.iay.startLoad(this.iaE.icon, 10, false);
            if (this.iaE.display_name == null) {
                this.iaE.display_name = "";
            }
            this.mName.setText(this.iaE.display_name);
            bUs();
            if (this.iaE.newest != null) {
                if (TextUtils.isEmpty(this.iaE.newest.change_log)) {
                    this.iaz.setText("");
                } else {
                    this.iaz.setText(this.iaE.newest.change_log);
                }
                if (this.iaE.newest.size <= 0) {
                    this.iaA.setText("");
                } else {
                    this.iaA.setText(getPageContext().getString(d.j.plugin_size) + String.valueOf(this.iaE.newest.size / 1024) + "KB");
                }
            }
            this.iaB.setOnClickListener(this);
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
    public void bUs() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.ni().ca(this.iaD) && PluginPackageManager.ni().bY(this.iaD)) {
            this.dOi.setText(d.j.plugin_enabled);
            this.iaB.setVisibility(0);
            this.iaB.setText(d.j.download_update);
            this.iaB.setEnabled(true);
            al.k(this.iaB, d.f.selector_blue_gradient_button);
            this.iaF.setShadowColor(d.C0277d.plugin_button_shadow_blue);
            al.d(this.iaB, d.C0277d.cp_cont_g, 1);
            this.iaC.setVisibility(8);
            this.fzx.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.ni().bY(this.iaD)) {
            this.iaB.setEnabled(true);
            al.d(this.iaB, d.C0277d.cp_cont_g, 1);
            this.iaB.setVisibility(0);
            this.iaC.setVisibility(8);
            this.fzx.setVisibility(8);
            if (PluginPackageManager.ni().bZ(this.iaD)) {
                this.dOi.setText(d.j.plugin_unenabled);
                this.iaB.setText(d.j.plugin_enable);
                al.k(this.iaB, d.f.selector_blue_gradient_button);
                this.iaF.setShadowColor(d.C0277d.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.dOi.setText(d.j.plugin_enabled);
            this.iaB.setText(d.j.plugin_unenable);
            this.mStatus = 3;
            if (this.iaE != null && this.iaE.can_forbidden == 1) {
                this.iaB.setEnabled(false);
                this.iaB.setVisibility(8);
                this.iaF.setShadowColor(0);
                return;
            }
            this.iaB.setEnabled(true);
            this.iaB.setVisibility(0);
            al.k(this.iaB, d.f.button_plugin_forbidden);
            this.iaF.setShadowColor(d.C0277d.plugin_button_shadow_red);
        } else {
            this.iaB.setVisibility(0);
            this.dOi.setText(d.j.plugin_disabled);
            this.iaB.setText(d.j.install_app);
            this.iaB.setEnabled(true);
            al.k(this.iaB, d.f.selector_blue_gradient_button);
            this.iaF.setShadowColor(d.C0277d.plugin_button_shadow_blue);
            al.d(this.iaB, d.C0277d.cp_cont_g, 1);
            this.mStatus = 0;
            this.iaC.setVisibility(8);
            this.fzx.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iaC.setProgressDrawable(al.getDrawable(d.f.download_progressbar));
        this.iaC.setIndeterminateDrawable(al.getDrawable(d.f.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iaB) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bUt();
            } else if (this.mStatus == 3) {
                PluginPackageManager.ni().bW(this.iaD);
                bUs();
            } else if (this.mStatus == 2) {
                PluginPackageManager.ni().bX(this.iaD);
                bUs();
            }
        }
    }

    private void bUt() {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (j.la()) {
            bUu();
        } else if (this.iaE != null && !TextUtils.isEmpty(this.iaE.package_name) && !PluginPackageManager.ni().cc(this.iaE.package_name)) {
            this.iaB.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.ni().a(this.iaE, this.Lt);
        }
    }

    private void bUu() {
        String string;
        String string2;
        if (this.iaE != null && this.iaE.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.iaE.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.j.download_update);
            } else {
                string = getResources().getString(d.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.j.download);
            }
            aVar.lz(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    al.d(PluginDetailActivity.this.iaB, d.C0277d.cp_cont_d, 1);
                    PluginDetailActivity.this.iaB.setEnabled(false);
                    PluginPackageManager.ni().a(PluginDetailActivity.this.iaE, PluginDetailActivity.this.Lt);
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
            aVar.aaW();
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
