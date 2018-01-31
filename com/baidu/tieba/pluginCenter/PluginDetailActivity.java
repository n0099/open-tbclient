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
    private TextView czo;
    private HeadImageView guW;
    private TextView guX;
    private TextView guY;
    private TextView guZ;
    private String gva;
    private PluginNetConfigInfos.PluginConfig gvb;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d arG = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gvb.package_name) && !PluginDetailActivity.this.mFinished) {
                aj.e(PluginDetailActivity.this.guZ, d.C0108d.cp_cont_d, 1);
                PluginDetailActivity.this.guZ.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.guZ.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gvb.package_name)) {
                PluginDetailActivity.this.guZ.setText(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                PluginDetailActivity.this.guZ.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gvb.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bkS();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_finished));
                PluginDetailActivity.this.bkS();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bkS();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.oJ()) {
                PluginDetailActivity.this.bkS();
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
        this.guW = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.czo = (TextView) findViewById(d.g.status);
        this.guX = (TextView) findViewById(d.g.changelog);
        this.guY = (TextView) findViewById(d.g.size);
        this.guZ = (TextView) findViewById(d.g.enable);
        this.guZ.setOnClickListener(this);
        this.gva = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ro().rp() != null) {
            this.gvb = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ro().rp().getPluginConfig(this.gva);
        }
        if (PluginPackageManager.qS().bz(this.gva)) {
            PluginPackageManager.qS().a(this.arG);
            aj.e(this.guZ, d.C0108d.cp_cont_d, 1);
            this.guZ.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gvb != null) {
            this.guW.startLoad(this.gvb.icon, 10, false);
            if (this.gvb.display_name == null) {
                this.gvb.display_name = "";
            }
            this.mName.setText(this.gvb.display_name);
            bkS();
            if (this.gvb.newest != null) {
                if (TextUtils.isEmpty(this.gvb.newest.change_log)) {
                    this.guX.setText("");
                } else {
                    this.guX.setText(this.gvb.newest.change_log);
                }
                if (this.gvb.newest.size <= 0) {
                    this.guY.setText("");
                } else {
                    this.guY.setText(getPageContext().getString(d.j.plugin_size) + String.valueOf(this.gvb.newest.size / 1024) + "KB");
                }
            }
            this.guZ.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.qS().bx(this.gva) && PluginPackageManager.qS().bv(this.gva)) {
            this.czo.setText(d.j.plugin_enabled);
            this.guZ.setText(d.j.download_update);
            this.guZ.setEnabled(true);
            aj.e(this.guZ, d.C0108d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.qS().bv(this.gva)) {
            this.guZ.setEnabled(true);
            aj.e(this.guZ, d.C0108d.cp_cont_g, 1);
            if (PluginPackageManager.qS().bw(this.gva)) {
                this.czo.setText(d.j.plugin_unenabled);
                this.guZ.setText(d.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.czo.setText(d.j.plugin_enabled);
                this.guZ.setText(d.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.czo.setText(d.j.plugin_disabled);
            this.guZ.setText(d.j.plugin_enable);
            this.guZ.setEnabled(true);
            aj.e(this.guZ, d.C0108d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.qS().bz(this.gva)) {
            aj.e(this.guZ, d.C0108d.cp_cont_d, 1);
            this.guZ.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().aN(i == 1);
        getLayoutMode().aM(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.guZ) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bkT();
            } else if (this.mStatus == 3) {
                PluginPackageManager.qS().bt(this.gva);
                bkS();
            } else if (this.mStatus == 2) {
                PluginPackageManager.qS().bu(this.gva);
                bkS();
            }
        }
    }

    private void bkT() {
        if (!j.oJ()) {
            showToast(d.j.neterror);
        } else if (j.oL()) {
            bkU();
        } else {
            aj.e(this.guZ, d.C0108d.cp_cont_d, 1);
            this.guZ.setEnabled(false);
            PluginPackageManager.qS().a(this.gvb, this.arG);
        }
    }

    private void bkU() {
        String string;
        String string2;
        if (this.gvb != null && this.gvb.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.gvb.newest.size / 1048576.0f;
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
                    aj.e(PluginDetailActivity.this.guZ, d.C0108d.cp_cont_d, 1);
                    PluginDetailActivity.this.guZ.setEnabled(false);
                    PluginPackageManager.qS().a(PluginDetailActivity.this.gvb, PluginDetailActivity.this.arG);
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
            aVar.AB();
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
        PluginPackageManager.qS().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
