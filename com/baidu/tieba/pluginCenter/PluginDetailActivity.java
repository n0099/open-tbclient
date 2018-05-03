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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView bTa;
    private HeadImageView fRq;
    private TextView fRr;
    private TextView fRs;
    private TextView fRt;
    private PluginNetConfigInfos.PluginConfig fRu;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private d Cc = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fRu.package_name) && !PluginDetailActivity.this.mFinished) {
                ak.c(PluginDetailActivity.this.fRt, d.C0126d.cp_cont_d, 1);
                PluginDetailActivity.this.fRt.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.k.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.fRt.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fRu.package_name)) {
                PluginDetailActivity.this.fRt.setText(PluginDetailActivity.this.getPageContext().getString(d.k.plugin_download_finished));
                PluginDetailActivity.this.fRt.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fRu.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bhl();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.k.plugin_installation_finished));
                PluginDetailActivity.this.bhl();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.k.plugin_installation_failed) + str);
            PluginDetailActivity.this.bhl();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.gP()) {
                PluginDetailActivity.this.bhl();
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
            public void onClick(View view2) {
                PluginDetailActivity.this.closeActivity();
            }
        });
        this.fRq = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.bTa = (TextView) findViewById(d.g.status);
        this.fRr = (TextView) findViewById(d.g.changelog);
        this.fRs = (TextView) findViewById(d.g.size);
        this.fRt = (TextView) findViewById(d.g.enable);
        this.fRt.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jt().ju() != null) {
            this.fRu = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jt().ju().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.iX().bw(this.mPluginName)) {
            PluginPackageManager.iX().a(this.Cc);
            ak.c(this.fRt, d.C0126d.cp_cont_d, 1);
            this.fRt.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fRu != null) {
            this.fRq.startLoad(this.fRu.icon, 10, false);
            if (this.fRu.display_name == null) {
                this.fRu.display_name = "";
            }
            this.mName.setText(this.fRu.display_name);
            bhl();
            if (this.fRu.newest != null) {
                if (TextUtils.isEmpty(this.fRu.newest.change_log)) {
                    this.fRr.setText("");
                } else {
                    this.fRr.setText(this.fRu.newest.change_log);
                }
                if (this.fRu.newest.size <= 0) {
                    this.fRs.setText("");
                } else {
                    this.fRs.setText(getPageContext().getString(d.k.plugin_size) + String.valueOf(this.fRu.newest.size / 1024) + "KB");
                }
            }
            this.fRt.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhl() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.iX().bu(this.mPluginName) && PluginPackageManager.iX().bs(this.mPluginName)) {
            this.bTa.setText(d.k.plugin_enabled);
            this.fRt.setText(d.k.download_update);
            this.fRt.setEnabled(true);
            ak.c(this.fRt, d.C0126d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.iX().bs(this.mPluginName)) {
            this.fRt.setEnabled(true);
            ak.c(this.fRt, d.C0126d.cp_cont_g, 1);
            if (PluginPackageManager.iX().bt(this.mPluginName)) {
                this.bTa.setText(d.k.plugin_unenabled);
                this.fRt.setText(d.k.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bTa.setText(d.k.plugin_enabled);
                this.fRt.setText(d.k.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bTa.setText(d.k.plugin_disabled);
            this.fRt.setText(d.k.plugin_enable);
            this.fRt.setEnabled(true);
            ak.c(this.fRt, d.C0126d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.iX().bw(this.mPluginName)) {
            ak.c(this.fRt, d.C0126d.cp_cont_d, 1);
            this.fRt.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.fRt) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bhm();
            } else if (this.mStatus == 3) {
                PluginPackageManager.iX().bq(this.mPluginName);
                bhl();
            } else if (this.mStatus == 2) {
                PluginPackageManager.iX().br(this.mPluginName);
                bhl();
            }
        }
    }

    private void bhm() {
        if (!j.gP()) {
            showToast(d.k.neterror);
        } else if (j.gR()) {
            bhn();
        } else {
            ak.c(this.fRt, d.C0126d.cp_cont_d, 1);
            this.fRt.setEnabled(false);
            PluginPackageManager.iX().a(this.fRu, this.Cc);
        }
    }

    private void bhn() {
        String string;
        String string2;
        if (this.fRu != null && this.fRu.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.fRu.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.k.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.k.download_update);
            } else {
                string = getResources().getString(d.k.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.k.download);
            }
            aVar.dc(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ak.c(PluginDetailActivity.this.fRt, d.C0126d.cp_cont_d, 1);
                    PluginDetailActivity.this.fRt.setEnabled(false);
                    PluginPackageManager.iX().a(PluginDetailActivity.this.fRu, PluginDetailActivity.this.Cc);
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
            aVar.tD();
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
        PluginPackageManager.iX().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
