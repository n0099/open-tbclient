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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView czd;
    private HeadImageView guB;
    private TextView guC;
    private TextView guD;
    private TextView guE;
    private String guF;
    private PluginNetConfigInfos.PluginConfig guG;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d arD = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.guG.package_name) && !PluginDetailActivity.this.mFinished) {
                aj.e(PluginDetailActivity.this.guE, d.C0107d.cp_cont_d, 1);
                PluginDetailActivity.this.guE.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.guE.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.guG.package_name)) {
                PluginDetailActivity.this.guE.setText(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                PluginDetailActivity.this.guE.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.guG.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bkR();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_finished));
                PluginDetailActivity.this.bkR();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bkR();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.oI()) {
                PluginDetailActivity.this.bkR();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.setTitleText(d.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PluginDetailActivity.this.closeActivity();
            }
        });
        this.guB = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.czd = (TextView) findViewById(d.g.status);
        this.guC = (TextView) findViewById(d.g.changelog);
        this.guD = (TextView) findViewById(d.g.size);
        this.guE = (TextView) findViewById(d.g.enable);
        this.guE.setOnClickListener(this);
        this.guF = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.rn().ro() != null) {
            this.guG = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.rn().ro().getPluginConfig(this.guF);
        }
        if (PluginPackageManager.qR().bz(this.guF)) {
            PluginPackageManager.qR().a(this.arD);
            aj.e(this.guE, d.C0107d.cp_cont_d, 1);
            this.guE.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.guG != null) {
            this.guB.startLoad(this.guG.icon, 10, false);
            if (this.guG.display_name == null) {
                this.guG.display_name = "";
            }
            this.mName.setText(this.guG.display_name);
            bkR();
            if (this.guG.newest != null) {
                if (TextUtils.isEmpty(this.guG.newest.change_log)) {
                    this.guC.setText("");
                } else {
                    this.guC.setText(this.guG.newest.change_log);
                }
                if (this.guG.newest.size <= 0) {
                    this.guD.setText("");
                } else {
                    this.guD.setText(getPageContext().getString(d.j.plugin_size) + String.valueOf(this.guG.newest.size / 1024) + "KB");
                }
            }
            this.guE.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkR() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.qR().bx(this.guF) && PluginPackageManager.qR().bv(this.guF)) {
            this.czd.setText(d.j.plugin_enabled);
            this.guE.setText(d.j.download_update);
            this.guE.setEnabled(true);
            aj.e(this.guE, d.C0107d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.qR().bv(this.guF)) {
            this.guE.setEnabled(true);
            aj.e(this.guE, d.C0107d.cp_cont_g, 1);
            if (PluginPackageManager.qR().bw(this.guF)) {
                this.czd.setText(d.j.plugin_unenabled);
                this.guE.setText(d.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.czd.setText(d.j.plugin_enabled);
                this.guE.setText(d.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.czd.setText(d.j.plugin_disabled);
            this.guE.setText(d.j.plugin_enable);
            this.guE.setEnabled(true);
            aj.e(this.guE, d.C0107d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.qR().bz(this.guF)) {
            aj.e(this.guE, d.C0107d.cp_cont_d, 1);
            this.guE.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().aM(i == 1);
        getLayoutMode().aM(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.guE) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bkS();
            } else if (this.mStatus == 3) {
                PluginPackageManager.qR().bt(this.guF);
                bkR();
            } else if (this.mStatus == 2) {
                PluginPackageManager.qR().bu(this.guF);
                bkR();
            }
        }
    }

    private void bkS() {
        if (!j.oI()) {
            showToast(d.j.neterror);
        } else if (j.oK()) {
            bkT();
        } else {
            aj.e(this.guE, d.C0107d.cp_cont_d, 1);
            this.guE.setEnabled(false);
            PluginPackageManager.qR().a(this.guG, this.arD);
        }
    }

    private void bkT() {
        String string;
        String string2;
        if (this.guG != null && this.guG.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.guG.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.j.download_update);
            } else {
                string = getResources().getString(d.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.j.download);
            }
            aVar.cZ(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aj.e(PluginDetailActivity.this.guE, d.C0107d.cp_cont_d, 1);
                    PluginDetailActivity.this.guE.setEnabled(false);
                    PluginPackageManager.qR().a(PluginDetailActivity.this.guG, PluginDetailActivity.this.arD);
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
            aVar.AA();
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
        PluginPackageManager.qR().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
