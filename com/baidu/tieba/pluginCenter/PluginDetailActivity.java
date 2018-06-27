package com.baidu.tieba.pluginCenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
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
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView ced;
    private HeadImageView ghJ;
    private TextView ghK;
    private TextView ghL;
    private TextView ghM;
    private String ghN;
    private PluginNetConfigInfos.PluginConfig ghO;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Im = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.ghO.package_name) && !PluginDetailActivity.this.mFinished) {
                am.c(PluginDetailActivity.this.ghM, d.C0142d.cp_cont_d, 1);
                PluginDetailActivity.this.ghM.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.k.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.ghM.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.ghO.package_name)) {
                PluginDetailActivity.this.ghM.setText(PluginDetailActivity.this.getPageContext().getString(d.k.plugin_download_finished));
                PluginDetailActivity.this.ghM.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.ghO.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bmN();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.k.plugin_installation_finished));
                PluginDetailActivity.this.bmN();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.k.plugin_installation_failed) + str);
            PluginDetailActivity.this.bmN();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jD()) {
                PluginDetailActivity.this.bmN();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.setTitleText(d.k.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PluginDetailActivity.this.closeActivity();
            }
        });
        this.ghJ = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.ced = (TextView) findViewById(d.g.status);
        this.ghK = (TextView) findViewById(d.g.changelog);
        this.ghL = (TextView) findViewById(d.g.size);
        this.ghM = (TextView) findViewById(d.g.enable);
        this.ghM.setOnClickListener(this);
        this.ghN = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mh().mi() != null) {
            this.ghO = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mh().mi().getPluginConfig(this.ghN);
        }
        if (PluginPackageManager.lL().bK(this.ghN)) {
            PluginPackageManager.lL().a(this.Im);
            am.c(this.ghM, d.C0142d.cp_cont_d, 1);
            this.ghM.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.ghO != null) {
            this.ghJ.startLoad(this.ghO.icon, 10, false);
            if (this.ghO.display_name == null) {
                this.ghO.display_name = "";
            }
            this.mName.setText(this.ghO.display_name);
            bmN();
            if (this.ghO.newest != null) {
                if (TextUtils.isEmpty(this.ghO.newest.change_log)) {
                    this.ghK.setText("");
                } else {
                    this.ghK.setText(this.ghO.newest.change_log);
                }
                if (this.ghO.newest.size <= 0) {
                    this.ghL.setText("");
                } else {
                    this.ghL.setText(getPageContext().getString(d.k.plugin_size) + String.valueOf(this.ghO.newest.size / 1024) + "KB");
                }
            }
            this.ghM.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmN() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.lL().bI(this.ghN) && PluginPackageManager.lL().bG(this.ghN)) {
            this.ced.setText(d.k.plugin_enabled);
            this.ghM.setText(d.k.download_update);
            this.ghM.setEnabled(true);
            am.c(this.ghM, d.C0142d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.lL().bG(this.ghN)) {
            this.ghM.setEnabled(true);
            am.c(this.ghM, d.C0142d.cp_cont_g, 1);
            if (PluginPackageManager.lL().bH(this.ghN)) {
                this.ced.setText(d.k.plugin_unenabled);
                this.ghM.setText(d.k.plugin_enable);
                this.mStatus = 2;
            } else {
                this.ced.setText(d.k.plugin_enabled);
                this.ghM.setText(d.k.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.ced.setText(d.k.plugin_disabled);
            this.ghM.setText(d.k.plugin_enable);
            this.ghM.setEnabled(true);
            am.c(this.ghM, d.C0142d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.lL().bK(this.ghN)) {
            am.c(this.ghM, d.C0142d.cp_cont_d, 1);
            this.ghM.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ghM) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bmO();
            } else if (this.mStatus == 3) {
                PluginPackageManager.lL().bE(this.ghN);
                bmN();
            } else if (this.mStatus == 2) {
                PluginPackageManager.lL().bF(this.ghN);
                bmN();
            }
        }
    }

    private void bmO() {
        if (!j.jD()) {
            showToast(d.k.neterror);
        } else if (j.jF()) {
            bmP();
        } else {
            am.c(this.ghM, d.C0142d.cp_cont_d, 1);
            this.ghM.setEnabled(false);
            PluginPackageManager.lL().a(this.ghO, this.Im);
        }
    }

    private void bmP() {
        String string;
        String string2;
        if (this.ghO != null && this.ghO.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.ghO.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.k.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.k.download_update);
            } else {
                string = getResources().getString(d.k.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.k.download);
            }
            aVar.dE(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    am.c(PluginDetailActivity.this.ghM, d.C0142d.cp_cont_d, 1);
                    PluginDetailActivity.this.ghM.setEnabled(false);
                    PluginPackageManager.lL().a(PluginDetailActivity.this.ghO, PluginDetailActivity.this.Im);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.xn();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PluginPackageManager.lL().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
