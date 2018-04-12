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
    private TextView bTe;
    private HeadImageView fRt;
    private TextView fRu;
    private TextView fRv;
    private TextView fRw;
    private PluginNetConfigInfos.PluginConfig fRx;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private d Cc = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fRx.package_name) && !PluginDetailActivity.this.mFinished) {
                ak.c(PluginDetailActivity.this.fRw, d.C0126d.cp_cont_d, 1);
                PluginDetailActivity.this.fRw.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.k.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.fRw.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fRx.package_name)) {
                PluginDetailActivity.this.fRw.setText(PluginDetailActivity.this.getPageContext().getString(d.k.plugin_download_finished));
                PluginDetailActivity.this.fRw.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fRx.package_name)) {
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
        this.fRt = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.bTe = (TextView) findViewById(d.g.status);
        this.fRu = (TextView) findViewById(d.g.changelog);
        this.fRv = (TextView) findViewById(d.g.size);
        this.fRw = (TextView) findViewById(d.g.enable);
        this.fRw.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jt().ju() != null) {
            this.fRx = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jt().ju().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.iX().bw(this.mPluginName)) {
            PluginPackageManager.iX().a(this.Cc);
            ak.c(this.fRw, d.C0126d.cp_cont_d, 1);
            this.fRw.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fRx != null) {
            this.fRt.startLoad(this.fRx.icon, 10, false);
            if (this.fRx.display_name == null) {
                this.fRx.display_name = "";
            }
            this.mName.setText(this.fRx.display_name);
            bhl();
            if (this.fRx.newest != null) {
                if (TextUtils.isEmpty(this.fRx.newest.change_log)) {
                    this.fRu.setText("");
                } else {
                    this.fRu.setText(this.fRx.newest.change_log);
                }
                if (this.fRx.newest.size <= 0) {
                    this.fRv.setText("");
                } else {
                    this.fRv.setText(getPageContext().getString(d.k.plugin_size) + String.valueOf(this.fRx.newest.size / 1024) + "KB");
                }
            }
            this.fRw.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhl() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.iX().bu(this.mPluginName) && PluginPackageManager.iX().bs(this.mPluginName)) {
            this.bTe.setText(d.k.plugin_enabled);
            this.fRw.setText(d.k.download_update);
            this.fRw.setEnabled(true);
            ak.c(this.fRw, d.C0126d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.iX().bs(this.mPluginName)) {
            this.fRw.setEnabled(true);
            ak.c(this.fRw, d.C0126d.cp_cont_g, 1);
            if (PluginPackageManager.iX().bt(this.mPluginName)) {
                this.bTe.setText(d.k.plugin_unenabled);
                this.fRw.setText(d.k.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bTe.setText(d.k.plugin_enabled);
                this.fRw.setText(d.k.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bTe.setText(d.k.plugin_disabled);
            this.fRw.setText(d.k.plugin_enable);
            this.fRw.setEnabled(true);
            ak.c(this.fRw, d.C0126d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.iX().bw(this.mPluginName)) {
            ak.c(this.fRw, d.C0126d.cp_cont_d, 1);
            this.fRw.setEnabled(false);
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
        if (view2 == this.fRw) {
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
            ak.c(this.fRw, d.C0126d.cp_cont_d, 1);
            this.fRw.setEnabled(false);
            PluginPackageManager.iX().a(this.fRx, this.Cc);
        }
    }

    private void bhn() {
        String string;
        String string2;
        if (this.fRx != null && this.fRx.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.fRx.newest.size / 1048576.0f;
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
                    ak.c(PluginDetailActivity.this.fRw, d.C0126d.cp_cont_d, 1);
                    PluginDetailActivity.this.fRw.setEnabled(false);
                    PluginPackageManager.iX().a(PluginDetailActivity.this.fRx, PluginDetailActivity.this.Cc);
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
