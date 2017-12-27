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
    private TextView cyT;
    private HeadImageView gAt;
    private TextView gFt;
    private TextView gFu;
    private TextView gFv;
    private String gFw;
    private PluginNetConfigInfos.PluginConfig gFx;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d arE = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gFx.package_name) && !PluginDetailActivity.this.mFinished) {
                aj.e(PluginDetailActivity.this.gFv, d.C0108d.cp_cont_d, 1);
                PluginDetailActivity.this.gFv.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.gFv.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gFx.package_name)) {
                PluginDetailActivity.this.gFv.setText(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                PluginDetailActivity.this.gFv.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gFx.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bry();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_finished));
                PluginDetailActivity.this.bry();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bry();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.oI()) {
                PluginDetailActivity.this.bry();
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
        this.gAt = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.cyT = (TextView) findViewById(d.g.status);
        this.gFt = (TextView) findViewById(d.g.changelog);
        this.gFu = (TextView) findViewById(d.g.size);
        this.gFv = (TextView) findViewById(d.g.enable);
        this.gFv.setOnClickListener(this);
        this.gFw = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.rn().ro() != null) {
            this.gFx = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.rn().ro().getPluginConfig(this.gFw);
        }
        if (PluginPackageManager.qR().bz(this.gFw)) {
            PluginPackageManager.qR().a(this.arE);
            aj.e(this.gFv, d.C0108d.cp_cont_d, 1);
            this.gFv.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gFx != null) {
            this.gAt.startLoad(this.gFx.icon, 10, false);
            if (this.gFx.display_name == null) {
                this.gFx.display_name = "";
            }
            this.mName.setText(this.gFx.display_name);
            bry();
            if (this.gFx.newest != null) {
                if (TextUtils.isEmpty(this.gFx.newest.change_log)) {
                    this.gFt.setText("");
                } else {
                    this.gFt.setText(this.gFx.newest.change_log);
                }
                if (this.gFx.newest.size <= 0) {
                    this.gFu.setText("");
                } else {
                    this.gFu.setText(getPageContext().getString(d.j.plugin_size) + String.valueOf(this.gFx.newest.size / 1024) + "KB");
                }
            }
            this.gFv.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bry() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.qR().bx(this.gFw) && PluginPackageManager.qR().bv(this.gFw)) {
            this.cyT.setText(d.j.plugin_enabled);
            this.gFv.setText(d.j.download_update);
            this.gFv.setEnabled(true);
            aj.e(this.gFv, d.C0108d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.qR().bv(this.gFw)) {
            this.gFv.setEnabled(true);
            aj.e(this.gFv, d.C0108d.cp_cont_g, 1);
            if (PluginPackageManager.qR().bw(this.gFw)) {
                this.cyT.setText(d.j.plugin_unenabled);
                this.gFv.setText(d.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.cyT.setText(d.j.plugin_enabled);
                this.gFv.setText(d.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.cyT.setText(d.j.plugin_disabled);
            this.gFv.setText(d.j.plugin_enable);
            this.gFv.setEnabled(true);
            aj.e(this.gFv, d.C0108d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.qR().bz(this.gFw)) {
            aj.e(this.gFv, d.C0108d.cp_cont_d, 1);
            this.gFv.setEnabled(false);
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
        if (view == this.gFv) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                brz();
            } else if (this.mStatus == 3) {
                PluginPackageManager.qR().bt(this.gFw);
                bry();
            } else if (this.mStatus == 2) {
                PluginPackageManager.qR().bu(this.gFw);
                bry();
            }
        }
    }

    private void brz() {
        if (!j.oI()) {
            showToast(d.j.neterror);
        } else if (j.oK()) {
            brA();
        } else {
            aj.e(this.gFv, d.C0108d.cp_cont_d, 1);
            this.gFv.setEnabled(false);
            PluginPackageManager.qR().a(this.gFx, this.arE);
        }
    }

    private void brA() {
        String string;
        String string2;
        if (this.gFx != null && this.gFx.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.gFx.newest.size / 1048576.0f;
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
                    aj.e(PluginDetailActivity.this.gFv, d.C0108d.cp_cont_d, 1);
                    PluginDetailActivity.this.gFv.setEnabled(false);
                    PluginPackageManager.qR().a(PluginDetailActivity.this.gFx, PluginDetailActivity.this.arE);
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
            aVar.AI();
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
