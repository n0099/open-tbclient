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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView clx;
    private HeadImageView gpB;
    private TextView gpC;
    private TextView gpD;
    private TextView gpE;
    private String gpF;
    private PluginNetConfigInfos.PluginConfig gpG;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d KF = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gpG.package_name) && !PluginDetailActivity.this.mFinished) {
                al.c(PluginDetailActivity.this.gpE, e.d.cp_cont_d, 1);
                PluginDetailActivity.this.gpE.setText(PluginDetailActivity.this.getPageContext().getResources().getString(e.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.gpE.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gpG.package_name)) {
                PluginDetailActivity.this.gpE.setText(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                PluginDetailActivity.this.gpE.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gpG.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bnJ();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_installation_finished));
                PluginDetailActivity.this.bnJ();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bnJ();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kK()) {
                PluginDetailActivity.this.bnJ();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.mNavigationBar.setTitleText(e.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PluginDetailActivity.this.closeActivity();
            }
        });
        this.gpB = (HeadImageView) findViewById(e.g.icon);
        this.mName = (TextView) findViewById(e.g.name);
        this.clx = (TextView) findViewById(e.g.status);
        this.gpC = (TextView) findViewById(e.g.changelog);
        this.gpD = (TextView) findViewById(e.g.size);
        this.gpE = (TextView) findViewById(e.g.enable);
        this.gpE.setOnClickListener(this);
        this.gpF = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.np().nq() != null) {
            this.gpG = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.np().nq().getPluginConfig(this.gpF);
        }
        if (PluginPackageManager.mT().cc(this.gpF)) {
            PluginPackageManager.mT().a(this.KF);
            al.c(this.gpE, e.d.cp_cont_d, 1);
            this.gpE.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gpG != null) {
            this.gpB.startLoad(this.gpG.icon, 10, false);
            if (this.gpG.display_name == null) {
                this.gpG.display_name = "";
            }
            this.mName.setText(this.gpG.display_name);
            bnJ();
            if (this.gpG.newest != null) {
                if (TextUtils.isEmpty(this.gpG.newest.change_log)) {
                    this.gpC.setText("");
                } else {
                    this.gpC.setText(this.gpG.newest.change_log);
                }
                if (this.gpG.newest.size <= 0) {
                    this.gpD.setText("");
                } else {
                    this.gpD.setText(getPageContext().getString(e.j.plugin_size) + String.valueOf(this.gpG.newest.size / 1024) + "KB");
                }
            }
            this.gpE.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.mT().ca(this.gpF) && PluginPackageManager.mT().bY(this.gpF)) {
            this.clx.setText(e.j.plugin_enabled);
            this.gpE.setText(e.j.download_update);
            this.gpE.setEnabled(true);
            al.c(this.gpE, e.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.mT().bY(this.gpF)) {
            this.gpE.setEnabled(true);
            al.c(this.gpE, e.d.cp_cont_g, 1);
            if (PluginPackageManager.mT().bZ(this.gpF)) {
                this.clx.setText(e.j.plugin_unenabled);
                this.gpE.setText(e.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.clx.setText(e.j.plugin_enabled);
                this.gpE.setText(e.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.clx.setText(e.j.plugin_disabled);
            this.gpE.setText(e.j.plugin_enable);
            this.gpE.setEnabled(true);
            al.c(this.gpE, e.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.mT().cc(this.gpF)) {
            al.c(this.gpE, e.d.cp_cont_d, 1);
            this.gpE.setEnabled(false);
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
        if (view == this.gpE) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bnK();
            } else if (this.mStatus == 3) {
                PluginPackageManager.mT().bW(this.gpF);
                bnJ();
            } else if (this.mStatus == 2) {
                PluginPackageManager.mT().bX(this.gpF);
                bnJ();
            }
        }
    }

    private void bnK() {
        if (!j.kK()) {
            showToast(e.j.neterror);
        } else if (j.kM()) {
            bnL();
        } else {
            al.c(this.gpE, e.d.cp_cont_d, 1);
            this.gpE.setEnabled(false);
            PluginPackageManager.mT().a(this.gpG, this.KF);
        }
    }

    private void bnL() {
        String string;
        String string2;
        if (this.gpG != null && this.gpG.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.gpG.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(e.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(e.j.download_update);
            } else {
                string = getResources().getString(e.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(e.j.download);
            }
            aVar.dT(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    al.c(PluginDetailActivity.this.gpE, e.d.cp_cont_d, 1);
                    PluginDetailActivity.this.gpE.setEnabled(false);
                    PluginPackageManager.mT().a(PluginDetailActivity.this.gpG, PluginDetailActivity.this.KF);
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.yl();
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
        PluginPackageManager.mT().a((d) null);
    }
}
