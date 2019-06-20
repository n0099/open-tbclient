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
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private String bsY;
    private TextView dYI;
    private TextView fQt;
    private HeadImageView iti;
    private TextView itj;
    private TextView itk;
    private TextView itl;
    private ProgressBar itm;
    private PluginNetConfigInfos.PluginConfig itn;
    private ShadowLayout ito;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Jg = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.itn != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.itn.package_name) && !PluginDetailActivity.this.mFinished) {
                al.f(PluginDetailActivity.this.itl, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.ito.setShadowColor(0);
                PluginDetailActivity.this.itl.setEnabled(false);
                PluginDetailActivity.this.itl.setVisibility(8);
                PluginDetailActivity.this.itm.setVisibility(0);
                PluginDetailActivity.this.fQt.setVisibility(0);
                PluginDetailActivity.this.itm.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.itn != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.itn.package_name)) {
                PluginDetailActivity.this.itl.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.itl.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.itn != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.itn.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.ccx();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.ccx();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.ccx();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jS()) {
                PluginDetailActivity.this.ccx();
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
        this.iti = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.dYI = (TextView) findViewById(R.id.status);
        this.itm = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.fQt = (TextView) findViewById(R.id.plugin_download_text);
        this.itj = (TextView) findViewById(R.id.changelog);
        this.itk = (TextView) findViewById(R.id.size);
        this.itl = (TextView) findViewById(R.id.enable);
        this.itl.setOnClickListener(this);
        this.ito = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.bsY = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mA().mB() != null) {
            this.itn = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mA().mB().getPluginConfig(this.bsY);
        }
        if (PluginPackageManager.mc().bM(this.bsY)) {
            PluginPackageManager.mc().a(this.Jg);
            al.f(this.itl, R.color.cp_cont_d, 1);
            this.itl.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.itn != null) {
            this.iti.startLoad(this.itn.icon, 10, false);
            if (this.itn.display_name == null) {
                this.itn.display_name = "";
            }
            this.mName.setText(this.itn.display_name);
            ccx();
            if (this.itn.newest != null) {
                if (TextUtils.isEmpty(this.itn.newest.change_log)) {
                    this.itj.setText("");
                } else {
                    this.itj.setText(this.itn.newest.change_log);
                }
                if (this.itn.newest.size <= 0) {
                    this.itk.setText("");
                } else {
                    this.itk.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.itn.newest.size / 1024) + "KB");
                }
            }
            this.itl.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PluginPackageManager.mc().a(this.Jg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.mc().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccx() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.mc().bK(this.bsY) && PluginPackageManager.mc().bI(this.bsY)) {
            this.dYI.setText(R.string.plugin_enabled);
            this.itl.setVisibility(0);
            this.itl.setText(R.string.download_update);
            this.itl.setEnabled(true);
            al.k(this.itl, R.drawable.selector_blue_gradient_button);
            this.ito.setShadowColor(R.color.plugin_button_shadow_blue);
            al.f(this.itl, R.color.cp_cont_g, 1);
            this.itm.setVisibility(8);
            this.fQt.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.mc().bI(this.bsY)) {
            this.itl.setEnabled(true);
            al.f(this.itl, R.color.cp_cont_g, 1);
            this.itl.setVisibility(0);
            this.itm.setVisibility(8);
            this.fQt.setVisibility(8);
            if (PluginPackageManager.mc().bJ(this.bsY)) {
                this.dYI.setText(R.string.plugin_unenabled);
                this.itl.setText(R.string.plugin_enable);
                al.k(this.itl, R.drawable.selector_blue_gradient_button);
                this.ito.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.dYI.setText(R.string.plugin_enabled);
            this.itl.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.itn != null && this.itn.can_forbidden == 1) {
                this.itl.setEnabled(false);
                this.itl.setVisibility(8);
                this.ito.setShadowColor(0);
                return;
            }
            this.itl.setEnabled(true);
            this.itl.setVisibility(0);
            al.k(this.itl, R.drawable.button_plugin_forbidden);
            this.ito.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.itl.setVisibility(0);
            this.dYI.setText(R.string.plugin_disabled);
            this.itl.setText(R.string.install_app);
            this.itl.setEnabled(true);
            al.k(this.itl, R.drawable.selector_blue_gradient_button);
            this.ito.setShadowColor(R.color.plugin_button_shadow_blue);
            al.f(this.itl, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.itm.setVisibility(8);
            this.fQt.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.itm.setProgressDrawable(al.getDrawable(R.drawable.download_progressbar));
        this.itm.setIndeterminateDrawable(al.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.itl) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                ccy();
            } else if (this.mStatus == 3) {
                PluginPackageManager.mc().bG(this.bsY);
                ccx();
            } else if (this.mStatus == 2) {
                PluginPackageManager.mc().bH(this.bsY);
                ccx();
            }
        }
    }

    private void ccy() {
        if (!j.jS()) {
            showToast(R.string.neterror);
        } else if (j.jU()) {
            ccz();
        } else if (this.itn != null && !TextUtils.isEmpty(this.itn.package_name) && !PluginPackageManager.mc().bM(this.itn.package_name)) {
            this.itl.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.mc().a(this.itn, this.Jg);
        }
    }

    private void ccz() {
        String string;
        String string2;
        if (this.itn != null && this.itn.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.itn.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.mD(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    al.f(PluginDetailActivity.this.itl, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.itl.setEnabled(false);
                    PluginPackageManager.mc().a(PluginDetailActivity.this.itn, PluginDetailActivity.this.Jg);
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
            aVar.afG();
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
