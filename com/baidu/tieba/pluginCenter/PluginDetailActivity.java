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
import com.baidu.adp.lib.util.i;
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
    private TextView buD;
    private boolean dhf;
    private TextView fBl;
    private TextView fBm;
    private TextView fBn;
    private PluginNetConfigInfos.PluginConfig fBo;
    private HeadImageView fxX;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private d DM = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fBo.package_name) && !PluginDetailActivity.this.dhf) {
                aj.c(PluginDetailActivity.this.fBn, d.e.cp_cont_d, 1);
                PluginDetailActivity.this.fBn.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.l.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.fBn.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fBo.package_name)) {
                PluginDetailActivity.this.fBn.setText(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                PluginDetailActivity.this.fBn.setEnabled(false);
                PluginDetailActivity.this.dhf = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fBo.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bfT();
                PluginDetailActivity.this.dhf = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_installation_finished));
                PluginDetailActivity.this.bfT();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_installation_failed) + str);
            PluginDetailActivity.this.bfT();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && i.hi()) {
                PluginDetailActivity.this.bfT();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.navigation_bar);
        this.mNavigationBar.setTitleText(d.l.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PluginDetailActivity.this.closeActivity();
            }
        });
        this.fxX = (HeadImageView) findViewById(d.h.icon);
        this.mName = (TextView) findViewById(d.h.name);
        this.buD = (TextView) findViewById(d.h.status);
        this.fBl = (TextView) findViewById(d.h.changelog);
        this.fBm = (TextView) findViewById(d.h.size);
        this.fBn = (TextView) findViewById(d.h.enable);
        this.fBn.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT() != null) {
            this.fBo = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.jw().br(this.mPluginName)) {
            PluginPackageManager.jw().a(this.DM);
            aj.c(this.fBn, d.e.cp_cont_d, 1);
            this.fBn.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fBo != null) {
            this.fxX.c(this.fBo.icon, 10, false);
            if (this.fBo.display_name == null) {
                this.fBo.display_name = "";
            }
            this.mName.setText(this.fBo.display_name);
            bfT();
            if (this.fBo.newest != null) {
                if (TextUtils.isEmpty(this.fBo.newest.change_log)) {
                    this.fBl.setText("");
                } else {
                    this.fBl.setText(this.fBo.newest.change_log);
                }
                if (this.fBo.newest.size <= 0) {
                    this.fBm.setText("");
                } else {
                    this.fBm.setText(getPageContext().getString(d.l.plugin_size) + String.valueOf(this.fBo.newest.size / 1024) + "KB");
                }
            }
            this.fBn.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfT() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.jw().bp(this.mPluginName) && PluginPackageManager.jw().bn(this.mPluginName)) {
            this.buD.setText(d.l.plugin_enabled);
            this.fBn.setText(d.l.download_update);
            this.fBn.setEnabled(true);
            aj.c(this.fBn, d.e.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.jw().bn(this.mPluginName)) {
            this.fBn.setEnabled(true);
            aj.c(this.fBn, d.e.cp_cont_g, 1);
            if (PluginPackageManager.jw().bo(this.mPluginName)) {
                this.buD.setText(d.l.plugin_unenabled);
                this.fBn.setText(d.l.plugin_enable);
                this.mStatus = 2;
            } else {
                this.buD.setText(d.l.plugin_enabled);
                this.fBn.setText(d.l.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.buD.setText(d.l.plugin_disabled);
            this.fBn.setText(d.l.plugin_enable);
            this.fBn.setEnabled(true);
            aj.c(this.fBn, d.e.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.jw().br(this.mPluginName)) {
            aj.c(this.fBn, d.e.cp_cont_d, 1);
            this.fBn.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fBn) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bfU();
            } else if (this.mStatus == 3) {
                PluginPackageManager.jw().bl(this.mPluginName);
                bfT();
            } else if (this.mStatus == 2) {
                PluginPackageManager.jw().bm(this.mPluginName);
                bfT();
            }
        }
    }

    private void bfU() {
        if (!i.hi()) {
            showToast(d.l.neterror);
        } else if (i.hk()) {
            bfV();
        } else {
            aj.c(this.fBn, d.e.cp_cont_d, 1);
            this.fBn.setEnabled(false);
            PluginPackageManager.jw().a(this.fBo, this.DM);
        }
    }

    private void bfV() {
        String string;
        String string2;
        if (this.fBo != null && this.fBo.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.fBo.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.l.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.l.download_update);
            } else {
                string = getResources().getString(d.l.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.l.download);
            }
            aVar.cM(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aj.c(PluginDetailActivity.this.fBn, d.e.cp_cont_d, 1);
                    PluginDetailActivity.this.fBn.setEnabled(false);
                    PluginPackageManager.jw().a(PluginDetailActivity.this.fBo, PluginDetailActivity.this.DM);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.to();
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
        PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
