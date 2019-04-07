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
    private TextView dOh;
    private TextView fzx;
    private TextView iaA;
    private ProgressBar iaB;
    private String iaC;
    private PluginNetConfigInfos.PluginConfig iaD;
    private ShadowLayout iaE;
    private HeadImageView iax;
    private TextView iay;
    private TextView iaz;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Lt = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iaD != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iaD.package_name) && !PluginDetailActivity.this.mFinished) {
                al.d(PluginDetailActivity.this.iaA, d.C0277d.cp_cont_d, 1);
                PluginDetailActivity.this.iaE.setShadowColor(0);
                PluginDetailActivity.this.iaA.setEnabled(false);
                PluginDetailActivity.this.iaA.setVisibility(8);
                PluginDetailActivity.this.iaB.setVisibility(0);
                PluginDetailActivity.this.fzx.setVisibility(0);
                PluginDetailActivity.this.iaB.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iaD != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iaD.package_name)) {
                PluginDetailActivity.this.iaA.setText(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                PluginDetailActivity.this.iaA.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iaD != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iaD.package_name)) {
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
        this.iax = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.dOh = (TextView) findViewById(d.g.status);
        this.iaB = (ProgressBar) findViewById(d.g.plugin_download_progress);
        this.fzx = (TextView) findViewById(d.g.plugin_download_text);
        this.iay = (TextView) findViewById(d.g.changelog);
        this.iaz = (TextView) findViewById(d.g.size);
        this.iaA = (TextView) findViewById(d.g.enable);
        this.iaA.setOnClickListener(this);
        this.iaE = (ShadowLayout) findViewById(d.g.plugin_status_container);
        this.iaC = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nF().nG() != null) {
            this.iaD = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nF().nG().getPluginConfig(this.iaC);
        }
        if (PluginPackageManager.ni().cc(this.iaC)) {
            PluginPackageManager.ni().a(this.Lt);
            al.d(this.iaA, d.C0277d.cp_cont_d, 1);
            this.iaA.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iaD != null) {
            this.iax.startLoad(this.iaD.icon, 10, false);
            if (this.iaD.display_name == null) {
                this.iaD.display_name = "";
            }
            this.mName.setText(this.iaD.display_name);
            bUs();
            if (this.iaD.newest != null) {
                if (TextUtils.isEmpty(this.iaD.newest.change_log)) {
                    this.iay.setText("");
                } else {
                    this.iay.setText(this.iaD.newest.change_log);
                }
                if (this.iaD.newest.size <= 0) {
                    this.iaz.setText("");
                } else {
                    this.iaz.setText(getPageContext().getString(d.j.plugin_size) + String.valueOf(this.iaD.newest.size / 1024) + "KB");
                }
            }
            this.iaA.setOnClickListener(this);
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
        if (PluginPackageManager.ni().ca(this.iaC) && PluginPackageManager.ni().bY(this.iaC)) {
            this.dOh.setText(d.j.plugin_enabled);
            this.iaA.setVisibility(0);
            this.iaA.setText(d.j.download_update);
            this.iaA.setEnabled(true);
            al.k(this.iaA, d.f.selector_blue_gradient_button);
            this.iaE.setShadowColor(d.C0277d.plugin_button_shadow_blue);
            al.d(this.iaA, d.C0277d.cp_cont_g, 1);
            this.iaB.setVisibility(8);
            this.fzx.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.ni().bY(this.iaC)) {
            this.iaA.setEnabled(true);
            al.d(this.iaA, d.C0277d.cp_cont_g, 1);
            this.iaA.setVisibility(0);
            this.iaB.setVisibility(8);
            this.fzx.setVisibility(8);
            if (PluginPackageManager.ni().bZ(this.iaC)) {
                this.dOh.setText(d.j.plugin_unenabled);
                this.iaA.setText(d.j.plugin_enable);
                al.k(this.iaA, d.f.selector_blue_gradient_button);
                this.iaE.setShadowColor(d.C0277d.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.dOh.setText(d.j.plugin_enabled);
            this.iaA.setText(d.j.plugin_unenable);
            this.mStatus = 3;
            if (this.iaD != null && this.iaD.can_forbidden == 1) {
                this.iaA.setEnabled(false);
                this.iaA.setVisibility(8);
                this.iaE.setShadowColor(0);
                return;
            }
            this.iaA.setEnabled(true);
            this.iaA.setVisibility(0);
            al.k(this.iaA, d.f.button_plugin_forbidden);
            this.iaE.setShadowColor(d.C0277d.plugin_button_shadow_red);
        } else {
            this.iaA.setVisibility(0);
            this.dOh.setText(d.j.plugin_disabled);
            this.iaA.setText(d.j.install_app);
            this.iaA.setEnabled(true);
            al.k(this.iaA, d.f.selector_blue_gradient_button);
            this.iaE.setShadowColor(d.C0277d.plugin_button_shadow_blue);
            al.d(this.iaA, d.C0277d.cp_cont_g, 1);
            this.mStatus = 0;
            this.iaB.setVisibility(8);
            this.fzx.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iaB.setProgressDrawable(al.getDrawable(d.f.download_progressbar));
        this.iaB.setIndeterminateDrawable(al.getDrawable(d.f.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iaA) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bUt();
            } else if (this.mStatus == 3) {
                PluginPackageManager.ni().bW(this.iaC);
                bUs();
            } else if (this.mStatus == 2) {
                PluginPackageManager.ni().bX(this.iaC);
                bUs();
            }
        }
    }

    private void bUt() {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (j.la()) {
            bUu();
        } else if (this.iaD != null && !TextUtils.isEmpty(this.iaD.package_name) && !PluginPackageManager.ni().cc(this.iaD.package_name)) {
            this.iaA.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.ni().a(this.iaD, this.Lt);
        }
    }

    private void bUu() {
        String string;
        String string2;
        if (this.iaD != null && this.iaD.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.iaD.newest.size / 1048576.0f;
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
                    al.d(PluginDetailActivity.this.iaA, d.C0277d.cp_cont_d, 1);
                    PluginDetailActivity.this.iaA.setEnabled(false);
                    PluginPackageManager.ni().a(PluginDetailActivity.this.iaD, PluginDetailActivity.this.Lt);
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
