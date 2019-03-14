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
    private TextView dOQ;
    private TextView fzJ;
    private HeadImageView iaL;
    private TextView iaM;
    private TextView iaN;
    private TextView iaO;
    private ProgressBar iaP;
    private String iaQ;
    private PluginNetConfigInfos.PluginConfig iaR;
    private ShadowLayout iaS;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Lt = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iaR != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iaR.package_name) && !PluginDetailActivity.this.mFinished) {
                al.d(PluginDetailActivity.this.iaO, d.C0277d.cp_cont_d, 1);
                PluginDetailActivity.this.iaS.setShadowColor(0);
                PluginDetailActivity.this.iaO.setEnabled(false);
                PluginDetailActivity.this.iaO.setVisibility(8);
                PluginDetailActivity.this.iaP.setVisibility(0);
                PluginDetailActivity.this.fzJ.setVisibility(0);
                PluginDetailActivity.this.iaP.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iaR != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iaR.package_name)) {
                PluginDetailActivity.this.iaO.setText(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                PluginDetailActivity.this.iaO.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.iaR != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.iaR.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bUw();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_finished));
                PluginDetailActivity.this.bUw();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bUw();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kY()) {
                PluginDetailActivity.this.bUw();
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
        this.iaL = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.dOQ = (TextView) findViewById(d.g.status);
        this.iaP = (ProgressBar) findViewById(d.g.plugin_download_progress);
        this.fzJ = (TextView) findViewById(d.g.plugin_download_text);
        this.iaM = (TextView) findViewById(d.g.changelog);
        this.iaN = (TextView) findViewById(d.g.size);
        this.iaO = (TextView) findViewById(d.g.enable);
        this.iaO.setOnClickListener(this);
        this.iaS = (ShadowLayout) findViewById(d.g.plugin_status_container);
        this.iaQ = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nF().nG() != null) {
            this.iaR = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nF().nG().getPluginConfig(this.iaQ);
        }
        if (PluginPackageManager.ni().cc(this.iaQ)) {
            PluginPackageManager.ni().a(this.Lt);
            al.d(this.iaO, d.C0277d.cp_cont_d, 1);
            this.iaO.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iaR != null) {
            this.iaL.startLoad(this.iaR.icon, 10, false);
            if (this.iaR.display_name == null) {
                this.iaR.display_name = "";
            }
            this.mName.setText(this.iaR.display_name);
            bUw();
            if (this.iaR.newest != null) {
                if (TextUtils.isEmpty(this.iaR.newest.change_log)) {
                    this.iaM.setText("");
                } else {
                    this.iaM.setText(this.iaR.newest.change_log);
                }
                if (this.iaR.newest.size <= 0) {
                    this.iaN.setText("");
                } else {
                    this.iaN.setText(getPageContext().getString(d.j.plugin_size) + String.valueOf(this.iaR.newest.size / 1024) + "KB");
                }
            }
            this.iaO.setOnClickListener(this);
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
    public void bUw() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.ni().ca(this.iaQ) && PluginPackageManager.ni().bY(this.iaQ)) {
            this.dOQ.setText(d.j.plugin_enabled);
            this.iaO.setVisibility(0);
            this.iaO.setText(d.j.download_update);
            this.iaO.setEnabled(true);
            al.k(this.iaO, d.f.selector_blue_gradient_button);
            this.iaS.setShadowColor(d.C0277d.plugin_button_shadow_blue);
            al.d(this.iaO, d.C0277d.cp_cont_g, 1);
            this.iaP.setVisibility(8);
            this.fzJ.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.ni().bY(this.iaQ)) {
            this.iaO.setEnabled(true);
            al.d(this.iaO, d.C0277d.cp_cont_g, 1);
            this.iaO.setVisibility(0);
            this.iaP.setVisibility(8);
            this.fzJ.setVisibility(8);
            if (PluginPackageManager.ni().bZ(this.iaQ)) {
                this.dOQ.setText(d.j.plugin_unenabled);
                this.iaO.setText(d.j.plugin_enable);
                al.k(this.iaO, d.f.selector_blue_gradient_button);
                this.iaS.setShadowColor(d.C0277d.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.dOQ.setText(d.j.plugin_enabled);
            this.iaO.setText(d.j.plugin_unenable);
            this.mStatus = 3;
            if (this.iaR != null && this.iaR.can_forbidden == 1) {
                this.iaO.setEnabled(false);
                this.iaO.setVisibility(8);
                this.iaS.setShadowColor(0);
                return;
            }
            this.iaO.setEnabled(true);
            this.iaO.setVisibility(0);
            al.k(this.iaO, d.f.button_plugin_forbidden);
            this.iaS.setShadowColor(d.C0277d.plugin_button_shadow_red);
        } else {
            this.iaO.setVisibility(0);
            this.dOQ.setText(d.j.plugin_disabled);
            this.iaO.setText(d.j.install_app);
            this.iaO.setEnabled(true);
            al.k(this.iaO, d.f.selector_blue_gradient_button);
            this.iaS.setShadowColor(d.C0277d.plugin_button_shadow_blue);
            al.d(this.iaO, d.C0277d.cp_cont_g, 1);
            this.mStatus = 0;
            this.iaP.setVisibility(8);
            this.fzJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iaP.setProgressDrawable(al.getDrawable(d.f.download_progressbar));
        this.iaP.setIndeterminateDrawable(al.getDrawable(d.f.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iaO) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bUx();
            } else if (this.mStatus == 3) {
                PluginPackageManager.ni().bW(this.iaQ);
                bUw();
            } else if (this.mStatus == 2) {
                PluginPackageManager.ni().bX(this.iaQ);
                bUw();
            }
        }
    }

    private void bUx() {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (j.la()) {
            bUy();
        } else if (this.iaR != null && !TextUtils.isEmpty(this.iaR.package_name) && !PluginPackageManager.ni().cc(this.iaR.package_name)) {
            this.iaO.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.ni().a(this.iaR, this.Lt);
        }
    }

    private void bUy() {
        String string;
        String string2;
        if (this.iaR != null && this.iaR.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.iaR.newest.size / 1048576.0f;
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
                    al.d(PluginDetailActivity.this.iaO, d.C0277d.cp_cont_d, 1);
                    PluginDetailActivity.this.iaO.setEnabled(false);
                    PluginPackageManager.ni().a(PluginDetailActivity.this.iaR, PluginDetailActivity.this.Lt);
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
