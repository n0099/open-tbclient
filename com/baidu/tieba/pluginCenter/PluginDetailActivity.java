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
    private TextView fQr;
    private HeadImageView ith;
    private TextView iti;
    private TextView itj;
    private TextView itk;
    private ProgressBar itl;
    private PluginNetConfigInfos.PluginConfig itm;
    private ShadowLayout itn;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Jh = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.itm != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.itm.package_name) && !PluginDetailActivity.this.mFinished) {
                al.f(PluginDetailActivity.this.itk, R.color.cp_cont_d, 1);
                PluginDetailActivity.this.itn.setShadowColor(0);
                PluginDetailActivity.this.itk.setEnabled(false);
                PluginDetailActivity.this.itk.setVisibility(8);
                PluginDetailActivity.this.itl.setVisibility(0);
                PluginDetailActivity.this.fQr.setVisibility(0);
                PluginDetailActivity.this.itl.setProgress((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.itm != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.itm.package_name)) {
                PluginDetailActivity.this.itk.setText(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                PluginDetailActivity.this.itk.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && PluginDetailActivity.this.itm != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.itm.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.ccw();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                PluginDetailActivity.this.ccw();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(R.string.plugin_installation_failed) + str);
            PluginDetailActivity.this.ccw();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jS()) {
                PluginDetailActivity.this.ccw();
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
        this.ith = (HeadImageView) findViewById(R.id.icon);
        this.mName = (TextView) findViewById(R.id.name);
        this.dYI = (TextView) findViewById(R.id.status);
        this.itl = (ProgressBar) findViewById(R.id.plugin_download_progress);
        this.fQr = (TextView) findViewById(R.id.plugin_download_text);
        this.iti = (TextView) findViewById(R.id.changelog);
        this.itj = (TextView) findViewById(R.id.size);
        this.itk = (TextView) findViewById(R.id.enable);
        this.itk.setOnClickListener(this);
        this.itn = (ShadowLayout) findViewById(R.id.plugin_status_container);
        this.bsY = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mA().mB() != null) {
            this.itm = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mA().mB().getPluginConfig(this.bsY);
        }
        if (PluginPackageManager.mc().bM(this.bsY)) {
            PluginPackageManager.mc().a(this.Jh);
            al.f(this.itk, R.color.cp_cont_d, 1);
            this.itk.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.itm != null) {
            this.ith.startLoad(this.itm.icon, 10, false);
            if (this.itm.display_name == null) {
                this.itm.display_name = "";
            }
            this.mName.setText(this.itm.display_name);
            ccw();
            if (this.itm.newest != null) {
                if (TextUtils.isEmpty(this.itm.newest.change_log)) {
                    this.iti.setText("");
                } else {
                    this.iti.setText(this.itm.newest.change_log);
                }
                if (this.itm.newest.size <= 0) {
                    this.itj.setText("");
                } else {
                    this.itj.setText(getPageContext().getString(R.string.plugin_size) + String.valueOf(this.itm.newest.size / 1024) + "KB");
                }
            }
            this.itk.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        PluginPackageManager.mc().a(this.Jh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        PluginPackageManager.mc().a((d) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccw() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.mc().bK(this.bsY) && PluginPackageManager.mc().bI(this.bsY)) {
            this.dYI.setText(R.string.plugin_enabled);
            this.itk.setVisibility(0);
            this.itk.setText(R.string.download_update);
            this.itk.setEnabled(true);
            al.k(this.itk, R.drawable.selector_blue_gradient_button);
            this.itn.setShadowColor(R.color.plugin_button_shadow_blue);
            al.f(this.itk, R.color.cp_cont_g, 1);
            this.itl.setVisibility(8);
            this.fQr.setVisibility(8);
            this.mStatus = 1;
        } else if (PluginPackageManager.mc().bI(this.bsY)) {
            this.itk.setEnabled(true);
            al.f(this.itk, R.color.cp_cont_g, 1);
            this.itk.setVisibility(0);
            this.itl.setVisibility(8);
            this.fQr.setVisibility(8);
            if (PluginPackageManager.mc().bJ(this.bsY)) {
                this.dYI.setText(R.string.plugin_unenabled);
                this.itk.setText(R.string.plugin_enable);
                al.k(this.itk, R.drawable.selector_blue_gradient_button);
                this.itn.setShadowColor(R.color.plugin_button_shadow_blue);
                this.mStatus = 2;
                return;
            }
            this.dYI.setText(R.string.plugin_enabled);
            this.itk.setText(R.string.plugin_unenable);
            this.mStatus = 3;
            if (this.itm != null && this.itm.can_forbidden == 1) {
                this.itk.setEnabled(false);
                this.itk.setVisibility(8);
                this.itn.setShadowColor(0);
                return;
            }
            this.itk.setEnabled(true);
            this.itk.setVisibility(0);
            al.k(this.itk, R.drawable.button_plugin_forbidden);
            this.itn.setShadowColor(R.color.plugin_button_shadow_red);
        } else {
            this.itk.setVisibility(0);
            this.dYI.setText(R.string.plugin_disabled);
            this.itk.setText(R.string.install_app);
            this.itk.setEnabled(true);
            al.k(this.itk, R.drawable.selector_blue_gradient_button);
            this.itn.setShadowColor(R.color.plugin_button_shadow_blue);
            al.f(this.itk, R.color.cp_cont_g, 1);
            this.mStatus = 0;
            this.itl.setVisibility(8);
            this.fQr.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.itl.setProgressDrawable(al.getDrawable(R.drawable.download_progressbar));
        this.itl.setIndeterminateDrawable(al.getDrawable(R.drawable.download_progressbar));
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.itk) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                ccx();
            } else if (this.mStatus == 3) {
                PluginPackageManager.mc().bG(this.bsY);
                ccw();
            } else if (this.mStatus == 2) {
                PluginPackageManager.mc().bH(this.bsY);
                ccw();
            }
        }
    }

    private void ccx() {
        if (!j.jS()) {
            showToast(R.string.neterror);
        } else if (j.jU()) {
            ccy();
        } else if (this.itm != null && !TextUtils.isEmpty(this.itm.package_name) && !PluginPackageManager.mc().bM(this.itm.package_name)) {
            this.itk.setEnabled(false);
            this.mFinished = false;
            PluginPackageManager.mc().a(this.itm, this.Jh);
        }
    }

    private void ccy() {
        String string;
        String string2;
        if (this.itm != null && this.itm.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.itm.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(R.string.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download_update);
            } else {
                string = getResources().getString(R.string.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(R.string.download);
            }
            aVar.mE(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    al.f(PluginDetailActivity.this.itk, R.color.cp_cont_d, 1);
                    PluginDetailActivity.this.itk.setEnabled(false);
                    PluginPackageManager.mc().a(PluginDetailActivity.this.itm, PluginDetailActivity.this.Jh);
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
