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
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView cbS;
    private HeadImageView gdI;
    private TextView gdJ;
    private TextView gdK;
    private TextView gdL;
    private String gdM;
    private PluginNetConfigInfos.PluginConfig gdN;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Ik = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gdN.package_name) && !PluginDetailActivity.this.mFinished) {
                al.c(PluginDetailActivity.this.gdL, d.C0141d.cp_cont_d, 1);
                PluginDetailActivity.this.gdL.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.k.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.gdL.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gdN.package_name)) {
                PluginDetailActivity.this.gdL.setText(PluginDetailActivity.this.getPageContext().getString(d.k.plugin_download_finished));
                PluginDetailActivity.this.gdL.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gdN.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bmj();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.k.plugin_installation_finished));
                PluginDetailActivity.this.bmj();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.k.plugin_installation_failed) + str);
            PluginDetailActivity.this.bmj();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jD()) {
                PluginDetailActivity.this.bmj();
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
        this.gdI = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.cbS = (TextView) findViewById(d.g.status);
        this.gdJ = (TextView) findViewById(d.g.changelog);
        this.gdK = (TextView) findViewById(d.g.size);
        this.gdL = (TextView) findViewById(d.g.enable);
        this.gdL.setOnClickListener(this);
        this.gdM = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mh().mi() != null) {
            this.gdN = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mh().mi().getPluginConfig(this.gdM);
        }
        if (PluginPackageManager.lL().bI(this.gdM)) {
            PluginPackageManager.lL().a(this.Ik);
            al.c(this.gdL, d.C0141d.cp_cont_d, 1);
            this.gdL.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gdN != null) {
            this.gdI.startLoad(this.gdN.icon, 10, false);
            if (this.gdN.display_name == null) {
                this.gdN.display_name = "";
            }
            this.mName.setText(this.gdN.display_name);
            bmj();
            if (this.gdN.newest != null) {
                if (TextUtils.isEmpty(this.gdN.newest.change_log)) {
                    this.gdJ.setText("");
                } else {
                    this.gdJ.setText(this.gdN.newest.change_log);
                }
                if (this.gdN.newest.size <= 0) {
                    this.gdK.setText("");
                } else {
                    this.gdK.setText(getPageContext().getString(d.k.plugin_size) + String.valueOf(this.gdN.newest.size / 1024) + "KB");
                }
            }
            this.gdL.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmj() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.lL().bG(this.gdM) && PluginPackageManager.lL().bE(this.gdM)) {
            this.cbS.setText(d.k.plugin_enabled);
            this.gdL.setText(d.k.download_update);
            this.gdL.setEnabled(true);
            al.c(this.gdL, d.C0141d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.lL().bE(this.gdM)) {
            this.gdL.setEnabled(true);
            al.c(this.gdL, d.C0141d.cp_cont_g, 1);
            if (PluginPackageManager.lL().bF(this.gdM)) {
                this.cbS.setText(d.k.plugin_unenabled);
                this.gdL.setText(d.k.plugin_enable);
                this.mStatus = 2;
            } else {
                this.cbS.setText(d.k.plugin_enabled);
                this.gdL.setText(d.k.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.cbS.setText(d.k.plugin_disabled);
            this.gdL.setText(d.k.plugin_enable);
            this.gdL.setEnabled(true);
            al.c(this.gdL, d.C0141d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.lL().bI(this.gdM)) {
            al.c(this.gdL, d.C0141d.cp_cont_d, 1);
            this.gdL.setEnabled(false);
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
        if (view == this.gdL) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bmk();
            } else if (this.mStatus == 3) {
                PluginPackageManager.lL().bC(this.gdM);
                bmj();
            } else if (this.mStatus == 2) {
                PluginPackageManager.lL().bD(this.gdM);
                bmj();
            }
        }
    }

    private void bmk() {
        if (!j.jD()) {
            showToast(d.k.neterror);
        } else if (j.jF()) {
            bml();
        } else {
            al.c(this.gdL, d.C0141d.cp_cont_d, 1);
            this.gdL.setEnabled(false);
            PluginPackageManager.lL().a(this.gdN, this.Ik);
        }
    }

    private void bml() {
        String string;
        String string2;
        if (this.gdN != null && this.gdN.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.gdN.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.k.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.k.download_update);
            } else {
                string = getResources().getString(d.k.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.k.download);
            }
            aVar.dB(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    al.c(PluginDetailActivity.this.gdL, d.C0141d.cp_cont_d, 1);
                    PluginDetailActivity.this.gdL.setEnabled(false);
                    PluginPackageManager.lL().a(PluginDetailActivity.this.gdN, PluginDetailActivity.this.Ik);
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
            aVar.xa();
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
